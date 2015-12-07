package spinghg.hungergames.habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Hulk
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Hulk(libsHg plugin)
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
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Hulk"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Hulk (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Hulk", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onClick(PlayerInteractEvent e)
  {
    if ((e.getAction().name().contains("LEFT")) && 
      (!this.pl.comecando))
    {
      Player player = e.getPlayer();
      if (this.pl.kit) 
      if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Hulk")))) {
        return;
      }
      if (player.getPassenger() != null)
      {
        Entity pas = player.getPassenger();
        if ((pas instanceof Player))
        {
          final Player p = (Player)pas;
          final Vector vector = player.getEyeLocation().getDirection();
          vector.multiply(1.2F);
          vector.setY(1.2F);
          p.setSneaking(true);
          Bukkit.getScheduler().scheduleAsyncDelayedTask(this.pl, new Runnable()
          {
            public void run()
            {
              p.setSneaking(false);
              p.setVelocity(vector);
            }
          }, 10L);
        }
      }
    }
  }
  
  @EventHandler
  public void hulk(PlayerInteractEntityEvent event)
  {
    if (!(event.getRightClicked() instanceof Player)) {
      return;
    }
    if (this.pl.kit) 
    if (!this.pl.comecando)
    {
      Player player = event.getPlayer();
      Player clicked = (Player)event.getRightClicked();
      if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Hulk")))) {
        return;
      }
      if (player.getItemInHand().getType() != Material.AIR) {
        return;
      }
      if ((player.getPassenger() == null) && (clicked.getPassenger() == null)) {
        player.setPassenger(clicked);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Hulk")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Hulk");
	    }

	    return false;
	  }
}
