package spinghg.hungergames.listeners;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;
import org.bukkit.scheduler.BukkitScheduler;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.api.configs.Config.ConfigFile;
import spinghg.hungergames.api.mysql.MySQLManager;
import spinghg.hungergames.libsHg;

public class Extras
  implements Listener
{
  private libsHg pl;
  
  public Extras(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  ArrayList<Player> vanished = new ArrayList();
  ArrayList<Player> adminmode = new ArrayList();
  private static Pattern VALID_CHARS_PATTERN = Pattern.compile("[A-Za-z0-9_]");
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void comandoInvalido(PlayerCommandPreprocessEvent event)
  {
    if (!event.isCancelled())
    {
      Player player = event.getPlayer();
      String cmd = event.getMessage().split(" ")[0];
      HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
      if (topic == null)
      {
        player.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oEste comando não foi localizado");
        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
        event.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void SemChuva(WeatherChangeEvent event)
  {
    if (event.toWeatherState()) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onChat(AsyncPlayerChatEvent event)
  {
    AntiSpam.OnPlayerChat(event);
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onPlayerLogin(PlayerLoginEvent event)
  {
    Player player = event.getPlayer();
    String invalidChars = getInvalidChars(player.getName());
    Player[] arrayOfPlayer;
    int j;
    int i;
    if (!invalidChars.isEmpty())
    {
      player.kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cSeu nick contem caracteres invalidos porfavor altere!");
      event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cSeu nick contem caracteres invalidos porfavor altere!");
      j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (i = 0; i < j; i++)
      {
        Player online = arrayOfPlayer[i];
        if (online.hasPermission("planeta.vip")) {
          online.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Aviso -> §7Jogador " + player.getName() + " tentou entrar com nick invalido.");
        }
      }
      return;
    }
    if (player.getName().isEmpty())
    {
      player.kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cSeu nick contem caracteres invalidos porfavor altere!");
      event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §cSeu nick contem caracteres invalidos porfavor altere!");
      j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (i = 0; i < j; i++)
      {
        Player online = arrayOfPlayer[i];
        if (online.hasPermission("hg.admin")) {
          online.sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §9Aviso -> §7Jogador " + player.getName() + " tentou entrar com nick invalido.");
        }
      }
      return;
    }
    File file = new File("plugins/CHBukkitHunger/UserData/" + player.getPlayer().getName() + ".yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (player.isOnline())
    {
      player.kickPlayer("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê ja esta Online");
      event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê ja esta Online");
    }
    if (file.exists())
    {
      if (event.getResult().equals(PlayerLoginEvent.Result.KICK_WHITELIST)) {
        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "§4Servidor esta em manutenção \n\n§7Jogador: " + player.getPlayer().getName() + " (" + player.getUniqueId() + ")\n VIP:" + cfg.getString("VIP").replace("&", "§") + "\n Server IP: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
      }
      if (event.getResult().equals(PlayerLoginEvent.Result.KICK_BANNED)) {
        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "Você esta banido\n\n§7Jogador: " + player.getPlayer().getName() + " (" + player.getUniqueId() + ")\n VIP:" + cfg.getString("VIP").replace("&", "§") + "\n Server IP: " + Config.getConfig(Config.ConfigFile.CONFIG).getString("ip"));
      }
    }
    else
    {
      if (event.getResult().equals(PlayerLoginEvent.Result.KICK_WHITELIST)) {
        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "§c§oServidor em manutenção");
      }
      if (event.getResult().equals(PlayerLoginEvent.Result.KICK_BANNED)) {
        event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "§c§oVocê esta banido");
      }
    }
  }
  
  @EventHandler
  public void joinEvents(PlayerJoinEvent event)
    throws IOException
  {
    final Player player = event.getPlayer();
    String nick = player.getName();
    if (this.pl.invencibilidade) {
      libsHg.setScoreBoard2(player);
      
    }
    if (libsHg.database) {
      if ((libsHg.login.contains(player)) && 
        (Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")))
      {
        File file = new File("plugins/CHBukkitHunger/UserData/" + nick + ".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
      }
    }
    if (Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
      libsHg.login.add(player);
    }
    Player target = Bukkit.getPlayerExact(player.getName());
    if ((player.hasPermission("hg.mod")) && (player.hasPermission("hg.admin")))
    {
      libsHg.stafflog(player.getName() + " entrou no servidor");
      DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
      Date date = new Date();
      player.sendMessage("§9§o[Staff-Log] Foi registrado o seu login exatamente as:§7§o " + dateFormat.format(date));
      libsHg.alertas.add(player);
    }
    if (this.pl.comecando) {
        libsHg.setScoreBoard(player);
    }
    if ((this.pl.comecando) || (this.pl.aguardando))
    {
      BossBar.setMessage(player, "§6Seja bem-vindo §a" + player.getName() + " §6 ao " + Config.getConfig(Config.ConfigFile.CONFIG).getString("Servidor") + "!", 5);
      player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
      player.getInventory().setArmorContents(null);
      player.setHealth(20);
      player.setFoodLevel(20);
      player.setExp(0.0F);
      player.giveExp(0);
      player.giveExpLevels(0);
      player.setLevel(0);
      player.setRemainingAir(20);
      player.setGameMode(GameMode.SURVIVAL);
      player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
      player.playSound(player.getLocation(), Sound.NOTE_BASS, 1.0F, 1.0F);
      ItemStack kits = new ItemStack(Material.CHEST);
      ItemMeta kitsm = kits.getItemMeta();
      kitsm.setDisplayName("§c§oKits");
      kits.setItemMeta(kitsm);
      List<String> pages = Config.getConfig(Config.ConfigFile.CONFIG).getStringList("texto-livro");
      List<String> content = new ArrayList();
      List<String> page = new ArrayList();
      String l;
      for (String line : pages)
      {
        line = line.replace("<servidor>", "§c§oPlanetaCraft");
        line = line.replace("<br>", ChatColor.RESET + "\n");
        line = ChatColor.translateAlternateColorCodes('&', line);
        if (!line.contains("<np>"))
        {
          page.add(line + "\n");
        }
        else
        {
          String pagestr = "";
          for (Iterator localIterator2 = page.iterator(); localIterator2.hasNext();)
          {
            line = (String)localIterator2.next();
            pagestr = pagestr + line;
          }
          content.add(pagestr);
          page.clear();
        }
      }
      String pagestr = "";
      for (String line : page) {
        pagestr = pagestr + line;
      }
      content.add(pagestr);
      page.clear();
      
      ItemStack item = new ItemStack(387, 1);
      
      BookMeta im = (BookMeta)item.getItemMeta();
      im.setPages(content);
      im.setAuthor(Config.getConfig(Config.ConfigFile.CONFIG).getString("autor-livro").replace("&", "§"));
      im.setTitle(Config.getConfig(Config.ConfigFile.CONFIG).getString("title-livro").replace("&", "§"));
      item.setItemMeta(im);
      
      ItemStack soupa = new ItemStack(Material.MUSHROOM_SOUP);
      ItemMeta soupams = kits.getItemMeta();
      soupams.setDisplayName("§a§oSopa");
      soupa.setItemMeta(soupams);
      
      ItemStack loja = new ItemStack(Material.EMERALD);
      ItemMeta lojams = kits.getItemMeta();
      lojams.setDisplayName("§6§oLoja");
      loja.setItemMeta(lojams);
      
      player.getInventory().setItem(0, kits);
      player.getInventory().setItem(7, soupa);
      player.getInventory().setItem(5, loja);
      player.getInventory().setItem(8, item);
      player.teleport(player.getWorld().getSpawnLocation());
      
      //TitleManager.sendTimings(player.getPlayer(), 20, 40, 20);

      //TitleManager.sendSubTitle(player.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"Servidor HardCore Games\",\"color\":\"blue\"}]}");

      //TitleManager.sendTitle(player.getPlayer(), "{\"text\":\"\",\"extra\":[{\"text\":\"PlanetaCraft Seja Bem-Vindo\",\"color\":\"yellow\"}]}");
  	  
  	  }

  			  if (this.pl.login.contains(player)) {
  				  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
  			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
  			      {
  					public void run()
  			        {
  					    final File file = new File("plugins/CHBukkitHunger/UserData/"+player.getPlayer().getName()+".yml");
  					    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  					    if (libsHg.login.contains(player)) {
  					    	player.kickPlayer("§c§oVocê não se logou");
  					    }
  					    }
  				  
  			        } , 600L);	
  				  }
  			  }
  			  
  			  if (this.pl.login.contains(player)) {
  				  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("login").equals("true")) {
  			      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.pl, new Runnable()
  			      {
  					public void run()
  			        {
  					    final File file = new File("plugins/CHBukkitHunger/UserData/"+player.getPlayer().getName()+".yml");
  					    final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  					    if (libsHg.login.contains(player)) {
  					        if(cfg.getString("MostrarCDS").equals("Sim")) {
  					        	  if(Config.getConfig(Config.ConfigFile.CONFIG).getString("MsgCDS").equals("true")) {
  					             player.sendMessage("§9Novo Jogadores> §7Sua senha é --> " + cfg.getString("ChaveDS") + " \nmude sua senha usando /MudarCDS <Sua Senha> <Nova senha>.");
  					             cfg.set("MostrarCDS", "Nao");
  					             Extras.this.pl.vivos.remove(player);
  					             return;
  					    }
  					        }
  					    }
  					    }
  				  
  			        } , 5L);	
  				  }
  			  }
  	          if (this.pl.database) {
  	              try
  	              {
  	                this.pl.mysql.updatIP(player);
  	              }
  	              catch (SQLException e1)
  	              {
  	                e1.printStackTrace();
  	              }
  	            }

  	          
   }
    


  @EventHandler
    public void onMapInitialize(MapInitializeEvent event) {
      MapView map = event.getMap();
      if (!this.pl.acabou) {
        return;
      }
      for (MapRenderer r : map.getRenderers()) {
        map.removeRenderer(r);
      }
      map.addRenderer(new MapRenderer()
      {
        @SuppressWarnings("deprecation")
  	public void render(MapView view, MapCanvas canvas, Player player)
        {
            canvas.drawText(40, 10, MinecraftFont.Font, "§" + MapPalette.RED + ";Parabens");
            canvas.drawText(30, 20, MinecraftFont.Font,  "");
            canvas.drawText(10, 30, MinecraftFont.Font, "§" + MapPalette.RED + ";Voce Ganhou a Partida");
            canvas.drawText(40, 40, MinecraftFont.Font, "§" + MapPalette.BLUE + ";" + player.getName());
            canvas.drawImage(14, 50, new ImageIcon(Extras.this.pl.getDataFolder().getPath() + "/Cake.png").getImage());
    	    if (player.hasPermission("planeta.staff"))
    	    {
    	   libsHg.stafflog(player.getName() + " abrio o mapa");
    	    }
          }
      });
    }
    
    @SuppressWarnings("deprecation")
  public void NoGamer() {
  	  for (Player player : Bukkit.getOnlinePlayers()) {
    if (player.hasPermission("hg.nogamer") && (!player.hasPermission("planeta.op")))
    {
  	 
      for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
        pl.hidePlayer(player);
      
      }    
      {
        this.vanished.add(player);
        this.pl.vivos.remove(player);
        this.pl.admins.add(player);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setGameMode(GameMode.CREATIVE);
        BossBar.setMessage(player, "§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §6§l§oVoce entrou no modo: Spectador", 4);
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(true);
        player.setFlying(true);
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
      }
    }
    
   }

    }
    
    @EventHandler
    public void joinEvents(PlayerQuitEvent event) { 
  	    Player player = event.getPlayer();
  	    if (player.hasPermission("planeta.staff"))
  	    {
  	   libsHg.stafflog(player.getName() + " saiu do servidor");
  	    }
    }
  
  @EventHandler
  public void Leave(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    File file = new File("plugins/CHBukkitHunger/UserData/" + player.getPlayer().getName() + ".yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    if (cfg.getString("banido").equals("true")) {
      event.setQuitMessage(null);
    }
  }
  
  public String emoticonizer(String message)
  {
    return message;
  }
  
  public boolean checaDV(String mensagem)
  {
    if (!Config.getConfig(Config.ConfigFile.CONFIG).getBoolean("AntiDV")) {
      return false;
    }
    if (Config.getConfig(Config.ConfigFile.CONFIG).getBoolean("IngorarEspacos")) {
      mensagem = mensagem.replace(" ", "");
    }
    for (String regex : Config.getConfig(Config.ConfigFile.CONFIG).getStringList("Avancado.ReGex"))
    {
      Pattern replace = Pattern.compile(regex);
      Matcher matcher = replace.matcher(mensagem);
      if (matcher.matches()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean temBlock(String msg)
  {
    for (String p : Config.getConfig(Config.ConfigFile.CONFIG).getStringList("Palavroes")) {
      if (msg.contains(p)) {
        return true;
      }
    }
    return false;
  }
  
  public String corrigir(String palavra)
  {
    boolean certo = false;
    for (String c : Config.getConfig(Config.ConfigFile.C).getStringList("Fix")) {
      try
      {
        String[] correcao = c.split("->");
        if (correcao.length > 1)
        {
          if (checa(correcao[0], palavra)) {
            return correcao[1];
          }
          if (checa(correcao[1], palavra)) {
            certo = true;
          }
        }
      }
      catch (Exception localException) {}
    }
    return palavra;
  }
  
  public ChatColor getCor(String cmd)
  {
    ChatColor rtn = ChatColor.WHITE;
    for (String c : Config.getConfig(Config.ConfigFile.C).getStringList("Cores")) {
      if (c.split(":")[0].equalsIgnoreCase(cmd))
      {
        String cor = c.split(":")[1];
        if (ChatColor.valueOf(cor) != null) {
          rtn = ChatColor.valueOf(cor);
        }
      }
    }
    return rtn;
  }
  
  public String marcar(String mensagem, Player p, String cmd)
  {
    String msgnova = "";
    String[] arrayOfString;
    int j = (arrayOfString = mensagem.split(" ")).length;
    for (int i = 0; i < j; i++)
    {
      String palavra = arrayOfString[i];
      if (palavra != null) {
        if (palavra.length() > 15)
        {
          String nome = palavra;
          if (Bukkit.getPlayer(nome) != null)
          {
            nome = Bukkit.getPlayer(nome).getName();
            p.sendMessage(mensagem);
            if (msgnova.equalsIgnoreCase("")) {
              msgnova = "§f" + nome + getCor(cmd);
            } else {
              msgnova = msgnova + " §f" + nome + getCor(cmd);
            }
          }
          else if (msgnova.equalsIgnoreCase(""))
          {
            msgnova = palavra;
          }
          else
          {
            msgnova = msgnova + " " + palavra;
          }
        }
        else if (msgnova.equalsIgnoreCase(""))
        {
          msgnova = palavra;
        }
        else
        {
          msgnova = msgnova + " " + palavra;
        }
      }
    }
    return msgnova;
  }
  
  @EventHandler
  public void onChatSv(AsyncPlayerChatEvent event)
  {
    String mensagem = event.getMessage();
    if (temBlock(mensagem))
    {
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não deve se redigir a esta palavra!");
      event.setCancelled(true);
    }
    String msgnova = "";
    String[] arrayOfString;
    int j = (arrayOfString = mensagem.split(" ")).length;
    for (int i = 0; i < j; i++)
    {
      String palavra = arrayOfString[i];
      if (msgnova.equalsIgnoreCase("")) {
        msgnova = corrigir(palavra);
      } else {
        msgnova = msgnova + " " + corrigir(palavra);
      }
    }
    if (checaDV(msgnova))
    {
      Player player = event.getPlayer();
      File file = new File("plugins/CHBukkitHunger/UserData/" + player.getName() + ".yml");
      YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	  if ((!player.hasPermission("hg.mod")) && (!player.hasPermission("hg.admin")))
	    {
      event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oNão escrava divulgações no chat do servidor.");
      event.setCancelled(true);
	    }
    }
    msgnova = marcar(msgnova, event.getPlayer(), "CHAT");
    
    msgnova = msgnova.toLowerCase();
    if (!msgnova.endsWith(".")) {
      msgnova = msgnova + ".";
    }
    msgnova = primeiraLetra(msgnova);
    
    msgnova = emoticonizer(msgnova);
    event.setMessage(msgnova);
  }
  
  public String primeiraLetra(String original)
  {
    if (original.length() == 0) {
      return original;
    }
    return original.substring(0, 1).toUpperCase() + original.substring(1);
  }
  
  @EventHandler
  public void onCmd(PlayerCommandPreprocessEvent event)
  {
    boolean tem = false;
    String cmdformato = "";
    for (String cmd : Config.getConfig(Config.ConfigFile.CONFIG).getStringList("LerComandos")) {
      if (cmd.split(" ")[0].equalsIgnoreCase(event.getMessage().split(" ")[0]))
      {
        tem = true;
        cmdformato = cmd;
      }
    }
    if (tem)
    {
      String[] msg = event.getMessage().split(" ");
      String[] cmd = cmdformato.split(" ");
      int i = cmd.length;
      if (msg.length <= cmd.length) {
        return;
      }
      String mensagem = "";
      while (i != msg.length)
      {
        if (mensagem.equalsIgnoreCase("")) {
          mensagem = msg[i];
        } else {
          mensagem = mensagem + " " + msg[i];
        }
        i++;
      }
      if (temBlock(mensagem))
      {
    	    Player player = event.getPlayer();
    	  if ((!player.hasPermission("planeta.staff")))
    	    {
        event.getPlayer().sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §c§oVocê não deve se redigir a esta palavra.");
        event.setCancelled(true);
    	    }
      }
      String base = "";
      i = 0;
      while (i != cmd.length)
      {
        if (base.equalsIgnoreCase("")) {
          base = event.getMessage().split(" ")[i];
        } else {
          base = base + " " + event.getMessage().split(" ")[i];
        }
        i++;
      }
      String msgnova = "";
      for (String palavra : mensagem.split(" ")) {
        if (msgnova.equalsIgnoreCase(""))
          msgnova = corrigir(palavra);
        else {
          msgnova = msgnova + " " + corrigir(palavra);
        }
      }
      if (checaDV(msgnova))
      {
  	    Player player = event.getPlayer();
  	  if ((!player.hasPermission("planeta.staff")))
  	    {
           event.getPlayer().sendMessage("§c§oNão escrava divulgações no chat do servidor.");
        event.setCancelled(true);
  	    }
      }
      msgnova = marcar(msgnova, event.getPlayer(), event.getMessage().split(" ")[0].toLowerCase());
      
      msgnova = msgnova.toLowerCase();
      if (!msgnova.endsWith(".")) {
        msgnova = msgnova + ".";
      }
      msgnova = primeiraLetra(msgnova);
      
      msgnova = emoticonizer(msgnova);
      event.setMessage(base + " " + msgnova);
    }
  }
  
  public static String removerAcentos(String str)
  {
    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
  }
  
  public boolean checa(String str1, String str2)
  {
    str1 = removerAcentos(str1);
    str2 = removerAcentos(str2);
    return str1.equalsIgnoreCase(str2);
  }
  
  public static String getInvalidChars(String s)
  {
    return VALID_CHARS_PATTERN.matcher(s).replaceAll("");
  }
}
