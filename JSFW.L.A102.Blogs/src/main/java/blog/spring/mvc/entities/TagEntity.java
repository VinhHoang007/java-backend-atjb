package blog.spring.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Tags")
@Entity(name="Tags")
public class TagEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "tagName", columnDefinition = "varchar(50)", nullable = false,unique = true)
	private String tagName;
	
	@Column(name = "frequency", columnDefinition = "int",nullable = false)
	private int frequency;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public TagEntity(int id, String tagName, int frequency) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.frequency = frequency;
	}

	public TagEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
