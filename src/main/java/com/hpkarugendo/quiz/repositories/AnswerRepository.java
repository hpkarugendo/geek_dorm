package com.hpkarugendo.quiz.repositories;

import java.util.List;

import com.hpkarugendo.quiz.models.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    List<Answer> findAll();
}
