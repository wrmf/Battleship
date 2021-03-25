
public class Carrier extends Ship {

	public Carrier(Location location) {
		super(location);
	}
	
	public Carrier(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String draw() {
		if(isHit()) {
			return "C ";
		}
		else {
			return ". ";
		}
	}

}
