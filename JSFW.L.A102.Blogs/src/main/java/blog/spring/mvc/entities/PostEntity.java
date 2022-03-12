package blog.spring.mvc.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Posts")
@Entity(name="Posts")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "title", columnDefinition = "varchar(50)", nullable = false)
	private String title;
	
	@Column(name = "content", columnDefinition = "varchar(max)", nullable = false)
	private String content;

	@Column(name = "status", columnDefinition = "varchar(20)", nullable = false)
	private String status;
	
	@Column(name = "tags", columnDefinition = "varchar(50)")
	private String tags;
	
	@Column(name = "createTime", columnDefinition = "datetime")
	private LocalDateTime createTime;
	
	@Column(name = "updateTime", columnDefinition = "datetime")
	private LocalDateTime updateTime;
	
	@Column(name = "authorID", columnDefinition = "int")
	private int authorID;
	
	@ManyToOne()
	@JoinColumn(name ="authorID", insertable = false, updatable = false)
	private UserEntity userEntity;
	
	@OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<CommentEntity> stPost = new HashSet<CommentEntity>();

	public PostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PostEntity(String title, String content, String status, String tags, LocalDateTime createTime,
			LocalDateTime updateTime, int authorID) {
		super();
		this.title = title;
		this.content = content;
		this.status = status;
		this.tags = tags;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.authorID = authorID;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Set<CommentEntity> getStPost() {
		return stPost;
	}

	public void setStPost(Set<CommentEntity> stPost) {
		this.stPost = stPost;
	}

	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", title=" + title + ", content=" + content + ", status=" + status + ", tags="
				+ tags + ", createTime=" + createTime + ", updateTime=" + updateTime + ", authorID=" + authorID + "]";
	}

	

	
	
	
	
}
