package blog.spring.mvc.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Comments")
@Entity(name="Comments")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "author", columnDefinition = "varchar(50)", nullable = false)
	private String author;
	
	@Column(name = "url", columnDefinition = "varchar(50)")
	private String url;
	
	@Column(name = "email", columnDefinition = "varchar(50)", nullable = false)
	private String email;
	
	@Column(name = "content", columnDefinition = "varchar(max)", nullable = false)
	private String content;
	
	@Column(name = "status", columnDefinition = "int", nullable = false)
	private int status;
	
	@Column(name = "createTime", columnDefinition = "datetime", nullable = false)
	private LocalDateTime createTime;
	
	

	public LocalDateTime getCreateTime() {
		return createTime;
	}



	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Column(name = "postID", columnDefinition = "int", nullable = false)
	private int postID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="postID", insertable = false, updatable = false)
	private PostEntity postEntity;

	public CommentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CommentEntity(String author, String url, String email, String content, int status, LocalDateTime createTime,
			int postID) {
		super();
		this.author = author;
		this.url = url;
		this.email = email;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
		this.postID = postID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public PostEntity getPostEntity() {
		return postEntity;
	}

	public void setPostEntity(PostEntity postEntity) {
		this.postEntity = postEntity;
	}

	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", author=" + author + ", url=" + url + ", email=" + email + ", content="
				+ content + ", status=" + status + ", postID=" + postID + "]";
	}
	
	
}
