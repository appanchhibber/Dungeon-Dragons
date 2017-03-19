package com.SOEN6441_DND.Controller;

import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.MapView;

/**
 * 
 * This class is the controller handling the events from the map creater view.
 * @author Appan Chhibber
 *
 */
public class MapViewController implements ActionListener,MouseMotionListener {

	
@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	JLabel newlabel = (JLabel) e.getSource();
	TransferHandler handler = newlabel.getTransferHandler();
	handler.exportAsDrag(newlabel, e, TransferHandler.COPY);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
public MapView getMapView() {
		return mapView;
	}
	public void setMapView(MapView mapView) {
		this.mapView = mapView;
	}
public MapView mapView;
public MapModel mapModel;
public FileOperationModel ioModel;
private GameController gameController;
	public MapViewController(MapView view)
	{
		gameController=GameController.getInstance();
		this.mapView=view;
		this.mapModel=view.mapModel;
		ioModel=new FileOperationModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mapView.inventView.validateButton){
			MapValidatorController validate=new MapValidatorController();
			String result=validate.validator(mapView);
			if(result!="Map Validated")
			{
				JOptionPane.showMessageDialog(null,result);
			}
			else{
				JOptionPane.showMessageDialog(null,result);
				mapView.navPanel.saveButton.setEnabled(true);
			}
		}

		else if(e.getSource()==mapView.navPanel.saveButton){
			File file;
			JFileChooser fileChooser = new JFileChooser(new File("maps/"));
			fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
					"xml");
			fileChooser.setFileFilter(filter);
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".xml"))
				{
					 file = new File(fileChooser.getSelectedFile().toString()+".xml");	
				}else{
					 file = new File(fileChooser.getSelectedFile().toString());
				}
				
				String saveResult=ioModel.writeMapData(file,mapModel);
				JOptionPane.showMessageDialog(null, saveResult);
			}
		
		}
		else if (e.getSource() == mapView.navPanel.loadButton) {
			File file = openMapFile();
			if(file==null)
			{
				return;
			}else{
			mapModel=ioModel.readMapFile(file);
			String mode="edit";
			gameController.mainFrame.setView(new MapView(mapModel,mode));
			}
		}
		else if(e.getSource()==mapView.inventView.addCharacter){
			if(mapView.inventView.addCharacter.isSelected()==true){				
				mapModel.setCharacterList(ioModel.getAllFolderFile("characters"));				
			}
			else{
				
				mapModel.notifyMapView("Uncheckcharacter");
			}
		}
		else if(e.getSource()==mapView.inventView.addTreasure){
			if(mapView.inventView.addTreasure.isSelected()==true){
				ioModel.readTreasureFile();
				mapModel.setTreasureList(ioModel.getTreasureList());
			}
			else{
				mapModel.notifyMapView("UncheckTreasure");
			}
		}
		else if(e.getSource()==mapView.inventView.characterDropDown){
				ioModel.readCharaterFile(ioModel.setCharacterFile(mapView.inventView.characterDropDown.getSelectedItem().toString()));
				mapModel.setCharacterImage(ioModel.getCharacterImage());
		}
		else if(e.getSource()==mapView.inventView.treasureDropDown){
		 mapModel.notifyMapView("treasureImage");
		}
		
	}
	// To Open Dialog Box
		public File openMapFile() {
			JFileChooser fileChooser = new JFileChooser(new File("maps/"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("XML",
					"xml");
			fileChooser.setFileFilter(filter);
			int option = fileChooser.showOpenDialog(gameController.mainFrame);

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				return file;
			} else {
				return null;
			}
		}

}
