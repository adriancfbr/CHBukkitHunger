package spinghg.hungergames.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

public class KitManager
{
  public Map<Player, Kit> playerKit = new HashMap<Player, Kit>();
  public List<Kit> kits = new ArrayList<Kit>();
  
  public KitManager(libsHg plugin) {}
  
  public void loadKits()
  {
    List<String> kitslist = Config.getConfig(Config.ConfigFile.KITS).getStringList("KitsLista");
    for (String kit : kitslist) {
      loadKit(kit);
    }
  }
  
  public List<Kit> getKits()
  {
    return this.kits;
  }
  
  public void loadKit(String kitName)
  {
    boolean gratis = Config.getConfig(Config.ConfigFile.KITS).getBoolean("Kits." + kitName + ".gratis");
    List<ItemStack> items = Kit.loadItem(Config.getConfig(Config.ConfigFile.KITS).getStringList("Kits." + kitName + ".items"));
    List<String> descricao = Config.getConfig(Config.ConfigFile.KITS).getStringList("Kits." + kitName + ".descricao");
    
    Kit newKit = new Kit(kitName, gratis, items, descricao);
    newKit.setName(kitName);
    
    this.kits.add(newKit);
  }
  
  public void setKit(Kit kit, Player player)
  {
    this.playerKit.put(player, kit);
  }
  
  public void giveKitItems(Player player)
  {
    List<ItemStack> items = ((Kit)this.playerKit.get(player)).getItem();
    if (((Kit)this.playerKit.get(player)).getName() == "Barbarian")
    {
      for (ItemStack i : items)
      {
        i.addUnsafeEnchantment(Enchantment.DURABILITY, 2);
        player.getInventory().addItem(new ItemStack[] { i });
      }
      return;
    }
    for (ItemStack i : items) {
      player.getInventory().addItem(new ItemStack[] { i });
    }
  }
  
  public boolean temKit(Player player)
  {
    return this.playerKit.containsKey(player);
  }
  
  public boolean getPlayerKit(Player player, Kit kit)
  {
    if (this.playerKit.containsKey(player))
    {
      if (((Kit)this.playerKit.get(player)).getName() == kit.getName()) {
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public void removeKit(Kit kit, Player player)
  {
    if (this.playerKit.containsKey(player)) {
      this.playerKit.remove(player);
    }
  }
  
  public Kit getKitByName(String s)
  {
    for (Kit kit : this.kits) {
      if (s.equalsIgnoreCase(kit.getName())) {
        return kit;
      }
    }
    return null;
  }
  
  public static ItemStack getVacuumBlackHole()
  {
    ItemStack a = new ItemStack(Material.ENDER_PEARL, 1);
    ItemMeta am = a.getItemMeta();
    am.setDisplayName("§7Black Hole");
    a.setItemMeta(am);
    return a;
  }
}
