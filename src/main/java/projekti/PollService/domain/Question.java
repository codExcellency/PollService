package projekti.PollService.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String content;

	public enum questionType {
		TEXT, RADIOBUTTON
	};

	@Enumerated(EnumType.STRING)
	private questionType questionType;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "pollId")
	private Poll poll;

	@JsonIgnoreProperties("question")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> options;

	// Getters & Setters
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public questionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(questionType questionType) {
		this.questionType = questionType;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	// Constructors
	public Question(String content, questionType questionType, Poll poll) {
		super();
		this.content = content;
		this.questionType = questionType;
		this.poll = poll;
	}

	public Question() {
		super();
	}

}
