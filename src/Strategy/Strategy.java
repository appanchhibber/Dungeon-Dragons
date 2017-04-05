package Strategy;

import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.PlayArena;

public interface Strategy {
	void execute(MapModel mapModel,CharacterModel charModel);
	public String getStrategyName();
}
