package com.SOEN6441_DND.Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Model.CharacterModel;

public class CharacterScene extends View implements Observer {

	public CharacterSceneController characterController;
	// Panels
    View imagePanel;
	View navMenuPanel;
	View abilityPanel;
	// Buttons
	JButton homeButton;
	JButton newButton;
	JButton saveButton;
	JButton loadButton;
	JButton nextButton;
	// Labels
	JLabel strengthLabel;
	JLabel dexterityLabel;
	JLabel constitutionLabel;
	JLabel intelligenceLabel;
	JLabel wisdomLabel;
	JLabel charismaLabel;
	JLabel nameLabel;
	JLabel imageLabel;
	// TextField
	JTextField strengthText;
	JTextField dexterityText;
	JTextField constitutionText;
	JTextField intelligencText;
	JTextField wisdomText;
	JTextField charismaText;
	JTextField nameText;
	// Image
	ImageIcon characterImage;
	// Radio buttons.
	public JRadioButton characterTypeRadio;
	ButtonGroup charactertypeGroup;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		characterController = new CharacterSceneController(this);
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

		charactertypeGroup = new ButtonGroup();
		characterTypeRadio = new JRadioButton("Human", true);
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(160, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Dwarf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(280, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Elf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(400, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Orc");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(520, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterController.characterModel.setImage("Human");
		characterImage = new ImageIcon(characterController.characterModel.getImage());
		characterController.characterModel.addObserver(this);
		
		imagePanel = new View();
		//imagePanel.setBackground(Color.BLACK);
		imagePanel.setSize(300, 300);
		imagePanel.setLocation(20, 70);
		
		imageLabel = new JLabel(
				new ImageIcon(((characterImage.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(300, 300);
		imageLabel.setLocation(0, 0);
		imagePanel.add(imageLabel);

		navMenuPanel = new View();
		navMenuPanel.setBackground(Color.BLACK);
		navMenuPanel.setSize(200, 500);
		navMenuPanel.setLocation(650, 70);
		navMenuPanel.setVisible(true);

		navMenuPanel.add(homeButton);
		navMenuPanel.add(newButton);
		navMenuPanel.add(saveButton);
		navMenuPanel.add(loadButton);
		navMenuPanel.add(nextButton);

		abilityPanel = new View();
		abilityPanel.setBackground(Color.BLACK);
		abilityPanel.setSize(250, 500);
		abilityPanel.setLocation(350, 70);
		abilityPanel.setVisible(true);

		this.setSize(600, 600);
		this.setVisible(true);
		this.add(navMenuPanel);
		this.add(imagePanel);
		this.add(abilityPanel);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		characterImage.getImage().flush();
		characterImage= new ImageIcon(new ImageIcon(((CharacterModel) o).getImage()).getImage().getScaledInstance(300, 300,java.awt.Image.SCALE_SMOOTH ));
		imageLabel.setIcon(characterImage);
		imagePanel.revalidate();
		imagePanel.repaint();
		
	}

}
