package Strategy;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public class ComputerStrategy implements Strategy {
	@Override
	public void execute(MapModel mapModel,CharacterModel charModel) {
		System.out.println("Computer Strategy fired");

	}

	@Override
	public String getStrategyName() {
		return "ComputerStrategy";
	}

}
