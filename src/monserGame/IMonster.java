package monserGame;

public interface IMonster {
	
	int getLife();
	int getDamage();
	void hit(int damage);
	char getMonsterMark();
	int[] getCurrentPosition();
	boolean heal();
	int[] generateNewCurrentPosition();
}
