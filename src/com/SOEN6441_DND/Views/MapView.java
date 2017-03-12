package com.SOEN6441_DND.Views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Model.MapModel;

@SuppressWarnings("serial")
/**
 * 
 * @author Appan Chhibber
 *
 */
public class MapView extends View implements Observer {
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
		inventView.addCharacter.addActionListener(mapController);
		inventView.addTreasure.addActionListener(mapController);
		this.add(inventView);
		
       
		navPanel = new NavigationPanelView();
		navPanel.saveButton.setEnabled(false);
		navPanel.saveButton.addActionListener(mapController);
		navPanel.loadButton.addActionListener(mapController);
		this.add(navPanel);
		mapModel.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
	this.mapModel=(MapModel)o;
		if(mapModel.message=="characterList"){
			inventView.characterLabel.setVisible(true);
			inventView.characterDropDown.setModel(new DefaultComboBoxModel(mapModel.getCharacterList().toArray()));
			inventView.characterDropDown.setVisible(true);		
		}
		else if(mapModel.message=="Uncheckcharacter"){
			inventView.characterDropDown.setVisible(false);
			inventView.characterLabel.setVisible(false);
		}
		else if(mapModel.message=="TreasureList"){
			inventView.treasureLabel.setVisible(true);
			inventView.treasureDropDown.setModel(new DefaultComboBoxModel(mapModel.getTreasureList().toArray()));
			inventView.treasureDropDown.setVisible(true);	
		}
		else if(mapModel.message=="UncheckTreasure"){
			inventView.treasureDropDown.setVisible(false);
			inventView.treasureLabel.setVisible(false);
		}

	}

}
