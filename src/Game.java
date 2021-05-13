
public class Game {
	private Player player1;
	private Player player2;
	protected Board board1;
	protected Board board2;
	
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void setPlayers(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void play() {
		board1 = player1.placeShips(new Board());
		board2 = player2.placeShips(new Board());
		while(!isGameOver()) {
			board1.fire(player1.getNextMove(board1));
			board2.fire(player2.getNextMove(board1));
		}
	}
	
	public boolean isGameOver() {
		if(board1.areAllShipsSunk() || board2.areAllShipsSunk()) {
			printWinner();
			return true;
		}
		
		return false;
	}
	
	public void printWinner() {
		if(board1.areAllShipsSunk()) {
			System.out.println("Player 1 won");
		} else {
			System.out.println("Player 2 won");
		}
	}
}
