 package spinghg.hungergames.commands;
 
 import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.NameAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
 
 public class tag
   implements CommandExecutor
 {
   @SuppressWarnings("unused")
private libsHg pl;
   
   public tag(libsHg plugin)
   {
     this.pl = plugin;
   }
   
   /* (non-Javadoc)
 * @see org.bukkit.command.CommandExecutor#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
 */
@EventHandler
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
     {
 	    if (!(sender instanceof Player))
 	    {
 	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
 	      return true;
 	    }
      if ((args.length > 0) && (p.hasPermission("tag.op")))
      {
    	  if (args.length == 0)
          {
    		  p.sendMessage("§cUse: (§fNormal §c| §aVip §c| §9Mvp §c| §6Pro §c| §b§oYoutuber §c| §5Mod §c| §5§oMod+ §c|§c Admin §c| §4Dono)");
            return true;
          }
    	  
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("vip"))
        {
          p.sendMessage("§6Voce esta usando a tag §aVip");
          p.setPlayerListName("§a" + 
                  NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§a" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mvp"))
        {
          p.sendMessage("§6Voce esta usando a tag §9Mvp");
          p.setPlayerListName("§9" + 
                  NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§9" + p.getName());
        }
        else if (args[0].toLowerCase().equals("pro"))
        {
          p.sendMessage("§6Voce esta usando a tag §6Pro");
          p.setPlayerListName("§6" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§6" + p.getName());
        }
        else if (args[0].toLowerCase().equals("youtuber"))
        {
          p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
          p.setPlayerListName("§b§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§b§o" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mod"))
        {
          p.sendMessage("§6Voce esta usando a tag §5MOD");
          p.setPlayerListName("§5" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5 " + p.getName());
        }
        else if (args[0].toLowerCase().equals("mod+"))
        {
          p.sendMessage("§6Voce esta usando a tag §5§oMod+");
          p.setPlayerListName("§5§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5§o" + p.getName());
        }
        else if (args[0].toLowerCase().equals("admin"))
        {
          p.sendMessage("§6Voce esta usando a tag §cAdmin");
          p.setPlayerListName("§c" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§c" + p.getName());
        }
        else if (args[0].toLowerCase().equals("dono"))
        {
          p.sendMessage("§6Voce esta usando a tag §4§oDono");
          p.setPlayerListName("§4" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§4" + p.getName());
        }
        else
        {
         p.sendMessage("§cUse: (§fNormal §c| §aVip §c| §9Mvp §c| §6Pro §c| §b§oYoutuber §c| §5Mod §c| §5§oMod+ §c|§c Admin §c| §4Dono)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.tmod")))
      {
    	  if (args.length == 0)
          {
    		  p.sendMessage("§cUse: (§fNormal §c| §5Mod §c|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }

        else if (args[0].toLowerCase().equals("mod"))
        {
          p.sendMessage("§6Voce esta usando a tag §5MOD");
          p.setPlayerListName("§5" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c| §5Mod §c|)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.mod")))
      {
    	  if (args.length == 0)
          {
              p.sendMessage("§cUse: (§fNormal §c| §5Mod §c| §5§o Mod+ §c|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }

        else if (args[0].toLowerCase().equals("mod"))
        {
          p.sendMessage("§6Voce esta usando a tag §5MOD");
          p.setPlayerListName("§5" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5 "+ p.getName());
        }
        else if (args[0].toLowerCase().equals("mod+"))
        {
          p.sendMessage("§6Voce esta usando a tag §5§oMod+");
          p.setPlayerListName("§5§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5§o" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c| §5Mod §c| §5§o Mod+ §c|)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.mvp")))
      {
    	  if (args.length == 0)
          {
              p.sendMessage("§cUse: (§fNormal §c|§6 Vip §2| §9Mvp§c|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("vip"))
        {
          p.sendMessage("§6Voce esta usando a tag §aVip");
          p.setPlayerListName("§a" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§a" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mvp"))
        {
          p.sendMessage("§6Voce esta usando a tag §9Mvp");
          p.setPlayerListName("§9" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§9" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c|§6 Vip §2| §9Mvp§c|)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.pro")))
      {
    	  if (args.length == 0)
          {
              p.sendMessage("§cUse: (§fNormal §c|§6 Vip §2| §9Mvp§c| §6Pro §c|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("vip"))
        {
          p.sendMessage("§6Voce esta usando a tag §aVip");
          p.setPlayerListName("§a" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§a" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mvp"))
        {
          p.sendMessage("§6Voce esta usando a tag §9Mvp");
          p.setPlayerListName("§9" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§9" + p.getName());
        }
        else if (args[0].toLowerCase().equals("pro"))
        {
          p.sendMessage("§6Voce esta usando a tag §6Pro");
          p.setPlayerListName("§6" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§6" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c|§6 Vip §2| §9Mvp§c| §6Pro §c|)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.yt")))
      {
    	  if (args.length == 0)
          {
              p.sendMessage("§cUse: (§fNormal §c|§b§o Youtuber§c|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("youtuber"))
        {
          p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
          p.setPlayerListName("§b§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§b§o" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c|§b§o Youtuber§c|)");
        }
      }
     
      else if ((args.length > 0) && (p.hasPermission("tag.admin")))
      {
    	  if (args.length == 0)
          {
              p.sendMessage("§cUse: (§fNormal §c| §aVip §c| §9Mvp §c| §6Pro §c| §b§oYoutuber §c|§5§o Mod §c|§c Admin §c)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("vip"))
        {
          p.sendMessage("§6Voce esta usando a tag §aVip");
          p.setPlayerListName("§a" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§a" + p.getName());;
        }
        else if (args[0].toLowerCase().equals("mvp"))
        {
          p.sendMessage("§6Voce esta usando a tag §9Mvp");
          p.setPlayerListName("§9" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§9" + p.getName());
        }
        else if (args[0].toLowerCase().equals("youtuber"))
        {
          p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
          p.setPlayerListName("§b§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§b§o" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mod"))
        {
          p.sendMessage("§6Voce esta usando a tag §5MOD");
          p.setPlayerListName("§5" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5" + p.getName());
        }
        else if (args[0].toLowerCase().equals("mod+"))
        {
          p.sendMessage("§6Voce esta usando a tag §5§oMod+");
          p.setPlayerListName("§5§o" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§5§o" + p.getName());
        }
        else if (args[0].toLowerCase().equals("admin"))
        {
          p.sendMessage("§6 Voce esta usando a tag §cAdmin");
          p.setPlayerListName("§c" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§c " + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c| §aVip §c| §9Mvp §c| §6Pro §c| §b§oYoutuber §c|§5§o Mod §c|§c Admin §c)");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.vip")))
      {
    	  if (args.length == 0)
          {
    		  p.sendMessage("§cUse: (§fNormal §c|§6 Vip §c6|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("vip"))
        {
          p.sendMessage("§6Voce esta usando a tag §6Vip");
          p.setPlayerListName("§a" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§a" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c|§6 Vip §c6|)");
        }
      }
      else if (args.length > 0) {
        if ((args[0].toLowerCase().equals("normal")) || 
          (args[0].toLowerCase().equals("default")))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§c| §fNormal/Default §c|"+ ")");
        }
      }
      else if ((args.length > 0) && (p.hasPermission("tag.helper")))
      {
    	  if (args.length == 0)
          {
    		  p.sendMessage("§cUse: (§fNormal §c|§d Helper §c6|)");
            return true;
          }
        if (args[0].toLowerCase().equals("normal"))
        {
          p.sendMessage("§6Voce esta usando a tag §fNormal");
          p.setPlayerListName("§f" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§f" + p.getName());
        }
        else if (args[0].toLowerCase().equals("helper"))
        {
          p.sendMessage("§6Voce esta usando a tag §dHelper");
          p.setPlayerListName("§d" + NameAPI.getShortStr(p.getName()));
          p.setDisplayName("§d" + p.getName());
        }
        else
        {
          p.sendMessage("§cUse: (§fNormal §c|§d Helper §c6|)");
        }
      }
      
    }
	return false;
}
}