package model.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "Employee")
@Entity(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID", columnDefinition = "int")
	private int employeeID;
	
	@Column(name = "FirstName", columnDefinition = "varchar(255)", nullable = false)
	private String firstName;
	
	@Column(name = "LastName", columnDefinition = "varchar(255)", nullable = false)
	private String lastName;
	
	@Column(name = "Gender", columnDefinition = "int", nullable = false)
	private int gender;
	
	@Column(name = "Date_Of_Birth", columnDefinition = "date", nullable = false)
	private LocalDate dob;
	
	@Column(name = "Phone", columnDefinition = "varchar(20)", nullable = false)
	private String phone;
	
	@Column(name = "Address", columnDefinition = "varchar(255)")
	private String address;
	
	@Column(name = "Department", columnDefinition = "varchar(255)", nullable = false)
	private String deptName;
	
	@Column(name = "Remark", columnDefinition = "varchar(255)")
	private String remark;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private Account account;

	public Employee(String firstName, String lastName, int gender, LocalDate dob, String phone,
			String address, String deptName, String remark) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.deptName = deptName;
		this.remark = remark;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + ", address=" + address + ", deptName="
				+ deptName + ", remark=" + remark + "]";
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
