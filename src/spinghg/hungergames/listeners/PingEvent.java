package spinghg.hungergames.listeners;

import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import spinghg.hungergames.libsHg;

public class PingEvent
  implements Listener
{
  private libsHg pl;
  public boolean comecando = false;
  public boolean acabou = false;
  public boolean comecou = false;
  public boolean invencibilidade = false;
  public boolean feast = false;
  
  public PingEvent(libsHg plugin)
  {
    this.pl = plugin;
  }

  @EventHandler
  public void onPingServList(ServerListPingEvent e)
  {
        if (this.pl.aguardando)
    {
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §6§oAguardando os jogadores \n§a§o Entre em nosso site: (Em breve)");

      e.setMotd("§a[Entrar]");
    }
    if (this.pl.comecando)
    {
      int millis = this.pl.startingCounter * 1000;
      SimpleDateFormat df = new SimpleDateFormat("m:ss");
      String time = df.format(Integer.valueOf(millis));
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §6§oPartida inicia em: " + time + "\n§a§oEntre em nosso site: (Em breve)");
      e.setMotd("§a[Entrar]");
    }
    if ((this.pl.invencibilidade) && (Join.getOnlinePlayers() == 0))
    {
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §c§oServidor vai reiniciar \n§a§o Entre em nosso site: (Em breve)");
      Bukkit.getServer().shutdown();
      
      e.setMotd("§c[Reiniciando]");
      }
   
    if ((this.pl.comecou) && (Join.getOnlinePlayers() == 0))
    {
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §c§oServidor vai reiniciar \n§a§o Entre em nosso site: (Em breve)");
      Bukkit.getServer().shutdown();
      e.setMotd("§c[Reiniciando]");
    }
    if (this.pl.invencibilidade)
    {
      int millis = this.pl.invicCounter * 1000;
      SimpleDateFormat df = new SimpleDateFormat("m:ss");
      String time = df.format(Integer.valueOf(millis));
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §6§oInvencibilidade acaba em: " + time + "\n§a§o Entre em nosso site: (Em breve)");
      e.setMaxPlayers(Integer.valueOf(this.pl.vivos.size()));
      e.setMotd("§5[Em Jogo]");
     
    }
    if (this.pl.comecou)
    {
      int millis = this.pl.partidaCounter * 1000;
      SimpleDateFormat df = new SimpleDateFormat("m:ss");
      String time = df.format(Integer.valueOf(millis));
     // e.setMotd("§a§l §b§o§lCooler - HG §a§l « §c§oJogo em progresso: " + time + "\n§a§o Entre em nosso site: (Em breve)");
      e.setMaxPlayers(Integer.valueOf(this.pl.vivos.size()));
      e.setMotd("§5[Em Jogo]");
    }
    if (this.pl.acabou)
    {
     // e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §c§oServidor vai reiniciar \n§a§o Entre em nosso site: (Em breve)");
      e.setMaxPlayers(Integer.valueOf(this.pl.vivos.size()));
      e.setMotd("§c[Reiniciando]");
    }
    if ((this.pl.acabou) && (Join.getOnlinePlayers() == 0))
    {
  //    e.setMotd("§a§l» §b§o§lCooler - HG §a§l « §c§oServidor vai reiniciar \n§a§o Entre em nosso site: (Em breve)");
      Bukkit.getServer().shutdown();
      e.setMotd("§c[Reiniciando]");
      
      }
  }

   
}
