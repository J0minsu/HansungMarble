package Graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Map.Land;

public class StructurePanel extends JPanel{
	private ImageIcon greenLand = new ImageIcon("assets/GreenLand.png");
	private ImageIcon greenVilla = new ImageIcon("assets/GreenVilla.png");
	private ImageIcon greenHotel = new ImageIcon("assets/GreenHotel.png");
	private ImageIcon greenBuilding = new ImageIcon("assets/GreenBuilding.png");
	private ImageIcon redLand = new ImageIcon("assets/RedLand.png");
	private ImageIcon redVilla = new ImageIcon("assets/RedVilla.png");
	private ImageIcon redHotel = new ImageIcon("assets/RedHotel.png");
	private ImageIcon redBuilding = new ImageIcon("assets/RedBuilding.png");
	private JLabel greenLandLabel;
	private JLabel greenVillaLabel;
	private JLabel greenHotelLabel;
	private JLabel greenBuildingLabel;
	private JLabel redLandLabel;
	private JLabel redVillaLabel;
	private JLabel redHotelLabel;
	private JLabel redBuildingLabel;

	public StructurePanel() {
		setLayout(null);
		setSize(1150,803);
		setOpaque(false);
		/*this.greenLand = new ImageIcon("/assets/GreenLand.png");
		this.greenVilla = new ImageIcon("/assets/GreenVilla.png");
		this.greenHotel = new ImageIcon("/assets/GreenHotel.png");
		this.greenBuilding = new ImageIcon("/assets/GreenBuilding.png");
		this.redLand = new ImageIcon("/assets/RedLand.png");
		this.redVilla = new ImageIcon("/assets/RedVilla.png");
		this.redHotel = new ImageIcon("/assets/RedHotel.png");
		this.redBuilding = new ImageIcon("/assets/RedBuilding.png");*/
		this.greenLandLabel = new JLabel();
		greenLandLabel.setIcon(greenLand);
		this.greenVillaLabel = new JLabel();
		greenVillaLabel.setIcon(greenVilla);
		this.greenHotelLabel = new JLabel();
		greenHotelLabel.setIcon(greenHotel);
		this.greenBuildingLabel = new JLabel();
		greenBuildingLabel.setIcon(greenBuilding);
		this.redLandLabel = new JLabel();
		redLandLabel.setIcon(redLand);
		this.redVillaLabel = new JLabel();
		redVillaLabel.setIcon(redVilla);
		this.redHotelLabel = new JLabel();
		redHotelLabel.setIcon(redHotel);
		this.redBuildingLabel = new JLabel();
		redBuildingLabel.setIcon(redBuilding);

		greenLandLabel.setSize(36, 29);
		redLandLabel.setSize(36, 29);
		greenVillaLabel.setSize(30, 30);
		redVillaLabel.setSize(30, 30);
		greenHotelLabel.setSize(25, 40);
		redHotelLabel.setSize(25, 40);
		greenBuildingLabel.setSize(25, 30);
		redBuildingLabel.setSize(25, 30);
		refresh();
		/*this.add(greenLandLabel);
		this.add(greenVillaLabel);
		this.add(greenHotelLabel);
		this.add(greenBuildingLabel);
		this.add(redLandLabel);
		this.add(redVillaLabel);
		this.add(redHotelLabel);
		this.add(redBuildingLabel);*/
		
		//setVisible(true);
	}

	public void setGreenLandLabel(int x, int y) {
		greenLandLabel.setLocation(x, y);
		greenLandLabel.setVisible(false);
	}

	public void setGreenVillaLabel(int x, int y) {
		greenVillaLabel.setLocation(x, y);
		greenVillaLabel.setVisible(false);
	}

	public void setGreenHotelLabel(int x, int y) {
		greenHotelLabel.setLocation(x, y);
		greenHotelLabel.setVisible(false);
	}

	public void setGreenBuildingLabel(int x, int y) {
		greenBuildingLabel.setLocation(x, y);
		greenBuildingLabel.setVisible(false);
	}

	public void setRedLandLabel(int x, int y) {
		redLandLabel.setLocation(x, y);
		redLandLabel.setVisible(false);
	}

	public void setRedVillaLabel(int x, int y) {
		redVillaLabel.setLocation(x, y);
		redVillaLabel.setVisible(false);
	}

	public void setRedHotelLabel(int x, int y) {
		redHotelLabel.setLocation(x, y);
		redHotelLabel.setVisible(false);
	}

	public void setRedBuildingLabel(int x, int y) {
		redBuildingLabel.setLocation(x, y);
		redBuildingLabel.setVisible(false);
	}

	public JPanel getStructurePanel() {
		return this;
	}

	public JLabel getGreenLandLabel() {
		return greenLandLabel;
	}

	public JLabel getGreenVillaLabel() {
		return greenVillaLabel;
	}

	public JLabel getGreenHotelLabel() {
		return greenHotelLabel;
	}

	public JLabel getGreenBuildingLabel() {
		return greenBuildingLabel;
	}

	public JLabel getRedLandLabel() {
		return redLandLabel;
	}

	public JLabel getRedVillaLabel() {
		return redVillaLabel;
	}

	public JLabel getRedHotelLabel() {
		return redHotelLabel;
	}

	public JLabel getRedBuildingLabel() {
		return redBuildingLabel;
	}
	
	public void refresh() {
		
		this.add(greenLandLabel);
		this.add(greenVillaLabel);
		this.add(greenHotelLabel);
		this.add(greenBuildingLabel);
		this.add(redLandLabel);
		this.add(redVillaLabel);
		this.add(redHotelLabel);
		this.add(redBuildingLabel);
		
		setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
}
