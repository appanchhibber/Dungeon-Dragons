package com.SOEN6441_DND.Views;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;

public class CharacterInventoryView extends JFrame {
private Container container;
	public CharacterInventoryView(){		
		container=getContentPane();
		ItemAssignView view=new ItemAssignView();
		view.itemPanel.setVisible(false);
		view.navPanel.setVisible(false);
		view.setVisible(true);
		view.backpackPanel.setLocation(0, 0);
		container.add(view);

		setPreferredSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(500, 500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.pack();
	}
}
