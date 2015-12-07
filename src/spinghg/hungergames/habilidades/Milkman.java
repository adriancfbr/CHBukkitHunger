package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Milkman
  implements Listener
{
  private transient HashMap<ItemStack, Integer> cooldown = new HashMap();
  public int maxUses = 5;
  public String milkbucketName = "Milkman";
  public String[] potionEffects = { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
  
  private libsHg pl;
  
  public Milkman(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageHunter(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Milkman"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - LavaMan (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - LavaMan", 1);
      }
    }
  }
  }
  
  @EventHandler
  public void onConsume(PlayerItemConsumeEvent event)
  {
    ItemStack item = event.getItem();
    Player p = event.getPlayer();
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Milkman")))) {
    {
      String[] arrayOfString1;
      int j = (arrayOfString1 = this.potionEffects).length;
      for (int i = 0; i < j; i++)
      {
        String string = arrayOfString1[i];
        
        String[] effect = string.split(" ");
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effect[0].toUpperCase()), 
          Integer.parseInt(effect[1]), Integer.parseInt(effect[2]));
        p.addPotionEffect(potionEffect, true);
      }
      if (!this.cooldown.containsKey(item)) {
        this.cooldown.put(item, Integer.valueOf(0));
      }
      this.cooldown.put(item, Integer.valueOf(((Integer)this.cooldown.get(item)).intValue() + 1));
      if (((Integer)this.cooldown.get(item)).intValue() == this.maxUses)
      {
        this.cooldown.remove(item);
        event.setCancelled(true);
        p.setItemInHand(new ItemStack(Material.BUCKET, item.getAmount(), item.getDurability()));
      }
      else
      {
        event.setCancelled(true);
      }
    }
  }
}
}
