package com.myjava.registrationform.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @category Database Connection
 * @author Kartik Panchal
 *
 */
public class DatabaseConnector {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DatabaseConstant.DRIVER);
			connection = DriverManager.getConnection(DatabaseConstant.DBURL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}