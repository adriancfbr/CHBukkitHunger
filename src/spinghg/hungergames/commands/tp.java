package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp
  implements CommandExecutor
{
  public tp(libsHg plugin)
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
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      if (!player.hasPermission("hg.mod"))
      {
        player.sendMessage("§cVocê não tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§cUse /tp [player] para ir até um player!");
        player.sendMessage("§cUse /s [player] para puxar um player até você!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage("§8§oJogador não encontrado!");
          return true;
        }
        player.teleport(target);
        player.sendMessage("§8§oTeleportado para " + target.getName());
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§8§o§cUse /tp [player] para ir até um player!");
        player.sendMessage("§8§o §cUse /s [player] para puxar um player até você!");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("s"))
    {
      if (!player.hasPermission("hg.mod"))
      {
        player.sendMessage("§8§o§cVocê não tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§8§o§cUse /tp [player] para ir até um player!");
        player.sendMessage("§8§o§cUse /s [player] para puxar um player até você!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage("§8§oJogador não encontrado!");
          return true;
        }
        target.teleport(player);
        player.sendMessage("§8§o§aVocê puxou -> " + target.getName());
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage("§cUse /tp [player] para ir até um player!");
        player.sendMessage("§cUse /s [player] para puxar um player até você!");
        return true;
      }
    }
    return false;
  }
}