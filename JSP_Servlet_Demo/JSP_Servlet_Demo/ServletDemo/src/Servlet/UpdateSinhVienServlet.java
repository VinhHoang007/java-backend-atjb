package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSinhVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String name = request.getParameter("name");
		 System.out.println(name);
		 //Xu ly database
		 
		 SinhVien sv = new SinhVien(name, 18);
		 
		 request.setAttribute("sinhvien", sv);
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/update.jsp");
		 dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Goi database kiem tra co ton tai username password khong
		if ("hieuvt8".equals(userName) && "hieuvt8".equals(password)) {
			String contextPath = request.getContextPath();
			System.out.println(contextPath);
			response.sendRedirect(contextPath + "/danh_sach_sinh_vien");
		} else {
			request.setAttribute("loginMessage", "Dang nhap khong thanh cong");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
