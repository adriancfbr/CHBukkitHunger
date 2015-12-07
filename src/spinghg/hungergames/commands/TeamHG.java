package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.ScoreboardTeam;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamHG
  implements CommandExecutor
{
	private libsHg pl;

  public TeamHG(libsHg plugin)
  {
     this.pl = plugin;
  }
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if ((paramCommandSender instanceof Player))
      {
        Player localPlayer = (Player)paramCommandSender;
        
        if (paramString.equalsIgnoreCase("team"))
        {
    	    if (!(localPlayer instanceof Player))
    	    {
    	      localPlayer.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
          if (paramArrayOfString.length == 0)
          {
            localPlayer.sendMessage("§c§oUse /team help para saber mais sobre teams!");
            return true;
          }
           {
          if (paramArrayOfString[0].equalsIgnoreCase("create"))
          {
            if (paramArrayOfString.length != 2)
            {    
              localPlayer.sendMessage(ChatColor.RED + "/team create <nome>");
            }
            else
            {
            ScoreboardTeam.e.add(paramArrayOfString[1]);
            ScoreboardTeam.c(localPlayer, paramArrayOfString[1]);
            libsHg.Team.add(localPlayer);
            return true;
          }
          }
          if (paramArrayOfString[0].equalsIgnoreCase("leave"))
          {
        	  ScoreboardTeam.a(localPlayer);
        	  libsHg.Team.remove(localPlayer);
            return true;
          }
          
          if (paramArrayOfString[0].equalsIgnoreCase("join"))
          {
            if (paramArrayOfString.length != 2)
            {
              localPlayer.sendMessage(ChatColor.RED + "/team join <nome>");
            }
            if (ScoreboardTeam.e.contains(paramArrayOfString[1])) {
            	ScoreboardTeam.c(localPlayer, paramArrayOfString[1]);
                libsHg.Team.add(localPlayer);
          }
            else
              localPlayer.sendMessage(ChatColor.RED + "Esse time nao existe!");
            return true;
          }
        
          if (paramArrayOfString[0].equalsIgnoreCase("help"))
          {
            localPlayer.sendMessage(ChatColor.GREEN + "Use /team create [nomedateam] para criar um time!");
            localPlayer.sendMessage(ChatColor.GREEN + "Use /team join [nomedateam] para entrar em um time!");
            localPlayer.sendMessage(ChatColor.GREEN + "Use /team leave para sair de um time!");
          }
        }
      }
  }
    return false;
}
}