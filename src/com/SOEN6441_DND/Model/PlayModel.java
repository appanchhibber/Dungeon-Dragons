package com.SOEN6441_DND.Model;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.SOEN6441_DND.Controller.DiceRollController;
import com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon;

/**
 * 
 * @author Appan Chhibber
 *
 */
public class PlayModel {
	public HashMap<String, CharacterModel> characters;
	public HashMap<String, Integer> characterTurn;
	private String[] playOrder;
	DiceRollController diceController;

	public PlayModel() {
		characters = new HashMap<String, CharacterModel>();
		diceController = new DiceRollController(1, 20);
		characterTurn = new HashMap<String, Integer>();
	}

	public String[] getPlayOrder() {
		return playOrder;
	}

	public void setPlayOrder() {
		for (Map.Entry<String, CharacterModel> character : characters.entrySet()) {
			int result = diceController.getDiceRollResult();
			// System.out.println(character.getValue().getName()+" :
			// "+character.getValue().getAbilityModifier().getDexterity()+" + "+
			// result);
			characterTurn.put(character.getKey(), (character.getValue().getAbilityModifier().getDexterity() + result));
			
		}
		
		characterTurn=(HashMap<String, Integer>) sortByValue(characterTurn);
		System.out.println(characterTurn.keySet());
		playOrder= characterTurn.keySet().toArray(new String[characterTurn.keySet().size()]);
	}
	
	

	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		
		return result;
	}

	public HashMap<String, CharacterModel> getCharacters() {
		return characters;
	}

	public void addCharacter(String name, CharacterModel charModel) {
		this.characters.put(name, charModel);
	}

	public void removeCharacter(String name) {
		this.characters.remove(name);
	}

}
