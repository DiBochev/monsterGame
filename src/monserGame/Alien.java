package monserGame;

import java.util.Random;

public class Alien implements IMonster{

	private int live;
	private final int DAMAGE = 40;
	private int[] position;
	private final char MONSTERMARK = 'A';
	private Random randomnNumber;
	
	public Alien(){
		this.position = new int[2];
		this.live = 200;
		this.randomnNumber = new Random();
	}
	
	@Override
	public int getLife() {
		return this.live;
	}
	
	protected void setLife(int life){
		this.live = life;
	}
	
	public void	hit(int damage){
		setLife(getLife() - damage);
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
	public void heal() {
		if (randomnNumber.nextInt(10)/4 == 0) {
			this.live += 40;
			System.err.println("Alien eat smth and now has: " + getLife() + " live");
		}
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
