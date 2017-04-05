package com.SOEN6441_DND.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.text.IconView;

import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Controller.TransferHandlerController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;

/**
 * This class is responsible for creating the grid map that is being rendered in
 * mapView
 * 
 * @author Appan Chhibber
 * @author Punit Trivedi
 * 
 *
 */
public class GridView extends JPanel implements Observer {
	private int mapWidth;
	private int mapHeight;
	public JButton mapButtonsGrid[][];
	public int mapGridSelection[][];
	public MapView mapView;
	public MapModel mapModel;
	public TransferHandlerController transferHandler;
	private int count = 0;
	public PlayArena playArena;
	private int stepCounter;
	CharacterModel	characterModel;

	/**
	 * Constructor for passing the model from the controller to MapView and the
	 * mode of working as well ie create and edit
	 * 
	 * @param mapModel
	 * @param mapView
	 * @param mode
	 * @author Appan Chhibber
	 * @author Punit Trivedi
	 */
	public GridView(MapModel mapModel, MapView mapView, String mode) {
		this.mapModel = mapModel;
		this.mapHeight = mapModel.getMapHeight();
		this.mapWidth = mapModel.getMapWidth();
		this.mapView = mapView;
		
		this.mapView.mapModel.setMapHeight(mapHeight);
		this.mapView.mapModel.setMapWidth(mapWidth);
		this.setLayout(new GridLayout(mapHeight, mapWidth, 3, 3));

		this.setBackground(Color.BLACK);
		this.setLocation(10, 10);
		this.setVisible(true);
		this.setSize(620, 530);
		if (mode == "create") {
			createGridView();
		} else {
			editGridView();
		}

	}

	/**
	 * Constructor for creating the gridMap for the play Arean view
	 * 
	 * @param mapModel
	 * @param playArena
	 * @author Appan Chhibber
	 */
	public GridView(MapModel mapModel, PlayArena playArena) {
		this.mapModel = mapModel;
		this.mapHeight = mapModel.getMapHeight();
		this.mapWidth = mapModel.getMapWidth();
		this.playArena = playArena;
		this.playArena.mapModel.setMapHeight(mapHeight);
		this.playArena.mapModel.setMapWidth(mapWidth);
		this.stepCounter=0;
		this.setLayout(new GridLayout(mapHeight, mapWidth, 3, 3));

		this.setBackground(Color.BLACK);
		this.setLocation(10, 10);
		this.setVisible(true);
		this.setSize(620, 530);
		playGridView();
	}

