package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Model.PlayModel;
import com.SOEN6441_DND.Views.CharacterInventoryView;
import com.SOEN6441_DND.Views.ItemAssignView;
import com.SOEN6441_DND.Views.PlayArena;
import javax.swing.JButton;

/**
 * This controller is responsible for handling the play game aspect and
 * listening to the events being generated on Play Arena View
 * 
 * @author Appan Chhibber
 *
 */
public class PlayArenaController implements ActionListener {

	public MapModel mapModel;
	public CampaignModel campaignModel;
	public CharacterModel characterModel;
	public PlayArena playArena;
	public GameController gameController;
	public FileOperationModel ioModel;
	public boolean nextMapFlag;
	public String turnCharacter;
	public String turnBehaviour;
	public int turnCounter;

	/**
	 * Constructor for initializing the local variables to the instance
	 * available in the view or create a new instance
	 * 
	 * @param playArena
	 * @author Appan Chhibber
	 */
	public PlayArenaController(PlayArena playArena) {
		this.playArena = playArena;
		mapModel = playArena.mapModel;
		campaignModel = playArena.campaignModel;
		gameController = playArena.gameController;
		ioModel = playArena.ioModel;
		characterModel = playArena.charModel;
		nextMapFlag=false;
		turnCounter=0;
		
	}
	/**
	 * Turn Mechanism
	 * 
	 */
	public void turn() {
			if(turnCounter>=playArena.playModel.getPlayOrder().length-1){
				turnCounter=0;
			}
			else{
				turnCounter++;
			}
			String[] tempTurn=playArena.playModel.getPlayOrder()[turnCounter].split("-");
			turnCharacter=tempTurn[0];
			turnBehaviour=tempTurn[1];
			switch(turnBehaviour){
			case "Player":{
				System.out.println("Player Turn");
				playArena.keyBinding();
				
				break;
			}
			case "Hostile":{
				System.out.println("Hostile Turn");
				turn();
				break;
			}
			case "Friendly":{
				System.out.println("Friendly Turn");
				turn();
				break;
			}
			case "Computer":{
				System.out.println("Computer Turn");
				turn();
				break;
			}
			}
		
	}

	/**
	 * Action Listener for the events being generated on the View
	 * 
	 * @author Appan Chhibber
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == playArena.playInfoPanel.inventoryBtn) {
			playArena.charInventory.setInventory();
		}
		 else if (e.getSource() instanceof JButton) {
		} 
	}
}
