package monserGame;

public class Main {

	public static void main(String[] args) {
		Predator predator = new Predator();
		Alien alien = new Alien();
		Map map = new Map();
		map.showCurrentMap();
		System.out.println("next step");
		while(true){
		monsterStep(predator, alien, map);
		
		//show map and monsters current position
		map.showCurrentMap();
		
		// fight
		if(map.AreMonstersTogether(predator.getCurrentPosition(), alien.getCurrentPosition())){
			fight(predator, alien);
			break;
		}
		System.out.println("next step");
		
		map.setUsedPosition(predator.getCurrentPosition());
		map.setUsedPosition(alien.getCurrentPosition());
		}
	}

	private static void monsterStep(Predator predator, Alien alien, Map map) {
		//predator step
		do{
			predator.generateNewCurrentPosition();
		}while(map.CheckIsFreePosition(predator.getCurrentPosition()));
		map.setCurrentPosition(predator.getCurrentPosition(), predator.getMonsterMark());
		
		//alien step
		do{
			alien.generateNewCurrentPosition();
		}while(map.CheckIsFreePosition(alien.getCurrentPosition()));
		map.setCurrentPosition(alien.getCurrentPosition(), alien.getMonsterMark());
	}

	private static void fight(Predator predator, Alien alien) {
		while (true) {
			alien.hit(predator.getDamage());
			System.out.println("Predator attacked Alien, Alien has: " + alien.getLife() + " live");
			predator.hit(alien.getDamage());
			System.out.println("Alien attacked Predator, Predator has: " + predator.getLife() + " live");
			if(predator.getLife() <= 0){
				System.out.println("Predator is dead, Alien has "+ alien.getLife() + " live");
				break;
			}
			if(alien.getLife() <= 0){
				System.out.println("Alien is dead, Predator has "+ predator.getLife() + " live");
				break;
			}
			if(predator.heal()){
				System.err.println("Predator eat smth and now has: " + predator.getLife() + " live");
			}
			if(alien.heal()){
			System.err.println("Alien eat smth and now has: " + alien.getLife() + " live");
			}
		}
	}
	
}
