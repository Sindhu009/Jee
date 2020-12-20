package jdbcConectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class CustemersRead {
	public static void main(String[] args) {

		String sqlQuery= "Select * from custemers";

		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/20transowd08",
					"root","root");
			Statement stmt=conn.createStatement();
			ResultSet results = stmt.executeQuery(sqlQuery);)
			{
				System.out.println(conn);

				while(results.next()) {
					int id=results.getInt("id");
					String name= results.getString("Name");
					int noOfRooms = results.getInt(3);
				//	double rating = results.getDouble(4);
				//	boolean isRestaurant = results.getBoolean(5);

					System.out.println("id: "+id);
					System.out.println("name: "+name);
					System.out.println("noOfRooms: "+noOfRooms);
				//	System.out.println("rating: "+rating);
				//	System.out.println("isRestaurant: "+isRestaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
