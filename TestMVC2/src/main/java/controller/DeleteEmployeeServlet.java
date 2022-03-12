package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Employee;
import model.bo.EmployeeBO;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBO empBo = new EmployeeBO();
		String id = request.getParameter("id_del");
		empBo.deleteEmp(Integer.parseInt(id));
		
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		listEmp = empBo.getEmployeeList();
	
		request.setAttribute("listEmployee", listEmp);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/employeelist.jsp");
		dispatcher.forward(request, response);
	}



}
