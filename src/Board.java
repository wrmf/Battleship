import java.util.Random;

public class Board {
	private char[][] charArray;
	private char water = '-';
	private char ship = '#';
	private char hit = 'X';
	private char miss = '*';
	
	public Board(char[][] charArray) {
		this.charArray = charArray;
	}
	
	public Board() {
		charArray = new char[8][8];
		resetBoard();
	}
	
	/***
	 * fill an empty board
	 */
	public void fillBoard() {
		Random random = new Random();
		Carrier carrier = new Carrier();
		Battleship battleship = new Battleship();
		Destroyer destroyer = new Destroyer();
		Submarine sub = new Submarine();
		PatrolBoat pboat = new PatrolBoat();
		boolean orientation; //True for upright, false for sideways
		int locationx;
		int locationy;
		
		while(checkNumChar('#') != 17) {
			
			resetBoard();
			
			orientation = random.nextBoolean();
			locationx = random.nextInt(7);
			locationy = random.nextInt(7);
			drawShip(5, locationx, locationy, random, orientation);
			
			orientation = random.nextBoolean();
			locationx = random.nextInt(7);
			locationy = random.nextInt(7);
			drawShip(4, locationx, locationy, random, orientation);
			
			orientation = random.nextBoolean();
			locationx = random.nextInt(7);
			locationy = random.nextInt(7);
			drawShip(3, locationx, locationy, random, orientation);
			
			orientation = random.nextBoolean();
			locationx = random.nextInt(7);
			locationy = random.nextInt(7);
			drawShip(3, locationx, locationy, random, orientation);
			
			orientation = random.nextBoolean();
			locationx = random.nextInt(7);
			locationy = random.nextInt(7);
			drawShip(2, locationx, locationy, random, orientation);
		}
			
			
		for(int i = 0; i < charArray.length; i++) {
			for(int x = 0; x < charArray.length; x++) {
				System.out.print(charArray[i][x]+" ");
			}
			System.out.println();
		}
	}
	
	/***
	 * Mark a space as a hit
	 * @param x x coord
	 * @param y y coord
	 */
	private void markHit(int x, int y) {
		charArray[x][y] = 'H';
	}
	
	/***
	 * Mark a space as a miss
	 * @param x x coord
	 * @param y y coord
	 */
	private void markMiss(int x, int y) {
		charArray[x][y] = 'M';
	}
	
	/***
	 * Return the state of a location in (x, y)
	 * @param x x coord
	 * @param y y coord
	 * @return state of location
	 */
	public char getState(int x, int y) {
		return this.charArray[x][y];
	}
	
	/***
	 * Check if board was a hit or miss
	 * @param board
	 * @param x
	 * @param y
	 */
	public boolean checkHit(Board board, int x, int y) {
		if(board.getState(x, y) == '#') {
			markHit(x, y);
			return true;
		}
		else {
			markMiss(x, y);
			return false;
		}
	}
	
	/***
	 * Draw a ship
	 * @param length
	 * @param locationx
	 * @param locationy
	 * @param random
	 * @param orientation
	 * @param charArray
	 * @return
	 */
	private void drawShip(int length, int locationx, int locationy, Random random, boolean orientation) {
		/***
		 * Draw carrier
		 */
		if(orientation) {
			if(length == 5) {
				while(locationy < 2 || locationy > 5) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy+2] = '#';
				charArray[locationx][locationy+1] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy-1] = '#';
				charArray[locationx][locationy-2] = '#';
			} else if(length == 4) {
				while(locationy < 1 || locationy > 5) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy+1] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy-1] = '#';
				charArray[locationx][locationy+2] = '#';
			}	else if(length == 3) {
				while(locationy < 1 || locationy > 6) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy+1] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy-1] = '#';
			} else if(length == 2) {
				while(locationy < 0 || locationy > 6) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy+1] = '#';
			}
		}
		else {
			if(length == 5) {	
				while(locationx < 2 || locationx > 5) {
					locationx = random.nextInt(7);
				}
				charArray[locationx+2][locationy] = '#';
				charArray[locationx+1][locationy] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx-1][locationy] = '#';
				charArray[locationx-2][locationy] = '#';
			} else if(length == 4) {
				while(locationy < 1 || locationy > 5) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy+1] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy-1] = '#';
				charArray[locationx][locationy+2] = '#';
			} else if(length == 3) {
				while(locationy < 1 || locationy > 6) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy+1] = '#';
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy-1] = '#';
			} else if(length == 2) {
				while(locationy < 0 || locationy > 6) {
					locationy = random.nextInt(7);
				}
				charArray[locationx][locationy] = '#';
				charArray[locationx][locationy+1] = '#';
			}
		}
	}
	
	private int checkNumChar(char Char) {
		int num = 0;
		for(int i = 0; i < charArray.length; i++) {
			for(int x = 0; x < charArray.length; x++) {
				if(charArray[i][x] == '#') {
					num++;
				}
			}
		}
		return num;
	}
	
	public void resetBoard() {
		for(int counter1 = 0; counter1 < 8; counter1++) {
			for(int counter2 = 0; counter2 < 8; counter2++) {
				charArray[counter1][counter2] = water;
			}
		}
	}
}
