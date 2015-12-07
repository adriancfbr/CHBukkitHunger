package spinghg.hungergames.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCompassTargetEvent extends Event
  implements Cancellable
{
  private boolean cancelado = false;
  private Location locAlvo;
  private String mensagem;
  private Player player;
  private Player alvo;
  private static final HandlerList handlers = new HandlerList();

  public PlayerCompassTargetEvent(Player player, Player alvo, String message)
  {
    this.player = player;
    this.alvo = alvo;
    this.mensagem = message;
    if (alvo != null)
        this.locAlvo = alvo.getLocation().clone();
      else
        this.locAlvo = player.getWorld().getSpawnLocation();
  }

  public boolean isCancelled()
  {
    return this.cancelado;
  }

  public void setCancelled(boolean novoCancelado)
  {
    this.cancelado = novoCancelado;
  }

  public HandlerList getHandlers()
  {
    return handlers;
  }

  public static HandlerList getHandlerList()
  {
    return handlers;
  }

  public Location getLocationAlvo()
  {
    return this.locAlvo.clone();
  }

  public String getMessage()
  {
    return this.mensagem;
  }

  public Player getPlayer()
  {
    return this.player;
  }

  public Player getAlvo()
  {
    return this.alvo;
  }

  public void setLocation(Location loc)
  {
    this.locAlvo = loc.clone();
  }

  public void setMessage(String newMessage)
  {
    this.mensagem = newMessage;
  }
}