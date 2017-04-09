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
	public DefaultListModel treasureList;
	public HashMap<String, Dimension> treasures;
	public HashMap<String, MapModel> characters;
	public HashMap<String, Dimension> characterLocations;
	private boolean loadNextMap;

	public boolean isLoadNextMap() {
		return loadNextMap;
	}

	public void setLoadNextMap(boolean loadNextMap) {
		this.loadNextMap = loadNextMap;
		notifyMapView("Next Map");
	}

	public HashMap<String, Dimension> getCharacterLocations() {
		return characterLocations;
	}

	public void addCharLocation(String name, Dimension location) {
		this.characterLocations.put(name, location);
	}

	public void updateCharLocation(String name, Dimension location) {
		this.characterLocations.get(name).setSize(location);
	}

	public void removeCharacterLocation(String name) {
		this.characterLocations.remove(name);
	}

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

	/*
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

	public void setCharacterLocation(Dimension characterLocation) {
		this.characterLocation = characterLocation;
	}

	public Dimension getCharacterLocation() {
		return characterLocation;
	}

	public DefaultListModel getCharacterList() {
		return characterList;
	}

	public String getCharacterImage() {
		return characterImage;
	}

	public void setCharacterImage(String characterImage) {
		this.characterImage = characterImage;
		notifyMapView("characterImage");
	}

	public void setCharacterList(DefaultListModel characterList) {
		this.characterList = characterList;
		notifyMapView("characterList");
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterBehavior() {
		return characterBehavior;
	}

	public void setCharacterBehavior(String characterBehavior) {
		this.characterBehavior = characterBehavior;
	}

	public ArrayList<Dimension> getWalls() {
		return walls;
	}

	public void setWalls(ArrayList<Dimension> walls) {
		this.walls = walls;
	}

	public Dimension getEntry() {
		return entry;
	}

	public void setEntry(Dimension entry) {
		this.entry = entry;
	}

	public Dimension getExit() {
		return exit;
	}

	public void setExit(Dimension exit) {
		this.exit = exit;
	}

	public Dimension getChest() {
		return chest;
	}

	public void setChest(Dimension chest) {
		this.chest = chest;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public int[][] getMapGridSelection() {
		return mapGridSelection;
	}

	public void setMapGridSelection(int[][] mapGridSelection) {
		this.mapGridSelection = mapGridSelection;
	}

	public JPanel getMapView() {
		return MapView;
	}

	public void setMapView(JPanel mapView) {
		MapView = mapView;
	}

	public void notifyMapView(String message) {
		this.message = message;
		setChanged();
		notifyObservers(this);
	}

}
