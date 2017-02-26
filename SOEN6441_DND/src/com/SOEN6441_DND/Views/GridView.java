package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridView extends JPanel {
	private int mapWidth;
	private int mapHeight;
	private JButton mapButtonsGrid[][];
	public int mapGridSelection[][];
	public GridView(int mapWidth, int mapHeight) {
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
		
		this.setLayout(new GridLayout(mapHeight,
				mapWidth, 3, 3));
		
		this.setBackground(Color.BLACK);
		this.setLocation(10, 10);
		this.setVisible(true);
		this.setSize(620,530);
		createGridView();
	}

	public void createGridView() {
		
		mapButtonsGrid = new JButton[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				System.out.println("i:"+i+"j:"+j);
				mapButtonsGrid[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				// multiple = mapModel.getMapWidth();
				multiple = mapWidth;

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);
				mapButtonsGrid[i][j].setBackground(Color.WHITE); 
				mapButtonsGrid[i][j].setOpaque(true);
				mapButtonsGrid[i][j].setBorderPainted(false);
				mapButtonsGrid[i][j].setSize(40,40);
				this.add(mapButtonsGrid[i][j]);
			}
		}
	}
	
}
