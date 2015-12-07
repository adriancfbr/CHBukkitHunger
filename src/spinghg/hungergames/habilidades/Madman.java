package spinghg.hungergames.habilidades;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.events.TimeSecondEvent;
import spinghg.hungergames.listeners.BossBar;

public class Madman
 implements Listener
{
  private HashMap<Player, Double> madman = new HashMap();
  private libsHg pl;
  
  public Madman(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onTime(TimeSecondEvent event)
  {
    DecimalFormat dm = new DecimalFormat("##");
    {
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player p = arrayOfPlayer[i];
         {
          for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
            if ((e instanceof Player))
            {
              if (this.madman.containsKey((Player)e))
              {
                this.madman.put((Player)e, Double.valueOf(((Double)this.madman.get((Player)e)).doubleValue() + 0.01D));
              }
              else
              {
                this.madman.put((Player)e, Double.valueOf(0.01D));
                ((Player)e).sendMessage("§bTem um madman por perto!");
                ((Player)e).playSound(((Player)e).getLocation(), Sound.AMBIENCE_CAVE, 10.0F, 1.0F);
              }
              BossBar.setMessage((Player)e, dm.format(((Double)this.madman.get((Player)e)).doubleValue() * 100.0D) + "% Efeito do madman");
            }
          }
        }
        if (this.madman.containsKey(p))
        {
          boolean hasMadMan = false;
          for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
            if ((e instanceof Player))
            {
              Player mad = (Player)e;
              {
                hasMadMan = true;
                break;
              }
            }
          }
          if (!hasMadMan) {
            if (((Double)this.madman.get(p)).doubleValue() - 0.2D <= 0.0D)
            {
              this.madman.remove(p);
              BossBar.setMessage(p, "Efeito do madman passou!");
              BossBar.removeBar(p);
            }
            else
            {
              this.madman.put(p, Double.valueOf(((Double)this.madman.get(p)).doubleValue() - 0.2D));
              BossBar.setMessage(p, dm.format(((Double)this.madman.get(p)).doubleValue() * 100.0D) + "% Efeito do madman");
            }
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onDamage123s(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player))
    {
      Player p = (Player)event.getEntity();
      if (this.madman.containsKey(p)) {
        event.setDamage(event.getDamage() + event.getDamage() * ((Double)this.madman.get(p)).doubleValue());
      }
    }
  }
}
