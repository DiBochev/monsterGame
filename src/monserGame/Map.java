package monserGame;


public class Map {
	
	private char[][] freePositon;
	private final char FREEPOSITIONMARK = '-';
	private final char USEDPOSITIONMARK = '=';
	private final int MATRIXSIZE = 10;
	
	public Map(){
		freePositon = new char [MATRIXSIZE][MATRIXSIZE];
		for (int i = 0; i <MATRIXSIZE; i++) {
			for (int j = 0; j < MATRIXSIZE; j++) {
				freePositon [i][j] = this.FREEPOSITIONMARK;
			}
		}
	}
	
	public char[][] getFreePositon() {
		return this.freePositon;
	}

	public String showCurrentMap (){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				sb.append(this.freePositon[i][j]);
			}sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	public void setUsedPosition (int[] position) {
		setCurrentPosition(position, this.USEDPOSITIONMARK);
	}
	
	public void setCurrentPosition (int[] position, char monster){
			this.freePositon [position[0]][position[1]] = monster;
	}
	
	public boolean CheckIsFreePosition(int[] position){
		boolean result = true;
		if (this.freePositon [position[0]][position[1]] == this.USEDPOSITIONMARK) {
		}
		else {
			result = false;
		}
		return result;
	}
	
	public boolean AreMonstersTogether(int[] predatorPosition, int[] alienPosition){
		boolean result = false;
		int rowDistance = Math.abs(predatorPosition[0] - alienPosition[0]);
		int colDistance = Math.abs(predatorPosition[1] - alienPosition[1]);
		if (rowDistance == 0 && colDistance == 0) {
			result = true;
		}
		if(rowDistance == 0 && colDistance == 1){
			result = true;
		}
		if (rowDistance == 1 && colDistance == 0) {
			result = true;
		}
		return result;
	}
	
}


