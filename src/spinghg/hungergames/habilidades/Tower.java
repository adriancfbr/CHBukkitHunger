package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Tower implements Listener, CommandExecutor
{
	  private libsHg pl;
	  
	  public Tower(libsHg plugin)
	  {
	    this.pl = plugin;
	  }

	  public static List<Player> Tower = new ArrayList<Player>();
	  
	  
	  @EventHandler
	  public void onDamageTower(EntityDamageByEntityEvent e)
	  {
		  if (this.pl.comecou)
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Entity ent = e.getEntity();
	      Player player = (Player)e.getEntity();
	      Player damager = (Player)e.getDamager();
	      Player p = (Player)ent;
	      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Tower"))) && 
	        (damager.getItemInHand() != null) && 
	        (damager.getItemInHand().getType() != null)) {
	    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
	    	  {
	    		  BossBar.setMessage(damager, p.getName() + " - Tower (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
	    	  }
	    	  else
	    	  {
	        BossBar.setMessage(damager, p.getName() + " - Tower", 1);
	    	  }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
	  {
	      Player p = event.getPlayer();
	      if (!this.Tower.contains(p)) {
	      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Tower")))) {
	      if (!(event.getRightClicked() instanceof Player)) {
	          return;
	        }
	    if ((p.getItemInHand().getType() == Material.NETHER_STAR))
	    {
	    	
	      final Player p2 = (Player)event.getRightClicked();
          p.sendMessage("§6--> Criado torre para o jogador §o" + p2.getName());
          p2.sendMessage("§6--> O jogador " + p.getName() + " criou uma torre para você");
          p.setItemInHand(new ItemStack(0));
          
	        
	      Location loc = event.getPlayer().getLocation();
	         loc = loc.getWorld().getHighestBlockAt(loc).getLocation().add(0.0D,  50.0D, 0.0D);
	         for (int x = -1; x <= 3; x++) {
	           for (int z = -1; z <= 3; z++)
	           {
	        	   final Block chest = loc.clone().add(1, 0.0D, 3).getBlock();
		             chest.setType(Material.CHEST);
		             
	        	 final Block b = loc.clone().add(x, -1.0D, z).getBlock();
	             b.setType(Material.DIRT);
	               
	             final Block a = loc.clone().add(1, -2.0D, 1).getBlock();
	             a.setType(Material.DIRT); 
	             
	             final Block c = loc.clone().add(1, -3.0D, 1).getBlock();
	             c.setType(Material.DIRT); 
	             
	             final Block d = loc.clone().add(1, -4.0D, 1).getBlock();
	             d.setType(Material.DIRT); 
	             
	             final Block f = loc.clone().add(1, -5.0D, 1).getBlock();
	             f.setType(Material.DIRT); 
	             
	             final Block o = loc.clone().add(1, -6.0D, 1).getBlock();
	             o.setType(Material.DIRT); 
	             
	             final Block ç = loc.clone().add(1, -7.0D, 1).getBlock();
	            ç.setType(Material.DIRT); 
	             
	             final Block g = loc.clone().add(1, -8.0D, 1).getBlock();
	             g.setType(Material.DIRT); 
	             
	             final Block h = loc.clone().add(1, -9.0D, 1).getBlock();
	             h.setType(Material.DIRT); 
	             
	             final Block j = loc.clone().add(1, -10.0D, 1).getBlock();
	             j.setType(Material.DIRT); 
	             
	             final Block q = loc.clone().add(1, -11.0D, 1).getBlock();
	             q.setType(Material.DIRT); 
	             
	             final Block y = loc.clone().add(1, -12.0D, 1).getBlock();
	             y.setType(Material.DIRT); 
	             
	             final Block i = loc.clone().add(1, -13.0D, 1).getBlock();
	             i.setType(Material.DIRT); 
	             
	             final Block w = loc.clone().add(1, -14.0D, 1).getBlock();
	             w.setType(Material.DIRT); 
	             
	             final Block aa = loc.clone().add(1, -15.0D, 1).getBlock();
	             aa.setType(Material.DIRT); 
	             
	             final Block v = loc.clone().add(1, -16.0D, 1).getBlock();
	             v.setType(Material.DIRT); 
	             
	             final Block m = loc.clone().add(1, -17.0D, 1).getBlock();
	             m.setType(Material.DIRT); 
	             
	             final Block daa = loc.clone().add(1, -18.0D, 1).getBlock();
	             daa.setType(Material.DIRT); 
	             
	             final Block daaa = loc.clone().add(1, -19.0D, 1).getBlock();
	             daaa.setType(Material.DIRT); 
	             
	             final Block dw = loc.clone().add(1, -20.0D, 1).getBlock();
	             dw.setType(Material.DIRT); 
	             
	             final Block dww = loc.clone().add(1, -21.0D, 1).getBlock();
	             dww.setType(Material.DIRT); 
	             
	             final Block du = loc.clone().add(1, -21.0D, 1).getBlock();
	             du.setType(Material.DIRT);
	             
	             final Block da = loc.clone().add(1, -22.0D, 1).getBlock();
	             da.setType(Material.DIRT); 
	             
	             final Block dkk = loc.clone().add(1, -23.0D, 1).getBlock();
	             dkk.setType(Material.DIRT); 
	             
	             final Block ee = loc.clone().add(1, -24.0D, 1).getBlock();
	             ee.setType(Material.DIRT);
	             
	             final Block oo = loc.clone().add(1, -25.0D, 1).getBlock();
	             oo.setType(Material.DIRT); 
	             
	             final Block ll = loc.clone().add(1, -26.0D, 1).getBlock();
	             ll.setType(Material.DIRT); 
	             
	             final Block hh = loc.clone().add(1, -27.0D, 1).getBlock();
	             hh.setType(Material.DIRT); 
	             
	             final Block djk = loc.clone().add(1, -28.0D, 1).getBlock();
	             djk.setType(Material.DIRT); 
	             
	             final Block dr = loc.clone().add(1, -29.0D, 1).getBlock();
	             dr.setType(Material.DIRT); 
	             
	             final Block drr = loc.clone().add(1, -30.0D, 1).getBlock();
	             drr.setType(Material.DIRT); 
	             
	             final Block djjj = loc.clone().add(1, -31.0D, 1).getBlock();
	             djjj.setType(Material.DIRT); 
	             
	             final Block dj = loc.clone().add(1, -32.0D, 1).getBlock();
	             dj.setType(Material.DIRT); 
	             
	             final Block dk = loc.clone().add(1, -33.0D, 1).getBlock();
	             dk.setType(Material.DIRT); 
	             
	             final Block dd = loc.clone().add(1, -34.0D, 1).getBlock();
	             dd.setType(Material.DIRT); 
	             
	             final Block df = loc.clone().add(1, -35.0D, 1).getBlock();
	             df.setType(Material.DIRT); 
	             
	             final Block dff = loc.clone().add(1, -36.0D, 1).getBlock();
	             dff.setType(Material.DIRT); 
	             
	             final Block dy = loc.clone().add(1, -37.0D, 1).getBlock();
	             dy.setType(Material.DIRT); 
	             
	             final Block dyy = loc.clone().add(1, -38.0D, 1).getBlock();
	             dyy.setType(Material.DIRT); 
	             
	             final Block doo = loc.clone().add(1, -39.0D, 1).getBlock();
	             doo.setType(Material.DIRT); 
	             
	             final Block dooo = loc.clone().add(1, -40.0D, 1).getBlock();
	             dooo.setType(Material.DIRT); 
	             
	             final Block dkkll = loc.clone().add(1, -41.0D, 1).getBlock();
	             dkkll.setType(Material.DIRT); 
	             	             
	             final Block dtt = loc.clone().add(1, -42.0D, 1).getBlock();
	             dtt.setType(Material.DIRT); 
	             
	             final Block dmm = loc.clone().add(1, -43.0D, 1).getBlock();
	             dmm.setType(Material.DIRT); 
	             
	             final Block dop = loc.clone().add(1, -44.0D, 1).getBlock();
	             dop.setType(Material.DIRT); 
	             
	             final Block dll = loc.clone().add(1, -45.0D, 1).getBlock();
	             dll.setType(Material.DIRT); 
	             
	             final Block dkkg = loc.clone().add(1, -46.0D, 1).getBlock();
	             dkkg.setType(Material.DIRT); 
	             
	             final Block dii = loc.clone().add(1, -47.0D, 1).getBlock();
	             dii.setType(Material.DIRT); 
	             
	             final Block di = loc.clone().add(1, -48.0D, 1).getBlock();
	             di.setType(Material.DIRT); 
	             
	             final Block dgg = loc.clone().add(1, -49.0D, 1).getBlock();
	             dgg.setType(Material.DIRT); 
	             
	             final Block dg = loc.clone().add(1, -50.0D, 1).getBlock();
	             dg.setType(Material.DIRT); 
	             
	             p2.teleport(loc.add(0.0D, 0.0D,0.0D));	
	             p2.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
	             p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
	             this.Tower.add(p);
	           }
	         }
	    }
	    }
	      }
	      }
	      
	  @EventHandler
	  public void Clicar(PlayerInteractEvent e)
	  {
	         Player p = e.getPlayer();
	      	 Location loc = e.getPlayer().getLocation();
		      if (!this.Tower.contains(p)) {
	         if (((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Tower"))) && 
	        	      (e.getAction() == Action.LEFT_CLICK_BLOCK) && (p.getItemInHand().getType() == Material.NETHER_STAR)) || ((e.getAction() == Action.LEFT_CLICK_AIR) && 
	        	      (p.getItemInHand().getType() == Material.NETHER_STAR))) {
	        	 p.sendMessage("§6--> A torre foi criado com exito!");
	        	  p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.NETHER_STAR) });
	         loc = loc.getWorld().getHighestBlockAt(loc).getLocation().add(0.0D,  50.0D, 0.0D);
	         for (int x = -1; x <= 3; x++) {
	           for (int z = -1; z <= 3; z++)
	           {
	        	   final Block chest = loc.clone().add(1, 0.0D, 3).getBlock();
		             chest.setType(Material.CHEST);
		             
	        	 final Block b = loc.clone().add(x, -1.0D, z).getBlock();
	             b.setType(Material.DIRT);
	               
	             final Block a = loc.clone().add(1, -2.0D, 1).getBlock();
	             a.setType(Material.DIRT); 
	             
	             final Block c = loc.clone().add(1, -3.0D, 1).getBlock();
	             c.setType(Material.DIRT); 
	             
	             final Block d = loc.clone().add(1, -4.0D, 1).getBlock();
	             d.setType(Material.DIRT); 
	             
	             final Block f = loc.clone().add(1, -5.0D, 1).getBlock();
	             f.setType(Material.DIRT); 
	             
	             final Block o = loc.clone().add(1, -6.0D, 1).getBlock();
	             o.setType(Material.DIRT); 
	             
	             final Block ç = loc.clone().add(1, -7.0D, 1).getBlock();
	            ç.setType(Material.DIRT); 
	             
	             final Block g = loc.clone().add(1, -8.0D, 1).getBlock();
	             g.setType(Material.DIRT); 
	             
	             final Block h = loc.clone().add(1, -9.0D, 1).getBlock();
	             h.setType(Material.DIRT); 
	             
	             final Block j = loc.clone().add(1, -10.0D, 1).getBlock();
	             j.setType(Material.DIRT); 
	             
	             final Block q = loc.clone().add(1, -11.0D, 1).getBlock();
	             q.setType(Material.DIRT); 
	             
	             final Block y = loc.clone().add(1, -12.0D, 1).getBlock();
	             y.setType(Material.DIRT); 
	             
	             final Block i = loc.clone().add(1, -13.0D, 1).getBlock();
	             i.setType(Material.DIRT); 
	             
	             final Block w = loc.clone().add(1, -14.0D, 1).getBlock();
	             w.setType(Material.DIRT); 
	             
	             final Block aa = loc.clone().add(1, -15.0D, 1).getBlock();
	             aa.setType(Material.DIRT); 
	             
	             final Block v = loc.clone().add(1, -16.0D, 1).getBlock();
	             v.setType(Material.DIRT); 
	             
	             final Block m = loc.clone().add(1, -17.0D, 1).getBlock();
	             m.setType(Material.DIRT); 
	             
	             final Block daa = loc.clone().add(1, -18.0D, 1).getBlock();
	             daa.setType(Material.DIRT); 
	             
	             final Block daaa = loc.clone().add(1, -19.0D, 1).getBlock();
	             daaa.setType(Material.DIRT); 
	             
	             final Block dw = loc.clone().add(1, -20.0D, 1).getBlock();
	             dw.setType(Material.DIRT); 
	             
	             final Block dww = loc.clone().add(1, -21.0D, 1).getBlock();
	             dww.setType(Material.DIRT); 
	             
	             final Block du = loc.clone().add(1, -21.0D, 1).getBlock();
	             du.setType(Material.DIRT);
	             
	             final Block da = loc.clone().add(1, -22.0D, 1).getBlock();
	             da.setType(Material.DIRT); 
	             
	             final Block dkk = loc.clone().add(1, -23.0D, 1).getBlock();
	             dkk.setType(Material.DIRT); 
	             
	             final Block ee = loc.clone().add(1, -24.0D, 1).getBlock();
	             ee.setType(Material.DIRT);
	             
	             final Block oo = loc.clone().add(1, -25.0D, 1).getBlock();
	             oo.setType(Material.DIRT); 
	             
	             final Block ll = loc.clone().add(1, -26.0D, 1).getBlock();
	             ll.setType(Material.DIRT); 
	             
	             final Block hh = loc.clone().add(1, -27.0D, 1).getBlock();
	             hh.setType(Material.DIRT); 
	             
	             final Block djk = loc.clone().add(1, -28.0D, 1).getBlock();
	             djk.setType(Material.DIRT); 
	             
	             final Block dr = loc.clone().add(1, -29.0D, 1).getBlock();
	             dr.setType(Material.DIRT); 
	             
	             final Block drr = loc.clone().add(1, -30.0D, 1).getBlock();
	             drr.setType(Material.DIRT); 
	             
	             final Block djjj = loc.clone().add(1, -31.0D, 1).getBlock();
	             djjj.setType(Material.DIRT); 
	             
	             final Block dj = loc.clone().add(1, -32.0D, 1).getBlock();
	             dj.setType(Material.DIRT); 
	             
	             final Block dk = loc.clone().add(1, -33.0D, 1).getBlock();
	             dk.setType(Material.DIRT); 
	             
	             final Block dd = loc.clone().add(1, -34.0D, 1).getBlock();
	             dd.setType(Material.DIRT); 
	             
	             final Block df = loc.clone().add(1, -35.0D, 1).getBlock();
	             df.setType(Material.DIRT); 
	             
	             final Block dff = loc.clone().add(1, -36.0D, 1).getBlock();
	             dff.setType(Material.DIRT); 
	             
	             final Block dy = loc.clone().add(1, -37.0D, 1).getBlock();
	             dy.setType(Material.DIRT); 
	             
	             final Block dyy = loc.clone().add(1, -38.0D, 1).getBlock();
	             dyy.setType(Material.DIRT); 
	             
	             final Block doo = loc.clone().add(1, -39.0D, 1).getBlock();
	             doo.setType(Material.DIRT); 
	             
	             final Block dooo = loc.clone().add(1, -40.0D, 1).getBlock();
	             dooo.setType(Material.DIRT); 
	             
	             final Block dkkll = loc.clone().add(1, -41.0D, 1).getBlock();
	             dkkll.setType(Material.DIRT); 
	             
	             
	             final Block dtt = loc.clone().add(1, -42.0D, 1).getBlock();
	             dtt.setType(Material.DIRT); 
	             
	             final Block dmm = loc.clone().add(1, -43.0D, 1).getBlock();
	             dmm.setType(Material.DIRT); 
	             
	             final Block dop = loc.clone().add(1, -44.0D, 1).getBlock();
	             dop.setType(Material.DIRT); 
	             
	             final Block dll = loc.clone().add(1, -45.0D, 1).getBlock();
	             dll.setType(Material.DIRT); 
	             
	             final Block dkkg = loc.clone().add(1, -46.0D, 1).getBlock();
	             dkkg.setType(Material.DIRT); 
	             
	             final Block dii = loc.clone().add(1, -47.0D, 1).getBlock();
	             dii.setType(Material.DIRT); 
	             
	             final Block di = loc.clone().add(1, -48.0D, 1).getBlock();
	             di.setType(Material.DIRT); 
	             
	             final Block dgg = loc.clone().add(1, -49.0D, 1).getBlock();
	             dgg.setType(Material.DIRT); 
	             
	             final Block dg = loc.clone().add(1, -50.0D, 1).getBlock();
	             dg.setType(Material.DIRT);      	            
                 p.teleport(loc.add(0.0D, 0.0D,0.0D));
                 p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
                 p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
 	             this.Tower.add(p);    
	         }
	         }
	         }
		      }
	  }


	  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
	  {
		    if (c.getName().equalsIgnoreCase("Tower")) {
		      Player p1 = (Player)p;
		      p1.chat("/kit Tower");
		    }

		    return false;
		  }
}
