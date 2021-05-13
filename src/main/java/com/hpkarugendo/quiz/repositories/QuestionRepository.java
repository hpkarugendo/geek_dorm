package com.hpkarugendo.quiz.repositories;

import java.util.List;

import com.hpkarugendo.quiz.models.Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
    List<Question> findAll();
}
