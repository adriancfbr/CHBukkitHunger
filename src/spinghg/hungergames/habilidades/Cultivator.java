package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Cultivator
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Cultivator(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageCultivator(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Cultivator"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Nenhum (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Cultivator", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onPlace(BlockPlaceEvent event)
  {
    Player player = event.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Cultivator"))))
    {
      Block b = event.getBlock();
      if (b.getType() == Material.SAPLING)
      {
        int data = b.getData();
        b.setType(Material.AIR);
        boolean success = false;
        if (data == 1)
        {
          b.setType(Material.AIR);
          success = b.getWorld().generateTree(b.getLocation(), TreeType.REDWOOD);
        }
        else if (data == 2)
        {
          b.setType(Material.AIR);
          b.getWorld().generateTree(b.getLocation(), TreeType.BIRCH);
        }
        else
        {
          b.setType(Material.AIR);
          if (data == 3) {
            b.getWorld().generateTree(b.getLocation(), TreeType.SMALL_JUNGLE);
          } else {
            b.getWorld().generateTree(b.getLocation(), TreeType.TREE);
          }
        }
        if (!success) {
          b.setTypeIdAndData(Material.SAPLING.getId(), (byte)data, false);
        }
      }
      else if (b.getType() == Material.CROPS)
      {
        b.setData((byte)7);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Cultivator")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Cultivator");
	    }

	    return false;
	  }
}
