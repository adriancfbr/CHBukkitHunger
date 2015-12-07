package spinghg.hungergames.commands;

import java.util.ArrayList;
import java.util.List;

import spinghg.hungergames.Menu.KitMenu;
import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.libsHg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
 public class kit
  implements CommandExecutor
{
 private libsHg pl;

 public kit(libsHg plugin)
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
  if (args.length == 0)
   {
   KitMenu.guiKits(player);
     return true;
 }
  if (args.length == 1)
 {
 List<String> nomes = new ArrayList<String>();
 for (Kit kit : this.pl.km.getKits()) {
  nomes.add(kit.getName());
     }
    char[] stringArray = args[0].toCharArray();
   stringArray[0] = Character.toUpperCase(stringArray[0]);
   args[0] = new String(stringArray);
  if (nomes.contains(args[0]))
   {
	  if (this.pl.kit) {
 if ((this.pl.comecando) || (this.pl.aguardando))
 {
   if ((!player.hasPermission("planeta.hg.kit." + args[0])) && (!this.pl.km.getKitByName(args[0]).getGratis()))
  {
 player.sendMessage("§a§oVocê não tem este kit! \n§9Compre este kit:§7 (Em breve)");
 return true;
  }
  this.pl.km.setKit(this.pl.km.getKitByName(args[0]), player);
  player.sendMessage("§a§oVocê esta usando o kit: §7§o" + ((Kit)this.pl.km.playerKit.get(player)).getName());
  player.sendMessage("§9Para escolher um kit: §7/kit [Nome do kit] \n§a§oUse /kits para ver seus kits!");
  if (player.hasPermission("hg.mod") && (player.hasPermission("hg.admin")))
  {
 libsHg.stafflog(player.getName() + " pegou o kit " + ((Kit)this.pl.km.playerKit.get(player)).getName());
  }
 return false;
    }
	  }
	  if (this.pl.kit) {
  if (this.pl.invencibilidade)
 {
   if ((!player.hasPermission("plante.hg.kit." + args[0])) && (!this.pl.km.getKitByName(args[0]).getGratis()))
      {
      player.sendMessage("§a§oVocê não tem este kit! \n§9Compre este kit:§7 (Em breve)");
 player.sendMessage("§9Para escolher um kit: §7/kit [Nome do kit] \n§a§oUse /kits para ver seus kits!");
 return true;
    }
   if (player.hasPermission("planeta.vip.mais"))
      {
   if (!this.pl.km.temKit(player))
    {
       this.pl.km.setKit(this.pl.km.getKitByName(args[0]), player);
         this.pl.km.giveKitItems(player);
      player.sendMessage("§a§oVocê esta usando o kit: §7§o " + ((Kit)this.pl.km.playerKit.get(player)).getName());
    player.sendMessage("§9Para escolher um kit: §7/kit [Nome do kit] \n§a§oUse /kits para ver seus kits!");
         }
       else
   {
          player.sendMessage("§cO HungerGames ja começou!");
    return true;
     }
 }
  else
  {
 player.sendMessage("§a§oVocê já esta usando:§7§o " + ((Kit)this.pl.km.playerKit.get(player)).getName());
   return true;
  }
return false;
 }
	  }
    if (this.pl.comecou)
       {
 player.sendMessage("§cO HungerGames já come§ou!");
return true;
 }
 }
   else
 {
  player.sendMessage("§c§oNão foi possivel encontrar este kit.");
  player.sendMessage("§9§oVocê quer usar §7§o[/kit Stomper ]§9§o ?");
     return true;
 }
  }
  
if (args.length > 1)
 {
  player.sendMessage("§9Para escolher um kit: §7/kit [Nome do kit] \n§a§oUse /kits para ver seus kits!");
  return true;
}

if (!this.pl.kit) {
	  player.sendMessage("§cOs kits esta desativado!");
}
 return false;
  }
 }
