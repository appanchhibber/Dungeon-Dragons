package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.text.IconView;

import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Controller.TransferHandlerController;

public class GridView extends JPanel {
	private int mapWidth;
	private int mapHeight;
	public JButton mapButtonsGrid[][];
	public int mapGridSelection[][];
	public MapView mapView;
	
	public TransferHandlerController transferHandler;
	public GridView(int mapWidth, int mapHeight,MapView mapView) {
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
		this.mapView=mapView;
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
				mapButtonsGrid[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				// multiple = mapModel.getMapWidth();
				multiple = mapWidth;

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);
				mapButtonsGrid[i][j].setName( i + "," + j);
				mapButtonsGrid[i][j].setBackground(Color.WHITE); 
				mapButtonsGrid[i][j].setOpaque(true);
				mapButtonsGrid[i][j].setBorderPainted(false);
				mapButtonsGrid[i][j].setSize(40,40);
				mapButtonsGrid[i][j].setTransferHandler(new TransferHandlerController().valueImportCreator());
				mapButtonsGrid[i][j].addMouseListener(new MouseAdapter() {
					 public void mousePressed(MouseEvent e) {
						// System.out.println(e.getButton());
						 if(e.getButton()==MouseEvent.BUTTON3)
						 {
	                            JButton button=(JButton)e.getSource();
	                            if(!button.getName().contains(",")){
	                            	 button.setSelected(true);
	                            	 //System.out.println(button.getName());
	                            	 button.setIcon(null);
	                            	 button.setName(button.getText());

	                            }
						 }

                           
					    }
				});
				this.add(mapButtonsGrid[i][j]);
			}
		}
	}
	
}
