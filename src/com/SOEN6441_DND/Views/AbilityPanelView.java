package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.SOEN6441_DND.Model.AbilitiyModel;


public class AbilityPanelView extends View implements Observer{
	//Ability Labels
	public JLabel strengthLabel;
	public JLabel dexterityLabel;
	public JLabel constitutionLabel;
	public JLabel intelligenceLabel;
	public JLabel wisdomLabel;
	public JLabel charismaLabel;
	
	//Ability TextFields
	public JTextField strengthText;
	public JTextField dexterityText;
	public JTextField constitutionText;
	public JTextField intelligenceText;
	public JTextField wisdomText;
	public JTextField charismaText;
	
	//Buttons
	public JButton calculateButton;

	public AbilitiyModel abilityViewModel;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		setBackground(Color.BLACK);
		setSize(300, 500);
		setLocation(335, 70);
		setVisible(true);
			
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
				
	}
	AbilityPanelView(AbilitiyModel model){
		abilityViewModel=model;
		abilityViewModel.addObserver(this);
		setAbilityPanel();
	}
	
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
