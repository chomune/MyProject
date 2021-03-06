package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) {

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://192.168.3.130","root", "1234");
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			/***********************************************************/
			rs = st.executeQuery("SHOW DATABASES");

			if (st.execute("SHOW DATABASES")) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());

		}
	}

	public static Connection getConnection() throws SQLException{
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://192.168.3.130","root", "1234");
		
		return con;
	}
	
}
