package spinghg.hungergames.Coins;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.mysql.MySQLManager;

public class kExtrasListener
  implements Listener
{
	  private libsHg pl;

	  public kExtrasListener(libsHg plugin)
	  {
	    this.pl = plugin;
	  }

	
  @SuppressWarnings({ "deprecation", "static-access" })
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§3§lLoja - Extras")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
        if (e.getCurrentItem().getType() == Material.THIN_GLASS)
        {
          e.setCancelled(true);
          return;
        }
        if (e.getCurrentItem().getType() == Material.CAKE)
        {
          e.setCancelled(true);
  	    int Coins = 0;
  	    
			try {
				Coins = MySQLManager.getCoins(p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (Coins >= 25) {
				try {
					this.pl.mysql.updateCoinsKit(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!this.pl.ELoc.contains(p)) {
				p.sendMessage("§3[Coins] §6Você comprou o Spawn no lugar.");
                Bukkit.broadcastMessage("§9Shop> §7Jogador " + p.getName() + " se equipou bravamente com o Spawn no lugar.");
				p.closeInventory();
				this.pl.ELoc.add(p);
				}
				else
				{
					p.sendMessage("§c§oVocê já comprou.");
				}
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.STICK)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			if (Coins >= 25) {
				try {
					this.pl.mysql.updateCoinsKit(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (this.pl.EStick.contains(p))
				{
					p.sendMessage("§c§oVocê já comprou.");
				}
				else
				{
				p.sendMessage("§3[Coins] §6Você comprou o Stick.");
				this.pl.EStick.add(p);
				p.closeInventory();
				}
			}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.BOWL)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (Coins >= 25) {
					try {
						this.pl.mysql.updateCoinsKit(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (this.pl.EBown.contains(p))
					{
						p.sendMessage("§c§oVocê já comprou.");
					}
					else
					{
					p.sendMessage("§3[Coins] §6Você comprou o Bowl.");
					this.pl.EBown.add(p);
					p.closeInventory();
					}
				}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.STONE_PICKAXE)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (Coins >= 25) {
					try {
						this.pl.mysql.updateCoinsKit(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (this.pl.EStone.contains(p))
					{
						p.sendMessage("§c§oVocê já comprou.");
					}
					else
					{
					p.sendMessage("§3[Coins] §6Você comprou o Stone Pickaxe.");
					this.pl.EStone.add(p);
					p.closeInventory();
					}
				}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.WOOD)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (Coins >= 25) {
					try {
						this.pl.mysql.updateCoinsKit(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (this.pl.EWood.contains(p))
					{
						p.sendMessage("§c§oVocê já comprou.");
					}
					else
					{
					p.sendMessage("§3[Coins] §6Você comprou o Wood.");
					this.pl.EWood.add(p);
					p.closeInventory();
					}
				}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (Coins >= 25) {
					try {
						this.pl.mysql.updateCoinsKit(p);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (this.pl.ESoup.contains(p))
					{
						p.sendMessage("§c§oVocê já comprou.");
					}
					else
					{
					p.sendMessage("§3[Coins] §6Você comprou o Soup.");
					this.pl.ESoup.add(p);
					p.closeInventory();
					}
				}
			
			else
			{
				p.sendMessage("§9Error> §7não foi possivel comprar este item.");
			}
			
      
          return;
        }
    }
  }
}

