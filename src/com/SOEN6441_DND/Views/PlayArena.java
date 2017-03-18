package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import com.SOEN6441_DND.Controller.PlayArenaController;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.MapModel;
import com.sun.glass.events.KeyEvent;

public class PlayArena extends View  {
	public PlayArenaController playController;
	public MapModel mapModel;
	public CampaignModel campaignModel;

	public JButton playerPos;
	public GridView gridView;
public Timer repaintTimer;

private int xDelta = 0;
private int yDelta=0;
private int keyPressCount = 0;


int charLocX=0;
int charLocY=0;

	@Override
	protected void initSubviews() {
		super.initSubviews();
	}

	public PlayArena(MapModel mapModel, CampaignModel campaignModel) {
		this.mapModel = mapModel;
		this.campaignModel = campaignModel;
		playController = new PlayArenaController(this);
		gridView = new GridView(mapModel, this){
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				mapButtonsGrid[charLocY][charLocX].setIcon(new ImageIcon(
						new ImageIcon("image/Human.jpg").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
			}
		};
		this.add(gridView);
		placePlayerOnMap(gridView.mapButtonsGrid);
		
		
		//for key Binding
		InputMap inputMap=this.gridView.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap=this.gridView.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false), "pressed.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false), "pressed.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,true), "released.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,true), "released.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false), "pressed.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false), "pressed.Down");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,true), "released.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,true), "released.Down");

		
		actionMap.put("pressed.Left", new MoveAction(-1,0,true));
		actionMap.put("pressed.Right", new MoveAction(1,0,true));
		actionMap.put("released.Left", new MoveAction(0,0,false));
		actionMap.put("released.Right", new MoveAction(0,0,false));
		actionMap.put("pressed.Up", new MoveAction(0,-1,true));
		actionMap.put("pressed.Down", new MoveAction(0,1,true));
		actionMap.put("released.Up", new MoveAction(0,0,false));
		actionMap.put("released.Down", new MoveAction(0,0,false));
		repaintTimer=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nextX=0;
				int nextY=0;
				if(charLocX+xDelta>(mapModel.getMapWidth()-1))
				{
					nextX=mapModel.getMapWidth()-1;
					nextY=charLocY+yDelta;
				}
				else if(charLocX+xDelta>(mapModel.getMapHeight()-1)){
					nextY=mapModel.getMapHeight()-1;
					nextX=charLocX+xDelta;
				}
				if(gridView.mapButtonsGrid[nextY][nextX].getName().contains(","))
				{	gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					charLocX += xDelta;
					charLocY+=yDelta;	

				}
					
				  if (charLocX < 0) {
                	  charLocX = 0;
                  } 
                  else if(charLocY<0){
                	  charLocY=0;
                  }
                  else if(charLocX>(mapModel.getMapWidth()-1))
                  {
                	  charLocX=mapModel.getMapWidth()-1;
                  }
                  else if(charLocY>(mapModel.getMapHeight()-1)){
                	  charLocY=mapModel.getMapHeight()-1;
                  }
                
                  gridView.revalidate();
                  gridView.repaint();
              
			}
		});
		repaintTimer.setRepeats(true);
		repaintTimer.setCoalesce(true);
	}


	public void placePlayerOnMap(JButton mapButtonsGrid[][]){
		if(mapButtonsGrid[(int)(mapModel.getEntry().getWidth())+1][(int)mapModel.getEntry().getHeight()].getName().contains(",")){
			mapButtonsGrid[(int)(mapModel.getEntry().getWidth())+1][(int)mapModel.getEntry().getHeight()].setName("Player");
			mapButtonsGrid[(int)(mapModel.getEntry().getWidth())+1][(int)mapModel.getEntry().getHeight()].setIcon(new ImageIcon(
					new ImageIcon("image/Human.jpg").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
					charLocX=(int)(mapModel.getEntry().getWidth())+1;
					charLocY=(int)(mapModel.getEntry().getHeight());
		}
	}
	 class MoveAction extends javax.swing.AbstractAction {

		    private int x=0;
		    private int y=0;
		    private boolean keyDown;

		    public MoveAction(int x,int y, boolean down) {
		        this.x = x;
		        this.y=y;
		        keyDown = down;
		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (keyDown) {
		            if (!repaintTimer.isRunning()) {
		                repaintTimer.start();
				        xDelta = x;
				        yDelta=y;
		            }
		        } else {
		            repaintTimer.stop();
		        }
		    }
	 }
}


