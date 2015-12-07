package spinghg.hungergames.commands;

 import spinghg.hungergames.libsHg;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 
 public class fly
   implements CommandExecutor
 {
   private libsHg pl;
   
   public fly(libsHg plugin)
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
     if (!player.hasPermission("planeta.vip"))
     {
       player.sendMessage("§cVocê não pode ativar o fly!");
       return true;
     }
     if ((!this.pl.comecando) && (!this.pl.aguardando) && (!player.hasPermission("hg.admin")))
     {
       player.sendMessage("§bO HungerGames já comeÃ§ou!");
       return true;
     }
     if (!player.getAllowFlight())
     {
       player.setAllowFlight(true);
       player.sendMessage("§aModo fly: Ativo");
     }
     else
     {
      player.setAllowFlight(false);
       player.sendMessage("§cModo fly: desativado");
     }
     return false;
   }
 }
