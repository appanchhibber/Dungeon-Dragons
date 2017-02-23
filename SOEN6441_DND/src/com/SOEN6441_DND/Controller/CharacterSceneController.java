package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Views.CharacterScene;

public class CharacterSceneController implements ActionListener {
	public CharacterModel characterModel;
	public CharacterScene characterScreen;
	
	public CharacterSceneController(CharacterScene view)
	{
		this.characterModel = new CharacterModel();
		this.characterScreen = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JRadioButton)
		{
				switch (((JRadioButton)e.getSource()).getText())
				{
					case "Human":
					{
						characterModel.setImage("Human");
						break;
					}
					case "Dwarf":
					{
						characterModel.setImage("Dwarf");
						break;
					}
					case "Elf":
					{
						characterModel.setImage("Elf");
						break;
					}
					case "Orc":
					{
						characterModel.setImage("Orc");
						break;
					}
					
				}
				characterScreen.revalidate();
				characterScreen.repaint();
	}
 }	

}
