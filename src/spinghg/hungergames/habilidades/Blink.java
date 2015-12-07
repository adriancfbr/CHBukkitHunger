package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Blink
implements Listener, CommandExecutor
{
  private Map<String, Long> cooldown = new HashMap();
  private Map<String, Integer> cooldown3 = new HashMap();
  private libsHg pl;
  
  public Blink(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageBlink(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Blink"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Blink (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Blink", 1);
      }
    }
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void adfre(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (this.pl.kit) 
    if ((event.getItem() == null) || (event.getItem().getType() == Material.AIR)) {
      return;
    }
    if (event.getItem().getType() != Material.NETHER_STAR) {
      return;
    }
    if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Blink"))))
    {
      if ((this.cooldown.containsKey(p.getName())) && 
        (((Long)this.cooldown.get(p.getName())).longValue() > System.currentTimeMillis()))
      {
        p.sendMessage("§4Blink está em cooldown!");
        return;
      }
      if (!this.cooldown3.containsKey(p.getName())) {
        this.cooldown3.put(p.getName(), Integer.valueOf(1));
      }
      if (((Integer)this.cooldown3.get(p.getName())).intValue() <= 3) {
        this.cooldown3.put(p.getName(), Integer.valueOf(((Integer)this.cooldown3.get(p.getName())).intValue() + 1));
      }
      if (((Integer)this.cooldown3.get(p.getName())).intValue() > 3)
      {
        this.cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 20000L));
        this.cooldown3.remove(p.getName());
      }
      p.teleport(p.getTargetBlock(null, 7).getLocation());
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Blacksmith")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Blacksmith");
	    }

	    return false;
	  }
}
