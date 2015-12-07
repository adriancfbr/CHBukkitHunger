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

public class KitMenu2Listener
  implements Listener
{
	  private libsHg pl;

	  public KitMenu2Listener(libsHg plugin)
	  {
	    this.pl = plugin;
	  }

	
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§2Seus kits 2/2")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      if (e.getCurrentItem().getType() == Material.WOOD_AXE)
      {
        e.setCancelled(true);
        MenuLumberJack.LumberJack(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIREBALL)
      {
        e.setCancelled(true);
        MenuPyron.Pyro(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.PACKED_ICE)
      {
       e.setCancelled(true);
        MenuFrozen.Frozen(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WOOD_HOE)
      {
       e.setCancelled(true);
        MenuReaper.Reaper(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SLIME_BALL)
      {
       e.setCancelled(true);
        MenuBurrower.Burrower(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WATCH)
      {
       e.setCancelled(true);
        MenuTimeLord.TL(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SAPLING)
      {
       e.setCancelled(true);
        MenuTurtle.Turtle(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIRE)
      {
       e.setCancelled(true);
        MenuBerserker.Berserker(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.CARPET)
      {
       e.setCancelled(true);
        KitMenu.guiKits(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON)
      {
       e.setCancelled(true);
        MenuFlash.Flash(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_ORE)
      {
       e.setCancelled(true);
        MenuBlacksmith.Blacksmith(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE)
      {
       e.setCancelled(true);
        MenuSpirit.Spirit(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP)
      {
       e.setCancelled(true);
        MenuHermit.Hermit(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.BED)
      {
       e.setCancelled(true);
        MenuConfusion.Confusion(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.POTION)
      {
       e.setCancelled(true);
        MenuWeakhand.Weakhand(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WORKBENCH)
      {
       e.setCancelled(true);
        MenuCrafter.Crafter(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND)
      {
        e.setCancelled(true);
        PaginaKitMenu.pKits(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.BONE)
      {
        e.setCancelled(true);
        MenuSerialKiller.SeriallKiller(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.LAVA)
      {
        e.setCancelled(true);
        MenuLavaMan.LavaMan(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.COOKIE)
      {
        e.setCancelled(true);
        MenuCookieMonster.CookieMonster(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WRITTEN_BOOK)
      {
        e.setCancelled(true);
        MenuHungerly.Hungerly(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIRT)
      {
        e.setCancelled(true);
        MenuTower.Sumo(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FLOWER_POT)
      {
        e.setCancelled(true);
        MenuBomber.Bomber(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
      {
        e.setCancelled(true);
        MenuJumper.Jumper(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.TNT)
      {
        e.setCancelled(true);
        MenuMeteoro.Meteoro(p);
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
    }
    
  }
}