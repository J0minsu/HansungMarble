package Map;

public class City extends Land {
	private boolean[] structure = new boolean[4]; // 0 = 토지, 1 = 별장, 2 = 빌딩, 3 = 호텔
	private int price;
	private int xLeft, yLeft, xCenter, yCenter, xRight, yRight;

	public City(String name, int price, int x1, int y1, int x2, int y2, int xLeft, int yLeft, int xCenter, int yCenter,
			int xRight, int yRight) {
		super(name, price, x1, y1, x2, y2);
		this.xLeft = xLeft;
		this.yLeft = yLeft;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.xRight = xRight;
		this.yRight = yRight;
		this.price = getPrice();
		setTourSpot(false);
		
		for(int i = 0; i < structure.length; i++)	{
			structure[i] = false;
		}
	}

	// Getter & Setter
	public boolean[] getStructure() {
		return structure;
	}

	public void setStructure(boolean[] structure) {
		this.structure = structure;
	}

	// 인수 값 = 구매 * 1.3
	public int interceptPrice() {
		int sum = 0;
		if (structure[0] == true) // 토지
			sum += price * 0.2 * 1.3;
		if (structure[1] == true) // 별장
			sum += price * 0.5 * 2 * 1.3;
		if (structure[2] == true) // 빌딩
			sum += price * 1.1 * 2 * 1.3;
		if (structure[3] == true) // 호텔
			sum += price * 1.5 * 2 * 1.3;

		return sum;
	}

	// 살 때 값
	public int buyingPrice() {
		int sum = 0;
		if (structure[0] == true) // 토지
			sum += price * 0.2;
		if (structure[1] == true) // 별장
			sum += price * 0.5;
		if (structure[2] == true) // 빌딩
			sum += price * 1.1;
		if (structure[3] == true) // 호텔
			sum += price * 1.5;

		return sum;
	}

	// 되팔 때 값 구매 / 2
	public int sellingPrice() {
		int sum = 0;
		if (structure[0] == true) // 토지
			sum += price * 0.2 * 0.5;
		if (structure[1] == true) // 별장
			sum += price * 0.5 * 0.5;
		if (structure[2] == true) // 빌딩
			sum += price * 1.1 * 0.5;
		if (structure[3] == true) // 호텔
			sum += price * 1.5 * 0.5;

		return sum;
	}

	// 통행료 계산 구매 * 2
	public int passingPrice() {
		int sum = 0;
		if (structure[0] == true) // 토지
			sum += price * 0.2;
		if (structure[1] == true) // 별장
			sum += price * 0.5 * 2;
		if (structure[2] == true) // 빌딩
			sum += price * 1.1 * 2;
		if (structure[3] == true) // 호텔
			sum += price * 1.5 * 2;

		return sum;
	}

	public int getxLeft() {
		return xLeft;
	}

	public int getyLeft() {
		return yLeft;
	}

	public int getxCenter() {
		return xCenter;
	}

	public int getyCenter() {
		return yCenter;
	}

	public int getxRight() {
		return xRight;
	}

	public int getyRight() {
		return yRight;
	}

	public int getValuePrice() {
		return passingPrice();
	}

	// 오버라이딩
	public int getPurchasePrice() {
		return buyingPrice();
	}
}