	/**
	 * Method to create gridmap for playarena screen
	 * 
	 * @author Appan Chhibber
	 */
	public void playGridView() {
		mapButtonsGrid = new JButton[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				mapButtonsGrid[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				// multiple = mapModel.getMapWidth();
				multiple = mapWidth;

				if (i == 0 && j == 0) {
					value = 0;
				} else {
					value = 1 + j + (i * multiple);
				}
				if ((int) mapModel.getEntry().getWidth() == i
						&& (int) mapModel.getEntry().getHeight() == j) {
					mapButtonsGrid[i][j].setName("EntryDoor");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/EntryDoor.jpg").getImage()
							.getScaledInstance(50, 50,
									java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else if ((int) mapModel.getChest().getWidth() == i
						&& (int) mapModel.getChest().getHeight() == j) {
					mapButtonsGrid[i][j].setName("Chest");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/Chest.jpg").getImage().getScaledInstance(50,
							50, java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else if ((int) mapModel.getExit().getWidth() == i
						&& (int) mapModel.getExit().getHeight() == j) {
					mapButtonsGrid[i][j].setName("ExitDoor");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/ExitDoor.jpg").getImage().getScaledInstance(
							50, 50, java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else {
					mapButtonsGrid[i][j].setName(i + "," + j);
				}
				mapButtonsGrid[i][j].setBackground(Color.WHITE);
				mapButtonsGrid[i][j].setOpaque(true);
				mapButtonsGrid[i][j].setBorderPainted(false);
				mapButtonsGrid[i][j].setSize(40, 40);
				mapButtonsGrid[i][j].setFocusable(false);
				this.add(mapButtonsGrid[i][j]);
			}
		}
		mapButtonsGrid[playArena.charLocY][playArena.charLocX].setIcon(new ImageIcon(
				new ImageIcon(playArena.charModel.getImage()).getImage()
						.getScaledInstance(50, 50,
								java.awt.Image.SCALE_SMOOTH)));

		mapButtonsGrid[playArena.charLocY][playArena.charLocX]
				.setText(mapButtonsGrid[playArena.charLocY][playArena.charLocX].getName());
		mapButtonsGrid[playArena.charLocY][playArena.charLocX].setFont(new Font("Calibri",
				Font.PLAIN, 0));
		mapButtonsGrid[playArena.charLocY][playArena.charLocX].setName(playArena.charModel.getName()+"-Player");

		mapButtonsGrid[playArena.charLocY][playArena.charLocX]
				.addActionListener(playArena.playController);

		for (Dimension dimension : mapModel.getWalls()) {
			// System.out.println((int)dimension.getWidth());
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setName("Wall");
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setFont(new Font("Calibri", Font.PLAIN, 0));
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setIcon(new ImageIcon(new ImageIcon(
					"image/Wall.jpg").getImage().getScaledInstance(50, 50,
					java.awt.Image.SCALE_SMOOTH)));
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setText((int) dimension.getWidth() + ","
					+ (int) dimension.getHeight());
		}
		for (Map.Entry<String, MapModel> character : mapModel.getCharacters()
				.entrySet()) {
			int characterX = (int) character.getValue().getCharacterLocation()
					.getWidth();
			int characterY = (int) character.getValue().getCharacterLocation()
					.getHeight();
			mapButtonsGrid[characterX][characterY].setName("_"
					+ character.getKey());
			mapButtonsGrid[characterX][characterY].setFont(new Font("Calibri",
					Font.PLAIN, 0));
			mapButtonsGrid[characterX][characterY].setText(characterX + ","
					+ characterY);
			mapButtonsGrid[characterX][characterY].setToolTipText(character
					.getValue().getCharacterBehavior());
			mapButtonsGrid[characterX][characterY].setIcon(new ImageIcon(
					new ImageIcon(character.getValue().getCharacterImage())
							.getImage().getScaledInstance(50, 50,
									java.awt.Image.SCALE_SMOOTH)));
	CharacterModel model=new FileOperationModel().loadCharacter(character.getKey());
	model.setCharLocation(character.getValue().getCharacterLocation());
			playArena.playModel.addCharacter(character.getKey() + "-" + character.getValue().getCharacterBehavior(),
					model);
			mapModel.addCharLocation(character.getKey() + "-" + character.getValue().getCharacterBehavior(),character.getValue().getCharacterLocation());
			mapButtonsGrid[characterX][characterY].addActionListener(playArena.playController);
		}

	}

	/**
	 * Method to create gridMap view in edit Mode
	 * 
	 * @author Appan Chhibber
	 */
	public void editGridView() {
		mapButtonsGrid = new JButton[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				mapButtonsGrid[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				// multiple = mapModel.getMapWidth();
				multiple = mapWidth;

				if (i == 0 && j == 0) {
					value = 0;
				} else {
					value = 1 + j + (i * multiple);
				}
				if ((int) mapModel.getEntry().getWidth() == i
						&& (int) mapModel.getEntry().getHeight() == j) {
					mapButtonsGrid[i][j].setName("EntryDoor");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/EntryDoor.jpg").getImage()
							.getScaledInstance(50, 50,
									java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else if ((int) mapModel.getChest().getWidth() == i
						&& (int) mapModel.getChest().getHeight() == j) {
					mapButtonsGrid[i][j].setName("Chest");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/Chest.jpg").getImage().getScaledInstance(50,
							50, java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else if ((int) mapModel.getExit().getWidth() == i
						&& (int) mapModel.getExit().getHeight() == j) {
					mapButtonsGrid[i][j].setName("ExitDoor");
					mapButtonsGrid[i][j].setFont(new Font("Calibri",
							Font.PLAIN, 0));
					mapButtonsGrid[i][j].setIcon(new ImageIcon(new ImageIcon(
							"image/ExitDoor.jpg").getImage().getScaledInstance(
							50, 50, java.awt.Image.SCALE_SMOOTH)));
					mapButtonsGrid[i][j].setText(i + "," + j);
				} else {
					mapButtonsGrid[i][j].setName(i + "," + j);
				}
				mapButtonsGrid[i][j].setBackground(Color.WHITE);
				mapButtonsGrid[i][j].setOpaque(true);
				mapButtonsGrid[i][j].setBorderPainted(false);
				mapButtonsGrid[i][j].setSize(40, 40);
				mapButtonsGrid[i][j]
						.setTransferHandler(new TransferHandlerController()
								.valueImportCreator());
				mapButtonsGrid[i][j].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						// System.out.println(e.getButton());
						if (e.getButton() == MouseEvent.BUTTON3) {
							JButton button = (JButton) e.getSource();
							if (!button.getName().contains(",")) {
								button.setSelected(true);
								// System.out.println(button.getName());
								button.setIcon(null);
								button.setName(button.getText());

							}
						} else if (e.getButton() == MouseEvent.BUTTON1) {
							JButton button = (JButton) e.getSource();
							if (button.getName().contains("_")) {
								count++;
								if (count % 2 == 0) {
									mapView.inventView.selectBehavior
											.setText("Hostile");
									button.setToolTipText("Hostile");
								} else {
									mapView.inventView.selectBehavior
											.setText("Friendly");
									button.setToolTipText("Friendly");
								}
							}
						}

					}
				});

				this.add(mapButtonsGrid[i][j]);
			}
		}
		for (Dimension dimension : mapModel.getWalls()) {
			// System.out.println((int)dimension.getWidth());
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setName("Wall");
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setFont(new Font("Calibri", Font.PLAIN, 0));
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setIcon(new ImageIcon(new ImageIcon(
					"image/Wall.jpg").getImage().getScaledInstance(50, 50,
					java.awt.Image.SCALE_SMOOTH)));
			mapButtonsGrid[(int) dimension.getWidth()][(int) dimension
					.getHeight()].setText((int) dimension.getWidth() + ","
					+ (int) dimension.getHeight());
		}
		for (Map.Entry<String, MapModel> character : mapModel.getCharacters()
				.entrySet()) {
			int characterX = (int) character.getValue().getCharacterLocation()
					.getWidth();
			int characterY = (int) character.getValue().getCharacterLocation()
					.getHeight();
			mapButtonsGrid[characterX][characterY].setName("_"
					+ character.getKey());
			mapButtonsGrid[characterX][characterY].setFont(new Font("Calibri",
					Font.PLAIN, 0));
			mapButtonsGrid[characterX][characterY].setText(characterX + ","
					+ characterY);
			mapButtonsGrid[characterX][characterY].setToolTipText(character
					.getValue().getCharacterBehavior());
			mapButtonsGrid[characterX][characterY].setIcon(new ImageIcon(
					new ImageIcon(character.getValue().getCharacterImage())
							.getImage().getScaledInstance(50, 50,
									java.awt.Image.SCALE_SMOOTH)));
		}
	}

	/**
	 * Method for creation of gridmap in create mode
	 * 
	 * @author Appan Chhibber
	 */
	public void createGridView() {

		mapButtonsGrid = new JButton[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				mapButtonsGrid[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				// multiple = mapModel.getMapWidth();
				multiple = mapWidth;

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);
				mapButtonsGrid[i][j].setName(i + "," + j);
				mapButtonsGrid[i][j].setBackground(Color.WHITE);
				mapButtonsGrid[i][j].setOpaque(true);
				mapButtonsGrid[i][j].setBorderPainted(false);
				mapButtonsGrid[i][j].setSize(40, 40);
				mapButtonsGrid[i][j]
						.setTransferHandler(new TransferHandlerController()
								.valueImportCreator());
				mapButtonsGrid[i][j].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						// System.out.println(e.getButton());
						if (e.getButton() == MouseEvent.BUTTON3) {
							JButton button = (JButton) e.getSource();
							if (!button.getName().contains(",")) {
								button.setSelected(true);
								// System.out.println(button.getName());
								button.setIcon(null);
								button.setName(button.getText());

							}
						} else if (e.getButton() == MouseEvent.BUTTON1) {
							JButton button = (JButton) e.getSource();
							if (button.getName().contains("_")) {
								count++;
								if (count % 2 == 0) {
									mapView.inventView.selectBehavior
											.setText("Hostile");
									button.setToolTipText("Hostile");
								} else {
									mapView.inventView.selectBehavior
											.setText("Friendly");
									button.setToolTipText("Friendly");
								}
							}
						}

					}
				});
				this.add(mapButtonsGrid[i][j]);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
			characterModel=(CharacterModel)o;
			if(characterModel.message=="LocationUpdate")
			{
				moveCharacter();
				this.stepCounter++;
				if(this.stepCounter>=3)
				{

					this.stepCounter=0;
					playArena.playController.turn();
					
				}
				characterModel.message="";
			}	

		
	}
	public void moveCharacter()
	{
		int oldX=(int)mapModel.getCharacterLocations().get(characterModel.getName()+"-"+characterModel.getBehaviour()).getWidth();
		int oldY=(int)mapModel.getCharacterLocations().get(characterModel.getName()+"-"+characterModel.getBehaviour()).getHeight();
		mapButtonsGrid[oldY][oldX].setIcon(null);
		mapButtonsGrid[oldY][oldX]
				.setName(mapButtonsGrid[oldY][oldX]
						.getText());
		int charLocY=(int)characterModel.getCharLocation().getHeight();
		int charLocX=(int)characterModel.getCharLocation().getWidth();
		mapModel.updateCharLocation(characterModel.getName()+"-"+characterModel.getBehaviour(), new Dimension(charLocX, charLocY));
			mapButtonsGrid[charLocY][charLocX].setIcon(new ImageIcon(
					new ImageIcon(characterModel.getImage()).getImage()
							.getScaledInstance(50, 50,
									java.awt.Image.SCALE_SMOOTH)));

			mapButtonsGrid[charLocY][charLocX]
					.setText(mapButtonsGrid[charLocY][charLocX].getName());
			mapButtonsGrid[charLocY][charLocX].setFont(new Font("Calibri",
					Font.PLAIN, 0));
			if(characterModel.getBehaviour()=="Player"){
			mapButtonsGrid[charLocY][charLocX].setName(characterModel.getName()+"-Player");
			}
			mapButtonsGrid[charLocY][charLocX]
					.addActionListener(playArena.playController);

			revalidate();
	}

}
