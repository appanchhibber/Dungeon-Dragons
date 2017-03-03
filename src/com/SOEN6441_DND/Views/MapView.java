package com.SOEN6441_DND.Views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Model.MapModel;

@SuppressWarnings("serial")
public class MapView extends View {
	public NavigationPanelView navPanel;
	public InventoryPanelView inventView;
	public GridView gridView;
	public GameController gameController;
	public MapModel mapModel;
	public MapViewController mapController;

	// Global Variables
public	int mapWidth;
public	int mapHeight;
	
	public MapView(MapModel model,String mode) {
		// TODO Auto-generated constructor stub
		mapWidth = model.getMapWidth();
		mapHeight = mapModel.getMapWidth();
			gridView=new GridView(model,this,mode);	
	

	
		this.add(gridView);
	}

	@Override
	protected void initSubviews() {
		super.initSubviews();
		
		mapModel = new MapModel();
		mapController = new MapViewController(this);
		// The Dialog Box for dimensions
		
		inventView = new InventoryPanelView();
		inventView.entryDoorLabel.addMouseMotionListener(mapController);
		inventView.wallLabel.addMouseMotionListener(mapController);
		inventView.chestLabel.addMouseMotionListener(mapController);
		inventView.exitDoorLabel.addMouseMotionListener(mapController);
		inventView.validateButton.addActionListener(mapController);
		this.add(inventView);
		

		navPanel = new NavigationPanelView();
		navPanel.saveButton.setEnabled(false);
		navPanel.saveButton.addActionListener(mapController);
		navPanel.loadButton.addActionListener(mapController);
		this.add(navPanel);
		
	}

}
