package monserGame;

import java.util.ArrayList;

public class Alien extends Monster{

	private final static int LIVE = 600;
	private final static int DAMAGE = 60;
	private final char MONSTERMARK = 'A';
	private ArrayList<Pet> AlienPets;
	
	public Alien(){
		super(LIVE, DAMAGE);
		this.AlienPets = new ArrayList<Pet>();
	}
	
	public boolean ParticularAction() {
		if (randomnNumber.nextInt(10)/4 == 0) {
			this.live += 40;
		}
		return true;
	}

	@Override
	public char getMonsterMark() {
		return this.MONSTERMARK;
	}
}
