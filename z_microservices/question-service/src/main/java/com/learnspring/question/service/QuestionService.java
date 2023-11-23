package com.learnspring.question.service;

import com.learnspring.question.entity.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);
    List<Question> getQuestions();
    Question get(Long id);
}