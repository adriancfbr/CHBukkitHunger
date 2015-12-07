package spinghg.hungergames.commands;

import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import spinghg.hungergames.libsHg;

public class Money
  implements CommandExecutor
{
  private libsHg pl;

  public Money(libsHg plugin)
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
    Player player = (Player)sender;

    if (cmd.getName().equalsIgnoreCase("Coins"))
    {
      if (!this.pl.database)
      {
        player.sendMessage("§cA base de dados esta desabilitada, portanto nao possivel ver isso no momento!");
        return true;
      }
      if (args.length == 0)
      {
        int Coins = 0;
        try
        {
          Coins = this.pl.mysql.getCoins(player);
        }
        catch (SQLException e)
        {
          player.sendMessage("§cOcorreu um erro ao resgatar os seus dados!");
          this.pl.logger.log(Level.SEVERE, "§cErro" + e.getMessage());
          e.printStackTrace();
          return true;
        }
        String msg = String.format("§3[Coins] §6Você tem §3" + Integer.valueOf(Coins) + "§6 Coins.");
        player.sendMessage(msg);
      }
    }
    if (cmd.getName().equalsIgnoreCase("gcoins"))
    {

    }
	return false;
  }

  public double roundTwoDecimals(double d, int c)
  {
    int temp = (int)(d * Math.pow(10.0D, c));
    return temp / Math.pow(10.0D, c);
  }
}