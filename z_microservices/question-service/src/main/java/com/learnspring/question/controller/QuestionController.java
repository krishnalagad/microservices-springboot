package com.learnspring.question.controller;

import com.learnspring.question.entity.Question;
import com.learnspring.question.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/")
    public ResponseEntity<Question> create(@RequestBody Question question) {
        Question add = this.questionService.add(question);
        return ResponseEntity.status(201).body(add);
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> questions = this.questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> get(@PathVariable Long id) {
        Question question = this.questionService.get(id);
        return ResponseEntity.ok(question);
    }
}