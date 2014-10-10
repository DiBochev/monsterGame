package monserGame;

public class Main {

	public static void main(String[] args) {
		Predator predator = new Predator();
		Alien alien = new Alien();
		Map map = new Map();
		
		map.setCurrentPosition(predator.generateNewCurrentPosition(), predator.getMonsterMark());
		map.setCurrentPosition(alien.generateNewCurrentPosition(), alien.getMonsterMark());
		map.showCurrentMap();
		System.out.println("next step");
		
		while (true){
			System.out.println(predator.getUsedPositionsRow() + "" + predator.getUsedPositionsCol());
			map.setUsedPosition(predator.getCurrentPosition());
			map.setUsedPosition(alien.getCurrentPosition());
			
			map.setCurrentPosition(predator.generateNewCurrentPosition(), predator.getMonsterMark());
			map.setCurrentPosition(alien.generateNewCurrentPosition(), alien.getMonsterMark());
			map.showCurrentMap();
			System.out.println("next step");
			if(map.AreMonstersTogether(predator.getUsedPositionsRow(), predator.getUsedPositionsCol(), alien.getUsedPositionsRow(), alien.getUsedPositionsCol())){
				map.showCurrentMap();
				break;
			}
		}
	}

}
