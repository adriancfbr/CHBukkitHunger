package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;

public class Burrower
implements Listener, CommandExecutor
{
	
	  private libsHg pl;
	  
	  public Burrower(libsHg plugin)
	  {
	    this.pl = plugin;
	  }
  private transient HashMap<Integer, List<Player>> expires = new HashMap();

  public int itemId = Material.SLIME_BALL.getId();
  public int addX = 50;
  public int addZ = 50;
  public boolean randomCords = true;
  public boolean teleportHeightRelativeToCurrentPos = false;
  public int mustBeHigherThen = 10;
  public int teleportToY = 10;
  public int roofBlockId = 20;
  public int roomHeight = 3;
  public int roomWidth = 2;
  public int giveBackItemDelay = 300;
  public int groundBlockData = 0;
  public int groundBlockId = 20;
  public int roofBlockData = 0;
  public int wallsBlockId = 20;
  public int wallsBlockData = 0;
  public String messageNotHighEnough = ChatColor.RED + "Você está perto do void!";

  
  @EventHandler
  public void onDamageBoxer(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Burrower"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Burrower (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Burrower", 1);
      }
    }
    }
  }
  
  @EventHandler
  public void onInteract111(PlayerInteractEvent event)
  {
    ItemStack item = event.getItem();
    Player p = event.getPlayer();
    if (this.pl.comecou)
    if ((event.getAction().name().contains("RIGHT")) && (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Burrower"))) && (item != null) && 
      (item.getTypeId() == this.itemId)) {
      if (p.getLocation().getY() > this.mustBeHigherThen) {
        int x = this.addX;
        int z = this.addZ;
        if (this.randomCords) {
          x = new Random().nextInt(this.addX * 2) - this.addX;
          z = new Random().nextInt(this.addZ * 2) - this.addZ;
        }
        item.setAmount(item.getAmount() - 1);
        if (item.getAmount() == 0)
          p.setItemInHand(new ItemStack(0));
        Location loc = p.getLocation().clone().add(x, 0.0D, z);
        if (this.teleportHeightRelativeToCurrentPos)
          loc.setY(loc.getY() - this.teleportToY);
        else
          loc.setY(this.teleportToY);
        loc = loc.add(0.5D, 0.0D, 0.5D);
        for (int bX = -this.roomWidth; bX <= this.roomWidth; bX++) {
          for (int bZ = -this.roomWidth; bZ <= this.roomWidth; bZ++) {
            for (int bY = -1; bY <= this.roomHeight; bY++) {
              Block b = loc.clone().add(bX, bY, bZ).getBlock();
              if (bY == this.roomHeight)
                b.setTypeIdAndData(this.roofBlockId, (byte)this.roofBlockData, false);
              else if (bY == -1)
                b.setTypeIdAndData(this.groundBlockId, (byte)this.groundBlockData, false);
              else if ((bX == -this.roomWidth) || (bZ == -this.roomWidth) || (bX == this.roomWidth) || (bZ == this.roomWidth))
                b.setTypeIdAndData(this.wallsBlockId, (byte)this.wallsBlockData, false);
              else
                b.setType(Material.AIR);
            }
          }
        }
        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
        p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
        p.teleport(loc);
        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
        p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 0.0F);
        List players = new ArrayList();
        if (this.expires.containsKey(this))
          players = (List)this.expires.get(this);
        players.add(p);
        this.expires.put(Integer.valueOf(this.giveBackItemDelay), players);
      } else {
        p.sendMessage(this.messageNotHighEnough);
      }
    }
  }

  @EventHandler
  public void onKilled(PlayerDeathEvent event) {
    Player p = event.getEntity().getPlayer();
    if (this.pl.comecou)
    	if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Burrower")))) {
      Iterator itel = this.expires.keySet().iterator();
      while (itel.hasNext()) {
        int no = ((Integer)itel.next()).intValue();
        if ((!((List)this.expires.get(Integer.valueOf(no))).remove(p)) || 
          (((List)this.expires.get(Integer.valueOf(no))).size() != 0)) continue;
        itel.remove();
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Burrower")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Burrower");
	    }

	    return false;
	  }
}