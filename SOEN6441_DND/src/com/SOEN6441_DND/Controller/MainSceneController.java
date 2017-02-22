package com.SOEN6441_DND.Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.Windows;
/**
 * This Class is the controller class of Main Scene and intercepts actions generated on view. 
 * @author Ehab Amar
 *@version 1.0.0
 */
public class MainSceneController implements ActionListener {

	// To Open Dialog Box
	public File openMapFile() {
		JFileChooser fileChooser = new JFileChooser(new File("maps/"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
				"xml");
		fileChooser.setFileFilter(filter);
		int option = fileChooser.showOpenDialog(Game.getInstance());

		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == MainScene.exitGameButton) {
			System.out.println("Exit Game button fired");
			System.exit(0);
		}
		if (e.getSource() == MainScene.startGameButton) {
			System.out.println("Start Game button pressed");
		}
		if (e.getSource() == MainScene.mapCreator) {
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
			if (e.getSource() == MainScene.mapEditor) {
				System.out.println("map editor fired");
				File file = openMapFile();
			}
			if (e.getSource() == MainScene.itemCreation) {
				System.out.println("item creator fired");
			}
			if (e.getSource() == MainScene.editItem) {
				System.out.println("item editor fired");
			}
			if (e.getSource() == MainScene.characterCreation) {
				System.out.println("CHaracter creator fired");
			}
			if (e.getSource() == MainScene.editCharacter) {
				System.out.println("character editor fired");
			}

		}

	}

