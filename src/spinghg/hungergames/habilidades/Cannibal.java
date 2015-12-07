package spinghg.hungergames.habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Cannibal
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Cannibal(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageCannibalBar(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Cannibal"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("hg.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Cannibal (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Cannibal", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onDamageCannibal(EntityDamageByEntityEvent e)
  {
	  if (this.pl.kit) 
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      if ((this.pl.comecou) && 
        (this.pl.km.temKit(damager)) && (this.pl.km.getPlayerKit(damager, this.pl.km.getKitByName("Cannibal"))) && 
        (new Random().nextInt(3) == 0))
      {
        int food = damager.getFoodLevel();
        food += 2;
        if (food >= 20) {
          food = 20;
        }
        damager.setFoodLevel(food);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 1));
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Cannibal")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Cannibal");
	    }

	    return false;
	  }
}
