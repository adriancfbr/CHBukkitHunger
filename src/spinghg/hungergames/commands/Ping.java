package spinghg.hungergames.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import spinghg.hungergames.libsHg;

public class Ping
  implements CommandExecutor
{
	  private libsHg pl;

	  public Ping(libsHg plugin)
	  {
	    this.setPl(plugin);
	  }

	  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if (paramCommand.getName().equalsIgnoreCase("ping"))
    {
      Player localPlayer = (Player)paramCommandSender;
      int i = ((CraftPlayer)localPlayer).getHandle().ping;
	    if (!(localPlayer instanceof Player))
	    {
	      localPlayer.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
      localPlayer.sendMessage(ChatColor.RED + "Seu ping é: " + ChatColor.GOLD + i);
    }
    return false;
  }


public libsHg getPl() {
	return pl;
}


public void setPl(libsHg pl) {
	this.pl = pl;
}
}