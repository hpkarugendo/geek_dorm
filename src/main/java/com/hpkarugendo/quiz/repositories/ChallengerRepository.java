package com.hpkarugendo.quiz.repositories;

import java.util.List;

import com.hpkarugendo.quiz.models.Challenger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengerRepository extends CrudRepository<Challenger, Integer> {
    List<Challenger> findAll();
}
