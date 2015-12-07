package spinghg.hungergames.listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.mysql.MySQLManager;
import spinghg.hungergames.kit.Kit;

public class Mortes
  implements Listener
{
private libsHg pl;
  
  public Mortes(libsHg plugin)
  {
    this.pl = plugin;
  }
  
ArrayList<Player> vanished = new ArrayList<Player>();

List<String> vipsMortos = new ArrayList<String>();
  
@EventHandler
public void aoMorrer(PlayerDeathEvent e)
{
  if ((e.getEntity() instanceof Player)) {
    deathHandle(e);
  }
}

@EventHandler
public void onRespawn(PlayerRespawnEvent e)
{
  Player player = e.getPlayer();
  if (this.vipsMortos.contains(player.getName()))
  {
    int x = new Random().nextInt(375);
    int z = new Random().nextInt(220);
    int y = player.getWorld().getHighestBlockYAt(x, z);
    Location rloc = new Location(player.getWorld(), x, y, z);
    e.setRespawnLocation(rloc);
    this.vipsMortos.remove(player.getName());
  }
}

public void deathHandle(PlayerDeathEvent e)
{
  if (this.pl.comecando) {
    return;
  }
  if (this.pl.invencibilidade) {
    return;
  }
  if (this.pl.comecou) {
    if (e.getEntity().hasPermission("planeta.vip"))
    {
      if (!this.pl.vivos.contains(e.getEntity())) {
        return;
      }
      if (this.pl.partidaCounter < 180)
      {
        e.setDeathMessage("");
        this.vipsMortos.add(e.getEntity().getName());
        return;
      }
      if ((e.getEntity().getKiller() instanceof Player))
      {
        e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7%s(%s) §bmorreu para §7%s(%s) §bcom %s\n§b§oJogadores vivos: " + Integer.valueOf(this.pl.vivos.size()), new Object[] {
          e.getEntity().getName(), 
          this.pl.km.temKit(e.getEntity()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity())).getName() : "Nenhum", 
          e.getEntity().getKiller().getName(), 
          this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Nenhum", 
          e.getEntity().getKiller().getItemInHand().getType().name().replace("_", " ").replace("AIR", "mao") }));
        this.pl.vivos.remove(e.getEntity());
        if (this.pl.database) {
          try
          {
            this.pl.mysql.updateKills(e.getEntity().getKiller());
            this.pl.mysql.updateMortes(e.getEntity());
          }
          catch (SQLException e1)
          {
            e1.printStackTrace();
          }
        }
        if ((e.getEntity().hasPermission("planeta.staff")))
        {
          if (!this.pl.admins.contains(e.getEntity())) {
            this.pl.admins.add(e.getEntity());
          }
          return;
        }
        e.getEntity().kickPlayer(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bVoce morreu para §7%s(%s) §bcom %s.\n§b§oJogadores vivos: " + Integer.valueOf(this.pl.vivos.size()), new Object[] {
          e.getEntity().getKiller().getName(), 
          this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Nenhum", 
          e.getEntity().getKiller().getItemInHand().getType().name().replace("_", " ").replace("AIR", "mao") }));
      }
      else
      if ((e.getEntity().getLastDamageCause().getCause().equals(EntityDamageEvent.DamageCause.LAVA)))
      {
          e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7%s(%s) §b foi morto por tentar nadar na lava\n§b§oJogadores vivos: " + Integer.valueOf(this.pl.vivos.size()), new Object[] {
              e.getEntity().getName(), 
              this.pl.km.temKit(e.getEntity()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity())).getName() : "Nenhum", }));
          if (this.pl.database) {
              try
              {
                this.pl.mysql.updateMortes(e.getEntity());
              }
              catch (SQLException e1)
              {
                e1.printStackTrace();
              }
            }
          this.pl.vivos.remove(e.getEntity());
      }
      else
      {
        e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7%s §bmorreu.\n§b§oJogadores vivos: " + Integer.valueOf(this.pl.vivos.size()), new Object[] { e.getEntity().getName() }));
        this.pl.vivos.remove(e.getEntity());
        if (this.pl.database) {
          try
          {
            this.pl.mysql.updateMortes(e.getEntity());
          }
          catch (SQLException e1)
          {
            e1.printStackTrace();
          }
        }
        e.getEntity().kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bVoce morreu.");
      }
    }
    else
        if ((e.getEntity().getKiller() instanceof Player))
        {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
            }
          e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §b%s(%s) foi morto por %s(%s) com %s \n§b§oJogadores vivos:  " + Integer.valueOf(this.pl.vivos.size()), new Object[] {
            e.getEntity().getName(), 
            this.pl.km.temKit(e.getEntity()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity())).getName() : "Sem kit", 
            e.getEntity().getKiller().getName(), 
            this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Sem kit", Name.getItemName(e.getEntity().getKiller().getItemInHand())}));
          this.pl.vivos.remove(e.getEntity());
          for (Player online : Bukkit.getOnlinePlayers())
          {
            online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
          }
          if (this.pl.database) {
              try
              {
                this.pl.mysql.updateKills(e.getEntity().getKiller());
                this.pl.mysql.updateMortes(e.getEntity());
              }
              catch (SQLException e1)
              {
                e1.printStackTrace();
              }
            }
         
            	e.getEntity().kickPlayer(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bVoce foi morto por %s(%s) com %s ", new Object[] {
                        e.getEntity().getKiller().getName(), 
                        Mortes.this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)Mortes.this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Sem kit", 
                        Name.getItemName(e.getEntity().getKiller().getItemInHand()) }));
            }
        else
        {
          e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §7§o%s §b§omorreu!\n§b§oJogadores vivos: " + Integer.valueOf(this.pl.vivos.size()) , new Object[] { e.getEntity().getName() }));
          this.pl.vivos.remove(e.getEntity());   
          if (this.pl.database) {
              try
              {
                this.pl.mysql.updateMortes(e.getEntity());
              }
              catch (SQLException e1)
              {
                e1.printStackTrace();
              }
            }
          e.getEntity().kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bVocê morreu!");
        }
  }
      else
      {
        if (!this.pl.vivos.contains(e.getEntity())) {
          return;
        }
        if ((e.getEntity().getKiller() instanceof Player))
        {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
            }
          e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §b%s(%s) foi morto por %s(%s) com %s \n§b§oJogadores vivos:  " + Integer.valueOf(this.pl.vivos.size()), new Object[] {
            e.getEntity().getName(), 
            this.pl.km.temKit(e.getEntity()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity())).getName() : "Sem kit", 
            e.getEntity().getKiller().getName(), 
            this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Sem kit", Name.getItemName(e.getEntity().getKiller().getItemInHand())}));
          this.pl.vivos.remove(e.getEntity());
          for (Player online : Bukkit.getOnlinePlayers())
          {
            online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
          }
          if (this.pl.database) {
              try
              {
                this.pl.mysql.updateKills(e.getEntity().getKiller());
                this.pl.mysql.updateMortes(e.getEntity());
              }
              catch (SQLException e1)
              {
                e1.printStackTrace();
              }
            }
         
            	e.getEntity().kickPlayer(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bVoce foi morto por %s(%s) com %s ", new Object[] {
                        e.getEntity().getKiller().getName(), 
                        Mortes.this.pl.km.temKit(e.getEntity().getKiller()) ? ((Kit)Mortes.this.pl.km.playerKit.get(e.getEntity().getKiller())).getName() : "Sem kit", 
                        Name.getItemName(e.getEntity().getKiller().getItemInHand()) }));
            }
        else
        {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
            }
          e.setDeathMessage(String.format("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §b%s morreu\n§b§oJogadores vivos:  " + Integer.valueOf(this.pl.vivos.size()), new Object[] { e.getEntity().getName() }));
          this.pl.vivos.remove(e.getEntity());
          if (this.pl.database) {
            try
            {
              this.pl.mysql.updateMortes(e.getEntity());
            }
            catch (SQLException e1)
            {
              e1.printStackTrace();
            }
          }
          e.getEntity().kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §bvoce morreu!");
        }
      }
 
    }
  }
  

