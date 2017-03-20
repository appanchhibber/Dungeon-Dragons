/**
 * 
 */
package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import com.SOEN6441_DND.Controller.MapValidatorController;
import com.SOEN6441_DND.Controller.MapViewController;
import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Views.MapView;

//import java.awt.Dimension;

/**
 * @author Paras Malik
 *
 */
public class ControllerTest {
	
	public PathValidatorController pathValidator;
	public FileOperationModel fileIo;

	@Test
	public void testMapValidation() {
		pathValidator= new PathValidatorController();
		JButton[][] mapCell;
		JButton mapButtonsGrid[][];
		Dimension entry;
		Dimension exit;
		ArrayList<Dimension> walls;
		
		walls=new ArrayList<Dimension>();				
		mapButtonsGrid = new JButton[10][10];
		
		mapCell = mapButtonsGrid;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mapButtonsGrid[i][j] = new JButton();
				if(j==5){
					//if(i!=5)
						walls.add(new Dimension(i, j));
				}
			}
		}
		
		mapCell[2][4].setName("EntryDoor");
		mapCell[8][8].setName("ExitDoor");

		entry=new Dimension(2, 4);
		exit=new Dimension(8, 8);
		
		//String temp = mapCell[2][4].getName();
		
		String message=PathValidatorController.test(1, mapCell.length, mapCell[1].length, (int) entry.getWidth(), (int)entry.getHeight(), (int)exit.getWidth(), (int)exit.getHeight(), walls);
				
		assertEquals("NoPath", message);
	}

	@Test
	public void testExitDoorGreaterThanZero(){
		
		String expected = "There can only be one Exit Door";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkExitDoor(2));
	}
	
	@Test
	public void testExitDoorEqualZero(){
		
		String expected = "There is no Exit Door";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkExitDoor(0));
	}
	
	@Test
	public void testEntryDoorGreaterThanZero(){
		
		String expected = "There can only be one Entry Door";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkEntryDoor(3));
	}
	
	@Test
	public void testCheckChestCountGreaterZero(){
		
		String expected = "There can only be one Chest";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkChestCount(3));
	}
	@Test
	public void testCheckChestCountEqualZero(){
		
		String expected = "There is no chest/Character in the Map";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkChestCount(0));
	}
	@Test
	public void testEntrytDoorEqualZero(){
		
		String expected = "There is no Entry Door";
		MapValidatorController mapValidatorController = new MapValidatorController();
		assertEquals(expected,mapValidatorController.checkEntryDoor(0));
	}

	

	
}
