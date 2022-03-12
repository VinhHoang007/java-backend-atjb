package model.bean;

public class Account {
	private int accountID;
	private int employeeID;
	private String account;
	private String email;
	private String password;
	private int status;
	public Account(int accountID, int employeeID, String account, String email, String password, int status) {
		super();
		this.accountID = accountID;
		this.employeeID = employeeID;
		this.account = account;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", employeeID=" + employeeID + ", account=" + account + ", email="
				+ email + ", password=" + password + ", status=" + status + "]";
	}
	
	
	
	
	
}
