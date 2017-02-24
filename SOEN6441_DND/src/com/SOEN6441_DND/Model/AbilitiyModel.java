package com.SOEN6441_DND.Model;

import java.util.Observable;

/**
 * This Class Defines all the characteristics and property of the character.
 * @author Amirbabak Rahgozar
 * @author Paras Malik.
 *
 */

public class AbilitiyModel extends Observable {
	
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		notifyCharacterView();
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
		notifyCharacterView();
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		notifyCharacterView();
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
		notifyCharacterView();
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
		notifyCharacterView();
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
		notifyCharacterView();
	}
	public void setAbilities(AbilitiyModel data)
	{
		strength=data.strength;
		dexterity=data.dexterity;
		constitution=data.constitution;
		intelligence=data.intelligence;
		wisdom=data.wisdom;
		charisma=data.charisma;
		notifyCharacterView();
	}
	public void notifyCharacterView()
	{
		setChanged();
		notifyObservers(this);
	}
	
	

}
