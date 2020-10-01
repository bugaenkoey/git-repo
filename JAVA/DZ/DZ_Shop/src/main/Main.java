package main;

import java.sql.SQLException;

import java.util.Scanner;
import java.util.*;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String nameDB = "shops";
		// SET @@global.time_zone = '+00:00';
		ConectDB conn = new ConectDB(nameDB);
//Создаем три таблици для магазина
		// Таблица магазины
		Shop shop = new Shop(nameDB);
		conn.statement.execute(shop.cre);
		// Таблица отделы
		Departments departments = new Departments(nameDB);
		conn.statement.execute(departments.cre);
		// Таблица продавци
		Worker worker = new Worker(nameDB);
		conn.statement.execute(worker.cre);

		shop.valueCreateInsetr("epicentr", "supermarket");
		departments.valueCreateInsetr("santekhnika", "umyvalniki", 1);
		departments.valueCreateInsetr("avtotovary", "masla", 1);
		worker.valueCreateInsetr("ivan", "ivanov", "1980-01-10", 1, 10000);
		worker.valueCreateInsetr("petro", "petrov", "1990-10-01", 1, 10000);
		worker.valueCreateInsetr("pavlo", "pavlov", "2010-02-28", 2, 8000);
		worker.valueCreateInsetr("vasa", "vasechkin", "2020-02-29", 2, 8000);

		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Для выхода нажмите -\t\tq\n" + "Для операций с магазином -\ts\n"
					+ "Для операций с отделами -\td\n" + "Для операций с продавцами - \tw");

			switch (scan.nextLine()) {
			case "q": {
				scan.close();
				System.exit(0);
			}
				break;
			case "s": {
				System.out.println("*** МАГАЗИНЫ ***\nДля выхода нажмите -\tq\n" + "Для просмотра -\t\tv\n"
						+ "Для добавления -\ti\n" + "Для удаления -\t\td\n");
				switch (scan.nextLine()) {
				case "q": {
					break;
				}
				case "v": {
					System.out.println(shop.getAll());
				}
					break;
				case "i": {
					shop.addInsert();
				}
					break;
				case "d": {
//					shop.delID();
					System.out.println("id ");
					shop.delID(scan.nextInt());
				}
					break;
				}
			}
				break;
			case "d": {
				System.out.println("*** ОТДЕЛЫ ***\nДля выхода нажмите -\tq\n" + "Для просмотра -\t\tv\n"
						+ "Для добавления -\ti\n" + "Для удаления -\t\td\n");
				switch (scan.nextLine()) {
				case "q": {
					break;
				}
				case "v": {
					System.out.println(departments.getAll());
				}
					break;
				case "i": {
					departments.addInsert();
				}
					break;
				case "d": {
					// departments.delID();
					System.out.println("id ");
					departments.delID(scan.nextInt());

				}
					break;
				}
			}
				break;
			case "w": {
				System.out.println("*** ПРОДАВЦИ ***\nДля выхода нажмите -\tq\n" + "Для просмотра -\t\tv\n"
						+ "Для добавления -\ti\n" + "Для удаления -\t\td\n");
				switch (scan.nextLine()) {
				case "q": {
					break;
				}
				case "v": {
					System.out.println(worker.getAll());
				}
					break;
				case "i": {
					worker.addInsert();
				}
					break;
				case "d": {
					System.out.println("id ");
					worker.delID(scan.nextInt());
				}
					break;
				}
			}
				break;
			default:
				break;
			}
		}
	}

}
