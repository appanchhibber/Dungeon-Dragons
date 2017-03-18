package com.SOEN6441_DND.Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;
/**
 * <b>This Class is View for Character Creation and Editor.</b>
 * @author Punit Trivedi
 *
 */
public class CharacterScene extends View implements Observer {

	public CharacterSceneController characterController;
	// Panels
    View imagePanel;
	public NavigationPanelView navMenuPanel;
	public AbilityPanelView abilityPanel;
	public ItemAssignView itemAssignView;
	// Labels
	JLabel nameLabel;
	JLabel imageLabel;
	JLabel charTypeLabel;
	JLabel levelLabel;
	// TextField
	public JTextField nameText;
	// Image
	ImageIcon characterImage;
	// Radio buttons.
	public JRadioButton characterTypeRadio;
	ButtonGroup charactertypeGroup;
	
	//button
		public JButton bully;
		public JButton tank;
		public JButton nimble;
		
	//ComboBox
	public JComboBox levels;
	//Character View Model
	public CharacterModel characterViewModel;
	
	public AbilitiyModel abilityViewModel;
	public AbilitiyModel abilityModifier;
	public AbilitiyModel abilityScore;
	
	//backPack
	public Map<String, ArrayList<String>> backPackMap;
	public Map<String, ArrayList<String>> assignItemMap;
	
	
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		
		//Model Initialization
		characterViewModel= new CharacterModel();
		abilityViewModel=new AbilitiyModel();
		abilityModifier= new AbilitiyModel();
		abilityScore= new AbilitiyModel();
		
		itemAssignView=new ItemAssignView();
		characterViewModel.setAbilityScore(abilityScore);
		characterViewModel.setAbilityModifier(abilityModifier);
		
		
		//Panel Initialization
		abilityPanel = new AbilityPanelView(abilityViewModel);
		navMenuPanel = new NavigationPanelView();
		characterController = new CharacterSceneController(this);
		
		//Name Character
		  nameLabel= new JLabel("Name :");
		  nameText = new JTextField();
		  nameLabel.setLocation(20,40);
		  nameText.setLocation(70,35);
		  nameLabel.setSize(80, 20);
		  nameText.setSize(250,30);
		  this.add(nameLabel);
		  this.add(nameText);
		 
		 //levels
		 levelLabel=new JLabel("Level :");
		 levelLabel.setLocation(20,5);
		 levelLabel.setSize(80, 20);
		 levels = new JComboBox(characterViewModel.getLevelListValues());
		 levels.setLocation(70,5);
		 levels.setSize(250,30);
		 characterViewModel.setLevel(Integer.parseInt(levels.getSelectedItem().toString()));
		 levels.addActionListener(characterController);
		 this.add(levelLabel);
		 this.add(levels);
		//Character Selection
		charTypeLabel=new JLabel("Select Your Character");
		charTypeLabel.setLocation(550,10);
		charTypeLabel.setSize(200,20);
		this.add(charTypeLabel);
		
		charactertypeGroup = new ButtonGroup();
		characterTypeRadio = new JRadioButton("Human", true);
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(360, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Dwarf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(480, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Elf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(600, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Orc");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(720, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);
		//End Character Selection
		//Configure Model attach with Observer.
		
		characterViewModel.setImage("Human");
		characterViewModel.setType("Human");
		characterViewModel.addObserver(this);
		characterImage = new ImageIcon(characterViewModel.getImage());
		abilityModifier.setStrength(0);
		abilityModifier.setDexterity(0);
		abilityModifier.setConstitution(0);
		abilityModifier.setIntelligence(0);
		abilityModifier.setWisdom(0);
		abilityModifier.setCharisma(0);
		//characterViewModel.setAbilityModifier(abilitiyModifier);
		
		//Image Panel
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(20, 70);
		
		imageLabel = new JLabel(
				new ImageIcon(((characterImage.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);
		imagePanel.add(imageLabel);
		//End Image Panel.
		
		//Add Action Listener
		abilityPanel.calculateButton.addActionListener(characterController);
		setModifier();
		setAbilityScore();
		this.setVisible(true);
		this.add(navMenuPanel);
		navMenuPanel.nextButton.addActionListener(characterController);
		navMenuPanel.saveButton.addActionListener(characterController);
		itemAssignView.itemType.addActionListener(characterController);
		itemAssignView.subItemType.addActionListener(characterController);
		itemAssignView.backpackAssign.addActionListener(characterController);
		itemAssignView.charBackButton.addActionListener(characterController);
		itemAssignView.addItem.addActionListener(characterController);

		bully = new JButton("Bully");
		bully.setSize(90, 30);
		bully.setLocation(420, 120);
		bully.addActionListener(characterController);
		abilityPanel.add(bully);
		
		nimble = new JButton("Nimble");
		nimble.setSize(90, 30);
		nimble.setLocation(420, 170);
		nimble.addActionListener(characterController);
		abilityPanel.add(nimble);
		
		tank = new JButton("Tank");
		tank.setSize(90, 30);
		tank.setLocation(420, 220);
		tank.addActionListener(characterController);
		abilityPanel.add(tank);
		
		this.add(imagePanel);
		this.add(abilityPanel);
		

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setImagePanel();
		setModifier();
		setAbilityScore();
		characterSkillUpdate();
	}
	public void characterSkillUpdate()
	{
		itemAssignView.levelsValueLabel.setText(String.valueOf(characterViewModel.getLevel()));
		
	}
	
	
	public void setImagePanel()
	{
		characterImage.getImage().flush();
		characterImage= new ImageIcon(new ImageIcon(characterViewModel.getImage()).getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(),java.awt.Image.SCALE_SMOOTH ));
		//abilityModel;
		imageLabel.setIcon(characterImage);
		imageLabel.revalidate();
		imageLabel.repaint();
		
	}
	public void setModifier()
	{
		abilityPanel.strengthModifierText.setText(String.valueOf(abilityModifier.getStrength()));
		abilityPanel.constitutionModifierText.setText(String.valueOf(abilityModifier.getConstitution()));
		abilityPanel.dexterityModifierText.setText(String.valueOf(abilityModifier.getDexterity()));
		abilityPanel.intelligenceModifierText.setText(String.valueOf(abilityModifier.getIntelligence()));
		abilityPanel.wisdomModifierText.setText(String.valueOf(abilityModifier.getWisdom()));
		abilityPanel.charismaModifierText.setText(String.valueOf(abilityModifier.getCharisma()));
	}
	
	public void setAbilityScore()
	{	
		abilityPanel.strengthScoreText.setText(String.valueOf(abilityScore.getStrength()));
		abilityPanel.constitutionScoreText.setText(String.valueOf(abilityScore.getConstitution()));
		abilityPanel.dexterityScoreText.setText(String.valueOf(abilityScore.getDexterity()));
		abilityPanel.intelligenceScoreText.setText(String.valueOf(abilityScore.getIntelligence()));
		abilityPanel.wisdomScoreText.setText(String.valueOf(abilityScore.getWisdom()));
		abilityPanel.charismaScoreText.setText(String.valueOf(abilityScore.getCharisma()));
	}

}
