package spinghg.hungergames.habilidades;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Turtle
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Turtle(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageTurtle(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Turtle"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else {
        BossBar.setMessage(damager, p.getName() + " - Turtle", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void a(EntityDamageEvent e)
  {
    Entity entidade = e.getEntity();
    if (this.pl.kit) 
    if ((entidade instanceof Player))
    {
      Player p = (Player)entidade;
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Turtle"))) && (!this.pl.comecando) && (!this.pl.invencibilidade)) {
        if (p.isSneaking())
        {
          e.setDamage(1.0D);
          entidade.getWorld().playEffect(entidade.getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
        }
        else
        {
          p.damage(e.getDamage());
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Turtle")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Turtle");
	    }

	    return false;
	  }
}
