package spinghg.hungergames.Menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

public class MenuMeteoroListener
  implements Listener
{
	  private libsHg pl;

	  public MenuMeteoroListener(libsHg plugin)
	  {
	    this.pl = plugin;
	  }

	
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("Kit Meteoro")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      if (e.getCurrentItem().getType() == Material.FIRE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit Meteoro");
        return;
      }
      
      if (e.getCurrentItem().getType() == Material.FIREBALL)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§a§oCompre VIP em nosso site para usar este kit: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("site"));
        return;
      }
      
      if (e.getCurrentItem().getType() == Material.BOOK)
      {
        e.setCancelled(true);
      }
      
      if (e.getCurrentItem().getType() == Material.MAP)
      {
        e.setCancelled(true);
      }
     
      if (e.getCurrentItem().getType() == Material.COMPASS)
      {
        e.setCancelled(true);
      }
      
      if (e.getCurrentItem().getType() == Material.BOOK)
      {
        e.setCancelled(true);
      }
      
      if (e.getCurrentItem().getType() == Material.CARPET)
      {
        e.setCancelled(true);
        PaginaKitMenu.pKits(p);
        return;
      }
      
      if (e.getCurrentItem().getType() == Material.SUGAR)
      {
        e.setCancelled(true);
        KitMenu.guiKits(p);
        return;
      }
      
      if (e.getCurrentItem().getType() == Material.SULPHUR)
      {
        e.setCancelled(true);
        return;
      }
     
      if (e.getCurrentItem().getType() == Material.THIN_GLASS)
      {
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIREWORK)
      {
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FEATHER)
      {
        e.setCancelled(true);
        return;
      }
    }
  }
}