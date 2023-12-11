package projekti.PollService.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projekti.PollService.domain.Option;
import projekti.PollService.domain.OptionRepository;
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

	@Autowired
	private OptionRepository optionRepository;

	// Add TEXT question
	@RequestMapping(value = "addQuestion/{id}/text")
	public String addTextQuestion(@PathVariable("id") Long pollId, Model model) {

		Question newQuestion = new Question();
		Poll poll = pollRepository.findById(pollId).orElse(null);
		newQuestion.setPoll(poll);
		newQuestion.setQuestionType(questionType.TEXT);
		model.addAttribute("newQuestion", newQuestion);
		return "addquestion";
	}

	// Add RADIOBUTTON question
	@RequestMapping(value = "addQuestion/{id}/radiobutton")
	public String addRadiobuttonQuestion(@PathVariable("id") Long pollId, Model model) {
		Question newQuestion = new Question();
		Poll poll = pollRepository.findById(pollId).orElse(null);
		newQuestion.setPoll(poll);
		newQuestion.setQuestionType(questionType.RADIOBUTTON);
		// questionrepository.save(newQuestion);
		model.addAttribute("newQuestion", newQuestion);
		return "addquestion";
	}

	@PostMapping(value = "savequestion", params = "giveoption")
	public String addOption(@ModelAttribute("newQuestion") Question newQuestion, Model model) {
		Question question;
		if (newQuestion.getQuestionId() != null) {
			Optional<Question> existingQuestion = questionrepository.findById(newQuestion.getQuestionId());

			if (existingQuestion.isPresent()) {
				question = existingQuestion.get();
				question.setTempOption(newQuestion.getTempOption());
			} else {
				return "addquestion";
			}

		} else {
			question = questionrepository.save(newQuestion);
		}

		List<Option> optionList;
		if (question.getOptions() != null) {
			optionList = question.getOptions();

		} else {
			optionList = new ArrayList<Option>();
		}

		Option option = new Option(question.getTempOption(), question);
		optionRepository.save(option);
		optionList.add(option);
		question.setOptions(optionList);
		questionrepository.save(question);
		model.addAttribute("options", question.getOptions());
		return "addquestion";
	}

	@PostMapping(value = "savequestion", params = "save")
	public String saveQuestion(@ModelAttribute Question question) {
		questionrepository.save(question);
		Long pollId = question.getPoll().getPollId();

		return "redirect:/showPoll/" + pollId;
	}

}
