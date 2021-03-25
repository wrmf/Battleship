
public abstract class Player {
	public Player() {
		
	}
	
	public abstract Location getNextMove(Board board);
	
	public abstract Board placeShips(Board board);
}
