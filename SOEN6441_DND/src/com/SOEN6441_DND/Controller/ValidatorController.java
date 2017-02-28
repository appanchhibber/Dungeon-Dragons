package com.SOEN6441_DND.Controller;

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
    private String result;
	public String validator(MapView view) {
        result="Map Validated";
		mapCell = view.gridView.mapButtonsGrid;
list=new ArrayList();
		for (int i = 0; i < mapCell.length; i++) {
			for (int j = 0; j < mapCell[i].length; j++) {
				list.add(mapCell[i][j].getName());
			}

		}
		exitDoorCount=Collections.frequency(list, "ExitDoor");
		entryDoorCount=Collections.frequency(list, "EntryDoor");
        characterCount=Collections.frequency(list, "Character");
        chestCount=Collections.frequency(list,"Chest");
        System.out.println(chestCount);
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
		return result;
	}
}
