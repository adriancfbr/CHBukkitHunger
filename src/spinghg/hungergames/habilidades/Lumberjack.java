package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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

public class Lumberjack
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Lumberjack(libsHg plugin)
  {
    this.pl = plugin;
  }
  
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
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Lumberjack"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Lumberjack (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Lumberjack", 1);
      }
    }
  }
  }
  @EventHandler
  public void onBreak(BlockBreakEvent event)
  {
    Player player = event.getPlayer();
    if (this.pl.kit) 
    if (((event.getBlock().getType() == Material.LOG) || (event.getBlock().getType() == Material.LOG_2)) && (this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Lumberjack"))))
    {
      Block b = event.getBlock().getRelative(BlockFace.UP);
      while ((b.getType() == Material.LOG) || (b.getType() == Material.LOG_2))
      {
        b.breakNaturally();
        b = b.getRelative(BlockFace.UP);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Lumberjack")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Lumberjack");
	    }

	    return false;
	  }
}
