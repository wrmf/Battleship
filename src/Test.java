
public class Test {
	public static void main(String[] args) {
		Game game = null;
		game.setPlayers(new RandomPlayer(), new RandomPlayer());
		game.play();
	}
}
