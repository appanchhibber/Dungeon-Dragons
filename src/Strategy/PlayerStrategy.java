package Strategy;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class PlayerStrategy implements Strategy {
	public Timer repaintTimer ;
	private int xDelta = 0;
	private int yDelta = 0;
	private int stepCount;

	public int charLocX = 0;
	public int charLocY = 0;
	public MapModel mapModel;
	public CharacterModel characterModel;
	@Override
	public void execute(MapModel mapModel,CharacterModel charModel) {
	
			this.mapModel=mapModel;
			this.characterModel=charModel;
			this.charLocX=(int)characterModel.getCharLocation().getWidth();
			this.charLocY=(int)characterModel.getCharLocation().getHeight();
			stepCount=0;
			keyBinding();
	}
	
	@Override
	public String getStrategyName() {
		return "PlayerStrategy";
	}
	public void keyBinding(){
		// for key Binding
		 
		InputMap inputMap = PlayArena.inputMap;
		ActionMap actionMap = PlayArena.actionMap;
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"pressed.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"pressed.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true),
				"released.Left");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true),
				"released.Right");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false),
				"pressed.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false),
				"pressed.Down");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true),
				"released.Up");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true),
				"released.Down");

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
				 if(stepCount==3){
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
				
				Dimension nextLoc=new Dimension(nextX+xDelta, nextY+yDelta);
				Dimension validLoc=new Dimension(nextY+yDelta,nextX+xDelta);
				if(!(mapModel.getWalls().contains(validLoc)||mapModel.getChest()==validLoc||mapModel.getCharacterLocations().containsValue(validLoc))){
					charLocX += xDelta;
					charLocY += yDelta;
					characterModel.setCharLocation(nextLoc);
					stepCount++;
					//mapModel.updateCharLocation(characterModel.getName()+"-Player", nextLoc);
				}
				
				
				
				
				
				/*if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta]
						.getName().contains(",")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX]
									.getText());
					stepCount++;
					charLocX += xDelta;
					charLocY += yDelta;

				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX
						+ xDelta].getName().contains("EntryDoor")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX]
									.getText());
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX
						+ xDelta].getName().contains("Wall")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX]
									.getText());
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX
						+ xDelta].getName().contains("Chest")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(charLocY + "," + charLocX);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setText(charLocY + "," + charLocX);
					charLocX += xDelta;
					charLocY += yDelta;
					chestFlag = true;
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX
						+ xDelta].getName().contains("ExitDoor")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					repaintTimer.stop();
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX]
									.getText());
					if (chestFlag) {
						campaignModel.getCampMapList().removeElement(
								mapModel.mapName);
						if (campaignModel.getCampMapList().size() == 0) {
							gameController.mainFrame.setView(new MainScene());
						} else {
							loadNextMap(campaignModel.getCampMapList().get(0)
									.toString());
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Collect Chest First");
					}
				}

				else {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX]
									.getText());
				}
*/
			
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
