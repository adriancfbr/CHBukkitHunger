package spinghg.hungergames.habilidades;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Thermo
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Thermo(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public HashMap<String, Long> cooldown = new HashMap();
  
  @EventHandler
  public void onDamageThermo(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Thermo"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else {
        BossBar.setMessage(damager, p.getName() + " - Thermo", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void the(final BlockPlaceEvent event)
  {
    final Player player = event.getPlayer();
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Thermo"))))
    {
      Block block = event.getBlockPlaced();
      Location playerPos = block.getLocation();
      int radius = 10;
      int radiusY = 10;
      if (this.pl.kit) 
      if (this.cooldown.containsKey(player.getName()))
      {
        long secondsLeft = ((Long)this.cooldown.get(player.getName())).longValue() / 1000L + 5L - System.currentTimeMillis() / 1000L;
        if (secondsLeft > 0L)
        {
          player.sendMessage("§cTem que esperar " + secondsLeft + " segundos para usar o kit!");
          return;
        }
      }
      for (int x = radius * -1; x <= radius; x++) {
        for (int y = radiusY * -1; y <= radius; y++) {
          for (int z = radius * -1; z <= radius; z++)
          {
            final Block b = playerPos.getWorld().getBlockAt(playerPos.getBlockX() + x, playerPos.getBlockY() + y, playerPos.getBlockZ() + z);
            if ((b.getType() == Material.WATER) || ((b.getType() == Material.STATIONARY_WATER) && (block.getType().equals(Material.DAYLIGHT_DETECTOR))))
            {
              b.setType(Material.AIR);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
              {
                public void run()
                {
                  b.setType(Material.STATIONARY_LAVA);
                  Thermo.this.cooldown.put(player.getName(), Long.valueOf(System.currentTimeMillis()));
                  if (event.getBlockPlaced().getType().equals(Material.DAYLIGHT_DETECTOR))
                  {
                    event.getBlockPlaced().setType(Material.AIR);
                    player.getInventory().setItem(1, Thermo.getTablet());
                  }
                  event.setCancelled(true);
                }
              }, 1L);
            }
            if ((b.getType() == Material.LAVA) || ((b.getType() == Material.STATIONARY_LAVA) && (block.getType().equals(Material.DAYLIGHT_DETECTOR))))
            {
              b.setType(Material.AIR);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
              {
                public void run()
                {
                  b.setType(Material.STATIONARY_WATER);
                  event.setCancelled(true);
                  if (event.getBlockPlaced().getType().equals(Material.DAYLIGHT_DETECTOR))
                  {
                    event.getBlockPlaced().setType(Material.AIR);
                    player.getInventory().setItem(1, Thermo.getTablet());
                  }
                  Thermo.this.cooldown.put(player.getName(), Long.valueOf(System.currentTimeMillis()));
                }
              }, 1L);
            }
          }
        }
      }
    }
  }
  
  public static ItemStack getTablet()
  {
    ItemStack sword = new ItemStack(Material.DAYLIGHT_DETECTOR);
    ItemMeta swordmeta = sword.getItemMeta();
    swordmeta.setDisplayName("§cThermo");
    sword.setItemMeta(swordmeta);
    return sword;
  }
  
  @EventHandler
  public void OnPlace(BlockPlaceEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.kit) 
    if ((player.getItemInHand().getType() == Material.DAYLIGHT_DETECTOR) && (this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Thermo")))) {
      e.setCancelled(true);
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Thermo")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Thermo");
	    }

	    return false;
	  }
}
