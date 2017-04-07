package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;

public class HostileStrategy implements Strategy {
	ArrayList<Dimension> hostilePath;
	int stepCount=0;
	CharacterModel charModel;
	MapModel mapModel;
	int charLocX=0;
	int charLocY=0;
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
					(int) playerLoc.getHeight(),
					(int) playerLoc.getWidth(), mapModel.getWalls());
		System.out.println(hostilePath);
		Collections.reverse(hostilePath);
		
		for(Dimension d:hostilePath){
			if(stepCount<=3){
				charLocX=(int)d.getWidth();
				 charLocY=(int)d.getHeight();
				 System.out.println(d);
				 stepCount++;
						charModel.setBehaviour("Hostile");
					//	mapModel.updateCharLocation(charModel.getName()+"-Hostile", new Dimension(charLocY,charLocX));
						charModel.setCharLocation(new Dimension(charLocY,charLocX));
						
				}else{
					stepCount=0;
					return;
				}


				}

	}
	@Override
	public String getStrategyName() {
		return "HostileStrategy";
	}

}




