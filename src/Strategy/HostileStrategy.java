package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;

public class HostileStrategy implements Strategy,Runnable {
	ArrayList<Dimension> hostilePath;
	int stepCount=0;
	CharacterModel charModel;
	MapModel mapModel;
	int charLocX=0;
	int charLocY=0;
	Thread t1;
	@Override
	public void execute(MapModel mapModel,CharacterModel charModel) {
		System.out.println("Execute Hostile Strategy");
	 this.mapModel=mapModel;
	 this.charModel=charModel;
	 Dimension playerLoc=mapModel.getCharacterLocations().get(mapModel.getCharacterName());
	 System.out.println("player position:"+playerLoc);
	 System.out.println("Hostile Position:"+charModel.getCharLocation());
		hostilePath=PathValidatorController.hostilePath(1, mapModel.getMapWidth(),
					mapModel.getMapHeight(), (int) charModel.getCharLocation().getWidth(),
					(int) charModel.getCharLocation().getHeight(),
					(int) playerLoc.getWidth(),
					(int) playerLoc.getHeight(), mapModel.getWalls());
		Collections.reverse(hostilePath);
		t1=new Thread(this);
		t1.start();

	}
	@Override
	public String getStrategyName() {
		return "HostileStrategy";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Dimension d:hostilePath){
			if(stepCount<3){
				charLocX=(int)d.getWidth();
				 charLocY=(int)d.getHeight();
				 stepCount++;
						charModel.setBehaviour("Hostile");
					//	mapModel.updateCharLocation(charModel.getName()+"-Hostile", new Dimension(charLocY,charLocX));
						try {
							 t1.sleep(1000);
					            charModel.setCharLocation(new Dimension(charLocX,charLocY));
						}catch(Exception e){
							e.printStackTrace();
						}
						
						
				}else{
					stepCount=0;
					return;
				}

				}
	}

}




