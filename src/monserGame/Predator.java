package monserGame;

import java.util.Random;

public class Predator  implements IMonster{

	private int live;
	private final int DAMAGE = 40;
	private int[] position;
	private final char MONSTERMARK = 'P';
	private Random randomnNumber;
	
	public Predator(){
		this.position = new int[2];
		this.live = 200;
		this.randomnNumber = new Random();
	}
	
	public boolean heal() {
		if (randomnNumber.nextInt(10)/4 == 0) {
			this.live += 40;
		}
		return true;

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

	public char getMonsterMark() {
		return MONSTERMARK;
	}

}
