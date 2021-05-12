
public abstract class GamePiece extends Board {
	private Location coordinate;
	private boolean isHit;
	private boolean isMiss;
	
	/***
	 * Constructor
	 * @param coordinate duplicate coordinate
	 */
	public GamePiece(Location coordinate) {
		this.coordinate = coordinate;
		isHit = false;
	}
	
	/***
	 * Constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public GamePiece(int x, int y) {
		this.coordinate = new Location(x, y);
		isHit = false;
	}
	
	/***
	 * Draw piece
	 * @return
	 */
	public abstract String draw();
	
	/***
	 * Check if there is water
	 * @return true if water, false if not
	 */
	public abstract boolean isWater() ;
	
	/***
	 * Check if there is a ship at location
	 * @return true if ship, false if not
	 */
	public abstract boolean isShip();
	
	/***
	 * Take a hit
	 */
	public void takeHit() {
		if(this.isWater()) {
			isMiss = true;
			isHit = false;
		} else {
			isHit = true;
			isMiss = false;
		}
	}
	
	/***
	 * Check if the piece is hit
	 * @return
	 */
	public boolean isHit() {
		return isHit;
	}
	
	/***
	 * Check if the piece is a miss
	 * @return
	 */
	public boolean isMiss() {
		return isMiss;
	}
	
	
}
