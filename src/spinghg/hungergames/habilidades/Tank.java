package spinghg.hungergames.habilidades;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Tank
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Tank(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageTank(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Tank"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else {
        BossBar.setMessage(damager, p.getName() + " - Tank", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onKilled(PlayerDeathEvent event)
  {
	  if (this.pl.kit) 
    if (((event.getEntity().getKiller() instanceof Player)) && ((event.getEntity() instanceof Player)))
    {
      Player player1 = event.getEntity();
      Player killer1 = player1.getKiller();
      if ((this.pl.km.temKit(killer1)) && (this.pl.km.getPlayerKit(killer1, this.pl.km.getKitByName("Tank"))))
      {
        Location loc1 = player1.getLocation();
        World w = player1.getWorld();
        Entity tnt = w.spawn(loc1, TNTPrimed.class);
        ((TNTPrimed)tnt).setFuseTicks(0);
      }
    }
  }
  
  @EventHandler
  public void tankDamage(EntityDamageEvent event)
  {
	  if (this.pl.kit) 
    if (((event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) && 
      ((event.getEntity() instanceof Player)))
    {
      Player p = (Player)event.getEntity();
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Tank")))) {
        event.setCancelled(true);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Tank")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Tank");
	    }

	    return false;
	  }
}
