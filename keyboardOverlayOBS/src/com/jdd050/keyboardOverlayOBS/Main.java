package com.jdd050.keyboardOverlayOBS;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {
	
	private static ArrayList<String> keys = new ArrayList<String>();
	private static final File keyConfiguration = new File("keys.txt");
	
	private void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(keyConfiguration));
		String currentLine;
		
		while ((currentLine = br.readLine()) != null) {
			if (currentLine.contains("###")) {
				continue;
			// add key id to ArrayList<String> keys
			} else {
				keys.add(currentLine);
			}
		}
		// close reader when done
		br.close();
	}
	
	public Main() throws IOException {
		this.setBackground(Color.green);
		
		// load keys to listen to
		if (keyConfiguration.isFile()) {
			readFile();
		} else {
			keyConfiguration.createNewFile();
			readFile();
		}
	}

	// create the root window
	private static void createAndShowGui() throws IOException {
		// calls
		Main mainPanel = new Main();
		
		// make and configure window
		JFrame frame = new JFrame("OBS Keyboard Overlay");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setSize(1280, 720);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(mainPanel, "To add keys to display, please edit the 'keys.txt' file.", "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// start the app
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGui();
				} catch (IOException e) {
					System.out.println("Error occurred while reading key configs.");
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

