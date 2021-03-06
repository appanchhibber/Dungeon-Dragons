package com.SOEN6441_DND.Views;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * This class displays the log window showing the real time logs for the game.
 * @author Paras Malik
 *
 */
public class LogWindow extends JFrame{
	
	JPanel logPanel;
	public static JTextArea logArea = new JTextArea(40,40);
	JLabel heading;
		/**
		 * Create the frame.
		 */
		public LogWindow() {
			logPanel = new JPanel();
			heading = new JLabel("DnD Console :"); 
			logArea.setLocation(10, 110);
			heading.setVisible(true);
			heading.setSize(110,110);
			heading.setFont(new Font("calibri", Font.BOLD, 18));
			logPanel.add(heading);
			logArea.setEditable(false);
			logArea.setText("Game logs - ");
			logArea.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(logArea);
			logPanel.add(scrollPane);
			this.add(logPanel);
		}
	
		/**
		 * Displaying the real time battle information in log file
		 * @param logText
		 */
		public static void setLogDisplay(String logText){
			logArea.append("\n"+logText);
		}

		/**
	     * Get current info in the display panel to save it.
	     * @return The String for the current information on log window.
	     */
	    public static String getBattleInfo (){
	        String battleInfo = logArea.getText();
	        return battleInfo;
	    }
}
