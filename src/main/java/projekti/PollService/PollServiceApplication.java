package projekti.PollService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projekti.PollService.domain.Poll;
import projekti.PollService.domain.PollRepository;
import projekti.PollService.domain.Question;
import projekti.PollService.domain.QuestionRepository;

@SpringBootApplication
public class PollServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(PollServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PollServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner pollDemo(PollRepository pollRepository, QuestionRepository questionRepository) {
		return (args) -> {
			log.info("save some polls");
			Poll poll1 = new Poll("Friday special poll", "Vote on the new friday special option at the cafeteria");
			pollRepository.save(poll1);
			Poll poll2 = new Poll("Course feedback", "Give feedback on the course");
			pollRepository.save(poll2);
			
			log.info("save some questions");
			Question question1 = new Question("What would you like to have as the friday special?", poll1);
			questionRepository.save(question1);
			Question question2 = new Question("How easy was the exam?", poll2);
			questionRepository.save(question2);
			Question question3 = new Question("Did the course material help you learn?", poll2);
			questionRepository.save(question3);
		};
	}
}
