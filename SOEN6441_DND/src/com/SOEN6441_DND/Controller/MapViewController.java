package com.SOEN6441_DND.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.MapView;

public class MapViewController implements ActionListener {
public MapView mapView;
public MapModel mapModel;
	public MapViewController(MapView view)
	{
		this.mapView=view;
		this.mapModel=view.mapModel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
