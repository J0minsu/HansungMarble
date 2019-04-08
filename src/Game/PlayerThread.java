package Game;

import Graphics.GPlayer;
import Map.Card;
import Map.Ground;

public class PlayerThread extends Thread {
	private GPlayer player;
	private int getDiceNo;
	private final int DELAY = 100;
	private Ground ground = Ground.getSingleGround();
	private Card[] groundCard = ground.getGround();
	private static PlayerThread playerThread = new PlayerThread(null, 0);
	private boolean isFinished = true;

	private PlayerThread(GPlayer player, int getDiceNo) {
		this.player = player;
		this.getDiceNo = getDiceNo;
		run();
	}

	public void run() {
		for (int i = 0; i < getDiceNo; i++) {
			try {
				sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((player.getIndex() + 1) == 32) {
				player.setIndex(0);
				player.addGoalCount();
				player.setX(groundCard[0].getX1());
				player.setY(groundCard[0].getY1());
				player.setLocation(player.getX() - 15, player.getY() - 25);
			} else	{
				player.setIndex(player.getIndex() + 1);
				player.setX(groundCard[player.getIndex()].getX1());
				player.setY(groundCard[player.getIndex()].getY1());
				player.setLocation(player.getX() - 15, player.getY() - 25);
			}
		}
		
		isFinished = false;
	}
	
	public static PlayerThread getPlayerThread()	{
		return playerThread;
	}
	
	public void setGPlayer(GPlayer player)	{
		this.player = player;
	}
	
	public void setgetDiceNo(int getDiceNo)	{
		this.getDiceNo = getDiceNo;
	}
	
	public boolean getIsFinished()	{
		return this.isFinished;
	}
}
