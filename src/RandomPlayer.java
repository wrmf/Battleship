/***
 * Random player class
 * @author William McGovern-Fagg
 */

import java.util.Random;

public class RandomPlayer extends Player {
	
	private static int maxTries = 10;

	@Override
	public Location getNextMove(Board board) {
		Location location = new Location();
		Random random = new Random();
		for(int i = 0; i < maxTries; i ++) {
			location.setRow(random.nextint(board.getNumRows()));
			location.setCol(random.nextInt(board.getNumCols()));
			if(board.isValidMove(location)) {
				return location;
			}
		}
		
		return location;
	}

}
