package Method;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Game.Player;
import Graphics.AllStructurePanel;
import Graphics.GPlayer;
import Graphics.GPlayerPanel;
import Graphics.GameFrame;
import Graphics.StructurePanel;
import Map.City;
import Map.Land;
import Map.TourSpot;

public class Update extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private City city;
	private int cityPrice = 0;
	private boolean[] beforeStructure = new boolean[4];
	private AllStructurePanel allStructurePanel = AllStructurePanel.getSingleStructurePanel();
	private HashMap<Land, StructurePanel> structureMap;
	private StructurePanel structurePanel;
	private int constructMoney = 0;
	private JLabel ownMoney;
	private JLabel constructMoneyLabel;
	private JLabel logicAfterMoney;
	private JRadioButton villaBtn;
	private JRadioButton buildingBtn;
	private JRadioButton hotelBtn;
	private JButton updateBtn;
	private JButton exitBtn;

	public Update(GPlayerPanel playerPanel, GPlayer gPlayer, Land land) {
		setTitle(" 건 설 ");
		setSize(250, 300);
		setLocation(300, 300);
		setLayout(new GridLayout(8, 1));
		
		structureMap = allStructurePanel.getStructureMap();

		player = gPlayer.getPlayer();
		if (land instanceof City)
			this.city = (City) land;
		cityPrice = city.getPrice();
		beforeStructure = city.getStructure();

		ownMoney = new JLabel("  소유금액 : " + player.getBalance());
		constructMoneyLabel = new JLabel("  건설 비용  : 0");
		logicAfterMoney = new JLabel("  건설 후 금액  : " + (player.getBalance() - constructMoney));
		villaBtn = new JRadioButton("  별 장  ");
		buildingBtn = new JRadioButton("  빌 딩  ");
		hotelBtn = new JRadioButton("  호 텔  ");
		updateBtn = new JButton("  건 설  ");
		exitBtn = new JButton("  취 소  ");

		if (beforeStructure[1])
			villaBtn.setVisible(false);
		else
			villaBtn.setVisible(true);

		if (beforeStructure[2])
			buildingBtn.setVisible(false);
		else
			buildingBtn.setVisible(true);

		if (beforeStructure[3])
			hotelBtn.setVisible(false);
		else
			hotelBtn.setVisible(true);

		villaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (villaBtn.isSelected()) {
					constructMoney += (cityPrice * 0.5);
					beforeStructure[1] = !beforeStructure[1];
				} else {
					constructMoney -= (cityPrice * 0.5);
					beforeStructure[1] = !beforeStructure[1];
				}
				logicAfterMoney.setText("건설 후 금액  : " + (player.getBalance() - constructMoney));
				constructMoneyLabel.setText("  건설 비용  : " + constructMoney);
			}
		});

		buildingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buildingBtn.isSelected()) {
					constructMoney += (cityPrice * 1.1);
					beforeStructure[2] = !beforeStructure[2];
				} else {
					constructMoney -= (cityPrice * 1.1);
					beforeStructure[2] = !beforeStructure[2];
				}
				logicAfterMoney.setText("건설 후 금액  : " + (player.getBalance() - constructMoney));
				constructMoneyLabel.setText("  건설 비용  : " + constructMoney);
			}
		});

		hotelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hotelBtn.isSelected()) {
					constructMoney += (cityPrice * 1.5);
					beforeStructure[3] = !beforeStructure[3];
				} else {
					constructMoney -= (cityPrice * 1.5);
					beforeStructure[3] = !beforeStructure[3];
				}
				logicAfterMoney.setText("건설 후 금액  : " + (player.getBalance() - constructMoney));
				constructMoneyLabel.setText("  건설 비용  : " + constructMoney);
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(land.getName());
				city.setStructure(beforeStructure);
				player.setBalance(player.getBalance() - constructMoney);
				playerPanel.getBalanceLabel().setText("  소   유   액    : " + Integer.toString(player.getBalance()));
				playerPanel.getOwnBalanceLabel().setText("  총 소유자산 : " + Integer.toString(player.getOwnTotalBalance()));
				setVisible(false);
				if (player.getTurn() % 2 == 1) {
					boolean[] afterStructure = new boolean[4];
					afterStructure = city.getStructure();
					structurePanel = structureMap.get(city);
					if (afterStructure[0] == true) {
						structurePanel.getGreenLandLabel().setVisible(true);
					}
					if (afterStructure[1] == true) {
						structurePanel.getGreenVillaLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}
					if (afterStructure[2] == true) {
						structurePanel.getGreenBuildingLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}
					if (afterStructure[3] == true) {
						structurePanel.getGreenHotelLabel().setVisible(true);
						structurePanel.getGreenLandLabel().setVisible(false);
					}

				}else if (player.getTurn() % 2 == 0) {
					boolean[] afterStructure = new boolean[4];
					afterStructure = city.getStructure();
					structurePanel = structureMap.get(city);
					if (afterStructure[0] == true) {
						structurePanel.getRedLandLabel().setVisible(true);
					}
					if (afterStructure[1] == true) {
						structurePanel.getRedVillaLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
					if (afterStructure[2] == true) {
						structurePanel.getRedBuildingLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
					if (afterStructure[3] == true) {
						structurePanel.getRedHotelLabel().setVisible(true);
						structurePanel.getRedLandLabel().setVisible(false);
					}
				}
				// gf.getStructurepanel().refresh();
				// gf.getStructurepanel().setVisible(true);
				structurePanel.repaint();
			}
		});

		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		add(ownMoney);
		add(constructMoneyLabel);
		add(logicAfterMoney);
		add(villaBtn);
		add(buildingBtn);
		add(hotelBtn);
		add(updateBtn);
		add(exitBtn);
	}

}
