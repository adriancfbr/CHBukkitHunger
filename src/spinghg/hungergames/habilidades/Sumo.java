 package spinghg.hungergames.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Sumo
 implements Listener
{
	  private libsHg pl;
	  
	  public Sumo(libsHg plugin)
	  {
	    this.pl = plugin;
	  }



public ArrayList<String> Cima = new ArrayList<String>();
  ArrayList<String> tempo = new ArrayList<String>();
  private ArrayList<Block> remover = new ArrayList<Block>();
  @SuppressWarnings("deprecation")
public static int Cu = Material.APPLE.getId();
  
  @EventHandler
  public void Morrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    this.tempo.remove(p.getName());
    this.Cima.remove(p.getName());
  }
  
  @EventHandler
  public void Sair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    this.tempo.remove(p.getName());
    this.Cima.remove(p.getName());
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void Clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p instanceof Player))
    {
    	if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Sumo"))) && (p.getItemInHand().equals(Integer.valueOf(Sumo.Cu)))) {
        return;
      }
      if (!e.getAction().name().contains("RIGHT")) {
        return;
      }
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Sumo"))) && (p.getItemInHand().getTypeId() != Sumo.Cu)) {
        return;
      }
      e.setCancelled(true);
      if (!this.tempo.contains(p.getName()))
      {
        Location Local = e.getPlayer().getLocation();
        Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 22.0D, 0.0D);
        for (int x = 0; x <= 0; x++) {
          for (int z = 0; z <= 0; z++)
          {
            final Block a = Local.add(x, 0.0D, z).getBlock();
            a.setType(Material.DIRT);
            e.getPlayer().teleport(Local.add(0.0D, 1.0D, 0.0D));
            this.tempo.add(p.getName());
            this.Cima.add(p.getName());
            Bukkit.getServer().getScheduler().runTaskLater(this.pl , new Runnable()
            {
              public void run()
              {
                a.setType(Material.AIR);
                Sumo.this.remover.remove(a);
              }
            }, 50L);
          }
        }
      }
      else
      {
        p.sendMessage("§cAguarde mais um pouco para usar sua habilidade !");
      }
    }
  }
  
  @EventHandler
  public void Cair(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    final Player p = (Player)e.getEntity();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Sumo"))) && (e.getCause() == EntityDamageEvent.DamageCause.FALL)) {
      if (this.Cima.contains(p.getName()))
      {
        e.setCancelled(true);
        for (Entity Altura : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
          if ((Altura instanceof Player))
          {
            Player Pular = (Player)Altura;
            Vector v = p.getLocation().getDirection().multiply(0).setY(2.0D);
            Pular.setVelocity(v);
          }
        }
        this.Cima.remove(p.getName());
        e.setDamage(9.0D);
        Bukkit.getServer().getScheduler().runTaskLater(this.pl, new Runnable()
        {
          public void run()
          {
            Sumo.this.tempo.remove(p.getName());
          }
        }, 600L);
        
        return;
      }
    }
  }
  @EventHandler
  public void onDamageBomber(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Sumo"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("hg.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Sumo (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Sumo", 1);
      }
    }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Sumo")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Sumo");
	    }

	    return false;
	  }
}