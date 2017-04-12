package com.SOEN6441_DND.Model;

import java.util.Observable;

/**
 * This Class Defines all the characteristics and property of the character.
 * 
 * @author Amirbabak Rahgozar
 * @author Paras Malik.
 *
 */

public class AbilityModel extends Observable {

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private String type;

	/**
	 * get the type of ability
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * set the type of ability
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter for intelligence
	 * 
	 * @return
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * setter for intelligence
	 * 
	 * @param intelligence
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		notifyCharacterView();
	}

	/**
	 * getter for strength
	 * 
	 * @return
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * setter for strength
	 * 
	 * @param strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
		notifyCharacterView();
	}

	/**
	 * getter for dexterity
	 * 
	 * @return
	 */
	public int getDexterity() {
		return dexterity;
	}

	/**
	 * setter for decterity
	 * 
	 * @param dexterity
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		notifyCharacterView();
	}

	/**
	 * getter for constitution
	 * 
	 * @return
	 */
	public int getConstitution() {
		return constitution;
	}

	/**
	 * setter for constitution
	 * 
	 * @param constitution
	 */
	public void setConstitution(int constitution) {
		this.constitution = constitution;
		notifyCharacterView();
	}

	/**
	 * getter for wisdom
	 * 
	 * @return
	 */
	public int getWisdom() {
		return wisdom;
	}

	/**
	 * setter for wisdom
	 * 
	 * @param wisdom
	 */
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
		notifyCharacterView();
	}

	/**
	 * getter for charisma
	 * 
	 * @return
	 */
	public int getCharisma() {
		return charisma;
	}

	/**
	 * setter for charisma
	 * 
	 * @param charisma
	 */
	public void setCharisma(int charisma) {
		this.charisma = charisma;
		notifyCharacterView();
	}

	/**
	 * This function sets the abilities from the AbilityModel instance.
	 * 
	 * @param data
	 */
	public void setAbilities(AbilityModel data) {
		strength = data.strength;
		dexterity = data.dexterity;
		constitution = data.constitution;
		intelligence = data.intelligence;
		wisdom = data.wisdom;
		charisma = data.charisma;
		notifyCharacterView();
	}

	/**
	 * Here Observer pattern is used notifying the character view for any
	 * changes made.
	 */
	public void notifyCharacterView() {
		setChanged();
		notifyObservers(this);
	}

}
