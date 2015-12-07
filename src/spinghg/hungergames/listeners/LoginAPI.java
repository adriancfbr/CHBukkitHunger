package spinghg.hungergames.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import spinghg.hungergames.libsHg;

@SuppressWarnings("deprecation")
public class LoginAPI
  implements Listener
{
  private libsHg pl;

  public LoginAPI(libsHg plugin)
  {
    this.pl = plugin;
  }

 
  @SuppressWarnings("static-access")
@EventHandler
  public void onPlace(BlockPlaceEvent e) {
    Player p = e.getPlayer();
    if (this.pl.login.contains(p)) {
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não esta logado use: /entrar <Seu-CDS>.");
      e.setCancelled(true);
    }
  }

  @SuppressWarnings("static-access")
@EventHandler
  public void onBreak(BlockBreakEvent e) {
	  Player p = e.getPlayer();
	  if (this.pl.login.contains(p)) {
	  p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não esta logado use: /entrar <Seu-CDS>.");
      e.setCancelled(true);
  }
  }

  @SuppressWarnings("static-access")
@EventHandler
  public void onBlockDamage(BlockDamageEvent e) {
	  Player p = e.getPlayer();
	  if (this.pl.login.contains(p)) {
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não esta logado use: /entrar <Seu-CDS>.");
      e.setCancelled(true);
  }
  }
  
  @SuppressWarnings({ "static-access" })
@EventHandler
  public void ss1(PlayerChatEvent event) {
    Player p = event.getPlayer();
    if (this.pl.login.contains(p)) {
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não esta logado use: /entrar <Seu-CDS>.");
      event.setCancelled(true);
  }
 }
  @SuppressWarnings("static-access")
@EventHandler
  public void ss2(PlayerMoveEvent event) {
    Player p = event.getPlayer();
    if (this.pl.login.contains(p)) {
      event.setCancelled(true);
  }
 }
  
  @SuppressWarnings("static-access")
@EventHandler
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
	  Player p = event.getPlayer();
	  if (this.pl.login.contains(p)) {
	    if (event.getMessage().toLowerCase().startsWith("/entrar"))
	    {
	    	event.setCancelled(false);
	    	return;
	    }
	    if (event.getMessage().toLowerCase().startsWith("/registrar"))
	    {
	    	event.setCancelled(false);
	    	return;
	    }
	    if (event.getMessage().toLowerCase().startsWith("/login"))
	    {
	    	event.setCancelled(false);
	    	return;
	    }
	    if (event.getMessage().toLowerCase().startsWith("/register"))
	    {
	    	event.setCancelled(false);
	    	return;
	    }
	    {
	    	event.setCancelled(true);
	    	p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não esta logado use: /entrar <Seu-CDS>.");
	    }
	  
  }
  }

	  
}