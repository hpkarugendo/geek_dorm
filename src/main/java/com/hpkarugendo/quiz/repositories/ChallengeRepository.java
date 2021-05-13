package com.hpkarugendo.quiz.repositories;

import java.util.List;

import com.hpkarugendo.quiz.models.Challenge;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Integer> {
    List<Challenge> findAll();
}
