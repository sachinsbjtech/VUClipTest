package vuclip.vuclipTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import vuclip.domainObjects.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Welcome to Ship Destroyer");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Enter 1st User Name :");
    	String firstUserName = br.readLine();
    	User firstUser = new User(firstUserName);
    	
    	System.out.println("Enter 2nd User Name :");
    	String secondUserName = br.readLine();
    	User secondUser = new User(secondUserName);
    	
    	//Load User's Grid
    	System.out.println("Wait..Ships are being loaded for :"+firstUserName);
    	firstUser.getShipProcessor().loadShipOnGrid();
    	System.out.println("Wait..Ships are being loaded for :"+secondUserName);
    	secondUser.getShipProcessor().loadShipOnGrid();
    	
    	User firstTurn, secondTurn;
    	
    	// decide which player will play first
    	if(decidePlayerTurn()==1) {
    		firstTurn = firstUser;
    		secondTurn = secondUser;
    	}else{
    		firstTurn = secondUser;
    		secondTurn = firstUser;
    	}
    	
    	// infinite loop until someone wins
    	while(true) {
    		//First Player Turn. Hit Second turn User's Grid 
    		System.out.println("Player "+firstTurn.getName()+"'s turn. Please enter Command:");
    		String firstUserCommand = br.readLine();
    		if(!secondTurn.getShipProcessor().isShipHit(firstUserCommand)) {
    			System.out.println("Target Missed");
    			firstTurn.addMissCount();
    		}else {
    			firstTurn.addHitCount();
    		}
    		
    		if(secondTurn.getShipProcessor().AreAllShipsSinked()) {
    			System.out.println("Player "+firstTurn.getName()+" Won !!!");
    			System.exit(0);
    		}
    		
    		//Second Player Turn. Hit First turn user's Grid
    		System.out.println("Player "+secondTurn.getName()+"'s turn. Please enter Command:");
    		String secondUserCommand = br.readLine();
    		if(!firstTurn.getShipProcessor().isShipHit(secondUserCommand)) {
    			System.out.println("Target Missed");
    			secondTurn.addMissCount();
    		}else {
    			secondTurn.addHitCount();
    		}
    		if(firstTurn.getShipProcessor().AreAllShipsSinked()) {
    			System.out.println("Player "+secondTurn.getName()+" Won !!!");
    			System.exit(0);
    		}
    		
    		//
    	}
    }
    
    /*
     * this will decide turn which player should play first
     */
    private static int decidePlayerTurn() {
		return ThreadLocalRandom.current().nextInt(1, 3);
	}
    
}
