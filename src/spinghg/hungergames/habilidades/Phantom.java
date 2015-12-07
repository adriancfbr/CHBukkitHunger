package spinghg.hungergames.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Phantom
 implements Listener, CommandExecutor
{
  private ArrayList<String> cooldown = new ArrayList();
  private libsHg pl;
  
  public Phantom(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamagePhantom(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Phantom"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Phantom (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Phantom", 1);
      }
    }
  }
  }
  
  @EventHandler
  public void death(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (this.cooldown.contains(p.getName())) {
      this.cooldown.remove(p.getName());
    }
  }
  
  @EventHandler
  public void death(PlayerRespawnEvent e)
  {
    Player p = e.getPlayer();
    if (this.cooldown.contains(p.getName())) {
      this.cooldown.remove(p.getName());
    }
  }
  
  @EventHandler
  public void interact(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.FEATHER) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Phantom")))) {
      if (this.cooldown.contains(p.getName())) {
        p.sendMessage("§c§oModo Fly esta em Cooldown!");
      } else {
        for (Entity en : p.getNearbyEntities(25.0D, 25.0D, 25.0D)) {
          if ((en instanceof Player))
          {
            Player nearby = (Player)en;
            if (nearby != null) {
              p.setAllowFlight(true);
            }
            p.setFlying(true);
            nearby.sendMessage("§9§oUm Phantom esta proximo!");
            nearby.sendMessage("§cO Phantom esta voando [Ele não é hack Fly]");
            p.sendMessage("§c§oModo Fly ativo!");
            p.getWorld().playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0F, 1.0F);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 150, 3));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
            this.cooldown.add(p.getName());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
            {
              public void run()
              {
                p.setFlying(false);
                p.setAllowFlight(false);
                p.getWorld().playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0F, 1.0F);
                BossBar.setMessage(p, ChatColor.RED + "§c§oSeu tempo acabou!", 5);
              }
            }, 100L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
            {
              public void run()
              {
                p.getWorld().playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
                Phantom.this.cooldown.remove(p.getName());
              }
            }, 250L);
          }
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Phantom")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Phantom");
	    }

	    return false;
	  }
}
