package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectDB {
	static Connection conn;
	Statement statement;

	public ConectDB(String dbName) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:	//localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=	utf-8";
		ConectDB.conn = DriverManager.getConnection(url, "root", "admin");
		statement = conn.createStatement();
	}

	public ResultSet getSelectQuery(String sql/*, Connection conn*/) throws SQLException {
		Statement comm = null;
		ResultSet set = null;
		comm = (Statement) conn.createStatement();
		set = comm.executeQuery(sql);
		return set;
	}
}
