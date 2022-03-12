package general.spring.mvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Services")
@Entity(name = "Services")
public class Services {
	@Id
	@Column(name = "serviceID", columnDefinition = "varchar(5)")
	private String serviceID;
	
	@Column(name = "serviceName", columnDefinition = "varchar(100)", nullable = false)
	private String serviceName;
	
	@Column(name = "unit", columnDefinition = "varchar(100)", nullable = false)
	private String unit;
	
	@Column(name = "price", columnDefinition = "int", nullable = false)
	private int price;
	
	@OneToMany(mappedBy = "service",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ServiceUsage> stServiceUsages = new HashSet<ServiceUsage>();

	public Services(String serviceID, String serviceName, String unit, int price) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.unit = unit;
		this.price = price;
	}

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<ServiceUsage> getStServiceUsages() {
		return stServiceUsages;
	}

	public void setStServiceUsages(Set<ServiceUsage> stServiceUsages) {
		this.stServiceUsages = stServiceUsages;
	}

	@Override
	public String toString() {
		return "Service [serviceID=" + serviceID + ", serviceName=" + serviceName + ", unit=" + unit + ", price="
				+ price + "]";
	}

	
}
