package com.SOEN6441_DND.Controller;
import java.awt.Color;
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

import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.MapView;

/**
 * 
 * @author Punit Trivedi
 *
 */
public class MapValidatorController {
	private JButton[][] mapCell;
    private int exitDoorCount;
    private int entryDoorCount;
    private int chestCount;
    private int characterCount;
 public MapModel mapModel;
    public PathValidatorController pathValidator;

private ArrayList list;    
    private String result;
    
    /**
     * This function validates the map and returns appropriate message.
     * @param view
     * @return result Message of type String
     */
	public String validator(MapView view) {
        result="Map Validated";
		mapCell = view.gridView.mapButtonsGrid;
		PathValidatorController.mapCell=view.gridView.mapButtonsGrid;
		exitDoorCount=0;
		entryDoorCount=0;
		chestCount=0;
		characterCount=0;
		list=new ArrayList();
		this.mapModel=view.mapModel;
		mapModel.walls.clear();
for (int i = 0; i < mapCell.length; i++) {
			for (int j = 0; j < mapCell[i].length; j++) {
				list.add(mapCell[i][j].getName());
				if(mapCell[i][j].getName().equals("Wall"))
				{
					mapModel.walls.add(new Dimension(i, j));
				}
				else if(mapCell[i][j].getName().equals("EntryDoor"))
				{
					mapModel.entry=new Dimension(i, j);
				}
				else if (mapCell[i][j].getName().equals("ExitDoor")) {
					mapModel.exit=new Dimension(i, j);
				}
				else if(mapCell[i][j].getName().equals("Chest")){
					mapModel.chest=new Dimension(i, j);
				}
				mapCell[i][j].setBackground(Color.WHITE);
			}

		}
		mapModel.mapItemList=list;
		exitDoorCount=Collections.frequency(mapModel.mapItemList, "ExitDoor");
		entryDoorCount=Collections.frequency(mapModel.mapItemList, "EntryDoor");
        characterCount=Collections.frequency(mapModel.mapItemList, "Character");
        chestCount=Collections.frequency(mapModel.mapItemList,"Chest");

       if(exitDoorCount>1){
    	   
    	   result="There can only be one Exit Door";
       }
       else if(entryDoorCount>1){
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
       else if(chestCount==0)
       {
    	   result="There is no chest/Character in the Map";
       }
       else if(chestCount>1)
       {
    	   result="There can only be one Chest.";
       }
       else
       {
    	   pathValidator= new PathValidatorController();
    	   
    	   String Valid1=PathValidatorController.test(1, mapCell.length, mapCell[1].length, (int) mapModel.entry.getWidth(), (int)mapModel.entry.getHeight(), (int)mapModel.chest.getWidth(), (int)mapModel.chest.getHeight(), mapModel.getWalls());
    	   String Valid2=PathValidatorController.test(2, mapCell.length, mapCell[1].length, (int) mapModel.chest.getWidth(), (int)mapModel.chest.getHeight(), (int)mapModel.exit.getWidth(), (int)mapModel.exit.getHeight(),  mapModel.getWalls());
 
    	   if(Valid1=="NoPath"|| Valid2=="NoPath")
    	   {
    		   result="There is no Valid Path";
    	   }
       }
		return result;
	}

	public Boolean checkExitDoor(int exitDoorCount){
		if(exitDoorCount>1){
	    	   
	    	    result =  "There can only be one Exit Door";
	    return false;   
		}
		
		else if(exitDoorCount==0)
	       {
	    	   result="There is no Exit Door";
	      return false;
	       }
		
		
	else{
		
		return true;
	}
	}

	public String checkEntryDoor(int entryDoorCount){
		if(entryDoorCount>1){
	    	   
	    	    result =  "There can only be one Entry Door";
	    return result;   
		}
		
		else if(entryDoorCount==0)
	       {
	    	   result="There is no Entry Door";
	      return result;
	       }
		
		
	else{
		
		result =  "Wrong Entry Door Placement";
		return result;
	}
	}
	public String checkChestCount(int chestCount){
		if(chestCount>1){
	    	   
			result="There can only be one Chest";
	    return result;   
		}
		
		else if(chestCount==0)
	       {
			result="There is no chest/Character in the Map";
	      return result;
	       }
		
		
	else{
		
		result =  "Wrong chest Placement";
		return result;
	}
	}

}
