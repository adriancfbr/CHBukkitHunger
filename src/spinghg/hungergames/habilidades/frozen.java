package spinghg.hungergames.habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class frozen
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public frozen(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageFrosty(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("frozen"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Frozen (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Frozen", 1);
      }
    }
    }
  }  
  
  @EventHandler
  public void onFrozen(final PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    final Player mage = e.getPlayer();
    if ((this.pl.comecou) && (this.pl.invencibilidade) &&
            (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("frozen"))));
    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("frozen"))) && 
    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getAction() == Action.RIGHT_CLICK_AIR) && (e.getAction() == Action.LEFT_CLICK_AIR) && (mage.getItemInHand().getType() == Material.SNOW_BALL)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	      (mage.getItemInHand().getType() == Material.SNOW_BALL))) {
      if ((e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(1.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(0.0D, 1.0D, 1.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(0.0D, 1.0D, -1.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(-1.0D, 1.0D, -1.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(1.0D, 1.0D, 1.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 1.0D).getBlock().getType() == Material.AIR) && 
        (e.getClickedBlock().getLocation().add(1.0D, 1.0D, -1.0D).getBlock().getType() == Material.AIR))
      {
        {
          e.setCancelled(true);
          e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(1.0D, 1.0D, 0.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(0.0D, 1.0D, 1.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 0.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(0.0D, 1.0D, -1.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(-1.0D, 1.0D, -1.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(1.0D, 1.0D, 1.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 1.0D).getBlock().setType(Material.PACKED_ICE);
          e.getClickedBlock().getLocation().add(1.0D, 1.0D, -1.0D).getBlock().setType(Material.PACKED_ICE);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
          {
            public void run()
            {
              e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(1.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(0.0D, 1.0D, 1.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(0.0D, 1.0D, -1.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(-1.0D, 1.0D, -1.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(1.0D, 1.0D, 1.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(-1.0D, 1.0D, 1.0D).getBlock().setType(Material.AIR);
              e.getClickedBlock().getLocation().add(1.0D, 1.0D, -1.0D).getBlock().setType(Material.AIR);
            }
          }, 200L);
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Frozen")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Frozen");
	    }

	    return false;
	  }
  
  @EventHandler
  public void onBlock(PlayerInteractEvent e)
  {
	  Player p = e.getPlayer();
	  	if (p.getItemInHand().getType() == Material.SNOW_BALL) {
    		e.setCancelled(true);
    		p.updateInventory();
    		onFrozen(e);
	  	}
  }
}
      
     
      
    
  
  

