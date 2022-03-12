package insertData;

import java.time.LocalDate;

import model.bean.Account;
import model.bean.Employee;
import modeldao.AccountDAO;
import modeldao.EmployeeDAO;

public class InsertData {
	public static void insertData() {
		Employee emp1 = new Employee("Nguyen","Van A",1,LocalDate.of(2020, 01, 01),"1111111","Da Nang","IT","aaa");
		Account acc = new Account("Abc","v@gmail.com","123",1,emp1);
		EmployeeDAO empDao = new EmployeeDAO();
		empDao.insertEmp(emp1);
		AccountDAO accDao = new AccountDAO();
		accDao.insertAccount(acc);
	}
	
	
}
