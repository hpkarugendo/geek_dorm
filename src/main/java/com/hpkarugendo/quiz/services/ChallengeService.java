package com.hpkarugendo.quiz.services;

import java.util.List;

import com.hpkarugendo.quiz.models.Challenge;
import com.hpkarugendo.quiz.repositories.ChallengeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepository cRepository;

    public ChallengeService(){
    }

    public List<Challenge> listAllChallenges(){
        return cRepository.findAll();
    }

    public Challenge saveChallenge(Challenge c){
        return cRepository.save(c);
    }
}
