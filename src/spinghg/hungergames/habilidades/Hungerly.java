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
import org.bukkit.event.entity.FoodLevelChangeEvent;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Hungerly
  implements CommandExecutor, Listener
{

	private libsHg pl;
	  
	  public Hungerly(libsHg plugin)
	  {
	    this.pl = plugin;
	  }
	  
	  @EventHandler
	  public void onDamageHulk(EntityDamageByEntityEvent e)
	  {
		  if (this.pl.comecou)
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Entity ent = e.getEntity();
	      Player player = (Player)e.getEntity();
	      Player damager = (Player)e.getDamager();
	      Player p = (Player)ent;
	      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("hungerly"))) && 
	        (damager.getItemInHand() != null) && 
	        (damager.getItemInHand().getType() != null)) {
	      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
	    	  {
	    		  BossBar.setMessage(damager, p.getName() + " - Hungerly (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
	    	  }
	    	  else
	    	  {
	        BossBar.setMessage(damager, p.getName() + " - Hungerly", 1);
	      }
	    }
	    }
	  }
	  
	  @EventHandler
	  public void nohunger(FoodLevelChangeEvent event) {
		  Player player = (Player)event.getEntity();
		  if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("hungerly")))) {
		  if (this.pl.comecou) {
	    event.setCancelled(true);
	    event.setFoodLevel(20);
	  }
	  }
	  }
	  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
  if (c.getName().equalsIgnoreCase("Hungerly"))
    {
      Player p1 = (Player)p;
      p1.chat("/kit Hungerly");
    }
    return false;
  }
}
