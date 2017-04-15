package com.SOEN6441_DND.Model;

import java.awt.Dimension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

import Strategy.AggressiveStrategy;
import Strategy.ComputerStrategy;
import Strategy.FriendlyStrategy;
import Strategy.HumanStrategy;
import Strategy.Strategy;

/**
 * This Class Defines all the characteristics and property of the character.
 * This class extends Observable.
 * 
 * @author Amirbabak Rahgozar
 * @author Paras Malik
 *
 */
public class CharacterModel extends Observable {

	private String name;
	private String type;
	private String fighterType;
	private String helmetFlag;
	private String armorFlag;
	private String beltFlag;
	private String bootFlag;
	private String ringFlag;
	private String weaponFlag;
	private String shieldFlag;
	private boolean attackFlag;
	private CharacterModel enemy;
	private int backPackCounter;
	public String[] levelListValues;
	private int hitPoints;
	private int hitPointBase;
	private int attackBonus;
	private int baseAttackBonus;
	private int damageBonus;
	private int armorClass;
	private String image;
	private int level;
	private AbilityModel abilityScore;
	private AbilityModel abilityModifier;
	private int speed;
	private Dimension charLocation;
	private String behaviour;
	public HashMap<String, ItemModel> ownedItems;
	public String message;
	private Strategy strategy;
	private  ArrayList<String> weaponEffects;
	public ArrayList<String> backPackItems;
	public boolean moveCompleted;
	/**
	 * constructor for character model
	 */
	public CharacterModel() {
		backPackItems = new ArrayList<String>();
		backPackCounter = 0;
		ownedItems = new HashMap<String, ItemModel>();
		hitPointBase = 1 + new Random().nextInt(10);
		baseAttackBonus=1 + new Random().nextInt(8);
		attackFlag = false;
		weaponEffects=new ArrayList<String>();
		setAbilityModifier(new AbilityModel());
		setAbilityScore(new AbilityModel());
		levelListValues = new String[25];
		for (int i = 0; i < 25; i++) {
			levelListValues[i] = String.valueOf(i + 1);
		}
	}

	/**
	 * getter for weapon effects
	 * @return
	 */
	public ArrayList<String> getWeaponEffects() {
		return weaponEffects;
	}

	/**
	 * setter for weapon effects
	 * @param weaponEffects
	 */
	public void setWeaponEffects(ArrayList<String> weaponEffect) {
		this.weaponEffects=weaponEffect;
	}
	/**
	 * method to add weapon effects
	 * @param weaponEffects
	 */
	public void addWeaponEffects(String weaponEffect) {
		this.weaponEffects.add(weaponEffect);
	}


	/**
	 * getter for character behavior
	 * 
	 * @return
	 */
	public String getBehaviour() {
		return behaviour;
	}

