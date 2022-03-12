package general.spring.mvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Customer")
@Entity(name = "Customer")
public class Customer {
	@Id
	@Column(name = "customerID", columnDefinition = "varchar(7)")
	private String customerID;
	

	@Column(name = "customerName", columnDefinition = "varchar(100)", nullable = false)
	private String customerName;
	
	@Column(name = "address", columnDefinition = "varchar(100)",nullable = false)
	private String address;
	
	@Column(name = "phone", columnDefinition = "varchar(11)",nullable = false)
	private String phone;
	
	@Column(name = "email", columnDefinition = "varchar(100)",nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<ComputerUsage> stComputerUsage = new HashSet<ComputerUsage>();
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER,orphanRemoval = true)
	private Set<ServiceUsage> stServiceUsage = new HashSet<ServiceUsage>();

	public Customer(String customerID, String customerName, String address, String phone, String email) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + "]";
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<ComputerUsage> getStComputerUsage() {
		return stComputerUsage;
	}

	public void setStComputerUsage(Set<ComputerUsage> stComputerUsage) {
		this.stComputerUsage = stComputerUsage;
	}

	public Set<ServiceUsage> getStServiceUsage() {
		return stServiceUsage;
	}

	public void setStServiceUsage(Set<ServiceUsage> stServiceUsage) {
		this.stServiceUsage = stServiceUsage;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
