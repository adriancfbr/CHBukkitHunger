package spinghg.hungergames.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import spinghg.hungergames.libsHg;

public class AmountAPI implements Listener
{
	  private libsHg pl;

	  public AmountAPI(libsHg plugin)
	  {
	    this.setPl(plugin);
	  }

  public static int getAmount(Player p, Material m)
  {
    int amount = 0;
    for (ItemStack item : p.getInventory().getContents()) {
      if ((item == null) || (item.getType() != m) || 
        (item.getAmount() <= 0)) continue;
      amount += item.getAmount();
    }

    return amount;
  }

public libsHg getPl() {
	return pl;
}

public void setPl(libsHg pl) {
	this.pl = pl;
}
}