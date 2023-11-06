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
import projekti.PollService.domain.QuestionRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionrepository;

	@Autowired
	private PollRepository pollRepository;

	@RequestMapping(value = "addQuestion/{id}")
	public String addQuestion(@PathVariable("id") Long pollId, Model model) {

		Question newQuestion = new Question();
		Poll poll = pollRepository.findById(pollId).orElse(null);
		newQuestion.setPoll(poll);
		model.addAttribute("newQuestion", newQuestion);
		return "addquestion";
	}

	@PostMapping(value = "savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		questionrepository.save(question);
		Long pollId = question.getPoll().getPollId();

		return "redirect:/showPoll/" + pollId;
	}

}
