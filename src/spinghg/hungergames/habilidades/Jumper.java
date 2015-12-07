package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Jumper
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Jumper(libsHg plugin)
  {
    this.pl = plugin;
  }
  ArrayList<String> tempo = new ArrayList<String>();
  public boolean GerarPlataforma= true;
  private transient HashMap<Block, Integer> platformTaskIds = new HashMap<Block, Integer>();
  @SuppressWarnings("deprecation")
public static int JumperItem = Material.ENDER_PEARL.getId();

  
  @SuppressWarnings("deprecation")
@EventHandler
  public void vish(PlayerInteractEvent e)
  {
	  ItemStack item = e.getItem();
	  final Player p = e.getPlayer();
    if (e.getAction().toString().contains("RIGHT")) {
    	if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Jumper"))) && 
      (e.getItem().getTypeId() == Jumper.JumperItem)) {
	        e.setCancelled(true);
	        if (!this.tempo.contains(p.getName()))
	        {              
	        	item.setAmount(item.getAmount() - 1);
	            if (item.getAmount() == 0) {
	              e.getPlayer().setItemInHand(new ItemStack(0));
	            }
	              
        p.sendMessage("§b§lVocê usou seu kit !!");
        p.launchProjectile(EnderPearl.class);
          this.tempo.add(p.getName());
          Bukkit.getServer().getScheduler().runTaskLater(this.pl, new Runnable()
          {
            public void run()
            {
              Jumper.this.tempo.remove(p.getName());
            }
          }, 100L);
        }
        else
        {
          p.sendMessage("Aguarde um pouco !");
        }
      }
    }
  }
@EventHandler
public void onBlockBreak(BlockBreakEvent event)
{
if (this.platformTaskIds.containsKey(event.getBlock())) {
Bukkit.getScheduler().cancelTask(((Integer)this.platformTaskIds.remove(event.getBlock())).intValue());
}
}

@SuppressWarnings("deprecation")
@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
{
if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof EnderPearl)) && (event.getEntity() == ((Projectile)event.getDamager()).getShooter()))
{
event.setCancelled(true);
if (this.GerarPlataforma) {
  for (int x = -2; x < 3; x++) {
    for (int z = -2; z < 3; z++)
    {
      final Block b = event.getEntity().getLocation().clone().add(x, -1.0D, z).getBlock();
      if (this.platformTaskIds.containsKey(b)) {
        Bukkit.getScheduler().cancelTask(((Integer)this.platformTaskIds.remove(b)).intValue());
      }
      if (b.getType() == Material.AIR)
      {
        b.setType(Material.BEDROCK);
        this.platformTaskIds.put(b, Integer.valueOf(Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            b.setType(Material.AIR);
            Jumper.this.platformTaskIds.remove(Jumper.this.platformTaskIds.get(b));
          }
        }, 200L)));
      }
    }
  }
}
}
}
public void matar(PlayerDeathEvent event)
{
	  Player p = ((OfflinePlayer) event).getPlayer();
	  if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Jumper"))) &&  (!(event.getEntity().getKiller() instanceof Player))) {
    return;
  }
  if (event.getEntity().getKiller() == null) {
    return;
  }
  if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Jumper")))) {
    event.getEntity().getKiller().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 1) });
  }
}

@EventHandler
public void onDamageJumper(EntityDamageByEntityEvent e)
{
	  if (this.pl.comecou)
  if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
  {
    Entity ent = e.getEntity();
    Player player = (Player)e.getEntity();
    Player damager = (Player)e.getDamager();
    Player p = (Player)ent;
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Jumper"))) && 
      (damager.getItemInHand() != null) && 
      (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
  	  {
  		  BossBar.setMessage(damager, p.getName() + " - Jumper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
  	  }
  	  else
  	  {
      BossBar.setMessage(damager, p.getName() + " - Jumper", 1);
    }
  }
  }
}
public boolean onCommand(CommandSender p, Command c, String label, String[] args)
{
	    if (c.getName().equalsIgnoreCase("Jumper")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Jumper");
	    }

	    return false;
	  }
}
