
public class Destroyer extends Ship {

	public Destroyer(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "D ";
		}
		else {
			return ". ";
		}
	}

}
