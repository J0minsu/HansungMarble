package Method;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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

public class Paying extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private JLabel landName;
	private JLabel passingPrice;
	private static JLabel nowBalance;
	private static JLabel afterPayingBalace;
	private JButton payingBtn = new JButton(" 지  불 ");
	private JButton sellingBtn = new JButton(" 땅 팔 기 ");
	private JButton loseBtn = new JButton(" 파 산 ");
	
	
	
	private SellingDialog sellingDialog;
	private Intercept interceptDialog;

	public Paying(GPlayerPanel playerPanel, GPlayer gPlayer, Land land, JFrame frame) {
		super(frame, "지불");
		player = gPlayer.getPlayer();
		setSize(270, 270);
		setLocation(450, 320);
		setLayout(new GridLayout(7, 1));
		setUndecorated(true);
		
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		landName = new JLabel("땅 이름 : " + land.getName());
		passingPrice = new JLabel("지불액 : " + land.passingPrice());
		// line
		nowBalance = new JLabel("소유 금액 : " + player.getBalance());
		if (player.getBalance() < land.passingPrice())
			afterPayingBalace = new JLabel("소유금액 초과 땅을 파십시오.");
		else
			afterPayingBalace = new JLabel(
					"지불 후 소유금액 : " + Integer.toString(player.getBalance() - land.passingPrice()));

		payingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player.getBalance() > land.passingPrice()) {
					player.setBalance(player.getBalance() - land.passingPrice());

					GameFrame gameFrame = (GameFrame) frame;
					ArrayList<GPlayerPanel> players = gameFrame.getPlayers();

					for (int i = 0; i < players.size(); i++) {
						GPlayerPanel ownerPanel = players.get(i);
						GPlayer getGPlayer = players.get(i).getgPlayer();

						// 땅 소유주쪽 패널 변경
						if (getGPlayer.getName() == land.getOwnerPlayerName()) {
							Player ownerPlayer = getGPlayer.getPlayer();
							ownerPlayer.setBalance(ownerPlayer.getBalance() + land.passingPrice());
							ownerPanel.getBalanceLabel()
									.setText("  소   유   액    : " + Integer.toString(ownerPlayer.getBalance()));
						}
						// 통행료 지불자쪽 패널 변경
						if (getGPlayer.getName() == player.getName()) {
							ownerPanel.getBalanceLabel()
									.setText("  소   유   액    : " + Integer.toString(player.getBalance()));
							ownerPanel.getOwnBalanceLabel()
									.setText("  총 소유자산 : " + Integer.toString(player.getOwnTotalBalance()));

						}
					}
				}
				setVisible(false);
				// 인수 method
				if (player.getBalance() > land.interceptPrice())
					if (land instanceof City) {
						interceptDialog = new Intercept(playerPanel, gPlayer, land, frame);
						interceptDialog.setVisible(true);
					}
			}
		});

		sellingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sellingDialog = new SellingDialog(this, player, land.passingPrice(), frame);
				sellingDialog.setVisible(true);
			}
		});

		loseBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// 구현해야한다
				System.out.println(player.getName() + "의 패배!");
				setVisible(false);
			}
		});

		add(landName);
		add(passingPrice);
		add(nowBalance);
		add(afterPayingBalace);
		add(payingBtn);
		add(sellingBtn);
		add(loseBtn);
		System.out.println("지불");
	}

	public static JLabel getNowBalance() {
		return nowBalance;
	}

	public static JLabel getAfterPayingBalace() {
		return afterPayingBalace;
	}

}

class SellingDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel sellingAfterBalance;
	private int totalMoney = 0;
	private ArrayList<Land> selectedLands = new ArrayList<Land>();
	private AllStructurePanel allStructurePanel = AllStructurePanel.getSingleStructurePanel();
	private HashMap<Land, StructurePanel> structureMap;
	private StructurePanel structurePanel;

	public SellingDialog(ActionListener actionListener, Player player, int passingPrice, JFrame frame) {
		super();
		setSize(250, 300);
		setLocation(300, 300);
		setLayout(new GridLayout(player.getOwnLandList().size() * 2 + 3, 1));
		setBackground(Color.CYAN);

		structureMap = allStructurePanel.getStructureMap();
		
		sellingAfterBalance = new JLabel("판매 후 소유금액 : " + player.getBalance());
		add(sellingAfterBalance);
		add(new JLabel("─────────────"));
		for (Land land : player.getOwnLandList()) {
			JRadioButton landCheck = new JRadioButton(land.getName());
			add(landCheck);
			add(new JLabel("판매 가격 : " + Integer.toString(land.sellingPrice())));
			landCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (landCheck.isSelected()) {
						totalMoney += land.sellingPrice();
						selectedLands.add(land);
					} else {
						totalMoney -= land.sellingPrice();
						selectedLands.remove(land);
					}
					sellingAfterBalance.setText("판매 후 소유금액 : " + (totalMoney + player.getBalance()));
				}
			});
		}

		JButton sellingBtn = new JButton(" 판 매 ");
		sellingBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				player.setBalance(player.getBalance() + totalMoney);
				for (Land land : selectedLands) {
					player.sellingLand(land);
				}
				Paying.getAfterPayingBalace()
						.setText("지불 후 소유금액 : " + Integer.toString(player.getBalance() - passingPrice));
				Paying.getNowBalance().setText("소유 금액 : " + Integer.toString(player.getBalance()));
				for(Land land : selectedLands) {
					if (land instanceof City && player.getTurn() % 2 == 1) {
						City city = (City) land;
						structurePanel = structureMap.get(city);
						if(city.getOwnerPlayerName() == null) {
							structurePanel.getGreenLandLabel().setVisible(false);
							structurePanel.getGreenVillaLabel().setVisible(false);
							structurePanel.getGreenBuildingLabel().setVisible(false);
							structurePanel.getGreenHotelLabel().setVisible(false);
						}
					} else if (land instanceof TourSpot && player.getTurn() % 2 == 1) {
						TourSpot tourSpot = (TourSpot) land;
						structurePanel = structureMap.get(tourSpot);
						if (tourSpot.getOwnerPlayerName() == null) {
							structurePanel.getGreenLandLabel().setVisible(false);
						}
					}else if (land instanceof City && player.getTurn() % 2 == 0) {
						City city = (City) land;
						structurePanel = structureMap.get(city);
						if(city.getOwnerPlayerName() == null) {
							structurePanel.getRedLandLabel().setVisible(false);
							structurePanel.getRedVillaLabel().setVisible(false);
							structurePanel.getRedBuildingLabel().setVisible(false);
							structurePanel.getRedHotelLabel().setVisible(false);
						}
					} else if (land instanceof TourSpot && player.getTurn() % 2 == 0) {
						TourSpot tourSpot = (TourSpot) land;
						structurePanel = structureMap.get(tourSpot);
						if (tourSpot.getOwnerPlayerName() == null) {
							structurePanel.getRedLandLabel().setVisible(false);
						}
					}
					// gf.getStructurepanel().refresh();
					// gf.getStructurepanel().setVisible(true);
					structurePanel.repaint();
				}
				setVisible(false);
			}
		});
		add(sellingBtn);
	}
}
