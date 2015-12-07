package spinghg.hungergames.Coins;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import spinghg.hungergames.libsHg;

public class kExtras
  implements Listener
{
  public libsHg plugin;

  public void kkExtras(libsHg plugin)
  {
    this.plugin = plugin;
  }

  static ItemStack leftcarpet = new ItemStack(Material.CARPET, 1, (short) 8);

  @SuppressWarnings({ "rawtypes", "unchecked" })
public static void guiShopExtra(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§3§lLoja - Extras");

    
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
   
    {
      ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "5 Sopas §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    {
      ItemStack pyro = new ItemStack(Material.WOOD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "15 Woods §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    {
      ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Stone Pickaxe §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
  
    {
      ItemStack pyro = new ItemStack(Material.BOWL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "35 BOWL §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
       
        {
          ItemStack pyro = new ItemStack(Material.STICK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "25 Stick §625 Coins");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((!p.hasPermission("hg.vantage")))
        {
          ItemStack pyro = new ItemStack(Material.CAKE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Spawn no lugar §625 Coins");
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