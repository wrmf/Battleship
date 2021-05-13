/***
 * Board class
 * @author William McGovern-Fagg
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Board {
	public GamePiece[][] board;
	private int size = 8;
	
	public Board(int size) {
		this.size = size;
		this.board = new GamePiece[size][size];
	}
	
	public Board() {
		this.board = new GamePiece[size][size];
	}
	
	/***
	 * Check if move is valid
	 * @param location location to check
	 * @return true if valid, false if not
	 */
	public boolean isValidMove(Location location) {
		if(board[location.getRow()][location.getCol()].isWater() && !board[location.getRow()][location.getCol()].isMiss() && 
				!board[location.getRow()][location.getCol()].isHit()) {
			return true;
		} else {
			return false;
		}
	}
	
	/***
	 * Check if move is valid
	 * @param int x locationx to check
	 * @param int y locationy to check
	 * @return true if valid, false if not
	 */
	public boolean isValidMove(int x, int y) {
		if(board[x][y].isWater() && !board[x][y].isMiss() && 
				!board[x][y].isHit()) {
			return true;
		} else {
			return false;
		}
	}
	
	/***
	 * Check if all ships are sunk on board
	 * @return true if all ships are sunk, false if not
	 */
	public boolean areAllShipsSunk() {
		for(int counterRows = 0; counterRows < board.length; counterRows ++) {
			for(int counterCols = 0; counterCols < board.length; counterCols++) {
				if(board[counterRows][counterCols].isShip()) {
					if(!board[counterRows][counterCols].isHit()) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/***
	 * Get number of rows in the board
	 * @return rows as int
	 */
	public int getNumRows() {
		return size;
	}
	
	/***
	 * Get number of columns in the board
	 * @return size
	 */
	public int getNumCols() {
		return size;
	}
	
	/***
	 * Get size of square board
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/***
	 * Check if Location is water
	 * @param location location to check
	 * @return true if water, false if not
	 */
	public boolean isWater(Location location) {
		return board[location.getRow()][location.getCol()].isWater();
	}
	
	/***
	 * Check if a location x, y is water
	 * @param x X coord
	 * @param y Y coord
	 * @return true if water, false if not
	 */
	public boolean isWater(int x, int y) {
		return board[x][y].isWater();
	}
	
	/***
	 * Fire shot
	 * @param location
	 * @return
	 */
	public boolean fire(Location location) {
		board[location.getRow()][location.getCol()].takeHit(); //Fire at location
		//Check if it was a hit or miss for return
		if(board[location.getRow()][location.getCol()].isHit()) {
			return true;
		} else {
			return false;
		}
	}
	
	/***
	 * Print board to file
	 * @param fileName file to print to
	 * @throws IOException
	 */
	public void toFile(String fileName) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fileName, true);
			PrintWriter printWriter = new PrintWriter(fileWriter); //create new printWriter
			
		    
		    //Print board
		    for(int counterRows = 0; counterRows < board.length; counterRows++) {
		    	for(int counterCols = 0; counterCols < board.length; counterCols++) {
		    		printWriter.print(board[counterRows][counterCols].draw()+" ");
		    	}
		    	printWriter.println(); //Line break
		    }
		    
		    printWriter.println(); //Extra line at end
		    
		    printWriter.close();
		    fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
