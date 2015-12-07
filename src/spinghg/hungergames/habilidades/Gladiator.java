package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
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
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Gladiator
implements Listener, CommandExecutor
{
  private libsHg pl;
  ArrayList<String> inPvP = new ArrayList();
  public Map<String, Location> local = new HashMap();
  
  public Gladiator(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageGladiator(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Gladiator"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Gladiator (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Gladiator", 1);
      }
    }
    }
  }
  ArrayList<Player> in1v1 = new ArrayList();
  public boolean generateGlass = true;
  public HashMap<String, Location> oldl = new HashMap();
  public static HashMap<String, String> fighting = new HashMap();
  public HashMap<Integer, ArrayList<Location>> blocks = new HashMap();
  public HashMap<Player, Location> localizacao = new HashMap();
  public HashMap<Location, Block> bloco = new HashMap();
  public HashMap<Integer, String[]> players = new HashMap();
  public HashMap<String, Integer> tasks = new HashMap();
  int nextID = 0;
  public int id1;
  public int id2;
  
  @EventHandler
  public void OnGladiatorKit(PlayerInteractEntityEvent event)
  {
    final Player p = event.getPlayer();
    final Player r = (Player)event.getRightClicked();
    if (this.pl.comecou)
    if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (!this.in1v1.contains(p.getName())))
    {
    	  if ((this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Gladiator")))) {
      event.setCancelled(true);
      Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 70, p.getLocation().getBlockZ());
      this.localizacao.put(p, loc);
      this.localizacao.put(r, loc);
      Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX() + 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() + 8);
      Location loc3 = new Location(p.getWorld(), p.getLocation().getBlockX() - 8, p.getLocation().getBlockY() + 73, p.getLocation().getBlockZ() - 8);
      if ((fighting.containsKey(p.getName())) || (fighting.containsKey(r.getName())))
      {
        event.setCancelled(true);
        p.sendMessage("§cVocê já está em batalha!");
        return;
      }
      Integer currentID = Integer.valueOf(this.nextID);
      this.nextID += 1;
      ArrayList list = new ArrayList();
      list.add(p.getName());
      list.add(r.getName());
      this.players.put(currentID, (String[])list.toArray(new String[1]));
      this.oldl.put(p.getName(), p.getLocation());
      this.oldl.put(r.getName(), r.getLocation());
      if (this.generateGlass)
      {
        List<Location> cuboid = new ArrayList();
        cuboid.clear();
        int bZ;
        for (int bX = -10; bX <= 10; bX++) {
          for (bZ = -10; bZ <= 10; bZ++) {
            for (int bY = -1; bY <= 10; bY++)
            {
              Block b = loc.clone().add(bX, bY, bZ).getBlock();
              if (!b.isEmpty())
              {
                event.setCancelled(true);
                p.sendMessage("§cVocê não pode criar uma arena aqui!");
                return;
              }
              if (bY == 10) {
                cuboid.add(loc.clone().add(bX, bY, bZ));
              } else if (bY == -1) {
                cuboid.add(loc.clone().add(bX, bY, bZ));
              } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
                cuboid.add(loc.clone().add(bX, bY, bZ));
              }
            }
          }
        }
        for (Location loc1 : cuboid)
        {
          loc1.getBlock().setType(Material.GLASS);
          this.bloco.put(loc1, loc1.getBlock());
        }
        loc2.setYaw(135.0F);
        p.teleport(loc2);
        loc3.setYaw(-45.0F);
        r.teleport(loc3);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
        r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
        p.sendMessage("§cVocê desafiou!\nVocê possui 5 segundos de invencibilidade");
        r.sendMessage("§cVocê foi desafiado por !\nVocê possui 5 segundos de invencibilidade");
        fighting.put(p.getName(), r.getName());
        fighting.put(r.getName(), p.getName());
        this.in1v1.add(p);
        this.in1v1.add(r);
        this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName())))
            {
              p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
              r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 5));
            }
          }
        }, 2400L);
        this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            if ((Gladiator.fighting.containsKey(p.getName())) && (((String)Gladiator.fighting.get(p.getName())).equalsIgnoreCase(r.getName())) && (Gladiator.fighting.containsKey(r.getName())) && (((String)Gladiator.fighting.get(r.getName())).equalsIgnoreCase(p.getName())))
            {
              Gladiator.fighting.remove(p.getName());
              Gladiator.fighting.remove(r.getName());
              Gladiator.this.in1v1.remove(p.getName());
              Gladiator.this.in1v1.remove(r.getName());
              p.teleport((Location)Gladiator.this.oldl.get(p.getName()));
              r.teleport((Location)Gladiator.this.oldl.get(r.getName()));
              Gladiator.this.oldl.remove(p.getName());
              Gladiator.this.oldl.remove(r.getName());
              p.sendMessage("§cNão houve um vencedor, você foi teleportado ao lugar anterior.");
              p.removePotionEffect(PotionEffectType.WITHER);
              r.sendMessage("§cNão houve um vencedor, você foi teleportado ao lugar anterior.");
              r.removePotionEffect(PotionEffectType.WITHER);
              Location loc = (Location)Gladiator.this.localizacao.get(p);
              List<Location> cuboid = new ArrayList();
              int bZ;
              for (int bX = -10; bX <= 10; bX++) {
                for (bZ = -10; bZ <= 10; bZ++) {
                  for (int bY = -1; bY <= 10; bY++) {
                    if (bY == 10) {
                      cuboid.add(loc.clone().add(bX, bY, bZ));
                    } else if (bY == -1) {
                      cuboid.add(loc.clone().add(bX, bY, bZ));
                    } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
                      cuboid.add(loc.clone().add(bX, bY, bZ));
                    }
                  }
                }
              }
              for (Location loc1 : cuboid)
              {
                loc1.getBlock().setType(Material.AIR);
                ((Block)Gladiator.this.bloco.get(loc1)).setType(Material.AIR);
              }
            }
          }
        }, 4800L);
      }
    }
  }}
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlyaerInteract(final PlayerInteractEvent e)
  {
    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (fighting.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getClickedBlock().setType(Material.BEDROCK);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
      {
        public void run()
        {
          if (Gladiator.fighting.containsKey(e.getPlayer().getName())) {
            e.getClickedBlock().setType(Material.GLASS);
          }
        }
      }, 20L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onBlockBreak(final BlockBreakEvent e)
  {
    if ((e.getBlock().getType() == Material.GLASS) && (e.getPlayer().getGameMode() != GameMode.CREATIVE) && (fighting.containsKey(e.getPlayer().getName())))
    {
      e.setCancelled(true);
      e.getBlock().setType(Material.BEDROCK);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
      {
        public void run()
        {
          if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (Gladiator.fighting.containsKey(e.getPlayer().getName()))) {
            e.getBlock().setType(Material.GLASS);
          }
        }
      }, 20L);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerLeft(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (fighting.containsKey(p.getName()))
    {
      Player t = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
      fighting.remove(t.getName());
      fighting.remove(p.getName());
      this.in1v1.remove(p.getName());
      this.in1v1.remove(t.getName());
      Location old = (Location)this.oldl.get(t.getName());
      t.teleport(old);
      t.sendMessage("§cO jogador " + p.getName() + " deslogou-se!");
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      t.removePotionEffect(PotionEffectType.WITHER);
      Location loc = (Location)this.localizacao.get(p);
      List<Location> cuboid = new ArrayList();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
        for (bZ = -10; bZ <= 10; bZ++) {
          for (int bY = -1; bY <= 10; bY++) {
            if (bY == 10) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            }
          }
        }
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
    }
  }
  
  public void onInventoryPlayer(Player p, Location loc) {}
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onDeathGladiator(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (fighting.containsKey(p.getName()))
    {
      Player k = Bukkit.getServer().getPlayer((String)fighting.get(p.getName()));
      Location old = (Location)this.oldl.get(p.getName());
      
      k.teleport(old);
      k.sendMessage("§cVocê venceu a batalha contra " + p.getName() + "§c!");
      Bukkit.getScheduler().cancelTask(this.id1);
      Bukkit.getScheduler().cancelTask(this.id2);
      k.removePotionEffect(PotionEffectType.WITHER);
      k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
      fighting.remove(k.getName());
      fighting.remove(p.getName());
      this.in1v1.remove(p.getName());
      this.in1v1.remove(k.getName());
      Location loc = (Location)this.localizacao.get(p);
      
      List<Location> cuboid = new ArrayList();
      cuboid.clear();
      int bZ;
      for (int bX = -10; bX <= 10; bX++) {
        for (bZ = -10; bZ <= 10; bZ++) {
          for (int bY = -1; bY <= 10; bY++) {
            if (bY == 10) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if (bY == -1) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            } else if ((bX == -10) || (bZ == -10) || (bX == 10) || (bZ == 10)) {
              cuboid.add(loc.clone().add(bX, bY, bZ));
            }
          }
        }
      }
      for (Location loc1 : cuboid)
      {
        loc1.getBlock().setType(Material.AIR);
        ((Block)this.bloco.get(loc1)).setType(Material.AIR);
      }
      return;
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
    if (c.getName().equalsIgnoreCase("gladiator"))
    {
      Player p1 = (Player)p;
      p1.chat("/kit gladiator");
    }
    return false;
  }
}


