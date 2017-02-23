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
import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;
/**
 * <b>This Class is View for Character Creation and Editior.</b>
 * @author Punit Trivedi
 *
 */
public class CharacterScene extends View implements Observer {

	public CharacterSceneController characterController;
	// Panels
    View imagePanel;
	View navMenuPanel;
	View abilityPanel;
	// Buttons
	public JButton homeButton;
	public JButton newButton;
	public JButton saveButton;
	public JButton loadButton;
	public JButton nextButton;
	public JButton calculateButton;
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
	public JTextField strengthText;
	public JTextField dexterityText;
	public JTextField constitutionText;
	public JTextField intelligenceText;
	public JTextField wisdomText;
	public JTextField charismaText;
	public JTextField nameText;
	// Image
	ImageIcon characterImage;
	// Radio buttons.
	public JRadioButton characterTypeRadio;
	ButtonGroup charactertypeGroup;
	//Character View Model
	public CharacterModel characterViewModel;
	public AbilitiyModel abilityViewModel;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		characterViewModel= new CharacterModel();
		abilityViewModel=new AbilitiyModel();
		characterController = new CharacterSceneController(this);
		
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
		//End Navigation
		//Character Selection
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
		//End Character Selection
		//Configure Model attach with Observer.
		
		characterViewModel.setImage("Human");
		characterViewModel.addObserver(this);
		characterImage = new ImageIcon(characterViewModel.getImage());
		
		//Image Panel
		imagePanel = new View();
		imagePanel.setSize(300, 500);
		imagePanel.setLocation(20, 70);
		
		imageLabel = new JLabel(
				new ImageIcon(((characterImage.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);
		imagePanel.add(imageLabel);
		//End Image Panel.
		//Ability Panel.
		abilityPanel = new View();
		abilityPanel.setBackground(Color.BLACK);
		abilityPanel.setSize(300, 500);
		abilityPanel.setLocation(335, 70);
		abilityPanel.setVisible(true);
		// Labels
		strengthLabel= new JLabel("Strength :");
		dexterityLabel= new JLabel("Dexterity :");
		constitutionLabel= new JLabel("Constitution :");
		intelligenceLabel= new JLabel("Intelligence :");
		wisdomLabel= new JLabel("Wisdom :");
		charismaLabel= new JLabel("Charisma :");
		// TextField
		strengthText= new JTextField();
		dexterityText=new JTextField();
		constitutionText=new JTextField();
		intelligenceText=new JTextField();
		wisdomText=new JTextField();
		charismaText=new JTextField();
		
		calculateButton = new JButton("Calculate Ability");
		
		strengthLabel.setLocation(30,20);
		strengthLabel.setForeground(Color.WHITE);
		strengthLabel.setSize(80, 20);
		strengthText.setLocation(150, 10);
		strengthText.setSize(140, 40);
		strengthText.setEditable(false);
		
		dexterityLabel.setLocation(30,90);
		dexterityLabel.setForeground(Color.WHITE);
		dexterityLabel.setSize(80, 20);
		dexterityText.setLocation(150, 80);
		dexterityText.setSize(140, 40);
		dexterityText.setEditable(false);
		
		constitutionLabel.setLocation(30,160);
		constitutionLabel.setForeground(Color.WHITE);
		constitutionLabel.setSize(120, 20);
		constitutionText.setLocation(150, 150);
		constitutionText.setSize(140, 40);
		constitutionText.setEditable(false);
		
		intelligenceLabel.setLocation(30,230);
		intelligenceLabel.setForeground(Color.WHITE);
		intelligenceLabel.setSize(120, 20);
		intelligenceText.setLocation(150, 220);
		intelligenceText.setSize(140, 40);
		intelligenceText.setEditable(false);
		
		wisdomLabel.setLocation(30,300);
		wisdomLabel.setForeground(Color.WHITE);
		wisdomLabel.setSize(80, 20);
		wisdomText.setLocation(150, 290);
		wisdomText.setSize(140, 40);
		wisdomText.setEditable(false);
		
		charismaLabel.setLocation(30,370);
		charismaLabel.setForeground(Color.WHITE);
		charismaLabel.setSize(80, 20);
		charismaText.setLocation(150, 360);
		charismaText.setSize(140, 40);
		charismaText.setEditable(false);
		
		calculateButton.setLocation(50,425);
		calculateButton.setSize(200, 40);	
		calculateButton.addActionListener(characterController);
		
		abilityPanel.add(strengthText);
		abilityPanel.add(strengthLabel);
		abilityPanel.add(dexterityLabel);
		abilityPanel.add(dexterityText);
		abilityPanel.add(constitutionLabel);
		abilityPanel.add(constitutionText);
		abilityPanel.add(intelligenceLabel);
		abilityPanel.add(intelligenceText);
		abilityPanel.add(wisdomLabel);
		abilityPanel.add(wisdomText);
		abilityPanel.add(charismaLabel);
		abilityPanel.add(charismaText);
		abilityPanel.add(calculateButton);
		
		

		this.setVisible(true);
		this.add(navMenuPanel);
		this.add(imagePanel);
		this.add(abilityPanel);
		

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		characterImage.getImage().flush();
		characterImage= new ImageIcon(new ImageIcon(characterViewModel.getImage()).getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(),java.awt.Image.SCALE_SMOOTH ));
		//abilityModel;
		imageLabel.setIcon(characterImage);
		imageLabel.revalidate();
		imageLabel.repaint();	
		
		strengthText.setText(String.valueOf(abilityViewModel.getStrength()));
		constitutionText.setText(String.valueOf(abilityViewModel.getConstitution()));
		dexterityText.setText(String.valueOf(abilityViewModel.getDexterity()));
		intelligenceText.setText(String.valueOf(abilityViewModel.getIntelligence()));
		wisdomText.setText(String.valueOf(abilityViewModel.getWisdom()));
		charismaText.setText(String.valueOf(abilityViewModel.getCharisma()));
	}

}
