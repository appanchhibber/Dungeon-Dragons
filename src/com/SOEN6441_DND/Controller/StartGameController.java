package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Model.PlayModel;
import com.SOEN6441_DND.Model.StartGameModel;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.PlayArena;
import com.SOEN6441_DND.Views.StartGameView;

/**
 * This controller is responsible for handling the events and the data being
 * generated in the StartGame View
 * 
 * @author Appan Chhibber
 *
 */
public class StartGameController implements ActionListener {

	public StartGameView startView;
	public StartGameModel startModel;
	public GameController gameController;
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public CharacterModel characterModel;
	public FileOperationModel ioModel;

	/**
	 * Constructor for initializing the local variables to the instances
	 * available in the view or create new instances
	 * 
	 * @param view
	 * @author Appan Chhibber
	 */
	public StartGameController(StartGameView view) {
		startView = view;
		startModel = view.startModel;
		gameController = GameController.getInstance();
		ioModel = new FileOperationModel();
	}

	/**
	 * Action Listener for listening to the events
	 * 
	 * @author Appan Chhibber
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startView.startBtn) {
			if (startView.selectCampaign.getSelectedItem().equals("Select")
					|| startView.selectCharacter.getSelectedItem().equals(
							"Select")) {
				JOptionPane.showMessageDialog(null,
						"Campaign and Character Cant be Null!");
			} else {
				campaignModel = ioModel.readCampaignFile(new File("campaign/"
						+ startView.selectCampaign.getSelectedItem() + ".xml"));
				this.characterModel=ioModel.loadCharacter(startView.selectCharacter
						.getSelectedItem().toString());
				mapModel = ioModel.readMapFile(new File("maps/"
						+ campaignModel.getCampMapList().get(0)));
				gameController.mainFrame.setView(new PlayArena(mapModel,
						campaignModel, characterModel));
			}
		} else if (e.getSource() == startView.backBtn) {
			gameController.mainFrame.setView(new MainScene());
		}

	}

}
