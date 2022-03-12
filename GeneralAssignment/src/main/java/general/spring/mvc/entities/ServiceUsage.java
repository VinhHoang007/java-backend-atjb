package general.spring.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ServiceUsage")
@Entity(name = "ServiceUsage")
public class ServiceUsage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customerID", columnDefinition = "varchar(7)")
	private String customerID;
	
	@Id
	@Column(name = "serviceID", columnDefinition = "varchar(5)")
	private String serviceID;
	
	@Id
	@Column(name = "dayOfUseService", columnDefinition = "date")
	private String dayOfUseService;
	
	@Id
	@Column(name = "timeOfUseService", columnDefinition = "time")
	private String timeOfUseService;
	
	@Column(name = "quantity", columnDefinition = "int")
	private int quantity;
	
	@ManyToOne()
	@JoinColumn(name = "serviceID", insertable = false, updatable = false)
	private Services service;
	
	@ManyToOne()
	@JoinColumn(name = "customerID", insertable = false, updatable = false)
	private Customer customer;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getDayOfUseService() {
		return dayOfUseService;
	}

	public void setDayOfUseService(String dayOfUseService) {
		this.dayOfUseService = dayOfUseService;
	}

	public String getTimeOfUseService() {
		return timeOfUseService;
	}

	public void setTimeOfUseService(String timeOfUseService) {
		this.timeOfUseService = timeOfUseService;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ServiceUsage(String customerID, String serviceID, String dayOfUseService, String timeOfUseService,
			int quantity) {
		super();
		this.customerID = customerID;
		this.serviceID = serviceID;
		this.dayOfUseService = dayOfUseService;
		this.timeOfUseService = timeOfUseService;
		this.quantity = quantity;
	}

	public ServiceUsage() {
		super();
	}
	
	
	
	
	
}
