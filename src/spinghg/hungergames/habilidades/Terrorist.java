package spinghg.hungergames.habilidades;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Terrorist
implements Listener, CommandExecutor
{
  private libsHg pl;
  private HashMap<String, Integer> cdw = new HashMap();
  private transient HashMap<Block, Player> tnts = new HashMap();
  private int taskId;
  
  public Terrorist(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageTerrorist(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Terrorist"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Stomper (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Terrorist", 1);
      }
      }
    }
  }
  
  @EventHandler
  public void onBreak(BlockBreakEvent event)
  {
	  if (this.pl.kit) 
    if (this.tnts.containsKey(event.getBlock()))
    {
      this.tnts.remove(event.getBlock());
      event.setCancelled(true);
      event.getBlock().setType(Material.AIR);
      ItemStack tnt = new ItemStack(Material.TNT);
      ItemMeta im = tnt.getItemMeta();
      im.setDisplayName("§b§oTerrorist §8TNT");
      tnt.setItemMeta(im);
      Player player = event.getPlayer();
      player.getWorld();
    }
  }
  
  @EventHandler
  public void onCraft(PrepareItemCraftEvent event)
  {
	  if (this.pl.kit) 
    if ((event.getRecipe().getResult() != null) && 
      (event.getRecipe().getResult().getType() == Material.TNT))
    {
      for (HumanEntity entity : event.getViewers()) {
        if ((this.pl.km.temKit((Player)entity)) && (this.pl.km.getPlayerKit((Player)entity, this.pl.km.getKitByName("Terrorist")))) {
          return;
        }
      }
      event.getInventory().setItem(0, new ItemStack(0, 0));
    }
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    Player player = e.getEntity();
    if (this.pl.kit) 
    if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Terrorist")))) {
      return;
    }
    Iterator<Block> itel = this.tnts.keySet().iterator();
    while (itel.hasNext())
    {
      Block b = (Block)itel.next();
      if (((Player)this.tnts.get(b)).getName() == player.getName()) {
        itel.remove();
      }
    }
    for (ItemStack drops : e.getDrops()) {
      if ((drops.hasItemMeta()) && (drops.getItemMeta().getDisplayName().contains("Terrorist"))) {
        drops.setType(Material.AIR);
      }
    }
  }
  
  @EventHandler
  public void onExplode(EntityExplodeEvent event)
  {
	  if (this.pl.kit) 
    for (Block b : event.blockList()) {
      this.tnts.remove(b);
    }
  }
  
  @EventHandler
  public void onPlaceTnT(BlockPlaceEvent e)
  {
    Player player = e.getPlayer();
    ItemStack i = player.getItemInHand();
    if (this.pl.kit) 
    if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Terrorist")))) {
      return;
    }
    if ((i.hasItemMeta()) && (i.getItemMeta().getDisplayName().contains("Terrorist")))
    {
      Block b = e.getBlock();
      if (b.getType() == Material.TNT)
      {
        this.tnts.put(b, player);
        player.sendMessage("§aTnT Ativada!");
        player.sendMessage("§aUse seu detonador para explodir tudo!");
      }
    }
  }
  
  @EventHandler
  public void detonateTnt(PlayerInteractEvent e)
  {
    final Player player = e.getPlayer();
    if (this.pl.kit) 
    if (e.getAction().name().contains("RIGHT"))
    {
      if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Terrorist")))) {
        return;
      }
      ItemStack hand = player.getItemInHand();
      if ((hand.hasItemMeta()) && 
        (hand.getItemMeta().getDisplayName().contains("Terrorist")) && 
        (hand.getType() == Material.LEVER))
      {
        e.setCancelled(true);
        player.updateInventory();
        if (this.tnts.isEmpty())
        {
          player.sendMessage("§cNão existem TnT's ativadas!");
          player.sendMessage("§cColoque uma no chave e ative-a!");
          return;
        }
        player.sendMessage("§cDetonando TnT's em 1 segundo!\n§7Você acabou pegando radiação por alguns segundos!");
        this.cdw.put(player.getName(), Integer.valueOf(60));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0));
        
        Iterator<Block> itel = this.tnts.keySet().iterator();
        while (itel.hasNext())
        {
          Block b = (Block)itel.next();
          if (((Player)this.tnts.get(b)).getName() == player.getName())
          {
            itel.remove();
            b.setType(Material.AIR);
            Entity tntPrimed = b.getWorld().spawn(b.getLocation(), TNTPrimed.class);
            ((TNTPrimed)tntPrimed).setFuseTicks(5);
          }
        }
        this.taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.pl, new Runnable()
        {
          int time;
          
          public void run()
          {
            this.time -= 1;
            Terrorist.this.cdw.put(player.getName(), Integer.valueOf(this.time));
            if (this.time == 0)
            {
              if (Terrorist.this.cdw.containsKey(player.getName())) {
                Terrorist.this.cdw.remove(player.getName());
              }
              Bukkit.getScheduler().cancelTask(Terrorist.this.taskId);
            }
          }
        }, 0L, 20L);
      }
    }
  }
  
  @EventHandler
  public void onDropLever(PlayerDropItemEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Terrorist"))) && 
      (e.getItemDrop().getItemStack().hasItemMeta()) && (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Terrorist")) && 
      (e.getItemDrop().getItemStack().getType() == Material.LEVER))
    {
      e.setCancelled(true);
      player.updateInventory();
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Terrorist")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Terrorist");
	    }

	    return false;
	  }
}
