package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
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
	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {
		blockedPath = new ArrayList<Dimension>();
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
		blockedPath.addAll(mapModel.getCharacterLocations().values());
		blockedPath.remove(charModel.getCharLocation());
		
		//System.out.println(home);
		if(mapModel.treasurePresent==true){	
		
			Object key=mapModel.getTreasures().keySet().toArray()[0];
			 friendlyPath = PathValidatorController.friendlyPath(1, mapModel.getMapWidth(),
						mapModel.getMapHeight(), (int)charModel.getCharLocation().getWidth(),
						(int) charModel.getCharLocation().getHeight(),(int) mapModel.getTreasures().get(key).getWidth(),
						(int) mapModel.treasures.get(key).getHeight(), blockedPath);
			 Collections.reverse(friendlyPath);
			 
		}
		else{
			 Object key=mapModel.getTreasures().keySet().toArray()[0];
			 friendlyPath = PathValidatorController.friendlyPath(1, mapModel.getMapWidth(),
						mapModel.getMapHeight(),(int) charModel.getCharLocation().getWidth(),
						(int) charModel.getCharLocation().getHeight(), (int)home.getWidth(),
						(int) home.getHeight(), blockedPath);
			 Collections.reverse(friendlyPath);
			 toggle++;
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
		if (distance <= 1) {
			for (int i = stepCount; i < 3; i++) {
				charModel.setCharLocation(charModel.getCharLocation());
				mapModel.treasurePresent=false;
			}
		}
		for(Dimension d:friendlyPath){
			if(stepCount<3){
				charLocX=(int)d.getWidth();
				 charLocY=(int)d.getHeight();
					//	mapModel.updateCharLocation(charModel.getName()+"-Hostile", new Dimension(charLocY,charLocX));
						try {
							 t1.sleep(500);
					            charModel.setCharLocation(new Dimension(charLocX,charLocY));
					            stepCount++;
					            distance--;
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
