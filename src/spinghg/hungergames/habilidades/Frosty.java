package spinghg.hungergames.habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Frosty
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Frosty(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageFrosty(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Frosty"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Frosty (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Frosty", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onPlayerFrosty(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SNOW_BLOCK) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SNOW) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ICE)) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Frosty"))))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
      return;
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Frosty")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Frosty");
	    }

	    return false;
	  }
}
