package spinghg.hungergames.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import spinghg.hungergames.libsHg;

public class Leave
  implements Listener
{
  private libsHg pl;
@SuppressWarnings("unused")
private Object aoSair;
  
  public Leave(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void aoSair(PlayerQuitEvent e)
  {
    final Player player = e.getPlayer();
    if ((!this.pl.comecando) && (!this.pl.aguardando))
    {
      if (this.pl.vivos.contains(player)) {
    	  new BukkitRunnable()
          {
            int tempo = 25;
            
            @SuppressWarnings("deprecation")
			public void run()
            {
            	this.tempo -= 1;
            	 if (player.isOnline()) {
           		  this.tempo = 25;
           		  if(!Leave.this.pl.vivos.contains(player))
           		  {
           			  Leave.this.pl.vivos.add(player);
           		  }
                   }

              switch (this.tempo)
              {
              case 25:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 24:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 23:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 22:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 21:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 20:   
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 19:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 18:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 17:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 16:          
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 15:   
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 14:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 13:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 12:
            	  
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 11:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 10:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 9:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 8:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 7:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 6:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 5:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 4:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 3:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 2:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 1:
             	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	   break;
              case 0: 
            	  if (player.isOnline()) {
            		  this.tempo = 25;
                    }
            	  else
            	  {
                Leave.this.pl.vivos.remove(player);
                Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §b" + player.getName() + " §bfoi morto por sair da partida. \n§b§oJogadores vivos:  " + Join.getOnlinePlayers());
                for (Player online : Bukkit.getOnlinePlayers())
                {
                  online.playSound(online.getLocation(), Sound.AMBIENCE_THUNDER, 10.0F, 1.0F);
                  Location light = online.getLocation();
                  Bukkit.getServer().getWorlds().get(0).strikeLightningEffect(light.add(0.0D, 100.0D, 0.0D));
                }
            	  }
              }
            }
            
          }.runTaskTimer(this.pl, 0L, 20L);
        }
      }
    else
    {
    	  this.pl.vivos.remove(player);
      }
  }
  }

