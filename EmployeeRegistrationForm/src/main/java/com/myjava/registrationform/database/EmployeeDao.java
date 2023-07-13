package com.myjava.registrationform.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myjava.registrationform.connection.DatabaseConnector;
import com.myjava.registrationform.javabean.Employee;

/**
 * @author Kartik Panchal
 * @desc use {@code EmployeeDao} for data transaction in database
 */
public class EmployeeDao {

	Connection connection = null;

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_SQL = "INSERT INTO employee_details" + 
			" (emp_first_name, emp_last_name, emp_user_name, emp_password, emp_address, emp_mobile_number) VALUES " +
			"(?,?,?,?,?,?);";

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

		} catch (SQLException e) {
			printSQLException(e);
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return rowCount;
	}

	private void printSQLException(SQLException exe) {
		for (Throwable e1: exe) {
			if (e1 instanceof SQLException) {
				e1.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e1).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e1).getErrorCode());
				System.err.println("Message: " + e1.getMessage());
				Throwable t = e1.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}