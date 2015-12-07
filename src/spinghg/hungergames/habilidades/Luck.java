package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import spinghg.hungergames.libsHg;

public class Luck
  implements Listener
{
  final ArrayList<Player> cooldown = new ArrayList();
  static final ItemStack luckyitem = CriarItem("Lucky Block", Material.SPONGE);
  
  public Luck(libsHg main) {}
  
  @EventHandler
  public void playerInteract(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (e.getAction().name().contains("RIGHT"))
    {
      e.setCancelled(true);
      if (this.cooldown.contains(p))
      {;
      }
      int numerodecoisasquepodemacontencer = 9;
      int random = (int)(Math.random() * numerodecoisasquepodemacontencer);
      spawnRandomAcontecimentos(Integer.valueOf(random), p);
      this.cooldown.add(p);
    }
  }
  
  public static DyeColor getRandomDyeColor()
  {
    Random rand = new Random();
    return DyeColor.values()[rand.nextInt(DyeColor.values().length)];
  }
  
  public void spawnRandomAcontecimentos(Integer random, Player p)
  {
    if (random.equals(Integer.valueOf(1)))
    {
      for (int i = 0; i <= 9; i++)
      {
    	ItemStack iron = new ItemStack(Material.IRON_INGOT);
    	ItemMeta name = iron.getItemMeta();
    	name.setDisplayName("§4Luck Irons");
        Location item = p.getLocation();
        item.setY(p.getLocation().getY() + 30.0D);
        p.getWorld().dropItemNaturally(item, iron);
      }
    }
    else if (random.equals(Integer.valueOf(2)))
    {
      p.setHealth(1.0D);
    }
    else if (random.equals(Integer.valueOf(3)))
    {
      Wolf a = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
      Wolf b = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
      Wolf c = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
      Wolf d = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
      Wolf[] list = { a, b, c, d };
      Wolf[] arrayOfWolf1;
      int j = (arrayOfWolf1 = list).length;
      for (int i = 0; i < j; i++)
      {
        Wolf lobos = arrayOfWolf1[i];
        lobos.setTarget(p);
        lobos.damage(0.0D, p);
      }
    }
    else if (random.equals(Integer.valueOf(4)))
    {
      Wolf b = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
      b.setOwner(p);
      b.setTamed(true);
      b.setAdult();
      b.setCollarColor(getRandomDyeColor());
    }
    else if (random.equals(Integer.valueOf(5)))
    {
        Vector v1 = p.getLocation().getDirection().multiply(1.0D).setY(3.5D);
         p.setVelocity(v1);
        
    }
    else if (random.equals(Integer.valueOf(6)))
    {
      Zombie a = (Zombie)p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
      a.setCustomName("§c§lZOMBIE BOSS");
      a.setCustomNameVisible(true);
      a.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
      a.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
      a.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
      a.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
      a.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
    }
    else if (random.equals(Integer.valueOf(7)))
    {
        Zombie a = (Zombie)p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
        a.setCustomName("§c§lZOMBIE BOSS V2");
        a.setCustomNameVisible(true);
        a.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        a.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        a.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        a.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        a.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
        a.setMaxHealth(100);
        a.setHealth(100);
        a.damage(6);
        a.isBaby();
        a.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600000, 3));
        a.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600000, 2));
        a.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600000, 300000));
        a.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600000, 1));
    }
    else if (random.equals(Integer.valueOf(8)))
    {
      Location item = p.getLocation();
      item.setY(p.getLocation().getY() + 30.0D);
      Block a = item.getBlock();
      a.setType(Material.ANVIL);
    }
    else
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 2));
    }
  }
  
  public static ItemStack CriarItem(String nome, Material material)
  {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    return item;
  }
}
