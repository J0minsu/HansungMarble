package Graphics;

import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Map.Ground;
import Map.Land;

public class AllStructurePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AllStructurePanel SingleStructurePanel = new AllStructurePanel();
	private HashMap<Land, StructurePanel> structureMap = new HashMap<Land, StructurePanel>();
	private StructurePanel Gangneung;
	private StructurePanel Chuncheon;
	private StructurePanel Bukhansan;
	private StructurePanel Gyeongju;
	private StructurePanel Andong;
	private StructurePanel Cheonan;
	private StructurePanel SeoulPark;
	private StructurePanel Incheon;
	private StructurePanel Daejeon;
	private StructurePanel Cheongju;
	private StructurePanel Seolaksan;
	private StructurePanel Sejong;
	private StructurePanel Yeosu;
	private StructurePanel Jirisan;
	private StructurePanel Jeju;
	private StructurePanel Pohang;
	private StructurePanel Ulsan;
	private StructurePanel Daegu;
	private StructurePanel ChildPark;
	private StructurePanel Jeonju;
	private StructurePanel Gwangju;
	private StructurePanel Busan;
	private StructurePanel Seoul;

	private AllStructurePanel() {
		setSize(1150,803);
		setOpaque(false);
		setLayout(null);
		
		Ground ground = Ground.getSingleGround();
		Gangneung = new StructurePanel();
		Chuncheon = new StructurePanel();
		Bukhansan = new StructurePanel();
		Gyeongju = new StructurePanel();
		Andong = new StructurePanel();
		Cheonan = new StructurePanel();
		SeoulPark = new StructurePanel();
		Incheon = new StructurePanel();
		Daejeon = new StructurePanel();
		Cheongju = new StructurePanel();
		Seolaksan = new StructurePanel();
		Sejong = new StructurePanel();
		Yeosu = new StructurePanel();
		Jirisan = new StructurePanel();
		Jeju = new StructurePanel();
		Pohang = new StructurePanel();
		Ulsan = new StructurePanel();
		Daegu = new StructurePanel();
		ChildPark = new StructurePanel();
		Jeonju = new StructurePanel();
		Gwangju = new StructurePanel();
		Busan = new StructurePanel();
		Seoul = new StructurePanel();

		Gangneung.setGreenLandLabel(ground.getIndexCity(1).getxCenter(), ground.getIndexCity(1).getyCenter());
		Gangneung.setGreenVillaLabel(ground.getIndexCity(1).getxLeft(), ground.getIndexCity(1).getyLeft());
		Gangneung.setGreenBuildingLabel(ground.getIndexCity(1).getxCenter(), ground.getIndexCity(1).getyCenter());
		Gangneung.setGreenHotelLabel(ground.getIndexCity(1).getxRight(), ground.getIndexCity(1).getyRight());
		Gangneung.setRedLandLabel(ground.getIndexCity(1).getxCenter(), ground.getIndexCity(1).getyCenter());
		Gangneung.setRedVillaLabel(ground.getIndexCity(1).getxLeft(), ground.getIndexCity(1).getyLeft());
		Gangneung.setRedBuildingLabel(ground.getIndexCity(1).getxCenter(), ground.getIndexCity(1).getyCenter());
		Gangneung.setRedHotelLabel(ground.getIndexCity(1).getxRight(), ground.getIndexCity(1).getyRight());

		Chuncheon.setGreenLandLabel(ground.getIndexCity(3).getxCenter(), ground.getIndexCity(3).getyCenter());
		Chuncheon.setGreenVillaLabel(ground.getIndexCity(3).getxLeft(), ground.getIndexCity(3).getyLeft());
		Chuncheon.setGreenBuildingLabel(ground.getIndexCity(3).getxCenter(), ground.getIndexCity(3).getyCenter());
		Chuncheon.setGreenHotelLabel(ground.getIndexCity(3).getxRight(), ground.getIndexCity(3).getyRight());
		Chuncheon.setRedLandLabel(ground.getIndexCity(3).getxCenter(), ground.getIndexCity(3).getyCenter());
		Chuncheon.setRedVillaLabel(ground.getIndexCity(3).getxLeft(), ground.getIndexCity(3).getyLeft());
		Chuncheon.setRedBuildingLabel(ground.getIndexCity(3).getxCenter(), ground.getIndexCity(3).getyCenter());
		Chuncheon.setRedHotelLabel(ground.getIndexCity(3).getxRight(), ground.getIndexCity(3).getyRight());

		Bukhansan.setGreenLandLabel(ground.getIndexTourSpot(4).getxCenter(), ground.getIndexTourSpot(4).getyCenter());
		Bukhansan.setRedLandLabel(ground.getIndexTourSpot(4).getxCenter(), ground.getIndexTourSpot(4).getyCenter());

		Gyeongju.setGreenLandLabel(ground.getIndexCity(5).getxCenter(), ground.getIndexCity(5).getyCenter());
		Gyeongju.setGreenVillaLabel(ground.getIndexCity(5).getxLeft(), ground.getIndexCity(5).getyLeft());
		Gyeongju.setGreenBuildingLabel(ground.getIndexCity(5).getxCenter(), ground.getIndexCity(5).getyCenter());
		Gyeongju.setGreenHotelLabel(ground.getIndexCity(5).getxRight(), ground.getIndexCity(5).getyRight());
		Gyeongju.setRedLandLabel(ground.getIndexCity(5).getxCenter(), ground.getIndexCity(5).getyCenter());
		Gyeongju.setRedVillaLabel(ground.getIndexCity(5).getxLeft(), ground.getIndexCity(5).getyLeft());
		Gyeongju.setRedBuildingLabel(ground.getIndexCity(5).getxCenter(), ground.getIndexCity(5).getyCenter());
		Gyeongju.setRedHotelLabel(ground.getIndexCity(5).getxRight(), ground.getIndexCity(5).getyRight());

		Andong.setGreenLandLabel(ground.getIndexCity(6).getxCenter(), ground.getIndexCity(6).getyCenter());
		Andong.setGreenVillaLabel(ground.getIndexCity(6).getxLeft(), ground.getIndexCity(6).getyLeft());
		Andong.setGreenBuildingLabel(ground.getIndexCity(6).getxCenter(), ground.getIndexCity(6).getyCenter());
		Andong.setGreenHotelLabel(ground.getIndexCity(6).getxRight(), ground.getIndexCity(6).getyRight());
		Andong.setRedLandLabel(ground.getIndexCity(6).getxCenter(), ground.getIndexCity(6).getyCenter());
		Andong.setRedVillaLabel(ground.getIndexCity(6).getxLeft(), ground.getIndexCity(6).getyLeft());
		Andong.setRedBuildingLabel(ground.getIndexCity(6).getxCenter(), ground.getIndexCity(6).getyCenter());
		Andong.setRedHotelLabel(ground.getIndexCity(6).getxRight(), ground.getIndexCity(6).getyRight());

		Cheonan.setGreenLandLabel(ground.getIndexCity(7).getxCenter(), ground.getIndexCity(7).getyCenter());
		Cheonan.setGreenVillaLabel(ground.getIndexCity(7).getxLeft(), ground.getIndexCity(7).getyLeft());
		Cheonan.setGreenBuildingLabel(ground.getIndexCity(7).getxCenter(), ground.getIndexCity(7).getyCenter());
		Cheonan.setGreenHotelLabel(ground.getIndexCity(7).getxRight(), ground.getIndexCity(7).getyRight());
		Cheonan.setRedLandLabel(ground.getIndexCity(7).getxCenter(), ground.getIndexCity(7).getyCenter());
		Cheonan.setRedVillaLabel(ground.getIndexCity(7).getxLeft(), ground.getIndexCity(7).getyLeft());
		Cheonan.setRedBuildingLabel(ground.getIndexCity(7).getxCenter(), ground.getIndexCity(7).getyCenter());
		Cheonan.setRedHotelLabel(ground.getIndexCity(7).getxRight(), ground.getIndexCity(7).getyRight());

		SeoulPark.setGreenLandLabel(ground.getIndexTourSpot(9).getxCenter(), ground.getIndexTourSpot(9).getyCenter());
		SeoulPark.setRedLandLabel(ground.getIndexTourSpot(9).getxCenter(), ground.getIndexTourSpot(9).getyCenter());

		Incheon.setGreenLandLabel(ground.getIndexCity(10).getxCenter(), ground.getIndexCity(10).getyCenter());
		Incheon.setGreenVillaLabel(ground.getIndexCity(10).getxLeft(), ground.getIndexCity(10).getyLeft());
		Incheon.setGreenBuildingLabel(ground.getIndexCity(10).getxCenter(), ground.getIndexCity(10).getyCenter());
		Incheon.setGreenHotelLabel(ground.getIndexCity(10).getxRight(), ground.getIndexCity(10).getyRight());
		Incheon.setRedLandLabel(ground.getIndexCity(10).getxCenter(), ground.getIndexCity(10).getyCenter());
		Incheon.setRedVillaLabel(ground.getIndexCity(10).getxLeft(), ground.getIndexCity(10).getyLeft());
		Incheon.setRedBuildingLabel(ground.getIndexCity(10).getxCenter(), ground.getIndexCity(10).getyCenter());
		Incheon.setRedHotelLabel(ground.getIndexCity(10).getxRight(), ground.getIndexCity(10).getyRight());

		Daejeon.setGreenLandLabel(ground.getIndexCity(11).getxCenter(), ground.getIndexCity(11).getyCenter());
		Daejeon.setGreenVillaLabel(ground.getIndexCity(11).getxLeft(), ground.getIndexCity(11).getyLeft());
		Daejeon.setGreenBuildingLabel(ground.getIndexCity(11).getxCenter(), ground.getIndexCity(11).getyCenter());
		Daejeon.setGreenHotelLabel(ground.getIndexCity(11).getxRight(), ground.getIndexCity(11).getyRight());
		Daejeon.setRedLandLabel(ground.getIndexCity(11).getxCenter(), ground.getIndexCity(11).getyCenter());
		Daejeon.setRedVillaLabel(ground.getIndexCity(11).getxLeft(), ground.getIndexCity(11).getyLeft());
		Daejeon.setRedBuildingLabel(ground.getIndexCity(11).getxCenter(), ground.getIndexCity(11).getyCenter());
		Daejeon.setRedHotelLabel(ground.getIndexCity(11).getxRight(), ground.getIndexCity(11).getyRight());

		Cheongju.setGreenLandLabel(ground.getIndexCity(13).getxCenter(), ground.getIndexCity(13).getyCenter());
		Cheongju.setGreenVillaLabel(ground.getIndexCity(13).getxLeft(), ground.getIndexCity(13).getyLeft());
		Cheongju.setGreenBuildingLabel(ground.getIndexCity(13).getxCenter(), ground.getIndexCity(13).getyCenter());
		Cheongju.setGreenHotelLabel(ground.getIndexCity(13).getxRight(), ground.getIndexCity(13).getyRight());
		Cheongju.setRedLandLabel(ground.getIndexCity(13).getxCenter(), ground.getIndexCity(13).getyCenter());
		Cheongju.setRedVillaLabel(ground.getIndexCity(13).getxLeft(), ground.getIndexCity(13).getyLeft());
		Cheongju.setRedBuildingLabel(ground.getIndexCity(13).getxCenter(), ground.getIndexCity(13).getyCenter());
		Cheongju.setRedHotelLabel(ground.getIndexCity(13).getxRight(), ground.getIndexCity(13).getyRight());

		Seolaksan.setGreenLandLabel(ground.getIndexTourSpot(14).getxCenter(), ground.getIndexTourSpot(14).getyCenter());
		Seolaksan.setRedLandLabel(ground.getIndexTourSpot(14).getxCenter(), ground.getIndexTourSpot(14).getyCenter());

		Sejong.setGreenLandLabel(ground.getIndexCity(15).getxCenter(), ground.getIndexCity(15).getyCenter());
		Sejong.setGreenVillaLabel(ground.getIndexCity(15).getxLeft(), ground.getIndexCity(15).getyLeft());
		Sejong.setGreenBuildingLabel(ground.getIndexCity(15).getxCenter(), ground.getIndexCity(15).getyCenter());
		Sejong.setGreenHotelLabel(ground.getIndexCity(15).getxRight(), ground.getIndexCity(15).getyRight());
		Sejong.setRedLandLabel(ground.getIndexCity(15).getxCenter(), ground.getIndexCity(15).getyCenter());
		Sejong.setRedVillaLabel(ground.getIndexCity(15).getxLeft(), ground.getIndexCity(15).getyLeft());
		Sejong.setRedBuildingLabel(ground.getIndexCity(15).getxCenter(), ground.getIndexCity(15).getyCenter());
		Sejong.setRedHotelLabel(ground.getIndexCity(15).getxRight(), ground.getIndexCity(15).getyRight());

		Yeosu.setGreenLandLabel(ground.getIndexCity(17).getxCenter(), ground.getIndexCity(17).getyCenter());
		Yeosu.setGreenVillaLabel(ground.getIndexCity(17).getxLeft(), ground.getIndexCity(17).getyLeft());
		Yeosu.setGreenBuildingLabel(ground.getIndexCity(17).getxCenter(), ground.getIndexCity(17).getyCenter());
		Yeosu.setGreenHotelLabel(ground.getIndexCity(17).getxRight(), ground.getIndexCity(17).getyRight());
		Yeosu.setRedLandLabel(ground.getIndexCity(17).getxCenter(), ground.getIndexCity(17).getyCenter());
		Yeosu.setRedVillaLabel(ground.getIndexCity(17).getxLeft(), ground.getIndexCity(17).getyLeft());
		Yeosu.setRedBuildingLabel(ground.getIndexCity(17).getxCenter(), ground.getIndexCity(17).getyCenter());
		Yeosu.setRedHotelLabel(ground.getIndexCity(17).getxRight(), ground.getIndexCity(17).getyRight());

		Jirisan.setGreenLandLabel(ground.getIndexTourSpot(18).getxCenter(), ground.getIndexTourSpot(18).getyCenter());
		Jirisan.setRedLandLabel(ground.getIndexTourSpot(18).getxCenter(), ground.getIndexTourSpot(18).getyCenter());

		Jeju.setGreenLandLabel(ground.getIndexCity(19).getxCenter(), ground.getIndexCity(19).getyCenter());
		Jeju.setGreenVillaLabel(ground.getIndexCity(19).getxLeft(), ground.getIndexCity(19).getyLeft());
		Jeju.setGreenBuildingLabel(ground.getIndexCity(19).getxCenter(), ground.getIndexCity(19).getyCenter());
		Jeju.setGreenHotelLabel(ground.getIndexCity(19).getxRight(), ground.getIndexCity(19).getyRight());
		Jeju.setRedLandLabel(ground.getIndexCity(19).getxCenter(), ground.getIndexCity(19).getyCenter());
		Jeju.setRedVillaLabel(ground.getIndexCity(19).getxLeft(), ground.getIndexCity(19).getyLeft());
		Jeju.setRedBuildingLabel(ground.getIndexCity(19).getxCenter(), ground.getIndexCity(19).getyCenter());
		Jeju.setRedHotelLabel(ground.getIndexCity(19).getxRight(), ground.getIndexCity(19).getyRight());

		Pohang.setGreenLandLabel(ground.getIndexCity(21).getxCenter(), ground.getIndexCity(21).getyCenter());
		Pohang.setGreenVillaLabel(ground.getIndexCity(21).getxLeft(), ground.getIndexCity(21).getyLeft());
		Pohang.setGreenBuildingLabel(ground.getIndexCity(21).getxCenter(), ground.getIndexCity(21).getyCenter());
		Pohang.setGreenHotelLabel(ground.getIndexCity(21).getxRight(), ground.getIndexCity(21).getyRight());
		Pohang.setRedLandLabel(ground.getIndexCity(21).getxCenter(), ground.getIndexCity(21).getyCenter());
		Pohang.setRedVillaLabel(ground.getIndexCity(21).getxLeft(), ground.getIndexCity(21).getyLeft());
		Pohang.setRedBuildingLabel(ground.getIndexCity(21).getxCenter(), ground.getIndexCity(21).getyCenter());
		Pohang.setRedHotelLabel(ground.getIndexCity(21).getxRight(), ground.getIndexCity(21).getyRight());

		Ulsan.setGreenLandLabel(ground.getIndexCity(22).getxCenter(), ground.getIndexCity(22).getyCenter());
		Ulsan.setGreenVillaLabel(ground.getIndexCity(22).getxLeft(), ground.getIndexCity(22).getyLeft());
		Ulsan.setGreenBuildingLabel(ground.getIndexCity(22).getxCenter(), ground.getIndexCity(22).getyCenter());
		Ulsan.setGreenHotelLabel(ground.getIndexCity(22).getxRight(), ground.getIndexCity(22).getyRight());
		Ulsan.setRedLandLabel(ground.getIndexCity(22).getxCenter(), ground.getIndexCity(22).getyCenter());
		Ulsan.setRedVillaLabel(ground.getIndexCity(22).getxLeft(), ground.getIndexCity(22).getyLeft());
		Ulsan.setRedBuildingLabel(ground.getIndexCity(22).getxCenter(), ground.getIndexCity(22).getyCenter());
		Ulsan.setRedHotelLabel(ground.getIndexCity(22).getxRight(), ground.getIndexCity(22).getyRight());

		Daegu.setGreenLandLabel(ground.getIndexCity(23).getxCenter(), ground.getIndexCity(23).getyCenter());
		Daegu.setGreenVillaLabel(ground.getIndexCity(23).getxLeft(), ground.getIndexCity(23).getyLeft());
		Daegu.setGreenBuildingLabel(ground.getIndexCity(23).getxCenter(), ground.getIndexCity(23).getyCenter());
		Daegu.setGreenHotelLabel(ground.getIndexCity(23).getxRight(), ground.getIndexCity(23).getyRight());
		Daegu.setRedLandLabel(ground.getIndexCity(23).getxCenter(), ground.getIndexCity(23).getyCenter());
		Daegu.setRedVillaLabel(ground.getIndexCity(23).getxLeft(), ground.getIndexCity(23).getyLeft());
		Daegu.setRedBuildingLabel(ground.getIndexCity(23).getxCenter(), ground.getIndexCity(23).getyCenter());
		Daegu.setRedHotelLabel(ground.getIndexCity(23).getxRight(), ground.getIndexCity(23).getyRight());

		ChildPark.setGreenLandLabel(ground.getIndexTourSpot(25).getxCenter(), ground.getIndexTourSpot(25).getyCenter());
		ChildPark.setRedLandLabel(ground.getIndexTourSpot(25).getxCenter(), ground.getIndexTourSpot(25).getyCenter());

		Jeonju.setGreenLandLabel(ground.getIndexCity(26).getxCenter(), ground.getIndexCity(26).getyCenter());
		Jeonju.setGreenVillaLabel(ground.getIndexCity(26).getxLeft(), ground.getIndexCity(26).getyLeft());
		Jeonju.setGreenBuildingLabel(ground.getIndexCity(26).getxCenter(), ground.getIndexCity(26).getyCenter());
		Jeonju.setGreenHotelLabel(ground.getIndexCity(26).getxRight(), ground.getIndexCity(26).getyRight());
		Jeonju.setRedLandLabel(ground.getIndexCity(26).getxCenter(), ground.getIndexCity(26).getyCenter());
		Jeonju.setRedVillaLabel(ground.getIndexCity(26).getxLeft(), ground.getIndexCity(26).getyLeft());
		Jeonju.setRedBuildingLabel(ground.getIndexCity(26).getxCenter(), ground.getIndexCity(26).getyCenter());
		Jeonju.setRedHotelLabel(ground.getIndexCity(26).getxRight(), ground.getIndexCity(26).getyRight());

		Gwangju.setGreenLandLabel(ground.getIndexCity(27).getxCenter(), ground.getIndexCity(27).getyCenter());
		Gwangju.setGreenVillaLabel(ground.getIndexCity(27).getxLeft(), ground.getIndexCity(27).getyLeft());
		Gwangju.setGreenBuildingLabel(ground.getIndexCity(27).getxCenter(), ground.getIndexCity(27).getyCenter());
		Gwangju.setGreenHotelLabel(ground.getIndexCity(27).getxRight(), ground.getIndexCity(27).getyRight());
		Gwangju.setRedLandLabel(ground.getIndexCity(27).getxCenter(), ground.getIndexCity(27).getyCenter());
		Gwangju.setRedVillaLabel(ground.getIndexCity(27).getxLeft(), ground.getIndexCity(27).getyLeft());
		Gwangju.setRedBuildingLabel(ground.getIndexCity(27).getxCenter(), ground.getIndexCity(27).getyCenter());
		Gwangju.setRedHotelLabel(ground.getIndexCity(27).getxRight(), ground.getIndexCity(27).getyRight());

		Busan.setGreenLandLabel(ground.getIndexCity(29).getxCenter(), ground.getIndexCity(29).getyCenter());
		Busan.setGreenVillaLabel(ground.getIndexCity(29).getxLeft(), ground.getIndexCity(29).getyLeft());
		Busan.setGreenBuildingLabel(ground.getIndexCity(29).getxCenter(), ground.getIndexCity(29).getyCenter());
		Busan.setGreenHotelLabel(ground.getIndexCity(29).getxRight(), ground.getIndexCity(29).getyRight());
		Busan.setRedLandLabel(ground.getIndexCity(29).getxCenter(), ground.getIndexCity(29).getyCenter());
		Busan.setRedVillaLabel(ground.getIndexCity(29).getxLeft(), ground.getIndexCity(29).getyLeft());
		Busan.setRedBuildingLabel(ground.getIndexCity(29).getxCenter(), ground.getIndexCity(29).getyCenter());
		Busan.setRedHotelLabel(ground.getIndexCity(29).getxRight(), ground.getIndexCity(29).getyRight());

		Seoul.setGreenLandLabel(ground.getIndexCity(31).getxCenter(), ground.getIndexCity(31).getyCenter());
		Seoul.setGreenVillaLabel(ground.getIndexCity(31).getxLeft(), ground.getIndexCity(31).getyLeft());
		Seoul.setGreenBuildingLabel(ground.getIndexCity(31).getxCenter(), ground.getIndexCity(31).getyCenter());
		Seoul.setGreenHotelLabel(ground.getIndexCity(31).getxRight(), ground.getIndexCity(31).getyRight());
		Seoul.setRedLandLabel(ground.getIndexCity(31).getxCenter(), ground.getIndexCity(31).getyCenter());
		Seoul.setRedVillaLabel(ground.getIndexCity(31).getxLeft(), ground.getIndexCity(31).getyLeft());
		Seoul.setRedBuildingLabel(ground.getIndexCity(31).getxCenter(), ground.getIndexCity(31).getyCenter());
		Seoul.setRedHotelLabel(ground.getIndexCity(31).getxRight(), ground.getIndexCity(31).getyRight());
		
		structureMap.put(ground.getIndexCity(1), Gangneung);
		structureMap.put(ground.getIndexCity(3), Chuncheon);
		structureMap.put(ground.getIndexTourSpot(4), Bukhansan);
		structureMap.put(ground.getIndexCity(5), Gyeongju);
		structureMap.put(ground.getIndexCity(6), Andong);
		structureMap.put(ground.getIndexCity(7), Cheonan);
		structureMap.put(ground.getIndexTourSpot(9), SeoulPark);
		structureMap.put(ground.getIndexCity(10), Incheon);
		structureMap.put(ground.getIndexCity(11), Daejeon);
		structureMap.put(ground.getIndexCity(13), Cheongju);
		structureMap.put(ground.getIndexTourSpot(14), Seolaksan);
		structureMap.put(ground.getIndexCity(15), Sejong);
		structureMap.put(ground.getIndexCity(17), Yeosu);
		structureMap.put(ground.getIndexTourSpot(18), Jirisan);
		structureMap.put(ground.getIndexCity(19), Jeju);
		structureMap.put(ground.getIndexCity(21), Pohang);
		structureMap.put(ground.getIndexCity(22), Ulsan);
		structureMap.put(ground.getIndexCity(23), Daegu);
		structureMap.put(ground.getIndexTourSpot(25), ChildPark);
		structureMap.put(ground.getIndexCity(26), Jeonju);
		structureMap.put(ground.getIndexCity(27), Gwangju);
		structureMap.put(ground.getIndexCity(29), Busan);
		structureMap.put(ground.getIndexCity(31), Seoul);
		
		/*this.add(Gangneung);
		this.add(Chuncheon);
		this.add(Bukhansan);
		this.add(Gyeongju);
		this.add(Andong);
		this.add(Cheonan);
		this.add(SeoulPark);
		this.add(Incheon);
		this.add(Daejeon);
		this.add(Cheongju);
		this.add(Seolaksan);
		this.add(Sejong);
		this.add(Yeosu);
		this.add(Jirisan);
		this.add(Jeju);
		this.add(Pohang);
		this.add(Ulsan);
		this.add(Daegu);
		this.add(ChildPark);
		this.add(Jeonju);
		this.add(Gwangju);
		this.add(Busan);
		this.add(Seoul);*/
		refresh();
		setVisible(true);
	}

	public HashMap<Land, StructurePanel> getStructureMap() {
		return structureMap;
	}

	public static AllStructurePanel getSingleStructurePanel() {
		return SingleStructurePanel;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

	}
	public void refresh() {
		//this.removeAll();
		this.add(Gangneung);
		this.add(Chuncheon);
		this.add(Bukhansan);
		this.add(Gyeongju);
		this.add(Andong);
		this.add(Cheonan);
		this.add(SeoulPark);
		this.add(Incheon);
		this.add(Daejeon);
		this.add(Cheongju);
		this.add(Seolaksan);
		this.add(Sejong);
		this.add(Yeosu);
		this.add(Jirisan);
		this.add(Jeju);
		this.add(Pohang);
		this.add(Ulsan);
		this.add(Daegu);
		this.add(ChildPark);
		this.add(Jeonju);
		this.add(Gwangju);
		this.add(Busan);
		this.add(Seoul);
		
		setVisible(true);
	}
}



