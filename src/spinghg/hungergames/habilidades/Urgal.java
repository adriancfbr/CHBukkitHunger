package spinghg.hungergames.habilidades;

import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Urgal
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Urgal(libsHg plugin)
  {
    this.pl = plugin;
  }
  private HashMap<Player, Long> potionDelay = new HashMap();
  public int delayInMsForDrinkPotion = 1000;
  
  @EventHandler
  public void onDamageTurtle(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Urgal"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("hg.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Urgal (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Urgal", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onDropUrgal(PlayerDropItemEvent event) {
	  Player p = event.getPlayer();
	  if ((event.getItemDrop().getItemStack().getType() == Material.POTION) && this.pl.km.temKit(p) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Urgal"))))
      event.setCancelled(true); }

  @EventHandler
  public void onChomp(PlayerInteractEvent event)
  {
	  if (this.pl.kit) 
    if (event.getAction().name().contains("RIGHT"))
    {
      Player p = event.getPlayer();
      if (((!this.potionDelay.containsKey(p)) || (((Long)this.potionDelay.get(p)).longValue() < System.currentTimeMillis())) && 
        (event.getItem() != null) && (event.getItem().getType() == Material.POTION) && this.pl.km.temKit(p) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Urgal"))))
      {
        event.setCancelled(true);

        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0), true);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0), true);
        BossBar.setMessage(p, "§c§oSeu efeito do Urgal" ,60);
        
        event.getItem().setAmount(event.getItem().getAmount() - 1);
        if (event.getItem().getAmount() == 0) {
          p.setItemInHand(new ItemStack(0));
        }
        this.potionDelay.put(p, Long.valueOf(System.currentTimeMillis() + this.delayInMsForDrinkPotion));
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Urgal")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Urgal");
	    }

	    return false;
	  }

}
