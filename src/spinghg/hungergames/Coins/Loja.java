package spinghg.hungergames.Coins;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import spinghg.hungergames.libsHg;

public class Loja
  implements Listener
{
	  private libsHg pl;

	  public Loja(libsHg plugin)
	  {
	    this.setPl(plugin);
	  }


	
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§3§lLoja")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      if (e.getCurrentItem().getType() == Material.EMERALD)
      {
    	p.sendMessage("§c§oDesativado temporariamente");
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.THIN_GLASS)
      {
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP)
      {
        e.setCancelled(true);
        kExtras.guiShopExtra(p);;
        return;
      }
     
    }
  }



public libsHg getPl() {
	return pl;
}



public void setPl(libsHg pl) {
	this.pl = pl;
}
}