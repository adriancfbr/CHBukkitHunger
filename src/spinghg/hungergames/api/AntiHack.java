package spinghg.hungergames.api;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class AntiHack implements Listener
{
  public ArrayList<Player> alertas = new ArrayList();
  public static String PERMISSAO = "hg.mod";
  public static AntiHack m;
  
  
  public static AntiHack getMain()
  {
    return m;
  }
  
  public static void sendStaffMsg(String msg)
  {
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player p = arrayOfPlayer[i];
      if (p.hasPermission(AntiHack.PERMISSAO)) {
        p.sendMessage("§9CHAntiHack> §7" + msg);
      }
    }
  }
  
  private static Map<UUID, Long> lastAttacked = new HashMap();
  
  public static long getLastAttackTime(UUID uuid)
  {
    if (!AntiHack.lastAttacked.containsKey(uuid)) {
      AntiHack.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
    }
    return ((Long)AntiHack.lastAttacked.get(uuid)).longValue();
  }
  
  public static void setLastAttackTime(UUID uuid)
  {
    AntiHack.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
  }
  
}
