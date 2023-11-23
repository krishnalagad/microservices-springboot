package com.learnspring.quiz.controller;

import com.learnspring.quiz.entity.Quiz;
import com.learnspring.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/")
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz) {
        Quiz q = this.quizService.add(quiz);
        return ResponseEntity.status(201).body(q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> get(@PathVariable Long id) {
        Quiz quiz = this.quizService.get(id);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getAll() {
        List<Quiz> quizzes = this.quizService.getQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}