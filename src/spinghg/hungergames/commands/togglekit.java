package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
 public class togglekit
 implements CommandExecutor, Listener
 {
   @SuppressWarnings("unused")
private static final String Timers = null;
private libsHg pl;
  
  public togglekit(libsHg plugin)
   {
   this.pl = plugin;
  }
 

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if ((paramCommandSender instanceof Player))
      {
        Player localPlayer = (Player)paramCommandSender;
        if (paramString.equalsIgnoreCase("togglekit") && 
        	    (localPlayer.hasPermission("hg.admin")))
        {
    	    if (!(localPlayer instanceof Player))
    	    {
    	      localPlayer.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
          if (paramArrayOfString.length == 0)
          {
            localPlayer.sendMessage("§c§oUse /togglekit (true:false)");
            return true;
          }
           {
          if (paramArrayOfString[0].equalsIgnoreCase("true"))
          {
        	  {
            if (paramArrayOfString.length != 2)        
                 localPlayer.sendMessage("§cOs kits estão agora ativados");
                 this.pl.kit = true;
                 if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
           	    {
               libsHg.stafflog(localPlayer.getName() + " ativou os kits");
           	    }
            return true;
          }
          }
          }
          if (paramArrayOfString[0].equalsIgnoreCase("false"))
          {
              if (paramArrayOfString.length != 2)        
                  localPlayer.sendMessage("§cOs kits estão agora desativados");
              if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
      	    {
          libsHg.stafflog(localPlayer.getName() + " desativou os kits");
      	    }
                  this.pl.kit = false;
            return true;
          }
        }
      }
    return false;
  }
 }
