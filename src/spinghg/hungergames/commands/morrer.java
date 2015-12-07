package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.Join;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Sound;


public class morrer implements CommandExecutor
{
private libsHg pl;

  public morrer(libsHg plugin)
 {
    this.pl = plugin;
 }

@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("morrer")))
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
    {
      if ((this.pl.comecou) || (this.pl.invencibilidade)) {
      this.pl.vivos.remove(p);
      p.getInventory().clear();
      p.getInventory().setArmorContents(null);
      p.kickPlayer("§bVocê cometeu suicidio");
      for (Player online : Bukkit.getOnlinePlayers())
      {
        online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
      }
      Bukkit.broadcastMessage("§bJogador " + p.getName() + " cometeu suicidio. \n§b§oJogadores vivos:  " + Join.getOnlinePlayers());      
    }
      if ((this.pl.comecando) || (this.pl.acabou) || (this.pl.comecando)) {
    	  p.sendMessage("§cVocê não pode se matar agora!");
      }

    }
}
return false;
}
}
 
