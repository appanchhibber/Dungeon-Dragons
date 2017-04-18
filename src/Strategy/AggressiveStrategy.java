package Strategy;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;





import Decorator.*;

import com.SOEN6441_DND.Controller.PathValidatorController;
import com.SOEN6441_DND.Model.CharacterModel;
import com.SOEN6441_DND.Model.ItemModel;
import com.SOEN6441_DND.Model.MapModel;
import com.SOEN6441_DND.Views.LogWindow;

public class AggressiveStrategy implements Strategy, Runnable {
	ArrayList<Dimension> hostilePath;
	ArrayList<Dimension> blockedPath;
	int stepCount = 0;
	CharacterModel charModel;
	MapModel mapModel;
	int charLocX = 0;
	int charLocY = 0;
	int distance;
	Thread t1;
	private Weapon weapon;
	@Override
	public void execute(MapModel mapModel, CharacterModel charModel) {
		blockedPath = new ArrayList<Dimension>();
		this.mapModel = mapModel;
		Dimension playerLoc = mapModel.getCharacterLocations().get(
				mapModel.getCharacterName());
		this.charModel = charModel;
		System.out.println("Executing Hostile Behaviour Strategy");
		LogWindow.setLogDisplay("Executing Hostile Behaviour Strategy");
		stepCount = 0;
		if (charModel.isAttackFlag()) {
			System.out.println("Aggresive calling Attack");
			LogWindow.setLogDisplay("Aggresive calling Attack");
			attack();
			charModel.setAttackFlag(false);
			charModel.setMoveCompleted(true);
		}

		else {
			blockedPath.addAll(mapModel.getWalls());
			blockedPath.add(mapModel.getChest());
			blockedPath.addAll(mapModel.getCharacterLocations().values());
			blockedPath.remove(charModel.getCharLocation());
			blockedPath.remove(playerLoc);

			hostilePath = PathValidatorController.hostilePath(1,
					mapModel.getMapWidth(), mapModel.getMapHeight(),
					(int) charModel.getCharLocation().getWidth(),
					(int) charModel.getCharLocation().getHeight(),
					(int) playerLoc.getWidth(), (int) playerLoc.getHeight(),
					blockedPath);
			Collections.reverse(hostilePath);
			if (hostilePath.size() > 2) {
				hostilePath.remove(0);
			}
			distance = hostilePath.size();
			System.out.println("Distance:" + distance);
			t1 = new Thread(this);
			t1.start();
		}
	}

	@Override
	public String getStrategyName() {
		return "HostileStrategy";
	}




	/**
	 * method for frightening hostile
	 */
	public void frigthen() {

	}

	public void attack() {
		CharacterModel enemy = charModel.getEnemy();
		ItemModel weaponModel=charModel.getOwnedItems().get("Weapon");
		int enchantmentValue=weaponModel.getEnchantValue();
		int diceresult = rollDice() + charModel.getAttackBonus();
		System.out.println("Attack Roll" + diceresult);
		LogWindow.setLogDisplay("Getting Attack Roll dice result : "
				+ diceresult);
		if (enemy.getArmorClass() < diceresult) {
			System.out.println("Attack Started");
			LogWindow
					.setLogDisplay("Armor class is less than dice result - Attack started !");
			LogWindow.setLogDisplay(enemy.getArmorClass() + " < " + diceresult);
			enemy.setHitPoints(enemy.getHitPoints()
					- charModel.getDamageBonus());
			weapon=new SimpleWeapon(charModel.getEnemy(),enchantmentValue);
			
			System.out.println("Decorator"+weapon.getEffectedEnemy().getName());
			System.out.println("Burning:"+weaponModel.isBurning()+",Frightening:"+weaponModel.isFrightening());
			 if(weaponModel.isBurning()){
				 weapon=new Burning(weapon);
				 weapon.getEffectedEnemy();
			 }
			 if(weaponModel.isFreezing()){
				 weapon=new Freezing(weapon);
				 weapon.getEffectedEnemy();
			 }
			 if(weaponModel.isFrightening()){
				 weapon=new Frightening(weapon);
				 weapon.getEffectedEnemy();
			 }
			 if(weaponModel.isPacifying()){
				 weapon=new Pacifying(weapon);
				 weapon.getEffectedEnemy();
			 }
			 if(weaponModel.isSlaying()) {
				 weapon=new Slaying(weapon);
				 weapon.getEffectedEnemy();
			 }
			 
		}
	}

	public int rollDice() {
		return new Random().nextInt(20) + 1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (distance <= charModel.getOwnedItems().get("Weapon")
				.getWeaponRange()) {
			charModel.setCharLocation(charModel.getCharLocation());
		}
		for (Dimension d : hostilePath) {

			if (stepCount < 3) {
				System.out.println("Step Count:" + stepCount);
				if (distance <= charModel.getOwnedItems().get("Weapon")
						.getWeaponRange()) {
					attack();
				}
				charLocX = (int) d.getWidth();
				charLocY = (int) d.getHeight();
				// mapModel.updateCharLocation(charModel.getName()+"-Hostile",
				// new Dimension(charLocY,charLocX));
				try {
					t1.sleep(1000);
					charModel
							.setCharLocation(new Dimension(charLocX, charLocY));
					stepCount++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				stepCount = 0;
				return;
			}

		}
	}

}
