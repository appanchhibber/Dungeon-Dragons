package com.SOEN6441_DND.Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Controller.CharacterSceneController;
import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Model.AbilitiyModel;
import com.SOEN6441_DND.Model.CharacterModel;
/**
 * <b>This Class is View for Character Creation and Editior.</b>
 * @author Punit Trivedi
 *
 */
public class CharacterScene extends View implements Observer {

	public CharacterSceneController characterController;
	// Panels
    View imagePanel;
	NavigationPanelView navMenuPanel;
	public AbilityPanelView abilityPanel;
	
	// Labels
	JLabel nameLabel;
	JLabel imageLabel;
	// TextField
	public JTextField nameText;
	// Image
	ImageIcon characterImage;
	// Radio buttons.
	public JRadioButton characterTypeRadio;
	ButtonGroup charactertypeGroup;
	//Character View Model
	public CharacterModel characterViewModel;
	public AbilitiyModel abilityViewModel;
	
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		//Model Initialization
		characterViewModel= new CharacterModel();
		abilityViewModel=new AbilitiyModel();
		
		//Panel Initialization
		abilityPanel = new AbilityPanelView(abilityViewModel);
		navMenuPanel = new NavigationPanelView();
		characterController = new CharacterSceneController(this);
		
		//Character Selection
		charactertypeGroup = new ButtonGroup();
		characterTypeRadio = new JRadioButton("Human", true);
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(160, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Dwarf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(280, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Elf");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(400, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);

		characterTypeRadio = new JRadioButton("Orc");
		characterTypeRadio.setSize(100, 20);
		characterTypeRadio.setLocation(520, 40);
		characterTypeRadio.addActionListener(characterController);
		charactertypeGroup.add(characterTypeRadio);
		this.add(characterTypeRadio);
		//End Character Selection
		//Configure Model attach with Observer.
		
		characterViewModel.setImage("Human");
		characterViewModel.addObserver(this);
		characterImage = new ImageIcon(characterViewModel.getImage());
		
		//Image Panel
		imagePanel = new View();
		imagePanel.setSize(300, 500);
		imagePanel.setLocation(20, 70);
		
		imageLabel = new JLabel(
				new ImageIcon(((characterImage.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		imageLabel.setSize(imagePanel.getWidth(), imagePanel.getHeight());
		imageLabel.setLocation(0, 0);
		imagePanel.add(imageLabel);
		//End Image Panel.
		
		//Add Action Listener
		abilityPanel.calculateButton.addActionListener(characterController);
		
		this.setVisible(true);
		this.add(navMenuPanel);
		this.add(imagePanel);
		this.add(abilityPanel);
		

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setImagePanel();
	}
	
	
	public void setImagePanel()
	{
		characterImage.getImage().flush();
		characterImage= new ImageIcon(new ImageIcon(characterViewModel.getImage()).getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(),java.awt.Image.SCALE_SMOOTH ));
		//abilityModel;
		imageLabel.setIcon(characterImage);
		imageLabel.revalidate();
		imageLabel.repaint();
	}

}
