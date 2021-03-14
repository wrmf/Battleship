
public class Battleship extends Ship {
	
	public Battleship() {
		super(4);
	}
	
	@Override
	/***
	 * Draw sunken Battleship
	 */
	public void drawSunkenShip() {
		System.out.println("Battleship has been sunk");
	}
}
