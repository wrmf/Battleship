
public abstract class Game {
	private Player player1;
	private Player player2;
	protected Board board1;
	protected Board board2;
	
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		board1 = new Board();
		board2 = new Board();
	}
	
	public void play(Player player) {
		while(!isGameOver()) {
			
		}
	}
	
	public boolean isGameOver() {
		if(board1.areAllShipsSunk() || board2.areAllShipsSunk()) {
			return true;
		}
		
		return false;
	}
}
