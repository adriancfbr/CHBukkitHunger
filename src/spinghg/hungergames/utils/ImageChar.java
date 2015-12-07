package spinghg.hungergames.utils;

public enum ImageChar
{
  BLOCK('-'),  DARK_SHADE('-'),  MEDIUM_SHADE('-'),  LIGHT_SHADE('-');
  
  private char c;
  
  private ImageChar(char c)
  {
    this.c = c;
  }
  
  public char getChar()
  {
    return this.c;
  }
}
