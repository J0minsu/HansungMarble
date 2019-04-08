package Map;

public class SpecialSpot extends Card {
	
	public SpecialSpot(int x1, int y1, int x2, int y2)	{
		setChance(false);

		setLocation1(x1, y1);
		setLocation2(x2, y2);
	}
}