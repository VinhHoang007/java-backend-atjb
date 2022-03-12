package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Employee;
import model.bo.EmployeeBO;

public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeBO empBO = new EmployeeBO();
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		listEmp = empBO.getEmployeeList();

		ArrayList<Employee> listInfor = new ArrayList<Employee>();
		String value = request.getParameter("search-infor");
		if (value == "") {
			listInfor = listEmp;
		} else {
			String field = request.getParameter("field");

			if (field.equalsIgnoreCase("name")) {
				for (Employee employee : listEmp) {
					if (employee.getLastName().equalsIgnoreCase(value)) {
						listInfor.add(employee);
					}
				}
			} else {
				for (Employee employee : listEmp) {
					if (employee.getPhone().equalsIgnoreCase(value)) {
						listInfor.add(employee);
					}
				}
			}
			if (listInfor.size() == 0) {
				request.setAttribute("nodata", "Database connection error");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/employeelist.jsp");
				dispatcher.forward(request, response);
			}
		}

		request.setAttribute("listEmployee", listInfor);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/employeelist.jsp");
		dispatcher.forward(request, response);

	}

}
