
public class Test {
	public static void main(String[] args) {
		Game game = new Game(new RandomPlayer(), new RandomPlayer());
		game.play();
	}
}
