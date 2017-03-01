package com.SOEN6441_DND.Views;

import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JLabel;
/**
 * This class consist of creating JPanel that every other view is going to
 * inherit and override the class methods.The methods include:
 * initSubviews,initEvents.
 * 
 * @author Appan Chhibber
 * @author Ehab Amar
 * @version 1.0
 */
@SuppressWarnings("serial")
public class View extends JPanel {
	/**
	 * Create the panel.
	 */
	public View() {
		super();
		initialize();
	}

	public void initialize() {
		this.setLayout(null);
		init();
		initSubviews();
		initEvents();
	}

	protected void init() {

		this.setSize(860, 645);
	}

	protected void initSubviews() {

	}

	protected void initEvents() {

	}

}
