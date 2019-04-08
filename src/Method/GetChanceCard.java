package Method;

import Game.Player;
import Graphics.GPlayer;
import Map.ChanceCard;
import Map.Ground;

public class GetChanceCard {
	private Player player;
	private ChanceCard chance;

	public GetChanceCard(GPlayer gPlayer) {
		player = gPlayer.getPlayer();
		chance = (ChanceCard) Ground.getSingleGround().getGround()[player.getIndex()];
		System.out.println(chance.getChance());

		String card = chance.getChance();
		switch (card) {
		case "AngelCard":
			;
			break;
		case "PassLand":
			;
			break;
		case "Prison":
			;
			break;
		case "TrailTour":
			;
			break;
		case "OpenExpo":
			;
			break;
		case "GoExpo":
			;
			break;
		case "Start":
			new InStartSpot(gPlayer);
			/*player.setIndex(0);
			if (player.getTurn() % 2 == 1) {
				player.setX(Ground.getSingleGround().getIndexTourSpot(0).getX1());
				player.setY(Ground.getSingleGround().getIndexTourSpot(0).getY1());
			}
			else if (player.getTurn() % 2 == 0) {
				player.setX(Ground.getSingleGround().getIndexTourSpot(0).getX2());
				player.setY(Ground.getSingleGround().getIndexTourSpot(0).getY2());
			}*/
			break;
		case "BonusGame":
			;
			break;
		}
	}

	/*
	 * AngelCard, //천사카드 PassLand, //상대에게 가장 비싼 땅 양도 Prison, //감옥으로 워프 TrailTour,
	 * //기차여행으로 이동 OpenExpo, //원하는 곳 Expo 개최, 땅값 2배 GoExpo, //Expo개최지로 이동, 없다면 제자리
	 * Start, //출발지로 BonusGame; //보너스게임으로 이동
	 */
}