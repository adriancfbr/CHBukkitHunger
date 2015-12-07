package spinghg.hungergames.listeners;

import spinghg.hungergames.libsHg;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class SwordNerf
  implements Listener
{
  @SuppressWarnings("unused")
private libsHg pl;

  public SwordNerf(libsHg plugin)
  {
    this.pl = plugin;
  }

  @EventHandler
  public void onDamageByEntity(EntityDamageByEntityEvent event)
  {
    if ((event.getDamager() instanceof Player))
    {
      Player player = (Player)event.getDamager();
      if (event.getDamage() > 1.0D) {
        event.setDamage(event.getDamage() - 1.0D);
      }
      if ((event.getDamager() instanceof Player))
      {
        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && 
          (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
        {
          int NewDamage = (int)(event.getDamage() * 1.5D) - 
            (int)event.getDamage();
          if (event.getDamage() > 1.0D) {
            event.setDamage(event.getDamage() - NewDamage);
          }
        }
        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
          event.setDamage(3.0D);
        }
        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
          event.setDamage(4.0D);
        }
        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
          event.setDamage(5.0D);
        }
        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
          event.setDamage(6.0D);
        }
        if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
          event.setDamage(event.getDamage() + 1.0D);
        }
        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && 
          (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
        {
          if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
            event.setDamage(event.getDamage() + 1.0D);
          }
          if (player.getItemInHand().getType() == Material.STONE_SWORD) {
            event.setDamage(event.getDamage() + 1.0D);
          }
          if (player.getItemInHand().getType() == Material.IRON_SWORD) {
            event.setDamage(event.getDamage() + 1.0D);
          }
          if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
            event.setDamage(event.getDamage() + 1.0D);
          }
        }
      }
    }
  }  
  }
