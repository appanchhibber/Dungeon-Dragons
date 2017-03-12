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
		else if(e.getSource()==mapView.inventView.removeButton){
			System.out.println("Remove Button Event FIred");
		}
		else if(e.getSource()==mapView.navPanel.saveButton){
			JFileChooser fileChooser = new JFileChooser(new File("maps/"));
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
					"XML", "xml"));
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().toString());
				String saveResult=ioModel.writeMapData(file,mapModel);
			}
		
		}
		else if (e.getSource() == mapView.navPanel.loadButton) {
			File file = openMapFile();
			mapModel=ioModel.readMapFile(file);
			String mode="edit";
			gameController.mainFrame.setView(new MapView(mapModel,mode));
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
