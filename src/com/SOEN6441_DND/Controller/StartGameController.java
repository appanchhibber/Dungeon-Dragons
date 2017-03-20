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

public class StartGameController implements ActionListener{

	public StartGameView startView;
	public StartGameModel startModel;
	public GameController gameController;
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public CharacterModel characterModel;
	public FileOperationModel ioModel;
	public StartGameController(StartGameView view){
		startView=view;
		startModel=view.startModel;
		gameController=GameController.getInstance();
		ioModel=new FileOperationModel();
		characterModel=new CharacterModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startView.startBtn){
			if(startView.selectCampaign.getSelectedItem().equals("Select")||startView.selectCharacter.getSelectedItem().equals("Select")){
				JOptionPane.showMessageDialog(null,"Campaign and Character Cant be Null!");
			}
			else{
				campaignModel=ioModel.readCampaignFile(new File("campaign/"+startView.selectCampaign.getSelectedItem()+".xml"));
				characterModel.setName(startView.selectCharacter.getSelectedItem().toString());
				characterModel.setImage(ioModel.getCharacterImagePath(characterModel.getName()));
				mapModel=ioModel.readMapFile(new File("maps/"+campaignModel.getCampMapList().get(0)));
				gameController.mainFrame.setView(new PlayArena(mapModel,campaignModel,characterModel));
			}
		}
		else if(e.getSource()==startView.backBtn){
			gameController.mainFrame.setView(new MainScene());
		}
		
	}

}
