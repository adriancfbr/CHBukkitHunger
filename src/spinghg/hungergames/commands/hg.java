package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

 public class hg
 implements CommandExecutor, Listener
 {
   @SuppressWarnings("unused")
private static final String Timers = null;
private libsHg pl;
  
  public hg(libsHg plugin)
   {
   this.pl = plugin;
  }
 

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if ((paramCommandSender instanceof Player))
      {
        Player localPlayer = (Player)paramCommandSender;
        if (paramString.equalsIgnoreCase("hg") && 
        	    (localPlayer.hasPermission("hg.admin")))
        {
    	    if (!(localPlayer instanceof Player))
    	    {
    	      localPlayer.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
          if (paramArrayOfString.length == 0)
          {
            localPlayer.sendMessage("§c§oUse /hg (sopaoff:bussola)");
            return true;
          }
           {
          if (paramArrayOfString[0].equalsIgnoreCase("sopaoff"))
          {
        	  {
            if (paramArrayOfString.length != 2)        
                 localPlayer.sendMessage("§cAs sopas esta destativada");
                 this.pl.sopaoff = false;
                 if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
           	    {
               libsHg.stafflog(localPlayer.getName() + " desativou as sopas");
           	    }
            return true;
          }
          }
          }
          if (paramArrayOfString[0].equalsIgnoreCase("bussola"))
          {
              if (paramArrayOfString.length != 2)        
                  localPlayer.sendMessage("§cAs bussolas esta desativada");
                  this.pl.bsoff = false;
                  if (localPlayer.hasPermission("hg.mod") && (localPlayer.hasPermission("hg.admin")))
            	    {
                libsHg.stafflog(localPlayer.getName() + " desativou as bussolas");
            	    }
            return true;
          }
        }
      }
    return false;
  }
 }
