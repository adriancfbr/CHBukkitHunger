package spinghg.hungergames.commands;

import java.util.ArrayList;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.BossBar;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class spect
implements CommandExecutor, Listener
{
private libsHg pl;

  public spect(libsHg plugin)
 {
    this.pl = plugin;
 }

ArrayList<Player> vanished = new ArrayList<Player>();

@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("spect")) && 
    (p.hasPermission("hg.spect")))
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
	  if ((this.pl.comecou) || (this.pl.invencibilidade)) {
   if (!this.vanished.contains(p))
    {
      for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
        pl.hidePlayer(p);
      }
    
      this.vanished.add(p);
      this.pl.vivos.remove(p);
      this.pl.admins.add(p);
      p.setAllowFlight(false);
      p.setFlying(false);
      p.setGameMode(GameMode.CREATIVE);
      BossBar.setMessage(p, "§b§oVoce entrou no modo: Spectador", 4);
      p.setGameMode(GameMode.ADVENTURE);
      p.setAllowFlight(true);
      p.setFlying(true);
      p.getInventory().clear();
      p.getInventory().setArmorContents(null);
      if (p.hasPermission("hg.mod") && (p.hasPermission("hg.admin")))
	    {
  libsHg.stafflog(p.getName() + " entrou no modo admin");
	    }
    }
    }
    if ((this.pl.comecando) || (this.pl.acabou)) {
    	p.sendMessage("§cEspere a partida iniciar para ficar no spect.");
}
  }
return false;
}
}
 
