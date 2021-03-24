
public abstract class Ship extends GamePiece {

	public Ship(Location location) {
		super(location);
	}
	@Override
	public abstract String draw(Location location);

}
