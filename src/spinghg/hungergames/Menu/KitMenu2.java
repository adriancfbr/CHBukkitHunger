	

    package spinghg.hungergames.Menu;
     
    import spinghg.hungergames.libsHg;
    import spinghg.hungergames.habilidades.Bomber;
    import spinghg.hungergames.habilidades.Jumper;
    import spinghg.hungergames.habilidades.Sumo;
     
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
     
    public class KitMenu2
      implements Listener
    {
      public libsHg plugin;
     
      public KitMenu2(libsHg plugin)
      {
        this.plugin = plugin;
      }
     
      public static void p2(Player p)
      {
        Inventory inv = Bukkit.getServer().createInventory(p, 54, "§2Seus kits 2/2");
     
        ItemStack vidro = new ItemStack(Material.THIN_GLASS);
        ItemMeta metav = vidro.getItemMeta();
        metav.setDisplayName("");
        vidro.setItemMeta(metav);
       
       
        ItemStack meio = new ItemStack(289);
        ItemMeta metam = meio.getItemMeta();
        metam.setDisplayName("");
        meio.setItemMeta(metam);
        inv.setItem(0, meio);
       
        ItemStack nt = new ItemStack(264);
        ItemMeta nts = nt.getItemMeta();
        nts.setDisplayName("§a§oOutros Kits");
        nt.setItemMeta(nts);
        inv.setItem(0, nt);
       
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
        inv.setItem(6, nt);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
     
        if ((p.hasPermission("planeta.hg.kit.pyro")) || (p.hasPermission("planeta.vip")))
        {
          ItemStack pyro = new ItemStack(Material.FIREBALL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Pyro §6[Vip]");
          ArrayList descpyro = new ArrayList();
          descpyro.add(ChatColor.WHITE + "");
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Reaper")) || (p.hasPermission("planeta.vip")))
        {
            ItemStack pyro = new ItemStack(Material.WOOD_HOE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Reaper §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.TimeLord")) || (p.hasPermission("planeta.vip")))
        {
            ItemStack pyro = new ItemStack(Material.WATCH);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9TimeLord §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Berserker")) || (p.hasPermission("planeta.vip")))
        {
            ItemStack pyro = new ItemStack(Material.FIRE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Berserker §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Flash")) || (p.hasPermission("planeta.vip.mais")))
        {
            ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Flash §5[Vip+]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Burrower")) || (p.hasPermission("planeta.vip")))
        {
            ItemStack pyro = new ItemStack(Material.SLIME_BALL);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Burrower §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Blacksmith")) || (p.hasPermission("planeta.vip")))
        {
            ItemStack pyro = new ItemStack(Material.IRON_ORE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Blacksmith §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Hermit")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Hermit §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Confusion")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.BED);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Confusion §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.WeakHand")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.POTION);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9WeakHand §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Crafter")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.WORKBENCH);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Crafter §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.SerialKiller")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.BONE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9SerialKiller §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.LavaMan")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.LAVA);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9LavaMan §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.CookieMonster")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.COOKIE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9CookieMonster §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Tower")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.DIRT);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Tower §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Jumper")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Jumper.JumperItem);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Jumper §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Hungerly")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.WRITTEN_BOOK);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Hungerly §6[Vip]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Spirit")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Spirit §5[Vip+]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
            metapyro.setLore(descpyro);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
          }
        if ((p.hasPermission("planeta.hg.kit.Meteoro")) || (p.hasPermission("planeta.hg.kit.*")))
        {
            ItemStack pyro = new ItemStack(Material.TNT);
            ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GREEN + "§9Meteoro §5[Vip+]");
            ArrayList descpyro = new ArrayList();
            descpyro.add(ChatColor.WHITE + "");
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

