package Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BGPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon bgIcon = new ImageIcon("assets/background.jpeg");
	private JLabel bgLabel;
	private static BGPanel bgPanel = new BGPanel();
	
	private BGPanel()	{
		setSize(1150, 803);
		setLayout(null);
		
		bgLabel = new JLabel(bgIcon);
		bgLabel.setLocation(0, 0);
		bgLabel.setSize(bgIcon.getIconWidth(), bgIcon.getIconHeight());
		add(bgLabel);

		
		setVisible(true);
	}
	
	public static BGPanel getBGPanel()	{
		return bgPanel;
	}
	
}
