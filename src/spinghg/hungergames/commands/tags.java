 package spinghg.hungergames.commands;
 
 import spinghg.hungergames.libsHg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
 
 public class tags
   implements CommandExecutor
 {
   @SuppressWarnings("unused")
private libsHg pl;
   
   public tags(libsHg plugin)
   {
     this.pl = plugin;
   }
   
   @EventHandler
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
    Player p = (Player)sender;
     {
    	 p.sendMessage("§c/tag §7Normal §c| §aVip §c| §9Mvp §c| §6Pro §c| §b§oYoutuber §c| §5Mod §c| §5§oMod+ §c| §c Admin §c| §4§oDono§2|");
    }
	return false;
}
}
