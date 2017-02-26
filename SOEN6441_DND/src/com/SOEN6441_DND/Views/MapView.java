package com.SOEN6441_DND.Views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Model.MapModel;

@SuppressWarnings("serial")
public class MapView extends View {
	public NavigationPanelView navPanel;
	public InventoryPanelView inventView;
	public GridView gridView;
	
	public MapModel mapModel;
	public MapViewController mapController;

	// Global Variables
public	int mapWidth;
public	int mapHeight;

	@Override
	protected void initSubviews() {
		super.initSubviews();
		String[] mapValue={"10","11","12","13","14","15"};
		mapModel = new MapModel();
		mapController = new MapViewController(this);
		// The Dialog Box for dimensions
		JComboBox txtX = new JComboBox();
		txtX.setModel(new DefaultComboBoxModel(mapValue));
		JComboBox txtY = new JComboBox();
		txtY.setModel(new DefaultComboBoxModel(mapValue));
		Object[] message = { "Size of X:", txtX, "Size of Y:", txtY };
		int option = JOptionPane.showConfirmDialog(null, message,
				"SET SIZE OF MAP", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			//mapModel.setMapWidth(Integer.parseInt(txtX.getText().trim()));
			//mapModel.setMapHeight(Integer.parseInt(txtY.getText().trim()));
			mapWidth = Integer.parseInt(txtX.getSelectedItem().toString());
			mapHeight = Integer.parseInt(txtY.getSelectedItem().toString());
			
			
			
			gridView=new GridView(mapWidth, mapHeight);
			this.add(gridView);
			

		}

		//
		inventView = new InventoryPanelView();
		this.add(inventView);

		navPanel = new NavigationPanelView();
		this.add(navPanel);
	}

}
