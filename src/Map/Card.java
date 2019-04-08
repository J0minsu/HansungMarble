package Map;

public abstract class Card {
	private String name;
	private boolean isChance;
	private int x1, y1, x2, y2;
		
	public void setName(String name)	{
		this.name = name;
	}
	
	public String getName()	{
		return this.name;
	}

	public boolean isChance() {
		return isChance;
	}

	public void setChance(boolean isChance) {
		this.isChance = isChance;
	}
	
	//1P
	public void setLocation1(int x, int y)	{
		this.x1 = x;
		this.y1 = y;
	}
	
	public int getX1()	{
		return x1;
	}
	
	public int getY1()	{
		return y1;
	}
	
	//2P
	public void setLocation2(int x, int y)	{
		this.x2 = x;
		this.y2 = y;
	}
	
	public int getX2()	{
		return x2;
	}
	
	public int getY2()	{
		return y2;
	}
	
}
