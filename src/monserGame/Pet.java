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

	private void setLive(int live){
		this.live = live;
	}
	
	public static boolean IfCreatPet(){
		Random random = new Random();
		if((random.nextInt(10) / 4) == 0){
			return true;
		}else{
			return false;
		}
	}

	
	public boolean ParticularAction() {
		//CoverTree if not get live to master!
		//setLife(0);
		return true;
	}
	
	public void Move(StringBuilder mapSB){
		char[] map = mapSB.toString().toCharArray();
		//CoverTree if not get live to master!
		//if can attack enemy- attack, 
		//else if can move to enemy move, 
		//else give live to Master!
		
	}
	
}
