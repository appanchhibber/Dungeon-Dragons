package com.SOEN6441_DND.Views;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author Appan Chhibber
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Windows extends JFrame {

 public Container container;


	/**
	 * Create the frame.
	 */
	public Windows() {
		container = getContentPane();
		setResizable(false);
		setSize(860, 645);
		setLocationRelativeTo(null); // center window on the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void setView(View view )
	{
		container.removeAll();
		container.add(view);
		view.setVisible(true); 
		setVisible(true);
		this.pack();
	}

}
