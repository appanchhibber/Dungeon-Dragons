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
	public AbilitiyModel abilityModel;
	public AbilityPanelView abilityPanel;

	public CharacterSceneController(CharacterScene view) {
		this.characterScreen = view;
		this.characterModel = view.characterViewModel;
		this.abilityModel=view.abilityViewModel;
		this.abilityPanel=view.abilityPanel;
		diceRoll=new DiceRollController(4, 6); //Dice type 4d6
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JRadioButton) {
			switch (((JRadioButton) e.getSource()).getText()) {
			case "Human": {
				characterModel.setImage("Human");
				break;
			}
			case "Dwarf": {
				characterModel.setImage("Dwarf");
				break;
			}
			case "Elf": {
				characterModel.setImage("Elf");
				break;
			}
			case "Orc": {
				characterModel.setImage("Orc");
				break;
			}

			}
		} else if (e.getSource() == abilityPanel.calculateButton) {
			abilityModel.setStrength(diceRoll.getDiceRollResult());
			abilityModel.setDexterity(diceRoll.getDiceRollResult());
			abilityModel.setConstitution(diceRoll.getDiceRollResult());
			abilityModel.setIntelligence(diceRoll.getDiceRollResult());
			abilityModel.setWisdom(diceRoll.getDiceRollResult());
			abilityModel.setCharisma(diceRoll.getDiceRollResult());
			abilityModel.setAbilities(abilityModel);
		}
	}

}
