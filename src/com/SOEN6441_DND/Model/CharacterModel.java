package com.SOEN6441_DND.Model;

import java.awt.Dimension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 * This Class Defines all the characteristics and property of the character.
 * This class extends Observable.
 * 
 * @author Amirbabak Rahgozar
 * @author Paras Malik
 *
 */
public class CharacterModel extends Observable {

	// Get or set character name
	private String name;

	// Get or set character type
	private String type;

	// Fighter Type
	private String fighterType;

	// Equipped Items
	private String helmetFlag;
	private String armorFlag;
	private String beltFlag;
	private String bootFlag;
	private String ringFlag;
	private String weaponFlag;
	private String shieldFlag;
	public String message;

	public ArrayList<String> backPackItems;

	private int backPackCounter;
	public String[] levelListValues;
	// Get or set hit points
	private int hitPoints;
	private int hitPointBase;
	private int attackBonus;
	private int damageBonus;
	private int armorClass;
	private String image;
	private int level;
	private AbilityModel abilityScore;
	private AbilityModel abilityModifier;
	private int speed;
	// character location for strategy by appan
	private Dimension charLocation;
	private String behaviour;

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public Dimension getCharLocation() {
		return charLocation;
	}

	public void setCharLocation(Dimension charLocation) {
		this.charLocation = charLocation;
		this.message = "LocationUpdate";
		notifyCharacterView();
	}

	// ---------------------//
	public String getShieldFlag() {
		return shieldFlag;
	}

	public void setShieldFlag(String shieldFlag) {
		this.shieldFlag = shieldFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
		notifyCharacterView();
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
		notifyCharacterView();

	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
		notifyCharacterView();
	}

	public String getFighterType() {
		return fighterType;
	}

	public void setFighterType(String fighterType) {
		this.fighterType = fighterType;
	}

	public CharacterModel() {
		backPackItems = new ArrayList<String>();
		backPackCounter = 0;
		hitPointBase= 1+new Random().nextInt(10);
		setAbilityModifier(new AbilityModel());
		setAbilityScore(new AbilityModel());
		levelListValues = new String[25];
		for (int i = 0; i < 25; i++) {
			levelListValues[i] = String.valueOf(i + 1);
		}
	}

	public String[] getLevelListValues() {
		return levelListValues;
	}

	public void setLevelListValues(String[] levelListValues) {
		this.levelListValues = levelListValues;
	}

	public ArrayList<String> getBackPackItems() {
		return backPackItems;
	}

	public void setBackPackItems(ArrayList<String> backPackItems) {
		this.backPackItems = backPackItems;
		notifyObservers();
	}

	public void addBackPackItems(String item) {
		this.backPackItems.add(item);
		notifyCharacterView();
	}

	public void removeBackPackItems(String item) {
		this.backPackItems.remove(item);
		notifyCharacterView();
	}

	public int getBackPackCounter() {
		return backPackCounter;
	}

	public void setBackPackCounter(int backPackCounter) {
		this.backPackCounter = backPackCounter;
	}

	public String getHelmetFlag() {
		return helmetFlag;
	}

