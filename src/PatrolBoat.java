
public class PatrolBoat extends Ship {

	public PatrolBoat(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "P ";
		}
		else {
			return ". ";
		}
	}

}
