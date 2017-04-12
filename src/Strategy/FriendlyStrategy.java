package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class FriendlyStrategy implements Strategy,Runnable {


	MapModel mapModel;
	CharacterModel charModel;
	ArrayList<Dimension> friendlyPath=new ArrayList<Dimension>();
	int charLocX=0;
	int charLocY=0;
	int stepCount=0;
	static int toggle=1;
	Thread t1;
	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {
		System.out.println("Execute Friendly Strategy");
		this.mapModel = mapModel;
		this.charModel = charModel;
		
		 if(mapModel.treasurePresent==true){
			 Object key=mapModel.getTreasures().keySet().toArray()[0];
			 friendlyPath = PathValidatorController.friendlyPath(1, mapModel.getMapWidth(),
						mapModel.getMapHeight(), (int)charModel.getCharLocation().getWidth(),
						(int) charModel.getCharLocation().getHeight(),(int) mapModel.getTreasures().get(key).getWidth(),
						(int) mapModel.treasures.get(key).getHeight(), mapModel.getWalls());
			 Collections.reverse(friendlyPath);
			 if(friendlyPath.size()==1){
				 for(int i=0;i<=3;i++){
				 friendlyPath.add(new Dimension((int)(charModel.getCharLocation().getWidth())-i,(int)(charModel.getCharLocation().getHeight())));
				 
				 }
				 friendlyPath.remove(0);
			 }

			 friendlyPath.remove(0);
			 }

		 else{
			 
			 if(toggle%2==0){
			 for(int i=0;i<=3;i++){
				 friendlyPath.add(new Dimension((int)(charModel.getCharLocation().getWidth())+i,(int)(charModel.getCharLocation().getHeight())));
				 
				 }
			 toggle++;
			 }else{
				 for(int i=0;i<=3;i++){
					 friendlyPath.add(new Dimension((int)(charModel.getCharLocation().getWidth())-i,(int)(charModel.getCharLocation().getHeight())));
					 
					 }
				 toggle++;
			 }
			 friendlyPath.remove(0);
		 }
		 t1=new Thread(this);
		 t1.start();
	}
	@Override
	public void run() {
		for(Dimension d:friendlyPath){
			if(stepCount<3){
				charLocX=(int)d.getWidth();
				 charLocY=(int)d.getHeight();
						charModel.setBehaviour("Friendly");
					//	mapModel.updateCharLocation(charModel.getName()+"-Hostile", new Dimension(charLocY,charLocX));
						try {
							 t1.sleep(1000);
					            charModel.setCharLocation(new Dimension(charLocX,charLocY));
					            stepCount++;
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

}
