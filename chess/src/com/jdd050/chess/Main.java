package com.jdd050.chess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {
	
	private static final int ranks = 8;
	private static final int files = ranks;
	private static final Dimension squareSize = new Dimension(80, 80);
	private static final Color lightSquareColor = new Color(254, 238, 213);
	private static final Color darkSquareColor = new Color(205, 157, 111);
	private static JPanel chessBoard = new JPanel(new GridLayout(ranks, files));
	private static ArrayList<ArrayList<JPanel>> squares = new ArrayList<ArrayList<JPanel>>();
	
	public Main() {
		// populate ArrayList 
		do {
			squares.add(new ArrayList<JPanel>());
		} while (squares.size() < 8);
		
		// create ranks/files
		for (int file = 0; file < files; file++) {
			for (int rank = 0; rank < ranks; rank++) {
				// create a square and set its size/color
				JPanel square = new JPanel();
				square.setPreferredSize(squareSize);
				Color squareColor = (rank % 2 == file % 2) ? lightSquareColor : darkSquareColor;
				square.setBackground(squareColor);
				// add square to the chess board
				chessBoard.add(square);
				// add square to 2D ArrayList (mimicking a grid)
				squares.get(file).add(square);
			}
		}
	}
	
	/*
	 * methods that create the chess board
	 */
	
	// creates the grid with the chess board and labels (what the player can see)
	public void createGameGrid() {
		// define layout for main panel
		setLayout(new GridBagLayout());
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		// left-side rank labels
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 1;
		gbConstraints.gridwidth = 1;
		gbConstraints.gridheight = 1;
		gbConstraints.weightx = 0.0;
		gbConstraints.weighty = 0.0;
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.WEST;
		gbConstraints.insets = new Insets(0, 10, 0, 10);
		add(createRankPanel(), gbConstraints);
		
		// right-size rank labels
		gbConstraints.gridx = 2;
		gbConstraints.anchor = GridBagConstraints.EAST;
		add(createRankPanel(), gbConstraints);
		
		// top file labels
		gbConstraints.gridx = 1;
		gbConstraints.gridy = 0;
		gbConstraints.anchor = GridBagConstraints.SOUTH;
		gbConstraints.insets = new Insets(5, 0, 5, 0);
		add(createFilePanel(), gbConstraints);
		
		// bottom file labels
		gbConstraints.gridy = 2;
		gbConstraints.anchor = GridBagConstraints.NORTH;
		add(createFilePanel(), gbConstraints);
		
		// the chess board itself
		gbConstraints.gridx = 1;
		gbConstraints.gridy = 1;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		gbConstraints.insets = new Insets(0, 0, 0 ,0);
		add(chessBoard, gbConstraints);
	}
	
	// creates a files panel (for labeling) and returns the panel
	private JPanel createFilePanel() {
		JPanel filePanel = new JPanel(new GridLayout(1,0));
		for (int i = 0; i < files; i++) {
			// set current letter by increasing its ASCII value
			char fileLetter = (char) ('A' + i);
			JLabel letter = new JLabel(String.valueOf(fileLetter), SwingConstants.CENTER);
			letter.setForeground(Color.white);
			filePanel.add(letter);
			filePanel.setBackground(Color.gray);
		}
		return filePanel;
	}
	
	// creates a ranks panel (for labeling) and returns the panel
	private JPanel createRankPanel() {
		JPanel rankPanel = new JPanel(new GridLayout(0,1));
		for (int i = 0; i < ranks; i++) {
			// count down rather than up
			int currentRow = ranks - i;
			JLabel number = new JLabel(String.valueOf(currentRow));
			number.setForeground(Color.white);
			rankPanel.add(number);
			rankPanel.setBackground(Color.gray);
		}
		return rankPanel;
	}
	
	/*
	 *  methods that add and manage chess pieces
	 */
	
	// adds the textures for each piece on the board
	public void addPieceTextures() {
		// black pawns
			try {
				BufferedImage black_pawn_raw = ImageIO.read(new File("C:\\Users\\joeyd\\OneDrive\\Documents\\GitHub\\Java\\chess\\src\\com\\jdd050\\chess\\assets\\black_pawn.png"));
				Image black_pawn = black_pawn_raw.getScaledInstance(black_pawn_raw.getWidth() / 3, black_pawn_raw.getHeight() / 3, Image.SCALE_SMOOTH);
				for (int i = 0; i < ranks; i++) {
					JLabel blackPawn = new JLabel(new ImageIcon(black_pawn));
					squares.get(1).get(i).add(blackPawn);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	/*
	 * run methods
	 */
	
	// create the root window
	private static void createAndShowGui() {
		// calls
		Main mainPanel = new Main();
		mainPanel.createGameGrid();
		mainPanel.addPieceTextures();
		
		// make and configure window
		mainPanel.setBackground(Color.gray);
		JFrame frame = new JFrame("Java Chess v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	// start the app
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
	
	/*
	 * move chess pieces
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
