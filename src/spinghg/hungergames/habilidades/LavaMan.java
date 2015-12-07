package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class LavaMan
 implements Listener, CommandExecutor
{
	  private libsHg plugin;
	  
	  public LavaMan(libsHg plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  private HashMap<String, Location> register = new HashMap();
	  ArrayList<Block> naoescorrer = new ArrayList();
	  
	  @EventHandler
	  public void onDamageHunter(EntityDamageByEntityEvent e)
	  {
		  if (this.plugin.comecou)
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Entity ent = e.getEntity();
	      Player player = (Player)e.getEntity();
	      Player damager = (Player)e.getDamager();
	      Player p = (Player)ent;
	      if ((this.plugin.km.temKit(player)) && (this.plugin.km.getPlayerKit(player, this.plugin.km.getKitByName("Jellyfish"))) && 
	        (damager.getItemInHand() != null) && 
	        (damager.getItemInHand().getType() != null)) {
	      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
	    	  {
	    		  BossBar.setMessage(damager, p.getName() + " - LavaMan (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
	    	  }
	    	  else
	    	  {
	        BossBar.setMessage(damager, p.getName() + " - LavaMan", 1);
	      }
	    }
	  }
	  }
  @EventHandler
  public void colocaragua(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (this.plugin.kit) 
    if ((p.getItemInHand().getType() == Material.CLAY_BALL) && 
      (event.getAction() == Action.RIGHT_CLICK_BLOCK) && (this.plugin.km.temKit(p)) && (this.plugin.km.getPlayerKit(p, this.plugin.km.getKitByName("LavaMan"))))
    {
      Block b = event.getClickedBlock();
      
      BlockFace lado = event.getBlockFace();
      int x = b.getLocation().getBlockX();
      int y = b.getLocation().getBlockY();
      int z = b.getLocation().getBlockZ();
      if (lado == BlockFace.DOWN)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
      else if (lado == BlockFace.UP)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
      else if (lado == BlockFace.NORTH)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
      else if (lado == BlockFace.SOUTH)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
      else if (lado == BlockFace.WEST)
      {
        final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
      else if (lado == BlockFace.EAST)
      {
        final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
        b2.setType(Material.STATIONARY_LAVA);
        this.naoescorrer.add(b2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            b2.setType(Material.AIR);
            LavaMan.this.naoescorrer.remove(b2);
          }
        }, 60L);
      }
    }
  }
  
  @EventHandler
  public void naoescorrer(BlockPhysicsEvent event)
  {
    Block b = event.getBlock();
    if ((b.getType() == Material.STATIONARY_LAVA) && (this.naoescorrer.contains(b))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void veneno(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    Block b = p.getLocation().getBlock();
    if (this.plugin.kit) 
    if ((b.getType() == Material.STATIONARY_LAVA) && (this.plugin.km.temKit(p))  && (this.naoescorrer.contains(b)))
      p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 50, 0));
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Lavaman")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit LavaMan");
	    }

	    return false;
	  }
}