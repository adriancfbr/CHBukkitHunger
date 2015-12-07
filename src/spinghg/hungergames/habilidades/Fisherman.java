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
import org.bukkit.event.player.PlayerFishEvent;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Fisherman
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Fisherman(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageFisherman(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Fisherman"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Fisherman (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Fisherman", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onPlayerFished(PlayerFishEvent event)
  {
    Player player = event.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Fisherman"))) && 
      ((event.getCaught() instanceof Player)))
    {
      Player caught = (Player)event.getCaught();
      if (player.getItemInHand().getType() == Material.FISHING_ROD) {
        caught.teleport(player.getLocation());
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Fisherman")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Fisherman");
	    }

	    return false;
	  }
}
