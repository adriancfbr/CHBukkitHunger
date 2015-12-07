package spinghg.hungergames.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import spinghg.hungergames.libsHg;

@SuppressWarnings("deprecation")
public class ChatCMD
implements CommandExecutor, Listener
{

private libsHg libsHg;


public ChatCMD(libsHg plugin)
{
  this.setLibsHg(plugin);
}
	
	  public List<Player> chat = new ArrayList<Player>();
	  public boolean dchat = false;
	  
	  
@EventHandler
public void ss1(PlayerChatEvent event) {
Player p = event.getPlayer();
for (Player p1 : Bukkit.getOnlinePlayers()) {
    if (this.chat.contains(p1)) {
  p.sendMessage("§9Chat>§7 O Chat esta desativado.");
  event.setCancelled(true);
  
}
}
}


@EventHandler
public void onChat(PlayerJoinEvent event)
{
	Player p = event.getPlayer();
   if (this.dchat)
   {
	   if (!p.hasPermission("hg.vip")) {
           this.chat.add(p);
	   }
   }
}

@EventHandler
public void vChat(PlayerQuitEvent event)
{
	Player p = event.getPlayer();
   if (!this.dchat)
   {
           this.chat.remove(p);
   }
}
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("chat")) {
      if (sender.hasPermission("hg.admin")) {
        if (args.length > 0) {
          if (args.length == 1) {
            if (args[0].equalsIgnoreCase("false")) {
              Bukkit.broadcastMessage("§cO chat foi desativado!");
              this.dchat = true;
              for (Player p1 : Bukkit.getOnlinePlayers()) {
                if (!p1.hasPermission("hg.vip")) {
                  this.chat.add(p1);
                  
                  
                }
              }
            }
            else if (args[0].equalsIgnoreCase("true")) {
              Bukkit.broadcastMessage("§cO chat foi ativado!");
              this.dchat = false;
              for (Player p1 : Bukkit.getOnlinePlayers()) {
                if (this.chat.contains(p1)) {
                	this.chat.remove(p1);
                }
              }
            }
          }
          else
          {
            p.sendMessage(ChatColor.RED + "Use: /chat (true | false)");
          }
        }
        else {
          p.sendMessage(ChatColor.RED + "Use: /chat (true | false)");
        }
      }
      return true;
    }
    return false;
  }


public libsHg getLibsHg() {
	return libsHg;
}


public void setLibsHg(libsHg libsHg) {
	this.libsHg = libsHg;
}
}