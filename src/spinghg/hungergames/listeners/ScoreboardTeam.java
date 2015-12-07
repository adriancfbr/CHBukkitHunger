package spinghg.hungergames.listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import spinghg.hungergames.libsHg;

public class ScoreboardTeam
  implements Listener
{
	  private libsHg pl;
	  libsHg main;
	  
	  public ScoreboardTeam(libsHg plugin)
	  {
	    this.pl = plugin;
	  }
	  
	  public static HashMap a = new HashMap();
	  public static ArrayList b = new ArrayList();
	  public static ArrayList c = new ArrayList();
	  public static String d;
	  public static List e = new ArrayList();
	  
	  public static void a(Player paramPlayer, String paramString)
	  {
	    if (paramString == " ") {
	      return;
	    }
	    d = paramString;
	    ScoreboardManager localScoreboardManager = Bukkit.getScoreboardManager();
	    Scoreboard localScoreboard = localScoreboardManager.getNewScoreboard();
	    Objective localObjective1 = localScoreboard.registerNewObjective("test2", "dummy");
	    localObjective1.setDisplaySlot(DisplaySlot.SIDEBAR);
	    localObjective1.setDisplayName(ChatColor.LIGHT_PURPLE + "Time");
	    Objective localObjective2 = localScoreboard.registerNewObjective("test", "dummy");
	    localObjective2.setDisplaySlot(DisplaySlot.SIDEBAR);
	    localObjective2.setDisplayName(ChatColor.WHITE + paramString + " (HP%)");
	    Iterator localIterator = b(paramPlayer, paramString).iterator();
	    while (localIterator.hasNext())
	    {
	      Player localPlayer = (Player)localIterator.next();
	      Score localScore1 = localObjective2.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + NameAPI.getShortStr(localPlayer.getName()) + ChatColor.RED));
	      localScore1.setScore((int)(((CraftPlayer)localPlayer).getHealth() / 2.0D * 10.0D));
	      Score localScore2 = localObjective1.getScore(Bukkit.getOfflinePlayer(ChatColor.LIGHT_PURPLE + "Time"));
	      localScore2.setScore(1);
	      localPlayer.setScoreboard(localScoreboard);
	    }
	  }
	  
	  public static List b(Player paramPlayer, String paramString)
	  {
	    ArrayList localArrayList = new ArrayList();
	    Player[] arrayOfPlayer;
	    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
	    for (int i = 0; i < j; i++)
	    {
	      Player localPlayer = arrayOfPlayer[i];
	      if ((!((String)a.get(localPlayer)).equalsIgnoreCase(" ")) && (((String)a.get(localPlayer)).equalsIgnoreCase(paramString))) {
	        localArrayList.add(localPlayer);
	      }
	    }
	    return localArrayList;
	  }
	  
	  public static Player a()
	  {
	    return (Player)a;
	  }
	  
	  public static HashMap b()
	  {
	    return a;
	  }
	  
	  public static void c(Player paramPlayer, String paramString)
	  {
	    a.put(paramPlayer, paramString);
	    paramPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aVoce foi adicionado ao time!");
	    Iterator localIterator = b(paramPlayer, (String)a.get(paramPlayer)).iterator();
	    while (localIterator.hasNext())
	    {
	      Player localPlayer = (Player)localIterator.next();
	      localPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aO Jogador: " + ChatColor.YELLOW + paramPlayer.getName() + ChatColor.GREEN + " entrou!");
	    }
	    a(paramPlayer, paramString);
	  }
	  
	  public static void a(Player paramPlayer)
	  {
	    if (a.get(paramPlayer) == " ")
	    {
	      paramPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVoce nao esta em nenhum time!");
	      return;
	    }
	    paramPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVoce saiu do seu time!");
	    a(paramPlayer, (String)a.get(paramPlayer));
	    Iterator localIterator = b(paramPlayer, (String)a.get(paramPlayer)).iterator();
	    while (localIterator.hasNext())
	    {
	      Player localPlayer = (Player)localIterator.next();
	      localPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cO Jogador: " + ChatColor.YELLOW + paramPlayer.getName() + ChatColor.RED + " saiu!");
	    }
	    a.put(paramPlayer, " ");
	    paramPlayer.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
	  }
	  
	  @EventHandler
	  public void a(PlayerQuitEvent paramPlayerQuitEvent)
	  {
	    a(paramPlayerQuitEvent.getPlayer());
	  }
	  	  
	  @EventHandler
	  public void a(EntityDamageEvent paramEntityDamageEvent)
	  {
	    if ((paramEntityDamageEvent.getEntity() instanceof Player))
	    {
	      Player localPlayer = (Player)paramEntityDamageEvent.getEntity();
	      a(localPlayer, (String)a.get(localPlayer));
	    }
	  }
	  
	  @EventHandler
	  public void b(PlayerMoveEvent paramEntityDamageEvent)
	  {
	      Player localPlayer = paramEntityDamageEvent.getPlayer();
	      a(localPlayer, (String)a.get(localPlayer));
	    
	  }
	  
	  @EventHandler
	  public void b(AsyncPlayerChatEvent paramAsyncPlayerChatEvent)
	  {
	    String str = paramAsyncPlayerChatEvent.getPlayer().getName();
	    if (b.contains(paramAsyncPlayerChatEvent.getPlayer()))
	    {
	      Iterator localIterator = a.keySet().iterator();
	      while (localIterator.hasNext())
	      {
	        Player localPlayer = (Player)localIterator.next();
	        if (a.get(localPlayer.getName()) != null)
	        {
	          localPlayer.sendMessage(ChatColor.GOLD + (String)a.get(localPlayer) + ChatColor.GRAY + str + ": " + ChatColor.WHITE + paramAsyncPlayerChatEvent.getMessage());
	          paramAsyncPlayerChatEvent.setCancelled(true);
	        }
	        else
	        {
	          localPlayer.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVocê não esta em nenhum time!");
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void a(PlayerJoinEvent paramPlayerJoinEvent)
	  {
	    a.put(paramPlayerJoinEvent.getPlayer(), " ");
	  }
}