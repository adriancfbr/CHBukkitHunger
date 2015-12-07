 package spinghg.hungergames.commands;
 
 import spinghg.hungergames.libsHg;
 import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.bukkit.event.Listener;
 
 public class aviso
   implements CommandExecutor, Listener
 {
   public aviso(libsHg plugin)
   {
   }
   
   public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
   {
     Player player = (Player)sender;
     if (((commandLabel.equalsIgnoreCase("aviso")) || (commandLabel.equalsIgnoreCase("broadcast"))) && (player.hasPermission("sping.admin"))) {
 	    if (!(sender instanceof Player))
 	    {
 	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
 	      return true;
 	    }
    	 
    	 if (args.length >= 1)
       {
         String bcast = "";
         for (int x = 0; x < args.length; x++) {
           bcast = bcast + args[x] + " ";
         }
         bcast = ChatColor.translateAlternateColorCodes('&', bcast);
         Bukkit.broadcastMessage("§c§o[Aviso] §a§o" + ChatColor.AQUA + bcast);
       }
       else
       {
         sender.sendMessage("§c§oUse: /aviso [Sua-MSG]");
       }
     }
     return false;
   }
 }