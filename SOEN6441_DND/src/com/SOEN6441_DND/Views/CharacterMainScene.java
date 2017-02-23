package com.SOEN6441_DND.Views;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
public class CharacterMainScene extends View {
	public
	//Panels
		View imagePanel;
		View navMenuPanel;
		View abilityPanel;
	//Buttons
		JButton homeButton;
		JButton newButton;
		JButton saveButton;
		JButton loadButton;
		JButton nextButton;
	//Labels
		JLabel strengthLabel;
		JLabel dexterityLabel;
		JLabel constitutionLabel;
		JLabel intelligenceLabel;
		JLabel wisdomLabel;
		JLabel charismaLabel;
		JLabel nameLabel;
	//TextField
		JTextField strengthText;
		JTextField dexterityText;
		JTextField constitutionText;
		JTextField intelligencText;
		JTextField wisdomText;
		JTextField charismaText;
		JTextField nameText;
		
		@Override
		protected void initSubviews() {
			// TODO Auto-generated method stub
			super.initSubviews();
			
			homeButton = new JButton("Home");
			homeButton.setLocation(20, 30);
			homeButton.setSize(160, 50);
			homeButton.setBackground(Color.BLUE);
			homeButton.setOpaque(true);
			

			newButton =  new JButton("New");
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
			
			imagePanel = new View();
			imagePanel.setBackground(Color.BLACK);
			imagePanel.setSize(200, 500);
			imagePanel.setLocation(600, 70);

			navMenuPanel = new View();
			navMenuPanel.setBackground(Color.BLACK);
			navMenuPanel.setSize(200, 500);
			navMenuPanel.setLocation(600, 70);
			navMenuPanel.setVisible(true);
			
			navMenuPanel.add(homeButton);
			navMenuPanel.add(newButton);
			navMenuPanel.add(saveButton);
			navMenuPanel.add(loadButton);
			navMenuPanel.add(nextButton);
			
			abilityPanel = new View();
			this.setSize(600, 600);	
			this.setVisible(true);
			this.add(navMenuPanel);
			
		}
		
		
		
		
		
		
}
