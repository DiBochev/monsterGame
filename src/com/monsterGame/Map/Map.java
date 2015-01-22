package com.monsterGame.Map;


public class Map {
	
	private char[][] map;
	private final char FREEPOSITIONMARK = '-';
	private final char USEDPOSITIONMARK = '=';
	private int MATRIXSIZE;
	
	public Map(int matrixSize){
		this.MATRIXSIZE = matrixSize;
		map = new char [MATRIXSIZE][MATRIXSIZE];
		for (int i = 0; i < MATRIXSIZE; i++) {
			for (int j = 0; j < MATRIXSIZE; j++) {
				map [i][j] = this.FREEPOSITIONMARK;
			}
		}
	}

	public String getCurrentMap (){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MATRIXSIZE; i++) {
			for (int j = 0; j < MATRIXSIZE; j++) {
				sb.append(this.map[i][j]);
			}sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	public void setUsedPosition (int[] position) {
		setCurrentPosition(position, this.USEDPOSITIONMARK);
	}
	
	public void setCurrentPosition (int[] position, char monster){
			this.map [position[0]][position[1]] = monster;
	}
	
	public boolean CheckIsFreePosition(int[] position){
		if (this.map [position[0]][position[1]] != this.FREEPOSITIONMARK) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean AreMonstersTogether(int[] predatorPosition, int[] alienPosition){
		int rowDistance = Math.abs(predatorPosition[0] - alienPosition[0]);
		int colDistance = Math.abs(predatorPosition[1] - alienPosition[1]);
		if ((rowDistance == 0 && colDistance == 0) || (rowDistance == 0 && colDistance == 1) || (rowDistance == 1 && colDistance == 0)) {
			return true;
		}else{
			return false;
		}
	}
	
}