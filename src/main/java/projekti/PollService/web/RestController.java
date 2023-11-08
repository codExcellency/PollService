package projekti.PollService.web;

import java.util.List;
import java.util.Optional;

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
import projekti.PollService.domain.Question;
import projekti.PollService.domain.QuestionRepository;

@CrossOrigin
@Controller
public class RestController {

	@Autowired
	private PollRepository pollrepository;

	@Autowired
	private QuestionRepository questionrepository;
	
	@Autowired
	private AnswerRepository answerrepository;

	// Get all polls
	@GetMapping(value = "/polls")
	public @ResponseBody List<Poll> pollListRest() {
		return (List<Poll>) pollrepository.findAll();
	}

	// Get poll by id
	@GetMapping(value = "/polls/{id}")
	public @ResponseBody Optional<Poll> findPollRest(@PathVariable("id") Long poll_id) {
		return pollrepository.findById(poll_id);
	}

	// Get all questions of a poll
	@GetMapping(value = "/polls/{id}/questions")
	public @ResponseBody List<Question> questionListRest(@PathVariable("id") Long pollId) {
		return (List<Question>) questionrepository.findByPoll_PollId(pollId);
	}

	//Get all answers for a poll
	@GetMapping(value = "/polls/{id}/answers")
	public @ResponseBody List<Answer> pollAnswerListRest(@PathVariable("id") Long pollId){
		return (List<Answer>) answerrepository.findByQuestion_Poll_PollId(pollId);
	}
	
	//Get all answers for a question
	@GetMapping(value = "/polls/{pollid}/questions/{questionid}/answers")
	public @ResponseBody List<Answer> questionAnswerListRest(@PathVariable("pollid") Long pollId, @PathVariable("questionid") Long questionId){
		return (List<Answer>) answerrepository.findByQuestion_QuestionId(questionId);
	}
	
	//Post answer to question
	@PostMapping(value = "/questions/{id}/answers")
	public @ResponseBody Answer postQuestionAnswer(@RequestBody Answer answer, @PathVariable("id")Long questionId){
		return answerrepository.save(answer);
	}
}
