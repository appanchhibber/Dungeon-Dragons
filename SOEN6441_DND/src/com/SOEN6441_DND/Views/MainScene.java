package com.SOEN6441_DND.Views;

import java.awt.Button;
import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;

/**
 * This class defines the mainscene. On the Main interface of our game, there
 * are 2 buttons presented: StartGameButton, ExitButton and the JMenu for
 * editing and creation of Characters,Items and Maps.
 * 
 * @author Appan Chhibber
 * @version 1.0
 * @see
 */
public class MainScene extends View {
	private Button startGameButton;

	private Button exitGameButton;

	@Override
	protected void initSubviews() {
		super.initSubviews();
		JMenuBar menuBar = new JMenuBar();
		JMenu mnCharacter = new JMenu("Character");
		menuBar.add(mnCharacter);

		JMenuItem characterCreation = new JMenuItem("Character Creation");
		mnCharacter.add(characterCreation);

		JMenuItem editCharacter = new JMenuItem("Edit Character");
		mnCharacter.add(editCharacter);

		JMenu mnItem = new JMenu("Item");
		menuBar.add(mnItem);

		JMenuItem itemCreation = new JMenuItem("Item Creation");
		mnItem.add(itemCreation);

		JMenuItem editItem = new JMenuItem("Edit Item");
		mnItem.add(editItem);

		JMenu mnMap = new JMenu("Map");
		menuBar.add(mnMap);

		JMenuItem mapCreator = new JMenuItem("Map Creator");
		mnMap.add(mapCreator);

		JMenuItem mapEditor = new JMenuItem("Map Editor");
		mnMap.add(mapEditor);
		menuBar.setLocation(0, 0);
		menuBar.setSize(860, 25);
		this.add(menuBar);
		// adding background image to JPanel
		ImageIcon image = new ImageIcon("image/gameBk.jpg");
		JLabel label = new JLabel(new ImageIcon(
				((image.getImage().getScaledInstance(
						ApplicationStatics.WINDOW_WIDTH,
						(ApplicationStatics.WINDOW_HEIGHT - 5),
						java.awt.Image.SCALE_SMOOTH)))));
		label.setLocation(0, 25);
		label.setSize(860, 630);
		this.add(label);

		// new JPanel for addition of buttons to mainscene
		View buttonView = new View();
		buttonView.setLocation(0, 400);
		buttonView.setSize(860, 300);
		buttonView.setOpaque(false);
		// add a statGameButton in the mainscene
		startGameButton = new Button();
		startGameButton.setLabel("Start Game");
		startGameButton.setLocation(330, 5);
		startGameButton.setSize(200, 40);
		buttonView.add(startGameButton);

		// add a exitGameButton in the mainscene
		exitGameButton = new Button();
		exitGameButton.setLabel("Exit Game");
		exitGameButton.setLocation(330, 80);
		exitGameButton.setSize(200, 40);
		buttonView.add(exitGameButton);
		this.add(buttonView);
		// for the increasing the zindex of buttonView
		this.setComponentZOrder(buttonView, 0);
	}

}
