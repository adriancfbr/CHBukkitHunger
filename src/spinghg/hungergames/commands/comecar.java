package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comecar
   implements CommandExecutor
 {
 private libsHg pl;

public comecar(libsHg plugin)
 {
 this.pl = plugin;
}

 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
 {
    Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
      return true;
    }
   if (!sender.hasPermission("hg.admin"))
    {
     sender.sendMessage("§c§oVocê não pode iniciar a partida!");
   return true;
  }
 if (this.pl.comecando)
  {
    if (this.pl.startingCounter > 60)
      {
   this.pl.startingCounter = 60;
   Bukkit.broadcastMessage("§c§o[Aviso] O " + p.getName() + " mudou o tempo para 60 segundos!" );
   if (sender.hasPermission("hg.mod") && (sender.hasPermission("hg.admin")))
   {
  libsHg.stafflog(sender.getName() + " utilizou o start");
   }
}
 else
  {
      sender.sendMessage("§cTorneio já inicia em " + this.pl.startingCounter);
     return true;
      }
   }
  else
  {
    sender.sendMessage("§cA partida iniciou você não pode iniciar novamente");
   return true;
  }
    return false;
  }
 }
