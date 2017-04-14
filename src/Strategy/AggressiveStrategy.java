package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.MapModel;

public class AggressiveStrategy implements Strategy, Runnable {
	ArrayList<Dimension> hostilePath;
	ArrayList<Dimension> blockedPath;
	int stepCount = 0;
	CharacterModel charModel;
	MapModel mapModel;
	int charLocX = 0;
	int charLocY = 0;
	Thread t1;

	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {
		blockedPath = new ArrayList<Dimension>();
		this.mapModel = mapModel;
		Dimension playerLoc = mapModel.getCharacterLocations().get(mapModel.getCharacterName());
		this.charModel = charModel;
		System.out.println("Execute Hostile Strategy");
		if (charModel.isAttackFlag()) {
			charModel.setCharLocation(charModel.getCharLocation());
			charModel.setAttackFlag(false);
		}

		else {
			blockedPath.addAll(mapModel.getWalls());
			blockedPath.add(mapModel.getChest());
			blockedPath.addAll(mapModel.getCharacterLocations().values());
			blockedPath.remove(charModel.getCharLocation());
			blockedPath.remove(playerLoc);

			hostilePath = PathValidatorController.hostilePath(1, mapModel.getMapWidth(), mapModel.getMapHeight(),
					(int) charModel.getCharLocation().getWidth(), (int) charModel.getCharLocation().getHeight(),
					(int) playerLoc.getWidth(), (int) playerLoc.getHeight(), blockedPath);
			Collections.reverse(hostilePath);
			if (hostilePath.size() > 1) {
				hostilePath.remove(0);
			}

			t1 = new Thread(this);
			t1.start();
		}
	}

	@Override
	public String getStrategyName() {
		return "HostileStrategy";
	}

	public void attack() {
		charModel.setAttackFlag(false);
		int diceresult=rollDice();
		
	}
	public int rollDice(){
		return new Random().nextInt(20)+1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int distance = hostilePath.size();
		if (distance <= charModel.getOwnedItems().get("Weapon").getWeaponRange()) {
			for (int i = stepCount; i < 3; i++) {
				charModel.setCharLocation(charModel.getCharLocation());
			}
		}
		for (Dimension d : hostilePath) {
			if (stepCount < 3) {
				if (distance <= charModel.getOwnedItems().get("Weapon").getWeaponRange()) {
					System.out.println("Attacking on Player");
					charModel.setCharLocation(charModel.getCharLocation());
				} else {
					charLocX = (int) d.getWidth();
					charLocY = (int) d.getHeight();
					// mapModel.updateCharLocation(charModel.getName()+"-Hostile",
					// new Dimension(charLocY,charLocX));
					try {
						t1.sleep(1000);
						charModel.setCharLocation(new Dimension(charLocX, charLocY));
						distance--;
						stepCount++;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				stepCount = 0;
				return;
			}

		}
	}

}
