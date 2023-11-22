package projekti.PollService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId; 
	
	private String content;
	@ManyToOne
	@JoinColumn(name="questionID")
	private Question question;
	
	//Constructors
	public Option(String content, Question question) {
		super();
		this.content = content;
		this.question = question;
	}
	
	public Option() {
		
	}

	//Getters & Setters
	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}	
}
