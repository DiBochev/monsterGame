package monserGame;

import java.util.Random;

public class Pet extends Monster{

	private final static int Live = 100;
	private final static int Damage = 30;
	private char MonsterMark;
	
	public Pet(char Monstermark) {
		super(Live,Damage);
		setMonsterMark(Monstermark);
	}

	protected void setMonsterMark(char mark){
		this.MonsterMark = Character.toLowerCase(mark);;
		
	}
	
	@Override
	public char getMonsterMark() {
		return this.MonsterMark;
	}

	public static boolean IfCreateMonster(){
		Random random = new Random();
		if((random.nextInt(10) / 4) == 0){
			return true;
		}else{
			return false;
		}
	}

	
	@Override
	public boolean ParticularAction() {
		//CoverTree if not get live to master!
		return false;
	}

}
