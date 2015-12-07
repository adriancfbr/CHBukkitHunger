 package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ip
  implements CommandExecutor, Listener
{
  public String[] aliases = { "yt" };
  @SuppressWarnings("unused")
private libsHg pl;

  public ip(libsHg plugin)
  {
    this.pl = plugin;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    
    if ((cmd.getName().equalsIgnoreCase("ip"))) {
        if (cmd.getName().equalsIgnoreCase("ip")) {
            p.sendMessage("§aIp do servidor: §7 " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
         
          }
    }
    return true;
  }
}