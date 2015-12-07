package spinghg.hungergames.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

public class kick
implements CommandExecutor, Listener
{
public String[] aliases = { "yt" };
@SuppressWarnings("unused")
private libsHg pl;

public kick(libsHg plugin)
{
  this.pl = plugin;
}
	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		  Player p = (Player)sender;
		    if (commandLabel.equalsIgnoreCase("kick")) {
		    if (p.hasPermission("hg.mod")) { 
		 	    if (!(sender instanceof Player))
		 	    {
		 	      sender.sendMessage("§9Erro> §§7Somente jogadores podem executar este comando!");
		 	      return true;
		 	    }
		    if (args.length < 2)
		    {
		      p.sendMessage("§c§oUso /kick <jogador> <motivo>");
		    }
		    else if (args.length >= 2)
		    {

		        {
		        	   {
		       	        StringBuilder sb = new StringBuilder();
		       	        for (int i = 1; i < args.length; i++) {
		       	          sb.append(args[i]).append(" ");
		       	        }
		        	  Player target = Bukkit.getPlayer(args[0]);
		        	    if (target == null) {
		                    sender.sendMessage(ChatColor.GREEN + 
		                      "Jogador não esta online.");
		                    return true;
		                  }
		  	        File file = new File("plugins/CHBukkitHunger/UserData/" + args[0] + ".yml");
		  	          YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  	      @SuppressWarnings("unused")
				String allArgs = sb.toString().trim();
			          target.kickPlayer("Você foi kickado por " + sb + "\n\n§7Jogador: "  + target.getPlayer().getName() + " (" + target.getUniqueId() + ")\n VIP:" + cfg.getString("VIP").replace("&", "§") +"\n Server IP: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
		        
					  
				  
		          }
		    }
	
		        }
		      }
	  }
			return false;
	  }
}
