package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class CookieMonster
  implements CommandExecutor, Listener
{
  public int delayInMillisecondsBetweenCookies = 500;
  private HashMap<Player, Long> cookieExpires = new HashMap();
  public int oneChanceInWhatOfCookies = 4;
  private libsHg pl;
  
  public CookieMonster(libsHg plugin)
  {
    this.pl = plugin;
  }
  @EventHandler
  public void onDamageSnail(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("CookieMonster"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - CookieMonster (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - CookieMonster", 1);
      }
    }
  }
  }
  
  @EventHandler
  public void onChomp(PlayerInteractEvent event)
  {
    if (event.getAction().name().contains("RIGHT"))
    {
      Player p = event.getPlayer();
      if (this.pl.comecou) {
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("CookieMonster"))) && 
        ((!this.cookieExpires.containsKey(p)) || (((Long)this.cookieExpires.get(p)).longValue() < System.currentTimeMillis())) && 
         (event.getItem() != null) && (event.getItem().getType() == Material.COOKIE))
      {
        event.setCancelled(true);
        if (((CraftPlayer)p).getHealth() < 20.0D)
        {
          double hp = ((CraftPlayer)p).getHealth() + 1.0D;
          if (hp > 20.0D) {
            hp = 20.0D;
          }
          p.setHealth(hp);
        }
        else if (p.getFoodLevel() < 20)
        {
          p.setFoodLevel(p.getFoodLevel() + 1);
        }
        else
        {
          p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1), true);
          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1), true);
        }
        event.getItem().setAmount(event.getItem().getAmount() - 1);
        if (event.getItem().getAmount() == 0) {
          p.setItemInHand(new ItemStack(0));
        }
        this.cookieExpires.put(p, Long.valueOf(System.currentTimeMillis() + this.delayInMillisecondsBetweenCookies));
      }
    }
    }
  }
  @EventHandler
  public void onDamage(BlockDamageEvent event)
  {
	    Player p = event.getPlayer();
	  if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("CookieMonster"))) && 
      (event.getBlock().getType() == Material.LONG_GRASS) && (new Random().nextInt(this.oneChanceInWhatOfCookies) == 0))
    {
      Location loc = event.getBlock().getLocation().clone();
      loc.getWorld().dropItemNaturally(loc.add(0.5D, 0.0D, 0.5D), new ItemStack(Material.COOKIE));
      p.sendMessage("§bVocê ganhou um Cookie.");
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
    if (c.getName().equalsIgnoreCase("CookieMonster"))
    {
      Player p1 = (Player)p;
      p1.chat("/kit CookieMonster");
    }
    return false;
  }
}
