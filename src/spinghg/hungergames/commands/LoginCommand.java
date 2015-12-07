package spinghg.hungergames.commands;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.listeners.Extras;
import spinghg.hungergames.listeners.ScoreboardTeam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
 public class LoginCommand
 implements CommandExecutor, Listener
 {
   private static final String Timers = null;
private libsHg pl;
  
  public LoginCommand(libsHg plugin)
   {
   this.pl = plugin;
  }
  
  public int days = 30;
  public HashMap<String, Long> lg = new HashMap();
 
  
public HashMap<String, String> reason = new HashMap();
  


  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
	  if (commandLabel.equalsIgnoreCase("MudarCDS")) {
				  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) 
	 	    {
			    if (args.length < 2)
			    {
			      p.sendMessage("§c§oUso /MudarCDS <Seu-CDS> <Novo-CDS>");
			    }
			    else if (args.length >= 2)
			    {
			    final File file = new File("plugins/CHBukkitHunger/UserData/"+p.getPlayer().getName()+".yml");
			    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			    if(cfg.getString("ChaveDS").equals(args[0])) {
			    	cfg.set("ChaveDS", args[1]);
			    	try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
			    	p.sendMessage("§c§oSeu CDS foi alterado com exito.");
			    	p.sendMessage("§9§oSeu novo CDS:§7 " + cfg.getString("ChaveDS"));
			          if (this.pl.database) {
			              try
			              {
			                this.pl.mysql.updateChave(p);
			              }
			              catch (SQLException e1)
			              {
			                e1.printStackTrace();
			              }
			            }
			    }
			    else
			    {
			    	p.sendMessage("§c§oSeu CDS não é compativel com o registrado.");
			    }
			    }
	 	    }
  }
	  
  if (commandLabel.equalsIgnoreCase("entrar")) {
	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
	    if (!(sender instanceof Player))
	    {

	      return true;
	    }
	    else
	    {
		    if (args.length < 1)
		    {
		      p.sendMessage("§c§oUso /entrar <Seu-CDS>");
		    }
		    else if (args.length >= 1)
		    {
		    final File file = new File("plugins/CHBukkitHunger/UserData/"+p.getPlayer().getName()+".yml");
		    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		    if(cfg.getString("ChaveDS").equals(args[0])) {
		    	if (this.pl.login.contains(p)) {
		    	p.sendMessage("§cEntrou com exito no servidor.");
		    	p.sendMessage("§9§oMude sua senha usando /MudarCDS");
		        if(cfg.getString("MostrarCDS").equals("Sim")) {		             
		             cfg.set("MostrarCDS", "Nao");
		             try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		             }
		 
		    	if ((this.pl.aguardando) || (this.pl.comecando)) {
		    		this.pl.vivos.add(p);
		    	}
		    	if ((this.pl.comecou) || (this.pl.invencibilidade)) {
		    		if (!this.pl.vivos.contains(p)) {
		    		this.pl.vivos.add(p);
		    		}
		    	}
		    	this.pl.login.remove(p);
		    }
		    	if (!this.pl.login.contains(p)) {
		    		p.sendMessage("§c§oVocê já esta logado.");
		    	}
		    }
		    	
		    else
		    {
		    	p.sendMessage("§c§oSeu CDS não é compativel com o registrado.");
		    }
		    }
	    }
	  }
  }
  if (commandLabel.equalsIgnoreCase("login")) {
	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
	    if (!(sender instanceof Player))
	    {

	      return true;
	    }
	    else
	    {
		    if (args.length < 1)
		    {
		      p.sendMessage("§c§oUso /login <Seu-CDS>");
		    }
		    else if (args.length >= 1)
		    {
		    final File file = new File("plugins/CHBukkitHunger/UserData/"+p.getPlayer().getName()+".yml");
		    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		    if(cfg.getString("ChaveDS").equals(args[0])) {
		    	if (this.pl.login.contains(p)) {
		    	p.sendMessage("§cEntrou com exito no servidor.");
		    	p.sendMessage("§9§oMude sua senha usando /MudarCDS");
		        if(cfg.getString("MostrarCDS").equals("Sim")) {		             
		             cfg.set("MostrarCDS", "Nao");
		             try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		             }
		 
		    	if ((this.pl.aguardando) || (this.pl.comecando)) {
		    		this.pl.vivos.add(p);
		    	}
		    	if ((this.pl.comecou) || (this.pl.invencibilidade)) {
		    		if (!this.pl.vivos.contains(p)) {
		    		this.pl.vivos.add(p);
		    		}
		    	}
		    	this.pl.login.remove(p);
		    }
		    	if (!this.pl.login.contains(p)) {
		    		p.sendMessage("§c§oVocê já esta logado.");
		    	}
		    }
		    	
		    else
		    {
		    	p.sendMessage("§c§oSeu CDS não é compativel com o registrado.");
		    }
		    }
	    }
	  }
  }
	  if (commandLabel.equalsIgnoreCase("registrar")) {
		  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) 
	    {
	    if (args.length < 1)
	    {
	      p.sendMessage("§a§oUso /registrar <senha>");
	    }
	    else if (args.length >= 1)
	    {
			  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("registrar").equals("true")) {
	    final File file = new File("plugins/CHBukkitHunger/UserData/"+p.getPlayer().getName()+".yml");
	    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    if (this.pl.login.contains(p)) {
	    if(cfg.getString("MostrarCDS").equals("Sim")) {
	    	cfg.set("ChaveDS", args[0]);
	    	cfg.set("MostrarCDS", "Nao");
	    	try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	p.sendMessage("§c§oSeu CDS foi criado com exito.");
	    	this.pl.login.remove(p);
	        this.pl.vivos.add(p);
	        
	          if (this.pl.database) {
	              try
	              {
	                this.pl.mysql.updateChave(p);
	              }
	              catch (SQLException e1)
	              {
	                e1.printStackTrace();
	              }
	            }
	    }
	    else
	    {
	    	p.sendMessage("§cVoce já esta registrado");
	    }
	    }
	    }
	    }
	    }
}
	  
	  if (commandLabel.equalsIgnoreCase("register")) {
		  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) 
	    {
	    if (args.length < 1)
	    {
	      p.sendMessage("§a§oUso /registrar <senha>");
	    }
	    else if (args.length >= 1)
	    {
			  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("registrar").equals("true")) {
	    final File file = new File("plugins/CHBukkitHunger/UserData/"+p.getPlayer().getName()+".yml");
	    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    if (this.pl.login.contains(p)) {
	    if(cfg.getString("MostrarCDS").equals("Sim")) {
	    	cfg.set("ChaveDS", args[0]);
	    	cfg.set("MostrarCDS", "Nao");
	    	try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	p.sendMessage("§c§oSeu CDS foi criado com exito.");
	    	this.pl.login.remove(p);
	        this.pl.vivos.add(p);
	        
	          if (this.pl.database) {
	              try
	              {
	                this.pl.mysql.updateChave(p);
	              }
	              catch (SQLException e1)
	              {
	                e1.printStackTrace();
	              }
	            }
	    }
	    else
	    {
	    	p.sendMessage("§cVoce já esta registrado");
	    }
	    }
	    }
	    }
	    }
}
      

return false;
 
  }

 }
