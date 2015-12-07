package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Rider
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Rider(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageRider(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Rider"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Rider (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Rider", 1);
      }
    }
    }
  }
  
  public int horseHealth = 100;
  private String horseName = "Cavalo de %s";
  private HashMap<Player, Horse> horses = new HashMap();
  private double jumpStrength = 1.5D;
  private boolean modifyHorseStats = true;
  private boolean nameHorse = true;
  private boolean preventOthersFromUsing = true;
  private String saddleName = "Rider";
  
  @EventHandler
  public void onPlayerDropItemKit(PlayerDropItemEvent event)
  {
    Player p = event.getPlayer();
    Material item = event.getItemDrop().getItemStack().getType();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Rider"))) && (item == Material.SADDLE)) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onClick(InventoryClickEvent event)
  {
	  if (this.pl.kit) 
    if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() == Material.SADDLE) && 
      (event.getWhoClicked().getVehicle() != null) && 
      (this.horses.containsValue(event.getWhoClicked().getVehicle()))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event)
  {
	  if (this.pl.kit) 
    if (this.horses.containsValue(event.getEntity()))
    {
      event.setDroppedExp(0);
      event.getDrops().clear();
      Iterator<Player> itel = this.horses.keySet().iterator();
      while (itel.hasNext()) {
        if (this.horses.get(itel.next()) == event.getEntity())
        {
          itel.remove();
          break;
        }
      }
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
	  if (this.pl.kit) 
    if ((event.getAction().name().contains("RIGHT")) && (event.getMaterial() == Material.SADDLE))
    {
      Player p = event.getPlayer();
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Rider")))) {
        if (this.horses.containsKey(p))
        {
          Horse horse = (Horse)this.horses.remove(p);
          if (!horse.isDead())
          {
            horse.eject();
            horse.leaveVehicle();
            horse.remove();
          }
        }
        else
        {
          Horse horse = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
          this.horses.put(p, horse);
          if (this.nameHorse)
          {
            horse.setCustomName(String.format(this.horseName, new Object[] { p.getName() }));
            horse.setCustomNameVisible(true);
          }
          horse.setBreed(false);
          horse.setTamed(true);
          horse.setDomestication(horse.getMaxDomestication());
          horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
          
          horse.setOwner(p);
          if (this.modifyHorseStats)
          {
            horse.setJumpStrength(this.jumpStrength);
            horse.setMaxHealth(this.horseHealth);
            horse.setHealth(this.horseHealth);
            horse.setColor(Horse.Color.WHITE);
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onRightClick(PlayerInteractEntityEvent event)
  {
	  if (this.pl.kit) 
    if ((this.preventOthersFromUsing) && 
      (this.horses.containsValue(event.getRightClicked()))) {
      for (Player p : this.horses.keySet()) {
        if ((this.horses.get(p) == event.getRightClicked()) && 
          (event.getPlayer() != p))
        {
          event.setCancelled(true);
          break;
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Rider")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Rider");
	    }

	    return false;
	  }
}
