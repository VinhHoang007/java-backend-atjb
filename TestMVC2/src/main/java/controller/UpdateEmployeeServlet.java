package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
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
		String id = request.getParameter("id_up");
		EmployeeBO empBo = new EmployeeBO();
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String deptName = request.getParameter("department");
		String remark = request.getParameter("remark");

		Employee emp = new Employee();
		emp.setEmployeeID(Integer.parseInt(id));
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setPhone(phone);
		emp.setDob(LocalDate.parse(dob));
		emp.setGender(Integer.parseInt(gender));
		emp.setAddress(address);
		emp.setDeptName(deptName);
		emp.setRemark(remark);

		empBo.updateEmp(emp);

		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		listEmp = empBo.getEmployeeList();

		request.setAttribute("listEmployee", listEmp);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/employeelist.jsp");
		dispatcher.forward(request, response);
	}

}
