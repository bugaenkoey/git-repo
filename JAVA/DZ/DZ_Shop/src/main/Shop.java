package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop extends ConectDB {
	public Shop(String dbName) throws ClassNotFoundException, SQLException {
		super(dbName);
		this.dbName = dbName;
	}

	int id;
	String name;
	String type;
	String iner;
	String dbName;
	String tableName = "shops";
	String inValue = "name, type";

	ResultSet resultSet = null;

	String cre = "create table if not exists " + tableName + " (" + "id integer primary key auto_increment, "
			+ "name varchar(100), " + "type varchar(100));";
	ArrayList<String> tableList = new ArrayList<>();

	ConectDB conn = new ConectDB("shops");

	void delID(int id) {
		try {
			statement.execute("DELETE FROM " + tableName + "\r\n" + "WHERE id =" + id + " ;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insert(String value) throws SQLException {
		statement.execute("insert into " + tableName + " ( " + inValue + ") values(" + value + ")");
	}

	void valueCreateInsetr(String name, String type) throws SQLException {
		String value = "'" + name + "','" + type + "'";
		this.insert(value);
	}

	public void addInsert() {
		Scanner scan = new Scanner(System.in);
		String str;
		String ins;
		String values = "";
		System.out.println(" name ");
		str = scan.nextLine();
		setName(str);

		System.out.println(" type ");
		str = scan.nextLine();
		setType(str);

		values = " '" + getName() + "', '" + getType() + "'";
		ins = "insert into " + tableName + " ( name, type) values(" + values + ")";
//		ins = "insert into shops ( name, type) values(" + values + ")";
		System.out.println(ins);
		try {
			statement.execute(ins);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
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
				this.setName(resultSet.getString("name"));
				this.setType(resultSet.getString("type"));
				tableList.add(toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", type=" + type + "]\n";
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
}
