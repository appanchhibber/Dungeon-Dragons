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

public class MapViewController implements ActionListener,MouseMotionListener {

	
@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	//super.mouseDragged(e);
	JLabel newlabel = (JLabel) e.getSource();
	TransferHandler handler = newlabel.getTransferHandler();
	handler.exportAsDrag(newlabel, e, TransferHandler.COPY);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
public MapView mapView;
public MapModel mapModel;
public FileOperationModel ioModel;

	public MapViewController(MapView view)
	{
		this.mapView=view;
		this.mapModel=view.mapModel;
		ioModel=new FileOperationModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mapView.inventView.validateButton){
			ValidatorController validate=new ValidatorController();
			String result=validate.validator(mapView);
			if(result!="Map Validated")
			{
				JOptionPane.showMessageDialog(null,result);
			}
			else{
				mapView.navPanel.saveButton.setEnabled(true);
			}
		}
		else if(e.getSource()==mapView.inventView.removeButton){
			System.out.println("Remove Button Event FIred");
		}
		else if(e.getSource()==mapView.navPanel.saveButton){
			JFileChooser fileChooser = new JFileChooser(new File("maps/"));
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
					"Dungeon and DragonsS Map", "xml"));
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				String saveResult=ioModel.writeMapData(file,mapModel);
			}
		
		}
		
	}

}
