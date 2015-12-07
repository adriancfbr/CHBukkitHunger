package spinghg.hungergames.commands;

import java.sql.SQLException;
import java.util.logging.Level;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ranking
  implements CommandExecutor
{
  private libsHg pl;

  public ranking(libsHg plugin)
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

    cmd.getName().equalsIgnoreCase("ranking");
    if (cmd.getName().equalsIgnoreCase("status"))
    {
      if (!this.pl.database)
      {
        player.sendMessage("§cA base de dados esta desabilitada, portanto nao possivel ver isso no momento!");
        return true;
      }
      if (args.length == 0)
      {
        int kills = 0;
        int mortes = 0;
        double kdr = 0.0D;
        int vitorias = 0;
        try
        {
          kills = this.pl.mysql.getKills(player);
          mortes = this.pl.mysql.getMortes(player);
          kdr = this.pl.mysql.getKdr(player);
          vitorias = this.pl.mysql.getVitorias(player);
        }
        catch (SQLException e)
        {
          player.sendMessage("§cOcorreu um erro ao resgatar os seus dados!");
          this.pl.logger.log(Level.SEVERE, "§cErro" + e.getMessage());
          e.printStackTrace();
          return true;
        }
        String msg = String.format("§8Seus status:\n §aMatou: §f%s | §cMorreu: §f%s | §3KDR: §f%s | §9Vitorias: §f%s", new Object[] { 
          Integer.valueOf(kills), Integer.valueOf(mortes), Double.valueOf(roundTwoDecimals(kdr, 2)), Integer.valueOf(vitorias) });
        player.sendMessage(msg);
      }
      else if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null)
        {
          player.sendMessage("§cJogador nao encontrado!");
          return true;
        }
        int kills = 0;
        int mortes = 0;
        double kdr = 0.0D;
        int vitorias = 0;
        try
        {
          kills = this.pl.mysql.getKills(target);
          mortes = this.pl.mysql.getMortes(target);
          kdr = this.pl.mysql.getKdr(target);
          vitorias = this.pl.mysql.getVitorias(target);
        }
        catch (SQLException e)
        {
          player.sendMessage("§cOcorreu um erro ao resgatar os dados do jogador " + target.getName() + "!");
          this.pl.logger.log(Level.SEVERE, "§cErro" + e.getMessage());
          e.printStackTrace();
          return true;
        }
        String msg = String.format("§8Status de §b%s§8:\n §aMatou: §f%s | §cMorreu: §f%s | §3KDR: §f%s | §9Vitorias: §f%s", new Object[] { 
          target.getName(), Integer.valueOf(kills), Integer.valueOf(mortes), Double.valueOf(roundTwoDecimals(kdr, 2)), Integer.valueOf(vitorias) });
        player.sendMessage(msg);
      }
    }
    return false;
  }

  public double roundTwoDecimals(double d, int c)
  {
    int temp = (int)(d * Math.pow(10.0D, c));
    return temp / Math.pow(10.0D, c);
  }
}