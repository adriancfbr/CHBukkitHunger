package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class pvp
  implements CommandExecutor, Listener
{
  @SuppressWarnings("unused")
private libsHg pl;
  boolean pvp = true;

  public pvp(libsHg plugin)
  {
    this.pl = plugin;
  }

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if ((paramCommandSender instanceof Player))
      {
        Player localPlayer = (Player)paramCommandSender;
        if (paramString.equalsIgnoreCase("pvp") && 
        	    (localPlayer.hasPermission("hg.admin")))
        {
    	    if (!(localPlayer instanceof Player))
    	    {
    	      localPlayer.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
          if (paramArrayOfString.length == 0)
          {
            localPlayer.sendMessage("§c§oUse /pvp (true:false)");
            return true;
          }
           {
          if (paramArrayOfString[0].equalsIgnoreCase("true"))
          {
        	  {
            if (paramArrayOfString.length != 2)        
            	Bukkit.broadcastMessage("§cO pvp foi ativado!");
                 this.pvp = true;
                 if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
                 {
                libsHg.stafflog(localPlayer.getName() + " ativo o pvp");
                 }
            return true;
          }
          }
          }
          if (paramArrayOfString[0].equalsIgnoreCase("false"))
          {
              if (paramArrayOfString.length != 2)        
            	  Bukkit.broadcastMessage("§cO pvp foi desativado!");
                  this.pvp = false;
                  if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
                  {
                 libsHg.stafflog(localPlayer.getName() + " desativou o pvp");
                  }
            return true;
          }
        }
      }
    return false;
  }
  @EventHandler
  public void onHit(EntityDamageByEntityEvent e) {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
      if (!this.pvp)
        e.setCancelled(true);
      else
        e.setCancelled(false);
  }
}