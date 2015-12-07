package spinghg.hungergames.commands;

import java.util.ArrayList;
import java.util.List;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.listeners.BossBar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffectType;

public class ChatStaff
implements CommandExecutor, Listener
{
private libsHg pl;

  public ChatStaff(libsHg plugin)
 {
    this.pl = plugin;
 }

ArrayList<Player> vanished = new ArrayList<Player>();
ArrayList<Player> adminmode = new ArrayList<Player>();

@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("cs")) && 
    (p.hasPermission("hg.mod")))
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
	  
	  if (!this.pl.Cs.contains(p))
    {  	    	
      p.sendMessage("§c[Staff] §7Você entro no chat da staff!");
      this.pl.Cs.add(p);
      return true;
    }
    p.sendMessage("§c[Staff] §7Você saiu do chat da staff!");
    this.pl.Cs.remove(p);
    return true;
    
	  }
return false;
}

}



 
