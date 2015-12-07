package spinghg.hungergames.commands;

import java.net.InetSocketAddress;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.API.FakeAPI;
import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.listeners.AmountAPI;

public class fake
  implements CommandExecutor, Listener
{
	   private libsHg pl;
	   
	   
	   public fake(libsHg plugin)
	   {
		    this.pl = plugin;
	   }
	   
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Apenas jogadores podem executar esse comando!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("fake"))
    {
      if (!player.hasPermission("hg.mod"))
      {
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§cUse /fake [jogador]");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        
      }
    }
    return false;
  }
}
