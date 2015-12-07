package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitInventory
{
  public static ItemStack getVacuumBlackHole()
  {
    ItemStack a = new ItemStack(Material.ENDER_PEARL, 1);
    ItemMeta am = a.getItemMeta();
    am.setDisplayName("§oBlack Hole");
    a.setItemMeta(am);
    return a;
  }
}
