/***
 *  * Random player class
 * @author William McGovern-Fagg
 */

import java.util.Random;

public class RandomPlayer extends Player {
	
	private int maxTries = 50;

	/***
	 * Get location to move next
	 * @param board to see if chosen move is valid
	 */
	@Override
	public Location getNextMove(Board board) {
		Location location = new Location();
		Random random = new Random();
		for(int i = 0; i < maxTries; i ++) {
			location.setRow(random.nextInt(board.getNumRows()));
			location.setCol(random.nextInt(board.getNumCols()));
			if(board.isValidMove(location)) {
				return location;
			}
		}
		
		return location;
	}
	
	/***
	 * Place all ships on board
	 * @param board to place ships on
	 */
	@Override
	public Board placeShips(Board board) {
		Location location = new Location();
		Random random = new Random();
		
		for(int i = 0; i < board.getNumRows(); i ++) {
			for(int x = 0; x < board.getNumCols(); x ++) {
				location.setRow(i);
				location.setCol(x);
				board.board[i][x] = new Water(location);
			}
		}
		
		board = placeShip(board, random, 5, random.nextBoolean(), location);
		board = placeShip(board, random, 4, random.nextBoolean(), location);
		board = placeShip(board, random, 3, random.nextBoolean(), location);
		board = placeShip(board, random, 3, random.nextBoolean(), location);
		board = placeShip(board, random, 2, random.nextBoolean(), location);
		
		return board;
		
	}
	
	/***
	 * Place a ship on board with certain length
	 * @param board board to change
	 * @param random random used to determine location
	 * @param length length of ship
	 * @param direction vertical or horizontal
	 * @param location location variable so I don't have to new it every time
	 * @return
	 */
	public Board placeShip(Board board, Random random, int length, boolean direction, Location location) {
		boolean isPlaced = false;
		
		if(direction) {
			if(length >= 5) {
				location.setRow(random.nextInt(3));
			} else if(length == 4) {
				location.setRow(random.nextInt(4));
			} else if(length == 3) {
				location.setRow(random.nextInt(5));
			} else if(length <= 2) {
				location.setRow(random.nextInt(6));
			}
			
			
			location.setCol(random.nextInt(7));
			while(!isPlaced) {
				if(board.isWater(location) && board.isWater(location.getRow()+1, location.getCol()) 
						&& board.isWater(location.getRow()+length-1, location.getCol())) {
					for(int i = 0; i < length; i ++) {
						if(length >= 5) {
							board.board[i][location.getCol()] = new Carrier(i, location.getCol());
						} else if(length == 4) {
							board.board[i][location.getCol()] = new Battleship(i, location.getCol());
						} else if(length == 3) {
							board.board[i][location.getCol()] = new Submarine(i, location.getCol());
						} else if(length <= 2) {
							board.board[i][location.getCol()] = new PatrolBoat(i, location.getCol());
						}
					}
					
					isPlaced = true;
				}
			}
		} else {
			if(length >= 5) {
				location.setCol(random.nextInt(3));
			} else if(length == 4) {
				location.setCol(random.nextInt(4));
			} else if(length == 3) {
				location.setCol(random.nextInt(5));
			} else if(length <= 2) {
				location.setCol(random.nextInt(6));
			}
			
			
			location.setRow(random.nextInt(7));
			while(!isPlaced) {
				if(board.isWater(location) && board.isWater(location.getRow(), location.getCol()+1) 
						&& board.isWater(location.getRow(), location.getCol()+length-1)) {
					for(int i = 0; i < length; i ++) {
						if(length >= 5) {
							board.board[location.getRow()][i] = new Carrier(i, location.getCol());
						} else if(length == 4) {
							board.board[location.getRow()][i] = new Battleship(location.getRow(), i);
						} else if(length == 3) {
							board.board[location.getRow()][i] = new Submarine(location.getRow(), i);
						} else if(length <= 2) {
							board.board[location.getRow()][i] = new PatrolBoat(location.getRow(), i);
						}
					}
					
					isPlaced = true;
				}
			}
		}
		
		return board;
	}
	
	/***
	 * Set max tries for getting next move
	 * @param maxTries max times to try for a valid move before erroring
	 */
	public void setMaxTries(int maxTries) {
		this.maxTries = maxTries;
	}
	
	/***
	 * Get max number of tries for getting next move
	 * @return maxTries
	 */
	public int getMaxTries() {
		return maxTries;
	}

}
