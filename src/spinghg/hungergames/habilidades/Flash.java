package spinghg.hungergames.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Flash
 implements Listener, CommandExecutor
{
private libsHg pl;
  
  public Flash(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageFisherman(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Flash"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Flash (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Flash", 1);
      }
      	  }
    }
  }
  ArrayList<Player> Flashcd = new ArrayList();
  
  @EventHandler
  public void onFlash(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ( 
      (p.getInventory().getItemInHand().getType() == Material.REDSTONE_TORCH_ON) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Flash"))))
    {
      e.setCancelled(true);
      if (this.Flashcd.contains(p))
      {
        p.sendMessage("§cVocê deve esperar para usar isso novamente!");
      }
      else
      {
        Location loc = e.getPlayer().getTargetBlock(null, 100).getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();
        Location loc2 = new Location(e.getPlayer().getWorld(), x, y, z);
        if (loc2.getBlock().getType() != Material.AIR) {
          loc2.setY(y + 2.5D);
        }
        if (loc.getBlock().getType() == Material.AIR)
        {
          p.sendMessage("§cVocê não está olhando para um bloco");
          return;
        }
        if (loc2.distance(e.getPlayer().getLocation()) > 30)
        {
          p.sendMessage("§cVocê não pode se teletransportar tão longe.");
          return;
        }
        final int s = p.getInventory().getHeldItemSlot();
        p.teleport(loc);
        int distance = (int)(p.getLocation().distance(loc) / 2.0D);
        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, distance, 0));
        loc.add(0.0D, 4.0D, 0.0D);
        Bukkit.getServer().getWorld(p.getWorld().getName()).strikeLightning(loc);
        p.getInventory().setItemInHand(new ItemStack(Material.REDSTONE_TORCH_OFF));
        this.Flashcd.add(p);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            Flash.this.Flashcd.remove(p);
            p.getInventory().setItem(s, new ItemStack(Material.REDSTONE_TORCH_ON));
          }
        }, 500L);
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Flash")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Flash");
	    }

	    return false;
	  }
}
