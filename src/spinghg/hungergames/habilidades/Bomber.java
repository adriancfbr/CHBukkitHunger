package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.listeners.Efeitos;

public class Bomber
implements Listener
{
  private libsHg pl;
  
  public Bomber(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  HashMap<String, Location> bloco = new HashMap<String, Location>();
  ArrayList<String> blococooldown = new ArrayList<String>();
  public static ArrayList<String> cooldown = new ArrayList<String>();
  @SuppressWarnings("deprecation")
public static int BomberItem = Material.FLOWER_POT_ITEM.getId();
  @SuppressWarnings("deprecation")
public static int Bomber2Item = Material.STONE_BUTTON.getId();
  
  
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
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Bomber"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Bomber (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Bomber", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void ColocaBomba(BlockPlaceEvent event)
  {
    Player p = event.getPlayer();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Bomber")))&& ((p.getInventory().contains(Material.FLOWER_POT_ITEM)) && 
      (event.getPlayer().getItemInHand().getType() == Material.FLOWER_POT_ITEM))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void ColocaBomba2(BlockPlaceEvent event)
  {
    Player p = event.getPlayer();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Bomber")))    && ((p.getInventory().contains(Material.FLOWER_POT_ITEM)) && 
      (event.getPlayer().getItemInHand().getType() == Material.STONE_BUTTON))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void Cancela(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Bomber")))    &&  (((p instanceof Player)) && 
      (p.getInventory().contains(Material.FLOWER_POT_ITEM)) && 
      (p.getItemInHand().getType() == Material.FLOWER_POT_ITEM))) {
      event.setCancelled(true);
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void Bomberr(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((p instanceof Player))
    {
    	if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Bomber")))    && ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && 
    		      (p.getItemInHand().getTypeId() == Bomber.BomberItem)))
      {
      }
        event.setCancelled(true);
        Location loc = new Location(p.getWorld(), event.getClickedBlock().getLocation().getX(), event.getClickedBlock().getLocation().getY() + 1.0D, event.getClickedBlock().getLocation().getZ());
        if (loc.getBlock().getType() == Material.AIR)
        {
          if (this.bloco.containsKey(p.getName())) {
            this.bloco.remove(p.getName());
          }
          this.bloco.put(p.getName(), loc);
          ((Location)this.bloco.get(p.getName())).getBlock().setType(Material.FLOWER_POT);
          p.getWorld().playSound(p.getLocation(), Sound.STEP_STONE, 50.0F, 50.0F);
          p.sendMessage("§6-> §bBomba armada!");
          this.blococooldown.add(p.getName());
          final ItemStack botao = new ItemStack(Bomber.Bomber2Item);
          Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
          {
            public void run()
            {
              p.setItemInHand(botao);
            }
          }, 2L);
        }
        else
        {
          p.sendMessage("§cVocê não pode por aqui.");
        }
      }
      if (p.getItemInHand().getTypeId() == Bomber.Bomber2Item)
      {
        if (cooldown.contains(p.getName()))
        {
          p.sendMessage("§cAguarde o cooldown acabar !");
          return;
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
          }
        }, 200L);
      
        cooldown.add(p.getName());
        Location loc1 = (Location)this.bloco.get(p.getName());
        loc1.getBlock().setType(Material.AIR);
        p.getWorld().createExplosion(loc1, 4.0F);
        this.blococooldown.remove(p.getName());
        final ItemStack flower = new ItemStack(Bomber.BomberItem);
        Efeitos.HUGE_EXPLOSION.display(1, 0, 1, 10, 10, loc1, 15);
        p.sendMessage("§6-> §bBomba detonada !");
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            p.setItemInHand(flower);
          }
        }, 2L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            Bomber.cooldown.remove(p.getName());
          }
        }, 200L);
      }
    }
  
    

  
    @EventHandler
    public void Morrer(PlayerDeathEvent e) {
    	 Player p = e.getEntity();
    	 if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Bomber"))))
         {
    	 Location loc1 = (Location)this.bloco.get(p.getName());
         loc1.getBlock().setType(Material.AIR);
    }
    }
    public boolean onCommand(CommandSender p, Command c, String label, String[] args)
    {
  	    if (c.getName().equalsIgnoreCase("Bomber")) {
  	      Player p1 = (Player)p;
  	      p1.chat("/kit Bomber");
  	    }

  	    return false;
  	  }
}