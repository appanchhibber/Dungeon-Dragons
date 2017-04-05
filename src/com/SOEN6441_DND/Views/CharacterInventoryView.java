package com.SOEN6441_DND.Views;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.SOEN6441_DND.ConfigFiles.ApplicationStatics;
import com.SOEN6441_DND.Model.CharacterModel;

public class CharacterInventoryView extends JFrame{
private Container container;
public ItemAssignView view;

	public CharacterInventoryView(){
		container=getContentPane();
		view=new ItemAssignView();
		view.itemPanel.setVisible(false);
		view.navPanel.setVisible(false);
		container.add(view);
	}
	
	public void setcharModel(CharacterModel player){
		
		player.message="itemImage";
		player.addObserver(view);
		view.setCharacterModel(player);
		view.update(player, "");
	}
	public void setInventory()
	{
		
		view.setVisible(true);
		view.backpackPanel.setLocation(0, 0);
		setPreferredSize(new Dimension(500, 500));
		setMaximumSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(500, 500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
		this.pack();
	}
}
