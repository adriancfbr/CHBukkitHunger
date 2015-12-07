package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Boxer
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Boxer(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageBoxer(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Boxer"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Boxer (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Boxer", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Player))
    {
      Player boxer = (Player)e.getDamager();
      if (this.pl.kit) 
      if ((this.pl.km.temKit(boxer)) && (this.pl.km.getPlayerKit(boxer, this.pl.km.getKitByName("Boxer"))) && 
        (boxer.getItemInHand().getType() == Material.AIR)) {
        e.setDamage(3.0D);
      }
    }
    if ((e.getEntity() instanceof Player))
    {
      Player boxer = (Player)e.getEntity();
      if ((this.pl.km.temKit(boxer)) && (this.pl.km.getPlayerKit(boxer, this.pl.km.getKitByName("Boxer"))) && 
        (boxer.getItemInHand() == null)) {
        e.setDamage(e.getDamage() - 1.0D);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Boxer")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Boxer");
	    }

	    return false;
	  }
}
