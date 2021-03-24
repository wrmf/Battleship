
public class Water extends GamePiece {

	public Water(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "W ";
		} else {
			return ". ";
		}
	}

}
