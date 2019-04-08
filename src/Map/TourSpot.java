package Map;

public class TourSpot extends Land { // 구매시 canBuy false 해야함
	private int price;
	private int xCenter, yCenter;

	public TourSpot(String name, int price, int x1, int y1, int x2, int y2, int xCenter, int yCenter) {
		super(name, price, x1, y1, x2, y2);
		setTourSpot(true);
		this.price = getPrice();
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		setValuePrice((int) (price * 1.5));
	}

	// 구매 비용
	public int buyPrice() {
		return price;
	}

	public int getxCenter() {
		return xCenter;
	}

	public int getyCenter() {
		return yCenter;
	}

	// 오버라이딩
	public int getPurchasePrice() {
		return price;
	}
	
	// 살 때 값
	public int buyingPrice() {
		return price;
	}

	// 되팔 때 값 구매 / 2
	public int sellingPrice() {
		return price / 2;
	}

	// 통행료 계산 구매 * 2
	public int passingPrice() {
		return price * 2;
	}
	
	public int getValuePrice() {
		return passingPrice();
	}
	
}