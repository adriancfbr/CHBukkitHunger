package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class SerialKiller
implements Listener, CommandExecutor
{
private libsHg pl;
public static List<Player> Effect = new ArrayList<Player>();
  public SerialKiller(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageViper(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("SerialKiller"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - SerialKiller (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else {
    		  
    	  
        BossBar.setMessage(damager, p.getName() + " - SerialKiller", 1);
      }
      }
    }
  }
  
  public int chance = 31;
  public int length = 5;
  public int multiplier = 0;
  
  @EventHandler
  public void SnailDano(EntityDamageByEntityEvent e)
  {
	  if (this.pl.kit) 
	  if ((this.pl.comecou) || (this.pl.invencibilidade))
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      final Player d = (Player)e.getDamager();
      if ((this.pl.comecou) && 
        (this.pl.km.temKit(d)) && (this.pl.km.getPlayerKit(d, this.pl.km.getKitByName("SerialKiller"))))
      { 
    	  if (!this.Effect.contains(d)){
    	  this.Effect.add(d); 
    	  randomPotionEffect(p, 60, 160, 1, 3, PotionEffectType.POISON, PotionEffectType.CONFUSION, PotionEffectType.HUNGER, PotionEffectType.SATURATION, PotionEffectType.SLOW, PotionEffectType.WITHER, PotionEffectType.INCREASE_DAMAGE);
    	  } 
    	  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
	        {
	          public void run()
	          {
	        	  if (SerialKiller.this.Effect.contains(d)) {
	            SerialKiller.this.Effect.remove(d);
	            d.sendMessage("§6De um hit em alguem.");
	            }
	            
	          }
	        }, 250L);  
      }
    }
  }
  
  public void randomPotionEffect(Player player, int minDuration, int maxDuration,
		  int minAmplifier, int maxAmplifier, PotionEffectType... effects) {
		  Random rand = new Random();
		  PotionEffectType type = effects[rand.nextInt(effects.length)];
		   
		  int duration = rand.nextInt(maxDuration - minDuration + 1) + minDuration;
		   
		  int amplifier = rand.nextInt(maxAmplifier - minAmplifier + 1) + minAmplifier;
		   
		  player.addPotionEffect(new PotionEffect(type, duration, amplifier));
		  }
		   
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("SerialKiller")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit SerialKiller");
	    }

	    return false;
	  }
}
