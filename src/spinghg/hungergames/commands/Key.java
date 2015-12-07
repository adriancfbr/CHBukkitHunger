package spinghg.hungergames.commands;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Key
  implements CommandExecutor, Listener
{
  public String[] aliases = { "yt" };
  @SuppressWarnings("unused")
private libsHg pl;

  public Key(libsHg plugin)
  {
    this.pl = plugin;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    
    if ((cmd.getName().equalsIgnoreCase("ativar"))) {
        if (cmd.getName().equalsIgnoreCase("ativar")) {
            if (args.length < 1)
		    {
		      p.sendMessage("§c§oUso /ativar <Chave>");
		    }
		    else if (args.length >= 1)
		    {
		        String key = args[0];
		         try {
					{
		                List<?> l = Config.getConfig(Config.ConfigFile.KEY).getStringList("Vip." + args[0]);
		                if (l.contains(args[0]))
		                {
		                	p.sendMessage("§c§oA chave já foi ativada.");
		                }
		                else
		                {
		                	
							String kills = this.pl.mysql.updateKeyJogador(p, key);
							String ativar = this.pl.mysql.updatekeyAtiva(p, key);
			                p.sendMessage("§c§oChave ativada com exito: " + args[0]);
		                }
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		      }
		    }
          }
	return false;
  }
  
  
  }