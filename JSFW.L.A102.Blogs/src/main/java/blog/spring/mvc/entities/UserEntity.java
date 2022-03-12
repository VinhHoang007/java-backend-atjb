package blog.spring.mvc.entities;

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

@Table(name = "Users")
@Entity(name="Users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "userName", columnDefinition = "varchar(50)", nullable = false,unique = true)
	private String userName;
	
	@Column(name = "passWord", columnDefinition = "varchar(32)", nullable = false)
	private String passWord;
	
	@Column(name = "salt", columnDefinition = "varchar(32)", nullable = false)
	private String salt;
	
	@Column(name = "email", columnDefinition = "varchar(60)", nullable = false,unique = true)
	private String email;
	
	@Column(name = "profile", columnDefinition = "varchar(40)")
	private String profile;

	@OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PostEntity> stPost = new HashSet<PostEntity>();

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String userName, String passWord, String salt, String email, String profile) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.salt = salt;
		this.email = email;
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", salt=" + salt
				+ ", email=" + email + ", profile=" + profile + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Set<PostEntity> getStPost() {
		return stPost;
	}

	public void setStPost(Set<PostEntity> stPost) {
		this.stPost = stPost;
	}
	
	
	
	
}
