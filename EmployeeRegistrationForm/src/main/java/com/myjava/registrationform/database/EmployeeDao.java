package com.myjava.registrationform.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjava.registrationform.connection.DatabaseConnector;
import com.myjava.registrationform.javabean.Employee;

/**
 * @desc use 'EmployeeDao' class for data transaction in database
 * @author Kartik Panchal
 */
public class EmployeeDao {

	Connection connection = null;

	public int registerEmployee(Employee employee) throws Exception {
		String INSERT_SQL = "INSERT INTO employee_details"
				+ "(emp_first_name, emp_last_name, emp_user_name, emp_password, emp_address, emp_mobile_number) VALUES"
				+ "(?,?,?,?,?,?);";

		int rowCount = 0;
		connection = DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUserName());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setLong(6, employee.getMobileNumber());
			rowCount = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			printException(exception);
		}
		return rowCount;
	}

	private void printException(Exception exception) {
		if (exception instanceof SQLException) {
			exception.printStackTrace(System.err);
			System.err.println("SQLState : " + ((SQLException) exception).getSQLState());
			System.err.println("Error code : " + ((SQLException) exception).getErrorCode());
			System.err.println("Message : " + exception.getMessage());
		} else if (exception instanceof RuntimeException){
			exception.printStackTrace(System.err);
			System.err.println("Message : " + exception.getMessage());
		} else {
			System.err.println("Sorry for inconvenience.");
		}
	}

}