package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DanhSachSinhVienServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
		sinhVienList.add(new SinhVien("Nguyen Van A", 18));
		sinhVienList.add(new SinhVien("Nguyen Van A1", 19));
		sinhVienList.add(new SinhVien("Nguyen Van A2", 20));
		sinhVienList.add(new SinhVien("Nguyen Van A3", 21));
		sinhVienList.add(new SinhVien("Nguyen Van A4", 22));
		
		request.setAttribute("listSinhVien", sinhVienList);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DanhSachSinhVien.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	} 
}
