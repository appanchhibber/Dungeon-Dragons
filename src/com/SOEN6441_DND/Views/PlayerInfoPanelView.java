package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.SOEN6441_DND.Model.CharacterModel;

/**
 * This is the info panel for the play game window
 * displaying characteristics of the player during gameplay.
 * @author Paras Malik
 *
 */
public class PlayerInfoPanelView extends View implements Observer {
	public JLabel lblStrength;
	public JLabel lblConstitution;
	public JLabel lblDexterity;
	public JLabel lblIntelligence;
	public JLabel lblWisdom;
	public JLabel lblCharisma;
	public JLabel lblCharName;
	public JLabel lblCharType;
	public JLabel lblHitpoint;
	public JLabel lblCharLevel;
	public JLabel armorClassLabel;
	public JLabel attackBonusLabel;

	public JLabel strengthValue;
	public JLabel constitutionValue;
	public JLabel intelligenceValue;
	public JLabel wisdomValue;
	public JLabel charismaValue;
	public JLabel dexterityValue;
	public JLabel charNameValue;
	public JLabel charTypeValue;
	public JLabel hitpointValue;
	public JLabel charLevelValue;
	public JLabel armorClassValue;
	public JLabel attackBonusValue;

	public CharacterModel player;
	public CharacterModel character;

	public JButton inventoryBtn;
	
	
	public JLabel playerImage;
	public JLabel lblPlayer;
	public JLabel playerName;
	public JLabel lblHp;
	public JLabel playerHp;
	public JLabel lblplayArmor;
	public JLabel playerArmor;
	public JLabel attackerImage;
	public JLabel atkHp;
	public JLabel attackerHp;
	public JLabel lblAtkArmor;
	public JLabel attackerArmor;
	public JLabel lblAtkName;
	public JLabel attackerName;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		this.setBackground(Color.BLACK);
		this.setLocation(635, 10);
		this.setSize(215, 530);
		player = new CharacterModel();
		player.addObserver(this);
		lblCharName = new JLabel("Name:");
		lblCharName.setSize(100, 20);
		lblCharName.setForeground(Color.WHITE);
		lblCharName.setLocation(5, 5);
		this.add(lblCharName);

		charNameValue = new JLabel();
		charNameValue.setSize(120, 20);
		charNameValue.setForeground(Color.WHITE);
		charNameValue.setLocation(160, 5);
		this.add(charNameValue);

		lblCharType = new JLabel("Behavior:");
		lblCharType.setSize(100, 20);
		lblCharType.setForeground(Color.WHITE);
		lblCharType.setLocation(5, 25);
		this.add(lblCharType);

		charTypeValue = new JLabel();
		charTypeValue.setSize(120, 20);
		charTypeValue.setForeground(Color.WHITE);
		charTypeValue.setLocation(160, 25);
		this.add(charTypeValue);

		lblCharLevel = new JLabel("Character Level:");
		lblCharLevel.setSize(180, 20);
		lblCharLevel.setForeground(Color.WHITE);
		lblCharLevel.setLocation(5, 45);
		this.add(lblCharLevel);

		charLevelValue = new JLabel();
		charLevelValue.setSize(20, 20);
		charLevelValue.setForeground(Color.WHITE);
		charLevelValue.setLocation(190, 45);
		this.add(charLevelValue);

		lblStrength = new JLabel("Strength:");
		lblStrength.setSize(180, 20);
		lblStrength.setForeground(Color.WHITE);
		lblStrength.setLocation(5, 65);
		this.add(lblStrength);

		strengthValue = new JLabel();
		strengthValue.setSize(20, 20);
		strengthValue.setForeground(Color.WHITE);
		strengthValue.setLocation(190, 65);
		this.add(strengthValue);

		lblDexterity = new JLabel("Dexterity:");
		lblDexterity.setSize(180, 20);
		lblDexterity.setForeground(Color.WHITE);
		lblDexterity.setLocation(5, 85);
		this.add(lblDexterity);

