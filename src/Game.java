/***
 * Game class
 * @author William McGovern-Fagg
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
	private Player player1;
	private Player player2;
	protected Board board1;
	protected Board board2;
	
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void setPlayers(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void play() {
		board1 = player1.placeShips(new Board());
		board2 = player2.placeShips(new Board());
		
		File logs1 = new File("battleship_logs1.txt"); 
		File logs2 = new File("battleship_logs2.txt"); 
		logs1.delete();
		logs2.delete();
		
		board1.toFile("battleship_logs1.txt");
		board2.toFile("battleship_logs2.txt");
		
		while(!isGameOver()) {
			board1.fire(player1.getNextMove(board1));
			board1.toFile("battleship_logs1.txt");
			board2.fire(player2.getNextMove(board2));
			board2.toFile("battleship_logs2.txt");
		}
		board1.toFile("battleship_logs1.txt");
		board2.toFile("battleship_logs2.txt");
	}
	
	/***
	 * Check if game is over
	 * @return
	 */
	public boolean isGameOver() {
		if(board1.areAllShipsSunk() || board2.areAllShipsSunk()) {
			printWinner();
			return true;
		}
		
		return false;
	}
	
	/***
	 * Figure out who won
	 */
	public void printWinner() {
		if(board1.areAllShipsSunk()) {
			System.out.println("Player 2 won");
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("battleship_logs2.txt", true);
				PrintWriter printWriter = new PrintWriter(fileWriter); //create new printWriter
				printWriter.println("*************WINNER*************");
				printWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Player 1 won");
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("battleship_logs1.txt", true);
				PrintWriter printWriter = new PrintWriter(fileWriter); //create new printWriter
				printWriter.println("*************WINNER*************");
				printWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
