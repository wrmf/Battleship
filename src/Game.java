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
	private JPanel southPanel, northPanel, middlePanel, eastPanel, westPanel;
	private JButton startButton, fireButton;
	private ButtonGroup buttonGroup1, buttonGroup2;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		board1 = player1.placeShips(new Board());
		board2 = player2.placeShips(new Board());
		createGUI();
	}
	
	/***
	 * Create the GUI for battleship
	 */
	private void createGUI() {
		sourceButton = new JMenuItem("Source");
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		menuBar = new JMenuBar();
		southPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		startButton = new JButton("Start Game");
		fireButton = new JButton("Fire");
		buttonGroup1 = new ButtonGroup();
		
		
		JButton[][] board1buttons = new JButton[8][8];
		JButton[] board2buttons = new JButton[64];
		
		southPanel.setLayout(new FlowLayout());
		southPanel.add(startButton);
		southPanel.add(fireButton);
		frame.add(southPanel, BorderLayout.SOUTH);
		westPanel.setLayout(new GridLayout(8, 8));
		eastPanel.setLayout(new GridLayout(8, 8));
		frame.add(eastPanel, BorderLayout.EAST);
		frame.add(westPanel, BorderLayout.WEST);
		
		for(int i = 0; i < board1.board.length; i++) {
			for(int j = 0; j < board1.board.length; j++) {
				board1buttons[i][j] = new JButton(board1.board[i][j].draw());
				board1buttons[i][j].setBackground(Color.BLUE);
				buttonGroup1.add(board1buttons[i][j]);
				westPanel.add(board1buttons[i][j]);
			}
		}
		
		//eastPanel.add(board2buttons);
		
		frame.setTitle("Battleship");
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
        quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}	
		});	
        
		//Source button opens github
		sourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://github.com/wrmf/Battleship").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//fire button
		fireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int counterRows = 0; counterRows < board1.board.length; counterRows++) {
					for(int counterCols = 0; counterCols < board1.board.length; counterCols++) {
						if(board1buttons[counterRows][counterCols].isSelected()) {
							if(board1.fire(player1.getNextMove(board1, new Location(counterRows, counterCols)))) {
								board1buttons[counterRows][counterCols].setBackground(Color.RED);
							} else {
								board1buttons[counterRows][counterCols].setBackground(Color.WHITE);
							}
							board1buttons[counterRows][counterCols].setText(board1.board[counterRows][counterCols].draw());
							frame.setVisible(true);
						}
					}
				}
			}
		});
		
		//Source button opens github
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play();
			}
		});
		
		//Help button gives some amount of help
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sink all of the enemy's ships to win","Help", JOptionPane.NO_OPTION);
			}
		});
		
	}
	
	public void play() {
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
