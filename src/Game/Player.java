package Game;

import Map. *;
import java.util.ArrayList;

public class Player {
	private  String name = "";	//이름
	private ArrayList<Land> ownCity = new ArrayList<Land>();	//가지고 있는 땅
	private int balance = 5000000;	//초기비용
	private boolean hasEscapePrison = false;	//무인도 탈출권
	private boolean hasAngelCard = false;	//천사카드 유무
	private int x = 0, y = 0;
	private int index = 0;	//현재 위치
	private int goalCount = 0;	//시작지점 방문 수
	private int hasTourSpot = 0;	//관광지 소유 개수
	private int turn = 0;
	
	protected Player(String name)	{
		this.name = name;
	}

	public String getName()	{
		return name;
	}
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getGoalCount() {
		return goalCount;
	}

	public void setGoalCount(int goalCount) {
		this.goalCount = goalCount;
	}
	
	public ArrayList<Land> getOwnLandList()	{
		return ownCity;
	}
	
	public int getOwnTotalBalance()	{
		int totalBalance = 0;
		
		for(Land land: ownCity)
			totalBalance += land.getValuePrice();
		
		return totalBalance; 
	}
	
	public int getAllSellingBalance()	{
		int totalBalance = 0;
		
		for(Land land: ownCity)
			totalBalance += land.sellingPrice();
		
		return totalBalance; 
	}
	


	public boolean hasEscapePrison() {
		return hasEscapePrison;
	}

	public void usingEscapePrison() {
		hasEscapePrison = !hasEscapePrison;
	}

	public boolean hasAngelCard() {
		return hasAngelCard;
	}

	public void usingAngelCard() {
		hasAngelCard = !hasAngelCard;
	}

	public int getTurn()	{
		return this.turn;
	}
	
	public void setTurn(int turn)	{
		this.turn = turn;
	}
	
	public void addLand(Land land)	{
		ownCity.add(land);
		land.setOwnerPlayerName(name);
	}
	
	public void sellingLand(Land land) {
		ownCity.remove(land);
		land.setOwnerPlayerName(null);
	}

	public int getHasTourSpot() {
		return hasTourSpot;
	}

	public void setHasTourSpot(int hasTourSpot) {
		this.hasTourSpot = hasTourSpot;
	}
	
	public ArrayList<Land> getLands()	{
		return ownCity;
	}

}