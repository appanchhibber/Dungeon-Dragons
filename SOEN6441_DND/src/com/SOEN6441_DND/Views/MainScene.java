package com.SOEN6441_DND.Views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;

public class MainScene extends View {
	private Button loadGameButton;

	private Button newGameButton;

	@Override
	protected void initSubviews() {
		super.initSubviews();

		this.setLayout(new BorderLayout());
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

		ImageIcon image = new ImageIcon("image/gameBk.jpg");
		JLabel label = new JLabel(new ImageIcon(
				((image.getImage().getScaledInstance(
						ApplicationStatics.WINDOW_WIDTH,
						(ApplicationStatics.WINDOW_HEIGHT - 45),
						java.awt.Image.SCALE_SMOOTH)))));

		View buttonView = new View();
		buttonView.setLayout(null);
		buttonView.setLocation(450, 450);
		buttonView.setSize(200, 200);
		loadGameButton = new Button();
		loadGameButton.setLabel("Start Game");
		loadGameButton.setLocation(300, 300);
		loadGameButton.setSize(200, 40);
		buttonView.add(loadGameButton);

		// add a newGameButton in the mainscene
		newGameButton = new Button();
		newGameButton.setLabel("Exit Game");
		newGameButton.setLocation(300, 450);
		newGameButton.setSize(200, 40);
		buttonView.add(newGameButton);
		this.add(buttonView, BorderLayout.CENTER);
		this.add(label, BorderLayout.SOUTH);
		this.add(menuBar, BorderLayout.NORTH);
		this.setComponentZOrder(buttonView, 2);

	}

}
