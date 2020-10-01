package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worker extends ConectDB {
	public Worker(String dbName) throws ClassNotFoundException, SQLException {
		super(dbName);
		this.dbName = dbName;
	}

	String cre = "create table if not exists workers (" + "id integer primary key auto_increment, "
			+ "name varchar(100), " + "surname varchar(100), "
			// + "birthday varchar(100), "
			+ "birthday DATE, " + "departmentId int, " + "salary int,"
			+ " FOREIGN KEY (departmentId)  REFERENCES Departments (Id) );";
	String dbName;
	String tableName = "workers";

	int id;
	int departmentId;
	String name;
	String surname;
	String birthday;
	int salary;
	String inValue ="name, surname,birthday,departmentId,salary";

	String regular = "^(?:(?:(?:(?:(?:[13579][26]|[2468][048])00)|(?:[0-9]{2}(?:(?:[13579][26])|(?:[2468][048]|0[48]))))-(?:(?:(?:09|04|06|11)-(?:0[1-9]|1[0-9]|2[0-9]|30))|(?:(?:01|03|05|07|08|10|12)-(?:0[1-9]|1[0-9]|2[0-9]|3[01]))|(?:02-(?:0[1-9]|1[0-9]|2[0-9]))))|(?:[0-9]{4}-(?:(?:(?:09|04|06|11)-(?:0[1-9]|1[0-9]|2[0-9]|30))|(?:(?:01|03|05|07|08|10|12)-(?:0[1-9]|1[0-9]|2[0-9]|3[01]))|(?:02-(?:[01][0-9]|2[0-8])))))$";

	ConectDB conn = new ConectDB("shops");
	ArrayList<String> tableList = new ArrayList<>();

	String nameValue = "name, surname,birthday,departmentId,salary";
		

	void insert(String value) throws SQLException {
		statement.execute("insert into " + tableName + " ( "+inValue+") values(" + value + ")");
	}

	void valueCreateInsetr(String name, String surname,String birthday,int departmentId,int salary) throws SQLException {
		if(! birthday.matches(regular)) {
		System.out.println("no correct data");
			return ;
		}

		String value = "'" + name + "','" + surname + "','" + birthday+"','" + departmentId + "','" + salary + "'";
		this.insert(value);
	}
	
	public ArrayList<String> getAll() {
		ResultSet resultSet = null;
		try {
			resultSet = conn.getSelectQuery("select * from " + tableName);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ѕроходим по куче
		try {
			while (resultSet.next()) {
				this.setId(resultSet.getInt("id"));
				this.setName(resultSet.getString("name"));
				this.setSurname(resultSet.getString("surname"));
				this.setBirthday(resultSet.getString("birthday"));
				this.setDepartmentId(resultSet.getInt("departmentId"));
				this.setSalary(resultSet.getInt("salary"));				

				tableList.add(toString());
//				System.out.println(tableList.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
	
	void addInsert() {
	//	String nameValue = "name, surname,birthday,departmentId,salary";
		Scanner scan = new Scanner(System.in);
		String value;

		System.out.println(" name ");
		value = "'" + scan.nextLine() + "'";
//		setName(value);

		System.out.println(" surname ");
		value += ",'" + scan.nextLine() + "'";
		boolean b = true;
		String data;
		do {
			data = "";
			System.out.println("birthday DATE - format YYYY-MM-DD");
			System.out.println("¬ведите год");
			data += scan.nextLine() + "-";
			System.out.println("¬ведите мес€ц");
			data += scan.nextLine() + "-";
			System.out.println("¬ведите день");
			data += scan.nextLine();
			b = data.matches(regular);
			System.out.println(b);
		} while (!b);

		value += ",'" + data + "'";

		System.out.println(" departmentId ");
		value += ",'" + scan.nextLine() + "'";

		System.out.println(" salary ");
		value += ",'" + scan.nextLine() + "'";
		String insertes = "insert into " + tableName 
				+ " (" + nameValue + ") values(" + value + ")";
		try {
			statement.execute(insertes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}

	void delID(int id) {
		try {
			statement.execute("DELETE FROM " + tableName 
					+ "\r\n" + "WHERE id =" + id + " ;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [dbName=" + dbName + ", tableName=" + tableName + ", id=" + id + ", departmentId=" + departmentId
				+ ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", salary=" + salary + "]\n";
	}

}
