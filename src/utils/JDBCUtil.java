package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	private Connection con = null;
	private String nameDatabase,user,password;
	public JDBCUtil(String nameDatabase,String user,String password) {
		this.nameDatabase = nameDatabase;
		this.user = user;
		this.password = password;
	}
	
	public void connectDB() {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
			        + "databaseName="+nameDatabase
			        + ";user="+user
			        + ";password="+password+";encrypt=true;trustServerCertificate=true;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() {
		
		return con;
	}

	public void setConnect(Connection con) {
		this.con = con;
	}

	public void closeConnection() {
		try {
			if(con!=null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public ResultSet getQuery(String query) {
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	
}
