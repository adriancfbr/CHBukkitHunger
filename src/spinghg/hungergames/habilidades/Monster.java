package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
public class Monster
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Monster(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  private HashMap<Player, Long> cookieExpires = new HashMap();
  public int delayForEatMinerApple = 500;
  
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
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Monster"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Monster (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Monster", 1);
      }
    }
  }
  }
  
  @EventHandler
  public void onTarget(EntityTargetEvent event)
  {
	  Player player = (Player)event.getEntity();
    if (((event.getTarget() instanceof Player)) && (this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Monster"))) || ((event.getReason() != EntityTargetEvent.TargetReason.TARGET_ATTACKED_OWNER) && (event.getReason() != EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY) && (event.getReason() != EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET))) {
      event.setCancelled(true);
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Miner")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Miner");
	    }

	    return false;
	  }
}
