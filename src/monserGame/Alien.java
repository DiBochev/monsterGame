package monserGame;

public class Alien extends Monster{

	private final char MONSTERMARK = 'A';
	
	public Alien(){
		super();
	}
	
	public boolean heal() {
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