	public void setHelmetFlag(String helmetFlag) {
		this.helmetFlag = helmetFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getArmorFlag() {
		return armorFlag;
	}

	public void setArmorFlag(String armorFlag) {
		this.armorFlag = armorFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getBeltFlag() {
		return beltFlag;
	}

	public void setBeltFlag(String beltFlag) {
		this.beltFlag = beltFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getBootFlag() {
		return bootFlag;
	}

	public void setBootFlag(String bootsFlag) {
		this.bootFlag = bootsFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getRingFlag() {
		return ringFlag;
	}

	public void setRingFlag(String ringFlag) {
		this.ringFlag = ringFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getWeaponFlag() {
		return weaponFlag;
	}

	public void setWeaponFlag(String weaponFlag) {
		this.weaponFlag = weaponFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		resetScore();
		setModifer();
		notifyCharacterView();
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		int tempArmorBonus = 0;
		int tempConstitution = 0;
		int tempDamageBonus = 0;
		int enchanmentBonus = 0;
		if (getArmorClass() != 0) {
			tempArmorBonus = calculateEnchanment(this.level);
		}
		if (abilityModifier.getConstitution() != 0) {
			tempConstitution = calculateEnchanment(this.level);
		}
		if (getDamageBonus() != 0) {
			tempDamageBonus = calculateEnchanment(this.level);

		}
		this.level = level;
		enchanmentBonus = calculateEnchanment(level);
		if (helmetFlag != null && armorFlag != null && bootFlag != null && shieldFlag != null && ringFlag != null) {
			setArmorClass((getArmorClass() - (tempArmorBonus * 5)) + (enchanmentBonus * 5));
		}
		if (weaponFlag != null) {
			setDamageBonus((getDamageBonus() - tempDamageBonus) + enchanmentBonus);
		}
		if (beltFlag != null) {
			abilityModifier.setConstitution((abilityModifier.getConstitution() - tempConstitution) + enchanmentBonus);
		}
		calculateChar();
	}

	public void calculateChar() {
		if (getAbilityModifier() != null && getAbilityScore() != null) {
			setHitPoints((getAbilityModifier().getConstitution()+getHitPointBase()) * getLevel());
			setAttackBonus(getAbilityModifier().getStrength() + getLevel());
			if (getArmorClass() == 0) {
				setArmorClass(abilityModifier.getDexterity());
			}
			if (getDamageBonus() == 0) {
				setDamageBonus(0);
			}
			notifyCharacterView();
		}
	}

	public int getHitPointBase() {
		return hitPointBase;
	}

	public void setHitPointBase(int hitPointBase) {
		this.hitPointBase = hitPointBase;
	}

	public void calculateAbilityModifier() {
		setModifer();
		abilityModifier.setStrength(abilityModifier.getStrength() + modifierCalculator(abilityScore.getStrength()));
		abilityModifier.setDexterity(abilityModifier.getDexterity() + modifierCalculator(abilityScore.getDexterity()));
		abilityModifier.setConstitution(
				abilityModifier.getConstitution() + modifierCalculator(abilityScore.getConstitution()));
		abilityModifier.setIntelligence(
				abilityModifier.getIntelligence() + modifierCalculator(abilityScore.getIntelligence()));
		abilityModifier.setWisdom(abilityModifier.getWisdom() + modifierCalculator(abilityScore.getWisdom()));
		abilityModifier.setCharisma(abilityModifier.getCharisma() + modifierCalculator(abilityScore.getCharisma()));
		calculateChar();
	}

	public int modifierCalculator(int score) {

		return ((score / 2) - 5);
	}

	public void setModifer() {
		abilityModifier.setStrength(0);
		abilityModifier.setDexterity(0);
		abilityModifier.setConstitution(0);
		abilityModifier.setIntelligence(0);
		abilityModifier.setWisdom(0);
		abilityModifier.setCharisma(0);
		switch (this.getType()) {
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

	public void resetScore() {
		abilityScore.setStrength(0);
		abilityScore.setDexterity(0);
		abilityScore.setConstitution(0);
		abilityScore.setIntelligence(0);
		abilityScore.setWisdom(0);
		abilityScore.setCharisma(0);
	}

	public int calculateEnchanment(int level) {
		int enchanmentBonus = 0;
		if (level < 5) {
			enchanmentBonus = 1;
		} else if (level < 9) {
			enchanmentBonus = 2;
		} else if (level < 13) {
			enchanmentBonus = 3;
		} else if (level < 17) {
			enchanmentBonus = 4;
		} else if (level > 17) {
			enchanmentBonus = 5;
		}
		return enchanmentBonus;
	}

	public AbilityModel getAbilityScore() {
		return abilityScore;

	}

	public void setAbilityScore(AbilityModel abilityModel) {
		this.abilityScore = abilityModel;
		abilityScore.setType("abilityScore");
		calculateChar();
	}

	public AbilityModel getAbilityModifier() {
		return abilityModifier;

	}

	public void setAbilityModifier(AbilityModel abilitiyModifier) {
		this.abilityModifier = abilitiyModifier;
		abilityModifier.setType("abilityModifier");
		calculateChar();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
		message = "image";
	}

	/**
	 * This is the Observer function notifying the Character view for any
	 * changes made.
	 */
	public void notifyCharacterView() {
		setChanged();
		notifyObservers(this);
	}

}
