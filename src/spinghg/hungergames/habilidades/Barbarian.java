package spinghg.hungergames.habilidades;

import java.util.HashMap;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.PacketPlayOutSetSlot;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.listeners.AmountAPI;
import spinghg.hungergames.listeners.BossBar;
import spinghg.hungergames.libsHg;

public class Barbarian
 implements Listener, CommandExecutor
{
  private libsHg pl;
  String swordname = "Barbarian Sword ";
  private HashMap<String, Integer> kills = new HashMap();
  private Material[] updates = { Material.STONE_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD };
  
  public Barbarian(libsHg plugin)
  {
    this.pl = plugin;
  }
  
  @EventHandler
  public void onDamageBarbarian(EntityDamageByEntityEvent e)
  {
	  if (this.pl.comecou)
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      Entity ent = e.getEntity();
      Player player = (Player)e.getEntity();
      Player damager = (Player)e.getDamager();
      Player p = (Player)ent;
      if ((this.pl.km.temKit(player)) && (this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Barbarian"))) && 
        (damager.getItemInHand() != null) && 
        (damager.getItemInHand().getType() != null)) {
      	  if (damager.hasPermission("planeta.vip") && (damager.hasPermission("hg.youtuber")))
    	  {
    		  BossBar.setMessage(damager, p.getName() + " - Barbarian (§bSopas " + AmountAPI.getAmount(p, Material.MUSHROOM_SOUP) + " §f)" , 1);
    	  }
    	  else
    	  {
        BossBar.setMessage(damager, p.getName() + " - Barbarian", 1);
    	  }
      }
    }
  }
  
  @EventHandler
  public void onKilled(EntityDeathEvent event)
  {
	 if (this.pl.kit) 
    if (((event.getEntity().getKiller() instanceof Player)) && ((event.getEntity() instanceof Player))) {
      for (ItemStack item : event.getEntity().getKiller().getInventory().getContents())
      {
        Player barbarian = event.getEntity().getKiller();
        if ((!this.pl.km.temKit(barbarian)) || (!this.pl.km.getPlayerKit(barbarian, this.pl.km.getKitByName("Barbarian")))) {
          return;
        }
        if (item == null) {
          return;
        }
        if ((item.hasItemMeta()) && (item.getItemMeta().getDisplayName().contains("Barbarian")))
        {
          if (!this.kills.containsKey(barbarian.getName())) {
            this.kills.put(barbarian.getName(), Integer.valueOf(0));
          }
          this.kills.put(barbarian.getName(), Integer.valueOf(((Integer)this.kills.get(barbarian.getName())).intValue() + 1));
          if (this.kills.containsValue(Integer.valueOf(3)))
          {
            item.setType(this.updates[0]);
            barbarian.sendMessage("§aEvolução!");
            barbarian.sendMessage("§aSua espada é agora uma de pedra!");
            barbarian.sendMessage("§aProxima evolução-> 6 kills");
          }
          if (this.kills.containsValue(Integer.valueOf(6)))
          {
            item.setType(this.updates[1]);
            barbarian.sendMessage("§aEvolução!");
            barbarian.sendMessage("§aSua espada é agora uma de ferro!");
            barbarian.sendMessage("§aProxima evoluçao -> 9 kills");
          }
          if (this.kills.containsValue(Integer.valueOf(9)))
          {
            item.setType(this.updates[2]);
            barbarian.sendMessage("aEvolução!");
            barbarian.sendMessage("§aSua espada é agora uma de §bdiamante !");
            barbarian.sendMessage("§aSua espada está no nivel maximo!");
            barbarian.sendMessage("§aBoa!");
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent e)
  {
    Player player = e.getPlayer();
    if (this.pl.kit) 
    if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Barbarian")))) {
      return;
    }
    ItemStack item = e.getItemDrop().getItemStack();
    if ((item.hasItemMeta()) && (item.getItemMeta().getDisplayName().contains("Barbarian"))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onDamageSetDurability(EntityDamageByEntityEvent e)
  {
	  if (this.pl.kit) 
    if ((e.getDamager() instanceof Player))
    {
      Player player = (Player)e.getDamager();
      if ((!this.pl.km.temKit(player)) || (!this.pl.km.getPlayerKit(player, this.pl.km.getKitByName("Barbarian")))) {
        return;
      }
      ItemStack hand = player.getItemInHand();
      if ((hand.hasItemMeta()) && (hand.getItemMeta().getDisplayName().contains("Barbarian")))
      {
        short s = (short)(hand.getType().getMaxDurability() - hand.getType().getMaxDurability() / 3);
        hand.setDurability(s);
        EntityPlayer eP = ((CraftPlayer)player).getHandle();
        eP.playerConnection.sendPacket(new PacketPlayOutSetSlot(eP.activeContainer.windowId, 44 - Math.abs(player.getInventory().getHeldItemSlot() - 8), CraftItemStack.asNMSCopy(hand)));
      }
    }
  }
  
  public boolean onCommand(CommandSender p, Command c, String label, String[] args)
  {
	    if (c.getName().equalsIgnoreCase("Barbarian")) {
	      Player p1 = (Player)p;
	      p1.chat("/kit Barbarian");
	    }

	    return false;
	  }
}
