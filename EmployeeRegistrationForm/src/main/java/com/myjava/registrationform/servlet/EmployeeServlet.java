package com.myjava.registrationform.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.myjava.registrationform.database.EmployeeDao;
import com.myjava.registrationform.javabean.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/registrationform.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = new Employee();

		employee.setFirstName(request.getParameter("firstName").trim());
		employee.setLastName(request.getParameter("lastName").trim());
		employee.setUserName(request.getParameter("userName").trim());
		employee.setPassword(request.getParameter("password").trim());
		employee.setMobileNumber(request.getParameter("mobileNumber"));
		employee.setAddress(request.getParameter("address"));

		try {
			employeeDao.registerEmployee(employee);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/afterregister.jsp");
		dispatcher.forward(request, response);
	}

}