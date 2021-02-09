import java.sql.*;

public class DatabaseProba {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/dvukelic","dvukelic","11");
			if (con != null) {
				System.out.println("Database is connected");
			}
			
			Statement stmt = null;
			stmt = con.createStatement();

		      String sql = "SELECT id, username, password FROM korisnik";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String user= rs.getString("username");
		         String password= rs.getString("password");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", User: " + user);
		         System.out.print(", Password: " + password);
		      }
		      rs.close();
			
		} catch (Exception e) {
			System.out.println("Database is not connected");
		}
	}
}