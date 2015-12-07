package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload
implements CommandExecutor
{
  public reload(libsHg plugin) {}

 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
  sender.sendMessage("§c§oPorfavor não use /reload use o /stop!");
     return false;
 }
}
