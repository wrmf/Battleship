
public class PatrolBoat extends Ship {
	
	public PatrolBoat() {
		super(2);
	}
	
	@Override
	/***
	 * Draw sunken Submarine
	 */
	public void drawSunkenShip() {
		System.out.println("Patrol Boat has been sunk");
	}
}