		dexterityValue = new JLabel();
		dexterityValue.setSize(20, 20);
		dexterityValue.setForeground(Color.WHITE);
		dexterityValue.setLocation(190, 85);
		this.add(dexterityValue);

		lblConstitution = new JLabel("Constitution:");
		lblConstitution.setSize(180, 20);
		lblConstitution.setForeground(Color.WHITE);
		lblConstitution.setLocation(5, 105);
		this.add(lblConstitution);

		constitutionValue = new JLabel();
		constitutionValue.setSize(20, 20);
		constitutionValue.setForeground(Color.WHITE);
		constitutionValue.setLocation(190, 105);
		this.add(constitutionValue);

		lblWisdom = new JLabel("Wisdom:");
		lblWisdom.setSize(180, 20);
		lblWisdom.setForeground(Color.WHITE);
		lblWisdom.setLocation(5, 125);
		this.add(lblWisdom);

		wisdomValue = new JLabel();
		wisdomValue.setSize(20, 20);
		wisdomValue.setForeground(Color.WHITE);
		wisdomValue.setLocation(190, 125);
		this.add(wisdomValue);

		lblCharisma = new JLabel("Charisma:");
		lblCharisma.setSize(180, 20);
		lblCharisma.setForeground(Color.WHITE);
		lblCharisma.setLocation(5, 145);
		this.add(lblCharisma);

		charismaValue = new JLabel();
		charismaValue.setSize(20, 20);
		charismaValue.setForeground(Color.WHITE);
		charismaValue.setLocation(190, 145);
		this.add(charismaValue);

		lblIntelligence = new JLabel("Intelligence:");
		lblIntelligence.setSize(180, 20);
		lblIntelligence.setForeground(Color.WHITE);
		lblIntelligence.setLocation(5, 165);
		this.add(lblIntelligence);

		intelligenceValue = new JLabel("0");
		intelligenceValue.setSize(20, 20);
		intelligenceValue.setForeground(Color.WHITE);
		intelligenceValue.setLocation(190, 165);
		this.add(intelligenceValue);

		lblHitpoint = new JLabel("Hitpoint:");
		lblHitpoint.setSize(180, 20);
		lblHitpoint.setForeground(Color.WHITE);
		lblHitpoint.setLocation(5, 185);
		this.add(lblHitpoint);

		hitpointValue = new JLabel();
		hitpointValue.setSize(50, 20);
		hitpointValue.setForeground(Color.WHITE);
		hitpointValue.setLocation(190, 185);
		this.add(hitpointValue);
		
		armorClassLabel= new JLabel("Armor Class:");
		armorClassLabel.setSize(180, 20);
		armorClassLabel.setForeground(Color.WHITE);
		armorClassLabel.setLocation(5, 205);
		this.add(armorClassLabel);
		
		armorClassValue= new JLabel();
		armorClassValue.setSize(180, 20);
		armorClassValue.setForeground(Color.WHITE);
		armorClassValue.setLocation(190, 205);
		this.add(armorClassValue);
		
		attackBonusLabel= new JLabel("Attack Bonus:");
		attackBonusLabel.setSize(180, 20);
		attackBonusLabel.setForeground(Color.WHITE);
		attackBonusLabel.setLocation(5, 225);
		this.add(attackBonusLabel);
		
		attackBonusValue= new JLabel();
		attackBonusValue.setSize(180, 20);
		attackBonusValue.setForeground(Color.WHITE);
		attackBonusValue.setLocation(190, 225);
		this.add(attackBonusValue);

		inventoryBtn = new JButton("Inventory View");
		inventoryBtn.setSize(150, 30);
		inventoryBtn.setLocation(50, 255);
		this.add(inventoryBtn);
		
