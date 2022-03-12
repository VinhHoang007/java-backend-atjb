package model.bo;

import java.util.ArrayList;

import model.bean.Employee;
import modeldao.EmployeeDAO;

public class EmployeeBO {
	public ArrayList<Employee> getEmployeeList(){
		ArrayList<Employee> lstEmp = new ArrayList<Employee>();
		EmployeeDAO empDao = new EmployeeDAO();
		lstEmp = empDao.getEmployee();
		
		return lstEmp;
	}
	
	public String getNameByAccount(String account) {
		EmployeeDAO empDao = new EmployeeDAO();
		Employee emp = empDao.getEmployeeByAccount(account);
		return emp.getFirstName() +" " + emp.getLastName();
	}
	
	public Employee getEmpByID(int id) {
		EmployeeDAO empDao = new EmployeeDAO();
		return empDao.getEmployeeByID(id);
		
	}
	
	public void insertEmp(Employee emp) {
		EmployeeDAO empDao = new EmployeeDAO();
		empDao.insertEmp(emp);
		
	}
	
	public void updateEmp(Employee emp) {
		EmployeeDAO empDao = new EmployeeDAO();
		empDao.updateEmp(emp);
		
	}
	
	public void deleteEmp(int id) {
		EmployeeDAO empDao = new EmployeeDAO();
		empDao.deleteEmp(id);
		
	}
}
