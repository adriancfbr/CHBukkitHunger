package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Vampire
implements Listener, CommandExecutor
{
  private Map<String, Long> cooldown = new HashMap();
  private Map<String, Integer> cooldown3 = new HashMap();
  private libsHg pl;
  
  public Vampire(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageVampire(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Vampire"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Vampire", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void dead(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    Player d = p.getKiller();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(d)) && (this.pl.km.getPlayerKit(d, this.pl.km.getKitByName("Vampire"))))
    {
      Potion potion = new Potion(PotionType.INSTANT_HEAL);
      potion.setSplash(true);
      d.getHealthScale();
      d.getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
    }
    else if ((this.pl.km.temKit(d)) && (this.pl.km.getPlayerKit(d, this.pl.km.getKitByName("Vampire"))))
    {
      d.setHealth(20.0D);
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Vampire")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Vampire");
	    }

	    return false;
	  }
}
