package com.BootTrack.Forum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.BootTrack.Forum.Entity.Answer;
import com.BootTrack.Forum.Entity.Question;
import com.BootTrack.Forum.Repository.AnswerRepository;
import com.BootTrack.Forum.Repository.QuestionRepository;


@SpringBootTest
class ForumApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(6);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		assertEquals(1,answerList.size());
		assertEquals("가벼운 DB인 H2로 먼저 해보세요.",answerList.get(0).getContent());
	}
}