		 playerImage=new JLabel(new ImageIcon(new ImageIcon(
					"image/Chest.jpg").getImage().getScaledInstance(50,
					50, java.awt.Image.SCALE_SMOOTH)));
		 playerImage.setLocation(5,300);
		 playerImage.setSize(50,50);
		 this.add(playerImage);
		 lblPlayer=new JLabel("player");
		 lblPlayer.setLocation(5, 360);
		 lblPlayer.setSize(60, 20);
		 lblPlayer.setForeground(Color.WHITE);
		 this.add(lblPlayer);
		 playerName=new JLabel();
		 playerName.setLocation(65, 360);
		 playerName.setSize(60, 20);
		 playerName.setForeground(Color.WHITE);
		 this.add(playerName);
		 lblHp=new JLabel("Hitpoint");
		 lblHp.setLocation(5,390);
		 lblHp.setSize(60,20);
		 lblHp.setForeground(Color.WHITE);
		 this.add(lblHp);
		 playerHp=new JLabel();
		 playerHp.setLocation(65, 390);
		 playerHp.setSize(60, 20);
		 playerHp.setForeground(Color.WHITE);
		 this.add(playerHp);
		 lblplayArmor=new JLabel("Armor");
		 lblplayArmor.setSize(60,20);
		 lblplayArmor.setLocation(5, 415);
		 lblplayArmor.setForeground(Color.WHITE);
		 this.add(lblplayArmor);
		 
		 playerArmor=new JLabel();
		 playerArmor.setLocation(65, 415);
		 playerArmor.setSize(60, 20);
		 playerArmor.setForeground(Color.WHITE);
		 this.add(playerArmor);
		 
		 attackerImage=new JLabel(new ImageIcon(new ImageIcon(
					"image/Chest.jpg").getImage().getScaledInstance(50,
					50, java.awt.Image.SCALE_SMOOTH)));
		 attackerImage.setLocation(120, 300);
		 attackerImage.setSize(50, 50);
		 this.add(attackerImage);
		 lblAtkName=new JLabel("Character");
		 lblAtkName.setSize(60, 20);
		 lblAtkName.setLocation(120, 360);
		 lblAtkName.setForeground(Color.WHITE);
		 this.add(lblAtkName);
		 attackerName=new JLabel();
		 attackerName.setSize(60,20 );
		 attackerName.setLocation(185, 360);
		 attackerName.setForeground(Color.WHITE);
		 this.add(attackerName);
		 atkHp=new JLabel("Hitpoint");
		 atkHp.setLocation(120, 390);
		 atkHp.setSize(60, 20);
		 atkHp.setForeground(Color.WHITE);
		 this.add(atkHp);
		 attackerHp=new JLabel();
		 attackerHp.setSize(60, 20);
		 attackerHp.setLocation(185, 390);
		 attackerHp.setForeground(Color.WHITE);
		 this.add(attackerHp);
		 lblAtkArmor=new JLabel("Armor");
		 lblAtkArmor.setSize(60,20);
		 lblAtkArmor.setLocation(120, 415);
		 lblAtkArmor.setForeground(Color.WHITE);
		 this.add(lblAtkArmor);
		 attackerArmor=new JLabel();
		 attackerArmor.setSize(60, 20);
		 attackerArmor.setLocation(185, 415);
		 attackerArmor.setForeground(Color.WHITE);
		 this.add(attackerArmor);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		player = (CharacterModel)o;
		setPanel();		
	}
	public void setPanel(){
		strengthValue.setText(String.valueOf(character.getAbilityScore().getStrength()));
		constitutionValue.setText(String.valueOf(character.getAbilityScore().getConstitution()));
		intelligenceValue.setText(String.valueOf(character.getAbilityScore().getIntelligence()));
		wisdomValue.setText(String.valueOf(character.getAbilityScore().getStrength()));
		charismaValue.setText(String.valueOf(character.getAbilityScore().getCharisma()));
		dexterityValue.setText(String.valueOf(character.getAbilityScore().getDexterity()));
		charNameValue.setText(character.getName());
		charTypeValue.setText(character.getType());
		hitpointValue.setText(String.valueOf(character.getHitPoints()));
		charLevelValue.setText(String.valueOf(character.getLevel()));
		armorClassValue.setText(String.valueOf(character.getArmorClass()));
		attackBonusValue.setText(String.valueOf(character.getAttackBonus()));
		
		
	}

}
