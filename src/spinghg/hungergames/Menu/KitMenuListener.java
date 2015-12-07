package spinghg.hungergames.Menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import spinghg.hungergames.libsHg;

public class KitMenuListener
  implements Listener
{
	  private libsHg pl;

	  public KitMenuListener(libsHg plugin)
	  {
	    this.pl = plugin;
	  }
	  static ItemStack leftcarpet = new ItemStack(Material.CARPET, 1, (short) 8);

	
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§2Seus kits 1/2")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      if (e.getCurrentItem().getType() == Material.WOOD_AXE)
      {
        e.setCancelled(true);
        MenuLumberJack.LumberJack(p);
        return;
      }
      {
      ItemStack thor = new ItemStack(Material.CARPET, 1, (short) 5);
      ItemMeta metathor = thor.getItemMeta();
      thor.setItemMeta(metathor);
      if (e.getCurrentItem().equals(thor))
      {
        e.setCancelled(true);
        return;
      }
      }
      if (e.getCurrentItem().getType() == Material.COMPASS)
      {
        e.setCancelled(true);
        MenuNinja.Ninja(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIRE)
      {
        e.setCancelled(true);
        MenuThor.Thor(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.PORTAL)
      {
        e.setCancelled(true);
        
        MenuEndermage.Endermage(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
      {
        e.setCancelled(true);
        
        MenuVacuum.Vacuum(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK)
      {
        e.setCancelled(true);
        
        MenuRedstone.Redstone(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.NETHER_FENCE)
      {
        e.setCancelled(true);
        
        MenuCheckPoint.CheckPoint(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WATER)
      {
        e.setCancelled(true);
        MenuPoseidon.Poseidon(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.ANVIL)
      {
        e.setCancelled(true);
        MenuAnchor.Anchor(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.POTION)
      {
        e.setCancelled(true);
        MenuUrgal.Urgal(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FEATHER)
      {
        e.setCancelled(true);
        MenuPhantom.Phantom(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.BOOK)
      {
        e.setCancelled(true);   
        MenuSpecialist.Specialist(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SAPLING)
      {
        e.setCancelled(true);
        MenuCultivator.Cultivator(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIREWORK)
      {
        e.setCancelled(true);
        MenuKangaroo.Kangaroo(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_BOOTS)
      {
        e.setCancelled(true);
        MenuStomper.Stomper(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_FENCE)
      {
        e.setCancelled(true);
        MenuGladiator.Gladiator(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SPIDER_EYE)
      {
        e.setCancelled(true);
        MenuViper.Viper(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SOUL_SAND)
      {
        e.setCancelled(true);
        MenuSnail.Snail(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.ROTTEN_FLESH)
      {
        e.setCancelled(true);
        MenuCannibal.Cannibal(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.GOLD_AXE)
      {
        e.setCancelled(true);
        MenuViking.Viking(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
      {
        e.setCancelled(true);
        MenuBarbarian.Barbarian(p);
        return;
      } 
      if (e.getCurrentItem().getType() == Material.SADDLE)
      {
        e.setCancelled(true);
        MenuHulk.Hulk(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIRT)
      {
        e.setCancelled(true);
        MenuWorm.Worm(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND)
      {
        e.setCancelled(true);
        PaginaKitMenu.pKits(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.CARPET)
      {
    	KitMenu2.p2(p);  
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.BOW)
      {
        e.setCancelled(true);
        MenuArcher.Archer(p);
        return;
      }
      
      if (e.getCurrentItem().getType() == Material.WOOD_SWORD)
      {
        e.setCancelled(true);
        MenuAchilles.Achilles(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.STONE_SWORD)
      {
        e.setCancelled(true);
        MenuBoxer.Boxer(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FISHING_ROD)
      {
        e.setCancelled(true);
        MenuFisherman.Fisherman(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.NETHER_STAR)
      {
        e.setCancelled(true);
        MenuBlink.Blink(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.THIN_GLASS)
      {
        e.setCancelled(true);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SNOW_BALL)
      {
        e.setCancelled(true);
        MenuSwitcher.Switcher(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SNOW_BALL)
      {
        e.setCancelled(true);
        MenuSwitcher.Switcher(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DAYLIGHT_DETECTOR)
      {
        e.setCancelled(true);
        MenuThermo.Thermo(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.LEASH)
      {
        e.setCancelled(true);
        MenuGrappler.Grappler(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.STICK)
      {
          MenuGrandpa.Grandpa(p);
        e.setCancelled(true);
      }
      if (e.getCurrentItem().getType() == Material.SNOW_BLOCK)
      {
        e.setCancelled(true);
        MenuFrosty.Frosty(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.COAL)
      {
        e.setCancelled(true);
        MenuForge.Forge(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.LAVA)
      {
        e.setCancelled(true);
        MenuFireman.Fireman(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.SAND)
      {
        e.setCancelled(true);
        MenuCamel.Camel(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FLINT)
      {
        e.setCancelled(true);
        MenuTurtle.Turtle(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT)
      {
        e.setCancelled(true);
        MenuVampire.Vampire(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT)
      {
        e.setCancelled(true);
        MenuVampire.Vampire(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT)
      {
        e.setCancelled(true);
        MenuVampire.Vampire(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT)
      {
        e.setCancelled(true);
        MenuVampire.Vampire(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.LEVER)
      {
        e.setCancelled(true);
        MenuTerrorist.Terrorist(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_BARDING)
      {
        e.setCancelled(true);
        MenuRider.Rider(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.TNT)
      {
       e.setCancelled(true);
        MenuTank.Tank(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.STONE_PICKAXE)
      {
       e.setCancelled(true);
        MenuMiner.Miner(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.CLAY_BALL)
      {
       e.setCancelled(true);
        MenuJellyfish.Jellyfish(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.GRAVEL)
      {
       e.setCancelled(true);
        MenuDemoman.Demoman(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.NETHER_STAR)
      {
       e.setCancelled(true);
        MenuBlink.Blink(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.POTION)
      {
       e.setCancelled(true);
        MenuUrgal.Urgal(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.FISHING_ROD)
      {
       e.setCancelled(true);
        MenuFisherman.Fisherman(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_FENCE)
      {
       e.setCancelled(true);
        MenuGladiator.Gladiator(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIRT)
      {
       e.setCancelled(true);
        MenuWorm.Worm(p);
        return;
      }
      if (e.getCurrentItem().getType() == Material.PACKED_ICE)
      {
       e.setCancelled(true);
        MenuFrozen.Frozen(p);
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