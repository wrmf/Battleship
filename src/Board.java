/***
 * Board class
 * @author William McGovern-Fagg
 *
 */
public abstract class Board extends Game {
	protected GamePiece[][] board;
	
	public Board() {
		this.board = new GamePiece[8][8];
	}
	
	public boolean isValidMove(Location location) {
		
	}
	
	public boolean areAllShipsSunk() {
		
	}
	
}
