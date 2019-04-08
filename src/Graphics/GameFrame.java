package Graphics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Game.DiceThread;
import Map.BonusSpot;
import Map.ChanceCard;
import Map.ExpoSpot;
import Map.Ground;
import Map.Land;
import Map.LuckySpot;
import Map.PrisonSpot;
import Map.SpecialSpot;
import Map.StartSpot;
import Map.TrailSpot;
import Method.GetChanceCard;
import Method.InBonusSpot;
import Method.InExpoSpot;
import Method.InLuckySpot;
import Method.InPrisonSpot;
import Method.InStartSpot;
import Method.InTrailSpot;
import Method.Paying;
import Method.PurchaseDialog;
import Method.Update;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BGPanel bgPanel;
	private GPlayer player1;
	private GPlayer player2;
	private String name;
	private Dice dice;
	private Ground ground = Ground.getSingleGround();
	private int rand1, rand2, randSum; // Dice 변수
	private int turn = 0;
	private JButton diceBtn;
	private boolean isID = true;
	// private Purchase purchase;
	private Container c;
	private GPlayerPanel player1Panel;
	private GPlayerPanel player2Panel;
	private PurchaseDialog purchaseDialog;
	private ArrayList<GPlayerPanel> players = new ArrayList<GPlayerPanel>();
	private AllStructurePanel allStructurePanel;
	private HashMap<Land, StructurePanel> structureMap;
	private StructurePanel structurepanel;
	private Paying payingDialog;
	private Update updateDialog;

	public GameFrame() throws InterruptedException {
		super("Battle Blue Marble!");
		// ID check
		while (isID) {
			name = JOptionPane.showInputDialog("ID를 입력해주세요.");
			if (name != null)
				break;
		}
		
		setSize(1150, 803);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		setLayout(null);
		
		this.allStructurePanel = AllStructurePanel.getSingleStructurePanel();
		structureMap = allStructurePanel.getStructureMap();
		bgPanel = BGPanel.getBGPanel();
		player1 = new GPlayer("assets/greenPlayer.png", name, 1);
		player1.setOpaque(false);

		player2 = new GPlayer("assets/redPlayer.png", "nhchoi", 2);
		player2.setOpaque(false);

		dice = new Dice();

		dice.returnPanel().setLocation(505, 270);
		dice.returnPanel().setSize(135, 240);
		dice.returnPanel().setVisible(true);
		dice.returnPanel().setOpaque(false);

		diceBtn = new JButton(" R O L L ");
		diceBtn.setSize(100, 20);
		diceBtn.setLocation(520, 520);
		diceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turn++;
				diceBtn.setEnabled(false);
				rand1 = (int) (Math.random() * 6 + 1);
				rand2 = (int) (Math.random() * 6 + 1);

				randSum = rand1 + rand2;
				new DiceThread(dice.getLabel1(), rand1, dice.getLoadingDice());
				new DiceThread(dice.getLabel2(), rand2, dice.getLoadingDice());
				dice.setLoadingDice(false);
				dice.setIsUpdated(true);

				run();
			}
		});
		diceBtn.setOpaque(false);

		player1Panel = new GPlayerPanel(player1);
		player1Panel.setLocation(getWidth() - player1Panel.getWidth(), getHeight() - player1Panel.getHeight());

		player2Panel = new GPlayerPanel(player2);
		player2Panel.setLocation(5, 5);

		players.add(player1Panel);
		players.add(player2Panel);

		/* 가위바위보롤 턴을 정하는 method, 임의로 선 1p set */
		// player1.getPlayer().setTurn(true);

		c.add(player1Panel);
		c.add(player2Panel);
		c.add(diceBtn);
		c.add(dice.returnPanel());
		c.add(player1);
		c.add(player2);
		c.add(allStructurePanel);
		c.add(bgPanel);
		
		

		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] a) throws InterruptedException {
		new GameFrame();
	}

	public void run() {
		// 발판 이동
		playerMove();
		GameFrame.this.repaint();

		if (turn % 2 == 1)
			eventInGround(player1Panel, player1);
		else
			eventInGround(player2Panel, player2);
		diceBtn.setEnabled(true);
	}

	private void eventInGround(GPlayerPanel playerPanel, GPlayer player) {
		//찬스카드
		if (ground.getGround()[player.getIndex()] instanceof ChanceCard)
			new GetChanceCard(player);
		//특수발판
		else if (ground.getGround()[player.getIndex()] instanceof SpecialSpot)
			inSpecialSpot(player);
		//땅
		else if (ground.getGround()[player.getIndex()] instanceof Land) {
			Land getLand = (Land) ground.getGround()[player.getIndex()];
			inLand(playerPanel, player, getLand);
		}
	}

	private void inLand(GPlayerPanel playerPanel, GPlayer player, Land land) {
		// 소유주가 없을때 v
		if (land.getOwnerPlayerName() == null) {
			purchaseDialog = new PurchaseDialog(playerPanel, player, land, this);
			purchaseDialog.setVisible(true);
			setStructurepanel(structureMap.get(land));
			allStructurePanel.refresh();
		}
		// 자신의 소유지일때 v
		else if (land.getOwnerPlayerName() == player.getName()) {
			if (!land.isTourSpot()) {
				updateDialog = new Update(playerPanel, player, land);
				updateDialog.setVisible(true);
			}
		}
		// 상대방의 소유지일때 v
		else {
			// 통행료 지불 method v
			if (player.getPlayer().hasAngelCard())	{
				;	
			}// 천사카드 쓰시겠습니까? 그렇다면 로직후 break 아니면 else
			else {
				if (player.getPlayer().getAllSellingBalance() + player.getPlayer().getBalance() < land.passingPrice())
					// 승패갈림
					System.out.println("패배!");
				else {
					payingDialog = new Paying(playerPanel, player, land, this);
					payingDialog.setVisible(true);
					
				}
			}

		}
	}

	private void inSpecialSpot(GPlayer player) {
		int playerIndex = player.getIndex();
		// 시작지점 e
		if (ground.getGround()[playerIndex] instanceof StartSpot)
			new InStartSpot(player);
		// 감옥
		else if (ground.getGround()[playerIndex] instanceof PrisonSpot)
			new InPrisonSpot(this, player);
		// 엑스포
		else if (ground.getGround()[playerIndex] instanceof ExpoSpot)
			new InExpoSpot(this, player);
		// 세계여행
		else if (ground.getGround()[playerIndex] instanceof TrailSpot)
			new InTrailSpot(this, player);
		// 복불복
		else if (ground.getGround()[playerIndex] instanceof LuckySpot)
			new InLuckySpot(this, player);
		// 보너스게임
		else if (ground.getGround()[playerIndex] instanceof BonusSpot)
			new InBonusSpot(this, player);
	}

	public void playerMove() {
		if (turn % 2 == 1) {
			int playerIndex = player1.getIndex();

			if (playerIndex + randSum > ground.getGround().length)
				new InStartSpot(player1);

			player1.setIndex((playerIndex + randSum) % ground.getGround().length);
			playerIndex = player1.getIndex();
			player1.setX(ground.getGround()[playerIndex].getX1() - 15);
			player1.setY(ground.getGround()[playerIndex].getY1() - 50);
			player1.repaint();
		} else {
			int playerIndex = player2.getIndex();

			if (playerIndex + randSum > ground.getGround().length)
				new InStartSpot(player2);

			player2.setIndex((playerIndex + randSum) % ground.getGround().length);
			// 인덱스 변경, 재정의
			playerIndex = player2.getIndex();
			player2.setX(ground.getGround()[playerIndex].getX2() - 15);
			player2.setY(ground.getGround()[playerIndex].getY2() - 50);
			player2.repaint();
		}
	}

	public ArrayList<GPlayerPanel> getPlayers() {
		return players;
	}

	public JButton getDiceBtn() {
		return diceBtn;
	}

	public void setDiceBtn(JButton diceBtn) {
		this.diceBtn = diceBtn;
	}

	public StructurePanel getStructurepanel() {
		return structurepanel;
	}

	public void setStructurepanel(StructurePanel structurepanel) {
		this.structurepanel = structurepanel;
	}
}