package spinghg.hungergames.listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import spinghg.hungergames.libsHg;

public class MineCombatLog
  implements Listener
{
  public libsHg plugin;
  
  public MineCombatLog(libsHg plugin)
  {
    this.plugin = plugin;
  }
  
  public static ArrayList<Player> incombat = new ArrayList<Player>();
  public static HashMap<Player, String> damager = new HashMap<Player, String>();
  
  @EventHandler
  public void onCombatTag(EntityDamageByEntityEvent e)
  {
	  if (this.plugin.comecou) {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      Player d = (Player)e.getDamager();
      if (!incombat.contains(p)) {
      }
      incombat.add(p);
      damager.put(p, d.getName());
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
      {
        public void run()
        {
          MineCombatLog.incombat.remove(p);
          if (!MineCombatLog.incombat.contains(p)) {
          }
        }
      }, 1500L);
    }
  }
  }
  
  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (this.plugin.comecou) {
    if (incombat.contains(p))
    {
      if (damager.get(p) == null)
      {
        p.damage(9999.0D);
      }
      else
      {
        Player d = Bukkit.getServer().getPlayer((String)damager.get(p));
        p.damage(99999.0D, d);
      }
      incombat.remove(p);
      damager.remove(p);
      this.plugin.vivos.remove(p);
    }
  }
}
}
