package jdbcConectivity;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustemerUpdate {
	public static void main(String[] args) {

		String sqlQuery = "update custemer set age = 23 where id=1";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/custemers",
						"root", "root");
			Statement stmt = conn.createStatement();
			){

			int result = stmt.executeUpdate(sqlQuery);  //Updating rows
			System.out.println("The no of rows updated is : "+ result);

		} catch (SQLException e) {
			e.printStackTrace();
		}



	}


}
