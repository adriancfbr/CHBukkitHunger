package spinghg.hungergames.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Timelord
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Timelord(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public ArrayList<String> congelado = new ArrayList();
  public ArrayList<String> cooldown = new ArrayList();
  
  @EventHandler
  public void onDamageTimelord(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Timelord"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Timelord", 1);
    	  }
      }
    }
  }
  
  @EventHandler
  public void death(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    this.cooldown.remove(p.getName());
    this.congelado.remove(p.getName());
  }
  
  public void join(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    this.cooldown.remove(p.getName());
    this.congelado.remove(p.getName());
  }
  
  @EventHandler
  public void frozenClick(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (this.pl.kit) 
    if ((p.getItemInHand().getType() == Material.WATCH) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Timelord"))) && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)))
    {
      if (this.cooldown.contains(p.getName())) {
        p.sendMessage(ChatColor.GRAY + "§c espere antes de usar novamente!");
      }
      if (!this.cooldown.contains(p.getName())) {
        for (Entity en : p.getNearbyEntities(10.0D, 10.0D, 1.0D)) {
          if ((en instanceof Player))
          {
            final Player nearby = (Player)en;
            if ((nearby != null) && 
              (!this.congelado.contains(nearby.getName())))
            {
              this.congelado.add(nearby.getName());
              this.cooldown.add(p.getName());
              nearby.sendMessage("§77Timelord esta proximo!");
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 15);
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
              p.getWorld().playSound(p.getLocation(), Sound.WITHER_SHOOT, 10.0F, 1.0F);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
              {
                public void run()
                {
                  Timelord.this.congelado.remove(nearby.getName());
                }
              }, 100L);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
              {
                public void run()
                {
                  Timelord.this.cooldown.remove(p.getName());
                }
              }, 1000L);
            }
          }
        }
      }
    }
  }
  
  @EventHandler
  public void cancelMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if (this.congelado.contains(p.getName())) {
      e.setTo(p.getLocation());
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Timelord")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Timelord");
	    }

	    return false;
	  }
}
