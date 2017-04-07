package com.SOEN6441_DND.Views;

import java.awt.Button;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.StartGameController;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.StartGameModel;

/**
 * This view allows the user to select a character and campaign created by him
 * to start playing the game
 * 
 * @author Appan Chhibber
 *
 */
public class StartGameView extends View {

	public JLabel characterLabel;
	public JLabel campaignLabel;

	public JComboBox selectCharacter;
	public JComboBox selectCampaign;

	public JButton backBtn;
	public JButton startBtn;
	
	public JCheckBox computerBehavior;

	public StartGameController startGameController;
	public StartGameModel startModel;
	public FileOperationModel ioModel;

	@Override
	protected void initSubviews() {
		super.initSubviews();
		startModel = new StartGameModel();
		ioModel = new FileOperationModel();
		startGameController = new StartGameController(this);

		ImageIcon image = new ImageIcon("image/gameBk.jpg");
		JLabel label = new JLabel(new ImageIcon(
				((image.getImage().getScaledInstance(
						ApplicationStatics.WINDOW_WIDTH,
						(ApplicationStatics.WINDOW_HEIGHT),
						java.awt.Image.SCALE_SMOOTH)))));
		label.setLocation(0, 0);
		label.setSize(860, 630);
		this.add(label);

		View buttonView = new View();
		buttonView.setLocation(0, 400);
		buttonView.setSize(860, 300);
		buttonView.setOpaque(false);
		// add a statGameButton in the mainscene
		characterLabel = new JLabel("Select Character:");
		characterLabel.setLocation(210, 10);
		characterLabel.setSize(120, 20);
		selectCharacter = new JComboBox(ioModel.getAllFolderFile("characters")
				.toArray());
		selectCharacter.setSize(200, 30);
		selectCharacter.setLocation(350, 10);
		buttonView.add(selectCharacter);
		buttonView.add(characterLabel);

		computerBehavior=new JCheckBox("Act as Computer Player");
		computerBehavior.setSize(200, 30);
		computerBehavior.setLocation(350, 45);
		computerBehavior.setOpaque(false);
		buttonView.add(computerBehavior);
		// add a exitGameButton in the mainscene
		campaignLabel = new JLabel("Select Campaign:");
		campaignLabel.setLocation(210, 85);
		campaignLabel.setSize(120, 20);
		selectCampaign = new JComboBox(ioModel.getAllFolderFile("campaign")
				.toArray());
		selectCampaign.setSize(200, 30);
		selectCampaign.setLocation(350, 85);
		buttonView.add(campaignLabel);
		buttonView.add(selectCampaign);

		backBtn = new JButton("Back");
		backBtn.setSize(200, 40);
		backBtn.setLocation(130, 135);
		backBtn.addActionListener(startGameController);
		buttonView.add(backBtn);

		startBtn = new JButton("Start");
		startBtn.setSize(200, 40);
		startBtn.setLocation(430, 135);
		startBtn.addActionListener(startGameController);
		buttonView.add(startBtn);
		this.add(buttonView);

		this.add(buttonView);

		this.setComponentZOrder(buttonView, 0);
	}

}
