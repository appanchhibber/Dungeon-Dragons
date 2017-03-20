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
		characterModel=playArena.charModel;
	}

	

@Override
	public void actionPerformed(ActionEvent e) {

	if(e.getSource()==playArena.gridView.mapButtonsGrid[playArena.charLocY][playArena.charLocX]){
		try {
			characterModel=ioModel.loadCharacter(playArena.gridView.mapButtonsGrid[playArena.charLocY][playArena.charLocX].getName());
			System.out.println(characterModel.getDamageBonus());
			System.out.println(characterModel.getAbilityScore().getStrength());
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Unable to Load character Characteristics");
			e1.printStackTrace();
		}
	}
	else if(e.getSource()==playArena.playInfoPanel.inventoryBtn){
		new CharacterInventoryView();
	}
	}
}
