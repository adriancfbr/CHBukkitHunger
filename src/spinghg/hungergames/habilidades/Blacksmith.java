package spinghg.hungergames.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Blacksmith
implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Blacksmith(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  public List<Player> espada = new ArrayList();
  public List<Player> capacete = new ArrayList();
  public List<Player> peitoral = new ArrayList();
  public List<Player> calca = new ArrayList();
  public List<Player> bota = new ArrayList();
  public List<Player> block = new ArrayList();

  @EventHandler
  public void onDamageBerserker(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("blacksmith"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Blacksmith (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Blacksmith", 1);
      }
      }
    }
  }

  @EventHandler
  public void onBlackSmith(PlayerInteractEvent e) {
	    Player mage = e.getPlayer();
	    if ((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith")))) {
	    if (!this.espada.contains(mage))
	    {
    	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
    	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_SWORD)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	    	      (mage.getItemInHand().getType() == Material.IRON_SWORD))) {  
        this.espada.add(mage);
        mage.sendMessage("§aVocê liberou uma conquista do BlackSmith.");
        mage.sendMessage("§aTer uma §6Espada de Iron.");
        mage.sendMessage("§aVocê ganhou §61 IRON ORE e EXP.");
        mage.giveExp(9);
        mage.getInventory().addItem(new ItemStack(Material.IRON_ORE));
      }
     }
 
	 if (!this.capacete.contains(mage)) {
    	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
    	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_HELMET)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	    	      (mage.getItemInHand().getType() == Material.IRON_HELMET))) {  
        this.capacete.add(mage);
        mage.sendMessage("§aVocê liberou uma conquista do BlackSmith.");
        mage.sendMessage("§aTer um §6Capacete de ferro.");
        mage.sendMessage("§aVocê ganhou §61 IRON ORE e EXP.");
        mage.giveExp(9);;
        mage.getInventory().addItem(new ItemStack(Material.IRON_ORE ,2));
      }
     }
	 if (!this.peitoral.contains(mage))
{
    	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
    	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_CHESTPLATE)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	    	      (mage.getItemInHand().getType() == Material.IRON_CHESTPLATE))) {  
        this.peitoral.add(mage);
        mage.sendMessage("§aVocê liberou uma conquista do BlackSmith.");
        mage.sendMessage("§aTer um §6Peitoral de ferro.");
        mage.sendMessage("§aVocê ganhou §61 IRON ORE e EXP.");
        mage.giveExp(9);
        mage.getInventory().addItem(new ItemStack(Material.IRON_ORE ,2));
      }
     }
	 if (!this.calca.contains(mage))
	   {
    	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
    	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_LEGGINGS)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	    	      (mage.getItemInHand().getType() == Material.IRON_LEGGINGS))) {  
        this.calca.add(mage);
        mage.sendMessage("§aVocê liberou uma conquista do BlackSmith.");
        mage.sendMessage("§aTer uma §6Calça de ferro.");
        mage.sendMessage("§aVocê ganhou §61 IRON ORE e EXP.");
        mage.giveExp(9);
        mage.getInventory().addItem(new ItemStack(Material.IRON_ORE ,2));
      }
     }
	 if (!this.bota.contains(mage)) {
    	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
    	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_BOOTS)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
    	    	      (mage.getItemInHand().getType() == Material.IRON_BOOTS))) {  
        this.bota.add(mage);
        mage.sendMessage("§aVocê liberou uma conquista do BlackSmith.");
        mage.sendMessage("§aTer uma §6Bota de ferro");
        mage.sendMessage("§aVocê ganhou §61 IRON ORE e EXP.");
        mage.giveExp(9);
        mage.getInventory().addItem(new ItemStack(Material.IRON_ORE ,2));
      }
     }
	 if (!this.block.contains(mage)) {
 	    if (((this.pl.km.temKit(mage)) && (this.pl.km.getPlayerKit(mage, this.pl.km.getKitByName("blacksmith"))) && 
 	    	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && (mage.getItemInHand().getType() == Material.IRON_BLOCK)) || ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
 	    	      (mage.getItemInHand().getType() == Material.IRON_BLOCK))) {  
     this.block.add(mage);
     mage.sendMessage("§aVocê liberou uma conquista do BlackSmith (Secreta).");
     mage.sendMessage("§aTer um §6Block de ferro");
     mage.sendMessage("§aVocê ganhou §61 Enchantment Table.");
     mage.giveExp(9);
     mage.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
   }
  }
	    }
    }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Blacksmith")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Blacksmith");
	    }

	    return false;
	  }
  }

