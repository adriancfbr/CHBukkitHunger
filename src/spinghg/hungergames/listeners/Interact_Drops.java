package spinghg.hungergames.listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import spinghg.hungergames.libsHg;

public class Interact_Drops
  implements Listener
{
  private libsHg pl;
  
  public Interact_Drops(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.comecando) && (this.pl.aguardando) &&
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.comecando) && (this.pl.aguardando) &&
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPickup(PlayerPickupItemEvent event)
  {
    if ((this.pl.comecando) || (this.pl.aguardando)){
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPickUp(PlayerPickupItemEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.admins.contains(player)) && 
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInteractYoutuber(PlayerInteractEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.admins.contains(player)) && 
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDropYoutuber(PlayerDropItemEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.admins.contains(player)) && 
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPickUpYoutuber(PlayerPickupItemEvent e)
  {
    Player player = e.getPlayer();
    if ((this.pl.admins.contains(player)) && 
      (!player.hasPermission("planeta.op"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInvetoryOpenYoutuber1(InventoryOpenEvent e)
  {
    if ((this.pl.admins.contains(e.getPlayer())) && 
      (!e.getPlayer().hasPermission("planeta.staff"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInvetoryOpenYoutuber2(InventoryInteractEvent e)
  {
    if ((this.pl.admins.contains(e.getWhoClicked())) && 
      (!e.getWhoClicked().hasPermission("planeta.staff"))) {
      e.setCancelled(true);
    }
  }

  @SuppressWarnings("static-access")
@EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerMoves(PlayerMoveEvent event) {
   
	  Player p = event.getPlayer();
    if ((!this.pl.vivos.contains(p)) && (!this.pl.login.contains(p)))
    {
	  for (int i = 0; i < 1; i++) {
    	  List<Entity> entities = p.getNearbyEntities(i, i, i);
          for (Entity e : entities) {
        if (e.getType().equals(EntityType.PLAYER)) { 
        p.teleport(p.getLocation().add(0.0D, 10.0D, 0.0D));
        p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cEspectadores não podem chegar muito perto");
        p.setAllowFlight(true);
        p.getWorld().playEffect(((Player)e).getLocation(), Effect.STEP_SOUND, Material.BEDROCK, 90);
        p.playSound(((Player)e).getLocation(), Sound.BLAZE_BREATH, 1.0F, 1.0F);

        p.setFlying(true);
      }
    }
    }
    }
  }
}
