package spinghg.hungergames.habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Demoman
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Demoman(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageDemoman(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Demoman"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Demoman (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Demoman", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onMoveOnPlate(PlayerMoveEvent event)
  {
    Block b = event.getPlayer().getLocation().getBlock();
    if (this.pl.kit) 
    if ((b.hasMetadata("Placer")) && (b.getType() == Material.STONE_PLATE) && (b.getRelative(BlockFace.DOWN).getType() == Material.GRAVEL))
    {
      b.removeMetadata("Placer", this.pl);
      b.setType(Material.AIR);
      b.getWorld().createExplosion(b.getLocation().clone().add(0.5D, 0.5D, 0.5D), 4.0F);
    }
  }
  
  @EventHandler
  public void onPlace(BlockPlaceEvent event)
  {
	  if (this.pl.kit) 
    if ((event.getBlock().getType() == Material.STONE_PLATE) && (this.pl.km.getPlayerKit(event.getPlayer(), this.pl.km.getKitByName("Demoman"))))
    {
      event.getBlock().removeMetadata("Placer", this.pl);
      event.getBlock().setMetadata("Placer", new FixedMetadataValue(this.pl, event.getPlayer().getName()));
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Demoman")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Demoman");
	    }

	    return false;
	  }
}
