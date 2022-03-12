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


public class ListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	this.executeServlet(request, response);
    	
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.executeServlet(request, response);
	}
	
	private void executeServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeBO empBO = new EmployeeBO();

    	ArrayList<Employee> listEmp = new ArrayList<Employee>();

		listEmp = empBO.getEmployeeList();

		request.setAttribute("listEmployee", listEmp);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/employeelist.jsp");
		dispatcher.forward(request, response);
	}
    
    

}
