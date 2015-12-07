package spinghg.hungergames.habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Weakhand
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Weakhand(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public int chance = 4;
  public int length = 6;
  public int multiplier = 0;

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
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("weakhand"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - weakhand", 1);
      }
    }
  }}
  
  @EventHandler
  public void SnailDano(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if (this.pl.kit) 
      if ((this.pl.comecou) && 
        (this.pl.km.temKit(d)) && (this.pl.km.getPlayerKit(d, this.pl.km.getKitByName("weakhand"))))
      {
        Random rand = new Random();
        if (rand.nextInt(90) + 10 < 33) {
          p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 120, 2));
        }
      }
    }
  }

  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
    if (c.getName().equalsIgnoreCase("weakhand")) {
      Player p1 = (Player)p;
      p1.chat("/kit weakhand");
    }

    return false;
  }
}