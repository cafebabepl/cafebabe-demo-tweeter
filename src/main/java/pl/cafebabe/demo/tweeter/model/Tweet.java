package pl.cafebabe.demo.tweeter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tweeter_tweet")
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "Tytuł tweeta nie może być pusty.")
	@Size(min = 5, max = 50, message = "Tytuł tweeta musi mieć długość między 5 a 50 znaków.")
	private String title;

	@Column(nullable = false, length = 160)
	@NotBlank(message = "Treść tweeta nie może być pusta.")
	@Size(max = 160, message = "Maksymalna długość tekstu tweeta wynosi 160 znaków.")
	private String text;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@ManyToOne
	private User user;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", title=" + title + ", text=" + text + ", created=" + created + ", user=" + user + "]";
	}

}