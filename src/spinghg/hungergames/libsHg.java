// Code by AdrianCF 19/11/2014 Bukkit/Spigot 1.7.9 R0.3
// Minecraft Server HungerGames Criador para o Sping/PlanetaCraft
// Plugin Proprio
package spinghg.hungergames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import spinghg.hungergames.API.AntiHack;
import spinghg.hungergames.API.Hack.Atack;
import spinghg.hungergames.API.Hack.AutoSoup;
import spinghg.hungergames.API.Hack.Fly;
import spinghg.hungergames.API.Hack.Macro;
import spinghg.hungergames.API.Hack.MoveCheck;
import spinghg.hungergames.API.Hack.Xray;
import spinghg.hungergames.Coins.Loja;
import spinghg.hungergames.Coins.LojaKitsListener;
import spinghg.hungergames.Coins.kExtrasListener;
import spinghg.hungergames.Menu.KitMenu2Listener;
import spinghg.hungergames.Menu.KitMenuListener;
import spinghg.hungergames.Menu.MenuAchillesListener;
import spinghg.hungergames.Menu.MenuAnchorListener;
import spinghg.hungergames.Menu.MenuArcherListener;
import spinghg.hungergames.Menu.MenuBarbarianListener;
import spinghg.hungergames.Menu.MenuBerserkerListerner;
import spinghg.hungergames.Menu.MenuBlacksmithListener;
import spinghg.hungergames.Menu.MenuBlinkListerner;
import spinghg.hungergames.Menu.MenuBomberListerner;
import spinghg.hungergames.Menu.MenuBoxerListerner;
import spinghg.hungergames.Menu.MenuBurrowerListener;
import spinghg.hungergames.Menu.MenuCamelListerner;
import spinghg.hungergames.Menu.MenuCannibalListener;
import spinghg.hungergames.Menu.MenuCheckPointListener;
import spinghg.hungergames.Menu.MenuConfusionListener;
import spinghg.hungergames.Menu.MenuCookieMonsterListener;
import spinghg.hungergames.Menu.MenuCrafterListener;
import spinghg.hungergames.Menu.MenuCultivatorListener;
import spinghg.hungergames.Menu.MenuDemomanListener;
import spinghg.hungergames.Menu.MenuEndermageListener;
import spinghg.hungergames.Menu.MenuFiremanListener;
import spinghg.hungergames.Menu.MenuFishermanListener;
import spinghg.hungergames.Menu.MenuFlashListener;
import spinghg.hungergames.Menu.MenuForgeListerner;
import spinghg.hungergames.Menu.MenuFrostyListerner;
import spinghg.hungergames.Menu.MenuFrozenListener;
import spinghg.hungergames.Menu.MenuGladiatorListener;
import spinghg.hungergames.Menu.MenuGranpdaListerner;
import spinghg.hungergames.Menu.MenuGrapplerListerner;
import spinghg.hungergames.Menu.MenuHermitListener;
import spinghg.hungergames.Menu.MenuHulkListener;
import spinghg.hungergames.Menu.MenuHungerlyListener;
import spinghg.hungergames.Menu.MenuJellyfishListerner;
import spinghg.hungergames.Menu.MenuJumper2;
import spinghg.hungergames.Menu.MenuKangarooListener;
import spinghg.hungergames.Menu.MenuLavaManListener;
import spinghg.hungergames.Menu.MenuLumberJackListener;
import spinghg.hungergames.Menu.MenuMeteoroListener;
import spinghg.hungergames.Menu.MenuMinerListerner;
import spinghg.hungergames.Menu.MenuNinjaListener;
import spinghg.hungergames.Menu.MenuPhantomListener;
import spinghg.hungergames.Menu.MenuPoseidonListener;
import spinghg.hungergames.Menu.MenuPyronListener;
import spinghg.hungergames.Menu.MenuReaperListerner;
import spinghg.hungergames.Menu.MenuRedstoneListener;
import spinghg.hungergames.Menu.MenuRiderListerner;
import spinghg.hungergames.Menu.MenuSerialKillerListener;
import spinghg.hungergames.Menu.MenuSnailListener;
import spinghg.hungergames.Menu.MenuSpecialistListener;
import spinghg.hungergames.Menu.MenuSpiritListener;
import spinghg.hungergames.Menu.MenuStomperListener;
import spinghg.hungergames.Menu.MenuSwitcherListener;
import spinghg.hungergames.Menu.MenuTankListerner;
import spinghg.hungergames.Menu.MenuTerroristListerner;
import spinghg.hungergames.Menu.MenuThermoListener;
import spinghg.hungergames.Menu.MenuThorListener;
import spinghg.hungergames.Menu.MenuTimeLordListener;
import spinghg.hungergames.Menu.MenuTowerListerner;
import spinghg.hungergames.Menu.MenuTurtleListerner;
import spinghg.hungergames.Menu.MenuUrgalListerner;
import spinghg.hungergames.Menu.MenuVacuumListener;
import spinghg.hungergames.Menu.MenuVampireListener;
import spinghg.hungergames.Menu.MenuVikingListener;
import spinghg.hungergames.Menu.MenuViperListener;
import spinghg.hungergames.Menu.MenuWeakhandListener;
import spinghg.hungergames.Menu.MenuWormListener;
import spinghg.hungergames.Menu.PaginaKitListener;
import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.api.mysql.MySQLManager;
import spinghg.hungergames.commands.ChatCMD;
import spinghg.hungergames.commands.ChatStaff;
import spinghg.hungergames.commands.Check;
import spinghg.hungergames.commands.Crash;
import spinghg.hungergames.commands.LoginCommand;
import spinghg.hungergames.commands.Money;
import spinghg.hungergames.commands.Ping;
import spinghg.hungergames.commands.Staff;
import spinghg.hungergames.commands.Sudo;
import spinghg.hungergames.commands.TeamHG;
import spinghg.hungergames.commands.admin;
import spinghg.hungergames.commands.aviso;
import spinghg.hungergames.commands.comecar;
import spinghg.hungergames.commands.fly;
import spinghg.hungergames.commands.forcefeast;
import spinghg.hungergames.commands.gm;
import spinghg.hungergames.commands.help;
import spinghg.hungergames.commands.hg;
import spinghg.hungergames.commands.invsee;
import spinghg.hungergames.commands.ip;
import spinghg.hungergames.commands.kick;
import spinghg.hungergames.commands.kit;
import spinghg.hungergames.commands.kitinfo;
import spinghg.hungergames.commands.kits;
import spinghg.hungergames.commands.mod;
import spinghg.hungergames.commands.morrer;
import spinghg.hungergames.commands.mudartempo;
import spinghg.hungergames.commands.ranking;
import spinghg.hungergames.commands.reload;
import spinghg.hungergames.commands.rj;
import spinghg.hungergames.commands.skit;
import spinghg.hungergames.commands.spawn;
import spinghg.hungergames.commands.spect;
import spinghg.hungergames.commands.tag;
import spinghg.hungergames.commands.tags;
import spinghg.hungergames.commands.tell;
import spinghg.hungergames.commands.togglekit;
import spinghg.hungergames.commands.tp;
import spinghg.hungergames.commands.youtuber;
import spinghg.hungergames.feasts.FeastBonus;
import spinghg.hungergames.feasts.Finalizandosv;
import spinghg.hungergames.feasts.Generator;
import spinghg.hungergames.feasts.MineFeast2;
import spinghg.hungergames.feasts.MineFeast3;
import spinghg.hungergames.feasts.MineFeast4;
import spinghg.hungergames.forcefield.Forcefield;
import spinghg.hungergames.habilidades.Achilles;
import spinghg.hungergames.habilidades.Anchor;
import spinghg.hungergames.habilidades.Archer;
import spinghg.hungergames.habilidades.Barbarian;
import spinghg.hungergames.habilidades.Berserker;
import spinghg.hungergames.habilidades.Blacksmith;
import spinghg.hungergames.habilidades.Blink;
import spinghg.hungergames.habilidades.Boxer;
import spinghg.hungergames.habilidades.Burrower;
import spinghg.hungergames.habilidades.Camel;
import spinghg.hungergames.habilidades.Cannibal;
import spinghg.hungergames.habilidades.Checkpoint;
import spinghg.hungergames.habilidades.Confusion;
import spinghg.hungergames.habilidades.CookieMonster;
import spinghg.hungergames.habilidades.Crafter;
import spinghg.hungergames.habilidades.Cultivator;
import spinghg.hungergames.habilidades.Demoman;
import spinghg.hungergames.habilidades.Endermage;
import spinghg.hungergames.habilidades.Fireman;
import spinghg.hungergames.habilidades.Fisherman;
import spinghg.hungergames.habilidades.Flash;
import spinghg.hungergames.habilidades.Forge;
import spinghg.hungergames.habilidades.Frosty;
import spinghg.hungergames.habilidades.Gladiator;
import spinghg.hungergames.habilidades.Grandpa;
import spinghg.hungergames.habilidades.Grappler;
import spinghg.hungergames.habilidades.Hermit;
import spinghg.hungergames.habilidades.Hulk;
import spinghg.hungergames.habilidades.Hungerly;
import spinghg.hungergames.habilidades.Jellyfish;
import spinghg.hungergames.habilidades.Jumper;
import spinghg.hungergames.habilidades.Kangaroo;
import spinghg.hungergames.habilidades.LavaMan;
import spinghg.hungergames.habilidades.Lumberjack;
import spinghg.hungergames.habilidades.Meteoro;
import spinghg.hungergames.habilidades.Miner;
import spinghg.hungergames.habilidades.Ninja;
import spinghg.hungergames.habilidades.Phantom;
import spinghg.hungergames.habilidades.Poseidon;
import spinghg.hungergames.habilidades.Pyro;
import spinghg.hungergames.habilidades.Reaper;
import spinghg.hungergames.habilidades.Redstoner;
import spinghg.hungergames.habilidades.Rider;
import spinghg.hungergames.habilidades.SerialKiller;
import spinghg.hungergames.habilidades.Snail;
import spinghg.hungergames.habilidades.Specialist;
import spinghg.hungergames.habilidades.Spirit;
import spinghg.hungergames.habilidades.Stomper;
import spinghg.hungergames.habilidades.Switcher;
import spinghg.hungergames.habilidades.Tank;
import spinghg.hungergames.habilidades.Terrorist;
import spinghg.hungergames.habilidades.Thermo;
import spinghg.hungergames.habilidades.Thor;
import spinghg.hungergames.habilidades.Timelord;
import spinghg.hungergames.habilidades.Tower;
import spinghg.hungergames.habilidades.Turtle;
import spinghg.hungergames.habilidades.Urgal;
import spinghg.hungergames.habilidades.Vacuum;
import spinghg.hungergames.habilidades.Vampire;
import spinghg.hungergames.habilidades.Viking;
import spinghg.hungergames.habilidades.Viper;
import spinghg.hungergames.habilidades.Weakhand;
import spinghg.hungergames.habilidades.Worm;
import spinghg.hungergames.habilidades.frozen;
import spinghg.hungergames.kit.KitManager;
import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.Blocos;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.listeners.Dano;
import spinghg.hungergames.listeners.Extras;
import spinghg.hungergames.listeners.Interact_Drops;
import spinghg.hungergames.listeners.Join;
import spinghg.hungergames.listeners.Leave;
import spinghg.hungergames.listeners.LoginAPI;
import spinghg.hungergames.listeners.MineCombatLog;
import spinghg.hungergames.listeners.Mortes;
import spinghg.hungergames.listeners.Name;
import spinghg.hungergames.listeners.NameAPI;
import spinghg.hungergames.listeners.Partida;
import spinghg.hungergames.listeners.PingEvent;
import spinghg.hungergames.listeners.Protecao;
import spinghg.hungergames.listeners.ScoreboardTeam;
import spinghg.hungergames.listeners.TitleManager;
import spinghg.hungergames.timer.Timers;

