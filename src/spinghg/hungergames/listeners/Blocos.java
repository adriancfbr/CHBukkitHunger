package spinghg.hungergames.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.Coins.LojaListener;
import spinghg.hungergames.Menu.KitMenu;
import spinghg.hungergames.api.configs.Config;

public class Blocos
  implements Listener
{
  private libsHg pl;

  public Blocos(libsHg plugin)
  {
    this.pl = plugin;
  }

 
  @SuppressWarnings("unused")
@EventHandler
  public void onPlace(BlockPlaceEvent e) {
    Player player = e.getPlayer();
    if (this.pl.comecando)
      e.setCancelled(true);
  }

  @EventHandler
  public void onBreak(BlockBreakEvent e) {
    if (this.pl.comecando)
      e.setCancelled(true);
  }

  @EventHandler
  public void onBlockDamage(BlockDamageEvent e) {
    if (this.pl.comecando)
      e.setCancelled(true);
  }
  
  @SuppressWarnings("unused")
@EventHandler
  public void onPlaces(BlockPlaceEvent e) {
    Player player = e.getPlayer();
    if (this.pl.aguardando)
      e.setCancelled(true);
  }

  @EventHandler
  public void onBreaks(BlockBreakEvent e) {
    if (this.pl.aguardando)
      e.setCancelled(true);
  }

  @EventHandler
  public void onBlockDamages(BlockDamageEvent e) {
    if (this.pl.aguardando)
      e.setCancelled(true);
  }
  
  @EventHandler
  public void noPlace(BlockPlaceEvent e)
  {
	 if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if (e.getBlock().getType() == Material.CHEST)
      e.setCancelled(true);
	    if (e.getBlock().getType() == Material.MUSHROOM_SOUP)
	        e.setCancelled(true); 
  }
  
  @SuppressWarnings("static-access")
@EventHandler
  public void Soup(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (!this.pl.login.contains(p)) {
    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((p.getItemInHand().getType() == Material.MUSHROOM_SOUP) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (e.getAction() == Action.LEFT_CLICK_AIR) || 
      (e
      .getAction() == Action.LEFT_CLICK_BLOCK))){
      p.sendMessage(Config.getConfig(Config.ConfigFile.CONFIG).getString("soup").replace("&", "§"));
    }
    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
        if ((p.getItemInHand().getType() == Material.CHEST) && (
          (e.getAction() == Action.RIGHT_CLICK_AIR) || 
          (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
          (e.getAction() == Action.LEFT_CLICK_AIR) || 
          (e
          .getAction() == Action.LEFT_CLICK_BLOCK))) {
          KitMenu.guiKits(p);
        }
    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
        if ((p.getItemInHand().getType() == Material.EMERALD) && (
          (e.getAction() == Action.RIGHT_CLICK_AIR) || 
          (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
          (e.getAction() == Action.LEFT_CLICK_AIR) || 
          (e
          .getAction() == Action.LEFT_CLICK_BLOCK)))
        {
        	LojaListener.guiLoja(p);;
        }
    }
  }
  
  @SuppressWarnings("unused")
@EventHandler(priority=EventPriority.HIGHEST)
  public void onDrop(PlayerDropItemEvent e) {
    Player p = e.getPlayer();
    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    {
      e.setCancelled(true);
      return;
    }
  }
  
  @EventHandler
  public void onCreeperSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Creeper))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSkeletonSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Skeleton))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSpiderSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Spider))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onWitherSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Wither))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onZombieSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Zombie))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSlimeSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Slime))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onGhastSpawn(CreatureSpawnEvent e) {
    if ((e.getEntity() instanceof Ghast))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onPigZombieSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof PigZombie))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onEndermanSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Enderman))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onCaveSpiderSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof CaveSpider))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSilverfishSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Silverfish))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onBlazeSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Blaze))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onMagmaCubeSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof MagmaCube))
      e.setCancelled(true);
  }

  @EventHandler
  public void onWitchSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Witch))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSheepSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Sheep))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onCowSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Cow))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onChickenSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Chicken))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onSquidSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Squid))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onWolfSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Wolf))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onMooshroomSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof MushroomCow))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onOcelotSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Ocelot))
      e.setCancelled(true); 
  }

  @EventHandler
  public void onVillagerSpawn(CreatureSpawnEvent e) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    if ((e.getEntity() instanceof Villager))
      e.setCancelled(false);
  }
  
  
	@EventHandler
	public void onPickup(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando)) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
		}
	}

	  @SuppressWarnings("unused")
	@EventHandler
	  public void onPick23(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando)) {
	      event.setCancelled(true);
	  }
	  }
	  
	  
}