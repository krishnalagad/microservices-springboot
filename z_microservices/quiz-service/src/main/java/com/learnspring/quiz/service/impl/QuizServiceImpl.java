package com.learnspring.quiz.service.impl;

import com.learnspring.quiz.entity.Quiz;
import com.learnspring.quiz.repository.QuizRepository;
import com.learnspring.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        return this.quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        return this.quizRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Quiz not found with id %d", id)));
    }
}