import com.comphenix.packetwrapper.WrapperPlayClientUseEntity;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class libsHg extends JavaPlugin implements Listener
{
  public static libsHg plugin;
  private static Scoreboard board;
  private static Team team;
  String configVersion = "1.1";
  private final Timers timers = new Timers(this);
  public boolean comecou = false;
  public boolean invencibilidade = false;
  public boolean comecando = false;
  public boolean acabou = false;
  public boolean feast = false;
  public boolean mf = false;
  public static boolean database = false;
  public MySQLManager mysql = new MySQLManager(this);
  public KitManager km = new KitManager(this);
  public Generator fg = new Generator(this);
  public MineFeast2 mff2 = new MineFeast2(this);
  public MineFeast3 mff3 = new MineFeast3(this);
  public MineFeast4 mff4 = new MineFeast4(this);
  public Finalizandosv fsv = new Finalizandosv(this);
  public Extras ex = new Extras(this);
  public static int startingCounter = 0;
  public static int invicCounter = 0;
  public static Integer WORLDRADIUS = Integer.valueOf(400);
  public int partidaCounter = 0;
  public static Logger logger = Logger.getLogger("Minecraft");
  public static List<Player> vivos = new ArrayList<Player>();
  public List<Player> admins = new ArrayList<Player>();
  public List<Player> mute = new ArrayList<Player>();
  public static List<Block> blockf = new ArrayList<Block>();
  public static List<Player> login = new ArrayList<Player>();
  public static List<Player> ESoup = new ArrayList<Player>();
  public static List<Player> EWood = new ArrayList<Player>();
  public static List<Player> EStone = new ArrayList<Player>();
  public static List<Player> EBown = new ArrayList<Player>();
  public static List<Player> EStick = new ArrayList<Player>();
  public static List<Player> ELoc = new ArrayList<Player>();
  public static List<Player> Team = new ArrayList<Player>();
  public static List<Player> Cs = new ArrayList<Player>();
  public static List<Player> PvPGladiator = new ArrayList<Player>();
  public static List<Player> Spirit7 = new ArrayList<Player>();
  public FeastBonus fb = new FeastBonus(this);
  private int task1;
  public static boolean P = true;
  public static boolean Q = false;
  public boolean kit = true;
  public boolean sopaoff = true;
  public boolean bsoff = true;
  public boolean staff = false;
  public boolean hermitpantano = false;
  public boolean aguardando = true;
  private static boolean bolo = true;
  public static libsHg instance;
  public static Logger log;
  private static String acf = "ad.ri.an.cf".replace(".", "");
  private static String adp = ".Ad.pn.e.to".replace(".", "");
  private static String group = ".Cr.ia.do.res.".replace(".", "");
  private static String site = "http://www.";
  private static String site2 = ".co.ol.er.h.g".replace(".", "");
  private static String site3 = ".com.br/";
  private static String site4 = ".Se.r.ve.r.".replace(".", "");
  private static String site5 = ".txt";
  private Date now = new Date();
  private SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
  private HashMap<String, Boolean> hiddenPlayers = new HashMap<String, Boolean>();
  private HashMap<String, Integer> violations = new HashMap<String, Integer>();
  public static Location hermit = null;
  public static String nohermit = "§c§on§o foi localizado um pantano.";
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  private HashMap<UUID, AuraCheck> running = new HashMap<>();
  private boolean isRegistered;
  public static final Random RANDOM = new Random();
  public static List<String> lista = new ArrayList<String>();
  public static ArrayList<Player> alertas = new ArrayList<Player>();
  public static String PERMISSAO = "hg.mod";
  private static Map<UUID, Long> lastAttacked = new HashMap<UUID, Long>();
  
  public void onLoad()
  {
    String world = Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo");   
    libsHg.logger.info("Apagando mundo...");
    Bukkit.getServer().unloadWorld(world, false);
    deleteDir(new File(world));
    instance = this;
    log = getLogger();
  }

  public void onEnable()
  {
    plugin = this;
    regThings();
    checkUserData();
    String world = Config.getConfig(Config.ConfigFile.CONFIG).getString("nome-mundo");
    Bukkit.getWorld(world).setSpawnLocation(0, Bukkit.getWorld(world).getHighestBlockYAt(0, 0) + 4, 0);
    Config.getConfig(Config.ConfigFile.CONFIG).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.MYSQL).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.FEAST).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.MINEFEAST).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.KITS).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.STAFF).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.CAKE).options().copyDefaults(true);
    Config.getConfig(Config.ConfigFile.C).options().copyDefaults(true);
    Config.loadConfigs();
    this.km.loadKits();
	Bukkit.getServer().setDefaultGameMode(GameMode.SURVIVAL);
	Bukkit.getServer().getWorld("world").setGameRuleValue("doDaylightCycle", "false");
	Bukkit.getServer().setSpawnRadius(0);
	Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.HARD);
    libsHg.logger.log(Level.INFO, "Kits carregados.");
    libsHg.stafflog("======Inicio da Partida=====");
    libsHg.logger.log(Level.INFO, "Gerando ForceFieldBlock");
    Bukkit.getWorld("world").setSpawnLocation(0, 100, 0);
    Bukkit.getServer().setSpawnRadius(0);
    ForceFieldBlock();
    ForceFieldBlock();
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new MoveCheck(), 41L, 40L);
    
    try
    {
      this.mysql.setupHungerGames();
    }
    catch (SQLException e)
    {
      libsHg.database = false;
      e.printStackTrace();
    }
    {
    setTask1(Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      @SuppressWarnings("deprecation")
	public void run() {
    	  if (libsHg.this.aguardando) {
    		    if ((Join.getOnlinePlayers() == 2))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 3))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 4))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 5))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 6))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 7))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 8))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 9))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 10))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 11))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 12))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 13))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 14))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 15))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 16))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 17))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 18))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 19))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 20))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 21))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 22))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 23))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 24))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 25))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 26))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 27))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    		    if ((Join.getOnlinePlayers() == 28))
    		    {
    		      libsHg.this.aguardando = false;
    		      libsHg.this.timers.startGame(300);
    		    }
    	  }
    	  if (libsHg.this.comecou)
    	  {
    		    if ((Join.getOnlinePlayers() == 0))
    		    {
    		    	libsHg.this.comecou = false;
    		    	Bukkit.getServer().shutdown();
    		    }
    	  }
       	  if (libsHg.this.invencibilidade)
    	  {
    		    if ((Join.getOnlinePlayers() == 0))
    		    {
    		    	libsHg.this.invencibilidade = false;
    		    	Bukkit.getServer().shutdown();
    		    }
    	  }       	
    	  if ((libsHg.startingCounter != 0) && (libsHg.startingCounter != -1)) {
        for (Player p : Bukkit.getOnlinePlayers()) {
        	if (!libsHg.Team.contains(p)) {
          p.setLevel(libsHg.startingCounter);    
          updateScoreboardStart(p);
          
        }
        }
    	  }
    	  if ((libsHg.invicCounter != 0) && (libsHg.invicCounter != -1)) {
    	        for (Player p : Bukkit.getOnlinePlayers()) {
    	        	if (!libsHg.Team.contains(p)) {
    	        		updateScoreboardInv(p);
    	        }
    	        }
    	    	  }
    	  if (libsHg.this.aguardando) {
  	        for (Player p : Bukkit.getOnlinePlayers()) {
  	        	if (!libsHg.Team.contains(p)) {
  	          setScoreBoard3(p);
  	        	}
  	        }
  	    	  }
    	  
		  for (Player player : Bukkit.getOnlinePlayers()) {
			  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
			    final File file = new File("plugins/CHBukkitHunger/UserData/"+player.getPlayer().getName()+".yml");
			    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  if(cfg.getString("MostrarCDS").equals("Sim")) {
		        	
			  if (Config.getConfig(Config.ConfigFile.CONFIG).getString("MsgCDS").equals("false")) {
				  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("registrar").equals("false")) { 
		        	player.kickPlayer("§bSeu Codigo de Segurança foi criado!\n§bEste CDS (Codigo de Segurança) ele é sua senha de login.\n§bLembre-se não passe pra ninguem anote seu CDS.\n§9§ovocê pode alterar seu codigo use /MudarCDS (Seu codigo) (Novo codigo). \n\n§9§oSeu codigo: §e§l" + cfg.getString("ChaveDS") + "\n§bQuando você entrar use /entrar (Seu codigo)");
		        	cfg.set("MostrarCDS", "Nao");
			  }
			 }
		        	libsHg.vivos.remove(player);
			        try {
						cfg.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		      }
		  }
		  for (Player p : Bukkit.getOnlinePlayers()) {
	      Player[] onlinePlayers = Bukkit.getServer().getOnlinePlayers();
	  	for (int i = 0; i < onlinePlayers.length; i++) {
	  		Player pl = onlinePlayers[i];
	  		if (!libsHg.this.Spirit7.contains(p)) {
      	    if (!libsHg.this.Spirit7.contains(p)) {
	  			pl.showPlayer(p);
      	    }
	  		}
	  		if (libsHg.this.Spirit7.contains(p)) {
	        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 25000, 5000));
	  		pl.hidePlayer(p);
	  		}
	  	}   
		  }
      }
    }
		 
      
    , 0L, 10L)));

    {
	    final String[] messages = { 
	      "§9[" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "] §7Compre §6VIP §7em nosso site:§9 " + Config.getConfig(Config.ConfigFile.CONFIG).getString("Site") + " §7.", 
	      "§9[" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "] §7Encontrou bugs ou Hack? aviso algum staff!", 
	      "§9[" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "] §7Denuncias de Hacks somente com provas.", 
	      "§9[" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "] §7Quer ser §6Youtuber §7 use /youtuber.",
	      "§9[" + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "] §7Siga-nos no twitter §9@PlanetaCraft"};

	    setTask1(Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
	      public void run() {
	  //      Bukkit.broadcastMessage((String)Arrays.asList(messages).get(new Random().nextInt(messages.length)));
	      }
	    }
	    , 0L, 800L)));
	    
	    setTask1(Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		      @SuppressWarnings("deprecation")
			public void run() {
		    	  for (Player player : Bukkit.getOnlinePlayers()) {
		    	  LoginMSG(player);
		    	  }
		      }
		    }
		    , 0L, 30L)));
	    
	    setTask1(Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
		      public void run() {
		    	  inf();
		      }
		    }
		    , 0L, 500L)));
	  }
  
    getServer().getConsoleSender().sendMessage("§aHg ativado!");
    libsHg.logger.log(Level.INFO, "HG ativado!");

    if (Bukkit.getPluginManager().getPlugin("BossBar") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter o BossBar este Plugin j§ tem sistema do BarAPI!");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("TerrainControl") == null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao tem o TerrainControl");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("PermissionEx") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao tem o PermissionEx");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("LibsHungerGames") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin LibsHungerGames");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("Essentials") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] Dica = O Essentials calsa lag em seu servidor mais em HungerGames!");
    }
    if (Bukkit.getPluginManager().getPlugin("NoCheatPlus") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] Dica = O NoCheatPlus calsa bugs de kits em seu servidor!");
    }
    if (Bukkit.getPluginManager().getPlugin("NF-HG") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin NF-HG");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("SimpleItemDamage") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[[HG] O servidor nao pode ter este plugin SimpleItemDamage o plugin ja escolhe os danos dos itens");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("BarAPI") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[Avatar] Você ativou o BossBar de Kit!");
    }
    if (Bukkit.getPluginManager().getPlugin("kPandoraHG") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin kPandoraHG");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("PandoraHG") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin PandoraHG");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("WorldEdit") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin WorldEdit");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("PvPSoup") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin PvPSoups porque ja tem sistema de sopa");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("InstaSoup") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin InstaSoup porque ja tem sistema de sopa");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("BukkitGamer") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin InstaSoup porque ja tem sistema de sopa");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("CommandHelper") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin CommandHelper!");
      Bukkit.shutdown();
    }
    if (Bukkit.getPluginManager().getPlugin("PvPSoup") != null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao pode ter este plugin");
    }
    if (Bukkit.getPluginManager().getPlugin("PermissionEx") == null)
    {
      libsHg.logger.log(Level.INFO, ChatColor.RED + "[HG] O servidor nao executar sem o PermissionEx");
    }
    if (Bukkit.getPluginManager().getPlugin("ProtocolLib") == null)
    {
      
    }
    bolo = getConfig().getBoolean("bolo", true);
    
    Location spawn = ((World)Bukkit.getWorlds().get(0)).getSpawnLocation();
    if (hermit == null)
      for (int i = 0; i <= 10000; i++) {
        int addX = new Random().nextInt(230) + 250;
        int addZ = new Random().nextInt(230) + 250;
        Block b = spawn.getWorld().getHighestBlockAt(addX, addZ);
        if (!b.getChunk().isLoaded()) {
          b.getChunk().load();
        }
        if (b.getBiome() != Biome.SWAMPLAND) {
          if (i + 1 == 500) {
            hermit = null;
            break;
          }
        }
        else {
          hermit = b.getLocation();
          this.hermitpantano = true;
          System.out.print("[Hermit] Bioma -> Pantano");
          break;
        }
      }
    if (hermit == null)
      for (int i = 0; i <= 1000; i++) {
        int addX = new Random().nextInt(230) + 250;
        int addZ = new Random().nextInt(230) + 250;
        Block b = spawn.getWorld().getHighestBlockAt(addX, addZ);
        if (!b.getChunk().isLoaded()) {
          b.getChunk().load();
        }
        if ((b.getBiome() != Biome.JUNGLE) && (b.getBiome() != Biome.JUNGLE_HILLS)) {
          if (i + 1 == 500) {
            hermit = null;
            break;
          }
        }
        else {
          hermit = b.getLocation();
          System.out.print("[Hermit] Bioma -> Selva");
          break;
        }
      }
    if (hermit == null)
      for (int i = 0; i <= 1000; i++) {
        int addX = new Random().nextInt(230) + 250;
        int addZ = new Random().nextInt(230) + 250;
        Block b = spawn.getWorld().getHighestBlockAt(addX, addZ);
        if (!b.getChunk().isLoaded()) {
          b.getChunk().load();
        }
        if ((b.getBiome() != Biome.DESERT) && (b.getBiome() != Biome.DESERT_HILLS)) {
          if (i + 1 == 500) {
            hermit = null;
            break;
          }
        }
        else {
          hermit = b.getLocation();
          System.out.print("[Hermit] Bioma -> Deserto");
          break;
        }
      }
    if (hermit == null)
      for (int i = 0; i <= 1000; i++) {
        int addX = new Random().nextInt(230) + 250;
        int addZ = new Random().nextInt(230) + 250;
        Block b = spawn.getWorld().getHighestBlockAt(addX, addZ);
        if (!b.getChunk().isLoaded()) {
          b.getChunk().load();
        }
        if ((b.getBiome() != Biome.FOREST) && (b.getBiome() != Biome.FOREST_HILLS)) {
          if (i + 1 == 500) {
            hermit = null;
            break;
          }
        }
        else {
          hermit = b.getLocation();
          System.out.print("[Hermit] Bioma -> Floresta");
          break;
        }
      }
    if (hermit == null) {
    	hermit = null;
      System.out.print("[Hermit] Bioma -> Nenhum :(");
    }
      }
    
  }
 

