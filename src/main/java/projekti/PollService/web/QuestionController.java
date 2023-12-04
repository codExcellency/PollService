package projekti.PollService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projekti.PollService.domain.Poll;
import projekti.PollService.domain.PollRepository;
import projekti.PollService.domain.Question;
import projekti.PollService.domain.Question.questionType;
import projekti.PollService.domain.QuestionRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionrepository;

	@Autowired
	private PollRepository pollRepository;

	//Add TEXT question
	@RequestMapping(value = "addQuestion/{id}/text")
	public String addTextQuestion(@PathVariable("id") Long pollId, Model model) {
		
		Question newQuestion = new Question();
		Poll poll = pollRepository.findById(pollId).orElse(null);
		newQuestion.setPoll(poll);
		newQuestion.setQuestionType(questionType.TEXT);
		model.addAttribute("newQuestion", newQuestion);
		return "addquestion";
	}
	
	//Add RADIOBUTTON question
	@RequestMapping(value = "addQuestion/{id}/radiobutton")
	public String addRadiobuttonQuestion(@PathVariable("id") Long pollId, Model model) {
		Question newQuestion = new Question();
		Poll poll = pollRepository.findById(pollId).orElse(null);
		newQuestion.setPoll(poll);
		newQuestion.setQuestionType(questionType.RADIOBUTTON);
		String tempOption = "";
		model.addAttribute("newQuestion", newQuestion);
		model.addAttribute("", tempOption);
		return "addquestion";	
	}
	
	@RequestMapping(value = "savequestion", params = "giveoption")
	public String addOption(@ModelAttribute Question question, Model model) {
		
		return "addquestion";
	}

	@PostMapping(value = "savequestion", params = "save")
	public String saveQuestion(@ModelAttribute Question question) {
		questionrepository.save(question);
		Long pollId = question.getPoll().getPollId();

		return "redirect:/showPoll/" + pollId;
	}

}
