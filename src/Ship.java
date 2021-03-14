
public abstract class Ship extends GameObject {
	private int length;
	private boolean isSunk = false;
	private int coordx;
	private int coordy;
	
	/***
	 * Constructor
	 * @param type type of ship
	 */
	public Ship(int length) {
		this.length = length;
	}
	
	/***
	 * Check if ship is sunk
	 * @return
	 */
	public boolean isSunk() {
		return isSunk;
	}
	
	/***
	 * Sink ship
	 */
	public void sink() {
		isSunk = true;
	}

	/***
	 * Set x coordinate
	 * @param x x coord
	 */
	public void setXCoord(int x) {
		this.coordx = x;
	}
	
	/***
	 * Set y coordinate
	 * @param y y coord
	 */
	public void setYCoord(int y) {
		this.coordy = y;
	}
	
	/***
	 * Return x coordinate
	 * @return
	 */
	public int getXCoord() {
		return coordx;
	}
	
	/***
	 * Return y coordinate
	 */
	public int getYCoord(){
		return coordy;
	}
	
	public abstract void drawSunkenShip();
	
}
