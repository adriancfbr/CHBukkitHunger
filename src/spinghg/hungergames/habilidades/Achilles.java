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

public class Achilles
  implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Achilles(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageAchillesBar(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Achilles"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Achilles (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Achilles", 1);
    	  }
      }
    }
  }
  
  @EventHandler
  public void onDamageAchilles(EntityDamageByEntityEvent e)
  {
	if (this.pl.kit) 
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Achilles"))) && 
        (damager.getItemInHand() != null)) {
        if (damager.getItemInHand().getType() == Material.GOLD_SWORD)
        {
          e.setDamage(2.0D);
        }
        else if (damager.getItemInHand().getType() == Material.STONE_SWORD)
        {
          e.setDamage(2.0D);
        }
        else if (damager.getItemInHand().getType() == Material.IRON_SWORD)
        {
          e.setDamage(2.0D);
        }
        else if (damager.getItemInHand().getType() == Material.DIAMOND_SWORD)
        {
          e.setDamage(2.0D);
        }
        else if (damager.getItemInHand().getType() == Material.WOOD_SWORD)
        {
          e.setDamage(7.0D);
        }
      }
    }
  }

  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
    if (c.getName().equalsIgnoreCase("Achilles")) {
      Player p1 = (Player)p;
      p1.chat("/kit Achilles");
    }

    return false;
  }
}
