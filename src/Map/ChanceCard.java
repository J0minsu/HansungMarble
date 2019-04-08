package Map;

public class ChanceCard extends Card {
	private Chance[] chances = { Chance.AngelCard, Chance.PassLand, Chance.Prison, Chance.TrailTour, Chance.OpenExpo,
			Chance.GoExpo, Chance.Start, Chance.BonusGame };

	public ChanceCard(String name, int x1, int y1, int x2, int y2) {
		setName(name);
		setChance(true);
		setLocation1(x1, y1);
		setLocation2(x2, y2);
	}

	// 찬스카드 랜덤하게 리턴
	public String getChance() {
		int n = (int) (Math.random() * chances.length);
		return chances[n].toString();
	}
}
