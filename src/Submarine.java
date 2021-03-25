
public class Submarine extends Ship {

	public Submarine(Location location) {
		super(location);
	}
	
	public Submarine(int x, int y) {
		super(x, y);
	}
	
	
	@Override
	public String draw() {
		if(isHit()) {
			return "U ";
		}
		else {
			return ". ";
		}
	}

}
