package monserGame;

import java.util.ArrayList;

public interface IMonster {
	
	int getLife();
	int getDamage();
	int[] getCurrentPosition();
	void heal();
	int[] generateNewCurrentPosition();
	ArrayList<Integer> getUsedPositionsRow();
	ArrayList<Integer> getUsedPositionsCol();
}
