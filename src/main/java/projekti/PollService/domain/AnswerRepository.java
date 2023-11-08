package projekti.PollService.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findByQuestion_Poll_PollId(Long pollId);
	List<Answer> findByQuestion_QuestionId(Long questionId);
}
