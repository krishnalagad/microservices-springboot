package com.learnspring.quiz.service.impl;

import com.learnspring.quiz.entity.Quiz;
import com.learnspring.quiz.repository.QuizRepository;
import com.learnspring.quiz.service.QuestionClient;
import com.learnspring.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

/** @noinspection ALL*/
@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        List<Quiz> quizzes = this.quizRepository.findAll();
        List<Quiz> newQuizzes = quizzes.stream().map(quiz -> {
            quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).toList();
        return newQuizzes;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = this.quizRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Quiz not found with id %d", id)));
        quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}