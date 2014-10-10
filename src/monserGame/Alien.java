package monserGame;

import java.util.ArrayList;
import java.util.Random;

public class Alien implements IMonster{

	private int live;
	private int damage;
	private int[] position;
	private final String MONSTERMARK = "À";
	private Random randomnNumber;
	private ArrayList<Integer> usedPositionsRow;
	private ArrayList<Integer> usedPositionsCol;
	
	public Alien(){
		this.usedPositionsRow = new ArrayList<Integer>();
		this.usedPositionsCol = new ArrayList<Integer>();
		this.position = new int[2];
		this.live = 200;
		this.damage = 40;
		this.randomnNumber = new Random();
	}
	
	@Override
	public int getLife() {
		return this.live;
	}
	
	@Override
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public int[] getCurrentPosition() {
		return this.position;
	}
	
	@Override
	public void heal() {
		if (randomnNumber.nextInt()/4 == 0) {
			this.live += 60;
		}
	}

	@Override
	public int[] generateNewCurrentPosition() {
		do{
			this.position[0] = randomnNumber.nextInt(10);
			this.position[1] = randomnNumber.nextInt(10);
		}while(checkNewPositions(position));
		
		setUsedPositionsRow(this.position[0]-1);
		setUsedPositionsCol(this.position[1]-1);
		return this.position;
	}
	
	public boolean checkNewPositions(int [] Position){
		if (this.usedPositionsRow.contains(Position[0]) || this.usedPositionsCol.contains(Position[1])) {
			return true;
		}else{
			return false;
		}
	}

	public String getMonsterMark() {
		return MONSTERMARK;
	}
	
	public ArrayList getUsedPositionsRow() {
		return this.usedPositionsRow;
	}

	protected void setUsedPositionsRow(int usedPositionsRow) {
		this.usedPositionsRow.add(usedPositionsRow);
	}

	public ArrayList getUsedPositionsCol() {
		return this.usedPositionsCol;
	}

	protected void setUsedPositionsCol(int usedPositionsCol) {
		this.usedPositionsCol.add(usedPositionsCol);
	}
}
