package cms.spring.mvc.entities;

import java.time.LocalDateTime;
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
import javax.validation.constraints.NotBlank;

import cms.spring.mvc.validator.Email;
import cms.spring.mvc.validator.EmailDuplicate;
import cms.spring.mvc.validator.UserName;



@Table(name = "Member")
@Entity(name="Member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "firstName", columnDefinition = "varchar(50)")
	private String firstName;
	
	@Column(name = "lastName", columnDefinition = "varchar(50)")
	private String lastName;
	
//	@UserName
	@Column(name = "userName", columnDefinition = "varchar(50)",unique = true)
	private String userName;
	
	@NotBlank
	@Column(name = "passWord", columnDefinition = "varchar(50)", nullable = false)
	private String passWord;
	
	@Column(name = "phone", columnDefinition = "varchar(11)")
	private String phone;

//	@Email
//	@EmailDuplicate
	@Column(name = "email", columnDefinition = "varchar(50)", nullable = false,unique = true)
	private String email;
	
	@Column(name = "description", columnDefinition = "text")
	private String description;
	
	@Column(name = "createDate", columnDefinition = "datetime")
	private LocalDateTime createDate;
	
	@Column(name = "updateTime", columnDefinition = "datetime")
	private LocalDateTime updateTime;
	
	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Content> stContent = new HashSet<Content>();

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String firstName, String lastName, String userName, String passWord, String phone, String email,
			String description, LocalDateTime createDate, LocalDateTime updateTime) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createDate = createDate;
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", passWord=" + passWord + ", phone=" + phone + ", email=" + email + ", description=" + description
				+ ", createDate=" + createDate + ", updateTime=" + updateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public Set<Content> getStContent() {
		return stContent;
	}

	public void setStContent(Set<Content> stContent) {
		this.stContent = stContent;
	}
	
	
	
}
