package Method;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;

import Game.Player;
import Graphics.AllStructurePanel;
import Graphics.GPlayer;
import Graphics.GPlayerPanel;
import Graphics.GameFrame;
import Graphics.StructurePanel;
import Map.City;
import Map.Ground;
import Map.Land;
import Map.TourSpot;

public class PurchaseDialog extends JDialog {
	/**
	 * 
	 */
	private AllStructurePanel allStructurePanel = AllStructurePanel.getSingleStructurePanel();
	private HashMap<Land, StructurePanel> structureMap = new HashMap<Land, StructurePanel>();
	private static final long serialVersionUID = 1L;
	private City city = null;
	private TourSpot tourSpot = null;
	private Player player;
	private JRadioButton landBtn = new JRadioButton("토 지", true);
	private JRadioButton villaBtn = new JRadioButton("빌 라", false);
	private JRadioButton buildingBtn = new JRadioButton("빌 딩", false);
	private JRadioButton hotelBtn = new JRadioButton("호 텔", false);
	private JButton purchaseBtn = new JButton(" 구 입 ");
	private JButton exitBtn = new JButton(" 구입하지 않기 ");
	private boolean[] buyType = { false, false, false, false };
	private JLabel landName = new JLabel();
	private JLabel priceLabel = new JLabel();
	private int totalPrice = 0;

	public PurchaseDialog(GPlayerPanel playerPanel, GPlayer gPlayer, Land land, JFrame frame) {
		super(frame, "구매");
		this.player = gPlayer.getPlayer();
		if (land instanceof City) {
			city = (City) land;
			setLayout(new GridLayout(8, 1));
		} else if (land instanceof TourSpot) {
			tourSpot = (TourSpot) land;
			setLayout(new GridLayout(5, 1));

		}

		GameFrame gf = (GameFrame) frame;
		structureMap = allStructurePanel.getStructureMap();

		setLocation(485, 370);
		setSize(200, 200);
		setResizable(false);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		add(landName);
		add(priceLabel);
		if (land instanceof City) {
			add(landBtn);
			add(villaBtn);
			add(buildingBtn);
			add(hotelBtn);
		} else if (land instanceof TourSpot)
			add(landBtn);

		add(purchaseBtn);
		add(exitBtn);

		if (city != null)
			totalPrice += city.getPrice();
		else if (tourSpot != null)
			totalPrice += tourSpot.getPrice();
		landName.setText("         땅 이름 " + land.getName());
		priceLabel.setText("         건물 가격 :" + totalPrice);

		landBtn.setEnabled(false);

		villaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (villaBtn.isSelected())
					totalPrice += city.getPrice() * 0.5;
				else
					totalPrice -= city.getPrice() * 0.5;
				landName.setText("         땅 이름 " + land.getName());
				priceLabel.setText("         건물 가격 :" + totalPrice);
			}
		});

		buildingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buildingBtn.isSelected())
					totalPrice += city.getPrice() * 1.1;
				else
					totalPrice -= city.getPrice() * 1.1;
				landName.setText("         땅 이름 " + land.getName());
				priceLabel.setText("         건물 가격 :" + totalPrice);
			}
		});

		hotelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hotelBtn.isSelected())
					totalPrice += city.getPrice() * 1.5;
				else
					totalPrice -= city.getPrice() * 1.5;
				landName.setText("         땅 이름 " + land.getName());
				priceLabel.setText("         건물 가격 :" + totalPrice);
			}
		});

		purchaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (true) {
					if (player.getBalance() >= totalPrice) {
						player.setBalance(player.getBalance() - totalPrice);
						if (city != null) {
							buyType[0] = landBtn.isSelected();
							buyType[1] = villaBtn.isSelected();
							buyType[2] = buildingBtn.isSelected();
							buyType[3] = hotelBtn.isSelected();

							City nowCity = Ground.getSingleGround().getIndexCity(player.getIndex());
							nowCity.setOwnerPlayerName(player.getName());
							nowCity.setStructure(buyType);
							Ground.getSingleGround().setIndexCity(player.getIndex(), nowCity);
						} else {
							TourSpot nowTourSpot = Ground.getSingleGround().getIndexTourSpot(player.getIndex());
							nowTourSpot.setOwnerPlayerName(player.getName());
							Ground.getSingleGround().setIndexTourSpot(player.getIndex(), nowTourSpot);
						}
						setVisible(false);

						player.addLand(land);
						playerPanel.getBalanceLabel()
								.setText("  소   유   액    : " + Integer.toString(player.getBalance()));
						playerPanel.getOwnBalanceLabel()
								.setText("  총 소유자산 : " + Integer.toString(player.getOwnTotalBalance()));
						break;
					} else {
						JOptionPane.showMessageDialog(null, "자금 부족");
						setVisible(false);
						break;

					}
				}
				if (land instanceof City && player.getTurn() % 2 == 1) {
					City city = (City) land;
					boolean[] buyType = new boolean[4];
					buyType = city.getStructure();
					if (buyType[0] == true) {
						gf.getStructurepanel().getGreenLandLabel().setVisible(true);
					}
					if (buyType[1] == true) {
						gf.getStructurepanel().getGreenVillaLabel().setVisible(true);
						gf.getStructurepanel().getGreenLandLabel().setVisible(false);
					}
					if (buyType[2] == true) {
						gf.getStructurepanel().getGreenBuildingLabel().setVisible(true);
						gf.getStructurepanel().getGreenLandLabel().setVisible(false);
					}
					if (buyType[3] == true) {
						gf.getStructurepanel().getGreenHotelLabel().setVisible(true);
						gf.getStructurepanel().getGreenLandLabel().setVisible(false);
					}

				} else if (land instanceof TourSpot && player.getTurn() % 2 == 1) {
					TourSpot tourSpot = (TourSpot) land;
					if (tourSpot.getOwnerPlayerName() == player.getName()) {
						gf.getStructurepanel().getGreenLandLabel().setVisible(true);
					}
				} else if (land instanceof City && player.getTurn() % 2 == 0) {
					City city = (City) land;
					boolean[] buyType = new boolean[4];
					buyType = city.getStructure();
					if (buyType[0] == true) {
						gf.getStructurepanel().getRedLandLabel().setVisible(true);
					}
					if (buyType[1] == true) {
						gf.getStructurepanel().getRedVillaLabel().setVisible(true);
						gf.getStructurepanel().getRedLandLabel().setVisible(false);
					}
					if (buyType[2] == true) {
						gf.getStructurepanel().getRedBuildingLabel().setVisible(true);
						gf.getStructurepanel().getRedLandLabel().setVisible(false);
					}
					if (buyType[3] == true) {
						gf.getStructurepanel().getRedHotelLabel().setVisible(true);
						gf.getStructurepanel().getRedLandLabel().setVisible(false);
					}

				} else if (land instanceof TourSpot && player.getTurn() % 2 == 0) {
					TourSpot tourSpot = (TourSpot) land;
					if (tourSpot.getOwnerPlayerName() == player.getName()) {
						gf.getStructurepanel().getRedLandLabel().setVisible(true);
					}
				}
				// gf.getStructurepanel().refresh();
				// gf.getStructurepanel().setVisible(true);
				gf.getStructurepanel().repaint();
			}
		});
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});

		setVisible(false);
	}
}
