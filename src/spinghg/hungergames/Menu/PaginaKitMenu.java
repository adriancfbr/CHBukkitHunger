package spinghg.hungergames.Menu;

import spinghg.hungergames.libsHg;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PaginaKitMenu
  implements Listener
{
  public libsHg plugin;

  public PaginaKitMenu(libsHg plugin)
  {
    this.plugin = plugin;
  }

  public static void pKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54, "§9Alguns Kits que você não tem");

    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
    
    
    ItemStack meio = new ItemStack(289);
    ItemMeta metam = meio.getItemMeta();
    metam.setDisplayName("");
    meio.setItemMeta(metam);
    inv.setItem(0, meio);
    
    ItemStack paginass = new ItemStack(171);
    ItemMeta metaps = paginass.getItemMeta();
    metaps.setDisplayName("§a§o<--");
    paginass.setItemMeta(metaps);
    inv.setItem(0, paginass);

    inv.setItem(0, paginass);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, meio);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, vidro);

    if ((p.hasPermission("kit.archer")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.BOW);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Archer");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.ninja")) || (p.hasPermission("sping.admin")))
    {
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.COMPASS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Ninja");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.LumberJackL")) || (p.hasPermission("sping.admin")))
    {
    
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.WOOD_AXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "LumberJack");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.poseidon")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.WATER);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Poseidon");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Achilles")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Achilles");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.cannibal")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.ROTTEN_FLESH);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Cannibal");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.specialist")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.BOOK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Specialist");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.endermage")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.PORTAL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Endermage");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Phantom")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.FEATHER);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Phantom");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Redstone")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Redstone");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.CheckPoint")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "CheckPoint");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Vacuum")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Vacuum");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.stomper")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Stomper");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.kangaroo")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.FIREWORK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Kangaroo");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Cultivator")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.SAPLING);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Cultivator");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.thor")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.FIRE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Thor");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.anchor")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.ANVIL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Anchor");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.viper")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Viper");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.snail")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.SOUL_SAND);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Snail");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.viking")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.GOLD_AXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Viking");
      ArrayList descpyro = new ArrayList();;
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.barbarian")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Barbarian");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.hulk")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.SADDLE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Hulk");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Worm")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.DIRT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Worm");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Gladiator")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.IRON_FENCE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Gladiator");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Fisherman")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.FISHING_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Fisherman");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Urgal")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.POTION);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Urgal");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((p.hasPermission("kit.Boxer")) || (p.hasPermission("sping.admin")))
    {
    	
    }
    else
    {
      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Boxer");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
        if ((p.hasPermission("kit.Blink")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.NETHER_STAR);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Blink");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Demoman")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.GRAVEL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Demoman");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Jellyfish")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.CLAY_BALL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Jellyfish");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Miner")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Miner");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Tank")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyros = new ItemStack(Material.TNT);
          ItemMeta metapyros = pyros.getItemMeta();
          metapyros.setDisplayName(ChatColor.GREEN + "Tank");
          ArrayList descpyros = new ArrayList();
          metapyros.setLore(descpyros);
          pyros.setItemMeta(metapyros);
          inv.addItem(new ItemStack[] { pyros });
        }
        if ((p.hasPermission("kit.Rider")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.IRON_BARDING);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Rider");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Terrorist")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.LEVER);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Terrorist");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
      
        if ((p.hasPermission("kit.Vampire")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.DOUBLE_PLANT);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Vampire");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Turtle")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.FLINT);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Turtle");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Camel")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.SAND);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Camel");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Fireman")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.LAVA);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Fireman");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Forge")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.COAL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Forge");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Frosty")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Frosty");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Grandpa")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.STICK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Grandpa");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Grappler")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.LEASH);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Grappler");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.Thermo")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.DAYLIGHT_DETECTOR);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Thermo");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("kit.switcher")) || (p.hasPermission("sping.admin")))
        {
        	
        }
        else
        {
          ItemStack pyro = new ItemStack(Material.SNOW_BALL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "switcher");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
    
    ItemStack[] arrayOfItemStack;
    int descpyro = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro = 0; metapyro < descpyro; metapyro++)
    {
      ItemStack item = arrayOfItemStack[metapyro];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
    p.playSound(p.getLocation(), Sound.CHEST_OPEN, 40.0F, 1.0F);
  }
}