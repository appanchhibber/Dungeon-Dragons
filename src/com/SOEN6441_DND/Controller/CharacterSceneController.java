package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Views.AbilityPanelView;
import com.SOEN6441_DND.Views.CharacterScene;
/**
 * This Class is responsible for handle all the view Events.
 * @author Punit Trivedi
 * @author  Appan Chhibber
 *
 */
public class CharacterSceneController implements ActionListener {
	public CharacterModel characterModel;
	public CharacterScene characterScreen;
	public DiceRollController diceRoll;
	public AbilitiyModel score;
	public AbilitiyModel abilityModifier;
	public AbilitiyModel abilityScore;
	public AbilityPanelView abilityPanel;

	public CharacterSceneController(CharacterScene view) {
		this.characterScreen = view;
		this.characterModel = view.characterViewModel;
		this.score=view.abilityViewModel;
		this.abilityPanel=view.abilityPanel;
		abilityModifier=view.characterViewModel.getAbilityModifier();
		abilityScore=view.characterViewModel.getAbilityScore();
		diceRoll=new DiceRollController(4, 6); //Dice type 4d6
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JRadioButton) {
			abilityModifier.setStrength(0);
			abilityModifier.setDexterity(0);
			abilityModifier.setConstitution(0);
			abilityModifier.setIntelligence(0);
			abilityModifier.setWisdom(0);
			abilityModifier.setCharisma(0);
			switch (((JRadioButton) e.getSource()).getText()) {
			case "Human": {
				characterModel.setImage("Human");
				break;
			}
			case "Dwarf": {
				characterModel.setImage("Dwarf");
				abilityModifier.setConstitution(2);
				abilityModifier.setIntelligence(-2);
				
				break;
			}
			case "Elf": {
				characterModel.setImage("Elf");
				abilityModifier.setDexterity(2);
				abilityModifier.setConstitution(-2);
				break;
			}
			case "Orc": {
				characterModel.setImage("Orc");
				abilityModifier.setStrength(2);
				abilityModifier.setIntelligence(-2);
				abilityModifier.setCharisma(-2);
				break;
			}
			
			}
			resetScore();
			
		} else if (e.getSource() == abilityPanel.calculateButton) {
			score.setStrength(diceRoll.getDiceRollResult());
			score.setDexterity(diceRoll.getDiceRollResult());
			score.setConstitution(diceRoll.getDiceRollResult());
			score.setIntelligence(diceRoll.getDiceRollResult());
			score.setWisdom(diceRoll.getDiceRollResult());
			score.setCharisma(diceRoll.getDiceRollResult());
			abilityModifier.setStrength(abilityModifier.getStrength()+modifierCalculator(score.getStrength()));
			abilityModifier.setDexterity(abilityModifier.getDexterity()+modifierCalculator(score.getDexterity()));
			abilityModifier.setConstitution(abilityModifier.getConstitution()+modifierCalculator(score.getConstitution()));
			abilityModifier.setIntelligence(abilityModifier.getIntelligence()+modifierCalculator(score.getIntelligence()));
			abilityModifier.setWisdom(abilityModifier.getWisdom()+modifierCalculator(score.getWisdom()));
			abilityModifier.setCharisma(abilityModifier.getCharisma()+modifierCalculator(score.getCharisma()));	
		}
		characterModel.setAbilityModifier(abilityModifier);
		abilityScore.setStrength(score.getStrength()+abilityModifier.getStrength());
		abilityScore.setDexterity(score.getDexterity()+abilityModifier.getDexterity());
		abilityScore.setConstitution(score.getConstitution()+abilityModifier.getConstitution());
		abilityScore.setIntelligence(score.getIntelligence()+abilityModifier.getIntelligence());
		abilityScore.setCharisma(score.getCharisma()+abilityModifier.getCharisma());
		abilityScore.setWisdom(score.getWisdom()+abilityModifier.getWisdom());
		characterModel.setAbilityScore(abilityScore);
		
	}
	public void resetScore(){
		score.setStrength(0);
		score.setDexterity(0);
		score.setConstitution(0);
		score.setIntelligence(0);
		score.setWisdom(0);
		score.setCharisma(0);
	}
	public int modifierCalculator(int score){
		
		if(score==4 || score==5 ){
			return -3;
		}
		else if(score==6 || score==7){
			return -2;
		}
		else if(score==6 || score==7){
			return -2;
		}
		else if(score==8 || score==9){
			return -1;
		}
		else if(score==10 || score==11){
			return 0;
		}
		else if(score==12 || score==13){
			return 1;
		}
		else if(score==14 || score==15){
			return 2;
		}
		else if(score==16 || score==17){
			return 3;
		}
		else if(score==18 || score==19){
			return 4;
		}
		else if(score==20 || score==21){
			return 5;
		}
		else if(score==22 || score==23){
			return 6;
		}
		else if(score==24){
			return 7;
		}
		return 0;
	}
	
	

}
