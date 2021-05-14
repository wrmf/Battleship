
public abstract class Player {
	public Player() {
		
	}
	
	public abstract Location getNextMove(Board board, Location location);
	
	public abstract Board placeShips(Board board);
}
