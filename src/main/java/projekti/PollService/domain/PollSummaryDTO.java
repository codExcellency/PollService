package projekti.PollService.domain;

public class PollSummaryDTO {
	
	private Long pollId;
    private String name;
    private String description;
    
    
	public PollSummaryDTO(Long pollId, String name, String description) {
		super();
		this.pollId = pollId;
		this.name = name;
		this.description = description;
	}
	
	public PollSummaryDTO() {
		
	}

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
	
	
    
    
    
}
    
    
    
