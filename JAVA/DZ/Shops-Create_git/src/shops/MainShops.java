package shops;

import java.sql.SQLException;
import java.util.Scanner;

public class MainShops {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(
					"��� ������ ������� - \tQ"+
			"\n��� �������� �������� ������� -\tS"+
			"\n��� ��������� - \tV"
			+"\n��� ��������� � id- \ti\n ");
			switch (scan.nextLine()) {
			case "q": {
				scan.close();
				System.exit(0);
			}
			break;
			case "s": {
				String dbName = "shops";
				String tableName ="shop";
				new Shop(dbName, tableName);
			}
			break;
			
			default:
				break;

			}
		}
	}

}
