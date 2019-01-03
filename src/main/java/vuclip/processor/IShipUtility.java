package vuclip.processor;

import java.util.List;

import vuclip.domainObjects.IShip;

public interface IShipUtility {
	
	List<String> addShip(IShip ship );
	
	boolean isHit(int row,int column);
	
	int returnColumnIndex(char columnChar);

}
