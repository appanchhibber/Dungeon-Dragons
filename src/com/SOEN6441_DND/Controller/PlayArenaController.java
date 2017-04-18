package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Strategy.ComputerStrategy;
import Strategy.FriendlyStrategy;
import Strategy.AggressiveStrategy;
import Strategy.HumanStrategy;
import Strategy.Strategy;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.CharacterInventoryView;
import com.SOEN6441_DND.Views.LogWindow;
import com.SOEN6441_DND.Views.PlayArena;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
		turnCounter = -1;

	}

	/**
	 * Turn Mechanism
	 * 
	 */
	public void turn() {
		playArena.playerMove.setVisible(true);
	}

	/**
	 * Visible View
	 */
	public void playerAction() {
		playArena.playersAttack.setVisible(true);
	}

	/**
	 * method for freezing hostile
	 */
	public void freeze() {
		playArena.playInfoPanel.character.freezeTimes--;
	}

	/**
	 * method for burning hostile
	 */
	public void burn() {
		playArena.playInfoPanel.character.burnedTimes--;
		if(playArena.playInfoPanel.character.getHitPoints()<playArena.playInfoPanel.character.burnedValue){
			playArena.playInfoPanel.character.setMoveCompleted(true);
		}
		playArena.playInfoPanel.character.setHitPoints(
				playArena.playInfoPanel.character.getHitPoints() - playArena.playInfoPanel.character.burnedValue);
	}

	/**
	 * method for executing the strategy
	 * 
	 * @param mapModel
	 * @param charModel
	 */
	public void execute(MapModel mapModel, CharacterModel charModel) {
		this.strategy.execute(mapModel, charModel);
	}

	/**
	 * method for setting the strategy
	 * 
	 * @param strategy
	 */
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
			playArena.charInventory.setcharModel(playArena.playInfoPanel.character);
			playArena.charInventory.setInventory();
		} else if (e.getSource() == playArena.playersAttack) {
			System.out.println(playArena.playInfoPanel.character.getName() + ": Attcking On :"
					+ playArena.playInfoPanel.character.getEnemy().getName());
			playArena.playInfoPanel.character.setAttackFlag(true);
			turnCounter--;
			playArena.playersAttack.setVisible(false);
			turn();
		} else if (e.getSource() == playArena.playerMove) {
			System.out.println("Button Clicked");
			playArena.playerMove.setVisible(false);
			if (turnCounter >= playArena.playModel.getPlayOrder().length - 1) {
				turnCounter = 0;
			} else {
				turnCounter++;
			}

			playArena.playInfoPanel.character = playArena.playModel.characters
					.get(playArena.playModel.getPlayOrder()[turnCounter]);
			if (playArena.playInfoPanel.character.slayed) {
				System.out.println(playArena.playInfoPanel.character.getName() + " is Dead.");
				LogWindow.setLogDisplay(playArena.playInfoPanel.character.getName() + " is Dead.");
				turn();
			}

			if (playArena.playInfoPanel.character.freezed) {
				if (playArena.playInfoPanel.character.freezeTimes == 0) {
					playArena.playInfoPanel.character.freezed = false;
				} else {
					System.out.println(playArena.playInfoPanel.character.getName() + " is Freezed");
					LogWindow.setLogDisplay(playArena.playInfoPanel.character.getName() + " is now Freezed");
					freeze();
					turn();
				}
			}
			if (playArena.playInfoPanel.character.pacified) {
				playArena.playInfoPanel.character.pacified = false;
				mapModel.getCharacters()
						.get(playArena.playInfoPanel.character.getName()).characterBehavior = "Friendly";
				playArena.playModel.setPlayOrder();
			}
			if (playArena.playInfoPanel.character.burned) {
				if (playArena.playInfoPanel.character.burnedTimes == 0) {
					playArena.playInfoPanel.character.burned = false;
				} else {
					System.out.println(playArena.playInfoPanel.character.getName() + " is Burning");
					LogWindow.setLogDisplay(playArena.playInfoPanel.character.getName() + " is now Burning");
					burn();
				}

			}
			LogWindow.setLogDisplay("Now " + playArena.playInfoPanel.character.getName() + "'s turn with "
					+ characterModel.getBehaviour() + "'s behaviour.");
			playArena.playInfoPanel.setPanel();
			playArena.charInventory.setcharModel(playArena.playInfoPanel.character);
			playArena.playInfoPanel.character.execute(mapModel);

		} else if (e.getSource() == playArena.startGame) {
			playArena.startGame.setVisible(false);
			playArena.playModel.setPlayOrder();
			mapModel.setCharacterName(characterModel.getName() + "-" + characterModel.getBehaviour());
			LogWindow.setLogDisplay("Below is the order of the turns");
			for (int i = 0; i < playArena.playModel.playOrder.length; i++) {
				LogWindow.setLogDisplay(playArena.playModel.playOrder[i]);
			}
			turn();

		} else if (e.getSource() instanceof JButton) {
			System.out.println("Button Clicked Common");
			JButton btn = (JButton) e.getSource();
			String name;

			if (btn.getName().contains("_") || btn.getName().contains("Player")) {
				if (btn.getName().contains("_")) {
					name = btn.getName().replace("_", "").trim() + "-" + btn.getToolTipText();

				} else {
					name = btn.getName();
				}
				playArena.playInfoPanel.character = playArena.playModel.getCharacters().get(name);
				playArena.playInfoPanel.setPanel();
				playArena.charInventory.setcharModel(playArena.playInfoPanel.character);
			}

		}
	}

}
