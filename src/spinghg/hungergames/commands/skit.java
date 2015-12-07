package spinghg.hungergames.commands;

import java.util.HashMap;

import spinghg.hungergames.libsHg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
 
 public class skit
 implements CommandExecutor
 {
 private libsHg pl;
   
 public skit(libsHg plugin)
 {
    this.setPl(plugin);
  }
 public HashMap<String, ItemStack[]> kits = new HashMap<String, ItemStack[]>();
 public HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();

 public boolean isInt(String s)
 {
   try
   {
     Integer.parseInt(s);
     return true;
   } catch (NumberFormatException localNumberFormatException) {
   }
   return false;
 }
 
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
 {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("skit")) && (
      (p.hasPermission("hg.skit")) || (p.isOp())))
    {
      if (args.length == 0)
      {
          p.sendMessage("§a§oDigite /skit §7§o<criar> <nome>");
          p.sendMessage("§a§oDigite /skit usar §7§o<nome> <raio>");
        return true;
      }
      if (args[0].equalsIgnoreCase("criar"))
      {
        if (args.length == 1)
        {
            p.sendMessage("§a§o Digite /skit §7§o<criar> <nome>");
            p.sendMessage("§a§oDigite /skit usar §7§o<nome> <raio>");
          return true;
        }
        String name = args[1];
        this.kits.put(name, p.getInventory().getContents());
        this.armor.put(name, p.getInventory().getArmorContents());
        p.sendMessage(ChatColor.GREEN + "Kit " + args[1] + " criado com sucesso!");
        return true;
      }
      if (args[0].equalsIgnoreCase("usar"))
      {
        if (args.length <= 2)
        {
            p.sendMessage("§a§o Digite /skit §7§o<criar> <nome>");
            p.sendMessage("§a§oDigite /skit usar §7§o<nome> <raio>");
          return true;
        }
        String name = args[1];
        if ((!this.kits.containsKey(name)) && (!this.armor.containsKey(name)))
        {
          p.sendMessage("§c§oKit " + name + " nao encontrado!");
          return true;
        }
        if (isInt(args[2]))
        {
          int numero = Integer.parseInt(args[2]);
          for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
            if (!(ent instanceof Player))
              continue;
            Player plr = (Player)ent;
            plr.getInventory().setArmorContents((ItemStack[])this.armor.get(name));
            plr.getInventory().setContents((ItemStack[])this.kits.get(name));
          }
          p.sendMessage("§c§oKit " + name + " aplicado para jogadores em um raio de " + numero + " blocos");
          return true;
        }
      }
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

