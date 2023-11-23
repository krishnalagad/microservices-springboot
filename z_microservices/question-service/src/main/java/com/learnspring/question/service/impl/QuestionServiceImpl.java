package com.learnspring.question.service.impl;

import com.learnspring.question.entity.Question;
import com.learnspring.question.repository.QuestionRepository;
import com.learnspring.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Question not found with id %d", id)));
    }
}