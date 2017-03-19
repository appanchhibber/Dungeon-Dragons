package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.SOEN6441_DND.Model.AbilityModel;

/**
 * 
 * @author Punit Trivedi
 *
 */
public class AbilityPanelView extends View implements Observer{
	//Ability Labels
	public JLabel strengthLabel;
	public JLabel dexterityLabel;
	public JLabel constitutionLabel;
	public JLabel intelligenceLabel;
	public JLabel wisdomLabel;
	public JLabel charismaLabel;
	public JLabel scoreLabel;
	public JLabel modiferLabel;
	public JLabel abilityLabel;
	
	
	//Ability TextFields
	public JTextField strengthText;
	public JTextField dexterityText;
	public JTextField constitutionText;
	public JTextField intelligenceText;
	public JTextField wisdomText;
	public JTextField charismaText;
	
	//Ability Modifier
	public JTextField strengthModifierText;
	public JTextField dexterityModifierText;
	public JTextField constitutionModifierText;
	public JTextField intelligenceModifierText;
	public JTextField wisdomModifierText;
	public JTextField charismaModifierText;

	//Ability Score
	public JTextField strengthScoreText;
	public JTextField dexterityScoreText;
	public JTextField constitutionScoreText;
	public JTextField intelligenceScoreText;
	public JTextField wisdomScoreText;
	public JTextField charismaScoreText;
	//Buttons
	public JButton calculateButton;

	public AbilityModel abilityViewModel;
	
	@Override
	/**
	 * initSubviews() initializes the view to be used. Setting the default attributes for the view.
	 */
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		setBackground(Color.BLACK);
		setSize(600, 500);
		setLocation(335, 70);
		setVisible(true);
			
				// Labels
				strengthLabel= new JLabel("Strength :");
				dexterityLabel= new JLabel("Dexterity :");
				constitutionLabel= new JLabel("Constitution :");
				intelligenceLabel= new JLabel("Intelligence :");
				wisdomLabel= new JLabel("Wisdom :");
				charismaLabel= new JLabel("Charisma :");
				
				//Labels
				scoreLabel=new JLabel("Score");
				scoreLabel.setLocation(150, 5);
				scoreLabel.setForeground(Color.WHITE);
				scoreLabel.setSize(60,20);
				modiferLabel=new JLabel("Modifiers");
				modiferLabel.setLocation(250, 5);
				modiferLabel.setForeground(Color.WHITE);
				modiferLabel.setSize(60,20);
				abilityLabel= new JLabel("Ability Score");
				abilityLabel.setLocation(350, 5);
				abilityLabel.setForeground(Color.WHITE);
				abilityLabel.setSize(100,20);
				
				
				// TextField
				strengthText= new JTextField();
				dexterityText=new JTextField();
				constitutionText=new JTextField();
				intelligenceText=new JTextField();
				wisdomText=new JTextField();
				charismaText=new JTextField();
				
				strengthModifierText= new JTextField();
				dexterityModifierText=new JTextField();
				constitutionModifierText=new JTextField();
				intelligenceModifierText=new JTextField();
				wisdomModifierText=new JTextField();
				charismaModifierText= new JTextField();
				
				strengthScoreText= new JTextField();
				dexterityScoreText= new JTextField();
				constitutionScoreText= new JTextField();
				intelligenceScoreText=new JTextField();
				wisdomScoreText=new JTextField();
				charismaScoreText= new JTextField();
				
				
				
				calculateButton = new JButton("Calculate Ability");
				
				
				strengthLabel.setLocation(30,40);
				strengthLabel.setForeground(Color.WHITE);
				strengthLabel.setSize(80, 20);
				strengthText.setLocation(150, 30);
				strengthText.setSize(50, 40);
				strengthText.setEditable(false);
				strengthModifierText.setLocation(250,30);
				strengthModifierText.setSize(50,40);
				strengthModifierText.setEditable(false);
				strengthScoreText.setLocation(350,30);
				strengthScoreText.setSize(50,40);
				strengthScoreText.setEditable(false);
				
				
				dexterityLabel.setLocation(30,110);
				dexterityLabel.setForeground(Color.WHITE);
				dexterityLabel.setSize(80, 20);
				dexterityText.setLocation(150, 100);
				dexterityText.setSize(50, 40);
				dexterityText.setEditable(false);
				dexterityModifierText.setLocation(250, 100);
				dexterityModifierText.setSize(50, 40);
				dexterityModifierText.setEditable(false);
				dexterityScoreText.setLocation(350, 100);
				dexterityScoreText.setSize(50, 40);
				dexterityScoreText.setEditable(false);
				
