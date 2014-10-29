package monserGame;

import java.util.ArrayList;

public class Predator extends Monster{

	private final static int LIVE = 600;
	private final static int DAMAGE = 60;
	private final char MONSTERMARK = 'P';
	private ArrayList<Pet> PredatorPets;
	
	public Predator(){
		super(LIVE, DAMAGE);
		this.PredatorPets = new ArrayList<Pet>();
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

	
	public ArrayList<Pet> getPredatorPets() {
		return PredatorPets;
	}
	
	public Pet getLastPredatorPet() {
		return PredatorPets.get(PredatorPets.size()-1);
	}
	

	public void addPredatorPet() {
		PredatorPets.add(new Pet(this.MONSTERMARK));
	}


}
