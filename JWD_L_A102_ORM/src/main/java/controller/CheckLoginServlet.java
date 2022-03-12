package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.EmployeeBO;
import model.bo.LoginBO;

public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.executeServlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.executeServlet(request, response);

	}

	private void executeServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeBO empBo = new EmployeeBO();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBO loginBo = new LoginBO();
		if (loginBo.CheckLoginBO(userName, password)) {
					
			String fullName = empBo.getNameByAccount(userName);
			
			session.setAttribute("nameEmployeeLogin", fullName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list_employee");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("loginMessage", "Dang nhap khong thanh cong");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
