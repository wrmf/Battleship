
public abstract class Ship extends GamePiece {

	public Ship(Location location) {
		super(location);
	}
	
	public Ship(int x, int y) {
		super(x, y);
	}
	
	@Override
	public abstract String draw();

}
