package testDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//@SuppressWarnings("unused")
public class MercedesCarFactory extends CarFactory<MercedesCar> {
	DbManager db;
	Connection conn;
	Statement statement;

	MercedesCarFactory() throws SQLException {
		this.db = new DbManager("localhost:3306", "root", "admin", "car");
		this.conn = db.connect();
		this.statement = conn.createStatement();

		statement.execute("create table if not exists MercedesCars(" + "id integer primary key auto_increment, "
				+ "carId varchar(100), " + "model varchar(100), " + "yearManufacture varchar(100), "
				+ "colour varchar(100), " + "price varchar(100), " + "registrationNumber varchar(100));");

	}

	@Override
	public ArrayList<MercedesCar> getAll() {
		String sel = "select * from mercedescars";

		ArrayList<MercedesCar> mersS = new ArrayList<>();

		ResultSet resultSet = null;
		resultSet = db.getSelectQuery(sel, conn);
		// Проходим по куче
		try {
			while (resultSet.next()) {

				MercedesCar mers = new MercedesCar();
				// Инициализируем поля
				// String id, model, yearManufacture, colour, price, registrationNumber;

				mers.setId(resultSet.getInt("id"));
				mers.setCarId(resultSet.getString("carId"));
				mers.setModel(resultSet.getString("model"));
				mers.setYearManufacture(resultSet.getString("yearManufacture"));
				mers.setColour(resultSet.getString("colour"));
				mers.setPrice(resultSet.getString("price"));
				mers.setRegistrationNumber(resultSet.getString("registrationNumber"));
				// Заносим в колекцию
				mersS.add(mers);
//				System.out.println(mersS.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mersS;
	}

	@Override
	public MercedesCar getCarById(int id) {

		String sel = "select * from mercedescars WHERE id=" + id;
		ResultSet resultSet = null;
		resultSet = db.getSelectQuery(sel, conn);
		MercedesCar mers = new MercedesCar();
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

//		System.out.println(mers);
		return mers;
	}

	@Override
	public void addCar(MercedesCar car) {
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

		car.setCarId(car.getRegistrationNumber() + "@" + car.getYearManufacture());

		System.out.println(car);

		String values = " '" + car.getCarId() + "', '" + car.getModel() + "',' " + car.getYearManufacture() + "', '"
				+ car.getColour() + "',' " + car.getPrice() + "', '" + car.getRegistrationNumber() + "'";
		String insert = "insert into mercedescars(carId, model, yearManufacture, colour, price, registrationNumber) values("
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
