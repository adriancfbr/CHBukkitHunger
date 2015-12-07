package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm
  implements CommandExecutor
{
  public gm(libsHg plugin)
  {
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	  
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
    Player player = (Player)sender;
    if ((!player.hasPermission("hg.admin")))
    {
      player.sendMessage("§cVoc§ n§o tem permissao para fazer isso!");
      return true;
    }
    if (args.length == 0)
    {
      sender.sendMessage("§cUse /gm <gamemodeId> <player> ou /gm <gamemodeId>!");
      return true;
    }
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("0"))
      {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("§aSeu gamemode foi atualizado para survival.");
        if (sender.hasPermission("hg.modm") && (sender.hasPermission("hg.admin")))
        {
       libsHg.stafflog(sender.getName() + " mudou seu modo para survival");
        }
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage("§aSeu gamemode foi atualizado para criativo.");
        if (sender.hasPermission("hg.modm") && (sender.hasPermission("hg.admin")))
        {
       libsHg.stafflog(sender.getName() + " mudou seu modo para criativo");
        }
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage("§aSeu gamemode foi atualizado para adventure.");
        if (sender.hasPermission("hg.modm") && (sender.hasPermission("hg.admin")))
        {
       libsHg.stafflog(sender.getName() + " mudou seu modo para adventure");
        }
      }
      else
      {
        sender.sendMessage("§cEsse gamemode nao existe!");
        return true;
      }
      return true;
    }
    if (args.length == 2)
    {
      Player target = Bukkit.getPlayerExact(args[1]);
      if ((target == null) || (!(target instanceof Player)))
      {
        player.sendMessage("§cJogador nao encontrado!");
        return true;
      }
      if (args[0].equalsIgnoreCase("0"))
      {
        target.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("§aVoce atualizou o gamemode de" + target.getName() + " para survival.");
        target.sendMessage("§a" + target.getName() + " atualizou seu gamemode para survival.");
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        target.setGameMode(GameMode.CREATIVE);
        player.sendMessage("§aVoce atualizou o gamemode de" + target.getName() + " para criativo.");
        target.sendMessage("§a" + target.getName() + " atualizou seu gamemode para criativo.");
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        target.setGameMode(GameMode.ADVENTURE);
        player.sendMessage("§aVoce atualizou o gamemode de" + target.getName() + " para adventure.");
        target.sendMessage("§a" + target.getName() + " atualizou seu gamemode para adventure.");
      }
      else
      {
        sender.sendMessage("§cEsse gamemode nao existe!");
        return true;
      }
      return false;
    }
    if (args.length > 2)
    {
      sender.sendMessage("§cUse /gm <gamemodeId> <player> ou /gm <gamemodeId>!");
      return true;
    }
    return false;
  }
}