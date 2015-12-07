package spinghg.hungergames.feasts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.BossBar;
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

public class Finalizandosv
 implements Listener
{
private libsHg pl;
private int taskFeast;
public List<Location> feastBlocks = new ArrayList();

 public Finalizandosv(libsHg plugin)
  {
   this.pl = plugin;
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
  
 public void prepareFeast()
 {
  
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
      Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciar em 5 minutos."));
         break;
     case 240: 
         Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 4 minutos"));
         break;
     case 180: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 3 minutos"));
     break;
       case 120: 
    	   Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 2 minutos"));
     break;
    case 60: 
    Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 1 minuto"));
        break;
    case 30: 
      Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 30 segundo"));
         break;
        case 15: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 15 segundos"));
          break;
       case 10: 
        Bukkit.broadcastMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cServidor vai reiniciarem 10 segundos"));
        for (Player online : Bukkit.getOnlinePlayers()) {
            BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:10 ", 1);
          }
         break;
       case 9: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:09", 1);
             }
            break;
       case 8: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:08", 1);
             }
            break;
       case 7: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:07", 1);
             }
            break;
       case 6: 
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:06", 1);
             }
            break;
       case 5: 
    	   Bukkit.broadcastMessage(String.format("§cServidor vai reiniciarem 5 segundos"));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:05", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 4: 
    	   Bukkit.broadcastMessage(String.format("§cServidor vai reiniciarem 4 segundos"));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:04", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 3: 
    	   Bukkit.broadcastMessage(String.format("§cServidor vai reiniciarem 3 segundos"));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:03", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 2: 
    	   Bukkit.broadcastMessage(String.format("§cServidor vai reiniciarem 2 segundos"));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:02", 1);
               online.playSound(online.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
             }
            break;
       case 1: 
    	   Bukkit.broadcastMessage(String.format("§cServidor vai reiniciarem 1 segundos"));
           for (Player online : Bukkit.getOnlinePlayers()) {
               BossBar.setMessage(online, "§6§o§lServidor vai reiniciar em: 00:01", 1);
             }
            break;
      case 0: 
    	  Bukkit.getServer().shutdown();
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
   loc.setY(loc.getY() + 1.0D);
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
