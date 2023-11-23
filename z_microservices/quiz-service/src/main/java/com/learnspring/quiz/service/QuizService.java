package com.learnspring.quiz.service;

import com.learnspring.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> getQuizzes();
    Quiz get(Long id);
}