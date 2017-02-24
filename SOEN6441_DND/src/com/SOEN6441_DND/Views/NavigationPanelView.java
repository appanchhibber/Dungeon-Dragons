package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.JButton;

public class NavigationPanelView extends View{
 //Navigation Buttons
	public JButton homeButton;
	public JButton newButton;
	public JButton saveButton;
	public JButton loadButton;
	public JButton nextButton;
	
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		// Navigation Panel
				homeButton = new JButton("Home");
				homeButton.setLocation(20, 30);
				homeButton.setSize(160, 50);
				homeButton.setBackground(Color.BLUE);
				homeButton.setOpaque(true);

				newButton = new JButton("New");
				newButton.setLocation(20, 130);
				newButton.setSize(160, 50);
				newButton.setBackground(Color.orange);
				newButton.setOpaque(true);

				saveButton = new JButton("Save");
				saveButton.setLocation(20, 230);
				saveButton.setSize(160, 50);
				saveButton.setBackground(Color.CYAN);
				saveButton.setOpaque(true);

				loadButton = new JButton("Load");
				loadButton.setLocation(20, 330);
				loadButton.setSize(160, 50);
				loadButton.setBackground(Color.RED);
				loadButton.setOpaque(true);

				nextButton = new JButton("Next");
				nextButton.setLocation(20, 430);
				nextButton.setSize(160, 50);
				nextButton.setBackground(Color.GREEN);
				nextButton.setOpaque(true);
				
				setBackground(Color.BLACK);
				setSize(200, 500);
				setLocation(650, 70);
				setVisible(true);

				add(homeButton);
				add(newButton);
				add(saveButton);
				add(loadButton);
				add(nextButton);
				//End Navigation
	}
	
	
	
}
