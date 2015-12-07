package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Thor
implements Listener, CommandExecutor
{
  private libsHg pl;
  public int cooldown = 4;
  public String cooldownMessage = ChatColor.RED + "§cMachado ainda em cooldown!";
  public boolean doNetherackAndFire = true;
  private transient HashMap<String, Long> lastThored = new HashMap();
  public boolean protectThorer = true;
  public int thorItemId = Material.WOOD_AXE.getId();
  
  public Thor(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageThor(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Thor"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Thor", 1);
      }
      }
    }
  }
  
  
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
	  if (this.pl.kit) 
    if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
      Player p = event.getPlayer();
      Block block = event.getClickedBlock();
      Block hbloc = block.getLocation().getWorld().getHighestBlockAt(block.getLocation());
      if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Thor"))) && (event.getItem() != null) && (event.getItem().getTypeId() == this.thorItemId)) {
        if ((!this.lastThored.containsKey(p.getName())) || (((Long)this.lastThored.get(p.getName())).longValue() < System.currentTimeMillis()))
        {
          this.lastThored.put(p.getName(), Long.valueOf(System.currentTimeMillis() + this.cooldown * 1000));
          if ((this.doNetherackAndFire) && 
            (event.getClickedBlock().getType() != Material.BEDROCK))
          {
            hbloc.setType(Material.NETHERRACK);
            hbloc.getRelative(BlockFace.UP).setType(Material.FIRE);
            for (Entity ent : getNearbyEntities(hbloc.getLocation(), 3))
            {
              Vector vector = ent.getLocation().toVector().subtract(p.getLocation().toVector()).normalize();
              ent.setVelocity(vector.multiply(2.5F));
            }
          }
          LightningStrike strike = p.getWorld().strikeLightning(hbloc.getLocation().add(0.0D, 1.0D, 0.0D));
          if (this.protectThorer) {
            strike.setMetadata("DontHurt", new FixedMetadataValue(this.pl, p.getName()));
          }
        }
        else
        {
          p.sendMessage(this.cooldownMessage);
        }
      }
    }
  }
  
  public Entity[] getNearbyEntities(Location l, int radius)
  {
	  
    int chunkRadius = radius < 16 ? 1 : (radius - radius % 16) / 16;
    HashSet radiusEntities = new HashSet();
    if (this.pl.kit) 
    for (int chX = 0 - chunkRadius; chX <= chunkRadius; chX++) {
      for (int chZ = 0 - chunkRadius; chZ <= chunkRadius; chZ++)
      {
        int x = (int)l.getX();int y = (int)l.getY();int z = (int)l.getZ();
        for (Entity e : new Location(l.getWorld(), x + chX * 16, y, z + chZ * 16).getChunk().getEntities()) {
          if ((e.getLocation().distance(l) <= radius) && (e.getLocation().getBlock() != l.getBlock())) {
            radiusEntities.add(e);
          }
        }
      }
    }
    return (Entity[])radiusEntities.toArray(new Entity[radiusEntities.size()]);
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Thor")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Thor");
	    }

	    return false;
	  }
}
