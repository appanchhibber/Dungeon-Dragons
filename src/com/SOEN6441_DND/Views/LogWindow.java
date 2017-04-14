package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogWindow extends JFrame{
	
	JPanel logPanel;
	JTextArea logArea;
	JLabel heading;
		/**
		 * Create the frame.
		 */
		public LogWindow() {
			logPanel = new JPanel();
			heading = new JLabel("Welcome to DnD !");
			logArea = new JTextArea(40,40); 
			logArea.setLocation(10, 110);
			heading.setVisible(true);
			heading.setSize(110,110);
			heading.setFont(new Font("calibri", Font.BOLD, 18));
			logPanel.add(heading);
			logArea.setEditable(false);
			logArea.setBackground(Color.CYAN);
			logPanel.add(new JScrollPane(logArea));
			this.add(logPanel);
		}
		
}
