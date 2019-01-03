package vuclip.domainObjects;

import vuclip.processor.ShipProcessor;

public class User {
	private String name;
	
	private ShipProcessor shipProcessor;
	
	private Integer correctHit;
	
	private Integer hitCount = 0;
	
	private Integer missCount = 0 ;
	
	
	public User(String name) {
		this.name = name;
		this.shipProcessor = new ShipProcessor();
	}

	public String getName() {
		return name;
	}

	public ShipProcessor getShipProcessor() {
		return shipProcessor;
	}

	public Integer getCorrectHit() {
		return correctHit;
	}

	public void setCorrectHit(Integer correctHit) {
		this.correctHit = correctHit;
	}

	public void addHitCount() {
		this.hitCount ++;
	}

	public void addMissCount() {
		this.missCount ++;
	}
	
	
	
}
