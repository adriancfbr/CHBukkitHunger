package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class Abilities
{
  public static ArrayList<String> usedKit = new ArrayList();
  public static ArrayList<String> kitpvp = new ArrayList();
  public static ArrayList<String> kitcheckpoint = new ArrayList();
  public static ArrayList<String> kitkangaroo = new ArrayList();
  public static ArrayList<String> kithulk = new ArrayList();
  public static ArrayList<String> kitgladiator = new ArrayList();
  public static ArrayList<String> kitmonk = new ArrayList();
  public static ArrayList<String> kitvacuum = new ArrayList();
  public static ArrayList<String> kittimelord = new ArrayList();
  public static ArrayList<String> kitgrappler = new ArrayList();
  public static ArrayList<String> kitviper = new ArrayList();
  public static ArrayList<String> kitsnail = new ArrayList();
  public static ArrayList<String> kitanchor = new ArrayList();
  public static ArrayList<String> cooldown = new ArrayList();
  public static ArrayList<String> cooldown1 = new ArrayList();
  
  public static void removeKit(Player player)
  {
    usedKit.remove(player.getName());
    cooldown.remove(player.getName());
    cooldown1.remove(player.getName());
    kitpvp.remove(player.getName());
    kitcheckpoint.remove(player.getName());
    kithulk.remove(player.getName());
    kitkangaroo.remove(player.getName());
    kitgladiator.remove(player.getName());
    kitvacuum.remove(player.getName());
    kittimelord.remove(player.getName());
    kitgrappler.remove(player.getName());
    kitviper.remove(player.getName());
    kitsnail.remove(player.getName());
    kitanchor.remove(player.getName());
  }
}
