package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.FileOperationModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.LogWindow;
import com.SOEN6441_DND.Views.PlayArena;

public class FriendlyStrategy implements Strategy,Runnable {


	MapModel mapModel;
	CharacterModel charModel;
	ArrayList<Dimension> friendlyPath;
	ArrayList<Dimension> blockedPath;
	Dimension home;
	int charLocX=0;
	int charLocY=0;
	int stepCount=0;
	int toggle=1;
	Thread t1;
	Object key;
	FileOperationModel ioModel;
	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {
		blockedPath = new ArrayList<Dimension>();
		 ioModel=new FileOperationModel();
		System.out.println("Execute Friendly Behaviour Strategy");
		LogWindow.setLogDisplay("Execute Friendly Behaviour Strategy");
		this.mapModel = mapModel;
		this.charModel = charModel;
		if(toggle==1){
		this.setHomeLocation(charModel.getCharLocation());
		toggle++;
		}
		
		blockedPath.addAll(mapModel.getWalls());
		blockedPath.add(mapModel.getChest());
		blockedPath.add(mapModel.getExit());
		blockedPath.add(mapModel.getEntry());
		blockedPath.addAll(mapModel.getCharacterLocations().values());
		blockedPath.remove(charModel.getCharLocation());
		
		//System.out.println(home);
		if(mapModel.treasurePresent==true){	
		
			 key=mapModel.getTreasures().keySet().toArray()[0];
			 friendlyPath = PathValidatorController.friendlyPath(1, mapModel.getMapWidth(),
						mapModel.getMapHeight(), (int)charModel.getCharLocation().getWidth(),
						(int) charModel.getCharLocation().getHeight(),(int) mapModel.getTreasures().get(key).getWidth(),
						(int) mapModel.treasures.get(key).getHeight(), blockedPath);
			 Collections.reverse(friendlyPath);
			 
		}
		else{
			  key=mapModel.getTreasures().keySet().toArray()[0];
			 friendlyPath = PathValidatorController.friendlyPath(1, mapModel.getMapWidth(),
						mapModel.getMapHeight(),(int) charModel.getCharLocation().getWidth(),
						(int) charModel.getCharLocation().getHeight(), (int)home.getWidth(),
						(int) home.getHeight(), blockedPath);
			 Collections.reverse(friendlyPath);
		 }
		if(friendlyPath.size()>=1){
			 friendlyPath.remove(0);
		}
		 t1=new Thread(this);
		 t1.start();
	}
	@Override
	public void run() {
		int distance = friendlyPath.size();
		System.out.println(distance);
		if(distance==0){
			charModel.moveCompleted=true;
			charModel.setCharLocation(home);
		}
		for(Dimension d:friendlyPath){
			if(stepCount<3){
				charLocX=(int)d.getWidth();
				 charLocY=(int)d.getHeight();
					//	mapModel.updateCharLocation(charModel.getName()+"-Hostile", new Dimension(charLocY,charLocX));
						try {
							 t1.sleep(500);
								if (distance <3) {
									System.out.println("distance is less than 3");
									if(distance!=0) {
										System.out.println("dis:"+distance);
										distance--;
										charModel.setCharLocation(new Dimension(charLocX,charLocY));
										if(distance==0 && mapModel.treasurePresent==true){
											mapModel.treasurePresent=false;
											if(!charModel.getBackPackItems().contains(key.toString())&& charModel.getBackPackCounter()<10){
												charModel.getBackPackItems().add(key.toString());
												charModel.setBackPackCounter(charModel.getBackPackCounter()+1);
												JOptionPane.showMessageDialog(null, "Item:"+key.toString()+"added to Backpack");
												charModel.setMoveCompleted(true);
												charModel.setCharLocation(mapModel.getTreasures().get(key));
											}
											else{
												JOptionPane.showMessageDialog(null, "Item already in backpack");
												charModel.setMoveCompleted(true);
												charModel.setCharLocation(mapModel.getTreasures().get(key));
											}

										}
										if(distance==0 && mapModel.treasurePresent==false){
											charModel.setMoveCompleted(true);
											charModel.setCharLocation(home);
										}
									}else{
										mapModel.treasurePresent=false;
										ioModel.readTreasureItem(key.toString());
										charModel.setMoveCompleted(true);
									}
								}
								else{
							    stepCount++;
					            distance--;
					            charModel.setCharLocation(new Dimension(charLocX,charLocY));
								}
						}catch(Exception e){
							e.printStackTrace();
						}
						
						
				}else{
					stepCount=0;
					return;
				}
		}

		
	}
	@Override
	public String getStrategyName() {

		return "FriendlyStrategy";
	}
	public void setHomeLocation(Dimension d){
	
		home= new Dimension((int)d.getWidth(),(int)d.getHeight());
		
	}
}
