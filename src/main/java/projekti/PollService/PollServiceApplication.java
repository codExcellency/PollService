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
import projekti.PollService.domain.Question.questionType;
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
			Poll poll3 = new Poll("Ryhmätyö-kysyely", "Anna palautetta ryhmätyöskentelyn järjestelyistä");
			pollRepository.save(poll3);
			
			log.info("save some questions");
			Question question1 = new Question("What would you like to have as the friday special?", questionType.TEXT, poll1);
			questionRepository.save(question1);
			Question question2 = new Question("How easy was the exam?", questionType.TEXT, poll2);
			questionRepository.save(question2);
			Question question3 = new Question("Did the course material help you learn?", questionType.TEXT, poll2);
			questionRepository.save(question3);
			
			Question question4 = new Question("Miten ryhmäjako vaikutti ryhmän toimivuuteen?", questionType.TEXT, poll3);
			questionRepository.save(question4);
			Question question5 = new Question("Miten ryhmäjakoa olisi voinut parantaa?", questionType.TEXT, poll3);
			questionRepository.save(question5);
			Question question6 = new Question("Oliko ryhmätehtävälle varattu oikeaan aikaan aikaa tunneilta?", questionType.TEXT, poll3);
			questionRepository.save(question6);
			Question question7 = new Question("Mitä asioita teitte ryhmässä jotka tukivat ryhmätyötä?", questionType.TEXT, poll3);
			questionRepository.save(question7);
		};
	}
}
