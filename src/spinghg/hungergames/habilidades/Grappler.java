package spinghg.hungergames.habilidades;

import java.util.HashMap;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.listeners.GrapplingHook;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.libsHg;

public class Grappler
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Grappler(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  private transient HashMap<Player, GrapplingHook> hooks = new HashMap();
  public String message = ChatColor.RED + 
    "Seu grappler ainda nao foi fisgado!";
  public boolean sound = true;
  
  @EventHandler
  public void onDamageArcher(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Grappler"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Grappler (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Grappler", 1);
      }
    }
    }
  }
  

  @EventHandler
  public void onSlot(PlayerItemHeldEvent e) { if (this.hooks.containsKey(e.getPlayer())) {
      ((GrapplingHook)this.hooks.get(e.getPlayer())).remove();
      this.hooks.remove(e.getPlayer());
    } }

  @EventHandler
  public void onLeash(PlayerLeashEntityEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if (((e.getEntity() instanceof Player)) && (this.hooks.containsKey(p)) && 
      ((Player)e.getEntity() == ((GrapplingHook)this.hooks.get(p)).owner)) {
      return;
    }
    if ((e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) && (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Grappler")))) {
      e.setCancelled(true);
      e.getPlayer().updateInventory();
      if (!this.hooks.containsKey(p)) {
        return;
      }
      if (!((GrapplingHook)this.hooks.get(p)).isHooked()) {
        return;
      }
      double d = ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
        .distance(p.getLocation());
      double t = d;
      double v_x = (1.0D + 0.04000000000000001D * t) * (
        ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
        .getX() - p.getLocation().getX()) / t;

      double v_z = (1.0D + 0.04000000000000001D * t) * (
        ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
        .getZ() - p.getLocation().getZ()) / t;
      if (p.isOnGround())
      {
        if (((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
          .getY() - 
          p.getLocation().getY() < 0.5D) {
          double v_y = 0.5D;
         
        }
      }
      double v_y;
      if (((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getY() - 
        p.getLocation().getY() < 0.5D)
        v_y = p.getVelocity().getY();
      else {
        v_y = (0.9D + 0.03D * t) * (
          (((GrapplingHook)this.hooks.get(p)).getBukkitEntity()
          .getLocation().getY() - p.getLocation()
          .getY()) / t);
      }

      Vector v = p.getVelocity();
      v.setX(v_x);
      v.setY(v_y);
      v.setZ(v_z);
      p.setVelocity(v);
      if (this.sound)
        p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0F, 
          1.0F);
    }
  }

  @EventHandler
  public void onClick(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if ((e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) && (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Grappler")))) {
      e.setCancelled(true);
      if ((e.getAction() == Action.LEFT_CLICK_AIR) || 
        (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
        if (this.hooks.containsKey(p)) {
          ((GrapplingHook)this.hooks.get(p)).remove();
        }
        GrapplingHook nmsHook = new GrapplingHook(p.getWorld(), 
          ((CraftPlayer)p).getHandle());
        nmsHook.spawn(p.getEyeLocation().add(
          p.getLocation().getDirection().getX(), 
          p.getLocation().getDirection().getY(), 
          p.getLocation().getDirection().getZ()));
        nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p
          .getLocation().getDirection().getY() * 5.0D, p
          .getLocation().getDirection().getZ() * 5.0D);
        this.hooks.put(p, nmsHook);
      } else {
        if (!this.hooks.containsKey(p)) {
          return;
        }
        if (!((GrapplingHook)this.hooks.get(p)).isHooked()) {
          p.sendMessage(this.message);
          GrapplingHook gh = (GrapplingHook)this.hooks.get(p);
          gh.move(gh.motX, gh.motY - 2.0D, gh.motY);
          return;
        }
        double d = ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
          .distance(p.getLocation());
        double t = d;
        double v_x = (1.0D + 0.04000000000000001D * t) * (
          ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
          .getX() - p.getLocation().getX()) / t;

        double v_z = (1.0D + 0.04000000000000001D * t) * (
          ((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
          .getZ() - p.getLocation().getZ()) / t;
        if (p.isOnGround())
        {
          if (((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
            .getY() - 
            p.getLocation().getY() < 0.5D) {
            double v_y = 0.5D;
            
          }
        }
        double v_y;
        if (((GrapplingHook)this.hooks.get(p)).getBukkitEntity().getLocation()
          .getY() - 
          p.getLocation().getY() < 0.5D)
          v_y = p.getVelocity().getY();
        else {
          v_y = (0.9D + 0.03D * t) * (
            (((GrapplingHook)this.hooks.get(p)).getBukkitEntity()
            .getLocation().getY() - p.getLocation()
            .getY()) / t);
        }

        Vector v = p.getVelocity();
        v.setX(v_x);
        v.setY(v_y);
        v.setZ(v_z);
        p.setVelocity(v);

        if (p.getLocation().getY() < ((GrapplingHook)this.hooks.get(p))
          .getBukkitEntity().getLocation().getY()) {
          p.setFallDistance(0.0F);
        }
        if (this.sound)
          p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 
            1.0F, 1.0F);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Grappler")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Grappler");
	    }

	    return false;
	  }
  
}
