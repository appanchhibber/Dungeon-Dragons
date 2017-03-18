package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;








import javax.swing.Timer;

import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class PlayArenaController implements KeyListener{
	
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public CharacterModel characterModel;
	public PlayArena playArena;

	//Timer timer=new Timer(5,this);

	public int x=0;
	public int y=0;
	public int velX=0;
	public int velY=0;
	public PlayArenaController(PlayArena playArena){
		this.playArena=playArena;
	//	timer.start();
	}
/*	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Action performed");
		x=x+velX;
		y=x+velY;
		playArena.repaint(x,y,50,50);
	}*/
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed");
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			velX=-1;
			velY=0;
			System.out.println("left");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			velX=1;
			velY=0;
			System.out.println("right");
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			velX=0;
			velY=-1;
			System.out.println("up");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			velX=0;
			velY=1;
			System.out.println("down");
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
