 package spinghg.hungergames.commands;
 

 import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
 public class forcefeast
   implements CommandExecutor
 {
   private libsHg pl;
   
   public forcefeast(libsHg plugin)
   {
     this.pl = plugin;
   }
   
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
     if (!sender.hasPermission("hg.admin"))
     {
       return true;
     }
     if (this.pl.feast)
     {
       sender.sendMessage("§cJa existe um feast spawnado!");
       return true;
     }
     if (!this.pl.comecou)
     {
       sender.sendMessage("§O HungerGames não foi iniciado!");
       return true;
     }
     Location loc = this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
     this.pl.fg.prepareFeast(loc);
     this.pl.feast = true;
     if (sender.hasPermission("hg.mod") && (sender.hasPermission("hg.admin")))
     {
    libsHg.stafflog(sender.getName() + " utilizou o forcefeast");
     }
     
     return false;
   }
 }
