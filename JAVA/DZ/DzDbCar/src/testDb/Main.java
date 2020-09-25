package testDb;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

//	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
//		String ch;
		while (true) {
			System.out.println(
					"Для выхода нажмите - \tQ\nДля ввода Мерседесов -\tM\nДля ввода Тойот - \tT\nДля просмотра - \tV\nДля просмотра с id- \ti\n ");
//			ch=null;
//			ch = scan.nextLine();
			switch (scan.nextLine()) {
			case "q": {
				scan.close();
				System.exit(0);
			}

				break;
			case "m": {
				new MercedesCarFactory().addCar(new MercedesCar());

			}

				break;
			case "t": {
				new ToyotaCarFactory().addCar(new ToyotaCar());
			}

				break;
			case "v": {
				MercedesCarFactory mers = new MercedesCarFactory();
				System.out.println(mers.getAll().toString());

				ToyotaCarFactory toyota = new ToyotaCarFactory();
				System.out.println(toyota.getAll().toString());
			}

				break;
			case "i": {
				int id = 1;
				System.out.println(" id ");
				MercedesCarFactory mers = new MercedesCarFactory();
				ToyotaCarFactory toyota = new ToyotaCarFactory();

				id = scan.nextInt();
				System.out.println(mers.getCarById(id).toString());
				System.out.println(toyota.getCarById(id).toString());

			}

				break;

			default:
				break;

			}
		}

	}

}
