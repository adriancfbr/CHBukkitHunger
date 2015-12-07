package spinghg.hungergames.commands;

import spinghg.hungergames.libsHg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mudartempo implements CommandExecutor
 {
 private static final String Timers = null;
private libsHg pl;

public mudartempo(libsHg plugin)
 {
 this.pl = plugin;
}

public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
{
  if ((paramCommandSender instanceof Player))
  {
      Player p = (Player)paramCommandSender;
      if (paramString.equalsIgnoreCase("tempo")&& 
    	      (p.hasPermission("hg.admin")))
  
  	    if (!(p instanceof Player))
  	    {
  	      p.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
  	      return true;
  	    }
      
 if (this.pl.comecando) {
  {
	 if (paramArrayOfString.length == 1)
      {
		 if (p.isOp()) {
   this.pl.startingCounter = Integer.valueOf(Integer.parseInt(paramArrayOfString[0]));
		 }
      } 
  }
  
 } 
      if (this.pl.invencibilidade) {
    	  
    		 if (paramArrayOfString.length == 1)
    	      {
    			 if (p.isOp()) {
    			 this.pl.invicCounter = Integer.valueOf(Integer.parseInt(paramArrayOfString[0]));
    			 }
    	      } 
    	  }
          if (this.pl.comecou)     	  
        	  {	
        	  if (paramArrayOfString.length == 1)
       	      {
        		  if (p.isOp()) {
        			 this.pl.partidaCounter = Integer.valueOf(Integer.parseInt(paramArrayOfString[0]));
        	      }    	  
       	      }
    	 }
          

return false;

 }
return false;
}

public static String getTimers() {
	return Timers;
}
 }
 
