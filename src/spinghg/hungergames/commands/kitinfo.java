package spinghg.hungergames.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.libsHg;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kitinfo
  implements CommandExecutor
{
  private libsHg pl;

  public kitinfo(libsHg plugin)
  {
    this.pl = plugin;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
    Player player = (Player)sender;
    if (args.length == 0)
    {
      sender.sendMessage("§cUse: /kit [nome do kit]");
      return true;
    }
    if (args.length == 1)
    {
      List nomes = new ArrayList();
      for (Kit kit : this.pl.km.getKits()) {
        nomes.add(kit.getName());
      }
      char[] stringArray = args[0].toCharArray();
      stringArray[0] = Character.toUpperCase(stringArray[0]);
      args[0] = new String(stringArray);
      if (nomes.contains(args[0]))
      {
        Object desc = new ArrayList();
        desc = this.pl.km.getKitByName(args[0]).getDescricao();
        String list = StringUtils.join((Collection)desc, "\n ");
        String msg = String.format("§a%s: §7%s", new Object[] { args[0], list.toString() });
        player.sendMessage(msg);
      }
      else
      {
        player.sendMessage("§cEsse kit não existe!");
        player.sendMessage("§c/kits para ver os kits disponiveis!");
        player.sendMessage("§c/kit [nome do kit] para escolher um kit!");
        return true;
      }
    }
    return false;
  }
}