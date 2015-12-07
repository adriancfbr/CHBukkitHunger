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

public class LojaKitsListener
  implements Listener
{
	  private libsHg pl;

	  public LojaKitsListener(libsHg plugin)
	  {
	    this.pl = plugin;
	  }

	
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§3§lLoja - Kits")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
        if (e.getCurrentItem().getType() == Material.THIN_GLASS)
        {
          e.setCancelled(true);
          return;
        }
        if (e.getCurrentItem().getType() == Material.PORTAL)
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
				p.sendMessage("§3[Coins] §6Você  comprou o kit endermage.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Endermage");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.endermage");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
				p.chat("/endermage");
				p.closeInventory();
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7Não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK)
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
				p.sendMessage("§3[Coins] §6Você  comprou o kit Redstoner.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Redstoner");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
				p.chat("/Redstoner");
				p.closeInventory();
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7Não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.IRON_BOOTS)
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
				p.sendMessage("§3[Coins] §6Você  comprou o kit Stomper.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Stomper");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
				p.chat("/Stomper");
				p.closeInventory();
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7Não foi possivel comprar este item.");
			}
			
      
          return;
        }
        if (e.getCurrentItem().getType() == Material.STONE_SWORD)
        {
          e.setCancelled(true);
  	    int Coins = 0;			
				try {
					Coins = MySQLManager.getCoins(p);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			if (Coins == 25) {
				try {
					this.pl.mysql.updateCoinsKit(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p.sendMessage("§3[Coins] §6Você  comprou o kit Boxer.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Boxer");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
				p.chat("/Boxer");
				p.closeInventory();
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7Não foi possivel comprar este item.");
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
				p.sendMessage("§3[Coins] §6Você  comprou o kit Miner.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Miner");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex reload");
				p.chat("/Miner");
				p.closeInventory();
			    
			}
			
			else
			{
				p.sendMessage("§9Error> §7Não foi possivel comprar este item.");
			}
			
      
          return;
        }
    }
  }
}