	/**
	 * setter for character behavior
	 * 
	 * @param behaviour
	 */
	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
		switch (this.behaviour) {
		case "Hostile": {
			setStrategy(new AggressiveStrategy());
			break;
		}
		case "Player": {
			setStrategy(new HumanStrategy());
			break;
		}
		case "Friendly": {
			setStrategy(new FriendlyStrategy());
			break;
		}
		case "Computer": {
			setStrategy(new ComputerStrategy());
			break;
		}
		}

	}

	/**
	 * method for executing the strategy
	 * 
	 * @param mapModel
	 * @param charModel
	 */
	public void execute(MapModel mapModel) {
		this.strategy.execute(mapModel, this);
	}

	/**
	 * getter for strategy flag
	 * 
	 * @return
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * setter for strategy flag
	 * 
	 * @return
	 */
	public void setStrategy(Strategy charStrategy) {
		this.strategy = charStrategy;
	}

	/**
	 * getter for attack flag
	 * 
	 * @return
	 */
	public boolean isAttackFlag() {
		return attackFlag;
	}

	/**
	 * setter for attack flag
	 * 
	 * @param attackFlag
	 */
	public void setAttackFlag(boolean attackFlag) {
		this.attackFlag = attackFlag;
	}

	/**
	 * getter for enemy
	 * 
	 * @return
	 */
	public CharacterModel getEnemy() {
		return enemy;
	}

	/**
	 * Setter for enemy
	 * 
	 * @param enemy
	 */
	public void setEnemy(CharacterModel enemy) {
		this.enemy = enemy;
	}

	/**
	 * getter for character location
	 * 
	 * @return
	 */
	public Dimension getCharLocation() {
		return charLocation;
	}

	/**
	 * setter for character location
	 * 
	 * @param charLocation
	 */
	public void setCharLocation(Dimension charLocation) {
		this.charLocation = charLocation;
		this.message = "LocationUpdate";
		notifyCharacterView();
	}

	/**
	 * getter for shield flag
	 * 
	 * @return
	 */
	public String getShieldFlag() {
		return shieldFlag;
	}

	/**
	 * setter for shield flag
	 * 
	 * @param shieldFlag
	 */
	public void setShieldFlag(String shieldFlag) {
		this.shieldFlag = shieldFlag;

		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for attack bonus
	 * 
	 * @return
	 */
	public int getAttackBonus() {
		return attackBonus;
	}

	/**
	 * setter for attack bonus
	 * 
	 * @param attackBonus
	 */
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
		notifyCharacterView();
	}

	/**
	 * getter for damage bonus
	 * 
	 * @return
	 */
	public int getDamageBonus() {
		return damageBonus;
	}

	/**
	 * setter for damage bonus
	 * 
	 * @param damageBonus
	 */
	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
		notifyCharacterView();

	}

	/**
	 * getter for armor bonus
	 * 
	 * @return
	 */
	public int getArmorClass() {
		return armorClass;
	}

	/**
	 * setter for armor class
	 * 
	 * @param armorClass
	 */
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
		notifyCharacterView();
	}

	/**
	 * getter for fighter type
	 * 
	 * @return
	 */
	public String getFighterType() {
		return fighterType;
	}

	/**
	 * setter for fighter type
	 * 
	 * @param fighterType
	 */
	public void setFighterType(String fighterType) {
		this.fighterType = fighterType;
	}

	/**
	 * getter for level list
	 * 
	 * @return
	 */
	public String[] getLevelListValues() {
		return levelListValues;
	}

	/**
	 * getter for owned items
	 * 
	 * @return
	 */
	public HashMap<String, ItemModel> getOwnedItems() {
		return ownedItems;
	}

	/**
	 * method to add items into hashmap for the character
	 * 
	 * @param itemName
	 * @param item
	 */
	public void addOwnedItems(String itemName, ItemModel item) {
		item.setEnchantValue(item.getEnchantValue() + calculateEnchanment(getLevel()));
		this.ownedItems.put(itemName, item);
	}

	/**
	 * method to remove items from hashmap
	 * 
	 * @param itemName
	 */
	public void removeOwnedItems(String itemName) {
		this.ownedItems.remove(itemName);
	}

	/**
	 * setter for owned item
	 */
	public void setOwnedItems(HashMap<String, ItemModel> ownedItems) {
		this.ownedItems = ownedItems;
	}

	/**
	 * setter for level list
	 * 
	 * @param levelListValues
	 */
	public void setLevelListValues(String[] levelListValues) {
		this.levelListValues = levelListValues;
	}

	/**
	 * getter for backpack items
	 * 
	 * @return
	 */
	public ArrayList<String> getBackPackItems() {
		return backPackItems;
	}

	/**
	 * setter for backpack item
	 * 
	 * @param backPackItems
	 */
	public void setBackPackItems(ArrayList<String> backPackItems) {
		this.backPackItems = backPackItems;
		notifyObservers();
	}

	/**
	 * method to add item to back pack item
	 * 
	 * @param item
	 */
	public void addBackPackItems(String item) {
		this.backPackItems.add(item);
		notifyCharacterView();
	}

	/**
	 * remove item from backpack items
	 * 
	 * @param item
	 */
	public void removeBackPackItems(String item) {
		this.backPackItems.remove(item);
		notifyCharacterView();
	}

	/**
	 * getter for back pack counter
	 * 
	 * @return
	 */
	public int getBackPackCounter() {
		return backPackCounter;
	}

	/**
	 * setter from back pack counter
	 * 
	 * @param backPackCounter
	 */
	public void setBackPackCounter(int backPackCounter) {
		this.backPackCounter = backPackCounter;
	}

	/**
	 * getter for helmet flag
	 * 
	 * @return
	 */
	public String getHelmetFlag() {
		return helmetFlag;
	}

	/**
	 * setter for helmet flag
	 * 
	 * @param helmetFlag
	 */
	public void setHelmetFlag(String helmetFlag) {
		this.helmetFlag = helmetFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for armor flag
	 * 
	 * @return
	 */
	public String getArmorFlag() {
		return armorFlag;
	}

	/**
	 * setter armor flag
	 * 
	 * @param armorFlag
	 */
	public void setArmorFlag(String armorFlag) {
		this.armorFlag = armorFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for belt flag
	 * 
	 * @return
	 */
	public String getBeltFlag() {
		return beltFlag;
	}

	/**
	 * setter for belt flag
	 * 
	 * @param beltFlag
	 */
	public void setBeltFlag(String beltFlag) {
		this.beltFlag = beltFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for boot flag
	 * 
	 * @return
	 */
	public String getBootFlag() {
		return bootFlag;
	}

	/**
	 * setter for boot flag
	 * 
	 * @param bootsFlag
	 */
	public void setBootFlag(String bootsFlag) {
		this.bootFlag = bootsFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for ring flag
	 * 
	 * @return
	 */
	public String getRingFlag() {
		return ringFlag;
	}

	/**
	 * setter for ring flag
	 * 
	 * @param ringFlag
	 */
	public void setRingFlag(String ringFlag) {
		this.ringFlag = ringFlag;
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for weapon flag
	 * 
	 * @return
	 */
	public String getWeaponFlag() {
		return weaponFlag;
	}

	/**
	 * setter weapon flag
	 * 
	 * @param weaponFlag
	 */
	public void setWeaponFlag(String weaponFlag) {
		this.weaponFlag = weaponFlag;
		if (getOwnedItems().get("Weapon").getWeaponRange() == 1) {
			//Melee Weapon
			setAttackBonus(getLevel()+abilityModifier.getStrength()+baseAttackBonus);
		}
		else if (getOwnedItems().get("Weapon").getWeaponRange() == 2) {
			setAttackBonus(getLevel()+abilityModifier.getDexterity()+baseAttackBonus);
		}
		message = "itemImage";
		notifyCharacterView();
	}

	/**
	 * getter for name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for type
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter for type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
		resetScore();
		setModifer();
		notifyCharacterView();
	}

	/**
	 * getter for hitpoints
	 * 
	 * @return
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * setter for hitpoints
	 * 
	 * @param hitPoints
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * getter for level
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * method for setting the level
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		int tempArmorBonus = 0;
		int tempConstitution = 0;
		int tempDamageBonus = 0;
		int oldLevel = getLevel();
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
			for (Map.Entry<String, ItemModel> item : getOwnedItems().entrySet()) {
				item.getValue().setEnchantValue(-calculateEnchanment(oldLevel));
				item.getValue().setEnchantValue(+calculateEnchanment(getLevel()));
			}
		}
		if (beltFlag != null) {
			abilityModifier.setConstitution((abilityModifier.getConstitution() - tempConstitution) + enchanmentBonus);
		}
		calculateChar();
	}

	/**
	 * method for character calculations
	 */
	public void calculateChar() {
		if (getAbilityModifier() != null && getAbilityScore() != null) {
			setHitPoints((getAbilityModifier().getConstitution() + getHitPointBase()) * getLevel());
			setAttackBonus(getLevel());
			if (getDamageBonus() == 0) {
				setDamageBonus(0);
			}

		}
		notifyCharacterView();
	}

	/**
	 * getter for hitpoints
	 * 
	 * @return
	 */
	public int getHitPointBase() {
		return hitPointBase;
	}

	/**
	 * setter hitpoint base
	 * 
	 * @param hitPointBase
	 */
	public void setHitPointBase(int hitPointBase) {
		this.hitPointBase = hitPointBase;
	}

	/**
	 * method for calculating ability modifier
	 */
	public void calculateAbilityModifier() {
		setModifer();
		getAbilityModifier()
				.setStrength(abilityModifier.getStrength() + modifierCalculator(abilityScore.getStrength()));
		getAbilityModifier()
				.setDexterity(abilityModifier.getDexterity() + modifierCalculator(abilityScore.getDexterity()));
		getAbilityModifier().setConstitution(
				abilityModifier.getConstitution() + modifierCalculator(abilityScore.getConstitution()));
		getAbilityModifier().setIntelligence(
				abilityModifier.getIntelligence() + modifierCalculator(abilityScore.getIntelligence()));
		getAbilityModifier().setWisdom(abilityModifier.getWisdom() + modifierCalculator(abilityScore.getWisdom()));
		getAbilityModifier()
				.setCharisma(abilityModifier.getCharisma() + modifierCalculator(abilityScore.getCharisma()));
		calculateChar();
	}

	/**
	 * method for calculating ability modifier scrore
	 * 
	 * @param score
	 * @return
	 */
	public int modifierCalculator(int score) {

		return ((score / 2) - 5);
	}

	/**
	 * method for setting the modifier
	 */
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

	/**
	 * method for reseting the score
	 */
	public void resetScore() {
		abilityScore.setStrength(0);
		abilityScore.setDexterity(0);
		abilityScore.setConstitution(0);
		abilityScore.setIntelligence(0);
		abilityScore.setWisdom(0);
		abilityScore.setCharisma(0);
	}

	/**
	 * method for calculating enchancement
	 * 
	 * @param level
	 * @return
	 */
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

	/**
	 * getter for ability score
	 * 
	 * @return
	 */
	public AbilityModel getAbilityScore() {
		return abilityScore;

	}

	/**
	 * setter for ability score
	 * 
	 * @param abilityModel
	 */
	public void setAbilityScore(AbilityModel abilityModel) {
		this.abilityScore = abilityModel;
		abilityScore.setType("abilityScore");
		calculateChar();
	}

	/**
	 * getter for ability modifier
	 * 
	 * @return
	 */
	public AbilityModel getAbilityModifier() {
		return abilityModifier;

	}

	/**
	 * setter for ability modifier
	 * 
	 * @param abilitiyModifier
	 */
	public void setAbilityModifier(AbilityModel abilitiyModifier) {
		this.abilityModifier = abilitiyModifier;
		abilityModifier.setType("abilityModifier");
		calculateChar();
	}

	/**
	 * getter for speed
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * setter for speed
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * getter for image
	 * 
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * setter for image
	 * 
	 * @param image
	 */
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

	public String characterMovecheck(Dimension newLocation) {
		return "LocationUpdate";

	}
}
