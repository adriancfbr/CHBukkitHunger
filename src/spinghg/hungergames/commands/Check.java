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
import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.listeners.AmountAPI;

public class Check
  implements CommandExecutor, Listener
{
	   private libsHg pl;
	   
	   
	   public Check(libsHg plugin)
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
    if (cmd.getName().equalsIgnoreCase("check"))
    {
      if (!player.hasPermission("hg.mod"))
      {
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§cUse /check [jogador]");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target instanceof Player)) {
          player.sendMessage("§cJogador -> " + target.getName());
        }
        player.sendMessage("§7IP ->§9 http://www.geoiptool.com/en/?IP=" + target.getAddress().getHostString());
        if (!this.pl.km.temKit(target)) {
        	player.sendMessage("§7Kit ->§9 Sem Kit");
        }
        else
        {
            player.sendMessage("§7Kit ->§9 " + ((Kit)this.pl.km.playerKit.get(target)).getName());
        }
        player.sendMessage("§7HP -> §9" + ((CraftPlayer)target).getHealth() / 2.0D * 10.0D + "%");
        player.sendMessage("§7Fome ->§9 " + target.getFoodLevel() / 2 * 10 + "%");
        player.sendMessage("§7Gamemode ->§9 " + target.getGameMode());
        player.sendMessage("§7Sopas -> §9" + AmountAPI.getAmount(target, Material.MUSHROOM_SOUP));
        player.sendMessage("§7Localização (X, Y, Z) §c->§9 [" + target.getLocation().getBlockX() + ", " + target.getLocation().getBlockY() + ", " + target.getLocation().getBlockZ() + "]");
        
      }
    }
    return false;
  }
}