				constitutionLabel.setLocation(30,180);
				constitutionLabel.setForeground(Color.WHITE);
				constitutionLabel.setSize(120, 20);
				constitutionText.setLocation(150, 170);
				constitutionText.setSize(50, 40);
				constitutionText.setEditable(false);
				constitutionModifierText.setLocation(250, 170);
				constitutionModifierText.setSize(50, 40);
				constitutionModifierText.setEditable(false);
				constitutionScoreText.setLocation(350, 170);
				constitutionScoreText.setSize(50, 40);
				constitutionScoreText.setEditable(false);
				
				intelligenceLabel.setLocation(30,250);
				intelligenceLabel.setForeground(Color.WHITE);
				intelligenceLabel.setSize(120, 20);
				intelligenceText.setLocation(150, 240);
				intelligenceText.setSize(50, 40);
				intelligenceText.setEditable(false);
				intelligenceModifierText.setLocation(250, 240);
				intelligenceModifierText.setSize(50, 40);
				intelligenceModifierText.setEditable(false);
				intelligenceScoreText.setLocation(350, 240);
				intelligenceScoreText.setSize(50, 40);
				intelligenceScoreText.setEditable(false);
				
				wisdomLabel.setLocation(30,320);
				wisdomLabel.setForeground(Color.WHITE);
				wisdomLabel.setSize(80, 20);
				wisdomText.setLocation(150, 310);
				wisdomText.setSize(50, 40);
				wisdomText.setEditable(false);
				wisdomModifierText.setLocation(250, 310);
				wisdomModifierText.setSize(50, 40);
				wisdomModifierText.setEditable(false);
				wisdomScoreText.setLocation(350, 310);
				wisdomScoreText.setSize(50, 40);
				wisdomScoreText.setEditable(false);
				
				charismaLabel.setLocation(30,390);
				charismaLabel.setForeground(Color.WHITE);
				charismaLabel.setSize(80, 20);
				charismaText.setLocation(150, 380);
				charismaText.setSize(50, 40);
				charismaText.setEditable(false);
				charismaModifierText.setLocation(250, 380);
				charismaModifierText.setSize(50, 40);
				charismaModifierText.setEditable(false);
				charismaScoreText.setLocation(350, 380);
				charismaScoreText.setSize(50, 40);
				charismaScoreText.setEditable(false);
				
				calculateButton.setLocation(50,425);
				calculateButton.setSize(200, 40);	
				
				add(scoreLabel);
				add(modiferLabel);
				add(abilityLabel);
				add(strengthText);
				add(strengthLabel);
				add(dexterityLabel);
				add(dexterityText);
				add(constitutionLabel);
				add(constitutionText);
				add(intelligenceLabel);
				add(intelligenceText);
				add(wisdomLabel);
				add(wisdomText);
				add(charismaLabel);
				add(charismaText);
				add(calculateButton);
				add(strengthModifierText);
				add(dexterityModifierText);
				add(constitutionModifierText);
				add(intelligenceModifierText);
				add(wisdomModifierText);
				add(charismaModifierText);
				add(strengthScoreText);
				add(dexterityScoreText);
				add(constitutionScoreText);
				add(intelligenceScoreText);
				add(wisdomScoreText);
				add(charismaScoreText);
				
	}
	AbilityPanelView(AbilityModel model){
		setAbilityModel(model);
	}
	public void setAbilityModel(AbilityModel model){
		abilityViewModel=model;
		abilityViewModel.addObserver(this);
		setAbilityPanel();
	}
	/**
	 * This function sets ability modifiers from he model to the view.
	 */
	public void setAbilityPanel()
	{
		strengthText.setText(String.valueOf(abilityViewModel.getStrength()));
		constitutionText.setText(String.valueOf(abilityViewModel.getConstitution()));
		dexterityText.setText(String.valueOf(abilityViewModel.getDexterity()));
		intelligenceText.setText(String.valueOf(abilityViewModel.getIntelligence()));
		wisdomText.setText(String.valueOf(abilityViewModel.getWisdom()));
		charismaText.setText(String.valueOf(abilityViewModel.getCharisma()));
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setAbilityPanel();
	}
	
}
