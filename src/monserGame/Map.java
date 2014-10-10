package monserGame;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Map {
	
	private String[][] freePositon;
	private final String FREEPOSITIONMARK = "-";
	private final String USEDPOSITIONMARK = "=";
	
	Map(){
		freePositon = new String [10][10];
		for (int i = 0; i <10; i++) {
			for (int j = 0; j < 10; j++) {
				freePositon [i][j] = this.FREEPOSITIONMARK;
			}
		}
	}
	
	public String[][] getFreePositon() {
		return this.freePositon;
	}

	public void setFreePositon(int row, int col) {	
		this.freePositon [row][col] = this.USEDPOSITIONMARK;
	}
	
	public void setUsedPosition (int[] Position){
		this.freePositon[Position[0]][Position[1]] = this.USEDPOSITIONMARK;
	}
	
	public void setCurrentPosition (int[] Position, String monster){
		this.freePositon [Position[0]][Position[1]] = monster;
	}
	
	public void showCurrentMap (){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(this.freePositon[i][j]);
			}System.out.println("");
		}
	}
	
	public boolean AreMonstersTogether(ArrayList<Integer> predatorRow, ArrayList<Integer> predatorCol, ArrayList<Integer> alienRow, ArrayList<Integer> alienCol){
		if(Math.abs(predatorRow.get(predatorRow.size()-1) - alienRow.get(alienRow.size()-1)) == 1 || Math.abs(predatorCol.get(predatorCol.size()-1) - alienCol.size()-1) == 1){
			return true;
		}else {
			throw new IllegalArgumentException("INVALID");
		}
	}
}
