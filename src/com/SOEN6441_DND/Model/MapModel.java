package com.SOEN6441_DND.Model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 * This class is the model of the map screen which is responsible for handling
 * all the data for the map
 * 
 * @author Appan Chhibber
 * @author Punit Trivedi
 *
 */
public class MapModel extends Observable {
	int mapWidth;
	public String mapName;
	int mapHeight;
	public int mapGridSelection[][];

	public JPanel MapView;
	public String message;
	public Boolean characterChecked;
	// Treasure Addition in the map //
	public String treasureName;
	public boolean treasurePresent;
	public DefaultListModel treasureList;
	public HashMap<String, Dimension> treasures;
	public HashMap<String, MapModel> characters;
	public HashMap<String, Dimension> characterLocations;
	private boolean loadNextMap;
	// Character Addition and Behavior//
	public String characterName;
	public String characterBehavior;
	public DefaultListModel characterList;
	public String characterImage;
	public Dimension characterLocation;
	// -For saving of the map------//
	public ArrayList<String> mapItemList;
	public ArrayList<Dimension> walls;
	public Dimension entry;
	public Dimension exit;
	public Dimension chest;

	/**
	 * getter for load next map flag
	 * 
	 * @return
	 */
	public boolean isLoadNextMap() {
		return loadNextMap;
	}

	/**
	 * setter for load next map flag
	 * 
	 * @param loadNextMap
	 */
	public void setLoadNextMap(boolean loadNextMap) {
		this.loadNextMap = loadNextMap;
		notifyMapView("Next Map");
	}

	/**
	 * getter for character location
	 * 
	 * @return
	 */
	public HashMap<String, Dimension> getCharacterLocations() {
		return characterLocations;
	}

	/**
	 * method to add characters location on the map
	 * 
	 * @param name
	 * @param location
	 */
	public void addCharLocation(String name, Dimension location) {
		this.characterLocations.put(name, location);
	}

	/**
	 * method to update character location
	 * 
	 * @param name
	 * @param location
	 */
	public void updateCharLocation(String name, Dimension location) {
		this.characterLocations.get(name).setSize(location);
	}

	/**
	 * method to remove characterLocation
	 * 
	 * @param name
	 */
	public void removeCharacterLocation(String name) {
		this.characterLocations.remove(name);
	}

	/*
	 * Constructor responsible for intializing arraylist and hashmap objects
	 * 
	 * @author Appan Chhibber
	 */
	public MapModel() {
		walls = new ArrayList<Dimension>();
		mapItemList = new ArrayList<String>();
		characters = new HashMap<String, MapModel>();
		treasures = new HashMap<String, Dimension>();
		characterLocations = new HashMap<String, Dimension>();
	}

	/**
	 * Getter method to get data of all the characters saved on the map
	 * 
	 * @return HashMap<String,MapModel
	 * 
	 * @author Appan Chhibber
	 */
	public HashMap<String, MapModel> getCharacters() {
		return characters;
	}

	/**
	 * Getter method to get all the treasures data saved on the map
	 * 
	 * @return HashMap<String,Dimension>
	 * @author Appan Chhibber
	 */
	public HashMap<String, Dimension> getTreasures() {
		return treasures;
	}

	/**
	 * Getter method for treasure name
	 * 
	 * @return treasureName
	 * @author Appan Chhibber
	 */
	public String getTreasureName() {
		return treasureName;
	}

	/**
	 * Setter method to set the name of the treasure
	 * 
	 * @param treasureName
	 * @author Appan Chhibber
	 */
	public void setTreasureName(String treasureName) {
		this.treasureName = treasureName;
	}

	/**
	 * Getter method to return all the list of treasures created
	 * 
	 * @return
	 * @author Appan Chhibber
	 */
	public DefaultListModel getTreasureList() {
		return treasureList;
	}

	/**
	 * Setter method to set the list of treaures
	 * 
	 * @param treasureList
	 * @author Appan Chhibber
	 */
	public void setTreasureList(DefaultListModel treasureList) {
		this.treasureList = treasureList;
		notifyMapView("TreasureList");
	}

	/**
	 * setter to set character location
	 * 
	 * @param characterLocation
	 */
	public void setCharacterLocation(Dimension characterLocation) {
		this.characterLocation = characterLocation;
	}

	/**
	 * getter to get character location
	 * 
	 * @return
	 */
	public Dimension getCharacterLocation() {
		return characterLocation;
	}

	/**
	 * getter for character list
	 * 
	 * @return
	 */
	public DefaultListModel getCharacterList() {
		return characterList;
	}

	/**
	 * getter for character image
	 * 
	 * @return
	 */
	public String getCharacterImage() {
		return characterImage;
	}

	/**
	 * setter for character image
	 * 
	 * @param characterImage
	 */
	public void setCharacterImage(String characterImage) {
		this.characterImage = characterImage;
		notifyMapView("characterImage");
	}

	/**
	 * setter for character list
	 * 
	 * @param characterList
	 */
	public void setCharacterList(DefaultListModel characterList) {
		this.characterList = characterList;
		notifyMapView("characterList");
	}

	/**
	 * getter for character names
	 * 
	 * @return
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * setter for character name
	 * 
	 * @param characterName
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * getter for character behavior
	 * 
	 * @return
	 */
	public String getCharacterBehavior() {
		return characterBehavior;
	}

	/**
	 * setter for character behavior
	 * 
	 * @param characterBehavior
	 */
	public void setCharacterBehavior(String characterBehavior) {
		this.characterBehavior = characterBehavior;
	}

	/**
	 * getter for walls location
	 * 
	 * @return
	 */
	public ArrayList<Dimension> getWalls() {
		return walls;
	}

	/**
	 * setter for walls location
	 * 
	 * @param walls
	 */
	public void setWalls(ArrayList<Dimension> walls) {
		this.walls = walls;
	}

	/**
	 * getter for entry door
	 * 
	 * @return
	 */
	public Dimension getEntry() {
		return entry;
	}

	/**
	 * setter for entry door
	 * 
	 * @param entry
	 */
	public void setEntry(Dimension entry) {
		this.entry = entry;
	}

	/**
	 * getter for exit door
	 * 
	 * @return
	 */
	public Dimension getExit() {
		return exit;
	}

	/**
	 * setter for exit door
	 * 
	 * @param exit
	 */
	public void setExit(Dimension exit) {
		this.exit = exit;
	}

	/**
	 * getter for chest
	 * 
	 * @return
	 */
	public Dimension getChest() {
		return chest;
	}

	/**
	 * setter for chest
	 * 
	 * @param chest
	 */
	public void setChest(Dimension chest) {
		this.chest = chest;
	}

	/**
	 * getter for map width
	 * 
	 * @return
	 */
	public int getMapWidth() {
		return mapWidth;
	}

	/**
	 * setter for map width
	 * 
	 * @param mapWidth
	 */
	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	/**
	 * getter for map height
	 * 
	 * @return
	 */
	public int getMapHeight() {
		return mapHeight;
	}

	/**
	 * setter for map height
	 * 
	 * @param mapHeight
	 */
	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	/**
	 * getter for mapgrid
	 * 
	 * @return
	 */
	public int[][] getMapGridSelection() {
		return mapGridSelection;
	}

	/**
	 * setter for mapgrid
	 * 
	 * @param mapGridSelection
	 */
	public void setMapGridSelection(int[][] mapGridSelection) {
		this.mapGridSelection = mapGridSelection;
	}

	/**
	 * method for observer setchanged and notify
	 * 
	 * @param message
	 */
	public void notifyMapView(String message) {
		this.message = message;
		setChanged();
		notifyObservers(this);
	}

}
