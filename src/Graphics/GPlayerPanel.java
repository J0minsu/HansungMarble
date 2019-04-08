package Graphics;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Player;

//위치는 GameFrame에서
public class GPlayerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GPlayer gPlayer;
	private Player player;
	private ImageIcon playerIcon;
	private JLabel playerImageLabel;
	private JLabel balanceLabel;
	private JLabel ownBalanceLabel;
	private JLabel nameLabel;
	private JLabel angelCard;
	private JLabel escapeCard;

	public GPlayerPanel(GPlayer gPlayer) {
		setSize(350, 150);
		setLayout(null);
		setBackground(Color.CYAN);

		this.gPlayer = gPlayer;
		this.player = gPlayer.getPlayer();
		playerIcon = new ImageIcon(gPlayer.getIconPath());
		playerImageLabel = new JLabel(playerIcon);
		playerImageLabel.setSize(playerIcon.getIconWidth(), playerIcon.getIconHeight());
		playerImageLabel.setLocation(60, 25);

		balanceLabel = new JLabel();
		balanceLabel.setText("  소   유   액    : " + Integer.toString(player.getBalance()));
		balanceLabel.setSize(150, 20);
		balanceLabel.setLocation(150, 10);
		balanceLabel.setBackground(Color.CYAN);
		balanceLabel.setOpaque(true);

		ownBalanceLabel = new JLabel();
		ownBalanceLabel.setText("  총 소유자산 : " + Integer.toString(player.getOwnTotalBalance()));
		ownBalanceLabel.setSize(150, 20);
		ownBalanceLabel.setLocation(150, 30);
		ownBalanceLabel.setBackground(Color.CYAN);
		ownBalanceLabel.setOpaque(true);

		nameLabel = new JLabel(player.getName());
		nameLabel.setSize(70, 20);
		nameLabel.setLocation(40, 77);
		nameLabel.setBackground(Color.CYAN);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setOpaque(true);

		angelCard = new JLabel();
			if(player.hasAngelCard())
				angelCard.setText("  천사카드 : 소유");
			else
				angelCard.setText("  천사카드 : 미소유");
		angelCard.setSize(150, 20);
		angelCard.setLocation(150, 50);
		angelCard.setBackground(Color.CYAN);
		angelCard.setOpaque(true);

		escapeCard = new JLabel();
			if(player.hasEscapePrison())
				escapeCard.setText("  무인도 탈출카드 : 소유");
			else
				escapeCard.setText("  무인도 탈출카드 : 미소유");	
		escapeCard.setSize(150, 20);
		escapeCard.setLocation(150, 70);
		escapeCard.setBackground(Color.CYAN);
		escapeCard.setOpaque(true);

		if (player.getTurn() == 2) {
			angelCard.setVisible(false);
			escapeCard.setVisible(false);
		}

		add(angelCard);
		add(escapeCard);
		add(nameLabel);
		add(ownBalanceLabel);
		add(balanceLabel);
		add(playerImageLabel);

		setOpaque(false);
		setVisible(true);
	}

	public void setBalanceLabel(JLabel balanceLabel) {
		this.balanceLabel = balanceLabel;
	}

	public void setOwnBalanceLabel(JLabel ownBalanceLabel) {
		this.ownBalanceLabel = ownBalanceLabel;
	}

	public void setAngelCard(JLabel angelCard) {
		this.angelCard = angelCard;
	}

	public JLabel getBalanceLabel() {
		return balanceLabel;
	}

	public JLabel getOwnBalanceLabel() {
		return ownBalanceLabel;
	}

	public JLabel getAngelCard() {
		return angelCard;
	}

	public GPlayer getgPlayer() {
		return gPlayer;
	}
	
	
}