package cubedb; //cubedb

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
//import cubedb.FetchAlgs;

public class Db {

	public static void main(String[] args) throws Exception {
		//getConnection();
		setTimezone();
		createTable();
		insertIntoTable();
		System.out.println("finished");
		//FetchAlgs.importAlgs();
	}
	
	public static Connection getConnection() throws Exception { //establishes connection
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/cubedb?useSSL=false&allowPublicKeyRetrieval=true&allowPublicKeyRetrieval=true";
			String username = "sam";
			String password = "dbpassword";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return con;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void setTimezone() throws Exception { //sets timezone
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("SET @@global.time_zone = '+00:00'");
		create.executeUpdate();
	}
	
	public static void createTable() throws Exception { //creates table
		Connection con = getConnection();
		try {
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS algorithms(id int NOT NULL AUTO_INCREMENT, img varchar(255), alg varchar(255), rating int, PRIMARY KEY(id))");
			create.executeUpdate();	
			System.out.println("Table created");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insertIntoTable() throws Exception { //inserts into table
		Connection con = getConnection();
		ArrayList<String> algList = new ArrayList<String>();
		algList = FetchAlgs.importAlgs();
		int j = 0;
		while (j < algList.size()) {
			String var1 = "https://i.imgur.com/ekCeTkF.png";
			String var2 = algList.get(j);
			int var3 = 100;
			try {
				//Connection con = getConnection();
				PreparedStatement create = con.prepareStatement("INSERT INTO algorithms (img, alg, rating) VALUES('"+var1+"', '"+var2+"', '"+var3+"')");
				create.executeUpdate();	
				System.out.println(algList.get(j) + " Inserted");
				j++;
			} catch (Exception e) {
				System.out.println(e);
			} 
		}
	}
}


