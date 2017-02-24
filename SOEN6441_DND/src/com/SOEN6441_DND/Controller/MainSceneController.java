package com.SOEN6441_DND.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.ItemScene;
import com.SOEN6441_DND.Views.MainScene;
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
			System.out.println("map creator fired ");
			final JTextField txtX = new JTextField();
			final JTextField txtY = new JTextField();

			Object[] message = { "Size of X:", txtX, "Size of Y:", txtY };
			int option = JOptionPane.showConfirmDialog(null, message,
					"SET SIZE OF MAP", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				String x = txtX.getText().trim();
				String y = txtY.getText().trim();

				if (x.length() == 0) {
					JOptionPane.showMessageDialog(null, String.format(
							ApplicationStatics.MSG_X_MAY_NOT_EMPTY, "X"));
				}

				else if (y.length() == 0) {

					JOptionPane.showMessageDialog(null, String.format(
							ApplicationStatics.MSG_X_MAY_NOT_EMPTY, "Y"));
				}

				else if (Integer.parseInt(x) < 1 || Integer.parseInt(x) > 30) {

					JOptionPane.showMessageDialog(null, String.format(
							ApplicationStatics.MSG_X_MUST_BE_IN_RANGE, "X"));
				}

				else if (Integer.parseInt(y) < 1 || Integer.parseInt(y) > 30) {

					JOptionPane.showMessageDialog(null, String.format(
							ApplicationStatics.MSG_X_MUST_BE_IN_RANGE, "Y"));
				}
				
				
			}
		}
			if (e.getSource() == homeScreen.mapEditor) {
				System.out.println("map editor fired");
				File file = openMapFile();
			}
			if (e.getSource() == homeScreen.itemCreation) {
				ItemScene itemScreen = new ItemScene();
				gameController.mainFrame.setView(itemScreen);
			}
			if (e.getSource() == homeScreen.editItem) {
				System.out.println("item editor fired");
			}
			if (e.getSource() == homeScreen.characterCreation) {
				CharacterScene characterScreen = new CharacterScene();
				gameController.mainFrame.setView(characterScreen);
			}
			if (e.getSource() == homeScreen.editCharacter) {
				System.out.println("character editor fired");
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

}
