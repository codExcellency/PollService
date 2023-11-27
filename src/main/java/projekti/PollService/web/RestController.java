package projekti.PollService.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import projekti.PollService.domain.Answer;
import projekti.PollService.domain.AnswerRepository;
import projekti.PollService.domain.Poll;
import projekti.PollService.domain.PollRepository;
import projekti.PollService.domain.PollSummaryDTO;
import projekti.PollService.domain.Question;
import projekti.PollService.domain.QuestionRepository;
import projekti.PollService.domain.QuestionSummaryDTO;

@CrossOrigin
@Controller
public class RestController {

	@Autowired
	private PollRepository pollrepository;

	@Autowired
	private QuestionRepository questionrepository;
	
	@Autowired
	private AnswerRepository answerrepository;

	
	//POLLS

	// Get all polls
	@GetMapping(value = "/polls")
	public @ResponseBody List<PollSummaryDTO> getPolls() {
		List<Poll> polls = (List<Poll>) pollrepository.findAll();
	    List<PollSummaryDTO> pollDTOs = polls.stream()
	            .map(poll -> new PollSummaryDTO(poll.getPollId(), poll.getName(), poll.getDescription()))
	            .collect(Collectors.toList());
	    return pollDTOs;
	}

	//KESKEN
	// Get poll by id
//	@GetMapping(value = "/polls/{id}")
//	public @ResponseBody List<QuestionSummaryDTO> getPollById(@PathVariable("id") Long pollId) {
//		Poll poll = pollrepository.findById(pollId).orElse(null);
//		QuestionSummaryDTO questionDTOs = poll.s
// 		return "";
//	}
	
	//QUESTIONS
	
	//Get question by id
	@GetMapping(value = "/questions/{id}")
	public @ResponseBody Optional<Question> getQuestionById(@PathVariable("id")Long questionId) {
		return questionrepository.findById(questionId);
	}
	
	//ANSWERS
	
	//Post answer to a question
	@PostMapping(value = "/answers")
	public @ResponseBody Answer postAnswer(@RequestBody Answer answer){
		return answerrepository.save(answer);
	}
	
}
