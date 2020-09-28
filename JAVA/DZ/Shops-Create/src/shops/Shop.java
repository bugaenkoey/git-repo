package shops;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Shop extends TableFactory<Object> {

	DbManager db;
	Connection conn;
	Statement statement;

	Shop(String dbName, String tableName) throws SQLException {
		this.db = new DbManager("localhost:3306", "root", "admin", dbName);
		this.conn = db.connect();
		this.statement = conn.createStatement();

//	Shop(String dbName, String tableName) throws SQLException {
//		super(dbName);
		statement.execute("create table if not exists " + tableName + "(" 
		+ "id integer primary key auto_increment, "
		+ "name varchar(100), " 
		+ "type varchar(100));");

	}
//	Shop() {
//
//	}

	@Override
	public ArrayList<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> getNameTable(String nameTable) {
		// TODO Auto-generated method stub
		String sel = "select * from" + nameTable;
		ArrayList<Object> shop = new ArrayList<Object>();
		return null;
	}

	@Override
	public void addInsert(Object shop) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSelect(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
