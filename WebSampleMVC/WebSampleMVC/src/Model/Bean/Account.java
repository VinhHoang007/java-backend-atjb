package Model.Bean;

public class Account {
	private String userName;
	private String fullName;
	private String addr;
	private String email;
	
	
	
	public Account(String userName, String fullName, String addr) {
	
		this.userName = userName;
		this.fullName = fullName;
		this.addr = addr;
	}
	
	public Account(){
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
