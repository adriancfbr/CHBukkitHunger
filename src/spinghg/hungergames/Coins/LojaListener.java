package spinghg.hungergames.Coins;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import spinghg.hungergames.libsHg;

public class LojaListener
  implements Listener
{
  public libsHg plugin;

  public LojaListener(libsHg plugin)
  {
    this.plugin = plugin;
  }


  @SuppressWarnings("deprecation")
public static void guiLoja(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§3§lLoja");

    
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
    
    
    ItemStack nt = new ItemStack(388);
    ItemMeta nts = nt.getItemMeta();
    nts.setDisplayName("§6Kits Permanente");
    nt.setItemMeta(nts);
    inv.setItem(0, nt);
    
    ItemStack paginass = new ItemStack(282);
    ItemMeta metaps = paginass.getItemMeta();
    metaps.setDisplayName("§6Extras 1 Partida");
    paginass.setItemMeta(metaps);
    inv.setItem(0, paginass);
    

    inv.setItem(0, vidro);
    inv.setItem(1, nt);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, paginass);
    inv.setItem(8, vidro);

    
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