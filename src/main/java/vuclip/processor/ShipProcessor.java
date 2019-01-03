package vuclip.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import vuclip.domainObjects.IShip;
import vuclip.factory.ShipFactory;

public class ShipProcessor {
	//Ship locations on grid
	private Map<String,List<String>> shipLocations = new HashMap<String, List<String>>();
	
	// Utility class 
	private IShipUtility utility = new ShipUtility();
	
	/**
	 * Load ships on the Grid. Maintain each ship locations in Map
	 * @return
	 */
	public int loadShipOnGrid() {
        
        
		IShip ship = getShip("Destroyer");
		shipLocations.put("Destroyer", utility.addShip(ship)) ;
		
		ship = getShip("Submarine");
		shipLocations.put("Submarine", utility.addShip(ship)) ;
		
		ship = getShip("Cruiser");
		shipLocations.put("Cruiser", utility.addShip(ship)) ;
		
		ship = getShip("BattleShip");
		shipLocations.put("BattleShip", utility.addShip(ship)) ;
		
		ship = getShip("AricraftCarrier");
		shipLocations.put("AricraftCarrier", utility.addShip(ship)) ;
		
		System.out.println("Ships are loaded on Grid");
		
		return shipLocations.size();
	}
	
	/*
	 * get ship object from Factory
	 */
	private IShip getShip(String shipName) {
		return ShipFactory.getShip(shipName);
	}
	
	/**
	 * check if Ship is hit. If ship square is hit then remove it from ship location map
	 * which will help in decide if ship is sinked
	 * @param userInput - ship square guessed by user
	 * @return - true if ship is hit else false
	 */
	public boolean isShipHit(String userInput) {
		boolean isHit = false;
		int columnIndex = utility.returnColumnIndex(userInput.charAt(0));
		if(utility.isHit(Integer.parseInt(userInput.substring(1, userInput.length()))-1, columnIndex )) {
			Set<Entry<String, List<String>>> entryset = shipLocations.entrySet();
			for(Entry<String, List<String>> entry : entryset) {
				
				if(entry.getValue().contains(userInput)) {
					System.out.println("Shipt is hit");
					entry.getValue().remove(userInput);
					if(entry.getValue()!=null && entry.getValue().isEmpty()) {
						System.out.println("Ship "+entry.getKey()+" is sinked");
						shipLocations.remove(entry.getKey());
					}
					isHit = true;
					break;
				}
			}
		}
		
		return isHit;
	}
	/**
	 * check if all ships are sinked
	 * @return
	 */
	public boolean AreAllShipsSinked() {
		return shipLocations.isEmpty();
	}
}
