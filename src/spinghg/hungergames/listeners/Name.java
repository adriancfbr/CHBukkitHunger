package spinghg.hungergames.listeners;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;

public class Name
implements Listener
{
@SuppressWarnings("unused")
private libsHg pl;

public Name(libsHg plugin)
{
  this.pl = plugin;
}
private static HashMap<String, String> NAMES = new HashMap<String, String>();

  public Name() {
    NAMES.put("AIR", "Punhos");
    NAMES.put("WOOD_SWORD", "Espada de Madeira");
    NAMES.put("WOOD_AXE", "Machado de Madeira");
    NAMES.put("STONE_SWORD", "Espada de Pedra");
    NAMES.put("STONE_AXE", "Machado de Pedra");
    NAMES.put("IRON_SWORD", "Espada de Ferro");
    NAMES.put("IRON_AXE", "Machado de Ferro");
    NAMES.put("GOLD_SWORD", "Espada de Ouro");
    NAMES.put("GOLD_AXE", "Machado de Ouro");
    NAMES.put("DIAMOND_SWORD", "Espada de Diamante");
    NAMES.put("DIAMOND_AXE", "Machado de Diamante");
    NAMES.put("BOWL", "Tigela");
    NAMES.put("MUSHROOM_SOUP", "Sopa");
    NAMES.put("ARROW", "Flecha");
    NAMES.put("DIAMOND_AXE", "Machado de Diamante");
  }

  public String getEnchantName(Enchantment enchant) {
    return getName(enchant.getName());
  }

  @SuppressWarnings("deprecation")
public static String getItemName(ItemStack item)
  {
    if (item == null)
      item = new ItemStack(0);
    if (NAMES.containsKey(item.getType().name()))
      return (String)NAMES.get(item.getType().name());
    return getName(item.getType().name());
  }

  public static String getName(String string) {
    if (NAMES.containsValue(string))
      return (String)NAMES.get(string);
    return toReadable(string);
  }

  public static String toReadable(String string) {
    String[] names = string.split("_");
    for (int i = 0; i < names.length; i++) {
      names[i] = 
        (names[i].substring(0, 1) + 
        names[i].substring(1).toLowerCase());
    }
    return StringUtils.join(names, " ");
  }
}