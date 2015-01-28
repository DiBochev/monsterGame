package com.monsterGame.Main;

import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.monsterGame.ConsoleWriter.ConsoleWriter;
import com.monsterGame.DBManager.DBManager;
import com.monsterGame.Map.Map;
import com.monsterGame.Monsters.Alien;
import com.monsterGame.Monsters.IMonster;
import com.monsterGame.Monsters.Predator;

public class Main {
	
	private static final int MATRIX_SIZE = 10;
	private static final String NEXT_STEP = "next step\n";
	private static StringBuilder output;
	private static Predator predator;
	private static Alien alien;
	private static Map map;
	
	public static void main(String[] args) {
		output = new StringBuilder();
		predator = new Predator();
		alien = new Alien();
		map = new Map(MATRIX_SIZE);
	
		output.append(map.getCurrentMap() + NEXT_STEP);
		
		while(true){
			monsterMakeStep(predator, map);
			monsterMakeStep(alien, map);
			output.append(map.getCurrentMap());
			// fight
			if(map.AreMonstersTogether(predator.getCurrentPosition(), alien.getCurrentPosition())){
				while (true) {
					if(fight(alien, predator, output) || fight(predator, alien, output)){
						break;
					}
					monsterSpecial(predator);
					monsterSpecial(alien);
				}
				break;
			}
			
			output.append(NEXT_STEP);
			map.setUsedPosition(predator.getCurrentPosition());
			map.setUsedPosition(alien.getCurrentPosition());
		}
		
		ConsoleWriter.Write(output);
		
		DBWrite();
	}
	
	private static void DBWrite(){
		try {
			DBManager.DBWrite(alien.getLife(), predator.getLife());
			System.out.println(DBManager.Statistics());
		} catch (ClassNotFoundException e) {
			ConsoleWriter.Write("cannot find driver!/n cannot connect to DB");
		} catch (PSQLException e) {
			ConsoleWriter.Write("cannot connect to DB\ncreating new table...");
			try {
				DBManager.createNewTable();
				DBWrite();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void monsterSpecial(IMonster monster){
		if(monster.specialAction()){
			output.append(monster.getClass().getSimpleName() + " eat smth and now has: " + monster.getLife() + " live");
			output.append(System.getProperty("line.separator"));
		}
	}

	private static boolean fight(IMonster hittedMonster, IMonster attackingMonster, StringBuilder sb){
		hittedMonster.hit(attackingMonster.getDamage());
		sb.append(attackingMonster.getClass().getSimpleName() + " attacked " + hittedMonster.getClass().getSimpleName() + ", " + hittedMonster.getClass().getSimpleName() + " has: " + hittedMonster.getLife() + " live");
		sb.append(System.getProperty("line.separator"));
		
		if(hittedMonster.getLife() <= 0){
			sb.append(hittedMonster.getClass().getSimpleName() + " is dead, " + attackingMonster.getClass().getSimpleName() + " has "+ attackingMonster.getLife() + " live");
			sb.append(System.getProperty("line.separator"));
			return true;
		}
		
		return false;
	}
	
	private static void monsterMakeStep(IMonster monster, Map map) {
		do{
			monster.generateNewCurrentPosition(MATRIX_SIZE);
		}while(map.CheckIsFreePosition(monster.getCurrentPosition()));
		map.setCurrentPosition(monster.getCurrentPosition(), monster.getMonsterMark());
	}
}