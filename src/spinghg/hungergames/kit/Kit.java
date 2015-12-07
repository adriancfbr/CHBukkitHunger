package spinghg.hungergames.kit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kit
{
  private String nome = "";
  private boolean gratis = false;
  private List<ItemStack> items = null;
  private List<String> descricao = null;
  
  public Kit(String kitName, boolean isgratis, List<ItemStack> kitItems, List<String> kitDescricao)
  {
    this.nome = kitName;
    this.gratis = isgratis;
    this.items = kitItems;
    this.descricao = kitDescricao;
  }
  
  public void setName(String newName)
  {
    this.nome = newName;
  }
  
  public String getName()
  {
    return this.nome;
  }
  
  public boolean getGratis()
  {
    return this.gratis;
  }
  
  public List<ItemStack> getItem()
  {
    return this.items;
  }
  
  public List<String> getDescricao()
  {
    return this.descricao;
  }
  
  public static List<ItemStack> loadItem(List<String> items)
  {
    List<ItemStack> stacks = new ArrayList<ItemStack>();
    for (String str : items)
    {
      String[] item = str.split(":| ");
      int id = Integer.parseInt(item[0]);
      byte data = Byte.parseByte(item[1]);
      int amount = Integer.parseInt(item[2]);
      
      StringBuilder sb = new StringBuilder();
      boolean enchant = false;
      if (Enchantment.getByName(item[3]) != null)
      {
        for (int i = 5; i < item.length; i++) {
          sb.append(item[i] + " ");
        }
        enchant = true;
      }
      else
      {
        for (int i = 3; i < item.length; i++) {
          sb.append(item[i] + " ");
        }
      }
      String nome = ChatColor.translateAlternateColorCodes('&', sb.toString());
      

      @SuppressWarnings("deprecation")
	ItemStack i = new ItemStack(id, amount, data);
      if (enchant) {
        i.addUnsafeEnchantment(Enchantment.getByName(item[3]), Integer.parseInt(item[4]));
      }
      ItemMeta im = i.getItemMeta();
      im.setDisplayName(nome);
      i.setItemMeta(im);
      
      stacks.add(i);
    }
    return stacks;
  }
}
