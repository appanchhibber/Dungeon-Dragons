package com.SOEN6441_DND.Views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.PlayArenaController;
import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Model.PlayModel;
import com.sun.glass.events.KeyEvent;

/**
 * This view is the parent view of gridmap and the character ability panel and
 * displays the play scene of the game
 * 
 * @author Appan Chhibber
 *
 */
public class PlayArena extends View implements Observer {
	public PlayArenaController playController;
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public FileOperationModel ioModel;
	public CharacterModel charModel;
	public GameController gameController;
	public JButton playerPos;
	public GridView gridView;
	public Timer repaintTimer;
	public PlayModel playModel;
	public boolean chestFlag;
	public int charLocX = 0;
	public int charLocY = 0;

	public PlayerInfoPanelView playInfoPanel;
	public CharacterInventoryView charInventory;
	public static  InputMap inputMap;
	public static ActionMap actionMap;
	@Override
	protected void initSubviews() {
		super.initSubviews();
		playInfoPanel = new PlayerInfoPanelView();
		this.add(playInfoPanel);
		
	}

	/**
	 * constructor for passing the model from controller to the view
	 * 
	 * @param mapModel
	 * @param campaignModel
	 * @param charModel
	 * @author Appan Chhibber
	 */
	public PlayArena(MapModel mapModel, CampaignModel campaignModel,
			CharacterModel charModel) {
		this.mapModel = mapModel;
		this.campaignModel = campaignModel;
		this.charModel=charModel;
		
		playModel = new PlayModel();
		ioModel = new FileOperationModel();
		playInfoPanel= new PlayerInfoPanelView();
		playController = new PlayArenaController(this);
		

		playInfoPanel.inventoryBtn.addActionListener(playController);
		charLocX = (int) (mapModel.getEntry().getWidth()) + 1;
		charLocY = (int) (mapModel.getEntry().getHeight());
		chestFlag = false;
		charModel.setCharLocation(new Dimension(charLocX,charLocY));
		playModel.addCharacter((charModel.getName()+"-Player"), charModel);
		mapModel.addCharLocation((charModel.getName()+"-Player"), new Dimension(charLocX,charLocY));
		gridView = new GridView(mapModel, this);
		inputMap = this.gridView.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		actionMap = this.gridView.getActionMap();
		playModel.setPlayOrder();
		playController.turn();
		this.add(gridView);
		for(Map.Entry<String, CharacterModel> charact:playModel.characters.entrySet()){
			charact.getValue().addObserver(gridView);
			charact.getValue().addObserver(playInfoPanel);
		}
	}
	/**
	 * Observer update method to allow changes to be displayed on the map
	 * 
	 * @author Appan Chhibber
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.charModel = (CharacterModel) o;
		System.out.println("inside update method");
		if (charModel.message == "character data") {
			System.out.println("inside character data method");
			System.out.println(charModel.getAbilityScore().getWisdom());
			System.out.println(charModel.getAbilityScore().getCharisma());
			System.out.println(charModel.getFighterType());
			System.out.println(charModel.getName());
		}

	}

	/**
	 * Method responsible for loading the next map from the list of maps in
	 * campaign list
	 * 
	 * @param mapName
	 * @author Appan Chhibber
	 */
	public void loadNextMap(String mapName) {
		playController.nextMapFlag=true;
		gameController = GameController.getInstance();
		mapModel = ioModel.readMapFile(new File("maps/" + mapName));
		charModel.setLevel(charModel.getLevel()+1);
		gameController.mainFrame.setView(new PlayArena(mapModel, campaignModel,
				charModel));
		
	}



}
