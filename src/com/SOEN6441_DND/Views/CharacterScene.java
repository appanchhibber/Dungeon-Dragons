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
import java.util.Random;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CharacterModel;

/**
 * <b>This Class is View for Character Creation and Editor.</b>
 * 
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
	public JRadioButton[] characterTypeRadio;
	public ButtonGroup characterTypeGroup;

	// button
	public JButton bully;
	public JButton tank;
	public JButton nimble;

	// ComboBox
	public JComboBox levels;
	// Character View Model
	public CharacterModel characterViewModel;

	public AbilityModel abilityViewModel;
	public AbilityModel abilityModifier;
	public AbilityModel abilityScore;

	// backPack
	public Map<String, ArrayList<String>> backPackMap;
	public Map<String, ArrayList<String>> assignItemMap;

	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();

		// Model Initialization
		characterViewModel = new CharacterModel();
		abilityViewModel = new AbilityModel();
		abilityModifier = new AbilityModel();
		abilityScore = new AbilityModel();

		itemAssignView = new ItemAssignView();
		
		characterViewModel.setAbilityScore(abilityScore);
		characterViewModel.setAbilityModifier(abilityModifier);

		// Panel Initialization
		abilityPanel = new AbilityPanelView(abilityViewModel);
		navMenuPanel = new NavigationPanelView();
		characterController = new CharacterSceneController(this);
		characterController.readAllItems();
		// Name Character
		nameLabel = new JLabel("Name :");
		nameText = new JTextField();
		nameLabel.setLocation(20, 40);
		nameText.setLocation(70, 35);
		nameLabel.setSize(80, 20);
		nameText.setSize(250, 30);
		this.add(nameLabel);
		this.add(nameText);

		// levels
		levelLabel = new JLabel("Level :");
		levelLabel.setLocation(20, 5);
		levelLabel.setSize(80, 20);
		levels = new JComboBox(characterViewModel.getLevelListValues());
		levels.setLocation(70, 5);
		levels.setSize(250, 30);
		characterViewModel.setLevel(Integer.parseInt(levels.getSelectedItem().toString()));
		levels.addActionListener(characterController);
		this.add(levelLabel);
		this.add(levels);
		// Character Selection
		charTypeLabel = new JLabel("Select Your Character");
		charTypeLabel.setLocation(550, 10);
		charTypeLabel.setSize(200, 20);
		this.add(charTypeLabel);

		characterTypeGroup = new ButtonGroup();
		characterTypeRadio = new JRadioButton[] { new JRadioButton("Human", true), new JRadioButton("Dwarf"),
				new JRadioButton("Elf"), new JRadioButton("Orc") };
		characterTypeRadio[0].setSize(100, 20);
		characterTypeRadio[0].setLocation(360, 40);
		characterTypeRadio[0].addActionListener(characterController);
		characterTypeGroup.add(characterTypeRadio[0]);
		this.add(characterTypeRadio[0]);

		characterTypeRadio[1].setSize(100, 20);
		characterTypeRadio[1].setLocation(480, 40);
		characterTypeRadio[1].addActionListener(characterController);
		characterTypeGroup.add(characterTypeRadio[1]);
		this.add(characterTypeRadio[1]);

		characterTypeRadio[2].setSize(100, 20);
		characterTypeRadio[2].setLocation(600, 40);
		characterTypeRadio[2].addActionListener(characterController);
		characterTypeGroup.add(characterTypeRadio[2]);
		this.add(characterTypeRadio[2]);

		characterTypeRadio[3].setSize(100, 20);
		characterTypeRadio[3].setLocation(720, 40);
		characterTypeRadio[3].addActionListener(characterController);
		characterTypeGroup.add(characterTypeRadio[3]);
		this.add(characterTypeRadio[3]);
		// End Character Selection
		// Configure Model attach with Observer.

		characterViewModel.setImage("image/Human.jpg");
		characterViewModel.setType("Human");
		characterViewModel.addObserver(this);
		characterViewModel.addObserver(itemAssignView);
		characterImage = new ImageIcon(characterViewModel.getImage());
		abilityModifier.setStrength(0);
		abilityModifier.setDexterity(0);
		abilityModifier.setConstitution(0);
		abilityModifier.setIntelligence(0);
		abilityModifier.setWisdom(0);
		abilityModifier.setCharisma(0);
		// characterViewModel.setAbilityModifier(abilitiyModifier);

		// Image Panel
		imagePanel = new View();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setSize(300, 475);
		imagePanel.setLocation(20, 70);

		imageLabel = new JLabel(new ImageIcon(((characterImage.getImage().getScaledInstance(imagePanel.getWidth(),
				imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);
		imagePanel.add(imageLabel);
		// End Image Panel.

		// Add Action Listener
		abilityPanel.calculateButton.addActionListener(characterController);
		setModifier();
		setAbilityScore();
		this.setVisible(true);
		this.add(navMenuPanel);

		navMenuPanel.nextButton.addActionListener(characterController);
		navMenuPanel.saveButton.addActionListener(characterController);
		navMenuPanel.loadButton.addActionListener(characterController);

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
		setCharacter();
		characterSkillUpdate();
	}

	public void setCharacter() {
		this.levels.setSelectedItem(String.valueOf(characterViewModel.getLevel()));
		this.nameText.setText(characterViewModel.getName());

	}

	public void characterSkillUpdate() {
		itemAssignView.levelsValueLabel.setText(String.valueOf(characterViewModel.getLevel()));
		itemAssignView.hitValueLabel.setText(String.valueOf(characterViewModel.getHitPoints()));
		itemAssignView.attackValueLabel.setText(String.valueOf(characterViewModel.getAttackBonus()));
		itemAssignView.damageValueLabel.setText(String.valueOf(characterViewModel.getDamageBonus()));
		itemAssignView.armorValueLabel.setText(String.valueOf(characterViewModel.getArmorClass()));
	}

	public void setImagePanel() {
		characterImage.getImage().flush();
		characterImage = new ImageIcon(new ImageIcon(characterViewModel.getImage()).getImage()
				.getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH));
		// abilityModel;
		imageLabel.setIcon(characterImage);
		imageLabel.revalidate();
		imageLabel.repaint();
	}

	public void setModifier() {
		abilityPanel.strengthModifierText.setText(String.valueOf(abilityModifier.getStrength()));
		abilityPanel.constitutionModifierText.setText(String.valueOf(abilityModifier.getConstitution()));
		abilityPanel.dexterityModifierText.setText(String.valueOf(abilityModifier.getDexterity()));
		abilityPanel.intelligenceModifierText.setText(String.valueOf(abilityModifier.getIntelligence()));
		abilityPanel.wisdomModifierText.setText(String.valueOf(abilityModifier.getWisdom()));
		abilityPanel.charismaModifierText.setText(String.valueOf(abilityModifier.getCharisma()));
	}

	public void setAbilityScore() {
		abilityPanel.strengthScoreText.setText(String.valueOf(abilityScore.getStrength()));
		abilityPanel.constitutionScoreText.setText(String.valueOf(abilityScore.getConstitution()));
		abilityPanel.dexterityScoreText.setText(String.valueOf(abilityScore.getDexterity()));
		abilityPanel.intelligenceScoreText.setText(String.valueOf(abilityScore.getIntelligence()));
		abilityPanel.wisdomScoreText.setText(String.valueOf(abilityScore.getWisdom()));
		abilityPanel.charismaScoreText.setText(String.valueOf(abilityScore.getCharisma()));
	}

}
