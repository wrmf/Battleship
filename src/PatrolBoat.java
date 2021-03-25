
public class PatrolBoat extends Ship {

	public PatrolBoat(Location location) {
		super(location);
	}
	
	public PatrolBoat(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String draw() {
		if(isHit()) {
			return "P ";
		}
		else {
			return ". ";
		}
	}

}
