package monserGame;

import java.util.Random;

public abstract class Monster implements IMonster {
	
	private int live;
	private final int DAMAGE = 40;
	private int[] position;
	private final char MONSTERMARK = 'P';
	private Random randomnNumber;
	
	protected void setLife(int life){
		this.live = life;
	}
	
	public void	hit(int damage){
		setLife(getLife() - damage);
	}
	
	@Override
	public int getLife() {
		return this.live;
	}
	
	@Override
	public int getDamage() {
		return this.DAMAGE;
	}
	
	@Override
	public int[] getCurrentPosition() {
		return this.position;
	}

	@Override
	public int[] generateNewCurrentPosition() {
			this.position[0] = randomnNumber.nextInt(10);
			this.position[1] = randomnNumber.nextInt(10);
			return this.position;
	}

	public char getMonsterMark() {
		return MONSTERMARK;
	}
}
