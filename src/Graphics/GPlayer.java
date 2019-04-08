package Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.Player;
import Game.Player1P;
import Game.Player2P;

public class GPlayer extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private ImageIcon playerIcon; // new ImageIcon("assets/redPlayer.png");
	private String filePath;

	public GPlayer(String filePath, String name, int turn) {
		this.filePath = filePath;
		
		playerIcon = new ImageIcon(filePath);
		if (turn == 1)
			player = new Player1P(name);
		else if (turn == 2)
			player = new Player2P(name);
		
		player.setTurn(turn);
		setIcon(playerIcon);
		setX(player.getX());
		setY(player.getY());
		setBounds(player.getX(), player.getY(), playerIcon.getIconWidth(), playerIcon.getIconHeight());
		
		if (turn == 1)   {
	         player = new Player1P(name);
	         player.setTurn(turn);
	    }
	      else if (turn == 2)   {
	         player = new Player2P(name);
	         player.setTurn(turn);
	    }
	}

	public int getX() {
		return player.getX();
	}

	public void setX(int x) {
		player.setX(x);
	}

	public int getY() {
		return player.getY();
	}

	public void setY(int y) {
		player.setY(y);
	}

	public int getIndex() {
		return player.getIndex();
	}

	public void setIndex(int index) {
		player.setIndex(index);
	}

	public int getGoalCount() {
		return player.getGoalCount();
	}

	public void addGoalCount() {
		player.setGoalCount(player.getGoalCount() + 1);
	}
	
	public String getName()	{
		return player.getName();
	}
	
	public String getIconPath()	{
		return filePath;
	}
	
	public Player getPlayer()	{
		return player;
	}

	public int getTurn() {
		return player.getTurn();
	}	
	
	
}
