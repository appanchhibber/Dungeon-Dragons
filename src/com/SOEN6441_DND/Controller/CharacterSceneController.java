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
	public AbilitiyModel abilityScore;
	public AbilitiyModel abilityModifier;
	public AbilityPanelView abilityPanel;

	public CharacterSceneController(CharacterScene view) {
		this.characterScreen = view;
		this.characterModel = view.characterViewModel;
		this.abilityScore=view.abilityViewModel;
		this.abilityPanel=view.abilityPanel;
		abilityModifier=view.characterViewModel.getAbilityModifier();
		diceRoll=new DiceRollController(4, 6); //Dice type 4d6
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JRadioButton) {
			switch (((JRadioButton) e.getSource()).getText()) {
			case "Human": {
				characterModel.setImage("Human");
				abilityModifier.setStrength(0);
				abilityModifier.setDexterity(0);
				abilityModifier.setConstitution(0);
				abilityModifier.setIntelligence(0);
				abilityModifier.setWisdom(0);
				abilityModifier.setCharisma(0);
				break;
			}
			case "Dwarf": {
				characterModel.setImage("Dwarf");
				abilityModifier.setStrength(0);
				abilityModifier.setDexterity(0);
				abilityModifier.setConstitution(2);
				abilityModifier.setIntelligence(-2);
				abilityModifier.setWisdom(0);
				abilityModifier.setCharisma(0);
				break;
			}
			case "Elf": {
				characterModel.setImage("Elf");
				abilityModifier.setStrength(0);
				abilityModifier.setDexterity(2);
				abilityModifier.setConstitution(-2);
				abilityModifier.setIntelligence(0);
				abilityModifier.setWisdom(0);
				abilityModifier.setCharisma(0);
				break;
			}
			case "Orc": {
				characterModel.setImage("Orc");
				abilityModifier.setStrength(2);
				abilityModifier.setDexterity(0);
				abilityModifier.setConstitution(0);
				abilityModifier.setIntelligence(-2);
				abilityModifier.setWisdom(0);
				abilityModifier.setCharisma(-2);
				break;
			}

			}
			characterModel.setAbilityModifier(abilityModifier);
		} else if (e.getSource() == abilityPanel.calculateButton) {
			abilityScore.setStrength(diceRoll.getDiceRollResult());
			abilityScore.setDexterity(diceRoll.getDiceRollResult());
			abilityScore.setConstitution(diceRoll.getDiceRollResult());
			abilityScore.setIntelligence(diceRoll.getDiceRollResult());
			abilityScore.setWisdom(diceRoll.getDiceRollResult());
			abilityScore.setCharisma(diceRoll.getDiceRollResult());
			characterModel.setAbilityScore(abilityScore);
		}
	}

}
