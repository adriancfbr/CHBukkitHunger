package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class youtuber
  implements CommandExecutor, Listener
{
  public String[] aliases = { "yt" };
  public String description = "Veja os requisitos";
  @SuppressWarnings("unused")
private libsHg pl;

  public youtuber(libsHg plugin)
  {
    this.pl = plugin;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    
    if ((cmd.getName().equalsIgnoreCase("youtuber")) || (cmd.getName().equalsIgnoreCase("yt"))) {
        if (cmd.getName().equalsIgnoreCase("youtuber")) {
        	
    	    if (!(sender instanceof Player))
    	    {
    	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
              	
            p.sendMessage(ChatColor.GOLD + "------ " + ChatColor.BLACK + 
              ChatColor.BOLD + "You" + ChatColor.RED + ChatColor.BOLD + 
              "Tuber" + ChatColor.RESET + ChatColor.GOLD + " ------");
            p.sendMessage(ChatColor.GOLD + 
              "Para se tornar YouTuber no servidor, voce precisa de no minimo:");
            p.sendMessage(ChatColor.GOLD + " - " + Config.getConfig(Config.ConfigFile.CONFIG).getString("youtuber-subs") + " de Inscritos");
            p.sendMessage(ChatColor.GOLD + " - Video no Servidor");
            p.sendMessage(ChatColor.GOLD + " - " + Config.getConfig(Config.ConfigFile.CONFIG).getString("youtuber-complemento").replace("&", "§"));
          }
    }
    return true;
  }
}