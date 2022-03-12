package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.EmployeeBO;

public class UpdateDeleteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBO em = new EmployeeBO();
		String id = request.getParameter("id");
	
		request.setAttribute("employee", em.getEmpByID(Integer.parseInt(id)));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/delete_update.jsp");
		dispatcher.forward(request, response);
	}


}
