package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.CampaignView;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemScene;
import com.SOEN6441_DND.Views.LogWindow;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.MapView;
import com.SOEN6441_DND.Views.StartGameView;
/**
 * Main menu controller class
 * @author Appan Chhibber
 *
 */
public class MainSceneController implements ActionListener {

	private MainScene homeScreen;
	private GameController gameController;
	public FileOperationModel ioModel;
	public MapModel mapModel;
	public ItemModel itemModel;
/**
 * Constructor for main scene controller 
 * @param view
 */
	public MainSceneController(MainScene view) {
		this.homeScreen = view;
		gameController = GameController.getInstance();
		ioModel = new FileOperationModel();
		mapModel = new MapModel();
		itemModel = new ItemModel();
	}

	/**
	 * Action Listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homeScreen.exitGameButton) {
			System.out.println("Exit Game button fired");
			System.exit(0);
		}
		if (e.getSource() == homeScreen.startGameButton) {
			gameController.mainFrame.setView(new StartGameView());
		}
		if (e.getSource() == homeScreen.mapCreator) {
			String[] mapValue = { "10", "11", "12", "13", "14", "15" };
			String mode = "create";
			JComboBox txtX = new JComboBox();
			txtX.setModel(new DefaultComboBoxModel(mapValue));
			JComboBox txtY = new JComboBox();
			txtY.setModel(new DefaultComboBoxModel(mapValue));
			Object[] message = { "Size of X:", txtX, "Size of Y:", txtY };
			int option = JOptionPane.showConfirmDialog(null, message, "SET SIZE OF MAP", JOptionPane.CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				// mapModel.setMapWidth(Integer.parseInt(txtX.getText().trim()));
				// mapModel.setMapHeight(Integer.parseInt(txtY.getText().trim()));
				mapModel.setMapHeight(Integer.parseInt(txtX.getSelectedItem().toString()));
				mapModel.setMapWidth(Integer.parseInt(txtY.getSelectedItem().toString()));
				gameController.mainFrame.setView(new MapView(mapModel, mode));

			}

		}
		if (e.getSource() == homeScreen.itemCreation) {
			LogWindow.setLogDisplay("You are Item creation screen !!");
			String mode = "create";
			gameController.mainFrame.setView(new ItemScene(new ItemModel(),"create"));
		}
		if (e.getSource() == homeScreen.editItem) {
			System.out.println("item editor fired");
			File file = openItemFile();
			System.out.println(file);

			// gameController.mainFrame.setView(new ItemScene());
		}

		if (e.getSource() == homeScreen.characterCreation) {
			gameController.mainFrame.setView(new CharacterScene());
		}
		if (e.getSource() == homeScreen.editCharacter) {
			System.out.println("character editor fired");
		}
		if (e.getSource() == homeScreen.campaignCreator) {
			gameController.mainFrame.setView(new CampaignView(new CampaignModel(),"create"));
		}
		if (e.getSource() == homeScreen.campaignEditor) {

		}

	}

	/**
	 * to open file for editing map
	 * 
	 * @return File type
	 */
	public File openItemFile() {
		JFileChooser fileChooser = new JFileChooser(new File("itemSave/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
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
