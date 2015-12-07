package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Spirit
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Spirit(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageSpecialist(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Spirit"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Spirit (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Spirit", 1);
      }
    }
    }
  }

  @EventHandler
  public void dano(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player player = (Player)e.getEntity();
      if (this.pl.Spirit7.contains(player)) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Player))
    {
      Player player = (Player)e.getDamager();
      if (this.pl.Spirit7.contains(player)) {
        e.setCancelled(true);
      }
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Spirit")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Spirit");
	    }

	    return false;
	  }
}