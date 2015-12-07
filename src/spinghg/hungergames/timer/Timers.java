package spinghg.hungergames.timer;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.server.v1_7_R4.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Objective;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.feasts.MineFeast;
import spinghg.hungergames.feasts.MineFeast2;
import spinghg.hungergames.feasts.MineFeast3;
import spinghg.hungergames.feasts.MineFeast4;
import spinghg.hungergames.libsHg;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.listeners.Join;
import spinghg.hungergames.listeners.TitleManager;

public class Timers
{
  private libsHg pl;
  private int taskComecando;
  private int taskInv;
  private int taskGame;
  ArrayList<Player> vanished = new ArrayList<Player>();
  public ArrayList<Player> sorteado = new ArrayList<Player>();
  public Objective o;
  public Scoreboard timerBoard = null;
  public Objective timerObj = null;
  
  
  public Timers(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public void startGame(int l)
  {
    libsHg.startingCounter = l;
    this.pl.comecando = true;
    this.taskComecando = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.pl, new Runnable()
    {
      @SuppressWarnings({ "deprecation", "unused" })
	public void run()
      {
        libsHg.startingCounter -= 1;
        switch (libsHg.startingCounter)
        {
        case 299: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 5 minutos. " );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"5 Minutos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule commandBlockOutput false");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            online.getWorld().setTime(0L);
            libsHg.setScoreBoard(online);
          }
          break;
        case 240: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 4 minutos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"4 Minutos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            
          }
          break;
        case 180: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 3 minutos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"3 Minutos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);

          }
          break;
        case 120: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 2 minutos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"2 Minutos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);

          }
          break;
        case 60: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 1 minuto." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"1 Minutos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
          if (libsHg.vivos.size() < Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"))
          {
    		libsHg.startingCounter += 60;
          }
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);

          }
          break;
        case 45: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aA partida inicia em 45 segundos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"45 Segundos\",\"color\":\"green\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"green\"}]}");
          if (libsHg.vivos.size() < Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"))
          {
    		libsHg.startingCounter += 60;
          }
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);

          }
          break;
        case 30: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §eA partida inicia em 30 segundos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"30 Segundos\",\"color\":\"yellow\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"yellow\"}]}");
          if (libsHg.vivos.size() < Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"))
          {
    		libsHg.startingCounter += 60;
          }
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);

          }
          break;
        case 10: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §eA partida inicia em 10 segundos." );
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"10 segundos\",\"color\":\"yellow\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"yellow\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            if (libsHg.vivos.size() < Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"))
            {
      		libsHg.startingCounter += 60;
            }
            else
            {
		    int x = new Random().nextInt(5) + 200;
            int z = new Random().nextInt(5) + 200;
            World world = Bukkit.getWorld("world");
            online.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2500, 5000));
            online.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2500, 5000));
            online.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2500, 5000));
            online.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2500, 5000));
            
            if ((Timers.this.pl.km.temKit(online)) && (Timers.this.pl.km.getPlayerKit(online, Timers.this.pl.km.getKitByName("hermit")))) {
            	online.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aTeleportando você em 10 segundos.");
            }
            if ((!online.hasPermission("planeta.vip")) && (!libsHg.ELoc.contains(online))){
            Location loc = new Location(world, x, online.getWorld().getHighestBlockAt(x, z).getY()+100, z);
            online.teleport(loc);
            
        	}
            }
          }
          break;
        case 5: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6A partida inicia em 5 segundos.");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"5 Segundos\",\"color\":\"gold\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"gold\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);

          }
          break;
        case 4: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6A partida inicia em 4 segundos.");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"4 Segundos\",\"color\":\"gold\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"gold\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);

          }
          break;
        case 3: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cA partida inicia em 3 segundos.");
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"3 segundos\",\"color\":\"red\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"red\"}]}");;
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
 
          }
          break;
        case 2: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cA partida inicia em 2 segundos.");
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"2 segundos\",\"color\":\"red\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"red\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
          }
          break;
        case 1: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §4A partida inicia em 1 segundo.");
          for (Player online : Bukkit.getOnlinePlayers()) {
    	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

          TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"1 segundos\",\"color\":\"dark_red\"}]}");

          TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Começando em\",\"color\":\"dark_red\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            online.closeInventory();
          }
          break;
        case 0: 
          if (libsHg.vivos.size() < Config.getConfig(Config.ConfigFile.CONFIG).getInt("minimo-players-necessarios"))
          {
  
			libsHg.startingCounter += 60;
            for (Player online : Bukkit.getOnlinePlayers()) {
            }
            
            return;
          }
          Bukkit.getScheduler().cancelTask(Timers.this.taskComecando);
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cA partida já começou!");
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6A partida tem " + Join.getOnlinePlayers() + " jogadores participantes");
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §a2 minutos de pvp off.");
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §eBoa sorte!");
          Bukkit.getServer().getWorld("world").setGameRuleValue("doDaylightCycle", "true");
          for (Player online : Bukkit.getOnlinePlayers())
          {
        	  if (libsHg.login.contains(online)) {
        		  online.kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cA partida inicio pedimos desculpas.");
        	  }
            online.playSound(online.getLocation(), Sound.WITHER_DEATH, 10.0F, 1.0F);
            BossBar.removeBar(online);
            online.getInventory().clear();
            online.setLevel(0);
            online.removePotionEffect(PotionEffectType.CONFUSION);
            online.removePotionEffect(PotionEffectType.JUMP);
            online.removePotionEffect(PotionEffectType.SPEED);
            online.removePotionEffect(PotionEffectType.INVISIBILITY);
            online.removePotionEffect(PotionEffectType.SLOW);
            online.closeInventory();
            int random = new Random().nextInt(Bukkit.getOnlinePlayers().length);
            Player player = Bukkit.getOnlinePlayers()[random];
            Timers.this.sorteado.add(player);
            
            TitleManager.sendTimings(player.getPlayer(), 20, 40, 20);

            TitleManager.sendSubTitle(player.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"2 Minutos com pvp off\",\"color\":\"green\"}]}");

            TitleManager.sendTitle(player.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Partida Começou\",\"color\":\"yellow\"}]}");
            
          }
          Timers.this.pl.comecando = false;
          Timers.this.startInvic(120);
        }        
      }
    }, 0L, 20L);
  }
  
  @SuppressWarnings({ "deprecation" })
