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

public class LojaKits
  implements Listener
{
  public libsHg plugin;

  public LojaKits(libsHg plugin)
  {
    this.plugin = plugin;
  }

  static ItemStack leftcarpet = new ItemStack(Material.CARPET, 1, (short) 8);

  @SuppressWarnings({ "rawtypes", "unchecked" })
public static void guiShopKit(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§3§lLoja - Kits");

    
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
   
    if ((!p.hasPermission("kit.Endermage")))
    {
      ItemStack pyro = new ItemStack(Material.PORTAL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Endermage §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((!p.hasPermission("kit.Redstone")))
    {
      ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Redstone §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if ((!p.hasPermission("kit.stomper")))
    {
      ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Stomper §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
   
    if ((!p.hasPermission("kit.Boxer")))
    {
      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName(ChatColor.GREEN + "Boxer §625 Coins");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
       
        if ((!p.hasPermission("kit.Miner")))
        {
          ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "Miner §625 Coins");
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