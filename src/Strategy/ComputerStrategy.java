package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class ComputerStrategy implements Strategy {
	private int stepCount=0;
	@Override
	public void execute(MapModel mapModel,CharacterModel charModel) {
		ArrayList<Dimension> computerPath=new ArrayList<Dimension>();
		computerPath = PathValidatorController.computerPath(1, mapModel.getMapWidth(),
				mapModel.getMapHeight(), (int)charModel.getCharLocation().getWidth(),
				(int) charModel.getCharLocation().getHeight(),(int) mapModel.chest.getWidth(),
				(int) mapModel.chest.getHeight(), mapModel.getWalls());
		/*computerPath = PathValidatorController.computerPath(2, mapModel.getMapWidth(),
				mapModel.getMapHeight(), (int)mapModel.chest.getWidth(),
				(int) mapModel.chest.getHeight(),(int) mapModel.exit.getWidth(),
				(int) mapModel.exit.getHeight(), mapModel.getWalls());*/
		Collections.reverse(computerPath);
		System.out.println("Complete Path is:"+computerPath);
		for(Dimension d:computerPath){
			if(stepCount<3){
			System.out.println("3 movements are:"+d);
			stepCount++;
			}
			else{
				stepCount=0;
				return ;
			}
			
		}
	}

	@Override
	public String getStrategyName() {
		return "ComputerStrategy";
	}

}
