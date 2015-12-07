	

    package spinghg.hungergames.Menu;
     
    import spinghg.hungergames.libsHg;
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
     
    public class KitMenu
      implements Listener
    {
      public libsHg plugin;
     
      public KitMenu(libsHg plugin)
      {
        this.plugin = plugin;
      }
     
      static ItemStack leftcarpet = new ItemStack(Material.CARPET, 1, (short) 8);
     
      public static void guiKits(Player p)
      {
        Inventory inv = Bukkit.getServer().createInventory(p, 54, "§2Seus kits 1/2");
     
       
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
        metaps.setDisplayName("§a§o-->");
        paginass.setItemMeta(metaps);
        inv.setItem(0, paginass);
       
        ItemStack paginas1 = new ItemStack(leftcarpet);
        ItemMeta metaps1 = paginass.getItemMeta();
        metaps1.setDisplayName("§a§o");
        paginas1.setItemMeta(metaps);
        inv.setItem(0, paginas1);
     
        inv.setItem(0, vidro);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, meio);
        inv.setItem(5, vidro);
        inv.setItem(6, nt);
        inv.setItem(7, vidro);
        inv.setItem(8, paginass);
     
        if ((p.hasPermission("planeta.hg.kit.archer")) || (p.hasPermission("planeta.membros")))
        {
          ItemStack pyro = new ItemStack(Material.BOW);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Archer §a[Gratis]");
          ArrayList descpyro = new ArrayList();
          descpyro.add(ChatColor.WHITE + "");
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.ninja")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.COMPASS);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Ninja §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.LumberJackL")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.WOOD_AXE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9LumberJack §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.poseidon")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.WATER);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Poseidon §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Achilles")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Achilles §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.cannibal")) || (p.hasPermission("planeta.membros")))
        {
          ItemStack pyro = new ItemStack(Material.ROTTEN_FLESH);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Cannibal §a[Gratis]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.specialist")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.BOOK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Specialist §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.endermage")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.PORTAL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Endermage §5[Gratis]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Phantom")) || (p.hasPermission("planeta.vip.mais")))
        {
          ItemStack pyro = new ItemStack(Material.FEATHER);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Phantom §5[Vip+]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Redstone")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Redstone §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.CheckPoint")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + " §9CheckPoint §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Vacuum")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Vacuum §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.stomper")) || (p.hasPermission("planeta.vip.mais")))
        {
          ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Stomper §5[Vip+]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.kangaroo")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.FIREWORK);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Kangaroo §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Cultivator")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.SAPLING);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Cultivator §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.thor")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.FIRE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Thor §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.anchor")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.ANVIL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Anchor §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.viper")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Viper §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.snail")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.SOUL_SAND);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Snail §5[Gratis]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.viking")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.GOLD_AXE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Viking §6[Vip]");
          ArrayList descpyro = new ArrayList();;
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.barbarian")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Barbarian §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.hulk")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.SADDLE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Hulk §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Worm")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.DIRT);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Worm §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Gladiator")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.IRON_FENCE);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Gladiator §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Fisherman")) || (p.hasPermission("planeta.hg.kit.*")))
        {
          ItemStack pyro = new ItemStack(Material.FISHING_ROD);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Fisherman §6[Vip]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Urgal")) || (p.hasPermission("planeta.vip.mais")))
        {
          ItemStack pyro = new ItemStack(Material.POTION);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Urgal §5[Vip+]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
        if ((p.hasPermission("planeta.hg.kit.Boxer")) || (p.hasPermission("planeta.membros")))
        {
          ItemStack pyro = new ItemStack(Material.STONE_SWORD);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName(ChatColor.GREEN + "§9Boxer §a[Gratis]");
          ArrayList descpyro = new ArrayList();
          metapyro.setLore(descpyro);
          pyro.setItemMeta(metapyro);
          inv.addItem(new ItemStack[] { pyro });
        }
            if ((p.hasPermission("planeta.hg.kit.Blink")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.NETHER_STAR);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Blink §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Demoman")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.GRAVEL);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Demoman §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Jellyfish")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.CLAY_BALL);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Jellyfish §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Miner")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Miner §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Tank")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyros = new ItemStack(Material.TNT);
              ItemMeta metapyros = pyros.getItemMeta();
              metapyros.setDisplayName(ChatColor.GREEN + "§9Tank §6[Vip]");
              ArrayList descpyros = new ArrayList();
              metapyros.setLore(descpyros);
              pyros.setItemMeta(metapyros);
              inv.addItem(new ItemStack[] { pyros });
            }
            if ((p.hasPermission("planeta.hg.kit.Rider")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.IRON_BARDING);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Rider §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Terrorist")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.LEVER);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + " §9Terrorist §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
         
            if ((p.hasPermission("planeta.hg.kit.Vampire")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.DOUBLE_PLANT);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Vampire §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Turtle")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.FLINT);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Turtle §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Camel")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.SAND);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Camel §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Fireman")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.LAVA);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Fireman §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Forge")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.COAL);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Forge §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Frosty")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Frosty §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Grandpa")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.STICK);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Grandpa §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Grappler")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.LEASH);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Grappler §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Thermo")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.DAYLIGHT_DETECTOR);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Thermo §6[Vip]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.Switcher")) || (p.hasPermission("planeta.mais.vip")))
            {
              ItemStack pyro = new ItemStack(Material.SNOW_BALL);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Switcher §5[Vip+]");
              ArrayList descpyro = new ArrayList();
              metapyro.setLore(descpyro);
              pyro.setItemMeta(metapyro);
              inv.addItem(new ItemStack[] { pyro });
            }
            if ((p.hasPermission("planeta.hg.kit.frozen")) || (p.hasPermission("planeta.hg.kit.*")))
            {
              ItemStack pyro = new ItemStack(Material.PACKED_ICE);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName(ChatColor.GREEN + "§9Frozen §6[Vip]");
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

