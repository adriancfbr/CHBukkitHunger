package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.listeners.MineCombatLog;
import spinghg.hungergames.libsHg;

public class Vacuum
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Vacuum(libsHg plugin)
  {
    this.pl = plugin;
  }
  public static List<Player> Vacuum = new ArrayList<Player>();
  
  
  @EventHandler
  public void onDamageDeathGod(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Vacuum"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Vacuum", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onDrop3(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Vacuum"))) && (e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDeathGod(PlayerInteractEvent event)
  {
	     final Player p = event.getPlayer();
	     if (this.pl.kit) 
    if ((this.pl.comecou) || (this.pl.invencibilidade))
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Vacuum")))) {
    	if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
    		event.setCancelled(true);
    		p.updateInventory();
    		if (!Vacuum.this.Vacuum.contains(p)) {
      for (Entity nearby : p.getNearbyEntities(15.0D, 9.0D, 15.0D))
      {
        Entity targetplayer = nearby;
        if ((!(targetplayer instanceof Player)) && (!(targetplayer instanceof Item)) && (!(targetplayer instanceof Block)) && (!(targetplayer instanceof Entity)) && (this.pl.admins.contains(nearby))) {
          return;
        }
        Location lc = targetplayer.getLocation();
        Location to = p.getLocation();
        
        lc.setY(lc.getY() + 0.9D);
        double g = -0.1D;
        double d = to.distance(lc);
        double t = d;
        double v_x = (2.2D + 0.07000000000000001D * t) * (to.getX() - lc.getX()) / t;
        double v_y = (1.0D + 0.07000000000000001D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
        double v_z = (2.2D + 0.07000000000000001D * t) * (to.getZ() - lc.getZ()) / t;
        Vector v = p.getVelocity();
        v.setX(v_x);
        v.setY(v_y);
        v.setZ(v_z);
        targetplayer.setVelocity(v);
        this.Vacuum.add(p);
      }
    }
    		else
    		{
    			p.sendMessage("§c§oEspere antes de usar o vacuum");
    		}
    	}
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
        	  if (Vacuum.this.Vacuum.contains(p)) {
            Vacuum.this.Vacuum.remove(p);
            p.sendMessage("§6Você já pode usar o vacuum.");
            }
            
          }
        }, 100L);
  }
 }

  

  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Vacuum")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Vacuum");
	    }

	    return false;
	  }
}
