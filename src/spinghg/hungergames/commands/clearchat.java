 package spinghg.hungergames.commands;
 
 import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

 public class clearchat
   implements CommandExecutor
 {
   public String description = "Limpe o chat";
   private libsHg pl;
   
   public String color(String string)
   {
     return string.replace("&", "§");
   }
   
   public clearchat(libsHg plugin)
   {
	    this.pl = plugin;
   }
   
   @EventHandler
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
     if ((cmd.getName().equalsIgnoreCase("cc")) && (sender.hasPermission("hg.mod")))
 	    if (!(sender instanceof Player))
 	    {
 	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
 	      return true;
 	    }
     {
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage(color(""));
       Bukkit.broadcastMessage("§3§oO chat foi limpo!");
     }
     return true;
   }

public libsHg getPl() {
	return pl;
}

public void setPl(libsHg pl) {
	this.pl = pl;
}
 }
