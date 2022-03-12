package cms.spring.mvc.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Content")
@Entity(name="Content")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "int")
	private int id;
	
	@Column(name = "authorID", columnDefinition = "int")
	private int authorID;
	
	@Column(name = "title", columnDefinition = "varchar(50)", nullable = false)
	private String title;
	
	@Column(name = "brief", columnDefinition = "varchar(100)")
	private String brief;
	
	@Column(name = "content", columnDefinition = "text", nullable = false)
	private String content;
	
	@Column(name = "createDate", columnDefinition = "datetime")
	private LocalDateTime createDate;
	
	@Column(name = "updateTime", columnDefinition = "datetime")
	private LocalDateTime updateTime;
	
	@Column(name = "sort", columnDefinition = "varchar(50)")
	private String sort;
	
	@ManyToOne()
	@JoinColumn(name="authorID", insertable = false, updatable = false)
	private Member member;

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(int authorID, String title, String brief, String content, LocalDateTime createDate,
			LocalDateTime updateTime, String sort, Member member) {
		super();
		this.authorID = authorID;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.sort = sort;
		this.member = member;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", authorID=" + authorID + ", title=" + title + ", brief=" + brief + ", content="
				+ content + ", createDate=" + createDate + ", updateTime=" + updateTime + ", sort=" + sort + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
