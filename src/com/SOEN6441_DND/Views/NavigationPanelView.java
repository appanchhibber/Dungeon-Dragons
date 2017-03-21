package com.SOEN6441_DND.Views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.SOEN6441_DND.Controller.NavigationPanelController;

/**
 * This is the navigation view present at the bottom of the game.
 * @author Punit Trivedi
 *
 */
public class NavigationPanelView extends View{
 //Navigation Buttons
	public JButton homeButton;
	public JButton newButton;
	public JButton saveButton;
	public JButton loadButton;
	public JButton nextButton;
  //Navigation Controller
	public NavigationPanelController navigationController;
	@Override
	protected void initSubviews() {
		// TODO Auto-generated method stub
		super.initSubviews();
		navigationController= new NavigationPanelController(this);
		// Navigation Panel
				homeButton = new JButton();
				homeButton.setLocation(100, 10);
				homeButton.setSize(50, 50);
				homeButton.setOpaque(false);
				homeButton.setIcon(new ImageIcon(new ImageIcon("image/Home.jpg").getImage().getScaledInstance(homeButton.getWidth(), homeButton.getHeight(),java.awt.Image.SCALE_SMOOTH )));
				homeButton.setContentAreaFilled(false);
				homeButton.setBorderPainted(false);
				homeButton.addActionListener(navigationController);
				
				newButton = new JButton();
				newButton.setLocation(250, 10);
				newButton.setOpaque(false);
				newButton.setContentAreaFilled(false);
				newButton.setBorderPainted(false);
				newButton.setSize(50, 50);
				newButton.setIcon(new ImageIcon(new ImageIcon("image/New.jpg").getImage().getScaledInstance(newButton.getWidth(), newButton.getHeight(),java.awt.Image.SCALE_SMOOTH )));
				
				saveButton = new JButton();
				saveButton.setLocation(400, 10);
				saveButton.setSize(50, 50);
				saveButton.setOpaque(false);
				saveButton.setContentAreaFilled(false);
				saveButton.setBorderPainted(false);
				saveButton.setIcon(new ImageIcon(new ImageIcon("image/Save.jpg").getImage().getScaledInstance(saveButton.getWidth(), saveButton.getHeight(),java.awt.Image.SCALE_SMOOTH )));
				
				loadButton = new JButton();
				loadButton.setLocation(550, 10);
				loadButton.setSize(50, 50);
				loadButton.setOpaque(false);
				loadButton.setContentAreaFilled(false);
				loadButton.setBorderPainted(false);
				loadButton.setIcon(new ImageIcon(new ImageIcon("image/Load.jpg").getImage().getScaledInstance(loadButton.getWidth(), loadButton.getHeight(),java.awt.Image.SCALE_SMOOTH )));
				

				nextButton = new JButton();
				nextButton.setLocation(750, 10);
				nextButton.setSize(50, 50);
				nextButton.setOpaque(false);
				nextButton.setContentAreaFilled(false);
				nextButton.setBorderPainted(false);
				nextButton.setIcon(new ImageIcon(new ImageIcon("image/Next.jpg").getImage().getScaledInstance(nextButton.getWidth(), nextButton.getHeight(),java.awt.Image.SCALE_SMOOTH )));
				
				
				setBackground(Color.BLACK);
				setSize(860, 75);
				setLocation(0,550);
				setVisible(true);

				add(homeButton);
				add(newButton);
				add(saveButton);
				add(loadButton);
				add(nextButton);
				//End Navigation
	}
	
	
	
}
