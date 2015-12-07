package spinghg.hungergames.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class TimeSecondEvent
  extends Event
{
  public static final HandlerList handlers = new HandlerList();
  
  public HandlerList getHandlers()
  {
    return handlers;
  }
  
  public static HandlerList getHandlerList()
  {
    return handlers;
  }
}
