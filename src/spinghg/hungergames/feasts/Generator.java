package spinghg.hungergames.feasts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import spinghg.hungergames.listeners.BossBar;

 public class Generator
  extends Feast
  implements Listener
 {
   private libsHg pl;
  private int taskFeast;
  public List<Location> feastBlocks = new ArrayList();
  
 public Generator(libsHg plugin)
   {
    this.pl = plugin;
}

  public void generateFeast(Location loc)
{
   String world = Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo");
   Integer r = Integer.valueOf(20);
     for (double x = -r.intValue(); x <= r.intValue(); x += 1.0D) {
      for (double z = -r.intValue(); z <= r.intValue(); z += 1.0D)
      {
        Location l = new Location(Bukkit.getWorld(world), loc.getX() + x, loc.getY(), loc.getZ() + z);
         if (l.distance(loc) <= r.intValue())
      {
        removeAbove(l.getBlock());
       l.getBlock().setType(Material.GRASS);
          this.feastBlocks.add(l.getBlock().getLocation());
     }
     }
   }
  }

  @EventHandler
   public void onBreak(BlockBreakEvent e)
  {
    Block b = e.getBlock();
   if (this.feastBlocks.contains(b.getLocation())) {
      e.setCancelled(true);
 }
}
 
  @EventHandler
   public void onDamageBlock(BlockDamageEvent e)
   {
  Block b = e.getBlock();
    if (this.feastBlocks.contains(b.getLocation())) {
    e.setCancelled(true);
  }
  }
 
@EventHandler
   public void onDamageBlock2(BlockPlaceEvent e)
  {
  Block b = e.getBlock();
   if (this.feastBlocks.contains(b.getLocation())) {
    e.setCancelled(true);
   }
 }
  
 public void prepareFeast(final Location loc)
 {
 generateFeast(loc);
  
   this.taskFeast = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.pl, new Runnable()
     {
   int time = 301;
   
  public void run()
  {
      this.time -= 1;
     switch (this.time)
   {
        case 300: 
((World)Bukkit.getServer().getWorlds().get(0)).setTime(0L);
      Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Feast ira spawnar nas coordenadas (%s, %s, %s) em 5 minutos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
         break;
     case 240: 
         Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Feast ira spawnar nas coordenadas (%s, %s, %s) em 4 minutos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
         break;
     case 180: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Feast ira spawnar nas coordenadas (%s, %s, %s) em 3 minutos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
     break;
       case 120: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Feast ira spawnar nas coordenadas (%s, %s, %s) em 2 minutos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
     break;
    case 60: 
    Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Feast ira spawnar nas coordenadas (%s, %s, %s) em 1 minuto", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
        break;
    case 30: 
      Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 30 segundo", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
         break;
        case 15: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 15 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
          break;
       case 10: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 10 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
        for (Player online : Bukkit.getOnlinePlayers()) {
            BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:10 ", 1);
          }
         break;
       case 9: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:09", 1);
             }
            break;
       case 8: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:08", 1);
             }
            break;
       case 7: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:07", 1);
             }
            break;
       case 6: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:06", 1);
             }
            break;
       case 5: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 5 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:05", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 4: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 4 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:04", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 3: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 3 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:03", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 2: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 2 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:02", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 1: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cFeast ira spawnar nas coordenadas (%s, %s, %s) em 1 segundos", new Object[] { Integer.valueOf(loc.getBlockX()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lFeast vai aparecer em: 00:01", 1);
             }
            break;
      case 0: 
          for (Player online : Bukkit.getOnlinePlayers()) {
              BossBar.setMessage(online, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6§o§lFeast apareceu!", 1);
              online.playSound(online.getLocation(), Sound.WITHER_SPAWN, 10.0F, 1.0F);
            }
         Generator.this.spawnChests(loc);
         Generator.this.feastBlocks.clear();
      Bukkit.getScheduler().cancelTask(Generator.this.taskFeast);
  }
      }
    }, 0L, 20L);
   }
  
 public Location getRandomLoc(World w)
 {
   Random r = new Random();
int x = r.nextBoolean() ? -(r.nextInt(30) + 50) : r.nextInt(30) + 50;
  int z = r.nextBoolean() ? -(r.nextInt(30) + 50) : r.nextInt(30) + 50;
  
     Location loc = new Location(w, x, w.getHighestBlockYAt(x, z), z);
  
   return loc;
  }
 
   public void removeAbove(Block block)
  {
  Location loc = block.getLocation();
   loc.setY(loc.getY() + 5.0D);
    Block newBlock = ((World)Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
  while (loc.getY() < ((World)Bukkit.getServer().getWorlds().get(0)).getMaxHeight())
  {
  newBlock.setType(Material.AIR);
   loc.setY(loc.getY() + 20.0D);
     newBlock = ((World)Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
     }
   }
 
  public void spawnChests(Location loc)
  {
     loc.add(-3.0D, 1.0D, -3.0D);
   
Integer[] co = { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-2) };
   for (Integer i : co)
 {
   Material m = Material.AIR;
switch (i.intValue())
     {
     case 0: 
      m = Material.AIR;
     loc.getBlock().setType(m);
      break;
    case 1: 
    m = Material.GRASS;
    loc.getBlock().setType(m);
     break;
    case 2: 
     m = Material.CHEST;
    loc.getBlock().setType(m);
     Chest chest = (Chest)loc.getBlock().getState();
  RandomItems.fillChest(chest, RandomItems.getRandom(Config.getConfig(Config.ConfigFile.FEAST).getStringList("Items")));
   break;
  case 3: 
    m = Material.ENCHANTMENT_TABLE;
     loc.getBlock().setType(m);
     Bukkit.getServer().broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cO Feast spawnou em -> (%s, %s, %s)", new Object[] { Integer.valueOf(loc.getBlockZ()), Integer.valueOf(loc.getBlockY()), Integer.valueOf(loc.getBlockZ()) }));
   }
if (i.intValue() == -1)
{
  loc.add(0.0D, 0.0D, 1.0D);
  loc.subtract(7.0D, 0.0D, 0.0D);
}
else if (i.intValue() == -2)
{
  loc.add(0.0D, 1.0D, 0.0D);
  loc.subtract(7.0D, 0.0D, 6.0D);
}
else if (i.intValue() == 5)
{
  loc.add(1.0D, 0.0D, 0.0D);
}
else
{
  loc.getBlock().setType(m);
  loc.add(1.0D, 0.0D, 0.0D);
}
  }
  } }
