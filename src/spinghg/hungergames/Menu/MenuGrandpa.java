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

public class MenuGrandpa
  implements Listener
{
  public libsHg plugin;

  public MenuGrandpa(libsHg plugin)
  {
    this.plugin = plugin;
  }

  public static void Grandpa(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54, "Kit Gladiator");

    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
    
    
    ItemStack meio = new ItemStack(353);
    ItemMeta metam = meio.getItemMeta();
    metam.setDisplayName("§a§oVoltar");
    meio.setItemMeta(metam);
    inv.setItem(0, meio);

    inv.setItem(0, vidro);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, meio);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, vidro);
    inv.setItem(9, vidro);
    inv.setItem(10, vidro);
    inv.setItem(11, vidro);
    inv.setItem(12, vidro);
    inv.setItem(13, vidro);
    inv.setItem(14, vidro);
    inv.setItem(15, vidro);
    inv.setItem(16, vidro);
    inv.setItem(17, vidro);
    inv.setItem(18, vidro);
    inv.setItem(20, vidro);
    inv.setItem(22, vidro);
    inv.setItem(24, vidro);
    inv.setItem(26, vidro);
    inv.setItem(27, vidro);
    inv.setItem(28, vidro);
    inv.setItem(29, vidro);
    inv.setItem(30, vidro);
    inv.setItem(31, vidro);
    inv.setItem(32, vidro);
    inv.setItem(33, vidro);
    inv.setItem(35, vidro);
    inv.setItem(34, vidro);
    inv.setItem(37, vidro);
    inv.setItem(38, vidro);
    inv.setItem(39, vidro);
    inv.setItem(40, vidro);
    inv.setItem(41, vidro);
    inv.setItem(42, vidro);
    inv.setItem(43, vidro);
    {
      ItemStack pyro = new ItemStack(Material.MAP);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§aKit Gladiator");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    {
    ItemStack pyro = new ItemStack(Material.BOOK);
    ItemMeta metapyro = pyro.getItemMeta();
    metapyro.setDisplayName("§a§oDescrição do Kit Gladiator");
    ArrayList descpyro = new ArrayList();
    descpyro.add("§5§oCrie uma arena x1 clicando em seu oponente!");
    metapyro.setLore(descpyro);
    pyro.setItemMeta(metapyro);
    inv.addItem(new ItemStack[] { pyro });
  }
    {
    ItemStack pyro = new ItemStack(Material.COMPASS);
    ItemMeta metapyro = pyro.getItemMeta();
    metapyro.setDisplayName("§a§oEstrategias do Kit Gladiator");
    ArrayList descpyro = new ArrayList();
    descpyro.add("§5§oBoa para fugir de Traps e Times!!");
    metapyro.setLore(descpyro);
    pyro.setItemMeta(metapyro);
    inv.addItem(new ItemStack[] { pyro });
  }
    
    {
    ItemStack pyro = new ItemStack(Material.EMERALD);
    ItemMeta metapyro = pyro.getItemMeta();
    metapyro.setDisplayName("§a§oGroups que tem este kit");
    ArrayList descpyro = new ArrayList();
    descpyro.add("§5§oStaff,Youtuber,VIP,MVP e Pro");
    metapyro.setLore(descpyro);
    pyro.setItemMeta(metapyro);
    inv.addItem(new ItemStack[] { pyro });
  }
    
    {
    ItemStack pyro = new ItemStack(Material.SIGN);
    ItemMeta metapyro = pyro.getItemMeta();
    metapyro.setDisplayName("§a§oItens do kit Gladiator");
    ArrayList descpyro = new ArrayList();
    metapyro.setLore(descpyro);
    pyro.setItemMeta(metapyro);
    inv.addItem(new ItemStack[] { pyro });
  }
    
    if ((p.hasPermission("planeta.hg.kit.Anchor")) || (p.hasPermission("sping.admin")))
    {
      ItemStack pyro = new ItemStack(Material.FIRE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("Usar este kit");
      ArrayList descpyro = new ArrayList();
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    else
    {
        ItemStack pyro = new ItemStack(Material.FIREBALL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("Comprar este kit");
        ArrayList descpyro = new ArrayList();
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    {
    ItemStack pyro = new ItemStack(Material.IRON_FENCE);
    ItemMeta metapyro = pyro.getItemMeta();
    metapyro.setDisplayName("§cGladiator");
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