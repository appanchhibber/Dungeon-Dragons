package com.SOEN6441_DND.Views;

import javax.swing.JPanel;

public class View extends JPanel {
	/**
	 * Create the panel.
	 */
	public View() {
    super();
    initialize();
	}
	public void initialize()
	{ 
		this.setLayout(null);
		init();
		initSubviews();
		initEvents();
	}
	
	protected void init()
	{

		this.setSize(800, 600);
	}
	protected void initSubviews(){
		
	}
	
	protected void initEvents()
	{
		
	}


}
