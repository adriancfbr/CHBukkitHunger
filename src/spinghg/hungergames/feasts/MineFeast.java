package spinghg.hungergames.feasts;

import java.text.DecimalFormat;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

public class MineFeast
implements Listener
{
 private libsHg pl;

 public MineFeast(libsHg plugin)
 {
  this.pl = plugin;
}
  


 public static void spawnmf(Location loc)
 {
  World spawnmf = loc.getWorld();
  
  double x = (int)(2.0D + Math.random() * 90.0D);
  double z = (int)(2.0D + Math.random() * 90.0D);
  double loc1 = x;
  double loc2 = z;
  int y = 0;
      {
        Block b = loc.clone().add(x, 0.0D, z).getBlock();
        Block b2 = loc.clone().add(x, 50.0D, z).getBlock();
        Block b3 = loc.clone().add(-50.0D, y, z).getBlock();
        Block b4 = loc.clone().add(x, y, -50.0D).getBlock();
        Block b5 = loc.clone().add(x, y, 50.0D).getBlock();
        Block b6 = loc.clone().add(50.0D, y, z).getBlock();

        b.setType(Material.AIR);
        b2.setType(Material.AIR);
        b3.setType(Material.AIR);
        b4.setType(Material.AIR);
        b5.setType(Material.AIR);
        b6.setType(Material.AIR);
      }
  
  Location enchant = new Location(spawnmf, x, loc.getY()+2, z);
  
  Location chest1 = new Location (spawnmf, x+1, loc.getY()+2, z-1);
  
  Location chest2 = new Location (spawnmf, x+1, loc.getY()+2, z+1);
  
  Location chest3= new Location (spawnmf, x-1, loc.getY()+2, z-1);
  
  Location chest4 = new Location (spawnmf, x-1, loc.getY()+2, z+1);
  
  Location vidro = new Location(spawnmf, x+1, loc.getY()+1, z+1);
  
  Location vidro1 = new Location (spawnmf, x-1, loc.getY()+1, z-1);
  
  Location vidro2 = new Location (spawnmf, x-1, loc.getY()+1, z+1);
  
  Location vidro3= new Location (spawnmf, x+1, loc.getY()+1, z-1);
  
  Location vidro4 = new Location (spawnmf, x-1, loc.getY()+1, z+1);
  
  Location vidro5 = new Location (spawnmf, x+1, loc.getY()+1, z);
  
  Location vidro6 = new Location (spawnmf, x-1, loc.getY()+1, z);
  
  Location vidro7= new Location (spawnmf, x, loc.getY()+1, z+1);
  
  Location vidro8 = new Location (spawnmf, x, loc.getY()+1, z-1);
  
  Location vidro9 = new Location (spawnmf, x, loc.getY()+1, z);
 
  chest4.getBlock().setType(Material.CHEST);
  chest3.getBlock().setType(Material.CHEST);
  chest2.getBlock().setType(Material.CHEST);
  chest1.getBlock().setType(Material.CHEST);
  enchant.getBlock().setType(Material.ENCHANTMENT_TABLE);
  vidro4.getBlock().setType(Material.GLASS);
  vidro3.getBlock().setType(Material.GLASS);
  vidro2.getBlock().setType(Material.GLASS);
  vidro1.getBlock().setType(Material.GLASS);
  vidro5.getBlock().setType(Material.GLASS);
  vidro6.getBlock().setType(Material.GLASS);
  vidro7.getBlock().setType(Material.GLASS);
  vidro8.getBlock().setType(Material.GLASS);
  vidro9.getBlock().setType(Material.GLASS);
  vidro.getBlock().setType(Material.GLASS);
  
  Chest c1 = (Chest)chest4.getBlock().getState();
 RandomItems.fillChest(c1, RandomItems.getRandom(Config.getConfig(Config.ConfigFile.MINEFEAST).getStringList("Items")));
 
 Chest c2 = (Chest)chest3.getBlock().getState();
 RandomItems.fillChest(c2, RandomItems.getRandom(Config.getConfig(Config.ConfigFile.MINEFEAST).getStringList("Items")));
 
 Chest c3 = (Chest)chest2.getBlock().getState();
 RandomItems.fillChest(c3, RandomItems.getRandom(Config.getConfig(Config.ConfigFile.MINEFEAST).getStringList("Items")));
 
 Chest c4 = (Chest)chest1.getBlock().getState();
 RandomItems.fillChest(c4, RandomItems.getRandom(Config.getConfig(Config.ConfigFile.MINEFEAST).getStringList("Items")));
  
   DecimalFormat df = new DecimalFormat("##");
   Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Um mini feast spawnou entre X: ( 150 e -190 ) e Z: ( 100 e -125 ) Y: " + loc.getY());
   libsHg.logger.log(Level.WARNING,"[Mine-Feast] Cordenadas " + " " + x + " " + loc.getY() + " " + z);
}
 
}