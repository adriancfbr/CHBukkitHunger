package spinghg.hungergames.habilidades;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Berserker
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Berserker(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  private HashMap<String, Location> register = new HashMap();
  
  @EventHandler
  public void onDamageBerserker(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Berserker"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Berserker (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Berserker", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onBerserker1(PlayerDeathEvent event)
  {
    Player p = event.getEntity().getKiller();
    if (this.pl.kit) 
    if (((p instanceof Player)) && ((event.getEntity() instanceof Player)) && (this.pl.comecou) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Berserker"))))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1));
      p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 1));
      p.sendMessage("§c***SANGUE***");
    }
  }
  
  @EventHandler
  public void onBerserker2(EntityDeathEvent event)
  {
    Player p = event.getEntity().getKiller();
    if (this.pl.kit) 
    if (((p instanceof Player)) && (this.pl.comecou) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Berserker"))))
    {
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Berserker")))) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
      }
      p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));
      p.sendMessage("§c***SANGUE***");
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Berserker")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Berserker");
	    }

	    return false;
	  }
}
