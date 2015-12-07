 package spinghg.hungergames.commands;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import spinghg.hungergames.kit.Kit;
import spinghg.hungergames.libsHg;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kits
   implements CommandExecutor
{
 private libsHg pl;
   
   public kits(libsHg plugin)
  {
   this.pl = plugin;
  }
  
   @SuppressWarnings({ "rawtypes", "unchecked" })
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }
     Player player = (Player)sender;

     List meusKits = new ArrayList();
     List outrosKits = new ArrayList();
     for (int i = 0; i < this.pl.km.getKits().size(); i++) {
       if (i < this.pl.km.getKits().size() - 1)
       {
         if (((Kit)this.pl.km.getKits().get(i)).getGratis())
           meusKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
         else if ((!player.hasPermission("planeta.hg.kit." + ((Kit)this.pl.km.getKits().get(i)).getName())) && 
           (!((Kit)this.pl.km.getKits().get(i)).getGratis()))
           outrosKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
         else if (player.hasPermission("planeta.hg.kit." + ((Kit)this.pl.km.getKits().get(i)).getName())) {
           meusKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
         }
       }
       else if (((Kit)this.pl.km.getKits().get(i)).getGratis())
         meusKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
       else if ((!player.hasPermission("planeta.hg.kit." + ((Kit)this.pl.km.getKits().get(i)).getName())) && 
         (!((Kit)this.pl.km.getKits().get(i)).getGratis()))
         outrosKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
       else if (player.hasPermission("planeta.hg.kit." + ((Kit)this.pl.km.getKits().get(i)).getName())) {
         meusKits.add("§7" + ((Kit)this.pl.km.getKits().get(i)).getName());
       }
     }
     String mk = "§bEscolha você seu kit agora: §7/kit [Seu-Kit]\n§aSeus kits :§f %s";
     Collections.sort(meusKits, String.CASE_INSENSITIVE_ORDER);
     String list = StringUtils.join(meusKits, "§3, §r");
     String meus = String.format(mk, new Object[] { list });
     if (outrosKits.isEmpty()) {
       outrosKits.add("§bvocê já tem todos os kits.");
     }
     Collections.sort(outrosKits, String.CASE_INSENSITIVE_ORDER);
     String ok = "§aOutros kits:§f %s\n§9Compre seu vip agora: (Em breve) §b";
     String list1 = StringUtils.join(outrosKits, "§3, §r");
     String outros = String.format(ok, new Object[] { list1 });

     String send = meus + "\n" + outros;
     player.sendMessage(send);

     return false;
   }
 }
