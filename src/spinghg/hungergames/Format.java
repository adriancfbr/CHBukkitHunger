package spinghg.hungergames;

public class Format
{
  public static String tempoInt(int tempo)
  {
    int ss = tempo % 60;
    tempo /= 60;
    int min = tempo % 60;
    tempo /= 60;
    int hh = tempo % 24;
    tempo /= 24;
    if ((ss > 0) && (min == 0) && (hh == 0)) {
      return "0:" + strzero(ss);
    }
    if (hh > 0) {
      return  strzero(min) + ":" + strzero(ss);
    }
    return  strzero(min) + ":" + strzero(ss);
  }
  
  private static String strzero(int n)
  {
    if (n < 10) {
      return "0" + String.valueOf(n);
    }
    return String.valueOf(n);
  }
}
