package spinghg.hungergames.feasts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class RandomItems
{
 public static List<ItemStack> getRandom(List<String> lista)
{
    Random r = new Random();
  if (lista == null) {
     return null;
   }
  List<ItemStack> items = new ArrayList();
   for (String str : lista)
     {
     String[] args = str.split(" |:");
       
   ItemStack item = new ItemStack(Integer.parseInt(args[0]), 
     new Random().nextInt(Integer.parseInt(args[2]) + Integer.parseInt(args[3])), 
    Byte.parseByte(args[1]));

    int chance = r.nextInt(101);
   if (chance <= Integer.parseInt(args[4])) {
   items.add(item);
  }
  }
  return items;
   }

 public static void fillChest(Chest chest, List<ItemStack> items)
{
 for (ItemStack i : items) {
     chest.getInventory().addItem(new ItemStack[] { i });
  }
   }
 }
