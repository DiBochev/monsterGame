package monserGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Writer {
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final static String DB_URL = "jdbc:mysql://localhost/monstergame";
	private final static String USER = "fgg";
	private final static String PASS = "dbpassword";
	private static Connection conn = null;
	private static Statement stmt = null;
	private final static String TABLENAME = "monsters";
	private final static String TABLEVALUES = " (AlienWin, PredatorWin, AlienLive, PredatorLive) Values ";
	private StringBuilder printer;
	
	Writer(){
		printer = new StringBuilder();
	}
	
	public void ConseleWrter(){
		System.out.println(this.printer.toString());
	}

	public StringBuilder getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer.append(printer);
	}
	
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
	
	public void DBWriter(int AlienLive, int PredatorLive){
		if(Connect()){
			if( PredatorLive <= 0 && AlienLive > 0){
				TableInsert(0, 1, AlienLive, PredatorLive);
			}else if( AlienLive <= 0 && PredatorLive > 0){
				TableInsert(1, 0, AlienLive, PredatorLive);
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
	
}
