package com.monsterGame.Monsters;

public interface IMonster {
	
	int getLife();
	int getDamage();
	void hit(int damage);
	char getMonsterMark();
	int[] getCurrentPosition();
	int[] generateNewCurrentPosition(int matrixSize);
	boolean specialAction();
}
