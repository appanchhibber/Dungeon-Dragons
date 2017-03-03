package com.SOEN6441_DND.Model;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MapModel {
	int mapWidth;

	int mapHeight;
	public int mapGridSelection[][];

	public JPanel MapView;
	
	
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


}
