/**
 * 
 */
package com.SOEN6441_DND.Test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import com.SOEN6441_DND.Controller.PathValidatorController;

//import java.awt.Dimension;

/**
 * @author Amir
 *
 */
public class ControllerTest {
	
	public PathValidatorController pathValidator;

	@Test
	public void MapValidation() {
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

}
