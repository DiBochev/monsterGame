package monserGame;

import java.util.Random;

public abstract class Monster implements IMonster {
	
	protected int live;
	protected final int DAMAGE = 40;
	protected int[] position;
	protected Random randomnNumber;
	
	public Monster(){
		this.position = new int[2];
		this.live = 200;
		this.randomnNumber = new Random();
	}
	
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
}
