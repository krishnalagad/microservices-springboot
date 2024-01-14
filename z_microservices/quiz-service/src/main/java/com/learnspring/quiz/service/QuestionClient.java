package com.learnspring.quiz.service;

import com.learnspring.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/api/v1/question/quiz/{id}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long id);
}