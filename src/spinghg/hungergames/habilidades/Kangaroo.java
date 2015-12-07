package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Kangaroo
 implements Listener, CommandExecutor
{
  private libsHg pl;
  ArrayList<String> jumpa = new ArrayList();
  private HashMap<String, Integer> inta = new HashMap();
  
  public Kangaroo(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageKangaroo(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Kangaroo"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Kangaroo (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Kangaroo", 1);
      }
    }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    Block b = p.getLocation().getBlock();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Kangaroo"))) && 
      (p.getItemInHand().getType() == Material.FIREWORK))
    {
      e.setCancelled(true);
      if ((((Integer)this.inta.get(p.getName())).intValue() == 1) && (
        (e.getAction() == Action.RIGHT_CLICK_AIR) || 
        (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (e
        .getAction() == Action.LEFT_CLICK_BLOCK) || 
        (e
        .getAction() == Action.LEFT_CLICK_AIR) || 
        (e
        .getAction() == Action.RIGHT_CLICK_AIR)))
      {
        if ((b.getType() == Material.AIR) && 
          (b.getRelative(BlockFace.DOWN).getType() == Material.AIR)) {
          this.jumpa.contains(p.getName());
        }
        if ((((Integer)this.inta.get(p.getName())).intValue() == 1) && 
          (p.isSneaking()))
        {
          Vector v1 = p.getLocation().getDirection()
            .multiply(1.0D).setY(0.5D);
          p.setVelocity(v1);
          this.inta.put(p.getName(), Integer.valueOf(0));
        }
        this.jumpa.contains(p.getName());
        if ((((Integer)this.inta.get(p.getName())).intValue() == 1) && 
          (!p.isSneaking()))
        {
          Vector v2 = p.getLocation().getDirection()
            .multiply(0.3D).setY(0.85D);
          p.setVelocity(v2);
          this.inta.put(p.getName(), Integer.valueOf(0));
        }
      }
    }
  }
  
  @EventHandler
  public void fly(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    Block b = p.getLocation().getBlock();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Meteoro")))) {
    if (p.getInventory().contains(Material.FIREWORK)) {
      if (b.getRelative(BlockFace.DOWN).getType() == Material.AIR)
      {
        this.jumpa.add(p.getName());
      }
      else if ((b.getType() != Material.AIR) || 
        (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
      {
        this.inta.put(p.getName(), Integer.valueOf(1));
        this.jumpa.remove(p.getName());
      }
    }
    }
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = e.getEntity();
      if (this.pl.kit) 
      if ((!this.pl.km.temKit(p)) && (!this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Kangaroo")))) {
        return;
      }
      for (ItemStack item : e.getDrops()) {
        if (item.getType() == Material.FIREWORK) {
          item.setType(Material.AIR);
        }
      }
    }
  }
  
  @EventHandler
  public void reduceFallDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player player = (Player)e.getEntity();
      if (this.pl.kit) 
      if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Kangaroo")))) {
        return;
      }
      if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
      {
        EntityPlayer ep = ((CraftPlayer)player).getHandle();
        if (e.getDamage() > 0.5D) {
          e.setDamage(0.5D);
        }
        if ((ep.getHealth() <= 0.5F) && (e.getDamage() >= 0.5D))
        {
          e.setCancelled(true);
          ep.setHealth(0.5F);
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Kangaroo")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Kangaroo");
	    }

	    return false;
	  }
}
