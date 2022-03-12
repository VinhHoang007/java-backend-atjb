package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Account")
@Entity(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountID", columnDefinition = "int")
	private int accountID;
	
	@Column(name = "Account", columnDefinition = "varchar(255)", unique = true, nullable = false)
	private String account;
	
	@Column(name = "Email", columnDefinition = "varchar(255)", unique = true, nullable = false)
	private String email;
	
	@Column(name = "Password", columnDefinition = "varchar(255)", nullable = false)
	private String password;
	
	@Column(name = "Status", columnDefinition = "int")
	private int status;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "EmployeeID",columnDefinition = "int" , nullable = false)
	private Employee employee;

	public Account(String account, String email, String password, int status, Employee employee) {
		super();
		this.account = account;
		this.email = email;
		this.password = password;
		this.status = status;
		this.employee = employee;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", account=" + account + ", email=" + email + ", password="
				+ password + ", status=" + status + "EmployeeID ="+ employee.getEmployeeID() +"]";
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
	
	
	
	
}
