package vuclip.vuclipTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import vuclip.domainObjects.CruiserShip;
import vuclip.domainObjects.IShip;

public class TestConfiguration {
	
	static IShip createShip() {
		IShip ship = new CruiserShip();
		return ship;
	}
	
	static Set<Entry<String, List<String>>> getShipLocation(){
		List<String> locationList = new ArrayList<>();
		locationList.add("A2");
		locationList.add("A3");
		locationList.add("A4");
		
		final Map<String,List<String>> map =new HashMap<String,List<String>>();
		map.put("Cruiser", locationList);
		
		return map.entrySet();
	}
}
