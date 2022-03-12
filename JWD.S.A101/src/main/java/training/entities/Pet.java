package training.entities;

import java.io.Serializable;

public class Pet implements Serializable {

	/**
	 * @author VinhHN3
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	private int age;
	
	public void makeNoise(Pet pt) {
		System.out.println(pt.getName()+" cat say meow");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Pet(String type, String name, int age) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
	}
	public Pet() {
		super();
	}
	@Override
	public String toString() {
		return "Pet [type=" + type + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
