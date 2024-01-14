package com.learnspring.question.repository;

import com.learnspring.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> getByQuizId(Long id);
}