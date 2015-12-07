package spinghg.hungergames.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import spinghg.hungergames.libsHg;

public class Dano
  implements Listener
{
  private libsHg pl;

  public Dano(libsHg plugin)
  {
    this.pl = plugin;
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void onDanoComecando(EntityDamageEvent e)
  {
    if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
      e.setCancelled(true);
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void onDamageInvencibilidade(EntityDamageEvent e)
  {
    if ((this.pl.invencibilidade) && 
      ((e.getEntity() instanceof Player)))
      e.setCancelled(true);
  }
  
  @EventHandler
  public void nohunger(FoodLevelChangeEvent event) {
	  if ((this.pl.comecando) || (this.pl.invencibilidade) || (this.pl.acabou) || (this.pl.aguardando)) {
    event.setCancelled(true);
    event.setFoodLevel(20);
  }
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void onTarget(EntityTargetEvent e) {
    if ((this.pl.comecando) || (this.pl.aguardando) &&
      ((e.getTarget() instanceof Player)))
      e.setCancelled(true);
  }
  
  @EventHandler
  public void noRain(WeatherChangeEvent event) {
	  if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.aguardando))
    event.setCancelled(true);
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onCreeperExplosion(EntityExplodeEvent event) {
	  if ((this.pl.comecando) || (this.pl.acabou)|| (this.pl.aguardando))
    event.setCancelled(true);
  }
  
  
}