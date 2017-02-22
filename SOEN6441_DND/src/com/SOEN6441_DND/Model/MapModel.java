package com.SOEN6441_DND.Model;

import javax.swing.JPanel;

public class MapModel {
	int mapWidth;
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

	int mapHeight;
	public int mapGridSelection[][];
	
	public JPanel MapView;

}
