package spinghg.hungergames.habilidades;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Torre
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Torre(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageStomper(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Stomper"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Torre (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Torre", 1);
      }
    }
  }
  
  }
  @EventHandler
  public void stomperEvent(EntityDamageEvent event) {
    if (!(event.getEntity() instanceof Player)) {
      return;
    }
    if (this.pl.kit) 
    if ((this.pl.comecou) || (this.pl.acabou)) {
    Player player = (Player)event.getEntity();
    if (event.getCause() != EntityDamageEvent.DamageCause.FALL)
    {
      event.getDamage();
      return;
    }
    if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Torre")))) {
      return;
    }
    if (event.getDamage() > 4.0D) {
      event.setDamage(4.0D);
    }
    for (Entity stomped : player.getNearbyEntities(3.0D, 3.0D, 3.0D))
    {
      if (!(stomped instanceof Player)) {
        return;
      }
      if (!((Player)stomped).isSneaking())
      {
        ((Player)stomped).damage(player.getFallDistance(), player);
        Player st = (Player)stomped;
        EntityPlayer p = ((CraftPlayer)st).getHandle();
        if (p.getHealth() - player.getFallDistance() < 1.0F) {
          st.sendMessage("§bVoce foi stompado por §7" + player.getName() + "§b.");
        }
      }
      else
      {
        ((Player)stomped).damage(player.getFallDistance() / 3.0F, player);
        Player st = (Player)stomped;
        EntityPlayer p = ((CraftPlayer)st).getHandle();
        if (p.getHealth() - player.getFallDistance() / 4.0F < 1.0F)
          st.sendMessage("§bVoce foi stompado por §7" + player.getName() + "§b.");
      }
    }
  }
}
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Torre")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Torre");
	    }

	    return false;
	  }
}
