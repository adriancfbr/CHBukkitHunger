package spinghg.hungergames.api.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import spinghg.hungergames.api.configs.Config;
import spinghg.hungergames.libsHg;

public class MySQLManager
{
  private libsHg main;
  private static MySQL db;
	
  public MySQLManager(libsHg plugin)
  {
    this.main = plugin;
  }
  
  public void setupRanking()
    throws SQLException
  {
    if (Config.getConfig(Config.ConfigFile.MYSQL).getBoolean("mysql.habilitado"))
    {
      MySQLManager.db = new MySQL(this.main, 
        Config.getConfig(Config.ConfigFile.MYSQL).getString("mysql.host-name"), 
        Config.getConfig(Config.ConfigFile.MYSQL).getString("mysql.porta"), 
        Config.getConfig(Config.ConfigFile.MYSQL).getString("mysql.database"), 
        Config.getConfig(Config.ConfigFile.MYSQL).getString("mysql.usuario"), 
        Config.getConfig(Config.ConfigFile.MYSQL).getString("mysql.senha"));
      MySQLManager.db.openConnection();
      Statement statement = MySQLManager.db.getConnection().createStatement();
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `HungerGames` (`nome` varchar(32), `matou` int, `morreu` int, `kdr` double, `vitorias` int, `planets` double, `ip` varchar(90))");
      libsHg.database = true;
    }
    else
    {
      libsHg.logger.log(Level.WARNING, "O MySQL nao esta habilitado. Para usa-lo coloque true no mysql.yml em mysql.habilitado!");
      libsHg.database = false;
    }
  }
  
  public void closeDB()
  {
	  MySQLManager.db.closeConnection();
  }
  
  public void firstJoinPlayer(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
    if (rs.next()) {
      return;
    }
    s.executeUpdate("INSERT INTO HungerGames (`nome`, `matou`, `morreu`, `kdr`, `vitorias`, `chave`, `planets`, `ip`) VALUES ('" + 
      name + "', '0', " + 
      "'0', '0', '0', '0', '000.000.00.0');");
    libsHg.logger.log(Level.INFO, "O Jogador " + name + " teve seus dados " + 
      "inseridos com sucesso " + 
      "na base de dados.");
  }
  
  public void C(Player p)
		    throws SQLException
		  {
		    String name = p.getName();
		    if (!MySQLManager.db.checkConnection()) {
		      MySQLManager.db.openConnection();
		    }
		    Statement s = MySQLManager.db.getConnection().createStatement();
		    
		    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
		    if (rs.next()) {
		      return;
		    }
		    s.executeUpdate("INSERT INTO HungerGames (`nome`, `matou`, `morreu`, `kdr`, `vitorias`, `chave`, `planets`, `ip`) VALUES ('" + 
		      name + "', '0', " + 
		      "'0', '0', '0', '0', '000.000.00.0');");
		    libsHg.logger.log(Level.INFO, "O Jogador " + name + " teve seus dados " + 
		      "inseridos com sucesso " + 
		      "na base de dados.");
		  }

	
  
