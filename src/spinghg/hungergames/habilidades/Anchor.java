package spinghg.hungergames.habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Anchor
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Anchor(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageAnchor(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Anchor"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Anchor (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Anchor", 1);
    	  }
      }
    }
  }
  
  @EventHandler
  public void damage(EntityDamageByEntityEvent e)
  {
	if (this.pl.kit) 
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if (this.pl.comecou) {
      if ((this.pl.km.temKit(d)) && (this.pl.km.getPlayerKit(d, this.pl.km.getKitByName("Anchor"))))
      {
        p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        p.setVelocity(new Vector());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, 
          new Runnable()
          {
            public void run()
            {
              p.setVelocity(new Vector());
            }
          }, 1L);
      }
    }
  }
  
  }
  @EventHandler
  public void AnchorKiller(EntityDamageByEntityEvent e)
  {
	 if (this.pl.kit) 
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Anchor"))))
      {
        p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        p.setVelocity(new Vector());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, 
          new Runnable()
          {
            public void run()
            {
              p.setVelocity(new Vector());
            }
          }, 1L);
        
      }  
    }
  }

  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Anchor")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Anchor");
	    }

	    return false;
	  }
  
}
