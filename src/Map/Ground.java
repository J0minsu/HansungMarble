package Map;


public class Ground {
	private static Ground singleGround = new Ground();
	private Card[] ground = new Card[32];

	private Ground() {
		SpecialSpot start = new StartSpot(558, 711, 601, 713);
		SpecialSpot bonus = new BonusSpot(432, 634, 452, 648);
		SpecialSpot prison = new PrisonSpot(96, 419, 149, 421);
		SpecialSpot expo = new ExpoSpot(555, 123, 613, 123);
		SpecialSpot trail = new TrailSpot(1006, 415, 1073, 419);
		SpecialSpot lucky = new LuckySpot(706, 650, 729, 635);

		ChanceCard chance1 = new ChanceCard("천사", 334, 268, 356, 256);
		ChanceCard chance2 = new ChanceCard("천사", 807, 259, 830, 269);
		ChanceCard chance3 = new ChanceCard("천사", 808, 581, 828, 568);

		Land Gangneung = new City("강릉", 20000, 484, 668, 506, 686, 514, 630, 532, 630, 551, 630);
		Land Chuncheon = new City("춘천", 40000, 382, 604, 397, 617, 405, 554, 430, 560, 452, 560);
		Land Bukhansan = new TourSpot("북한산", 150000, 332, 566, 350, 581, 372, 509);
		Land Gyeongju = new City("경주", 60000, 280, 537, 297, 549, 304, 490, 325, 490, 345, 490);
		Land Andong = new City("안동", 80000, 227, 500, 246, 518, 254, 454, 274, 454, 294, 454);
		Land Cheonan = new City("천안", 100000, 172, 470, 194, 487, 200, 423, 220, 423, 240, 423);
		Land SeoulPark = new TourSpot("서울대공원", 150000, 181, 366, 202, 355, 219, 380);
		Land Incheon = new City("인천", 120000, 231, 336, 256, 320, 257, 355, 273, 341, 289, 324);
		Land Daejeon = new City("대전", 140000, 280, 299, 297, 289, 314, 324, 330, 311, 342, 300);
		Land Cheongju = new City("청주", 160000, 384, 235, 406, 218, 415, 261, 428, 250, 443, 234);
		Land Seolaksan = new TourSpot("설악산", 150000, 436, 199, 460, 184, 477, 216);
		Land Sejong = new City("세종", 180000, 488, 171, 510, 153, 518, 190, 530, 178, 546, 159);
		Land Yeosu = new City("여수", 220000, 650, 150, 673, 170, 588, 162, 608, 162, 628, 162);
		Land Jirisan = new TourSpot("지리산", 150000, 705, 189, 724, 202, 664, 209);
		Land Jeju = new City("제주", 240000, 759, 221, 780, 241, 693, 233, 713, 233, 733, 233);
		Land Pohang = new City("포항", 260000, 861, 285, 886, 304, 794, 295, 814, 295, 834, 295);
		Land Ulsan = new City("울산", 280000, 912, 321, 937, 337, 851, 335, 871, 335, 891, 335);
		Land Daegu = new City("대구", 300000, 960, 358, 985, 370, 901, 366, 921, 366, 941, 366);
		Land ChildPark = new TourSpot("어린이대공원", 150000, 966, 483, 992, 462, 914, 431);
		Land Jeonju = new City("전주", 320000, 909, 516, 934, 501, 842, 465, 862, 452, 873, 439);
		Land Gwangju = new City("광주", 340000, 860, 548, 883, 531, 791, 497, 805, 482, 819, 470);
		Land Busan = new City("부산", 360000, 761, 620, 785, 604, 690, 562, 702, 551, 714, 535);
		Land Seoul = new City("서울", 380000, 648, 683, 678, 668, 583, 630, 599, 618, 615, 606);

		ground[0] = start;
		ground[1] = Gangneung;
		ground[2] = bonus;
		ground[3] = Chuncheon;
		ground[4] = Bukhansan;
		ground[5] = Gyeongju;
		ground[6] = Andong;
		ground[7] = Cheonan;
		ground[8] = prison;
		ground[9] = SeoulPark;
		ground[10] = Incheon;
		ground[11] = Daejeon;
		ground[12] = chance1;
		ground[13] = Cheongju;
		ground[14] = Seolaksan;
		ground[15] = Sejong;
		ground[16] = expo;
		ground[17] = Yeosu;
		ground[18] = Jirisan;
		ground[19] = Jeju;
		ground[20] = chance2;
		ground[21] = Pohang;
		ground[22] = Ulsan;
		ground[23] = Daegu;
		ground[24] = trail;
		ground[25] = ChildPark;
		ground[26] = Jeonju;
		ground[27] = Gwangju;
		ground[28] = chance3;
		ground[29] = Busan;
		ground[30] = lucky;
		ground[31] = Seoul;
	}

	public static Ground getSingleGround() {
		return singleGround;
	}

	public Card[] getGround() {
		return ground;
	}
	
	public City getIndexCity(int index)	{
		City newCity = (City)ground[index];
		return newCity;
	}
	
	public void setIndexCity(int index, City city)	{
		ground[index] = city;
	}
	
	public TourSpot getIndexTourSpot(int index)	{
		TourSpot newTourSpot = (TourSpot)ground[index];
		return newTourSpot;
	}
	
	public void setIndexTourSpot(int index, TourSpot tourSpot)	{
		ground[index] = tourSpot;
	}
}