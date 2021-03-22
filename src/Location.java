/***
 * Location class
 * @author William McGovern-Fagg
 *
 */
public class Location {
	private int row;
	private int col;
	
	/***
	 * Constructor
	 * @param row x coord
	 * @param col y coord
	 */
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Location() {
		this.row = 0;
		this.col = 0;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}
	

	/***
	 * Get row
	 * @return
	 */
	public int getRow() {
		return this.row;
	}
	
	/***
	 * Get col
	 * @return
	 */
	public int getCol() {
		return this.col;
	}
	
	
	
	/***
	 * Check if one coord is equal to another
	 * @param loc
	 * @return
	 */
	public boolean equals(Location loc) {
		if(this.row == loc.getRow() && this.col == loc.getCol()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
