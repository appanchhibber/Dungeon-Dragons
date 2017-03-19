package com.SOEN6441_DND.Model;

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

	public ArrayList<String> backPackItems;

	private int backPackCounter;
	public String[] levelListValues = { "1", "2", "3", "4", "5", "6", "7", "8" };
	// Get or set hit points
	private int hitPoints;
	private int attackBonus;
	private int damageBonus;
	private int armorClass;
	private String image;
	private int level;
	private AbilitiyModel abilityScore;
	private AbilitiyModel abilityModifier;
	private int speed;
	
	public String getShieldFlag() {
		return shieldFlag;
	}

	public void setShieldFlag(String shildFlag) {
		this.shieldFlag = shildFlag;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus+getAbilityModifier().getStrength();
		notifyCharacterView();
		
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
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
	}

	public void addBackPackItems(String item) {
		this.backPackItems.add(item);
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
	}

	public String getArmorFlag() {
		return armorFlag;
	}

	public void setArmorFlag(String armorFlag) {
		this.armorFlag = armorFlag;
	}

	public String getBeltFlag() {
		return beltFlag;
	}

	public void setBeltFlag(String beltFlag) {
		this.beltFlag = beltFlag;
	}

	public String getBootFlag() {
		return bootFlag;
	}

	public void setBootFlag(String bootsFlag) {
		this.bootFlag = bootsFlag;
	}

	public String getRingFlag() {
		return ringFlag;
	}

	public void setRingFlag(String ringFlag) {
		this.ringFlag = ringFlag;
	}

	public String getWeaponFlag() {
		return weaponFlag;
	}

	public void setWeaponFlag(String weaponFlag) {
		this.weaponFlag = weaponFlag;
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
		this.level = level;
		notifyCharacterView();
	}

	public void calculateChar() {
		if (getAbilityModifier() != null && getAbilityScore() != null) {
			setHitPoints(((new Random().nextInt(10) + getAbilityScore().getConstitution()) * getLevel()));
			setAttackBonus(getAbilityModifier().getStrength() + getLevel());
			notifyCharacterView();
		}
	}

	public AbilitiyModel getAbilityScore() {
		return abilityScore;
	}

	public void setAbilityScore(AbilitiyModel abilityModel) {
		this.abilityScore = abilityModel;
	}

	public AbilitiyModel getAbilityModifier() {
		return abilityModifier;

	}

	public void setAbilityModifier(AbilitiyModel abilitiyModifier) {
		this.abilityModifier = abilitiyModifier;
		notifyCharacterView();
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
		this.image = "image/" + image + ".jpg";
		notifyCharacterView();
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
