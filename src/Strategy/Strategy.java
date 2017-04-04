package Strategy;

import com.SOEN6441_DND.Model.CharacterModel;

public interface Strategy {
	void execute(CharacterModel charModel);
	public String getStrategyName();
}
