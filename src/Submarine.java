
public class Submarine extends Ship {

	public Submarine(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "U ";
		}
		else {
			return ". ";
		}
	}

}
