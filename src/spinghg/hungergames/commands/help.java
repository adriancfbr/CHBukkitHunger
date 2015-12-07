package spinghg.hungergames.commands;

import java.text.SimpleDateFormat;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help
  implements CommandExecutor
{
  private libsHg pl;

  public help(libsHg plugin)
  {
    this.pl = plugin;
  }

  @SuppressWarnings("unused")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    int millis = this.pl.partidaCounter * 1000;
    SimpleDateFormat df = new SimpleDateFormat("mm:ss");
    String time = df.format(Integer.valueOf(millis));
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
      return true;
    }
    if ((this.pl.comecando))
    {
      int millis1 = this.pl.startingCounter * 1000;
      SimpleDateFormat df1 = new SimpleDateFormat("m:ss");
      String time1 = df1.format(Integer.valueOf(millis1));

      String msg = String.format("§bPartida inicia em:§9 " + time1);
      sender.sendMessage(msg);
      String msg1 = String.format("§9%s §bjogadores.", new Object[] { 
        Integer.valueOf(this.pl.vivos.size()) });
      sender.sendMessage(msg1);
      sender.sendMessage("§bCompre VIP e kits em: §9" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
    }
    if ((this.pl.aguardando))
    {
      int millis1 = this.pl.startingCounter * 1000;
      SimpleDateFormat df1 = new SimpleDateFormat("m:ss");
      String time1 = df1.format(Integer.valueOf(millis1));

      String msg = String.format("§bPartida necessita de :§9 " + Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"));
      sender.sendMessage(msg);
      String msg1 = String.format("§9%s §bjogadores.", new Object[] { 
        Integer.valueOf(this.pl.vivos.size()) });
      sender.sendMessage(msg1);
      sender.sendMessage("§bCompre VIP e kits em: §9" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
    }
    if (this.pl.invencibilidade)
    {
        int millis1 = this.pl.invicCounter * 1000;
        SimpleDateFormat df1 = new SimpleDateFormat("m:ss");
        String time1 = df1.format(Integer.valueOf(millis1));
      String msg1 = String.format("§bInvencibilidade:§9 " + time , new Object[0]);
      sender.sendMessage(msg1);
      String msg = String.format("§9%s §bjogadores", new Object[] { 
        Integer.valueOf(this.pl.vivos.size()) });
      sender.sendMessage(msg);
      sender.sendMessage("§bCompre VIP e kits em: §9" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
    }
    if (this.pl.comecou)
    {
        int millis1 = this.pl.partidaCounter * 1000;
        SimpleDateFormat df1 = new SimpleDateFormat("m:ss");
        String time1 = df1.format(Integer.valueOf(millis1));
      String msg1 = String.format("§bTempo da partida:§9 " + time , new Object[0]);
      sender.sendMessage(msg1);
      String msg = String.format("§9%s §bjogadores", new Object[] { 
        Integer.valueOf(this.pl.vivos.size()) });
      sender.sendMessage(msg);
      sender.sendMessage("§bCompre VIP e kits em: §9" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
    }
    return false;
  }
}