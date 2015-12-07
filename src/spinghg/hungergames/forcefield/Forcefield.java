package spinghg.hungergames.forcefield;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.BossBar;


public class Forcefield
 implements Listener
{
 private libsHg pl;
 public static ArrayList<Block> blockf = new ArrayList();

public Forcefield(libsHg plugin)
{
   this.pl = plugin;
  }


public boolean isPlayerFF(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 499) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 499);
}


public boolean isPlayerNearbyFF(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 499) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 499);
}

public boolean ffprotect(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 498) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 498);
}

public boolean ffprotect2(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 497) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 497);
}
public boolean ffprotect3(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 496) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 496);
}
public boolean ffprotect4(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 495) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 495);
}
public boolean ffprotect5(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 494) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 494);
}
public boolean ffprotect6(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 493) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 493);
}
public boolean ffprotect7(Player player)
{
  Location loc = player.getLocation();
  World w = player.getWorld();

  return (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 492) || 
    (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 492);
}
@EventHandler
public void ffprotect(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(isPlayerFF(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}

@EventHandler
public void ffprotect2(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect1(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect3(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect2(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect3(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect2(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect4(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect3(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect4(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect3(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect5(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect4(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect5(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect4(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect6(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect5(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect7(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect6(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect7(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect6(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect8(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (ffprotect7(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect8(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) &&(ffprotect7(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void ffprotect1(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.invencibilidade) && (isPlayerFF(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect1(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect3(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect2(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect3(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect2(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect4(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect3(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect4(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect3(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect5(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect4(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect5(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect4(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect6(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect5(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect7(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect6(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect7(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect6(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect8(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (ffprotect7(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
@EventHandler
public void f2protect8(BlockBreakEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) &&(ffprotect7(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos ou colocar perto forcefield!");
  }
}


@EventHandler
public void f2protect1(BlockPlaceEvent event)
{
  final Player player = event.getPlayer();
  if ((this.pl.comecou) && (isPlayerFF(player)))
  {
	  event.setCancelled(true);
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não pode quebrar blocos  ou colocar perto forcefield!");
  }
}
  @EventHandler
  public void onMoveFF(PlayerMoveEvent e)
  {
    final Player player = e.getPlayer();
    if ((this.pl.comecando) && 
      (isPlayerFF(player)))
    {
      int x = new Random().nextInt(50) + 400;
      int z = -(new Random().nextInt(30) + 300);
      
      Location loc = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z) + 30, z);
      
      player.teleport(loc);
      player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVoce chegou ao forcefield!");
    }
    if (this.pl.aguardando)
    {
        if (isPlayerNearbyFF(player)) {
    	 int x = new Random().nextInt(50) + 400;
         int z = -(new Random().nextInt(30) + 300);
         
         Location loc = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z) + 30, z);
         
         player.teleport(loc);
         player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVoce chegou ao forcefield!");
        }
    }
  if (this.pl.invencibilidade)
   {
    if (isPlayerNearbyFF(player)) {
     player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê esta no final do mundo!");
      }
   if (isPlayerFF(player))
{
      player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê esta no final do mundo!");
  
      new BukkitRunnable()
     {
          public void run()
           {
            if (!Forcefield.this.isPlayerFF(player)) {
               cancel();
           }
           EntityPlayer p = ((CraftPlayer)player).getHandle();
         if (p.getHealth() > 9.5F) {
           p.setHealth(p.getHealth() - 9.5F);
           int x = new Random().nextInt(50) + 400;
           int z = -(new Random().nextInt(30) + 300);
           Location loc = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z) + 30, z);
           
           player.teleport(loc);
           }
        }
       }.runTaskTimer(this.pl, 0L, 20L);
    }
     }
     if (this.pl.comecou)
    {
       if (isPlayerNearbyFF(player)) {
       player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê esta no final do mundo!");
       ((BlockBreakEvent) player).setCancelled(true);;
      }
       if (isPlayerFF(player))
      {
      player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê esta no final do mundo!");
      ((BlockBreakEvent) player).setCancelled(true);;
       
      new BukkitRunnable()
     {
           public void run()
          {
           if (!Forcefield.this.isPlayerFF(player)) {
            cancel();
            }
           player.damage(2.5D);
           player.closeInventory();
           BossBar.setMessage(player, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê esta no ForceField você pode morrer ai", 1);
           player.playSound(player.getLocation(), Sound.ANVIL_LAND, 4.0F, 4.0F);
           player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1, 3000000));
           player.getWorld().strikeLightning(player.getLocation());
          
        }
         }.runTaskTimer(this.pl, 0L, 20L);
       }
     }
  } 
}

