package shops;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import testDb.DbManager;

@SuppressWarnings("hiding")
public abstract class TableFactory<Object> {
//	DbManager db;
//	Connection conn;
//	Statement statement;
//
//	TableFactory(String dbName) throws SQLException {
//		this.db = new DbManager("localhost:3306", "root", "admin", dbName);
//		this.conn = db.connect();
//		this.statement = conn.createStatement();
		
//		statement.execute("create table if not exists "+tableName+"(" + "id integer primary key auto_increment, "
//				+ "carId varchar(100), " + "model varchar(100), " + "yearManufacture varchar(100), "
//				+ "colour varchar(100), " + "price varchar(100), " + "registrationNumber varchar(100));");

//	}
	
//	public int level;
	public abstract ArrayList<Object> getAll();

	public abstract ArrayList<Object> getNameTable(String nameTable);

	public abstract void addInsert(Object shop);

	public abstract Object getSelect(int id);

//	public abstract 
}