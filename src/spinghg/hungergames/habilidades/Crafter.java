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
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Crafter
  implements CommandExecutor, Listener
  {
  private libsHg pl;
  
  public Crafter(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageCamel(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Crafter"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Crafter (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Crafter", 1);
      }
      }
    }
  }
  @EventHandler
  public void onBlo2kClick22(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Crafter"))) && 
      ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) && 
      (player.getItemInHand().getType() == Material.NETHER_STAR)) {
      player.openWorkbench(player.getLocation(), true);
    }
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Crafter"))) && ((event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR)) && 
    	      (player.getItemInHand().getType() == Material.NETHER_STAR)) {
    		 Inventory localInventory = Bukkit.createInventory(player, InventoryType.FURNACE);
    	        player.openInventory(localInventory);
    }
  }


  public boolean onCommand(CommandSender p, Command c, String label, String[] args) {
    if (c.getName().equalsIgnoreCase("Crafter")) {
      Player p1 = (Player)p;
      p1.chat("/kit crafter");
    }

    return false;
  }
}