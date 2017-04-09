package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class ComputerStrategy implements Strategy,Runnable {
	private int stepCount=0;
	int charLocX=0;
	int charLocY=0;
	ArrayList<Dimension> computerPath=new ArrayList<Dimension>();
	CharacterModel charModel;
	Thread t1;
	@Override
	public void execute(MapModel mapModel,CharacterModel charModel) {
		if(computerPath.size()==0){
			ArrayList<Dimension> pathToChest = PathValidatorController.computerPath(1, mapModel.getMapWidth(),
					mapModel.getMapHeight(), (int)charModel.getCharLocation().getWidth(),
					(int) charModel.getCharLocation().getHeight(),(int) mapModel.chest.getWidth(),
					(int) mapModel.chest.getHeight(), mapModel.getWalls());
			Collections.reverse(pathToChest);
			computerPath.addAll(pathToChest);
			ArrayList<Dimension> pathToExit = PathValidatorController.computerPath(2, mapModel.getMapWidth(),
					mapModel.getMapHeight(), (int)mapModel.chest.getWidth(),
					(int) mapModel.chest.getHeight(),(int) mapModel.exit.getWidth(),
					(int) mapModel.exit.getHeight(), mapModel.getWalls());
			Collections.reverse(pathToExit);
			computerPath.addAll(pathToExit);	
		}
		remove(computerPath.get(0));
		this.charModel=charModel;
		t1=new Thread(this);
		t1.start();
	}
	public void remove(Object dimension){
		computerPath.remove(dimension);
		System.out.println("updated computer path"+computerPath);
	}
	@Override
	public String getStrategyName() {
		return "ComputerStrategy";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Dimension d:(ArrayList<Dimension>)computerPath.clone()){
			if(stepCount<3){
			charLocX=(int)d.getWidth();
			 charLocY=(int)d.getHeight();
			 System.out.println(d);
			 stepCount++;
					charModel.setBehaviour("Computer");
					remove(d);
					try {
						Thread.sleep(1000);
						charModel.setCharLocation(new Dimension(charLocX,charLocY));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
			else{
				stepCount=0;
				return ;
			}
			
		}
	}

}
