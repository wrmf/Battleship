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

	public boolean isWater() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
