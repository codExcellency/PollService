package projekti.PollService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import projekti.PollService.domain.QuestionRepository;

@CrossOrigin
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionrepository;
	
	@RequestMapping(value = "addQuestion")
	public String addQuestion() {
		return "";
	}

}
