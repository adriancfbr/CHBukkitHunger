package spinghg.hungergames.habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Camel
 implements Listener, CommandExecutor
{
  private libsHg pl;
  
  public Camel(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageCamel(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Camel"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Camel (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Camel", 1);
      }
    }
    }
  }
  
  public Camel(Player p)
  {
	  if (this.pl.kit) {
    ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    recipe.addIngredient(Material.CACTUS);
    recipe.addIngredient(Material.SAND);
    
    Bukkit.addRecipe(recipe);
    

    ShapelessRecipe recipes = new ShapelessRecipe(new ItemStack(Material.MUSHROOM_SOUP));
    recipes.addIngredient(Material.CACTUS);
    recipes.addIngredient(Material.BOWL);
    Bukkit.addRecipe(recipe);
  }
  }
  
  @EventHandler
  public void onPlayerCamel(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (this.pl.kit) 
    if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)) && 
      (this.pl.km.temKit(p)) && (this.pl.km.getPlayerKit(p, this.pl.km.getKitByName("Camel"))))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
      return;
    }
  }
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Camel")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Camel");
	    }

	    return false;
	  }
}
