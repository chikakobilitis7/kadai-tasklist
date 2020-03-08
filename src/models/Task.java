package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "getAllTasks",
			query = "SELECT m FROM Task AS m ORDER BY m.id ASC"
			)
})
@Table(name = "tasks")

public class Task {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp creted_at;

	@Column(name = "updated_at")
	private Timestamp updated_at;

	@Column(name = "content")
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreted_at() {
		return creted_at;
	}

	public void setCreted_at(Timestamp creted_at) {
		this.creted_at = creted_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
