package com.SOEN6441_DND.Controller;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.CampaignView;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemScene;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.MapView;
public class MainSceneController implements ActionListener{

	
	private MainScene homeScreen;
	private GameController gameController;
	public MainSceneController(MainScene view)
	{
		this.homeScreen=view;
		gameController=GameController.getInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homeScreen.exitGameButton) {
			System.out.println("Exit Game button fired");
			System.exit(0);
		}
		if (e.getSource() == homeScreen.startGameButton) {
			System.out.println("Start Game button pressed");
		}
		if (e.getSource() == homeScreen.mapCreator) {
			gameController.mainFrame.setView(new MapView());

		}
			if (e.getSource() == homeScreen.mapEditor) {
				System.out.println("map editor fired");
				File file = openMapFile();
			}
			if (e.getSource() == homeScreen.itemCreation) {
				gameController.mainFrame.setView(new ItemScene());
			}
			if (e.getSource() == homeScreen.editItem) {
				System.out.println("item editor fired");
				File file = openItemFile();
			}
			if (e.getSource() == homeScreen.characterCreation) {
				gameController.mainFrame.setView(new CharacterScene());
			}
			if (e.getSource() == homeScreen.editCharacter) {
				System.out.println("character editor fired");
			}
			if(e.getSource()==homeScreen.campaignCreator){
				gameController.mainFrame.setView(new CampaignView());
			}
			if(e.getSource()==homeScreen.campaignEditor){
				
			}

		}



	// To Open Dialog Box
	public File openMapFile() {
		JFileChooser fileChooser = new JFileChooser(new File("maps/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
				"xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(gameController.mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}

	/**to open file for editing map
	 * 
	 * @return File type
	 */
	public File openItemFile() {
		JFileChooser fileChooser = new JFileChooser(new File("itemSave/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
				"xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(gameController.mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}
}
