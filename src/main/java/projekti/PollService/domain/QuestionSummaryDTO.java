package projekti.PollService.domain;

import java.util.List;

public class QuestionSummaryDTO {
    private Long questionId;
    private String content;
    private String questionType;
    private List<Option> options; 
    
    // getters and setters
    public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	//Constructors
    public QuestionSummaryDTO(Long questionId, String content, String questionType, List<Option> options) {
        this.questionId = questionId;
        this.content = content;
        this.questionType = questionType;
        this.options = options;
    }

	
}
