package com.SOEN6441_DND.Model;

import java.util.Observable;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
/**
 * This Class Defines all the characteristics and property of the character.
 * This class extends Observable.
 * @author Amirbabak Rahgozar 
 * @author Paras Malik
 *
 */
public class CharacterModel extends Observable{
	
	//Get or set character name
	private String name;
	
	//Get or set character type
	private String type;
	
	//Get or set hit points
	private int hitPoints;	
	
	private int level;
	
	private AbilitiyModel abilityModel;
	
	private int speed;

	private ItemModel ownedItems[];
	
	private String image;

	private String damage;

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
	}

	

	public AbilitiyModel getAbilityModel() {
		return abilityModel;
	}

	public void setAbilityModel(AbilitiyModel abilityModel) {
		this.abilityModel = abilityModel;
		notifyCharacterView();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ItemModel[] getOwnedItems() {
		return ownedItems;
	}

	public void setOwnedItems(ItemModel[] ownedItems) {
		this.ownedItems = ownedItems;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = "image/"+image+".jpg";
		notifyCharacterView();
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}
	public void notifyCharacterView()
	{
		setChanged();
		notifyObservers(this);
	}
     
}
