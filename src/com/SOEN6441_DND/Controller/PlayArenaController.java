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
			JButton button = (JButton)e.getSource();
			if(button.getName().contains("_")){
			try {
				characterModel = ioModel
						.loadCharacter(button.getName().replace("_", "").trim());
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Unable to Load character Characteristics");
				e1.printStackTrace();
			}
		}
		} 
	}
}
