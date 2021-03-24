
public abstract class GamePiece extends Board {
	private Location coordinant;
	private boolean isHit;
	
	public GamePiece(Location coordinant) {
		this.coordinant = coordinant;
		isHit = false;
	}
	
	public abstract String draw(Location location);
	
	public void takeHit(Location location) {
		isHit = true;
	}
	
	public boolean isHit() {
		return isHit;
	}
}
