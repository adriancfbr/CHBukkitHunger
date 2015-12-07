package spinghg.hungergames.commands;

import java.util.Random;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn
implements CommandExecutor
{
private libsHg pl;

public spawn(libsHg plugin)
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
   Player player = (Player)sender;
  if ((!this.pl.comecando) && (!this.pl.aguardando))
 {
player.sendMessage("§c§oO comando foi retirado na partida!");
   return true;
}
 boolean chance = new Random().nextBoolean();
   if (chance)
{
  int x = new Random().nextInt(50) + 400;
int z = -(new Random().nextInt(30) + 300);
World world = Bukkit.getWorld("world");
Location loc = new Location(world, x, player.getWorld().getHighestBlockYAt(x, z) + 30, z);
 player.teleport(loc);
 }
 else
{
  int x = -(new Random().nextInt(50) + 300);
  int z = new Random().nextInt(30) + 400;
  World world = Bukkit.getWorld("world");
   Location loc = new Location(world, x, player.getWorld().getHighestBlockYAt(x, z) + 30, z);
    player.teleport(loc);
}
return false;
}
}
