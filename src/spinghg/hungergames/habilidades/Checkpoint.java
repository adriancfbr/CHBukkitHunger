package spinghg.hungergames.habilidades;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Checkpoint
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Checkpoint(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  private HashMap<String, Location> register = new HashMap();
  
  @EventHandler
  public void onDamageCheckpoint(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Checkpoint"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Checkpoint (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Checkpoint", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onPlayerDropItemKit(PlayerDropItemEvent event)
  {
    Player p = event.getPlayer();
    Material item = event.getItemDrop().getItemStack().getType();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Checkpoint"))) && (item == Material.NETHER_FENCE)) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onPlayerDropItemKit1(PlayerDropItemEvent event)
  {
    Player p = event.getPlayer();
    Material item = event.getItemDrop().getItemStack().getType();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Checkpoint"))) && (item == Material.FLOWER_POT_ITEM)) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void BlockPlaceEvent(BlockPlaceEvent event)
  {
    Player player = event.getPlayer();
    Block block = event.getBlockPlaced();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Checkpoint"))) && (block.getType().equals(Material.NETHER_FENCE)))
    {
      this.register.put(player.getName(), block.getLocation());
      player.getWorld().strikeLightningEffect(block.getLocation());
      player.getWorld().playEffect(block.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
      player.getWorld().playEffect(block.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
      player.getWorld().playEffect(block.getLocation(), Effect.MOBSPAWNER_FLAMES, 9);
      player.sendMessage("§bVoce salvou um local!");
    }
  }
  
  @EventHandler
  public void PlayerInteractEvent(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    Block block = event.getClickedBlock();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Checkpoint"))) && (event.getMaterial() == Material.FLOWER_POT_ITEM) && (event.getAction() == Action.RIGHT_CLICK_AIR))
    {
      if ((event.getMaterial() == Material.FLOWER_POT_ITEM) && (event.getAction() == Action.RIGHT_CLICK_AIR) && 
        (!this.register.containsKey(player.getName())))
      {
        player.sendMessage("§cErro --> Você não salvou o local");
        return;
      }
      player.teleport((Location)this.register.get(player.getName()));
      Location loc = (Location)this.register.get(player.getName());
      loc.getBlock().setType(Material.AIR);
      this.register.remove(player.getName());
      player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0F, 100.0F);
      player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
      player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
      player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
      player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.NETHER_FENCE) });
      player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
      player.updateInventory();
    }
    else if ((event.getAction() == Action.LEFT_CLICK_BLOCK) && (block.getType().equals(Material.NETHER_FENCE)) && (this.register.containsKey(player.getName())))
    {
      player.getWorld().createExplosion(block.getLocation().add(0.0D, 1.0D, 0.0D), 0.0F);
      player.getWorld().createExplosion(block.getLocation().add(0.0D, 1.0D, 0.0D), 0.0F);
      block.setType(Material.AIR);
      player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.NETHER_FENCE) });
      this.register.remove(player.getName());
    }
  }
  
  @EventHandler
  public void OnPlace(BlockPlaceEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.kit) 
    if ((player.getItemInHand().getType() == Material.FLOWER_POT_ITEM) && (this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Checkpoint"))))
    {
      e.setCancelled(true);
      if (!this.register.containsKey(player.getName()))
      {
        player.sendMessage("§cErro --> Você não salvou o local");
        return;
      }
      player.teleport((Location)this.register.get(player.getName()));
      Location loc = (Location)this.register.get(player.getName());
      loc.getBlock().setType(Material.AIR);
      this.register.remove(player.getName());
      player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0F, 100.0F);
      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 9);
      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 9);
      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 9);
      player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.NETHER_FENCE) });
      player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 9);
      player.updateInventory();
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Checkpoint")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Checkpoint");
	    }

	    return false;
	  }
}
