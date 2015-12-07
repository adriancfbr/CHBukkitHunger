package spinghg.hungergames.listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;

/**
 * @author adriancf
 *
 */
public class Join
  implements Listener
{
  private libsHg pl;
ArrayList<Player> vanished = new ArrayList<Player>();
  
  public Join(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @SuppressWarnings("deprecation")
public static int getOnlinePlayers()
  {
    return Bukkit.getServer().getOnlinePlayers().length;
  }
  
  @SuppressWarnings("static-access")
@EventHandler
  public void inserirDadosDoPlayer(PlayerJoinEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.database) {
      try
      {
        this.pl.mysql.firstJoinPlayer(player);
      }
      catch (SQLException e1)
      {
        this.pl.logger.log(Level.SEVERE, "Nao foi possivel inserir os dados na database.\nERRO: " + 
          e1.getMessage());
        e1.printStackTrace();
      }
    }
  }
  
  
  
  @EventHandler
  public void onJoinEvent(PlayerJoinEvent e) {
    Player player = e.getPlayer();

    e.setJoinMessage(null);
    if ((this.pl.comecando))
    {
      if (!this.pl.vivos.contains(player)) {
    	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("false")) {
        this.pl.vivos.add(player);
    	  }
        player.teleport(player.getWorld().getSpawnLocation());
        player.setExp(0);
        player.giveExpLevels(0);
        
      }
      player.teleport(player.getWorld().getSpawnLocation());
    }
    else if (this.pl.invencibilidade)
    {
      if (!this.pl.vivos.contains(player)) {
      }
      player.teleport(player.getWorld().getSpawnLocation());
    }
    else if (this.pl.aguardando)
    {
      if (!this.pl.vivos.contains(player)) {
    	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("false")) {
        this.pl.vivos.add(player);
    	  }
      }
    }
  }
  
    

  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onLoginVerificarJogo(PlayerLoginEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.acabou)
    {
      e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§c§oO HungerGames já acabou! \n§c§oReiniciando o servidor");
      this.pl.vivos.remove(player);
    }
    if (this.pl.invencibilidade) {
      if ((player.hasPermission("hg.mod")))
      {
          if (!this.pl.vivos.contains(player))
          {
        e.allow();
        this.vanished.add(player);
        this.pl.vivos.remove(player);
        this.pl.admins.add(player);
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(ChatColor.DARK_PURPLE + "§c§oVocê esta no modo admin!");
        player.sendMessage(ChatColor.DARK_PURPLE + "§c§oOs jogadores não ve mais você");
        player.getInventory().clear();
          }
        if (player.hasPermission("hg.mod") && (player.hasPermission("hg.admin")))
  	    {
      libsHg.stafflog(player.getName() + " entrou na ivencibilidade");
  	    }
      }
      else
      { 	  
      if (!this.pl.vivos.contains(player))
      {
    	  
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§bJogo em andamento!\n§6§oVisite nosso site de servidores: §6§o:" + 
                Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
        this.pl.vivos.remove(player);
      }
      }
    }
    if (this.pl.comecou)
    {
      if ((!player.hasPermission("hg.mod")) && (!this.pl.vivos.contains(player)))
      {
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§bJogo em andamento!\n§6§oVisite nosso site de servidores: §6§o:" + 
          Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
        this.pl.vivos.remove(player);
      }
        if ((this.pl.comecando) && (this.pl.aguardando)) {
          if (e.getResult().equals(PlayerLoginEvent.Result.KICK_FULL)) {
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, "§bServidor cheio!\n§6§oVisite nosso site de servidores: §6§o:" + 
                    Config.getConfig(Config.ConfigFile.CONFIG).getString("Site"));
          }
        }
      }
    }
  } 

