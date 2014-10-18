package monserGame;

public class Main {

	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		Predator predator = new Predator();
		Alien alien = new Alien();
		Map map = new Map();
		ConsoleWriter consoleWriter = new ConsoleWriter();
		output.append(map.showCurrentMap());
		output.append("next step\n");
		while(true){
		monsterStep(predator, alien, map);
		
		//show map and monsters current position
		output.append(map.showCurrentMap());
		
		// fight
		if(map.AreMonstersTogether(predator.getCurrentPosition(), alien.getCurrentPosition())){
			output.append(fight(predator, alien));
			
			break;
		}
		output.append("next step\n");
		
		map.setUsedPosition(predator.getCurrentPosition());
		map.setUsedPosition(alien.getCurrentPosition());
		}
		
		consoleWriter.setPrinter(output);
		consoleWriter.Write();
		DBWriter.DBWrite(alien.getLife(), predator.getLife());
		System.out.println(DBWriter.Statistics());
		
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

	private static String fight(Predator predator, Alien alien) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			//predator attack
			alien.hit(predator.getDamage());
			sb.append("Predator attacked Alien, Alien has: " + alien.getLife() + " live");
			sb.append(System.getProperty("line.separator"));
			if(alien.getLife() <= 0){
				sb.append("Alien is dead, Predator has "+ predator.getLife() + " live");
				sb.append(System.getProperty("line.separator"));
				break;
			}
			//alien attack
			predator.hit(alien.getDamage());
			sb.append("Alien attacked Predator, Predator has: " + predator.getLife() + " live");
			sb.append(System.getProperty("line.separator"));
			if(predator.getLife() <= 0 && alien.getLife() <= 0){
				sb.append("Predator and Alien are dead... MULTIKILL");
				sb.append(System.getProperty("line.separator"));
				break;
			}
			if(predator.getLife() <= 0){
				sb.append("Predator is dead, Alien has "+ alien.getLife() + " live");
				sb.append(System.getProperty("line.separator"));
				break;
			}
			if(predator.heal()){
				sb.append("Predator eat smth and now has: " + predator.getLife() + " live");
				sb.append(System.getProperty("line.separator"));
			}
			if(alien.heal()){
				sb.append("Alien eat smth and now has: " + alien.getLife() + " live");
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}
	
}
