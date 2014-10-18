package monserGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBWriter {
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final static String DB_URL = "jdbc:mysql://localhost/monstergame";
	private final static String USER = "fgg";
	private final static String PASS = "dbpassword";
	private static Connection conn = null;
	private static Statement stmt = null;
	private final static String TABLENAME = "monsters";
	private final static String TABLEVALUES = " (AlienWin, PredatorWin, AlienLive, PredatorLive) Values ";
	
	public static boolean Connect() {
		boolean ifHasConnection = true;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			ifHasConnection = false;
		}
		return ifHasConnection;
	}
	
	public static void ConnectionClose(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void TableInsert(int AlienWin, int PredatorWin, int alienLive, int predatorLive){
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + TABLENAME + TABLEVALUES +"('" + AlienWin + "','" + PredatorWin + "','" + alienLive + "','"+ predatorLive + "');");
		try {
			stmt = conn.createStatement();
	      	stmt.executeUpdate(sb.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DBWrite(int AlienLive, int PredatorLive){
		if(Connect()){
			if( PredatorLive <= 0 && AlienLive > 0){
				TableInsert(1, 0, AlienLive, PredatorLive);
			}else if( AlienLive <= 0 && PredatorLive > 0){
				TableInsert(0, 1, AlienLive, PredatorLive);
			}else if( AlienLive <= 0 && PredatorLive <= 0){
				TableInsert(0, 0, AlienLive, PredatorLive);
			}
		}else{
			try {
				throw new Exception("cant connect to db");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ConnectionClose();
	}

	public static int MonsterWin(String col){
		String sqlRequest = "SELECT SUM(" + col + ")" + "AS " + col + " FROM " + TABLENAME;
		ResultSet resultSet = null;
		int result = 0;
		try{
			resultSet = stmt.executeQuery(sqlRequest);
			if(resultSet.next()) {
				result = (resultSet.getInt(col));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static int NumberOfGames(String col){
		String sqlRequest = "select " + col +" from "  + TABLENAME + " order by " + col + " desc limit 1";
		ResultSet resultSet = null;
		int result = 0;
		try{
			resultSet = stmt.executeQuery(sqlRequest);
			if(resultSet.next()) {
				result = (resultSet.getInt(col));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static String Statistics(){
		int alienWin = 0, predatorWin = 0, numberOfGames = 0;
		if(Connect()){
			alienWin = MonsterWin("alienwin");
			predatorWin = MonsterWin("predatorwin");
			numberOfGames = NumberOfGames("numberofgames");
		}else{
			try {
				throw new Exception("cant connect to db");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ConnectionClose();
		return "Alen wins: " + alienWin + " Predator wins: " + predatorWin + " from " + numberOfGames + " games";
		
	}
}
