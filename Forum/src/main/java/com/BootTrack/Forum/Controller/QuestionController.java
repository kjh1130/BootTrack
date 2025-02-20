package com.BootTrack.Forum.Controller;

import java.util.List;

import com.BootTrack.Forum.Form.AnswerForm;
import com.BootTrack.Forum.Form.QuestionForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.BootTrack.Forum.Entity.Question;
//import com.BootTrack.Forum.Repository.QuestionRepository;
import com.BootTrack.Forum.Service.QuestionService;

import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@GetMapping("/list")
//	@ResponseBody
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList",questionList);
		return "question_list";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}

	@GetMapping("/create")
	public String questionCreate(Model model) {
		model.addAttribute("questionForm", new QuestionForm());
		return "question_form";
	}

	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
}
