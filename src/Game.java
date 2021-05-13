/***
 * Game class
 * @author William McGovern-Fagg
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.time.LocalDate;

public class Game {
	private Player player1;
	private Player player2;
	protected Board board1;
	protected Board board2;
	private JMenuItem quitButton, helpButton, sourceButton, newFileButton, saveButton, saveAsButton, openButton;
	private JFrame frame = new JFrame();
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		createGUI();
	}
	
	public void setPlayers(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		createGUI();
	}
	
	private void createGUI() {
		sourceButton = new JMenuItem("Source");
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		menuBar = new JMenuBar();
		
		frame.setTitle("Battleship");
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
		
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
