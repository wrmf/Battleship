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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.time.LocalDate;

public class Game {
	
	private Player player1;
	private Player player2;
	protected Board board1;
	protected Board board2;
	private JMenuItem quitButton, helpButton, sourceButton;
	private JFrame frame;
	private JMenu fileMenu, helpMenu;
	private JMenuBar menuBar;
	private JPanel southPanel, northPanel, middlePanel, eastPanel, westPanel;
	private JButton startButton, fireButton;
	private ButtonGroup buttonGroup1, buttonGroup2;
	private JLabel label1, label2;
	JButton[][] board1buttons;
	JButton[][] board2buttons;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		board1 = player1.placeShips(new Board());
		board2 = player2.placeShips(new Board());
		createGUI();
	}
	
	/***
	 * Special listener class
	 * @author william
	 *
	 */
	private class fireListener implements ActionListener {
		
		public int row;
		public int col;
		Board board;
		JButton button;

		public fireListener(int row, int col, JButton button) {
			this.row = row;
			this.col = col;
			this.board = board1;
			this.button = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(isGameOver()) {
				setButtonsEnabled(board1buttons, false);
				JOptionPane.showMessageDialog(null, "Game over! Player2 won!","Game Over", JOptionPane.NO_OPTION);
			} else {
			
				boolean hit = this.board.fire(new Location(row, col));
				if(hit) {
					button.setBackground(Color.RED);
				} else {
					button.setBackground(Color.WHITE);
				}
				button.setText(board1.board[row][col].draw());
				button.setEnabled(false);
				
				board1.toFile("battleship_logs1.txt");
			}
			
			if(isGameOver()) {
				setButtonsEnabled(board1buttons, false);
				JOptionPane.showMessageDialog(null, "Game over! You won!","Game Over", JOptionPane.NO_OPTION);
			} else {
				Location loc = new Location();
				loc = player2.getNextMove(board2, loc);
				Boolean hit2 = board2.fire(loc);
				board2buttons[loc.getRow()][loc.getCol()].setText(board2.board[loc.getRow()][loc.getCol()].draw());
				if(hit2) {
					board2buttons[loc.getRow()][loc.getCol()].setBackground(Color.RED);
				} else {
					board2buttons[loc.getRow()][loc.getCol()].setBackground(Color.WHITE);
				}
				
				board2.toFile("battleship_logs2.txt");
			}
		}
		
	}
	
	/***
	 * Create the GUI for battleship
	 */
	private void createGUI() {
		frame = new JFrame();
		sourceButton = new JMenuItem("Source");
		quitButton = new JMenuItem("Exit");
		helpButton = new JMenuItem("Info");
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		menuBar = new JMenuBar();
		northPanel = new JPanel();
		southPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		middlePanel = new JPanel();
		startButton = new JButton("Start Game");
		buttonGroup1 = new ButtonGroup();
		buttonGroup2 = new ButtonGroup();
		label1 = new JLabel("Your board");
		label2 = new JLabel("Opponent's board");
		
		
		board1buttons = new JButton[8][8];
		board2buttons = new JButton[8][8];
		
		frame.setLayout(new BorderLayout());
		
		northPanel.setLayout(new GridLayout(1, 2));
		frame.add(northPanel, BorderLayout.NORTH);
		northPanel.add(label1);
		northPanel.add(label2);
		
		southPanel.setLayout(new FlowLayout());
		southPanel.add(startButton);
		frame.add(southPanel, BorderLayout.SOUTH);

		westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		westPanel.setLayout(new GridLayout(8, 8));
		frame.add(westPanel, BorderLayout.WEST);
		for(int i = 0; i < board1.board.length; i++) {
			for(int j = 0; j < board1.board.length; j++) {
				board1buttons[i][j] = new JButton(board1.board[i][j].draw());
				board1buttons[i][j].addActionListener(new fireListener(i, j, board1buttons[i][j]));
				board1buttons[i][j].setBackground(Color.BLUE);
				buttonGroup1.add(board1buttons[i][j]);
				westPanel.add(board1buttons[i][j]);
				board1buttons[i][j].setEnabled(false);
			}
		}	
		
		eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(8, 8));
		for(int i = 0; i < board2.board.length; i++) {
			for(int j = 0; j < board2.board.length; j++) {
				board2buttons[i][j] = new JButton(board1.board[i][j].draw());
				board2buttons[i][j].setBackground(Color.BLUE);
				buttonGroup2.add(board2buttons[i][j]);
				eastPanel.add(board2buttons[i][j]);
				board2buttons[i][j].setEnabled(false);
			}
		}
		
			
		frame.setTitle("Battleship");
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		fileMenu.add(quitButton);
		helpMenu.add(helpButton);
		helpMenu.add(sourceButton);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		frame.add(eastPanel);
		
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
		
		//Source button opens github
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < board1buttons.length; i++) {
					for(int j = 0; j < board1buttons[i].length; j++) {
						board1buttons[i][j].setEnabled(true);
					}
				}
				play(board1buttons, board2buttons);
			}
		});
		
		//Help button gives some amount of help
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sink all of the enemy's ships to win","Help", JOptionPane.NO_OPTION);
			}
		});
		
	}
	
	public void play(JButton[][] board1buttons, JButton[][] board2buttons) {
		File logs1 = new File("battleship_logs1.txt"); 
		File logs2 = new File("battleship_logs2.txt"); 
		logs1.delete();
		logs2.delete();
		board1.toFile("battleship_logs1.txt");
		board2.toFile("battleship_logs2.txt");
		
		setButtonsEnabled(board1buttons, true);
		
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
	 * Set a button array to enabled or disabled
	 * @param buttonArray
	 * @param enabled
	 */
	public void setButtonsEnabled(JButton[][] buttonArray, boolean enabled) {
		for(int i = 0; i < buttonArray.length; i++) {
			for(int j = 0; j < buttonArray.length; j++) {
				buttonArray[i][j].setEnabled(enabled);
			}
		}
	}
	
	/***
	 * Figure out who won
	 */
	public void printWinner() {
		if(board1.areAllShipsSunk()) {
			System.out.println("Player 1 won");
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
			System.out.println("Player 2 won");
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
