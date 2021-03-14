
public class Submarine extends Ship {
	
	public Submarine() {
		super(3);
	}
	
	@Override
	/***
	 * Draw sunken Submarine
	 */
	public void drawSunkenShip() {
		System.out.println("Submarine has been sunk");
	}
}
