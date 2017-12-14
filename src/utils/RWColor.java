package utils;

public class RWColor {
	
	public String White = "[#FFFFFF]";
	public String Red= "[#FF0000]";
	public String Green = "[#00FF00]";
	public String Blue= "[#0000FF]";
	
	public RWColor()
	{
		
	}
	
	public String getColor(String color)
	{
		if (color.equalsIgnoreCase("red"))
			return (this.Red);
		if (color.equalsIgnoreCase("green"))
			return (this.Green);
		if (color.equalsIgnoreCase("blue"))
			return (this.Blue);
		return (this.White);
	}
}
