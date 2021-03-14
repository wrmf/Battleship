
public class Destroyer extends Ship {
	
	public Destroyer() {
		super(3);
	}
	
	@Override
	/***
	 * Draw sunken Battleship
	 */
	public void drawSunkenShip() {
		System.out.println("Destroyer has been sunk");
	}
}
