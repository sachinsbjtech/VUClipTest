package vuclip.factory;

import vuclip.domainObjects.AircraftCarrier;
import vuclip.domainObjects.BattleShip;
import vuclip.domainObjects.CruiserShip;
import vuclip.domainObjects.DestroyerShip;
import vuclip.domainObjects.IShip;
import vuclip.domainObjects.SubmarineShip;

public class ShipFactory {
	/**
	 * Ship factory method. 
	 * @param shipName for which corresponding object will be returned
	 * @return Ship object
	 */
	public static IShip getShip(String shipName) {
		IShip ship =null;
		switch (shipName) {
		case "Cruiser":
			ship = new CruiserShip();
			break;
		case "Destroyer":
			ship = new DestroyerShip();		
			break;
		case "BattleShip":
			ship = new BattleShip();
			break;
		case "Submarine":
			ship = new SubmarineShip();
			break;
		case "AricraftCarrier":
			ship = new AircraftCarrier();
			break;
		}
		return ship;
	}
}
