package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Ninja
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Ninja(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageNinja(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Ninja"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Ninja (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Ninja", 1);
      }
    }
    }
  }
  
  private HashMap<Player, Player> jogadoresNoNinja = new HashMap();
  private ArrayList<Player> cooldownDoNinja = new ArrayList();
  
  @EventHandler
  public void quandoEntidadeReceberDanoDeEntidade(EntityDamageByEntityEvent evento)
  {
	  if (this.pl.kit) 
    if ((evento.getDamager() instanceof Player))
    {
      final Player jogador = (Player)evento.getDamager();
      if ((this.pl.km.temKit(jogador)) && (this.pl.km.getPlayerKit(jogador, this.pl.km.getKitByName("Ninja"))) && 
        (this.pl.km.temKit(jogador)) && (this.pl.km.getPlayerKit(jogador, this.pl.km.getKitByName("Ninja"))) && 
        ((evento.getEntity() instanceof Player)))
      {
        final Player jogadorQueLevouDano = (Player)evento.getEntity();
        this.jogadoresNoNinja.put(jogador, jogadorQueLevouDano);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
        {
          public void run()
          {
            Ninja.this.jogadoresNoNinja.remove(jogador);
            Ninja.this.jogadoresNoNinja.remove(jogadorQueLevouDano);
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void quandoJogadorAlterarModoDeAgachamento(PlayerToggleSneakEvent evento)
  {
	  
    final Player jogador = evento.getPlayer();
    if (this.pl.kit) 
    if ((this.pl.km.temKit(jogador)) && (this.pl.km.getPlayerKit(jogador, this.pl.km.getKitByName("Ninja"))) && 
      (!jogador.isSneaking())) {
      if (!this.cooldownDoNinja.contains(jogador))
      {
        if (this.jogadoresNoNinja.containsKey(jogador))
        {
          jogador.teleport(((Player)this.jogadoresNoNinja.get(jogador)).getLocation());
          jogador.getWorld().playEffect(jogador.getLocation(), Effect.MOBSPAWNER_FLAMES, 13);
          jogador.getWorld().playEffect(jogador.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
          jogador.getWorld().playEffect(jogador.getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
          jogador.getWorld().playSound(jogador.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
          this.jogadoresNoNinja.remove(jogador);
          this.jogadoresNoNinja.remove(this.jogadoresNoNinja.get(jogador));
          this.cooldownDoNinja.add(jogador);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
          {
            public void run()
            {
              Ninja.this.cooldownDoNinja.remove(jogador);
            }
          }, 75L);
        }
        else
        {
          jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 1.0F, 1.0F);
        }
      }
      else {
        jogador.sendMessage(ChatColor.RED + "§c§oEspere para usar novamente!");
      }
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Ninja")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Ninja");
	    }

	    return false;
	  }
}
