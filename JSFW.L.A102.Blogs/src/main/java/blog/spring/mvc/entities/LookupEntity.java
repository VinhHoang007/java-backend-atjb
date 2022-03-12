package blog.spring.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Lookup")
@Entity(name="Lookup")
public class LookupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "code", columnDefinition = "int")
	private int code;
	
	@Column(name = "type", columnDefinition = "varchar(20)")
	private String type;
	
	@Column(name = "position", columnDefinition = "varchar(20)")
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LookupEntity(int id, int code, String type, String position) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
		this.position = position;
	}

	public LookupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LookupEntity [id=" + id + ", code=" + code + ", type=" + type + ", position=" + position + "]";
	}
	
	
}
