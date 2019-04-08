package Graphics;

import java.awt.*;
import javax.swing.*;


public class Dice {
	private JPanel m_wrapper;
	protected JPanel dicePanel1;
	protected JPanel dicePanel2;
	protected ImageIcon diceIcon1;
	protected ImageIcon diceIcon2;
	private JLabel diceLabel1;
	private JLabel diceLabel2;
	private final int HEIGHT = 115;
	private final int WIDTH = 115;

	public boolean loadingDice = false;
	boolean m_bdouble;
	boolean m_bupdated;

	public Dice() throws InterruptedException {
		m_bdouble = false;
		m_wrapper = new JPanel();
		m_wrapper.setPreferredSize(new Dimension(WIDTH, (int) (HEIGHT * 1.5)));

		dicePanel1 = new JPanel();
		dicePanel2 = new JPanel();
		m_wrapper.add(dicePanel1, BorderLayout.NORTH);
		m_wrapper.add(dicePanel2, BorderLayout.SOUTH);
		m_wrapper.setBackground(Color.black);

		diceIcon1 = new ImageIcon("assets/diceSprite.png");
		diceIcon2 = new ImageIcon("assets/diceSprite.png");

		dicePanel1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		dicePanel2.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		diceLabel1 = new JLabel(new ImageIcon(diceIcon1.getImage()));
		diceLabel1.setHorizontalAlignment(JLabel.CENTER);
		diceLabel1.setVerticalAlignment(JLabel.CENTER);
		
		diceLabel2 = new JLabel(new ImageIcon(diceIcon2.getImage()));
		diceLabel2.setHorizontalAlignment(JLabel.CENTER);
		diceLabel2.setVerticalAlignment(JLabel.CENTER);

		m_wrapper.setLayout(new BorderLayout());
		m_wrapper.add(diceLabel1, BorderLayout.NORTH);
		m_wrapper.add(diceLabel2, BorderLayout.CENTER);
	}

	// 주사위 패널을 리턴하는 함수
	public JPanel returnPanel() {
		return m_wrapper;
	}

	public boolean isUpdated() {
		return m_bupdated;
	}

	public void setIsUpdated(boolean b) {
		m_bupdated = b;
	}

	public boolean isDouble() {
		return m_bdouble;
	}

	public JLabel getLabel1() {
		return diceLabel1;
	}

	public JLabel getLabel2() {
		return diceLabel2;
	}

	public boolean getLoadingDice() {
		return loadingDice;
	}

	public void setLoadingDice(boolean b) {
		loadingDice = b;
	}
}
