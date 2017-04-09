package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Strategy.ComputerStrategy;
import Strategy.FriendlyStrategy;
import Strategy.HostileStrategy;
import Strategy.PlayerStrategy;
import Strategy.Strategy;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.CharacterInventoryView;
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

	private Strategy strategy;

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
		nextMapFlag = false;
		turnCounter = 0;

	}

	/**
	 * Turn Mechanism
	 * 
	 */
	public void turn() {
		if (turnCounter >= playArena.playModel.getPlayOrder().length - 1) {
			turnCounter = 0;
		} else {
			turnCounter++;
		}
		String[] tempTurn = playArena.playModel.getPlayOrder()[turnCounter].split("-");
		turnCharacter = tempTurn[0];
		turnBehaviour = tempTurn[1];
		switch (turnBehaviour) {
		case "Player": {
			System.out.println("Player Turn");
			this.setStrategy(new PlayerStrategy());
			
				this.execute(playArena.gridView.mapModel,
						playArena.playModel.characters.get(playArena.playModel.getPlayOrder()[turnCounter]));
			
			break;
		}
		case "Hostile": {
			System.out.println("Hostile Turn");
			this.setStrategy(new HostileStrategy());
			this.execute(playArena.gridView.mapModel,
					playArena.playModel.characters.get(playArena.playModel.getPlayOrder()[turnCounter]));
			//turn();
			break;
		}
		case "Friendly": {
			System.out.println("Friendly Turn");
			this.setStrategy(new FriendlyStrategy());
			this.execute(playArena.gridView.mapModel,
					playArena.playModel.characters.get(playArena.playModel.getPlayOrder()[turnCounter]));
			turn();
			break;
		}
		case "Computer": {
			System.out.println("Computer Turn");
			this.setStrategy(new ComputerStrategy());
			this.execute(playArena.gridView.mapModel,
					playArena.playModel.characters.get(playArena.playModel.getPlayOrder()[turnCounter]));
			//turn();
			break;
		}
		}

	}

	public void execute(MapModel mapModel, CharacterModel charModel) {
		this.strategy.execute(mapModel, charModel);
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Action Listener for the events being generated on the View
	 * 
	 * @author Appan Chhibber
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == playArena.playInfoPanel.inventoryBtn) {
			playArena.charInventory.setcharModel(playArena.playInfoPanel.player);
			playArena.charInventory.setInventory();
		} else if(e.getSource()==playArena.startGame){
			playArena.startGame.setVisible(false);
			playArena.playModel.setPlayOrder();
			mapModel.setCharacterName(characterModel.getName()+"-"+characterModel.getBehaviour());
			turn();
			
		}else if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			String name;
				
			if (btn.getName().contains("_") || btn.getName().contains("Player")) {
				if(btn.getName().contains("_"))
				{
					name=btn.getName().replace("_", "").trim()+"-"+btn.getToolTipText();
					
				}
				else
				{
					name=btn.getName();
				}
				playArena.playInfoPanel.player=playArena.playModel.getCharacters().get(name);
				playArena.playInfoPanel.setPanel();
				playArena.charInventory.setcharModel(playArena.playInfoPanel.player);
			}

		}
	}

}
