package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.SOEN6441_DND.Views.CharacterScene;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.NavigationPanelView;

/**
 * This Class is to manage Navigational events.
 * 
 * @author Punit Trivedi
 */

public class NavigationPanelController implements ActionListener {

	NavigationPanelView navigationView;
	private GameController gameController;

	public NavigationPanelController(NavigationPanelView view) {
		navigationView=view;
		gameController=GameController.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == navigationView.homeButton) {
			gameController.mainFrame.setView(new MainScene());
		}

	}

}
