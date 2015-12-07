package spinghg.hungergames.commands;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

 public class Staff
 implements CommandExecutor, Listener
 {
   private static final String Timers = null;
private libsHg pl;
  
  public Staff(libsHg plugin)
   {
   this.setPl(plugin);
  }
 

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  Player p = (Player)sender;
	    if (commandLabel.equalsIgnoreCase("ban")) {
	    if (p.hasPermission("hg.mod")) {
	 	    if (!(sender instanceof Player))
	 	    {
	 	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	 	      return true;
	 	    }
	    if (args.length < 2)
	    {
	      p.sendMessage("§c§oUso /Ban <jogador> <motivo>");
	    }
	    else if (args.length >= 2)
	    {
	      Player target = Bukkit.getPlayer(args[0]);
	        File file = new File("plugins/CHBukkitHunger/UserData/" + args[0] + ".yml");
	        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  if(file.exists())
	      {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 1; i < args.length; i++) {
	          sb.append(args[i]).append(" ");
	        }
	        String allArgs = sb.toString().trim();
	        String sim = cfg.getString("banido");
	        try {
	          cfg.set("banido", "true");
		      cfg.set("Motivo", allArgs);
	          p.sendMessage("§c§oJogador banido por: " + allArgs);
	          cfg.save(file);
	          if (target == null) {
	        	  p.sendMessage("§c§oJogador não esta online não é necessario kickar");
	              return true;
	            }
	          else
	          {
	        	  target.kickPlayer("Você foi banido por " + cfg.getString("Motivo") + "\n\n§7Jogador: " + target.getPlayer().getName() + " (" + target.getUniqueId() + ")\n VIP:" + cfg.getString("VIP").replace("&", "§") +"\n Server IP: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
	          }
	          if (this.pl.database) {
	              try
	              {
	                this.pl.mysql.updateBan(target, sim, allArgs);
	              }
	              catch (SQLException e1)
	              {
	                e1.printStackTrace();
	              }
	            }
	        }
	        catch (IOException e) {
	          e.printStackTrace();
	        }
				  
			  
	          }
		  else
		  {
			  p.sendMessage("§c§oEste jogador nunca entrou no servidor.");
		  }
	        }
	      }
	    }
	    if (commandLabel.equalsIgnoreCase("unban")) {
		    if (p.hasPermission("hg.mod")) {
		 	    if (!(sender instanceof Player))
		 	    {
		 	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
		 	      return true;
		 	    }
		    if (args.length < 2)
		    {
		      p.sendMessage("§c§oUso /Unban <jogador> <motivo>");
		    }
		    else if (args.length >= 2)
		    {
		      File file = new File("plugins/CHBukkitHunger/UserData/" + args[0] + ".yml");
		        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		        if(cfg.getString("banido").equals("true")) {
			  if(file.exists())
		      {
		        StringBuilder sb = new StringBuilder();
		        for (int i = 1; i < args.length; i++) {
		          sb.append(args[i]).append(" ");
		        }
		        String allArgs = sb.toString().trim();
		        try {
		          cfg.set("banido", "false");
			      cfg.set("Motivo", "");
			      cfg.set("Unban", allArgs);
		          cfg.save(file);
		          p.sendMessage("§a§oJogador desbanido");
		        }
		        catch (IOException e) {
		          e.printStackTrace();
		        }
					  
				  
		          }
			  else
			  {
				  p.sendMessage("§c§oEste jogador nunca entrou no servidor.");
			  }
			  
		        }
		        else
		        {
		        	p.sendMessage("§c§oEste jogador não foi banido.");
		        }
		      }
	    }
	    }
	    if (commandLabel.equalsIgnoreCase("sw")) {
		    if (p.hasPermission("hg.adminop"))
		    	if(p.isOp()) 
{
		    if (args.length < 2)
		    {
		      p.sendMessage("§c§oUso /Sw <Staff> <motivo>");
		    }
		    else if (args.length >= 2)
		    {
		      Player target = Bukkit.getPlayer(args[0]);
		        File file = new File("plugins/CHBukkitHunger/UserData/" + args[0] + ".yml");
		        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				  if(file.exists())
			      {
		        if(cfg.getString("Staff").equals("Sim")) {
				  if(!cfg.getString("Sw1").equals("avisado")) {
		        StringBuilder sb = new StringBuilder();
		        for (int i = 1; i < args.length; i++) {
		          sb.append(args[i]).append(" ");
		        }
		        String allArgs = sb.toString().trim();
		        try {
		          cfg.set("Sw1", "avisado");
			      cfg.set("MotivoSw1", allArgs);
		          if (target == null) {
		        	  p.sendMessage("§c§oJogador não esta online ele não vai ser notificado do alerta");
		              return true;
		            }
		          else
		          {
		          target.sendMessage("§9Staff >> §7Você recebeu um alerta por: " + allArgs);
		          }
		          cfg.save(file);
		        }
		        catch (IOException e) {
		          e.printStackTrace();
		        }
		        
				  
		          }
				  else
					  if(!cfg.getString("Sw2").equals("avisado"))
				  {
						  StringBuilder sb = new StringBuilder();
					        for (int i = 1; i < args.length; i++) {
					          sb.append(args[i]).append(" ");
					        }
					        String allArgs = sb.toString().trim();
					        try {
					          cfg.set("Sw2", "avisado");
						      cfg.set("MotivoSw2", allArgs);
					          if (target == null) {
					        	  p.sendMessage("§c§oJogador não esta online ele não vai ser notificado do alerta");
					              return true;
					            }
					          else
					          {
					          target.sendMessage("§9Staff >> §7Você recebeu um alerta por: " + allArgs);
					          }
					          cfg.save(file);
					        }
					        catch (IOException e) {
					          e.printStackTrace();
					        }
				  }
					  else
						  if(!cfg.getString("Sw3").equals("avisado"))
					  {
						  StringBuilder sb = new StringBuilder();
					        for (int i = 1; i < args.length; i++) {
					          sb.append(args[i]).append(" ");
					        }
					        String allArgs = sb.toString().trim();
					        try {
					          cfg.set("Sw3", "avisado");
						      cfg.set("MotivoSw3", allArgs);
					          if (target == null) {
					        	  p.sendMessage("§c§oJogador não esta online ele não vai ser notificado do alerta");
					              return true;
					            }
					          else
					          {
					          target.sendMessage("§9Staff >> §7Você recebeu um alerta por: " + allArgs);
					          }
					          cfg.save(file);
					        }
					        catch (IOException e) {
					          e.printStackTrace();
					        }
					  }
					 
				  else
				  {
					  if(cfg.getString("Sw3").equals("avisado"))
					  {
					      try {
					          cfg.set("Staff", "Nao");
					          cfg.set("Cargo", "Normal");
					          cfg.set("VIP", "Nao");
					          cfg.save(file);
					        }
					        catch (IOException e) {
					          e.printStackTrace();
					        }
						  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex group " + args[0] + " group set default");
						  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex group " + args[0] + " delete");
						  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex group " + args[0] + " remove");
						  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "deop " + args[0]);
				          if (target == null) {
				        	  p.sendMessage("§c§oJogador não esta online ele não vai ser notificado do alerta");
				              return true;
				            }
				          else
				          {
				        	  target.kickPlayer("Você foi removido da staff devido os 3 Avisos!" + "\n\n§7Jogador: " + target.getPlayer().getName() + " (" + target.getUniqueId() + ")\n VIP:" + cfg.getString("VIP").replace("&", "§") +"\n Server IP: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
				          }
					  }
				  }
		      }
			  
		        
		        else
		        {
		        	p.sendMessage("§c§oEste jogador não é staff.");
		        }
		      }
		    }
		    else
		    {
		    	p.sendMessage("§c§oEste jogador não é staff.");
		    }
	    }
    return false;
  }
		return false;
  }


public static String getTimers() {
	return Timers;
}


public libsHg getPl() {
	return pl;
}


public void setPl(libsHg pl) {
	this.pl = pl;
}
 }
