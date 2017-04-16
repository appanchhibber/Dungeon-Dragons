package Strategy;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.MainScene;
import com.SOEN6441_DND.Views.PlayArena;
import com.sun.glass.events.KeyEvent;

public class HumanStrategy implements Strategy {
	public Timer repaintTimer;
	private int xDelta = 0;
	private int yDelta = 0;
	private int stepCount;

	public int charLocX = 0;
	public int charLocY = 0;
	public MapModel mapModel;
	public CharacterModel characterModel;
	static public boolean chestFlag=false;

	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {

		System.out.println("Execute Human Strategy");
		this.mapModel = mapModel;
		this.characterModel = charModel;
		this.charLocX = (int) characterModel.getCharLocation().getWidth();
		this.charLocY = (int) characterModel.getCharLocation().getHeight();
		stepCount = 0;
		if (charModel.isAttackFlag()) {
			System.out.println("Human calling Attack");
			attack();			
			charModel.setAttackFlag(false);
			charModel.setMoveCompleted(true);
		}
		else{
			keyBinding();
		}
		
	}
	
	public void attack() {
		CharacterModel enemy=characterModel.getEnemy();
		int diceresult=rollDice()+characterModel.getAttackBonus();
		System.out.println("Attack Roll"+diceresult);
		if(enemy.getArmorClass()<diceresult){
			System.out.println("Attack Started");
			enemy.setHitPoints(enemy.getHitPoints()-characterModel.getDamageBonus());
		}
	}
	public int rollDice(){
		return new Random().nextInt(20)+1;
	}

	@Override
	public String getStrategyName() {
		return "PlayerStrategy";
	}
	
	public String checkNext(Dimension nextLoc){ 
		if(mapModel.getWalls().contains(nextLoc)  || mapModel.getEntry().equals(nextLoc) )
		{
			return "Wall";
		}
		else if(mapModel.getCharacterLocations().containsValue((nextLoc))){
			return "Character";
		}
		else if(mapModel.getChest().equals(nextLoc)){
			return "Chest";
		}
		else if(mapModel.getExit().equals(nextLoc)){
			return "ExitDoor";
		}
		else{
			return "Move";
		}
		
	}

	public void keyBinding() {
		// for key Binding

		InputMap inputMap = PlayArena.inputMap;
		ActionMap actionMap = PlayArena.actionMap;
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "pressed.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "released.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "pressed.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "pressed.Down");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "released.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "released.Down");

		actionMap.put("pressed.Left", new MoveAction(-1, 0, true));
		actionMap.put("pressed.Right", new MoveAction(1, 0, true));
		actionMap.put("released.Left", new MoveAction(0, 0, false));
		actionMap.put("released.Right", new MoveAction(0, 0, false));
		actionMap.put("pressed.Up", new MoveAction(0, -1, true));
		actionMap.put("pressed.Down", new MoveAction(0, 1, true));
		actionMap.put("released.Up", new MoveAction(0, 0, false));
		actionMap.put("released.Down", new MoveAction(0, 0, false));

		repaintTimer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (stepCount == 3) {
					repaintTimer.stop();
					return;
				}
				int nextX = charLocX;
				int nextY = charLocY;
				if (charLocX + xDelta > (mapModel.getMapWidth() - 1)) {
					nextX = mapModel.getMapWidth() - 2;
					nextY = charLocY + yDelta;
				} else if (charLocY + yDelta > (mapModel.getMapHeight() - 1)) {
					nextY = mapModel.getMapHeight() - 2;
					nextX = charLocX + xDelta;

				} else if (charLocX + xDelta < 0) {
					nextX = 1;
					nextY = charLocY + yDelta;
				} else if (charLocY + yDelta < 0) {
					nextY = 1;
					nextX = charLocX + xDelta;
				}

				Dimension nextLoc = new Dimension(nextX + xDelta, nextY + yDelta);
				// Dimension validLoc=new Dimension(nextY+yDelta,nextX+xDelta);
				
				switch(checkNext(nextLoc)){
					case "Move":{
						charLocX += xDelta;
						charLocY += yDelta;
						stepCount++;
						characterModel.setCharLocation(nextLoc);
						break;
					}
					case "Chest":{
						charLocX += xDelta;
						charLocY += yDelta;
						stepCount++;
						chestFlag=true;
						characterModel.setCharLocation(nextLoc);
						System.out.println("Chest Found");
						break;
					}
					case "ExitDoor":{
						repaintTimer.stop();
						if(chestFlag==true){
							chestFlag=false;
							mapModel.setLoadNextMap(true);
						}
						else{
							mapModel.setLoadNextMap(false);
						}
						
					break;
					}
				}
			}				
		});

	}

	/**
	 * This inner class extends AbstractButton and is responsible for passing
	 * the key press value to the constructor for player to move on the map
	 * 
	 * @author Appan Chhibber
	 *
	 */

	class MoveAction extends javax.swing.AbstractAction {

		private int x = 0;
		private int y = 0;
		private boolean keyDown;

		public MoveAction(int x, int y, boolean down) {
			this.x = x;
			this.y = y;
			keyDown = down;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (keyDown) {
				if (!repaintTimer.isRunning()) {
					repaintTimer.start();
					xDelta = x;
					yDelta = y;
				}
			} else {
				repaintTimer.stop();
			}
		}
	}
}
