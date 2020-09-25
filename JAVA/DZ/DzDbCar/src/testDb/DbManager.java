package testDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbManager {
	private String host; // server address
	private String user; // user name
	private String pass; // user password
	private String dbName; // DB name
	private Connection conn; // connection object

	public DbManager(String host, String user, String pass, String dbName) {
		this.conn = null;
		this.host = host;
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
		try {
			// driver registration
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Connection connect() {
		String url = "jdbc:mysql:	//" + this.host + "/" + this.dbName 
				+ "?useUnicode=true&characterEncoding=	utf-8";
		try {
			this.conn = DriverManager.getConnection(url, this.user, this.pass);
			return this.conn;
		} catch (SQLException ex) {
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public ResultSet getSelectQuery(String sql, Connection conn) {
		Statement comm = null;
		ResultSet set = null;
		try {
			comm = (Statement) conn.createStatement();
			set = comm.executeQuery(sql);
		} catch (SQLException ex) {
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		return set;
	}
}
