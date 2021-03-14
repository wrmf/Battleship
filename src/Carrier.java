
public class Carrier extends Ship {
	
	public Carrier() {
		super(5);
	}
	
	@Override
	/***
	 * Draw sunken carrier
	 */
	public void drawSunkenShip() {
		System.out.println("Carrier has been sunk");
	}
}
