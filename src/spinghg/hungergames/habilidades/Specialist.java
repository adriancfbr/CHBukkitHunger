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
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Specialist
implements Listener, CommandExecutor
{
  private Map<String, Long> cooldown = new HashMap();
  private Map<String, Integer> cooldown3 = new HashMap();
  private libsHg pl;
  
  public Specialist(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageSpecialist(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Specialist"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Specialist (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Specialist", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void click(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Specialist"))) && 
      (p.getItemInHand().getType() == Material.BOOK) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
      p.openEnchanting(p.getLocation(), true);
    }
  }
  
  @EventHandler
  public void dead(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    Player spe = p.getKiller();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(spe)) && (this.pl.km.getPlayerKit(spe, this.pl.km.getKitByName("Specialist")))) {
      spe.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) });
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Specialist")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Specialist");
	    }

	    return false;
	  }
}
