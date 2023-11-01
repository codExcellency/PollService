package projekti.PollService.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long poll_id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "poll")
	private List<Question> questions;
	
	public Long getPoll_id() {
		return poll_id;
	}
	public void setPoll_id(Long poll_id) {
		this.poll_id = poll_id;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Poll() {
		super();
	}
	
	public Poll(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	
}
