package monserGame;

import java.util.Random;

public abstract class Monster implements IMonster {
	
	protected int live;
	protected int Damage;
	protected int[] position;
	protected Random randomnNumber;
	
	public Monster(int live, int damage){
		this.position = new int[2];
		setLife(live);
		setDamage(damage);
		this.randomnNumber = new Random();
	}
	
	protected void setLife(int life){
		this.live = life;
	}
	
	protected void setDamage(int damage){
		this.Damage = damage;
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
		return this.Damage;
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
	
	public abstract boolean ParticularAction();
}