public void startInvic(int timer)
  {
    libsHg.invicCounter = timer;
    for (Player all : libsHg.vivos)
    {
    	if (this.pl.kit) {
      if (this.pl.km.temKit(all)) {
        this.pl.km.giveKitItems(all);
      }
    	}
    	if (!this.pl.kit) {
    	 Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cOs kits estão desativados do servidor!");
    	}
      all.setAllowFlight(false);
      all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
      BossBar.removeBar(all);
      all.setMaxHealth(10);
      libsHg.setScoreBoard2(all);
      if ((this.pl.km.temKit(all)) && (this.pl.km.getPlayerKit(all, this.pl.km.getKitByName("hermit")))) {
              all.teleport(libsHg.hermit);
              all.setAllowFlight(false);
              if (!this.pl.hermitpantano) {
              all.sendMessage(libsHg.nohermit);
              }
      }
      if (libsHg.ESoup.contains(all))
      {
    	  all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP ,5) });
      }
      if (libsHg.EWood.contains(all))
      {
    	  all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD ,15) });
      }
      if (libsHg.EStone.contains(all))
      {
    	  all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE ,1) });
      }
      if (libsHg.EBown.contains(all))
      {
    	  all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOWL ,35) });
      }
      if (libsHg.EStick.contains(all))
      {
    	  all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STICK ,25) });
      }
      if ((this.pl.km.temKit(all)) && (this.pl.km.getPlayerKit(all, this.pl.km.getKitByName("blacksmith")))) {
    	  all.sendMessage("§aKit BlackSmith.");
    	  all.sendMessage("§a- Crie uma espada de ferro.");
    	  all.sendMessage("§a- Crie um Capacete de ferro.");
    	  all.sendMessage("§a- Crie um peitoral de ferro.");
    	  all.sendMessage("§a- Crie uma calça de ferro.");
    	  all.sendMessage("§a- Crie uma bota de ferro.");
    	  all.sendMessage("§aRecompensas §6 IRON ORE e EXP.");
    	  all.sendMessage("§aObs: Sempre que fiser um item click nele.");
      }
      
    	      if ((this.pl.km.temKit(all)) && (this.pl.km.getPlayerKit(all, this.pl.km.getKitByName("hermit")))) {
                  all.teleport(libsHg.hermit);
                  all.setAllowFlight(false);
                  if (!this.pl.hermitpantano) {
                  all.sendMessage(libsHg.nohermit);
                  }
    	      }
    	      if (all.hasPermission("planeta.vip")){
                all.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6[Vip] Você tem a vantage de receber 5 pães, 2 sopas e nascer no lugar onde estava.");
                all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP ,2) });
                all.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BREAD ,5) });
    	  }      
        }
   
    this.pl.invencibilidade = true;    
    this.taskInv = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.pl, new Runnable()
  
    {
      public void run()
      {
        libsHg.invicCounter -= 1;
        switch (libsHg.invicCounter)
        {
        case 120: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(2);
            }
            break;
        case 119: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(3);
            }
            break;
        case 118: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(4);
            }
            break;
        case 117: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(5);
            }
            break;
        case 116: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(6);
            }
            break;
        case 115: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(7);
            }
            break;
        case 114: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(8);
            }
            break;
        case 113: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(9);
            }
            break;
        case 112: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(10);
            }
            break;
        case 111: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(11);
            }
            break;
        case 110: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(12);
            }
            break;
        case 109: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(13);
            }
            break;
        case 108: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(14);
            }
            break;
        case 107: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(15);
            }
            break;
        case 106: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(16);
            }
            break;
        case 105: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(17);
            }
            break;
        case 104: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(18);
            }
            break;
        case 103: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(19);
            }
            break;
        case 102: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.playSound(online.getLocation(), Sound.SKELETON_IDLE, 10.0F, 1.0F);
              online.setMaxHealth(20);
              online.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aCorações carregados.");
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\" \",\"color\":\"green\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Corações carregados\",\"color\":\"green\"}]}");
              online.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2500, 5000));
            }
            break;
        case 101: 
            for (Player online : Bukkit.getOnlinePlayers()) {
              online.setMaxHealth(20);
              online.removePotionEffect(PotionEffectType.REGENERATION);
            }
            break;
        case 90: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aEm 1 minuto e 30 segundos O PvP estará Online!" );
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"1 Minuto e 30 Segundos\",\"color\":\"green\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 60: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aEm 1 minuto O PvP estará Online!" );
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"1 Minuto\",\"color\":\"green\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 45: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aEm 45 segundos O PvP estará Online!" );
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"45 Segundos\",\"color\":\"green\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 30: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §aEm 30 segundos O PvP estará Online!" );
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"30 Segundos\",\"color\":\"green\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"green\"}]}");
            online.playSound(online.getLocation(), Sound.NOTE_STICKS, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 10: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §eEm 10 segundos O PvP estará Online!" );
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"10 Segundos\",\"color\":\"yellow\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"yellow\"}]}");
              
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 9: 
            for (Player online : Bukkit.getOnlinePlayers()) {
          	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"9 Segundos\",\"color\":\"yellow\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"yellow\"}]}");
                
              online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            }
            break;
        case 8: 
            for (Player online : Bukkit.getOnlinePlayers()) {
          	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"8 Segundos\",\"color\":\"yellow\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"yellow\"}]}");
                
              online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            }
            break;
        case 7: 
            for (Player online : Bukkit.getOnlinePlayers()) {
          	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"7 Segundos\",\"color\":\"yellow\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"yellow\"}]}");
                
              online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            }
            break;
        case 6: 
            for (Player online : Bukkit.getOnlinePlayers()) {
          	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"6 Segundos\",\"color\":\"yellow\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"yellow\"}]}");
                
              online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            }
            break;
        case 5: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Em 5 segundos O PvP estará Online!");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"5 Segundos\",\"color\":\"gold\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"gold\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
          }
          break;
        case 4: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6Em 4 segundos O PvP estará Online!");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"4 Segundos\",\"color\":\"gold\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"gold\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
          }
          break;
        case 3: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cEm 3 segundos O PvP estará Online!");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"3 Segundos\",\"color\":\"red\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"red\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
          }
          break;
        case 2: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cEm 2 segundos O PvP estará Online!");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"2 Segundos\",\"color\":\"red\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"red\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
          }
          break;
        case 1: 
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §4Em 1 segundos O PvP estará Online!");
          for (Player online : Bukkit.getOnlinePlayers()) {
        	  TitleManager.sendTimings(online.getPlayer(), 20, 40, 20);

              TitleManager.sendSubTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"1 Segundos\",\"color\":\"dark_red\"}]}");

              TitleManager.sendTitle(online.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"O PvP estrá Online em\",\"color\":\"dark_red\"}]}");
            online.playSound(online.getLocation(), Sound.CLICK, 10.0F, 1.0F);
            online.setMaxHealth(20);
          }
          break;
        case 0: 
          Bukkit.getScheduler().cancelTask(Timers.this.taskInv);
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cO PvP agora esta Online!");
          Bukkit.broadcastMessage(" ");
          Bukkit.broadcastMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6E Comece a batalha!");
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.playSound(online.getLocation(), Sound.NOTE_PIANO, 10.0F, 1.0F);
            libsHg.clearScoreboard(online);
            online.setMaxHealth(20);
          }
          Timers.this.pl.invencibilidade = false;
          Timers.this.pl.comecou = true;
          Timers.this.comecarTimerPartida(0);
        }
      }
    }, 0L, 20L);
    }
  
  
  public void comecarTimerPartida(int timer)
  {
    this.pl.partidaCounter = timer;
    if ((!this.pl.comecando) && (!this.pl.invencibilidade)) {
      this.taskGame = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.pl, new Runnable()
      {
        @SuppressWarnings({ "static-access", "unused" })
		public void run()
        {
          Timers.this.pl.partidaCounter += 1;
          
          switch (Timers.this.pl.partidaCounter)
          {
          case 2: 
          {
        	  Location loc = Timers.this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
              MineFeast.spawnmf(loc);
            }
            break;
          case 100: 
          {
        	  Location loc = Timers.this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
              MineFeast2.spawnmf(loc);
            }
            break;
          case 350: 
          {
        	  Location loc = Timers.this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
              MineFeast3.spawnmf(loc);
            }
            break;
          case 750: 
          {
        	  Location loc = Timers.this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
              MineFeast4.spawnmf(loc);
            }
            break;
          case 840: 
          {
              Location loc = Timers.this.pl.fg.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
              Timers.this.pl.fg.prepareFeast(loc);
            }
            break;
            
          case 1800: 
              {
                Location loc = Timers.this.pl.fb.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
                Timers.this.pl.fb.prepareFeast(loc);
              }
              break;
          case 3240: 
          {
            Location loc = Timers.this.pl.fb.getRandomLoc(Bukkit.getWorld(Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo")));
            Timers.this.pl.fsv.prepareFeast();
          }
          
          break;
          }
          if (libsHg.vivos.size() < 2)
          {
            Bukkit.getScheduler().cancelTask(Timers.this.taskGame);
            Timers.this.pl.winPlayer((Player)libsHg.vivos.get(0));
          }
        }
      }, 0L, 20L);
    }
  }
  
  
}
