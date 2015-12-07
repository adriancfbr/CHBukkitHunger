package spinghg.hungergames.listeners;

import org.bukkit.event.Listener;

import spinghg.hungergames.libsHg;

public class NameAPI implements Listener
{
	private libsHg pl;
	  
	  public NameAPI(libsHg plugin)
	  {
	    this.setPl(plugin);
	  }
  public static String getMod(String name)
  {
    if (name.length() == 16)
    {
      String shorts = name.substring(0, name.length() - 5);
      return shorts;
    }
    if (name.length() == 15)
    {
      String shorts = name.substring(0, name.length() - 4);
      return shorts;
    }
    if (name.length() == 14)
    {
      String shorts = name.substring(0, name.length() - 3);
      return shorts;
    }
    if (name.length() == 13)
    {
      String shorts = name.substring(0, name.length() - 2);
      return shorts;
    }
    return name;
  }
  
  public static String getShortStr(String name)
  {
    if (name.length() == 16)
    {
      String shorts = name.substring(0, name.length() - 5);
      return shorts;
    }
    if (name.length() == 15)
    {
      String shorts = name.substring(0, name.length() - 4);
      return shorts;
    }
    return name;
  }
public libsHg getPl() {
	return pl;
}
public void setPl(libsHg pl) {
	this.pl = pl;
}
}
