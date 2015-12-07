package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Fireman
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Fireman(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageFireman(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Fireman"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Fireman (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Fireman", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onFireman(EntityDamageEvent e) {
    if ((e.getEntity() instanceof Player)) {
      Player p = (Player)e.getEntity();
      if (this.pl.kit) 
      if ((this.pl.comecou) && 
        (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Fireman"))) && (
        (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
        (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
        (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || 
        (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING))) {
        e.setDamage(0.0D);
        return;
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Fireman")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Fireman");
	    }

	    return false;
	  }
}
