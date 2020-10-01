package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Departments extends ConectDB {
	public Departments(String dbName) throws ClassNotFoundException, SQLException {
		super(dbName);
		this.dbName = dbName;
	}

	int id;
	int shopsId;
	String name;
	String type;
	String iner;
	String dbName;
	String tableName = "departments";
	String inValue = "name, type, shopsId";
	ResultSet resultSet = null;

	String cre = "create table if not exists " + tableName + " (" + "id integer primary key auto_increment, "
			+ "name varchar(100), " + "type varchar(100)," + "shopsId int,"
			+ " FOREIGN KEY (shopsId)  REFERENCES shops (Id) );";

	ConectDB conn = new ConectDB("shops");
	ArrayList<String> tableList = new ArrayList<>();

	void insert(String value) throws SQLException {
		statement.execute("insert into " + tableName + " ( "+inValue+") values(" + value + ")");
	}

	void valueCreateInsetr(String name, String type, int id) throws SQLException {
		String value = "'" + name + "','" + type + "','" + id + "'";
		this.insert(value);
	}

	public void addInsert() {
		String ins = "";
		String nameValue = "name, type, shopsId";
		Scanner scan = new Scanner(System.in);
		String value = "";

		System.out.println(" name ");
		value = "'" + scan.nextLine() + "'";

		System.out.println(" type ");
		value += ",'" + scan.nextLine() + "'";

		System.out.println(" shopsId ");
		value += ",'" + scan.nextInt() + "'";
		ins = "insert into " + tableName + " (" + nameValue + ") values(" + value + ")";
		System.out.println(ins);
		try {
			statement.execute(ins);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}

	void delID(int id) {
		try {
			statement.execute("DELETE FROM " + tableName + "\r\n" + "WHERE id =" + id + " ;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAll() {

		ResultSet resultSet = null;
		try {
			resultSet = conn.getSelectQuery("select * from " + tableName);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// Проходим по куче
		try {
			while (resultSet.next()) {
				this.setId(resultSet.getInt("id"));
				this.setShopsId(resultSet.getInt("shopsId"));
				this.setName(resultSet.getString("name"));
				this.setType(resultSet.getString("type"));

				tableList.add(toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getShopsId() {
		return shopsId;
	}

	public void setShopsId(int shopsId) {
		this.shopsId = shopsId;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", shopsId=" + shopsId + ", name=" + name + ", type=" + type + ", dbName="
				+ dbName + ", tableName=" + tableName + "]\n";
	}

}
