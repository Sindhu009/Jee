package jdbcConectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;


public class CustemerInsrtRow {
	
			public static void main(String[] args) {

				ArrayList<Custemers> custemers= new ArrayList<Custemers>();
				custemers.add(new Custemers("bin", 24, "magadi"));
				custemers.add(new Custemers("san",23, "magadi"));
				custemers.add(new Custemers("suchi", 25, "banglore"));

				for(Custemers cust : custemers ) {
					insertRow(cust);
				}
			}

			private static void insertRow(Custemers custemers) {
				String name  = custemers.getName();
				int age = custemers.getAge();
				String adress= custemers.getAdress() ;

				String sqlQuery = "insert into custemers values("+name+", '"+age+"', "+adress+")";

				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers",
								"root", "root");
					Statement stmt = conn.createStatement();
					){

					int result = stmt.executeUpdate(sqlQuery);  //Updating, insert, delete rows
					System.out.println("The no of rows insert is : "+ result);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
