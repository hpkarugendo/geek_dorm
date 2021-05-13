package com.hpkarugendo.quiz.services;

import java.util.List;

import com.hpkarugendo.quiz.models.Challenger;
import com.hpkarugendo.quiz.repositories.ChallengerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengerService {
    @Autowired
    private ChallengerRepository cRepository;

    public ChallengerService(){
    }

    public List<Challenger> listAllChallengers(){
        return cRepository.findAll();
    }

    public Challenger saveChallenger(Challenger c){
        return cRepository.save(c);
    }
}
