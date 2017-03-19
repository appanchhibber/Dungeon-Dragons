package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;









import javax.swing.Timer;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class PlayArenaController implements ActionListener {
	
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public CharacterModel characterModel;
	public PlayArena playArena;
	public GameController gameController;
	public FileOperationModel ioModel;
	public PlayArenaController(PlayArena playArena){
		this.playArena=playArena;
		mapModel=playArena.mapModel;
		campaignModel=playArena.campaignModel;
		gameController=playArena.gameController;
		ioModel=playArena.ioModel;
	}

	

@Override
	public void actionPerformed(ActionEvent e) {

	if(e.getSource()==playArena.gridView.mapButtonsGrid[playArena.charLocY][playArena.charLocX]){
		
	}
	}
}
