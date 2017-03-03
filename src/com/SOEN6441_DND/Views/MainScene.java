package com.SOEN6441_DND.Views;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.MainSceneController;

/**
 * This class defines the mainscene. On the Main interface of our game, there
 * are 2 buttons presented: StartGameButton, ExitButton and the JMenu for
 * editing and creation of Characters,Items and Maps.
 * 
 * @author Appan Chhibber
 * @version 1.0
 * @see
 */
@SuppressWarnings("serial")
public class MainScene extends View {
	public Button startGameButton, exitGameButton;
	public JMenuItem characterCreation, editCharacter, itemCreation,
			editItem, mapCreator, mapEditor,campaignCreator,campaignEditor;
	private MainSceneController msController;

	@Override
	protected void initSubviews() {
		super.initSubviews();
		msController = new MainSceneController(this);
		JMenuBar menuBar = new JMenuBar();
		JMenu mnCharacter = new JMenu("Character");
		
		menuBar.add(mnCharacter);

		characterCreation = new JMenuItem("Character Creation");
		characterCreation.addActionListener(msController);
		mnCharacter.add(characterCreation);


		JMenu mnItem = new JMenu("Item");
		menuBar.add(mnItem);

		itemCreation = new JMenuItem("Item Creation");
		itemCreation.addActionListener(msController);
		mnItem.add(itemCreation);


		JMenu mnMap = new JMenu("Map");
		menuBar.add(mnMap);

		mapCreator = new JMenuItem("Map Creator");
		mapCreator.addActionListener(msController);
		mnMap.add(mapCreator);

		mapEditor = new JMenuItem("Map Editor");
		mapEditor.addActionListener(msController);
		mnMap.add(mapEditor);
		
		JMenu mnCampaign=new JMenu("Campaign");
		menuBar.add(mnCampaign);
		campaignCreator=new JMenuItem("Campaign Creator");
		campaignCreator.addActionListener(msController);
		mnCampaign.add(campaignCreator);
		
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
		startGameButton.addActionListener(msController);
		buttonView.add(startGameButton);

		// add a exitGameButton in the mainscene
		exitGameButton = new Button();
		exitGameButton.setLabel("Exit Game");
		exitGameButton.setLocation(330, 80);
		exitGameButton.setSize(200, 40);
		exitGameButton.addActionListener(msController);
		buttonView.add(exitGameButton);
		this.add(buttonView);
		// for the increasing the zindex of buttonView
		this.setComponentZOrder(buttonView, 0);
	}

}
