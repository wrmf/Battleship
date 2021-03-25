/***
 * Board class
 * @author William McGovern-Fagg
 *
 */
public abstract class Board {
	public GamePiece[][] board;
	private int size = 8;
	
	public Board(int size) {
		this.size = size;
		this.board = new GamePiece[size][size];
	}
	
	public Board() {
		this.board = new GamePiece[size][size];
	}
	
	public boolean isValidMove(Location location) {
		
	}
	
	public boolean areAllShipsSunk() {
		
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
	 * Check if a certain location is water
	 * @param location input coord (x, y)
	 * @return true if water, false if not
	 */
	public boolean isWater(Location location) {
		if(board[location.getRow()][location.getCol()].draw() == "W ") {
			return true;
		} else {
			return false;
		}
	}
	
	/***
	 * Check if a certain location is water
	 * @param location input coord (x, y)
	 * @return true if water, false if not
	 */
	public boolean isWater(int x, int y) {
		if(board[x][y].draw() == "W ") {
			return true;
		} else {
			return false;
		}
	}
	
}
