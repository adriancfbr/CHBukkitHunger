package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tell
  implements CommandExecutor
{
  private libsHg pl;

  public tell(libsHg plugin)
  {
    this.setPl(plugin);
  }

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
    if (args.length == 0)
    {
      sender.sendMessage("§c§oUse /tell [player] [mensagem]");
      return true;
    }
    if (args.length == 1)
    {
      sender.sendMessage("§c§ofalta uma mensagem!");
      sender.sendMessage("§c§oUse /tell [player] [mensagem]");
      return true;
    }
    if (args.length > 1)
    {
      Player target = Bukkit.getPlayerExact(args[0]);
      if ((target == null) || (!(target instanceof Player)))
      {
        sender.sendMessage("§c§oJogadoor não encontrado!");
        return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < args.length; i++) {
        sb.append(args[i] + " ");
      }
      String msg = sb.toString();
      target.sendMessage(String.format("§7[%s -> Você]§7 %s", new Object[] { sender.getName(), msg }));
      sender.sendMessage(String.format("§7(§fVoce §7-> §c%s§7) %s", new Object[] { target.getName(), msg }));
      for (Player staff : Bukkit.getOnlinePlayers()) {
    	  if (staff.hasPermission("hg.admin") && (staff.hasPermission("hg.dono"))) {
    		  staff.sendMessage("§7[Privado] (" + sender.getName() + ") /tell " + target.getName() + " " + msg);
    	  }
      }
      
      if (sender.hasPermission("hg.mod") && (sender.hasPermission("hg.admin")))
	    {
  libsHg.stafflog(sender.getName() + " mandou um tell para o " + target.getName() + " com a msg " + msg);
	    }
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