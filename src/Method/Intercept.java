package Method;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

import Game.Player;
import Graphics.AllStructurePanel;
import Graphics.GPlayer;
import Graphics.GPlayerPanel;
import Graphics.GameFrame;
import Graphics.StructurePanel;
import Map.City;
import Map.Land;
import Map.TourSpot;

public class Intercept extends JDialog {
	private Land land;
	private Player player;
	
	private JLabel beforeInterceptBalanceLabel;
	private JLabel interceptBalanceLabel;
	private JLabel afterInterceptBalanceLabel;
	private JButton interceptBtn;
	private JButton exitBtn;
	
	private Update update;
	
	private AllStructurePanel allStructurePanel = AllStructurePanel.getSingleStructurePanel();
	private HashMap<Land, StructurePanel> structureMap;
	private StructurePanel structurePanel;

	public Intercept(GPlayerPanel playerPanel, GPlayer gPlayer, Land getLand, JFrame frame) {
		land = (Land) getLand;
		player = gPlayer.getPlayer();
		
		setTitle(" 인 수 ");
		setSize(250, 300);
		setLocation(450, 320);
		setLayout(new GridLayout(6, 1));
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		structureMap = allStructurePanel.getStructureMap();
		
		beforeInterceptBalanceLabel = new JLabel("  인수 전 소유액 : " + player.getBalance());
		interceptBalanceLabel = new JLabel("  인수 금액  " + land.interceptPrice());
		afterInterceptBalanceLabel = new JLabel("  인수 후 소유액 : " + (player.getBalance() - land.interceptPrice()));
		interceptBtn = new JButton("  인수하기  ");
		exitBtn = new JButton("  종 료  ");
		
		add(beforeInterceptBalanceLabel);
		add(interceptBalanceLabel);
		add(afterInterceptBalanceLabel);
		add(new JLabel(""));
		add(interceptBtn);
		add(exitBtn);
		
		
		interceptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFrame gameFrame = (GameFrame)frame;
				for(GPlayerPanel playerPanel : gameFrame.getPlayers())	{
					if(land.getOwnerPlayerName() == playerPanel.getgPlayer().getName())	{
						Player player1 = playerPanel.getgPlayer().getPlayer();
						player1.setBalance(player1.getBalance() + land.interceptPrice());
						player1.sellingLand(land);
						playerPanel.getBalanceLabel().setText("  소   유   액    : " + Integer.toString(player1.getBalance()));
						System.out.println("메롱오옹로올오");
						playerPanel.getOwnBalanceLabel().setText("  총 소유자산 : " + Integer.toString(player1.getOwnTotalBalance()));
					}
				}
				
				player.setBalance(player.getBalance() - land.interceptPrice());
				land.setOwnerPlayerName(player.getName());
				player.addLand(land);
				if (player.getTurn() % 2 == 1) {
					City city = (City) land;
					boolean[] buyType = new boolean[4];
					buyType = city.getStructure();
					structurePanel = structureMap.get(city);
					if (buyType[0] == true) {
						structurePanel.getRedLandLabel().setVisible(false);
						structurePanel.getGreenLandLabel().setVisible(true);
					}
					if (buyType[1] == true) {
						structurePanel.getRedVillaLabel().setVisible(false);
						structurePanel.getGreenVillaLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}
					if (buyType[2] == true) {
						structurePanel.getRedBuildingLabel().setVisible(false);
						structurePanel.getGreenBuildingLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}
					if (buyType[3] == true) {
						structurePanel.getRedHotelLabel().setVisible(false);
						structurePanel.getGreenHotelLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}

				} else if (player.getTurn() % 2 == 0) {
					City city = (City) land;
					boolean[] buyType = new boolean[4];
					buyType = city.getStructure();
					structurePanel = structureMap.get(city);
					if (buyType[0] == true) {
						structurePanel.getGreenLandLabel().setVisible(false);
						structurePanel.getRedLandLabel().setVisible(true);
					}
					if (buyType[1] == true) {
						structurePanel.getGreenVillaLabel().setVisible(false);
						structurePanel.getRedVillaLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
					if (buyType[2] == true) {
						structurePanel.getGreenBuildingLabel().setVisible(false);
						structurePanel.getRedBuildingLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
					if (buyType[3] == true) {
						structurePanel.getGreenHotelLabel().setVisible(false);
						structurePanel.getRedHotelLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
				}
				// gf.getStructurepanel().refresh();
				// gf.getStructurepanel().setVisible(true);
				structurePanel.repaint();
				
				setVisible(false);
				
				playerPanel.getBalanceLabel().setText("  소   유   액    : " + Integer.toString(player.getBalance()));
				playerPanel.getOwnBalanceLabel().setText("  총 소유자산 : " + Integer.toString(player.getOwnTotalBalance()));
				update = new Update(playerPanel, gPlayer, getLand);
				update.setVisible(true);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

}
