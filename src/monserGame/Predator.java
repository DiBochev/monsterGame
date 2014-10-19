package monserGame;

public class Predator extends Monster{

	private final char MONSTERMARK = 'P';
	
	public Predator(){
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
