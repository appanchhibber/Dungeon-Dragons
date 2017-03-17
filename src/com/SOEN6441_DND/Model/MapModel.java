package com.SOEN6441_DND.Model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 * 
 * @author Appan Chhibber
 * @author Punit Trivedi
 *
 */
public class MapModel extends Observable {
	int mapWidth;

	int mapHeight;
	public int mapGridSelection[][];

	public JPanel MapView;
	public String message;
	public Boolean characterChecked;
	
	public HashMap<String,Dimension> characters;
	
	
	public HashMap<String,Dimension> getCharacters() {
		return characters;
	}
	
	
	//Treasure Addition in the map //
	public String treasureName;
	public DefaultListModel treasureList;
	public HashMap<String,Dimension> treasures;
	public HashMap<String,Dimension> getTreasures()
	{
		return treasures;
	}
	public String getTreasureName() {
		return treasureName;
	}

	public void setTreasureName(String treasureName) {
		this.treasureName = treasureName;
	}

	public DefaultListModel getTreasureList() {
		return treasureList;
	}

	public void setTreasureList(DefaultListModel treasureList) {
		this.treasureList = treasureList;
		notifyMapView("TreasureList");
	}

	//------------------------------//
	//Character Addition and Behavior//
	public String characterName;
	public String characterBehavior;
	public DefaultListModel characterList;
	public String characterImage;
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

	//-For saving of the map------//
	public ArrayList<String> mapItemList;
    public ArrayList<Dimension> walls;
    public Dimension entry;
    public Dimension exit;
    public Dimension chest;
    
    public MapModel()
	{
	walls=new ArrayList<Dimension>();	
	mapItemList=new ArrayList<String>();
	characters=new HashMap<String,Dimension>();
	treasures=new HashMap<String,Dimension>();
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

	//----------------------------//
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

	public void notifyMapView(String message)
	{
		this.message=message;
		setChanged();
		notifyObservers(this);
	}

}
