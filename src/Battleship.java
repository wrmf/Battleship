
public class Battleship extends Ship {

	public Battleship(Location location) {
		super(location);
	}
	
	@Override
	public String draw(Location location) {
		if(isHit()) {
			return "B ";
		}
		else {
			return ". ";
		}
	}

}