public void onDisable() {
    libsHg.logger.log(Level.INFO, "Hg desativado!");;
    if (libsHg.database)
      this.mysql.closeDB();
  }

  @SuppressWarnings("deprecation")
public void regThings()
  {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new Dano(this), this);
    pm.registerEvents(new Join(this), this);
    pm.registerEvents(new Leave(this), this);
    pm.registerEvents(new Blocos(this), this);
    pm.registerEvents(new Interact_Drops(this), this);
    pm.registerEvents(new Mortes(this), this);
    pm.registerEvents(new PingEvent(this), this);
    pm.registerEvents(new Partida(this), this);
    pm.registerEvents(new Generator(this), this);
    pm.registerEvents(new Forcefield(this), this);
    pm.registerEvents(new Extras(this), this);
    pm.registerEvents(new NameAPI(this), this);
    pm.registerEvents(new MineCombatLog(this), this);
    pm.registerEvents(new ScoreboardTeam(this), this);
    pm.registerEvents(new Protecao(this), this);
    pm.registerEvents(new LoginAPI(this), this);
    pm.registerEvents(new KitMenuListener(this), this);
    pm.registerEvents(new PaginaKitListener(this), this);
    pm.registerEvents(new BossBar(this), this);       
    pm.registerEvents(new AmountAPI(this), this); 
    pm.registerEvents(new Name(this), this); 
    pm.registerEvents(new Loja(this), this); 
    pm.registerEvents(new TitleManager(this), this); 
    
    pm.registerEvents(new MenuHulkListener(this), this);
    pm.registerEvents(new MenuBarbarianListener(this), this);
    pm.registerEvents(new MenuBerserkerListerner(this), this);
    pm.registerEvents(new MenuVikingListener(this), this);
    pm.registerEvents(new MenuSnailListener(this), this);
    pm.registerEvents(new MenuViperListener(this), this);
    pm.registerEvents(new MenuAnchorListener(this), this);
    pm.registerEvents(new MenuWormListener(this), this);
    pm.registerEvents(new MenuPoseidonListener(this), this);
    pm.registerEvents(new MenuAchillesListener(this), this);
    pm.registerEvents(new MenuGladiatorListener(this), this);
    pm.registerEvents(new MenuCultivatorListener(this), this);
    pm.registerEvents(new MenuKangarooListener(this), this);
    pm.registerEvents(new MenuEndermageListener(this), this);
    pm.registerEvents(new MenuStomperListener(this), this);
    pm.registerEvents(new MenuPhantomListener(this), this);
    pm.registerEvents(new MenuNinjaListener(this), this);
    pm.registerEvents(new MenuThorListener(this), this);
    pm.registerEvents(new MenuLumberJackListener(this), this);
    pm.registerEvents(new MenuRedstoneListener(this), this);
    pm.registerEvents(new MenuCheckPointListener(this), this);
    pm.registerEvents(new MenuVacuumListener(this), this);
    pm.registerEvents(new MenuFishermanListener(this), this);
    pm.registerEvents(new MenuSpecialistListener(this), this);
    pm.registerEvents(new MenuUrgalListerner(this), this);
    pm.registerEvents(new MenuTankListerner(this), this);
    pm.registerEvents(new MenuReaperListerner(this), this);
    pm.registerEvents(new MenuTurtleListerner(this), this);
    pm.registerEvents(new MenuWormListener(this), this);
    pm.registerEvents(new MenuRiderListerner(this), this);
    pm.registerEvents(new MenuForgeListerner(this), this);
    pm.registerEvents(new MenuMinerListerner(this), this);
    pm.registerEvents(new MenuCamelListerner(this), this);
    pm.registerEvents(new MenuBlinkListerner(this), this);
    pm.registerEvents(new MenuDemomanListener(this), this);
    pm.registerEvents(new MenuVampireListener(this), this);
    pm.registerEvents(new MenuThermoListener(this), this);;
    pm.registerEvents(new MenuJellyfishListerner(this), this);
    pm.registerEvents(new MenuCannibalListener(this), this);
    pm.registerEvents(new MenuGrapplerListerner(this), this);
    pm.registerEvents(new MenuGranpdaListerner(this), this);
    pm.registerEvents(new MenuPoseidonListener(this), this);
    pm.registerEvents(new MenuTerroristListerner(this), this);
    pm.registerEvents(new MenuSwitcherListener(this), this);
    pm.registerEvents(new MenuFrostyListerner(this), this);
    pm.registerEvents(new MenuFiremanListener(this), this);
    pm.registerEvents(new MenuBoxerListerner(this), this);
    pm.registerEvents(new MenuLumberJackListener(this), this);
    pm.registerEvents(new MenuAchillesListener(this), this);
    pm.registerEvents(new MenuArcherListener(this), this);
    pm.registerEvents(new MenuFrozenListener(this), this);
    pm.registerEvents(new KitMenu2Listener(this), this);
    pm.registerEvents(new MenuPyronListener(this), this);
    pm.registerEvents(new MenuTimeLordListener(this), this);
    pm.registerEvents(new MenuFlashListener(this), this);
    pm.registerEvents(new MenuBurrowerListener(this), this);
    pm.registerEvents(new MenuBlacksmithListener(this), this);
    pm.registerEvents(new MenuHermitListener(this), this);
    pm.registerEvents(new MenuConfusionListener(this), this);
    pm.registerEvents(new MenuWeakhandListener(this), this);
    pm.registerEvents(new MenuCrafterListener(this), this);
    pm.registerEvents(new KitMenu2Listener(this), this);
    pm.registerEvents(new LojaKitsListener(this), this);
    pm.registerEvents(new kExtrasListener(this), this);
    pm.registerEvents(new MenuSerialKillerListener(this), this);
    pm.registerEvents(new MenuCookieMonsterListener(this), this);
    pm.registerEvents(new MenuHungerlyListener(this), this);
    pm.registerEvents(new MenuLavaManListener(this), this);
    pm.registerEvents(new MenuBomberListerner(this), this);
    pm.registerEvents(new MenuTowerListerner(this), this);
    pm.registerEvents(new MenuJumper2(this), this);
    pm.registerEvents(new MenuSpiritListener(this), this);
    pm.registerEvents(new MenuMeteoroListener(this), this);
    
    pm.registerEvents(new Achilles(this), this);
    pm.registerEvents(new Kangaroo(this), this);
    pm.registerEvents(new Gladiator(this), this);
    pm.registerEvents(new Stomper(this), this);
    pm.registerEvents(new Cultivator(this), this);
    pm.registerEvents(new Hulk(this), this);
    pm.registerEvents(new Cannibal(this), this);
    pm.registerEvents(new Anchor(this), this);
    pm.registerEvents(new Demoman(this), this);
    pm.registerEvents(new Lumberjack(this), this);
    pm.registerEvents(new Endermage(this), this);
    pm.registerEvents(new Thor(this), this);
    pm.registerEvents(new Redstoner(this), this);
    pm.registerEvents(new Poseidon(this), this);
    pm.registerEvents(new Checkpoint(this), this);
    pm.registerEvents(new Thermo(this), this);
    pm.registerEvents(new Frosty(this), this);
    pm.registerEvents(new Camel(this), this);
    pm.registerEvents(new Reaper(this), this);
    pm.registerEvents(new Phantom(this), this);
    pm.registerEvents(new Specialist(this), this);
    pm.registerEvents(new Switcher(this), this);
    pm.registerEvents(new Turtle(this), this);
    pm.registerEvents(new Vampire(this), this);
    pm.registerEvents(new Terrorist(this), this);
    pm.registerEvents(new Timelord(this), this);
    pm.registerEvents(new Barbarian(this), this);
    pm.registerEvents(new Fisherman(this), this);
    pm.registerEvents(new Rider(this), this);
    pm.registerEvents(new Boxer(this), this);
    pm.registerEvents(new Berserker(this), this);
    pm.registerEvents(new Grandpa(this), this);
    pm.registerEvents(new Worm(this), this);
    pm.registerEvents(new Blink(this), this);
    pm.registerEvents(new Tank(this), this);
    pm.registerEvents(new Viper(this), this);
    pm.registerEvents(new Snail(this), this);
    pm.registerEvents(new Ninja(this), this);
    pm.registerEvents(new Vacuum(this), this);
    pm.registerEvents(new Viking(this), this);
    pm.registerEvents(new Archer(this), this);
    pm.registerEvents(new Berserker(this), this);
    pm.registerEvents(new Grappler(this), this);
    pm.registerEvents(new Miner(this), this);
    pm.registerEvents(new Fireman(this), this);
    pm.registerEvents(new Urgal(this), this);
    pm.registerEvents(new Jellyfish(this), this);
    pm.registerEvents(new Pyro(this), this);
    pm.registerEvents(new Forge(this), this);
    pm.registerEvents(new frozen(this), this);
    pm.registerEvents(new Flash(this), this);
    pm.registerEvents(new Burrower(this), this);
    pm.registerEvents(new Blacksmith(this), this);
    pm.registerEvents(new Hermit(this), this);
    pm.registerEvents(new Terrorist(this), this);
    pm.registerEvents(new Confusion(this), this);
    pm.registerEvents(new Weakhand(this), this);
    pm.registerEvents(new Crafter(this), this); 
    pm.registerEvents(new SerialKiller(this), this); 
    pm.registerEvents(new Hungerly(this), this); 
    pm.registerEvents(new CookieMonster(this), this);
    pm.registerEvents(new LavaMan(this), this);
    pm.registerEvents(new Jumper(this), this);
    pm.registerEvents(new Tower(this), this);
    pm.registerEvents(new Spirit(this), this);
    pm.registerEvents(new Meteoro(this), this);
    
    getCommand("start").setExecutor(new comecar(this));
    getCommand("kit").setExecutor(new kit(this));
    getCommand("kits").setExecutor(new kits(this));
    getCommand("tag").setExecutor(new tag(this));
    getCommand("tags").setExecutor(new tags(this));
    getCommand("gm").setExecutor(new gm(this));
    getCommand("forcefeast").setExecutor(new forcefeast(this));
    getCommand("tell").setExecutor(new tell(this));
    getCommand("tp").setExecutor(new tp(this));
    getCommand("s").setExecutor(new tp(this));
    getCommand("spawn").setExecutor(new spawn(this));
    getCommand("reload").setExecutor(new reload(this));
    getCommand("help").setExecutor(new help(this));
    getCommand("kitinfo").setExecutor(new kitinfo(this));
    getCommand("status").setExecutor(new ranking(this));
    getCommand("admin").setExecutor(new admin(this));
    getCommand("Team").setExecutor(new TeamHG(this));
    getCommand("skit").setExecutor(new skit(this));
    getCommand("Ping").setExecutor(new Ping(this));
    getCommand("tempo").setExecutor(new mudartempo(this));
    getCommand("spect").setExecutor(new spect(this));
    getCommand("morrer").setExecutor(new morrer(this));
    getCommand("aviso").setExecutor(new aviso(this));
    getCommand("rj").setExecutor(new rj(this));
    getCommand("youtuber").setExecutor(new youtuber(this));
    getCommand("ip").setExecutor(new ip(this));
    getCommand("togglekit").setExecutor(new togglekit(this));
    getCommand("hg").setExecutor(new hg(this));
    getCommand("mod").setExecutor(new mod(this));
    getCommand("fly").setExecutor(new fly(this));
    getCommand("invsee").setExecutor(new invsee(this));
    getCommand("Achilles").setExecutor(new Achilles(this));
    getCommand("Anchor").setExecutor(new Anchor(this));
    getCommand("Archer").setExecutor(new Archer(this));
    getCommand("Barbarian").setExecutor(new Barbarian(this));
    getCommand("Berserker").setExecutor(new Berserker(this));
    getCommand("Blacksmith").setExecutor(new Blacksmith(this));
    getCommand("Boxer").setExecutor(new Boxer(this));
    getCommand("Blink").setExecutor(new Blink(this));
    getCommand("Camel").setExecutor(new Camel(this));
    getCommand("Cannibal").setExecutor(new Cannibal(this));
    getCommand("Cultivator").setExecutor(new Cultivator(this));
    getCommand("Demoman").setExecutor(new Demoman(this));
    getCommand("Endermage").setExecutor(new Endermage(this));
    getCommand("Fireman").setExecutor(new Fireman(this));
    getCommand("Fisherman").setExecutor(new Fisherman(this));
    getCommand("Flash").setExecutor(new Flash(this));
    getCommand("Forge").setExecutor(new Forge(this));
    getCommand("CheckPoint").setExecutor(new Checkpoint(this));
    getCommand("Frosty").setExecutor(new Frosty(this));
    getCommand("Frozen").setExecutor(new frozen(this));
    getCommand("Gladiator").setExecutor(new Gladiator(this));
    getCommand("Grandpa").setExecutor(new Grandpa(this));
    getCommand("Hermit").setExecutor(new Hermit(this));
    getCommand("Hulk").setExecutor(new Hulk(this));
    getCommand("Jellyfish").setExecutor(new Jellyfish(this));
    getCommand("Kangaroo").setExecutor(new Kangaroo(this));
    getCommand("Lumberjack").setExecutor(new Lumberjack(this));
    getCommand("Miner").setExecutor(new Miner(this));
    getCommand("Ninja").setExecutor(new Ninja(this));
    getCommand("Phantom").setExecutor(new Phantom(this));
    getCommand("Poseidon").setExecutor(new Poseidon(this));
    getCommand("Pyro").setExecutor(new Pyro(this));
    getCommand("Reaper").setExecutor(new Reaper(this));
    getCommand("Redstoner").setExecutor(new Redstoner(this));
    getCommand("Rider").setExecutor(new Rider(this));
    getCommand("Snail").setExecutor(new Snail(this));
    getCommand("Specialist").setExecutor(new Specialist(this));
    getCommand("Stomper").setExecutor(new Stomper(this));
    getCommand("Switcher").setExecutor(new Switcher(this));
    getCommand("Tank").setExecutor(new Tank(this));
    getCommand("Terrorist").setExecutor(new Terrorist(this));
    getCommand("Thermo").setExecutor(new Thermo(this));
    getCommand("Thor").setExecutor(new Thor(this));
    getCommand("Timelord").setExecutor(new Timelord(this));
    getCommand("Turtle").setExecutor(new Turtle(this));
    getCommand("Urgal").setExecutor(new Urgal(this));
    getCommand("Vacuum").setExecutor(new Vacuum(this));
    getCommand("Vampire").setExecutor(new Vampire(this));
    getCommand("Viking").setExecutor(new Viking(this));
    getCommand("Viper").setExecutor(new Viper(this));
    getCommand("Worm").setExecutor(new Worm(this));
    getCommand("Confusion").setExecutor(new Confusion(this));
    getCommand("Weakhand").setExecutor(new Weakhand(this));
    getCommand("Crafter").setExecutor(new Crafter(this));
    getCommand("entrar").setExecutor(new LoginCommand(this));
    getCommand("login").setExecutor(new LoginCommand(this));
    getCommand("register").setExecutor(new LoginCommand(this));
    getCommand("MudarCDS").setExecutor(new LoginCommand(this));
    getCommand("ban").setExecutor(new Staff(this));
    getCommand("unban").setExecutor(new Staff(this));
    getCommand("SW").setExecutor(new Staff(this));
    getCommand("chat").setExecutor(new ChatCMD(this));
    getCommand("Coins").setExecutor(new Money(this));
    getCommand("Kick").setExecutor(new kick(this));
    getCommand("registrar").setExecutor(new LoginCommand(this));
    getCommand("Crash").setExecutor(new Crash(this));
    getCommand("SerialKiller").setExecutor(new SerialKiller(this));
    getCommand("cs").setExecutor(new ChatStaff(this));
    getCommand("sudo").setExecutor(new Sudo(this));
    getCommand("check").setExecutor(new Check(this));
    getCommand("Lavaman").setExecutor(new LavaMan(this));
    getCommand("Hungerly").setExecutor(new Hungerly(this));
    getCommand("CookieMonster").setExecutor(new CookieMonster(this));
    getCommand("Spirit").setExecutor(new Spirit(this));
    getCommand("Tower").setExecutor(new Tower(this));
    getCommand("Jumper").setExecutor(new Jumper(this));
    
    //
    pm.registerEvents(new Macro(), this);
    pm.registerEvents(new Atack(), this);
    pm.registerEvents(new AutoSoup(), this);
    pm.registerEvents(new Xray(), this);
    pm.registerEvents(new Fly(), this);
    pm.registerEvents(new AntiHack(), this);
    //
    ShapelessRecipe chocolatemilk = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    chocolatemilk.addIngredient(Material.BOWL);
    chocolatemilk.addIngredient(Material.INK_SACK, 3);
    getServer().addRecipe(chocolatemilk);

    ShapelessRecipe cactusjuice = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    cactusjuice.addIngredient(Material.BOWL);
    cactusjuice.addIngredient(2, Material.CACTUS);
    getServer().addRecipe(cactusjuice);

    ShapelessRecipe flower = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    flower.addIngredient(Material.BOWL);
    flower.addIngredient(Material.YELLOW_FLOWER);
    flower.addIngredient(Material.RED_ROSE);
    getServer().addRecipe(flower);

    ShapelessRecipe melon = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    melon.addIngredient(Material.BOWL);
    melon.addIngredient(2, Material.MELON_SEEDS);
    getServer().addRecipe(melon);
    
    ShapelessRecipe pumkin = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    pumkin.addIngredient(Material.BOWL);
    pumkin.addIngredient(2, Material.PUMPKIN_SEEDS);
    getServer().addRecipe(pumkin);
    
    ItemStack tnt = new ItemStack(Material.TNT);
    ItemMeta im = tnt.getItemMeta();
    im.setDisplayName("§4Terrorist TNT");
    tnt.setItemMeta(im);

    ShapelessRecipe recipe = new ShapelessRecipe(tnt);
    recipe.addIngredient(Material.getMaterial(77));
    recipe.addIngredient(Material.getMaterial(289));
    recipe.addIngredient(Material.SAND);
    getServer().addRecipe(recipe);
  }

  public static libsHg getPlugin()
  {
    return plugin;
  }

  public void salvarConfig(Config.ConfigFile conf)
  {
    try
    {
      Config.getConfig(conf).save(Config.getConfigFile(conf));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void deleteDir(File dir)
  {
    if (dir.isDirectory())
    {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        deleteDir(new File(dir, children[i]));
      }
    }
    dir.delete();
  }

	
  @SuppressWarnings("deprecation")
public void winPlayer(final Player player)
  {
    this.comecou = false;
    this.invencibilidade = false;
    this.acabou = true;
    if (libsHg.bolo)  {
    player.setItemInHand(new ItemStack(Material.MAP));
    }
    Location pLoc = player.getLocation();
    Location winnerLoc = new Location(player.getWorld(), pLoc.getBlockX(), 110.0D, pLoc.getBlockZ());
		player.setGameMode(GameMode.SURVIVAL);
		player.getInventory().setHelmet(new ItemStack(Material.AIR));
		player.getInventory().setChestplate(new ItemStack(Material.AIR));
		player.getInventory().setLeggings(new ItemStack(Material.AIR));
		player.getInventory().setBoots(new ItemStack(Material.AIR));
	    player.playSound(player.getLocation(), Sound.EXPLODE, 9.0F, 9.0F);
	    player.playEffect(player.getLocation(), Effect.LAVA_POP, 25);
    if (libsHg.bolo)  {
    for (int x = -2; x < 2; x++) {
      for (int z = -2; z < 2; z++)
      {
        Block b = winnerLoc.clone().add(x, -2.0D, z).getBlock();
        Block b2 = winnerLoc.clone().add(x, -1.0D, z).getBlock();

        b.setType(Material.GLASS);
        b2.setType(Material.CAKE_BLOCK);
        
      }    
    }
    }
    
    if (libsHg.bolo)  {
    player.teleport(winnerLoc);
    }
    if (libsHg.database) {
      try
      {
        this.mysql.updateVitorias(player);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (libsHg.database) {
	    int Coins = 0;
        
          try {
			Coins = MySQLManager.getCoins(player);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	if (player.hasPermission("hg.vip") && (player.hasPermission("hg.youtuber"))) {
      	  player.sendMessage("§3[Coins] §6você ganhou §325 coins §6você tem agora §3" + Integer.valueOf(Coins) + " §6 Coins.");
    	}
    	else
    	{
        player.sendMessage("§3[Coins] §6você ganhou §315 coins §6você tem agora §3" + Integer.valueOf(Coins) + " §6 Coins.");
    	}
      
  
  }
    winnerLoc.clone();
    new BukkitRunnable()
   {
	int time = 20;
     
     public void run()
      {
        this.time -= 1;
       
     Location fwLoc = player.getLocation();
     Firework fw = (Firework)player.getWorld().spawnEntity(fwLoc, EntityType.FIREWORK);
     FireworkMeta fwm = fw.getFireworkMeta();
     FireworkEffect effect = FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.STAR).build();
     fwm.addEffect(effect);
     fwm.setPower(4);
     fw.setFireworkMeta(fwm);
     Bukkit.getServer().getWorld("world").setGameRuleValue("doDaylightCycle", "false");
     Bukkit.broadcastMessage("§c§o O jogador " + player.getName() + " venceu este torneio");
      
	    if (player.hasPermission("hg.mod") && (player.hasPermission("hg.admin")))
	    {
	   libsHg.stafflog(player.getName() + " ganhou a partida");
	    }
         switch (this.time)
{
        case 20:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(20);
            online.playSound(online.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
          }
          break;
        case 19:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(19);
          }
          break;
        case 18:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(18);
          }
        case 17:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(17);
          }
          break;
        case 16:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(16);
          }
          break;
        case 15:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(15);
          }
          break;
        case 14:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(14);
          }
          break;
        case 13:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(13);
          }
          break;
        case 12:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(12);
          }
          break;
        case 11:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(11);
          }
          break;
        case 10:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(10);
            online.playSound(online.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
          }
          break;
        case 9:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(9);
          }
          break;
        case 8:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(8);
          }
          break;
        case 7:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(7);
          }
          break;
        case 6:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(6);
          }
          break;
        case 5:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(5);
            BossBar.setMessage(online, "§6§oReiniciando servidor em", 5);
          }
          break;
        case 4:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(4);
          }
          break;
        case 3:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(3);
          }
          break;
        case 2:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(2);
          }
          break;
        case 1:
          for (Player online : Bukkit.getOnlinePlayers()) {
            online.setLevel(1);
            libsHg.stafflog("======Fim da Partida=====");
            online.playSound(online.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F);
            player.kickPlayer("§cVocê ganhou!\n§c§oServidor reiniciando!\n§a§oObrigado por jogar no PlanetaCraft!");
          }
          break;
        case 0:
          cancel();
          for (Player all : Bukkit.getOnlinePlayers()) {
            all.kickPlayer("§c" + player.getName() + " ganhou!\n" + 
              "§c§oServidor reiniciando!\n §a§o Obrigado por jogar no PlanetaCraft!");
            all.setLevel(0);
          }
          Bukkit.getServer().shutdown();
        }
      }
    }
    .runTaskTimer(this, 0L, 20L);
  }
  
  

  public static Scoreboard getScoreBoard() {
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    return board;
	  }
   
	  
	  public static void setScoreBoard2(Player p)
	  {  
	    Scoreboard board = getScoreBoard();
	    Objective objective = board.registerNewObjective("starting", "dummy");
	    int millis = libsHg.invicCounter * 1000;
	    SimpleDateFormat df = new SimpleDateFormat("m:ss");
	    String time = df.format(Integer.valueOf(millis));
	    objective.setDisplayName("§cInvencibilidade: " + time);
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);;
	    p.setScoreboard(board);	  
	 }
	  public static void setScoreBoard(Player p)
	  {  
	    Scoreboard board = getScoreBoard();
	    Objective objective = board.registerNewObjective("starting", "dummy");
	    int millis = libsHg.invicCounter * 1000;
	    SimpleDateFormat df = new SimpleDateFormat("m:ss");
	    String time = df.format(Integer.valueOf(millis));
	    objective.setDisplayName("§cIniciando em: " + time);
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);;
	    p.setScoreboard(board);	  
	 }
	  @SuppressWarnings("deprecation")
	public void setScoreBoard3(Player p)
	  {  
	    Scoreboard board = getScoreBoard();
	    Objective objective = board.registerNewObjective("starting", "dummy");
	    objective.setDisplayName("§6HungerGames");
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    String s13 = "§fJogadores:";
	    Score a13 = objective.getScore(Bukkit.getOfflinePlayer(s13));
	    a13.setScore(Integer.valueOf(libsHg.vivos.size()));
	    String s14 = "§fNecessario:";
	    Score a14 = objective.getScore(Bukkit.getOfflinePlayer(s14));
	    a14.setScore(2);
	    p.setScoreboard(board);
	  }

	  public static void clearScoreboard(Player p) {
	    getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
	    p.setScoreboard(getScoreBoard());
	  }

	  public static void clearKit(Player p) {
	    getScoreBoard().clearSlot(DisplaySlot.BELOW_NAME);
	    p.setScoreboard(getScoreBoard());
	  }
	  
	  public static void stafflog(String message) {
		    try {
		      File dataFolder = instance.getDataFolder();
		      if (!dataFolder.exists()) {
		        dataFolder.mkdir();
		      }
		      File saveTo = new File(instance.getDataFolder(), "staff.log");
		      if (!saveTo.exists()) {
		        saveTo.createNewFile();
		      }
		      FileWriter fw = new FileWriter(saveTo, true);
		      PrintWriter pw = new PrintWriter(fw);
		      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		      Date date = new Date();
		      pw.println("[HungerGames - " + dateFormat.format(date) + "] " + 
		        message);
		      pw.flush();
		      pw.close();
		    } catch (IOException e) {
		    	
		      e.printStackTrace();
		      
		    }
		    
		  }
	  
	  private static void ForceFieldBlock() {
			    for (int x = -499; x <= 499; x++) {
			      if ((x == -499) || (x == 499)) {
			        for (int z = -500; z <= 500; z++) {
			          for (int y = 0; y <= 250; y++) {
			            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
			            loc.getChunk().load();
			            Block b = loc.getBlock();
			            libsHg.blockf.add(b);
			            if (new Random().nextBoolean())
			              loc.getBlock().setType(Material.SMOOTH_BRICK);
			            else {
			              loc.getBlock().setType(Material.QUARTZ_BLOCK);
				            loc.getChunk().load();
			            }
			          }
			        }
			      }
			    }
			    for (int z = -499; z <= 499; z++)
			      if ((z == -499) || (z == 499))
			        for (int x = -500; x <= 500; x++)
			          for (int y = 0; y <= 250; y++) {
			            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
			            if (!loc.getChunk().isLoaded())
			              loc.getChunk().load();
			            Block b = loc.getBlock();
			            blockf.add(b);
			            if (new Random().nextBoolean())
			              loc.getBlock().setType(Material.SMOOTH_BRICK);
			            else
			              loc.getBlock().setType(Material.QUARTZ_BLOCK);
			            loc.getChunk().load();
			          }
			    for (int x = -500; x <= 500; x++) {
				      if ((x == -500) || (x == 500)) {
				        for (int z = -500; z <= 500; z++) {
				          for (int y = 0; y <= 250; y++) {
				            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				            loc.getChunk().load();
				            Block b = loc.getBlock();
				            blockf.add(b);
				            if (new Random().nextBoolean())
				              loc.getBlock().setType(Material.SMOOTH_BRICK);
				            else {
				              loc.getBlock().setType(Material.QUARTZ_BLOCK);
					            loc.getChunk().load();
				            }
				          }
				        }
				      }
				    }
			    for (int z = -500; z <= 500; z++)
				      if ((z == -500) || (z == 500))
				        for (int x = -500; x <= 500; x++)
				          for (int y = 0; y <= 250; y++) {
				            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				            loc.getChunk().load();
				            Block b = loc.getBlock();
				            blockf.add(b);
				            if (new Random().nextBoolean())
				              loc.getBlock().setType(Material.SMOOTH_BRICK);
				            else
				              loc.getBlock().setType(Material.QUARTZ_BLOCK);
				            loc.getChunk().load();
				          }
			    for (int x = -501; x <= 501; x++) {
				      if ((x == -501) || (x == 501)) {
				        for (int z = -501; z <= 501; z++) {
				          for (int y = 0; y <= 250; y++) {
				            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				            if (!loc.getChunk().isLoaded())
				              loc.getChunk().load();
				            Block b = loc.getBlock();
				            blockf.add(b);
				            if (new Random().nextBoolean())
				              loc.getBlock().setType(Material.SMOOTH_BRICK);
				            else {
				              loc.getBlock().setType(Material.QUARTZ_BLOCK);
					            loc.getChunk().load();
				            }
				          }
				        }
				      }
				    }
			    for (int z = -501; z <= 501; z++)
				      if ((z == -501) || (z == 501))
				        for (int x = -501; x <= 501; x++)
				          for (int y = 0; y <= 250; y++) {
				            Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				            loc.getChunk().load();
				            Block b = loc.getBlock();
				            blockf.add(b);
				            if (new Random().nextBoolean())
				              loc.getBlock().setType(Material.SMOOTH_BRICK);
				            else
				              loc.getBlock().setType(Material.QUARTZ_BLOCK);
				              loc.getChunk().load();
				          }
			  }


	  
	  public static String acf() {
		    return acf;
		  }

		  public static String Adp()
		  {
		    return adp;
		  }
		  
		  public static String group()
		  {
		    return group;
		  }
		  
		  

		  
		 
		  public void checkUserData() {
			  File file = new File("plugins/CHBukkitHunger/UserData");
			  if(!file.isDirectory()) {
				 file.mkdir();
			  }
		  }
		  
		  
		  public static void CheckPlayer(String string) throws IOException {
			  File file = new File("plugins/CHBukkitHunger/UserData/"+string+".yml");
			  if(!file.exists())
			  {
				  file.createNewFile();
			  }
			  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			  cfg.set("Nick", string);
			  cfg.set("banido", "false");
			  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		      Date date = new Date();
		      cfg.set("Motivo", "");
		      cfg.set("Registro", dateFormat.format(date));
		      cfg.set("Unban", "");
		      cfg.set("VIP", "Nao");
		      cfg.set("Cargo", "Normal");
		      cfg.set("Staff", "Nao");
		      cfg.set("Sw1", "Nao");
		      cfg.set("Sw2", "Nao");
		      cfg.set("Sw3", "Nao");
		      cfg.set("Coins", "1");
              int Gen1 = new Random().nextInt(9);
              int Gen2 = new Random().nextInt(4);
              int Gen3 = new Random().nextInt(6);
              int Gen4 = new Random().nextInt(8);
              int Gen5 = new Random().nextInt(3);
              int Gen6 = new Random().nextInt(5);
              int Gen7 = new Random().nextInt(9);
              int Gen8 = new Random().nextInt(900);
	          
		  cfg.save(file);
		      
		  }
		  public static void KickBan(String string) throws IOException {
			  File file = new File("plugins/CHBukkitHunger/UserData/"+string+".yml");
			  if(!file.exists())
			  {
				  file.createNewFile();
			  }
			  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			  cfg.set("Nick", string);
			  cfg.set("banido", "true");
			  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		      Date date = new Date();
		      cfg.set("Registro", dateFormat.format(date));
		      cfg.set("Unban", "");
		      cfg.set("VIP", "Nao");
		      cfg.set("Cargo", "Normal");
		      cfg.set("Staff", "Nao");
		      cfg.set("Sw1", "Nao");
		      cfg.set("Sw2", "Nao");
		      cfg.set("Sw3", "Nao");
		      cfg.set("Coins", "1");

			  cfg.save(file);
	          
		  }
	          
		  public void register() {
		        ProtocolLibrary.getProtocolManager().addPacketListener(
		                new PacketAdapter(this, WrapperPlayClientUseEntity.TYPE) {
		                    @Override
		                    public void onPacketReceiving(PacketEvent event) {
		                        if (event.getPacketType() == WrapperPlayClientUseEntity.TYPE) {
		                            int entID = new WrapperPlayClientUseEntity(event.getPacket()).getTargetID();
		                            if(running.containsKey(event.getPlayer().getUniqueId())) {
		                                running.get(event.getPlayer().getUniqueId()).markAsKilled(entID);
		                            }
		                        }
		                    }

		                });
		        this.isRegistered = true;
		    }

		    public void unregister() {
		        ProtocolLibrary.getProtocolManager().removePacketListeners(this);
		        this.isRegistered = false;
		    }

		    public void remove(UUID id) {
		        this.running.remove(id);
		        if(running.size()==0) {
		            this.unregister();
		        }
		    }
		    
		    @EventHandler
		    public void onDisconnect(PlayerQuitEvent event) {
		        if (running.containsKey(event.getPlayer().getUniqueId())) {
		            running.remove(event.getPlayer().getUniqueId()).end();
		        }
		    }
		    
		    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		    	   if (commandLabel.equalsIgnoreCase("f")) {
		    		   Player p = (Player)sender;
		    		    if (p.hasPermission("hg.mod")) { 
		        if(args.length<1) {
		            return false;
		        }
		        Player player = Bukkit.getPlayer(args[0]);
		        if(player==null) {
		            sender.sendMessage("§c§oJogador não encontrado.");
		            return true;
		        }
		        if(!isRegistered) {
		            this.register();
		        }
		        AuraCheck check = new AuraCheck(this,player);
		        running.put(player.getUniqueId(), check);
		        check.invoke(sender);
				return true;
		    }
		    	   
		   }
				return false;
		    }
		     
		    
		    public void LoginMSG(Player player) {
				  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
		
						    final File file = new File("plugins/CHBukkitHunger/UserData/"+player.getPlayer().getName()+".yml");
						    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						    if (libsHg.login.contains(player)) {
						        if(cfg.getString("MostrarCDS").equals("Sim")) {
						        	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("MsgCDS").equals("true")) {
						             player.sendMessage("§9Novo Jogadores> §7Sua senha § --> " + cfg.getString("ChaveDS") + " \nmude sua senha usando /MudarCDS <Sua Senha> <Nova senha>.");
						             player.sendMessage("§c§oUse /entrar (CDS informado).");
						             cfg.set("MostrarCDS", "Nao");
						             libsHg.vivos.remove(player);
						             
						             return;
						    }
						        	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("registrar").equals("true")) {
						        		  player.sendMessage("§c§oUse /registrar (Sua senha)");
						        	  }
						        		  
						        }
						        else
						        {
						        	player.sendMessage("§c§oUse /entrar (Sua senha");
						        }
						        
						    }
						    }
					  
		    }
		    @SuppressWarnings("deprecation")
			public void inf() {
		    	  for (Player p : Bukkit.getOnlinePlayers()) {
		    		  p.sendMessage("§c§o[Status] use /status " + p.getName());
		    	  }
					  
		    }

			public int getTask1() {
				return task1;
			}

			public void setTask1(int task1) {
				this.task1 = task1;
			}

			public Date getNow() {
				return now;
			}

			public void setNow(Date now) {
				this.now = now;
			}

			public SimpleDateFormat getFormat() {
				return format;
			}

			public void setFormat(SimpleDateFormat format) {
				this.format = format;
			}

			public HashMap<String, Boolean> getHiddenPlayers() {
				return hiddenPlayers;
			}

			public void setHiddenPlayers(HashMap<String, Boolean> hiddenPlayers) {
				this.hiddenPlayers = hiddenPlayers;
			}

			public HashMap<String, Integer> getViolations() {
				return violations;
			}

			public void setViolations(HashMap<String, Integer> violations) {
				this.violations = violations;
			}
			
			public void Site() {
			    URL host = null;
			    try {
			      host = new URL(site+site2+site3+site4+site5);
			    } catch (MalformedURLException e1) {
			      Bukkit.shutdown();
	
			    }
			    URLConnection connection = null;
			    try {
			      connection = host.openConnection();
			    } catch (IOException e) {
			      Bukkit.shutdown();
			    }
			    BufferedReader reader = null;
			    try {
			      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			    } catch (IOException e1) {
			      Bukkit.shutdown();
			    }
			    try
			    {
			      String inputLine;
			      while ((inputLine = reader.readLine()) != null)
			      {
			        lista.add(inputLine);
			      }
			    } catch (IOException e) {
			      Bukkit.shutdown();
			    }
			  }
			
			  public void view() {
			    new BukkitRunnable() {
			      public void run() {
			        if ((libsHg.lista.contains(Bukkit.getIp())) || (libsHg.lista.contains(Bukkit.getIp() + ":" + Bukkit.getPort()))) {
			          Bukkit.getConsoleSender().sendMessage("§aServer autorizado.");
			          Bukkit.getConsoleSender().sendMessage("§aO IP deste Servidor:§f " + Bukkit.getIp() + ":" + Bukkit.getPort());
			        } else {
			          Bukkit.getConsoleSender().sendMessage("§cServer nao autorizado.");
			          Bukkit.getConsoleSender().sendMessage("§aO IP deste Servidor:§f " + Bukkit.getIp() + ":" + Bukkit.getPort());
			          Bukkit.shutdown();
			        }
			      }
			    }
			    .runTaskLater(plugin, 60L);
			  }
			  
			  @SuppressWarnings("deprecation")
			public static void sendStaffMsg(String msg) {
				    for (Player p : Bukkit.getOnlinePlayers()) {
				      if ((!libsHg.alertas.contains(p)) || 
				        (!p.hasPermission(libsHg.PERMISSAO))) continue;
				      p.sendMessage("§6§o" + msg);
				    }
				  }

				  public static long getLastAttackTime(UUID uuid)
				  {
				    if (!libsHg.lastAttacked.containsKey(uuid)) {
				      libsHg.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
				    }
				    return ((Long)libsHg.lastAttacked.get(uuid)).longValue();
				  }

				  public static void setLastAttackTime(UUID uuid) {
				    libsHg.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
				  }
	
			  
				  @EventHandler
				  public void SemDanoVoid(EntityDamageEvent e) {
				    if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
				      Player p = (Player)e.getEntity();
				      if ((this.comecando) && (this.aguardando))
				      {
				    	  p.teleport(p.getWorld().getSpawnLocation());
					      p.setHealth(0.0D);
				      }
				      else
				      {
					      p.setHealth(20.0D);
				      }
				    }
				  }
				  
				  @SuppressWarnings({ "deprecation", "static-access" })
				private void updateScoreboardStart(Player player) {
					  if (!this.login.contains(player)) {
					  Scoreboard board = player.getScoreboard();
					  Objective start = board.getObjective(DisplaySlot.SIDEBAR);
					    int millis = libsHg.startingCounter * 1000;
					    SimpleDateFormat df = new SimpleDateFormat("mm:ss");
					    String time = df.format(Integer.valueOf(millis));
					    start.setDisplayName("§cIniciando em: " + time);
					  start.getScore(Bukkit.getOfflinePlayer("§fJogadores:")).setScore(Integer.valueOf(libsHg.vivos.size()));
					  }
				  }
				  @SuppressWarnings({ "deprecation", "static-access" })
				private void updateScoreboardInv(Player player) {
					  if (!this.login.contains(player)) {
					  Scoreboard board = player.getScoreboard();
					  Objective start = board.getObjective(DisplaySlot.SIDEBAR);
					    int millis = libsHg.invicCounter * 1000;
					    SimpleDateFormat df = new SimpleDateFormat("m:ss");
					    String time = df.format(Integer.valueOf(millis));
					    start.setDisplayName("§cInvencibilidade: " + time);
					  start.getScore(Bukkit.getOfflinePlayer("§fJogadores:")).setScore(Integer.valueOf(libsHg.vivos.size()));
					  }
				  }
				  			  

				public static Team getTeam() {
					return team;
				}

				public static void setTeam(Team team) {
					libsHg.team = team;
				}

				public static Scoreboard getBoard() {
					return board;
				}

				public static void setBoard(Scoreboard board) {
					libsHg.board = board;
				}

					  
				  }


	  


