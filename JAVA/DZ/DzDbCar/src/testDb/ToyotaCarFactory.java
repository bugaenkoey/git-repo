package testDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//@SuppressWarnings("unused")
public class ToyotaCarFactory extends CarFactory<ToyotaCar> {
	DbManager db;
	Connection conn;
	Statement statement;

	ToyotaCarFactory() throws SQLException {
		this.db = new DbManager("localhost:3306", "root", "admin", "car");
		this.conn = db.connect();
		this.statement = conn.createStatement();

		statement.execute("create table if not exists ToyotaCar(" + "id integer primary key auto_increment, "
				+ "carId varchar(100), " + "model varchar(100), " + "yearManufacture varchar(100), "
				+ "colour varchar(100), " + "price varchar(100), " + "registrationNumber varchar(100));");

	}

	@Override
	public ArrayList<ToyotaCar> getAll() {
		String sel = "select * from ToyotaCar";

		ArrayList<ToyotaCar> toyotaS = new ArrayList<>();

		ResultSet resultSet = null;
		resultSet = db.getSelectQuery(sel, conn);
		// Проходим по куче
		try {
			while (resultSet.next()) {
				// Создаем студентов
				ToyotaCar toyota = new ToyotaCar();
				// Инициализируем поля
				// String id, model, yearManufacture, colour, price, registrationNumber;

				toyota.setId(resultSet.getInt("id"));
				toyota.setCarId(resultSet.getString("carId"));
				toyota.setModel(resultSet.getString("model"));
				toyota.setYearManufacture(resultSet.getString("yearManufacture"));
				toyota.setColour(resultSet.getString("colour"));
				toyota.setPrice(resultSet.getString("price"));
				toyota.setRegistrationNumber(resultSet.getString("registrationNumber"));
				// Заносим в колекцию
				toyotaS.add(toyota);
//					System.out.println(mersS.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toyotaS;
	}

	@Override
	public ToyotaCar getCarById(int id) {

		String sel = "select * from ToyotaCar WHERE id=" + id;
		ResultSet resultSet = null;
		resultSet = db.getSelectQuery(sel, conn);
		ToyotaCar mers = new ToyotaCar();
		// Инициализируем поля
		// String id, carId, model, yearManufacture, colour, price, registrationNumber;
		try {
			resultSet.next();
			mers.setId(resultSet.getInt("id"));
			mers.setCarId(resultSet.getString("carId"));
			mers.setModel(resultSet.getString("model"));
			mers.setYearManufacture(resultSet.getString("yearManufacture"));
			mers.setColour(resultSet.getString("colour"));
			mers.setPrice(resultSet.getString("price"));
			mers.setRegistrationNumber(resultSet.getString("registrationNumber"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//			System.out.println(mers);
		return mers;
	}

	@Override
	public void addCar(ToyotaCar car) {
		Scanner scan = new Scanner(System.in);
		String str;

		System.out.println(" model ");
		str = scan.nextLine();
		car.setModel(str);

		System.out.println(" yearManufacture ");
		str = scan.nextLine();
		car.setYearManufacture(str);

		System.out.println(" colour ");
		str = scan.nextLine();
		car.setColour(str);

		System.out.println(" price ");
		str = scan.nextLine();
		car.setPrice(str);

		System.out.println(" registrationNumber ");
		str = scan.nextLine();
		car.setRegistrationNumber(str);

		car.setCarId(car.getRegistrationNumber() + "@" + car.getModel());// ToyotaCar RegistrationNumber + Model

		System.out.println(car);

		String values = " '" + car.getCarId() + "', '" + car.getModel() + "',' " + car.getYearManufacture() + "', '"
				+ car.getColour() + "',' " + car.getPrice() + "', '" + car.getRegistrationNumber() + "'";
		String insert = "insert into ToyotaCar(carId, model, yearManufacture, colour, price, registrationNumber) values("
				+ values + ")";
		try {
			statement.execute(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
	}

}
