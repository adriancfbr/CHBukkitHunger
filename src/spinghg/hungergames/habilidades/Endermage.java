package spinghg.hungergames.habilidades;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Endermage
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Endermage(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  String teleport = ChatColor.translateAlternateColorCodes('&', "&c§oPuxado!\nVocê esta invencivel por 5 segundos!");
  
  @EventHandler
  public void onDamageEndermage(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Endermage"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Endermage (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Endermage", 1);
      }
    }
    }
  }
  
  public void TeleportP(Location portal, Player p1, Player p2)
  {
	  if (!this.pl.PvPGladiator.contains(p2)) {
    p1.teleport(portal.clone().add(0.5D, 1.0D, 0.5D));
    p2.teleport(portal.clone().add(0.5D, 1.0D, 0.5D));
    p1.setNoDamageTicks(100);
    p2.setNoDamageTicks(100);
    p1.sendMessage(this.teleport);
    p2.sendMessage(this.teleport);
    p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 10);
    p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 10);
    p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
    p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
    p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 10);
    p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 10);
    p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
    p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0F, 1.2F);
  }
	  else
	  {
		  p1.sendMessage("§cGladiator esta formado aguarde!");
	  }
  }
  
  private boolean isEnderable(Location portal, Location player)
  {
    return (Math.abs(portal.getX() - player.getX()) < 3.0D) && (Math.abs(portal.getZ() - player.getZ()) < 3.0D) && (
      Math.abs(portal.getY() - player.getY()) >= 3.5D);
  }
  
  @EventHandler
  public void onDrop3(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Endermage"))) && (e.getItemDrop().getItemStack().getType() == Material.PORTAL)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void EndermageInteract(PlayerInteractEvent e)
  {
    final Player mage = e.getPlayer();
    if (this.pl.kit) 
    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("Endermage"))) && 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.PORTAL)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
      (mage.getItemInHand().getType() == Material.PORTAL)))
    {
      e.setCancelled(true);
      mage.updateInventory();
      mage.setItemInHand(new ItemStack(Material.AIR));
      mage.updateInventory();
      final Block b = e.getClickedBlock();
      
      final Location bLoc = b.getLocation();
      final BlockState bs = b.getState();
      
      b.setType(Material.ENDER_PORTAL_FRAME);
      for (Player nearby : Bukkit.getOnlinePlayers())
      {
        final Player target = nearby.getPlayer();
        new BukkitRunnable()
        {
          int time = 5;
          
          public void run()
          {
            this.time -= 1;
            if ((!Endermage.this.pl.km.getPlayerKit(target, Endermage.this.pl.km.getKitByName("Endermage"))) && 
              (Endermage.this.isEnderable(bLoc, target.getLocation())) && 
              (target != mage) && 
              (!target.isDead()))
            {
              b.setType(bs.getType());
              b.setData(bs.getBlock().getData());
              cancel();
              b.setType(Material.ENDER_STONE);
              Endermage.this.TeleportP(bLoc, mage, target);
              if (!mage.getInventory().contains(new ItemStack(Material.PORTAL)))
              {
                Iterator<?> localIterator = ((Kit)Endermage.this.pl.km.playerKit.get(mage)).getItem().iterator();
                if (localIterator.hasNext())
                {
                  ItemStack portal = (ItemStack)localIterator.next();
                  mage.getInventory().addItem(new ItemStack[] { portal });
                }
                mage.updateInventory();
              }
            }
            else if (this.time == 0)
            {
              cancel();
              b.setType(bs.getType());
              b.setData(bs.getBlock().getData());
              b.setType(Material.ENDER_STONE);
              if (!mage.getInventory().contains(new ItemStack(Material.PORTAL)))
              {
                Iterator<?> localIterator = ((Kit)Endermage.this.pl.km.playerKit.get(mage)).getItem().iterator();
                if (localIterator.hasNext())
                {
                  ItemStack portal = (ItemStack)localIterator.next();
                  mage.getInventory().addItem(new ItemStack[] { portal });
                }
                mage.updateInventory();
              }
            }
          }
        }.runTaskTimer(this.pl, 0L, 20L);
      }
    }
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
	  if (this.pl.kit) 
    if ((e.getEntity() instanceof Player))
    {
      Player p = e.getEntity();
      if ((!this.pl.km.temKit(p)) && (!this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Endermage")))) {
        return;
      }
      for (ItemStack item : e.getDrops()) {
        if (item.getType() == Material.PORTAL) {
          item.setType(Material.AIR);
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Endermage")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Endermage");
	    }

	    return false;
	  }
}
