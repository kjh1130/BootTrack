package com.BootTrack.Forum;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BootTrack.Forum.Entity.Question;
import com.BootTrack.Forum.Repository.QuestionRepository;

@SpringBootTest
class ForumApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("SpringBoot는 어떻게 사용하나요?");
		q1.setContent("SpringBoot에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("DB 관련 질문입니다.");
		q2.setContent("DB연결은 어떻게 하나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
}
