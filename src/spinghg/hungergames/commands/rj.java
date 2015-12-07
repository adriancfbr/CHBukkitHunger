package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.Join;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class rj
  implements CommandExecutor, Listener
{
  private libsHg pl;

  public rj(libsHg plugin)
  {
    this.pl = plugin;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cApenas jogadores podem executar esse comando!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("rj"))
    {
      if (!player.hasPermission("hg.admin"))
      {
        player.sendMessage("§cVocê não tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage("§cUse /rj [Jogador] para remover um jogador da partida.");
        return true;
      }
      
      
      
      if (args.length == 1)
      {   
    	  if ((this.pl.comecou) || (this.pl.invencibilidade)) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null)
        {
          player.sendMessage("Esse jogador não existe!");
        }
        if ((target instanceof Player))
          this.pl.vivos.remove(target);
        player.sendMessage("§e§oO jogador " + target.getName() + "§f§o foi removido da partida");
    	 target.kickPlayer("§bVocê morreu!"); 
    	 Bukkit.broadcastMessage("§b " + target.getName() + " morreu.\n§b§oJogadores vivos: " + Join.getOnlinePlayers());
    	  }	  
    	  if ((this.pl.comecando) || (this.pl.acabou)) {
    		player.sendMessage("§cEsperando antes de remover um jogador da partida.");
    	  }
    	  }
        return true;
      }
    return false;
  }
}