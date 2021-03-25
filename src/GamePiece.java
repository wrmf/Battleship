
public abstract class GamePiece extends Board {
	private Location coordinant;
	private boolean isHit;
	
	public GamePiece(Location coordinant) {
		this.coordinant = coordinant;
		isHit = false;
	}
	
	public GamePiece(int x, int y) {
		this.coordinant = new Location(x, y);
		isHit = false;
	}
	
	public abstract String draw();
	
	public void takeHit() {
		isHit = true;
	}
	
	public boolean isHit() {
		return isHit;
	}
}
