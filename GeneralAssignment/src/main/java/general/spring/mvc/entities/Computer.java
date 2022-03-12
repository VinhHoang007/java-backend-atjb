package general.spring.mvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Computer")
@Entity(name = "Computer")
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "computerID", columnDefinition = "int")
	private int computerID;
	
	@Column(name = "position", columnDefinition = "varchar(10)", nullable = false, unique = true)
	private String position;
	
	@Column(name = "status", columnDefinition = "varchar(50)", nullable = false)
	private String status;
	
	@OneToMany(mappedBy = "computer",cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<ComputerUsage> stComputerUsage = new HashSet<ComputerUsage>();

	public Computer(String position, String status) {
		this.position = position;
		this.status = status;
		
	}

	public Computer() {
		super();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Computer [computerID=" + computerID + ", position=" + position + ", status=" + status + "]";
	}


	public int getComputerID() {
		return computerID;
	}

	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}
	
	
	
}
