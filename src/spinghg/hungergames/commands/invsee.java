package spinghg.hungergames.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;

public class invsee
implements CommandExecutor, Listener
{
  @SuppressWarnings("unused")
private static final String Timers = null;
private libsHg pl;
 
 public invsee(libsHg plugin)
  {
  this.setPl(plugin);
 }
  public String[] aliases = { "invsee", "invjogador", "ver", "verinventario", "jogadorinventario", "inv", "bukkit:ver" , "bukkit", "bukkit:pl", "pl", "bukkit:pl", "plugins", "bukkit:plugins"};

  public String description = "Ver os invenarios dos jogadores";

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (sender.hasPermission("hg.mod"))
    {
    	
      Player p = Bukkit.getPlayerExact(sender.getName());
      
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
      if (args.length > 0)
      {
        Player player = Bukkit.getPlayer(args[0]);
        if (player == null)
        {
          sender.sendMessage(ChatColor.RED + "Erro Jogador não foi localizado");
          return true;
        }
        p.openInventory(player.getInventory());
      }
    }
    else {
      sender.sendMessage(ChatColor.RED + "Você não e um administrador");
    }
    return true;
  }

public libsHg getPl() {
	return pl;
}

public void setPl(libsHg pl) {
	this.pl = pl;
}
}