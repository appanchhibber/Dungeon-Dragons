package Strategy;

import com.SOEN6441_DND.Model.CharacterModel;

public class HostileStrategy implements Strategy {
	@Override
	public void execute(CharacterModel charModel) {
		// TODO Auto-generated method stub
		System.out.println(charModel.getName()+":"+charModel.getHitPoints());

	}

	@Override
	public String getStrategyName() {
		return "HostileStrategy";
	}

}
