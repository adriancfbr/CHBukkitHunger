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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Reaper
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Reaper(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageReaper(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Reaper"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Reaper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Reaper", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void OnClick(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player damager = (Player)e.getDamager();
      Player victim = (Player)e.getEntity();
      if (this.pl.kit) 
      if ((this.pl.km.temKit(damager)) && (this.pl.km.getPlayerKit(damager, this.pl.km.getKitByName("Reaper"))) && 
        (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE)) {
        victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 75, 1));
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Reaper")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Reaper");
	    }

	    return false;
	  }
}
