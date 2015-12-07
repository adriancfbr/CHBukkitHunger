package spinghg.hungergames.commands;

import java.util.ArrayList;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.BossBar;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffectType;

public class mod
implements CommandExecutor, Listener
{
private libsHg pl;

  public mod(libsHg plugin)
 {
    this.pl = plugin;
 }

ArrayList<Player> vanished = new ArrayList<Player>();
ArrayList<Player> adminmode = new ArrayList<Player>();

@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("mod")) && 
    (p.hasPermission("hg.mod")))
  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("§9Erro> §7Somente jogadores podem executar este comando!");
	      return true;
	    }  
	  if (!this.vanished.contains(p))
    { 	    	
      for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
        pl.hidePlayer(p);
      }  
      this.vanished.add(p);
      this.pl.vivos.remove(p);
      this.pl.admins.add(p);
      if ((this.pl.comecou) || (this.pl.invencibilidade)) {
      p.getInventory().clear();
      p.getInventory().setArmorContents(null);
      Bukkit.broadcastMessage("§b" + p.getName() + " §bfoi morto por sair da partida. \n§b§oJogadores vivos:  " + Integer.valueOf(this.pl.vivos.size()));
      Bukkit.broadcastMessage("§e" + p.getName() + " left the game.");
      }
      this.adminmode.add(p);
      p.setGameMode(GameMode.ADVENTURE);
      BossBar.setMessage(p, "§7Voce Entrou no §cModo Mod§7.", 5);
      if (p.hasPermission("hg.mod") && (p.hasPermission("hg.admin")))
	    {
      libsHg.stafflog(p.getName() + " entrou no modo Mod");
	    }
      if ((this.pl.comecando) || (this.pl.acabou)) {
      Bukkit.broadcastMessage("§e" + p.getName() + " left the game.");
      }
      p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
      p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
      p.removePotionEffect(PotionEffectType.ABSORPTION);
      p.removePotionEffect(PotionEffectType.BLINDNESS);
      p.removePotionEffect(PotionEffectType.CONFUSION);
      p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
      p.removePotionEffect(PotionEffectType.FAST_DIGGING);
      p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
      p.removePotionEffect(PotionEffectType.HARM);
      p.removePotionEffect(PotionEffectType.HEAL);
      p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
      p.removePotionEffect(PotionEffectType.HUNGER);
      p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
      p.removePotionEffect(PotionEffectType.INVISIBILITY);
      p.removePotionEffect(PotionEffectType.JUMP);
      p.removePotionEffect(PotionEffectType.NIGHT_VISION);
      p.removePotionEffect(PotionEffectType.POISON);
      p.removePotionEffect(PotionEffectType.REGENERATION);
      p.removePotionEffect(PotionEffectType.SATURATION);
      p.removePotionEffect(PotionEffectType.SLOW);
      p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
      p.removePotionEffect(PotionEffectType.SPEED);
      p.removePotionEffect(PotionEffectType.WATER_BREATHING);
      p.removePotionEffect(PotionEffectType.WEAKNESS);
      p.removePotionEffect(PotionEffectType.WITHER);
      p.setAllowFlight(true);
      return true;
    }
    for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
      pl.showPlayer(p);
    }
    this.vanished.remove(p);
    this.adminmode.remove(p);
    this.vanished.remove(p);
    this.pl.admins.remove(p);
    p.setGameMode(GameMode.SURVIVAL);
    p.setAllowFlight(false);
    BossBar.setMessage(p, "§cVocê desativou seu modo Mod!", 25);
    if ((this.pl.comecou) || (this.pl.invencibilidade)) {
    p.getInventory().setArmorContents(null);
    p.getInventory().clear();
    }
    if ((this.pl.comecando) || (this.pl.aguardando)) {
    this.pl.vivos.add(p);
    }
    else
    {
    	p.sendMessage("§9Aviso> §7Não é possivel você voltar a partida!");
    }
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
    p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 9);
    p.removePotionEffect(PotionEffectType.ABSORPTION);
    p.removePotionEffect(PotionEffectType.BLINDNESS);
    p.removePotionEffect(PotionEffectType.CONFUSION);
    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.HARM);
    p.removePotionEffect(PotionEffectType.HEAL);
    p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    p.removePotionEffect(PotionEffectType.HUNGER);
    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.removePotionEffect(PotionEffectType.JUMP);
    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    p.removePotionEffect(PotionEffectType.POISON);
    p.removePotionEffect(PotionEffectType.REGENERATION);
    p.removePotionEffect(PotionEffectType.SATURATION);
    p.removePotionEffect(PotionEffectType.SLOW);
    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    p.removePotionEffect(PotionEffectType.SPEED);
    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    p.removePotionEffect(PotionEffectType.WEAKNESS);
    p.getInventory().setArmorContents(null);
    if (p.hasPermission("hg.mod") && (p.hasPermission("hg.admin")))
	    {
    libsHg.stafflog(p.getName() + " saiu do modo Mod");
	    }
	  return true;
  } 
  return false;
}
}




 
