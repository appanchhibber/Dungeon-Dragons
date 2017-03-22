package com.SOEN6441_DND.Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.ItemModel.itemTypeList;
import com.SOEN6441_DND.Views.AbilityPanelView;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemAssignView;

import Builder.BullyCharacterBuilder;
import Builder.CharacterBuilder;
import Builder.NimbleCharacterBuilder;
import Builder.TankCharacterBuilder;

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
	public AbilityModel score;
	public AbilityModel abilityModifier;
	public AbilityModel abilityScore;
	public AbilityPanelView abilityPanel;
	public ItemAssignView itemAssignView;
	public FileOperationModel fileModel;
	public Array backPackItems;
	public CharacterBuilder characterBuilder;

	// public String

	public CharacterSceneController() {

	}

	public static CharacterSceneController getInstance() {
		return new CharacterSceneController();
	}

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
				characterModel.setImage("image/Human.jpg");
				characterModel.setType("Human");
				break;
			}
			case "Dwarf": {
				characterModel.setImage("image/Dwarf.jpg");
				characterModel.setType("Dwarf");

				break;
			}
			case "Elf": {
				characterModel.setImage("image/Elf.jpg");
				characterModel.setType("Elf");
				break;
			}
			case "Orc": {
				characterModel.setImage("image/Orc.jpg");
				characterModel.setType("Orc");
				break;
			}

			}
			setModifer();
			resetScore();
			calculateAbility();
		}

		else if (e.getSource() == characterScreen.bully) {
			createCharacter("bully");
			calculateAbility();
		} else if (e.getSource() == characterScreen.nimble) {
			createCharacter("nimble");
			calculateAbility();
		} else if (e.getSource() == characterScreen.tank) {
			createCharacter("tank");
			calculateAbility();
		}

		else if (e.getSource() == abilityPanel.calculateButton) {
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
			calculateAbility();
		} else if (e.getSource() == characterScreen.levels) {
			characterModel.setLevel(Integer.parseInt(characterScreen.levels.getSelectedItem().toString()));
			calculateAbility();
		} else if (e.getSource() == characterScreen.navMenuPanel.loadButton) {
			File file = openCharFile();
			abilityPanel.calculateButton.setVisible(true);
			characterScreen.bully.setVisible(true);
			characterScreen.nimble.setVisible(true);
			characterScreen.tank.setVisible(true);
			characterScreen.characterTypeRadio[0].setVisible(true);
			characterScreen.characterTypeRadio[1].setVisible(true);
			characterScreen.characterTypeRadio[2].setVisible(true);
			characterScreen.characterTypeRadio[3].setVisible(true);
			fileModel.setCharacterModel(characterModel);
			itemAssignView.setCharacterModel(characterModel);
			try {
				fileModel.loadCharacter(file.getName().replace(".xml", ""));
				
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (e.getSource() == characterScreen.navMenuPanel.nextButton) {
			GameController.getInstance().mainFrame.setView(itemAssignView);
			abilityPanel.calculateButton.setVisible(false);
			characterScreen.bully.setVisible(false);
			characterScreen.nimble.setVisible(false);
			characterScreen.tank.setVisible(false);
			characterScreen.characterTypeRadio[0].setVisible(false);
			characterScreen.characterTypeRadio[1].setVisible(false);
			characterScreen.characterTypeRadio[2].setVisible(false);
			characterScreen.characterTypeRadio[3].setVisible(false);
			if (characterModel.getArmorClass() == 0) {
				characterModel.setArmorClass(characterModel.getAbilityModifier().getDexterity());
			}
			if (characterModel.getDamageBonus() == 0) {
				characterModel.setDamageBonus(0);
			}
			calculateAbility();
		} else if (e.getSource() == itemAssignView.charBackButton) {
			itemAssignView.setVisible(false);
			GameController.getInstance().mainFrame.setView(characterScreen);
		} else if (e.getSource() == characterScreen.navMenuPanel.saveButton) {
			if (characterScreen.nameText.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "Please enter the name of the character");
			} else {
				characterModel.setName(characterScreen.nameText.getText());
				try {
					JOptionPane.showMessageDialog(null, fileModel.writeCharacter(characterScreen.characterViewModel));
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == itemAssignView.itemType) {
			File f1 = new File("itemSave/" + itemAssignView.itemType.getSelectedItem() + ".xml");
			Map<String, ArrayList<String>> items = new FileOperationModel().readSaveItemFile(f1);
			if (items.isEmpty()) {
				itemAssignView.subItemType.removeAllItems();
			} else {
				itemAssignView.subItemType.setModel(new DefaultComboBoxModel(items.keySet().toArray()));
			}
		}  
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

	/**
	 * Calculate the ability scores
	 */
	public void calculateAbility() {
		abilityScore.setStrength(score.getStrength() + abilityModifier.getStrength());
		abilityScore.setDexterity(score.getDexterity() + abilityModifier.getDexterity());
		abilityScore.setConstitution(score.getConstitution() + abilityModifier.getConstitution());
		abilityScore.setIntelligence(score.getIntelligence() + abilityModifier.getIntelligence());
		abilityScore.setCharisma(score.getCharisma() + abilityModifier.getCharisma());
		abilityScore.setWisdom(score.getWisdom() + abilityModifier.getWisdom());
		characterModel.calculateChar();
	}

	public int modifierCalculator(int score) {

		return ((score / 2) - 5);
	}

	/**
	 * This function opens and returns the file character file already created.
	 * 
	 * @return
	 */
	public File openCharFile() {
		JFileChooser fileChooser = new JFileChooser(new File("characters/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(characterScreen);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		} else {
			return null;
		}

	}

	/**
	 * Creates character of the fighter class beased on user selection
	 * 
	 * @param charType
	 *            Accepts the type of fighter user selected.
	 */
	public void createCharacter(String charType) {

		CharacterBuilder cb;
		int[] scoreArray = new int[6];
		scoreArray[0] = score.getStrength();
		scoreArray[1] = score.getConstitution();
		scoreArray[2] = score.getDexterity();
		scoreArray[3] = score.getIntelligence();
		scoreArray[4] = score.getCharisma();
		scoreArray[5] = score.getWisdom();

		Arrays.sort(scoreArray);
		for (int i = 0; i < scoreArray.length / 2; i++) {
			int temp = scoreArray[i];
			scoreArray[i] = scoreArray[scoreArray.length - 1 - i];
			scoreArray[scoreArray.length - 1 - i] = temp;
		}
		if (charType.equals("bully")) {
			characterBuilder = new BullyCharacterBuilder(score, scoreArray);

		} else if (charType.equals("nimble")) {
			characterBuilder = new NimbleCharacterBuilder(score, scoreArray);

		} else if (charType.equals("tank")) {
			characterBuilder = new TankCharacterBuilder(score, scoreArray);

		}

		characterBuilder.buildStrength();
		characterBuilder.buildCharisma();
		characterBuilder.buildConstitution();
		characterBuilder.buildDexterity();
		characterBuilder.buildWisdom();
		characterBuilder.buildIntelligence();
		setModifer();
		abilityModifier.setStrength(abilityModifier.getStrength() + modifierCalculator(score.getStrength()));
		abilityModifier.setDexterity(abilityModifier.getDexterity() + modifierCalculator(score.getDexterity()));
		abilityModifier
				.setConstitution(abilityModifier.getConstitution() + modifierCalculator(score.getConstitution()));
		abilityModifier
				.setIntelligence(abilityModifier.getIntelligence() + modifierCalculator(score.getIntelligence()));
		abilityModifier.setWisdom(abilityModifier.getWisdom() + modifierCalculator(score.getWisdom()));
		abilityModifier.setCharisma(abilityModifier.getCharisma() + modifierCalculator(score.getCharisma()));

	}

}
