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

import projekti.PollService.domain.Poll;
import projekti.PollService.domain.PollRepository;

@CrossOrigin
@Controller
public class PollController {

	@Autowired
	private PollRepository pollrepository;

	@RequestMapping(value = "/addPoll")
	public String addPoll(Model model) {
		model.addAttribute("poll", new Poll());
		return "addpoll";
	}

	@PostMapping(value = "/savePoll")
	public String savePoll(@ModelAttribute Poll poll) {
		pollrepository.save(poll);
		Long pollId = poll.getPoll_id();
		return "redirect:/showPoll/" + pollId;
	}

	@GetMapping(value = "/showPoll/{id}")
	public String showOnePoll(@PathVariable("id") Long poll_Id, Model model) {
		model.addAttribute("poll", pollrepository.findById(poll_Id));
		return "showpoll";
	}

	@GetMapping(value = "/pollv1")
	public String listPOlls(Model model) {
		model.addAttribute("polls", pollrepository.findAll());
		return "pollv1";
	}

	// REST

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

	// Add new poll
	@PostMapping(value = "/polls")
	public @ResponseBody Poll savePollRest(@RequestBody Poll poll) {
		return pollrepository.save(poll);
	}
}
