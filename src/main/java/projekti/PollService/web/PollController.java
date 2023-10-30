package projekti.PollService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projekti.PollService.domain.Poll;
import projekti.PollService.domain.PollRepository;

@CrossOrigin
@Controller	
public class PollController {
	
	@Autowired
	private PollRepository pollrepository;
	
	@RequestMapping(value = "/addPoll")
	public String addPoll(Model model){
	model.addAttribute("poll", new Poll());
	return "addpoll";
	}
	
	@PostMapping(value = "/savePoll")
	public String savePoll(@ModelAttribute Poll poll) {
		pollrepository.save(poll);
		return "redirect:/showpoll";
	}
	
	@GetMapping(value = "/showPoll/{id}")
	public String showOnePoll(@PathVariable("id") Long pollId, Model model) {
		model.addAttribute("poll", pollrepository.findById(pollId));
		return "showpoll";
	}
	
	@GetMapping(value = "/pollv1")
	public String listPOlls(Model model) {
		model.addAttribute("polls", pollrepository.findAll());
		return "pollv1";
	}
	

}
