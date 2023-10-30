package projekti.PollService.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import projekti.PollService.domain.Question;
import projekti.PollService.domain.QuestionRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionrepository;
<<<<<<< HEAD
	
	@RequestMapping(value = "addquestion")
=======

	@RequestMapping(value = "addQuestion")
>>>>>>> 715d614f136326e50cc9be12dc606a15aac210d3
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}

	@PostMapping(value = "savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		questionrepository.save(question);
		return "redirect:/showPoll";
	}

	// REST

	// Get all questions
	@GetMapping(value = "/questions")
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) questionrepository.findAll();
	}

	// Get question by id
	@GetMapping(value = "/questions/{id}")
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long question_id) {
		return questionrepository.findById(question_id);
	}

	// Add new question
	@PostMapping(value = "/questions")
	public @ResponseBody Question saveQuestionRest(@RequestBody Question question) {
		return questionrepository.save(question);
	}
}
