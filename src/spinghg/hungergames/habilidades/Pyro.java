package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Pyro
implements Listener, CommandExecutor
{
private libsHg pl;

public Pyro(libsHg plugin)
{
  this.pl = plugin;
}

  public float fireballExplosiveMultiplier = 1.5F;
  
  @EventHandler
  public void onDamageLumberjack(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Pyro"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Pyro (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Pyro", 1);
      }
    }
  }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    ItemStack item = event.getItem();
    Player p = event.getPlayer();
    if (this.pl.kit) 
    if ((event.getAction() == Action.RIGHT_CLICK_AIR) && (item != null) && (item.getType() == Material.FIREBALL) && ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Pyro")))))
    {
      item.setAmount(item.getAmount() - 1);
      if (item.getAmount() == 0) {
        event.getPlayer().setItemInHand(new ItemStack(0));
      }
      Fireball ball = (Fireball)event.getPlayer().launchProjectile(Fireball.class);
      ball.setIsIncendiary(true);
      ball.setYield(ball.getYield() * this.fireballExplosiveMultiplier);
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Pyro")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Pyro");
	    }

	    return false;
	  }
}