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
	public String message;

	public ArrayList<String> backPackItems;

	private int backPackCounter;
	public String[] levelListValues; 
	// Get or set hit points
	private int hitPoints;
	private int attackBonus;
	private int damageBonus;
	private int armorClass;
	private String image;
	private int level;
	private AbilityModel abilityScore;
	private AbilityModel abilityModifier;
	private int speed;
	public String getShieldFlag() {
		return shieldFlag;
	}

	public void setShieldFlag(String shieldFlag) {
		this.shieldFlag = shieldFlag;
		message="shieldFlag";
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
		setAbilityModifier(new AbilityModel());
		setAbilityScore(new AbilityModel());
		levelListValues=new String[25];
		for(int i=0;i<25;i++){
			levelListValues[i]=String.valueOf(i+1);
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
		message="helmetFlag";
		notifyCharacterView();
	}

	public String getArmorFlag() {
		return armorFlag;
	}

	public void setArmorFlag(String armorFlag) {
		this.armorFlag = armorFlag;
		message="armorFlag";
		notifyCharacterView();
	}

	public String getBeltFlag() {
		return beltFlag;
	}

	public void setBeltFlag(String beltFlag) {
		this.beltFlag = beltFlag;
		message="beltFlag";
		notifyCharacterView();
	}

	public String getBootFlag() {
		return bootFlag;
	}

	public void setBootFlag(String bootsFlag) {
		this.bootFlag = bootsFlag;
		message="bootFlag";
		notifyCharacterView();
	}

	public String getRingFlag() {
		return ringFlag;
	}

	public void setRingFlag(String ringFlag) {
		this.ringFlag = ringFlag;
		message="ringFlag";
		notifyCharacterView();
	}

	public String getWeaponFlag() {
		return weaponFlag;
	}

	public void setWeaponFlag(String weaponFlag) {
		this.weaponFlag = weaponFlag;
		message="weaponFlag";
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
		int tempArmorBonus=0;
		int tempConstitution=0;
		int tempDamageBonus=0;
		int enchanmentBonus=0;
		if(getArmorClass()!=0){
			tempArmorBonus=calculateEnchanment(this.level);
		}
		if(abilityModifier.getConstitution()!=0)
		{
			tempConstitution=calculateEnchanment(this.level);
		}
		if(getDamageBonus()!=0)
		{
			tempDamageBonus=calculateEnchanment(this.level);
			
		}
		this.level = level;
		enchanmentBonus=calculateEnchanment(level);
		if(helmetFlag!=null && armorFlag!=null && bootFlag!=null && shieldFlag !=null && ringFlag!=null )
		{
		setArmorClass((getArmorClass()-(tempArmorBonus*5))+(enchanmentBonus*5));
		}
		if(weaponFlag!=null)
		{
		setDamageBonus((getDamageBonus()-tempDamageBonus)+enchanmentBonus);
		}
		if(beltFlag!=null){
		abilityModifier.setConstitution((abilityModifier.getConstitution()-tempConstitution)+enchanmentBonus);
		}
		notifyCharacterView();
		calculateChar();
	}

	public void calculateChar() {
		if (getAbilityModifier() != null && getAbilityScore() != null) {
			setHitPoints((getAbilityModifier().getConstitution()) * getLevel());
			setAttackBonus(getAbilityModifier().getStrength() + getLevel());
			notifyCharacterView();
		}
	}
	public int calculateEnchanment(int level)
	{ 
		int enchanmentBonus=0;
		if(level<5)
		{
			enchanmentBonus=1;
		}
		else if(level<9)
		{
			enchanmentBonus=2;
		}
		else if(level<13)
		{
			enchanmentBonus=3;
		}	
		else if(level<17)
		{
			enchanmentBonus=4;
		}
		else if(level>17)
		{
			enchanmentBonus=5;
		}
		return enchanmentBonus;
	}
	public AbilityModel getAbilityScore() {
		return abilityScore;
		
	}

	public void setAbilityScore(AbilityModel abilityModel) {
		this.abilityScore = abilityModel;
		abilityScore.setType("abilityScore");
		notifyCharacterView();
	}

	public AbilityModel getAbilityModifier() {
		return abilityModifier;

	}

	public void setAbilityModifier(AbilityModel abilitiyModifier) {
		this.abilityModifier = abilitiyModifier;
		abilityModifier.setType("abilityModifier");
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
		this.image = image;
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
