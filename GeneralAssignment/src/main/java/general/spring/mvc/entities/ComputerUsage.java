package general.spring.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "ComputerUsage")
@Entity(name = "ComputerUsage")
public class ComputerUsage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "computerID", columnDefinition = "int")
	private int computerID;
	
	@Id
	@Column(name = "customerID", columnDefinition = "varchar(7)")
	private String customerID;
	
	@Id
	@Column(name = "dateOfUseComputer", columnDefinition = "date")
	private String dateOfUseComputer;
	
	@Id
	@Column(name = "timeBeginOfUseComputer", columnDefinition = "time")
	private String timeBeginOfUseComputer;
	
	@Column(name = "timeUseComputer", columnDefinition = "int")
	private int timeUseComputer;
	
	@ManyToOne()
	@JoinColumn(name = "computerID", insertable = false, updatable = false)
	private Computer computer;
	
	@ManyToOne()
	@JoinColumn(name = "customerID", insertable = false, updatable = false)
	private Customer customer;

	public ComputerUsage(int computerID, String customerID, String dateOfUseComputer, String timeBeginOfUseComputer,
			int timeUseComputer) {
		super();
		this.computerID = computerID;
		this.customerID = customerID;
		this.dateOfUseComputer = dateOfUseComputer;
		this.timeBeginOfUseComputer = timeBeginOfUseComputer;
		this.timeUseComputer = timeUseComputer;
	}

	public ComputerUsage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getComputerID() {
		return computerID;
	}

	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getDateOfUseComputer() {
		return dateOfUseComputer;
	}

	public void setDateOfUseComputer(String dateOfUseComputer) {
		this.dateOfUseComputer = dateOfUseComputer;
	}

	public String getTimeBeginOfUseComputer() {
		return timeBeginOfUseComputer;
	}

	public void setTimeBeginOfUseComputer(String timeBeginOfUseComputer) {
		this.timeBeginOfUseComputer = timeBeginOfUseComputer;
	}

	public int getTimeUseComputer() {
		return timeUseComputer;
	}

	public void setTimeUseComputer(int timeUseComputer) {
		this.timeUseComputer = timeUseComputer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ComputerUsage [computerID=" + computerID + ", customerID=" + customerID + ", dateOfUseComputer="
				+ dateOfUseComputer + ", timeBeginOfUseComputer=" + timeBeginOfUseComputer + ", timeUseComputer="
				+ timeUseComputer + "]";
	}
	
	
	
}
