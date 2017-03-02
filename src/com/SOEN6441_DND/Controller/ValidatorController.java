package com.SOEN6441_DND.Controller;
/**
 * This Class is used to Validate Map.
 * Validations are.
 * 1.) Entry Exit Gate.
 * 2.) Map Path Validation
 * 3.) Chest in the Map Validation
 * @author Punit Trivedi
 * @author Appan Chhibber.
 */
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

import com.SOEN6441_DND.Views.MapView;

public class ValidatorController {
	private JButton[][] mapCell;
	private ArrayList list;
    private int exitDoorCount;
    private int entryDoorCount;
    private int chestCount;
    private int characterCount;
    public ArrayList<Dimension> walls;
    private Dimension entry;
    private Dimension exit;
    public PathValidatorController pathValidator;

    
    
    private String result;
    
	public String validator(MapView view) {
        result="Map Validated";
		mapCell = view.gridView.mapButtonsGrid;
		PathValidatorController.mapCell=view.gridView.mapButtonsGrid;
list=new ArrayList();
walls=new ArrayList<Dimension>();
for (int i = 0; i < mapCell.length; i++) {
			for (int j = 0; j < mapCell[i].length; j++) {
				list.add(mapCell[i][j].getName());
				if(mapCell[i][j].getName().equals("Wall"))
				{
					walls.add(new Dimension(i, j));
				}
				else if(mapCell[i][j].getName().equals("EntryDoor"))
				{
					entry=new Dimension(i, j);
				}
				else if (mapCell[i][j].getName().equals("ExitDoor")) {
					exit=new Dimension(i, j);
				}
			}

		}
		exitDoorCount=Collections.frequency(list, "ExitDoor");
		entryDoorCount=Collections.frequency(list, "EntryDoor");
        characterCount=Collections.frequency(list, "Character");
        chestCount=Collections.frequency(list,"Chest");
       if(exitDoorCount>=2){
    	   
    	   result="There can only be one Exit Door";
       }
       else if(entryDoorCount>=2){
    	   result="There can only be one Entry Door.";
       }
       else if(entryDoorCount==0)
       {
    	   result="There is no Entry Door";
       }
       else if(exitDoorCount==0)
       {
    	   result="There is no Exit Door";
       }
       else if(chestCount==0 ||chestCount>1)
       {
    	   result="There is no chest/Character in the Map";
       }
       else
       {
    	   pathValidator= new PathValidatorController();
    	   String message=PathValidatorController.test(1, mapCell.length, mapCell[1].length, (int) entry.getWidth(), (int)entry.getHeight(), (int)exit.getWidth(), (int)exit.getHeight(), walls);
    	   if(message=="NoPath")
    	   {
    		   result="There is no Valid Path";
    	   }
       }
		return result;
	}
}
