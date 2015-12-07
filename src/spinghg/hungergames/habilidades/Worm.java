package spinghg.hungergames.habilidades;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Worm
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Worm(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageWorm(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Worm"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else {        BossBar.setMessage(damager, p.getName() + " - Worm", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onDamage(BlockDamageEvent event)
  {
	  if (this.pl.kit) 
	 if ((this.pl.comecou) || (this.pl.invencibilidade))
    if ((this.pl.km.temKit(event.getPlayer())) && (this.pl.km.getPlayerKit(event.getPlayer(), this.pl.km.getKitByName("Worm"))) && 
      (event.getBlock().getType() == Material.DIRT))
    {
      Player p = event.getPlayer();
      boolean drop = true;
      EntityPlayer ep = ((CraftPlayer)p).getHandle();
      if (ep.getHealth() < 20.0D)
      {
        float hp = ep.getHealth() + 1.0F;
        if (hp > 20.0D) {
          hp = 20.0F;
        }
        p.setHealth(hp);
        drop = false;
      }
      else if (p.getFoodLevel() < 20)
      {
        p.setFoodLevel(p.getFoodLevel() + 1);
        drop = false;
      }
      event.getBlock().getWorld().playEffect(event.getBlock().getLocation(), Effect.STEP_SOUND, Material.DIRT.getId());
      event.getBlock().setType(Material.AIR);
      if (drop) {
        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5D, 0.0D, 0.5D), new ItemStack(Material.DIRT));
      }
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
	  if (this.pl.kit) 
    if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && ((event.getEntity() instanceof Player)))
    {
      Player player = (Player)event.getEntity();
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Worm"))))
      {
        Location loc = event.getEntity().getLocation();
        boolean dirt = false;
        for (float x = -0.35F; (x <= 0.35F) && (!dirt); x += 0.35F) {
          for (float z = -0.35F; (z <= 0.35F) && (!dirt); z += 0.35F)
          {
            Block b = loc.clone().add(x, -1.0D, z).getBlock();
            if (b.getType() == Material.DIRT) {
              dirt = true;
            }
          }
        }
        if (dirt) {
          event.setCancelled(true);
        }
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Worm")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Worm");
	    }

	    return false;
	  }
}
