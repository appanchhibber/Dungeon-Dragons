package com.SOEN6441_DND.Views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import org.dom4j.DocumentException;

import com.SOEN6441_DND.Controller.GameController;
import com.SOEN6441_DND.Controller.PlayArenaController;
import com.SOEN6441_DND.Model.AbilityModel;
import com.SOEN6441_DND.Model.CampaignModel;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.sun.glass.events.KeyEvent;

public class PlayArena extends View implements Observer {
	public PlayArenaController playController;
	public MapModel mapModel;
	public CampaignModel campaignModel;
	public FileOperationModel ioModel;
	public CharacterModel charModel;
	public GameController gameController;
	public JButton playerPos;
	public GridView gridView;
	public Timer repaintTimer;
	public boolean chestFlag;
	private int xDelta = 0;
	private int yDelta = 0;
	private int keyPressCount = 0;

	public int charLocX = 0;
	public int charLocY = 0;

	public PlayerInfoPanelView playInfoPanel;
	public CharacterInventoryView charInventory;

	@Override
	protected void initSubviews() {
		super.initSubviews();
		playInfoPanel = new PlayerInfoPanelView();
		this.add(playInfoPanel);

	}

	public PlayArena(MapModel mapModel, CampaignModel campaignModel, CharacterModel charModel) {
		this.mapModel = mapModel;
		this.campaignModel = campaignModel;
		ioModel = new FileOperationModel();
		gameController = GameController.getInstance();
		this.charModel = charModel;
		try {
			playInfoPanel.player= new CharacterModel();
			playInfoPanel.player.addObserver(playInfoPanel);
			charInventory=new CharacterInventoryView(playInfoPanel.player);
			ioModel.setCharacterModel(playInfoPanel.player);
			ioModel.loadCharacter(charModel.getName());	
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		playController = new PlayArenaController(this);
		playInfoPanel.inventoryBtn.addActionListener(playController);
		gridView = new GridView(mapModel, this) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				mapButtonsGrid[charLocY][charLocX].setIcon(new ImageIcon(new ImageIcon(charModel.getImage()).getImage()
						.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));

				mapButtonsGrid[charLocY][charLocX].setText(mapButtonsGrid[charLocY][charLocX].getName());
				mapButtonsGrid[charLocY][charLocX].setFont(new Font("Calibri", Font.PLAIN, 0));
				mapButtonsGrid[charLocY][charLocX].setName(charModel.getName());

				mapButtonsGrid[charLocY][charLocX].addActionListener(playController);

				revalidate();
			}
		};
		this.add(gridView);
		charLocX = (int) (mapModel.getEntry().getWidth()) + 1;
		charLocY = (int) (mapModel.getEntry().getHeight());
		chestFlag = false;

		// for key Binding
		InputMap inputMap = this.gridView.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = this.gridView.getActionMap();
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
		charModel.addObserver(this);
		repaintTimer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
				if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta].getName().contains(",")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX].getText());
					charLocX += xDelta;
					charLocY += yDelta;

				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta].getName().contains("EntryDoor")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX].getText());
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta].getName().contains("Wall")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX].getText());
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta].getName().contains("Chest")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX].setName(charLocY + "," + charLocX);
					gridView.mapButtonsGrid[charLocY][charLocX].setText(charLocY + "," + charLocX);
					charLocX += xDelta;
					charLocY += yDelta;
					chestFlag = true;
				} else if (gridView.mapButtonsGrid[nextY + yDelta][nextX + xDelta].getName().contains("ExitDoor")) {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					repaintTimer.stop();
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX].getText());
					if (chestFlag) {
						campaignModel.getCampMapList().removeElement(mapModel.mapName);
						if (campaignModel.getCampMapList().size() == 0) {
							gameController.mainFrame.setView(new MainScene());
						} else {
							loadNextMap(campaignModel.getCampMapList().get(0).toString());
						}
					} else {
						JOptionPane.showMessageDialog(null, "Collect Chest First");
					}
				}

				else {
					gridView.mapButtonsGrid[charLocY][charLocX].setIcon(null);
					gridView.mapButtonsGrid[charLocY][charLocX]
							.setName(gridView.mapButtonsGrid[charLocY][charLocX].getText());
				}

				gridView.revalidate();
				gridView.repaint();

			}
		});

	}

	@Override
	public void update(Observable o, Object arg) {
		this.charModel = (CharacterModel) o;
		System.out.println("inside update method");
		if (charModel.message == "character data") {
			System.out.println("inside character data method");
			System.out.println(charModel.getAbilityScore().getWisdom());
			System.out.println(charModel.getAbilityScore().getCharisma());
			System.out.println(charModel.getFighterType());
			System.out.println(charModel.getName());
		}

	}

	public void loadNextMap(String mapName) {
		mapModel = ioModel.readMapFile(new File("maps/" + mapName));
		gameController.mainFrame.setView(new PlayArena(mapModel, campaignModel, charModel));
	}

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
