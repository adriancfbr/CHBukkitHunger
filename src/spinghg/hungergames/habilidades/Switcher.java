package spinghg.hungergames.habilidades;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Switcher
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Switcher(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public void onDamageSwitcher(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Switcher"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Switcher", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
  {
    Entity ent = e.getEntity();
    Entity damager = e.getDamager();
    if (this.pl.kit) 
    if ((ent instanceof Player))
    {
      Player hit = (Player)ent;
      if ((damager instanceof Snowball))
      {
        Snowball snowball = (Snowball)damager;
        if ((snowball.getShooter() instanceof Player))
        {
          Player shooter = (Player)snowball.getShooter();
          if ((!this.pl.km.temKit(shooter)) || (!this.pl.km.getPlayerKit(shooter, this.pl.km.getKitByName("Switcher")))) {
            return;
          }
          Location ploc = shooter.getLocation();
          Location hitloc = hit.getLocation();
          shooter.teleport(hitloc);
          hit.teleport(ploc);
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Switcher")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Switcher");
	    }

	    return false;
	  }
}
