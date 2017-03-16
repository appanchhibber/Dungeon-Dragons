package com.SOEN6441_DND.Views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Controller.TransferHandlerController;
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
		inventView.charImageLabel.addMouseMotionListener(mapController);
		inventView.treaImageLabel.addMouseMotionListener(mapController);
		inventView.validateButton.addActionListener(mapController);
		inventView.addCharacter.addActionListener(mapController);
		inventView.addTreasure.addActionListener(mapController);
		inventView.characterDropDown.addActionListener(mapController);
		inventView.treasureDropDown.addActionListener(mapController);
		this.add(inventView);
		
       
		navPanel = new NavigationPanelView();
		navPanel.saveButton.setEnabled(false);
		navPanel.saveButton.addActionListener(mapController);
		navPanel.loadButton.addActionListener(mapController);
		this.add(navPanel);
		mapModel.addObserver(this);
		
	}

	public void createTreasureImage(String imagePath){
		inventView.treasureImage=new ImageIcon(new ImageIcon(imagePath).getImage()
				.getScaledInstance(50,
						50,
						java.awt.Image.SCALE_SMOOTH));
		inventView.treaImageLabel.setIcon(inventView.treasureImage);
		inventView.treaImageLabel.setName("."+inventView.treasureDropDown.getSelectedItem().toString());
		inventView.treaImageLabel.setTransferHandler(new TransferHandlerController()
		.valueExportCreator(imagePath,inventView.treaImageLabel.getName()));
		inventView.revalidate();
		inventView.repaint();
	}
	public void createCharacterImage(String imagePath){
		inventView.characterImage=new ImageIcon(new ImageIcon(imagePath).getImage()
				.getScaledInstance(50,
						50,
						java.awt.Image.SCALE_SMOOTH));
		inventView.charImageLabel.setIcon(inventView.characterImage);
		inventView.charImageLabel.setName("_"+inventView.characterDropDown.getSelectedItem().toString());
		inventView.charImageLabel.setTransferHandler(new TransferHandlerController()
		.valueExportCreator(imagePath,inventView.charImageLabel.getName()));
		inventView.revalidate();
		inventView.repaint();
	}
	@Override
	public void update(Observable o, Object arg) {
	this.mapModel=(MapModel)o;
		if(mapModel.message=="characterList"){
			inventView.characterLabel.setVisible(true);
			inventView.characterDropDown.setModel(new DefaultComboBoxModel(mapModel.getCharacterList().toArray()));
			inventView.characterDropDown.setVisible(true);	
			inventView.characterBehavior.setVisible(true);
			inventView.selectBehavior.setVisible(true);
		}
		else if(mapModel.message=="Uncheckcharacter"){
			inventView.characterDropDown.setVisible(false);
			inventView.characterLabel.setVisible(false);
			inventView.characterBehavior.setVisible(false);
			inventView.selectBehavior.setVisible(false);
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
		else if(mapModel.message=="characterImage"){
			createCharacterImage(mapModel.getCharacterImage());
		}
		else if(mapModel.message=="treasureImage"){
			createTreasureImage("image/Treasure.jpg");
		}

	}

}