  public void updateKills(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    int kills = getKills(p);
    if (kills != 0) {
      s.executeUpdate("UPDATE HungerGames SET `matou`='" + (kills + 1) + "' WHERE `nome`='" + name + "';");
    } else {
      s.executeUpdate("UPDATE HungerGames SET `matou`='1' WHERE `nome`='" + name + "';");
    }
    int Coins = getCoins(p);
    if (Coins != 0) {
      	if (p.hasPermission("planeta.vip") && (p.hasPermission("planeta.yt"))) {
    		s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins + 15) + "' WHERE `nome`='" + name + "';");
    	}
    	else
    	{
      s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins + 5) + "' WHERE `nome`='" + name + "';");}
    } else {
      s.executeUpdate("UPDATE HungerGames SET `planets`='5' WHERE `nome`='" + name + "';");
    }
    if ((getKills(p) != 0) && (getMortes(p) != 0)) {
      s.executeUpdate("UPDATE HungerGames SET `kdr`='" + getKills(p) / getMortes(p) + "' WHERE `nome`='" + name + "';");
    }
  }
  
  public void updatIP(Player p)
		    throws SQLException
		  {

		    String name = p.getName();
		    if (!MySQLManager.db.checkConnection()) {
		      MySQLManager.db.openConnection();
		    }
		     {
		    Statement s = MySQLManager.db.getConnection().createStatement();
		    s.executeUpdate("UPDATE HungerGames SET `ip`='"+p.getAddress().getHostString()+ "' WHERE `nome`='" + name + "';");
		    	 
		    }
		  }	
		
  public void updateCoinsKit(Player p)
		    throws SQLException
		  {
		    String name = p.getName();
		    if (!MySQLManager.db.checkConnection()) {
		      MySQLManager.db.openConnection();
		    }
		    Statement s = MySQLManager.db.getConnection().createStatement();
		    int Coins = getCoins(p);
		    if (Coins != 0) {
		    	if (p.hasPermission("planeta.vip") && (p.hasPermission("planeta.yt"))) {
		    		s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins - 25) + "' WHERE `nome`='" + name + "';");
		    	}
		    	else
		    	{
		      s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins - 25) + "' WHERE `nome`='" + name + "';");}
		    } else {
		      s.executeUpdate("UPDATE HungerGames SET `planets`='1' WHERE `nome`='" + name + "';");
		    }
		  }
  
  public void updateMortes(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    int mortes = getMortes(p);
    if (mortes != 0) {
      s.executeUpdate("UPDATE HungerGames SET `morreu`='" + (mortes + 1) + "' WHERE `nome`='" + name + "';");
    } else {
      s.executeUpdate("UPDATE HungerGames SET `morreu`='1' WHERE `nome`='" + name + "';");
    }
    if ((getKills(p) != 0) && (getMortes(p) != 0)) {
      s.executeUpdate("UPDATE HungerGames SET `kdr`='" + getKills(p) / getMortes(p) + "' WHERE `nome`='" + name + "';");
    }
  }
  
  public void updateVitorias(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    int vitorias = getVitorias(p);
    if (vitorias != 0) {
      s.executeUpdate("UPDATE HungerGames SET `vitorias`='" + (vitorias + 1) + "' WHERE `nome`='" + name + "';");
    } else {
      s.executeUpdate("UPDATE HungerGames SET `vitorias`='1' WHERE `nome`='" + name + "';");
    }
    int Coins = getCoins(p);
    if (Coins != 0) {
    	if (p.hasPermission("planeta.vip.mais") && (p.hasPermission("hg.youtuber"))) {
    		s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins + 25) + "' WHERE `nome`='" + name + "';");
    	}
    	else
    	{
      s.executeUpdate("UPDATE HungerGames SET `planets`='" + (Coins + 15) + "' WHERE `nome`='" + name + "';");}
    } else {
      s.executeUpdate("UPDATE HungerGames SET `planets`='15' WHERE `nome`='" + name + "';");
    }
  }
  
  public int getKills(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
    if (!rs.next()) {
      return 0;
    }
    int retorno = rs.getInt("matou");
    
    return retorno;
  }
  
  
  
  public int getMortes(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
    if (!rs.next()) {
      return 0;
    }
    int retorno = rs.getInt("morreu");
    
    return retorno;
  }
  
  public double getKdr(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
    if (!rs.next()) {
      return 0.0D;
    }
    double retorno = rs.getInt("kdr");
    
    return retorno;
  }
  
  public int getVitorias(Player p)
    throws SQLException
  {
    String name = p.getName();
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
    if (!rs.next()) {
      return 0;
    }
    int retorno = rs.getInt("vitorias");
    
    return retorno;
  }
  
  public static int getCoins(Player p)
		    throws SQLException
		  {
	      String name = p.getName();
		    if (!MySQLManager.db.checkConnection()) {
		    	MySQLManager.db.openConnection();
		    }
		    Statement s = MySQLManager.db.getConnection().createStatement();
		    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames WHERE `nome`='" + name + "';");
		    
		    if (!rs.next()) {
		      return 0;
		    }
		    int retorno = rs.getInt("planets");
		    
		    return retorno;
		  }
  
  public String[] getTop5()
    throws SQLException
  {
    if (!MySQLManager.db.checkConnection()) {
      MySQLManager.db.openConnection();
    }
    Statement s = MySQLManager.db.getConnection().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM HungerGames ORDER BY matou DESC LIMIT 5");
    while (rs.next())
    {
      rs.getString("nome");
      rs.getInt("matou");
      rs.getInt("morreu");
      rs.getDouble("kdr");
      rs.getInt("vitorias");
      rs.getInt("planets");
      rs.getInt("ip");
    }
    return null;
  }
}
