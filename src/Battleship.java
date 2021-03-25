
public class Battleship extends Ship {

	public Battleship(Location location) {
		super(location);
	}
	
	public Battleship(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String draw() {
		if(isHit()) {
			return "B ";
		}
		else {
			return ". ";
		}
	}

}
