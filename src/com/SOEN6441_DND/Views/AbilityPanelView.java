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
	public JLabel modiferLabel;
	public JLabel abilityLabel;
	
	
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
				abilityLabel=new JLabel("Ability Score");
				abilityLabel.setLocation(150, 5);
				abilityLabel.setForeground(Color.WHITE);
				abilityLabel.setSize(100,20);
				modiferLabel=new JLabel("Modifiers");
				modiferLabel.setLocation(300, 5);
				modiferLabel.setForeground(Color.WHITE);
				modiferLabel.setSize(60,20);

				
				
				// TextField
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
				strengthScoreText.setLocation(150, 30);
				strengthScoreText.setSize(50, 40);
				strengthScoreText.setEditable(false);
				strengthModifierText.setLocation(300,30);
				strengthModifierText.setSize(50,40);
				strengthModifierText.setEditable(false);
				
				
				
				dexterityLabel.setLocation(30,110);
				dexterityLabel.setForeground(Color.WHITE);
				dexterityLabel.setSize(80, 20);
				dexterityScoreText.setLocation(150, 100);
				dexterityScoreText.setSize(50, 40);
				dexterityScoreText.setEditable(false);
				dexterityModifierText.setLocation(300, 100);
				dexterityModifierText.setSize(50, 40);
				dexterityModifierText.setEditable(false);
			
				
				constitutionLabel.setLocation(30,180);
				constitutionLabel.setForeground(Color.WHITE);
				constitutionLabel.setSize(120, 20);
				constitutionScoreText.setLocation(150, 170);
				constitutionScoreText.setSize(50, 40);
				constitutionScoreText.setEditable(false);
				constitutionModifierText.setLocation(300, 170);
				constitutionModifierText.setSize(50, 40);
				constitutionModifierText.setEditable(false);

				
				intelligenceLabel.setLocation(30,250);
				intelligenceLabel.setForeground(Color.WHITE);
				intelligenceLabel.setSize(120, 20);
				intelligenceScoreText.setLocation(150, 240);
				intelligenceScoreText.setSize(50, 40);
				intelligenceScoreText.setEditable(false);
				intelligenceModifierText.setLocation(300, 240);
				intelligenceModifierText.setSize(50, 40);
				intelligenceModifierText.setEditable(false);
				
				wisdomLabel.setLocation(30,320);
				wisdomLabel.setForeground(Color.WHITE);
				wisdomLabel.setSize(80, 20);
				wisdomScoreText.setLocation(150, 310);
				wisdomScoreText.setSize(50, 40);
				wisdomScoreText.setEditable(false);
				wisdomModifierText.setLocation(300, 310);
				wisdomModifierText.setSize(50, 40);
				wisdomModifierText.setEditable(false);

				
				charismaLabel.setLocation(30,390);
				charismaLabel.setForeground(Color.WHITE);
				charismaLabel.setSize(80, 20);
				charismaScoreText.setLocation(150, 380);
				charismaScoreText.setSize(50, 40);
				charismaScoreText.setEditable(false);
				charismaModifierText.setLocation(300, 380);
				charismaModifierText.setSize(50, 40);
				charismaModifierText.setEditable(false);
				
				calculateButton.setLocation(50,425);
				calculateButton.setSize(200, 40);	
				
				
				add(modiferLabel);
				add(abilityLabel);
				add(strengthLabel);
				add(dexterityLabel);
				add(constitutionLabel);
				add(intelligenceLabel);
				add(wisdomLabel);
				add(charismaLabel);
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
	/**
	 * This function sets ability modifiers from he model to the view.
	 */
	public void setAbilityScorePanel()
	{
		strengthScoreText.setText(String.valueOf(abilityViewModel.getStrength()));
		constitutionScoreText.setText(String.valueOf(abilityViewModel.getConstitution()));
		dexterityScoreText.setText(String.valueOf(abilityViewModel.getDexterity()));
		intelligenceScoreText.setText(String.valueOf(abilityViewModel.getIntelligence()));
		wisdomScoreText.setText(String.valueOf(abilityViewModel.getWisdom()));
		charismaScoreText.setText(String.valueOf(abilityViewModel.getCharisma()));
	}
	public void setAbilityModifierPanel()
	{
		strengthModifierText.setText(String.valueOf(abilityViewModel.getStrength()));
		constitutionModifierText.setText(String.valueOf(abilityViewModel.getConstitution()));
		dexterityModifierText.setText(String.valueOf(abilityViewModel.getDexterity()));
		intelligenceModifierText.setText(String.valueOf(abilityViewModel.getIntelligence()));
		wisdomModifierText.setText(String.valueOf(abilityViewModel.getWisdom()));
		charismaModifierText.setText(String.valueOf(abilityViewModel.getCharisma()));
	}
    

	@Override
	public void update(Observable o, Object arg) {
		abilityViewModel=(AbilityModel)o;
		// TODO Auto-generated method stub
		System.out.println("Update"+abilityViewModel.getType());
		if(((AbilityModel)o).getType()=="abilityScore"){
			
			setAbilityScorePanel();
		}
		else if(((AbilityModel)o).getType()=="abilityModifier"){
			setAbilityModifierPanel();
		}
		
		
	}
	
}
