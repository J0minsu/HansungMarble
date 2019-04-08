package Map;

public class Land extends Card {

	private int price = 0;
	private int valuePrice = 0;
	private boolean isTourSpot; // 관광지 여부
	private boolean canBuy = true; // 땅 구매 가능여부
	private String ownerPlayerName = null; // 소유주 이름 없다면 null
	private boolean isExpo = false;

	public Land(String name, int price, int x1, int y1, int x2, int y2)	{
		setName(name);
		this.price = price;
		setChance(false);
		setLocation1(x1, y1);
		setLocation2(x2, y2);
	}
	//Getter & Setter
	public boolean isTourSpot() {
		return isTourSpot;
	}

	public void setTourSpot(boolean isTourSpot) {
		this.isTourSpot = isTourSpot;
	}
	public boolean isCanBuy() {
		return canBuy;
	}
	
	public void setCanBuy(boolean canBuy) {
		this.canBuy = canBuy;
	}
	public String getOwnerPlayerName() {
		return ownerPlayerName;
	}
	
	public void setOwnerPlayerName(String ownerPlayerName) {
		this.ownerPlayerName = ownerPlayerName;
		if(ownerPlayerName != null)
			setCanBuy(false);
		else
			setCanBuy(true);
	}
	
	public int getValuePrice()	{
		return valuePrice;
	}
	
	public void setValuePrice(int valuePrice)	{
		this.valuePrice = valuePrice;
	}
	
	//오버라이딩
	public int getPrchasePrice()	{
		return 0;
	}
	
	public int getPrice()	{
		return price;
	}
	
	// 인수 값 = 구매 * 1.3
	public int interceptPrice() {
		return 0;
	}

	// 살 때 값
	public int buyingPrice() {
		return 0;
	}

	// 되팔 때 값 구매 / 2
	public int sellingPrice() {
		return 0;
	}

	// 통행료 계산 구매 * 2
	public int passingPrice() {
		return 0;
	}
	public boolean isExpo() {
		return isExpo;
	}
	public void setExpo(boolean isExpo) {
		this.isExpo = isExpo;
	}
}
