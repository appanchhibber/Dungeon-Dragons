package com.SOEN6441_DND.Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Views.AbilityPanelView;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemAssignView;

/**
 * This Class is responsible for handle all the view Events.
 * 
 * @author Punit Trivedi
 * @author Appan Chhibber
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
	public ItemAssignView itemAssignView;
	public FileOperationModel fileModel;
	public Array backPackItems;

	// public String

	public CharacterSceneController(CharacterScene view) {
		this.characterScreen = view;
		this.characterModel = view.characterViewModel;
		fileModel = new FileOperationModel();
		this.score = view.abilityViewModel;
		this.abilityPanel = view.abilityPanel;
		abilityModifier = view.characterViewModel.getAbilityModifier();
		abilityScore = view.characterViewModel.getAbilityScore();
		diceRoll = new DiceRollController(4, 6); // Dice type 4d6
		itemAssignView = view.itemAssignView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JRadioButton) {

			switch (((JRadioButton) e.getSource()).getText()) {
			case "Human": {
				characterModel.setImage("Human");
				characterModel.setType("Human");
				break;
			}
			case "Dwarf": {
				characterModel.setImage("Dwarf");
				characterModel.setType("Dwarf");

				break;
			}
			case "Elf": {
				characterModel.setImage("Elf");
				characterModel.setType("Elf");
				break;
			}
			case "Orc": {
				characterModel.setImage("Orc");
				characterModel.setType("Orc");
				break;
			}

			}
			setModifer();
			resetScore();

		} else if (e.getSource() == abilityPanel.calculateButton) {
			score.setStrength(diceRoll.getDiceRollResult());
			score.setDexterity(diceRoll.getDiceRollResult());
			score.setConstitution(diceRoll.getDiceRollResult());
			score.setIntelligence(diceRoll.getDiceRollResult());
			score.setWisdom(diceRoll.getDiceRollResult());
			score.setCharisma(diceRoll.getDiceRollResult());
			setModifer();
			abilityModifier.setStrength(abilityModifier.getStrength() + modifierCalculator(score.getStrength()));
			abilityModifier.setDexterity(abilityModifier.getDexterity() + modifierCalculator(score.getDexterity()));
			abilityModifier
					.setConstitution(abilityModifier.getConstitution() + modifierCalculator(score.getConstitution()));
			abilityModifier
					.setIntelligence(abilityModifier.getIntelligence() + modifierCalculator(score.getIntelligence()));
			abilityModifier.setWisdom(abilityModifier.getWisdom() + modifierCalculator(score.getWisdom()));
			abilityModifier.setCharisma(abilityModifier.getCharisma() + modifierCalculator(score.getCharisma()));
		} else if (e.getSource() == characterScreen.levels) {
			characterModel.setLevel(Integer.parseInt(characterScreen.levels.getSelectedItem().toString()));
		}

		else if (e.getSource() == characterScreen.navMenuPanel.nextButton) {
			GameController.getInstance().mainFrame.setView(itemAssignView);
		} else if (e.getSource() == itemAssignView.charBackButton) {
			itemAssignView.setVisible(false);
			GameController.getInstance().mainFrame.setView(characterScreen);
		} else if (e.getSource() == characterScreen.navMenuPanel.saveButton) {
			if (characterScreen.nameText.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Please enter the name of the character");
			} else {
				characterModel.setName(characterScreen.nameText.getText());
				try {
					JOptionPane.showMessageDialog(null, fileModel.writeCharacter(characterScreen));
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == itemAssignView.itemType) {
			File f1 = new File("itemSave/" + itemAssignView.itemType.getSelectedItem().toString() + ".xml");
			Map<String, ArrayList<String>> items = new FileOperationModel().readSaveItemFile(f1);
			if (items.isEmpty()) {
				itemAssignView.subItemType.removeAllItems();
			} else {
				itemAssignView.subItemType.setModel(new DefaultComboBoxModel(items.keySet().toArray()));
			}
		} else if (e.getSource() == itemAssignView.backpackAssign) {
			if (itemAssignView.subItemType.getSelectedItem() != null) {
				String item = itemAssignView.subItemType.getSelectedItem().toString();
				if (characterModel.getBackPackCounter() < 11) {
					if (characterModel.getBackPackItems().contains(item)) {
						JOptionPane.showMessageDialog(null, "This Item is already inside the Backpack");
					} else {
						itemAssignView.backPackModel.addElement(item);
						itemAssignView.backPackList.setModel(itemAssignView.backPackModel);
						characterModel.setBackPackCounter(characterModel.getBackPackCounter() + 1);
						characterModel.addBackPackItems(item);
					}
				} else {
					JOptionPane.showMessageDialog(null, "You can store only 10 items in your Backpack");
				}
			}

		} else if (e.getSource() == itemAssignView.backpackAssign) {

		}

		characterModel.setAbilityModifier(abilityModifier);
		abilityScore.setStrength(score.getStrength() + abilityModifier.getStrength());
		abilityScore.setDexterity(score.getDexterity() + abilityModifier.getDexterity());
		abilityScore.setConstitution(score.getConstitution() + abilityModifier.getConstitution());
		abilityScore.setIntelligence(score.getIntelligence() + abilityModifier.getIntelligence());
		abilityScore.setCharisma(score.getCharisma() + abilityModifier.getCharisma());
		abilityScore.setWisdom(score.getWisdom() + abilityModifier.getWisdom());
		characterModel.setAbilityScore(abilityScore);

	}

	public void resetScore() {
		score.setStrength(0);
		score.setDexterity(0);
		score.setConstitution(0);
		score.setIntelligence(0);
		score.setWisdom(0);
		score.setCharisma(0);
	}

	public void setModifer() {
		abilityModifier.setStrength(0);
		abilityModifier.setDexterity(0);
		abilityModifier.setConstitution(0);
		abilityModifier.setIntelligence(0);
		abilityModifier.setWisdom(0);
		abilityModifier.setCharisma(0);
		switch (characterModel.getType()) {
		case "Human": {
			break;
		}
		case "Dwarf": {
			abilityModifier.setConstitution(2);
			abilityModifier.setIntelligence(-2);
			break;
		}
		case "Elf": {
			abilityModifier.setDexterity(2);
			abilityModifier.setConstitution(-2);
			break;
		}
		case "Orc": {
			abilityModifier.setStrength(2);
			abilityModifier.setIntelligence(-2);
			abilityModifier.setCharisma(-2);
			break;
		}

		}
	}

	public int modifierCalculator(int score) {

		return ((score / 2) - 5);
	}

}
