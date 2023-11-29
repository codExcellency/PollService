package projekti.PollService.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PollDetailDTO {

    private Long pollId;
    private String name;
    private String description;
    @JsonIgnoreProperties({"answers", "poll"})
    private List<Question> questions;

    //Constructors
    public PollDetailDTO(Long pollId, String name, String description, List<Question> questions) {
        this.pollId = pollId;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }
    
    public PollDetailDTO() {
    	
    }

    // Getters & Setters
	public Long getPollId() {
		return pollId;
	}

	public void setPollId(Long pollId) {
		this.pollId = pollId;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
    
    
    
}
