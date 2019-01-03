package vuclip.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import vuclip.domainObjects.IShip;

public class ShipUtility implements  IShipUtility{
	private int gameGrid  [][] = new int[10][10];
	private IShip ship;

	public ShipUtility() {

	}

	/**
	 * add ship on grid 
	 * @param ship - ship to be added on grid
	 * @return - list of ship Location
	 */
	public List<String> addShip(IShip ship) {
		this.ship = ship;
		List<String> shipLocation = placeShipOnGrid(findRandomNumber(1, 3));
		//Mark ship position on grid
		for(String square : shipLocation) {
			int rowIndex = 0;
			if(square.length()>2) {
				rowIndex =(Integer.parseInt(square.substring(1, square.length())))-1;
			}else {
				rowIndex = (Integer.parseInt(square.charAt(1)+""))-1;
			}
			gameGrid[rowIndex][returnColumnIndex(square.charAt(0))]=1;
		}
		
		return shipLocation;
	}
	/*
	 * find random number to decide 
	 * 1. place ship horizontally or vertically . If 1 then vertically else horizontally
	 * 2. grid square where ship is placed  
	 */
	private Integer findRandomNumber(Integer min, Integer max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	/*
	 * place ship on Grid.
	 * If ship is not fit vertically the then try to fit Horizontally. 
	 * If still not fit then repeat process until its fit on grid  
	 */
	private List<String> placeShipOnGrid(Integer verticalOrHorizantal){
		List<String> shipLocationList = new ArrayList<String>();
		if(verticalOrHorizantal == 1) {
			// try to place ship vertically 
			Integer firstSquareCol = findRandomNumber(1, 11)-1;
			Integer firstSquareRow = findRandomNumber(1, 11)-1;
			
			shipLocationList = growVertically(firstSquareCol, firstSquareRow);
			// ship is not fit at given square vertically then try to fit horizontally 
			if(this.ship.shipSize() > shipLocationList.size()) {
				shipLocationList = growHorizontally(firstSquareCol, firstSquareRow);
			}
			
		}else {
			// try to place ship horizontally 
			Integer firstSquareCol = findRandomNumber(1, 11)-1;
			Integer firstSquareRow = findRandomNumber(1, 11)-1;
			
			shipLocationList = growHorizontally(firstSquareCol, firstSquareRow);
			if(this.ship.shipSize() > shipLocationList.size()) {
				shipLocationList = growVertically(firstSquareCol, firstSquareRow);
			}
						
		}
		//call ship placing method recursively until it is fit on grid 
		if(this.ship.shipSize() > shipLocationList.size()) {
			shipLocationList = placeShipOnGrid(findRandomNumber(1,3));
		}
		return shipLocationList;
		
	}
	/*
	 * Place ship vertically and return ship's Grid squares
	 * start placing ship from randomly selected square index and grow towards higher index until it reaches its length
	 * if ship cannot grow towards higher index then try to grow on lower index
	 * else exit
	 */
	private List<String> growVertically(Integer columnIndex, Integer rowIndex){
		final Integer lengthofShip = ship.shipSize();
		final List<String> shipSquares = new ArrayList<String>();
		boolean changeDirection = false;
		shipSquares.add(getSquareIdentifier(rowIndex, columnIndex));
		
		for(int row = rowIndex+1; row< 10 && row >=0 ;) {
			if(  this.gameGrid[row][columnIndex]!=1 && !changeDirection) {
				
				if(shipSquares.size() == lengthofShip) {
					break;
				}else {
					shipSquares.add(getSquareIdentifier( row,columnIndex));
					row++;
				}
			}else {
				row = rowIndex - 1;
				changeDirection = true;
				if(row < 0 || this.gameGrid[row][columnIndex]==1
						||shipSquares.size() == lengthofShip) {
					break;
				}else {
					row--;
				}
			}
		}
		return shipSquares;
	}
	/*
	 * Place ship horizontally and return Ship's grid squares 
	 * start placing ship from randomly selected square index and grow towards higher index until it reaches its length
	 * if ship cannot grow towards higher index then try to grow on lower index
	 * else exit
	 */
	private List<String> growHorizontally(Integer columnIndex, Integer rowIndex){
		final Integer lengthofShip = ship.shipSize();
		final List<String> shipSquares = new ArrayList<String>();
		boolean changeDirection = false;
		shipSquares.add(getSquareIdentifier(rowIndex, columnIndex));
		
		for(int col = columnIndex+1; col< 10 && col >=0 ;) {
			if(  this.gameGrid[rowIndex][col]!=1 && !changeDirection) {
				
				if(shipSquares.size() == lengthofShip) {
					break;
				}else {
					shipSquares.add(getSquareIdentifier(rowIndex, col));
					col++;
				}
			}else {
				col = columnIndex - 1;
				changeDirection = true;
				if(col < 0 || this.gameGrid[rowIndex][col]==1
						||shipSquares.size() == lengthofShip) {
					break;
				}else {
					col--;
				}
			}
		}
		return shipSquares;
	}
	/*
	 * convert grid square index into string which in same format like input
	 */
	private String getSquareIdentifier(Integer rowIndex, Integer colIndex) {
		char alphabetStart = 'A';
		char colAlphabet = (char)((int)alphabetStart + (colIndex));
		return colAlphabet +""+(rowIndex+1);
	}
	/**
	 * check if Ship is hit
	 * @param row - row array index
	 * @param column - column array index
	 * @return - true if hit else false
	 */
	public boolean isHit(int row, int column) {
		if(this.gameGrid[row][column]==1) {
			return true;
		}
		return false;
	}
	/**
	 * convert input column character into array index
	 * @param columChar - input column char
	 * @return - array column index
	 */
	public int returnColumnIndex(char columnChar) {
		int columnNumber = 0;
		switch (columnChar) {
		case 'B':
			columnNumber = 1;
			break;
		case 'C':
			columnNumber = 2;
			break;
		case 'D':
			columnNumber = 3;
			break;
		case 'E':
			columnNumber = 4;
			break;
		case 'F':
			columnNumber = 5;
			break;
		case 'G':
			columnNumber = 6;
			break;
		case 'H':
			columnNumber = 7;
			break;
		case 'I':
			columnNumber = 8;
			break;
		case 'J':
			columnNumber = 9;
			break;
		}
		
		return columnNumber;
	}
	
	

}
