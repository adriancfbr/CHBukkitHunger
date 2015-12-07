package spinghg.hungergames.listeners;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.events.PlayerCompassTargetEvent;

public class Partida
  implements Listener
{
  private libsHg pl;
  libsHg main;
  
  public Partida(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  private float heal = 4.0F;
  private float feed = 20.0F;
  @SuppressWarnings("unused")
private Object vanished;
  
  @EventHandler
  public void useSopa(PlayerInteractEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.sopaoff) 
    if (e.getAction().name().contains("RIGHT"))
    {
      ItemStack hand = player.getItemInHand();
      if ((hand != null) && 
        (hand.getType() == Material.MUSHROOM_SOUP))
      {
        EntityPlayer p = ((CraftPlayer)player).getHandle();
        if (p.getHealth() < p.getMaxHealth())
        {
          if (p.getHealth() + this.heal >= p.getMaxHealth())
          {
            p.setHealth(p.getMaxHealth());
            player.getItemInHand().setType(Material.BOWL);
            player.updateInventory();
          }
          else
          {
            p.setHealth(p.getHealth() + this.heal);
            player.getItemInHand().setType(Material.BOWL);
            player.updateInventory();
          }
        }
        else if (player.getFoodLevel() < 20)
        {
          if (player.getFoodLevel() + this.feed < 20.0F) {
            player.setFoodLevel((int)(player.getFoodLevel() + this.feed));
          } else {
            player.setFoodLevel((int)(player.getFoodLevel() + this.feed));
          }
          player.getItemInHand().setType(Material.BOWL);
          player.updateInventory();
        }
        else
        {
          player.getFoodLevel();
        }
      }
    }
  }
  
  @EventHandler
  public void useCompass(PlayerInteractEvent e) {
    Player player = e.getPlayer();
    
    if (this.pl.bsoff) 
    if (((e.getAction().name().contains("LEFT")) || (e.getAction().name().contains("RIGHT"))) && 
      (e.getAction() != Action.PHYSICAL))
    {
      ItemStack hand = player.getItemInHand();
      if ((hand != null) && 
        (hand.getType() == Material.COMPASS) && (this.pl.vivos.contains(player)))
      {
          
        Player alvo = null;
        double inicialDist = 5000.0D;
        for (Player nearby : this.pl.vivos)
        {
          double distance = player.getLocation().distance(nearby.getPlayer().getLocation());
          if ((distance >= inicialDist) || (distance <= 10.0D))
            continue;
          inicialDist = distance;
          alvo = nearby.getPlayer();
        }
        
        if (alvo == null)
        {
          player.setCompassTarget(player.getWorld().getSpawnLocation());
          if (player.hasPermission("planeta.staff"))
  	    {
          libsHg.stafflog(player.getName() + " a bussola dele estava apontando para o Spawn");
  	    }
          player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cNenhum Jogador encontrado, Bussola apontando para o Spawn");
          return;
        }
	    if (player.hasPermission("planeta.staff"))
	    {
	   libsHg.stafflog(player.getName() + " o alvo dele era o " + alvo.getName());
	    }
        PlayerCompassTargetEvent targetEvt = new PlayerCompassTargetEvent(player, alvo, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oO seu alvo é o -->§6 " + alvo.getName() + ".");
        Bukkit.getPluginManager().callEvent(targetEvt);
        if (!targetEvt.isCancelled())
        {
          player.setCompassTarget(targetEvt.getLocationAlvo());
          int distance = (int) player.getLocation().distance(alvo.getLocation());
          if(player.getGameMode() == GameMode.SURVIVAL) {
          player.sendMessage(targetEvt.getMessage());
          } else if(player.getGameMode() == GameMode.CREATIVE) {
          player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §b[§e" + alvo.getName() + " §b] §eesta " +  distance + " blocos de você!");
        }
      }
      }
  }
  }
  
  public void isonline(Player p)
  {
    if (!p.isOnline())
    {
      this.pl.vivos.remove(p);
      this.pl.vivos.remove(p);
      this.pl.admins.add(p);
      p.setAllowFlight(false);
      p.setFlying(false);
      p.setGameMode(GameMode.CREATIVE);
      BossBar.setMessage(p, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7Voce entrou no modo: " + ChatColor.RED + ChatColor.ITALIC + "Spectador", 4);
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7Voce entrou no modo: " + ChatColor.RED + ChatColor.ITALIC + "Spectador");
      p.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cVoce esta invisivel para todos os jogadores!");
      p.setGameMode(GameMode.ADVENTURE);
      p.setAllowFlight(true);
      p.setFlying(true);
      if (p.hasPermission("planeta.staff"))
	    {
      libsHg.stafflog(p.getName() + " entrou no modo Spectador.");
	    }
    }
  }
  
  @EventHandler
  public void onClickOpenInv(PlayerInteractEntityEvent e)
  {
    Player player = e.getPlayer();
    if ((player.getGameMode() == GameMode.CREATIVE) && 
      ((e.getRightClicked() instanceof Player)))
    {
      Player clicked = (Player)e.getRightClicked();
      if (this.pl.vivos.contains(clicked)) {
        player.openInventory(clicked.getInventory());
        if (player.hasPermission("planeta.staff"))
        {
       libsHg.stafflog(player.getName() + " abrio o inventario de " + clicked.getName() );
        }
      }
    }
  }
  
  @EventHandler
  public void onHit(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Player damager = (Player)e.getDamager();
      if (this.pl.admins.contains(damager)) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onHit(PlayerPickupItemEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.admins.contains(player)) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDamagesemkit(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((!this.pl.km.temKit(player)) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
    	  if (damager.hasPermission("planeta.vip"))
    	  {
    		  if (this.pl.comecou) {
    		  BossBar.setMessage(damager, p.getName() + " - Nenhum (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  }
    	  else
    	  {
    		  if (this.pl.comecou) {
        BossBar.setMessage(damager, p.getName() + " - Nenhum", 1);
    	  }
    	  }
      }
    }
    }
  
 
  
  public static String toReadable(String string)
  {
    String[] names = string.split("_");
    for (int i = 0; i < names.length; i++) {
      names[i] = 
        (names[i].substring(0, 1) + names[i].substring(1).toLowerCase());
    }
    return StringUtils.join(names, " ");
  }
}
