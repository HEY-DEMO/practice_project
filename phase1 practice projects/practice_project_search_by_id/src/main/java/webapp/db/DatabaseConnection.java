package webapp.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is for DatabaseConnection.
 * 
 */
public class DatabaseConnection {

	// data source properties
	private final String DB_URL = "jdbc:mysql://localhost:3306/online_store";
	private final String DB_USR = "root";
	private final String DB_PAS = "6300926793";

	Connection connection = null;
	Statement statment = null;
	ResultSet rst = null;
	PreparedStatement prstm = null;
	CallableStatement callstm = null;

	/**
	 * This method initialize connection.
	 * 
	 * @return connection.
	 */
	public Connection init() {
		try {
			// step1 : Register Driver (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Register Driver class.");

			// step2 : Create a connection
			connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PAS);
			System.out.println("2. Connection is created.");

		} catch (ClassNotFoundException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		}
		return connection;
	}
	public ResultSet executeQuery(String query) {
		try {
			// step3 : Create a statement
			statment = connection.createStatement();
			System.out.println("3. Statement is created.");

			rst = statment.executeQuery(query);
			System.out.println("4. Execute Query.");

		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
			// e.printStackTrace();
		}
		return rst;
	}

	/**
	 * Closed the connection.
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Exception Occured ::: " + e.getClass());
		}
	}
}

	
