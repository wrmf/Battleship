
public class Carrier extends Ship {

	public Carrier(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "C ";
		}
		else {
			return ". ";
		}
	}

}
