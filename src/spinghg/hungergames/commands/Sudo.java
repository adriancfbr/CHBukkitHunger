package spinghg.hungergames.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;

public class Sudo
implements CommandExecutor, Listener
{
private libsHg pl;

  public Sudo(libsHg plugin)
 {
    this.setPl(plugin);
 }

ArrayList<Player> vanished = new ArrayList<Player>();

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
	Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("sudo")) {
        if (sender.hasPermission("hg.admin")) {
    	    if (!(sender instanceof Player))
    	    {
    	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
    	      return true;
    	    }
          if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + 
              "Porfavor Informe um nome.");
            return true;
          }
          if (args.length == 1) {
            sender.sendMessage(ChatColor.GREEN + "Não pode forçar um jogador a executar um comando:§7 null");
            return true;
          }
          Player player = Bukkit.getPlayer(args[0]);
          if (player == null) {
            sender.sendMessage(ChatColor.GREEN + 
              "Jogador não esta online.");
            return true;
          }
          String chat = StringUtils.join(
            Arrays.copyOfRange(args, 1, args.length), " ");
          if (chat.startsWith("/")) {
            chat = chat.substring(1);
            sender.sendMessage(ChatColor.RED + "Voce forcou " + 
              player.getName() + " rodar um comando");
            boolean op = player.isOp();
            if (!op) {
              player.setOp(true);
            }
            Bukkit.dispatchCommand(player, chat);
            if (!op) {
              player.setOp(false);
            }
            System.out.print(sender.getName() + " forcou " + 
              player.getName() + " rodar um comando: " + chat);
          } else {
            sender.sendMessage(ChatColor.RED + " forçou " + 
              player.getName() + " falar uma mensagem");
            player.chat(chat);
            System.out.print(sender.getName() + " forçou " + 
              player.getName() + " dizer " + chat);
          }
          if (args.length == 0)
            return false;
        }
        else {
          p.sendMessage("§cVocê não pode usar este comando.");
        }
        return true;
      }

return false;
}

public libsHg getPl() {
	return pl;
}

public void setPl(libsHg pl) {
	this.pl = pl;
}
}
 
