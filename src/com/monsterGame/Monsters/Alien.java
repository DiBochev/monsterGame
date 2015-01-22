package com.monsterGame.Monsters;

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
	
	public boolean specialAction() {
		if (randomnNumber.nextInt(10)/4 == 0) {
			this.live += 40;
			return true;
		}
		return false;
	}

	@Override
	public char getMonsterMark() {
		return this.MONSTERMARK;
	}

	public ArrayList<Pet> getPredatorPets() {
		return AlienPets;
	}
	
	public Pet getLastPredatorPet() {
		return AlienPets.get(AlienPets.size()-1);
	}

	public void addPredatorPet() {
		AlienPets.add(new Pet(this.MONSTERMARK));
	}

	public void petSearch(StringBuilder map) {
		for (Pet pet : AlienPets) {
			pet.Move(map);
		}
		
	}
}
