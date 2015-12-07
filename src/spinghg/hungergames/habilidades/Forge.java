package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Forge
 implements Listener, CommandExecutor
{
	  private libsHg plugin;
	  
	  public Forge(libsHg plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  @EventHandler
	  public void onDamageHunter(EntityDamageByEntityEvent e)
	  {
		  if (this.plugin.comecou)
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Entity ent = e.getEntity();
	      Player player = (Player)e.getEntity();
	      Player damager = (Player)e.getDamager();
	      Player p = (Player)ent;
	      if ((this.plugin.km.temKit(player)) && (this.plugin.km.getPlayerKit(player, this.plugin.km.getKitByName("Forge"))) && 
	        (damager.getItemInHand() != null) && 
	        (damager.getItemInHand().getType() != null)) {
	      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
	    	  {
	    		  BossBar.setMessage(damager, p.getName() + " - Forge (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
	    	  }
	    	  else
	    	  {
	        BossBar.setMessage(damager, p.getName() + " - Forge", 1);
	      }
	      }
	    }
	  }
	  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    ItemStack currentItem = event.getCurrentItem();
    Player p = (Player)event.getWhoClicked();
    if ((currentItem != null) && (currentItem.getType() != Material.AIR) && (this.plugin.km.temKit(p)) && (this.plugin.km.getPlayerKit(p, this.plugin.km.getKitByName("Forge")))) {
        int coalAmount = 0;
      Inventory inv = event.getView().getBottomInventory();
      for (ItemStack item : inv.getContents()) {
        if ((item != null) && (item.getType() == Material.COAL)) {
          coalAmount += item.getAmount();
        }
      }
      if (coalAmount == 0)
          return;
        int hadCoal = coalAmount;
        if (currentItem.getType() == Material.COAL)
        {
          for (int slot = 0; slot < inv.getSize(); slot++) {
            ItemStack item = inv.getItem(slot);
            if ((item != null) && (item.getType().name().contains("ORE"))) {
              while ((item.getAmount() > 0) && (coalAmount > 0) && (
                (item.getType() == Material.IRON_ORE) || (item.getType() == Material.GOLD_ORE))) {
                item.setAmount(item.getAmount() - 1);
                coalAmount--;
                if (item.getType() == Material.IRON_ORE)
                    p.getInventory().addItem( 
                            new ItemStack(Material.IRON_INGOT));
                else if (item.getType() == Material.GOLD_ORE)
                  p.getInventory().addItem( 
                    new ItemStack(Material.GOLD_INGOT));
              }
              if (item.getAmount() == 0)
                inv.setItem(slot, new ItemStack(0));
            }
          }
        } else if (currentItem.getType().name().contains("ORE"))
        {
          while ((currentItem.getAmount() > 0) && (coalAmount > 0) && (
            (currentItem.getType() == Material.IRON_ORE) || (currentItem.getType() == Material.GOLD_ORE))) {
            currentItem.setAmount(currentItem.getAmount() - 1);
            coalAmount--;
            if (currentItem.getType() == Material.IRON_ORE) {
              p.getInventory()
                .addItem( new ItemStack(Material.IRON_INGOT)); } else {
              if (currentItem.getType() != Material.GOLD_ORE) continue;
              p.getInventory()
                .addItem(new ItemStack(Material.GOLD_INGOT));
            }
          }
          if (currentItem.getAmount() == 0)
            event.setCurrentItem(new ItemStack(0));
        }
        if (coalAmount != hadCoal)
          for (int slot = 0; slot < inv.getSize(); slot++)
          {
            ItemStack item = inv.getItem(slot);
            if ((item != null) && (item.getType() == Material.COAL)) {
              while ((coalAmount < hadCoal) && (item.getAmount() > 0)) {
                item.setAmount(item.getAmount() - 1);
                coalAmount++;
              }
              if (item.getAmount() == 0)
                inv.setItem(slot, new ItemStack(0));
            }
          }
      }
    }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Forge")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Forge");
	    }

	    return false;
	  }
}