package com.jdd050.calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Calculator extends JPanel implements ActionListener {
	
	public Calculator() {
		
	}

	// create the root window
	private static void createAndShowGui() {
		// calls
		Calculator mainPanel = new Calculator();
		
		// make and configure window
		JFrame frame = new JFrame("Java Chess v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setSize(400, 600);
		frame.setResizable(false);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
