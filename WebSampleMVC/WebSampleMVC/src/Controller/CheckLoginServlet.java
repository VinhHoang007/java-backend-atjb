package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.AccountBO;
import Model.BO.LoginBO;
import Model.Bean.Account;

/**
 * Servlet implementation class CheckLoginServlet
 */
//@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.executeServlet(request, response, "get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//adoGet(request, response);
		
		this.executeServlet(request, response, "post");
	}
	
	
	public void executeServlet(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException{
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		LoginBO loginBO = new LoginBO();
		if(loginBO.CheckLoginBO(userName, password)){
			
			AccountBO accountBO = new AccountBO();
			
			Account account = accountBO.getAccountInfor(userName);
			
			request.setAttribute("account", account);
			
			RequestDispatcher rq = request.getRequestDispatcher("/Welcome.jsp");
			rq.forward(request, response);
		}else{
			response.sendRedirect("./Login.html");
		}
		
		
	}

}
