package com.hpkarugendo.quiz.services;

import java.util.List;

import com.hpkarugendo.quiz.models.Answer;
import com.hpkarugendo.quiz.repositories.AnswerRepository;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswerRepository aRepository;

    public AnswerService( AnswerRepository answerRepository){
        this.aRepository = answerRepository;
    }

    public List<Answer> listAllAnswers(){
        return aRepository.findAll();
    }

    public Answer saveAnswer(Answer a){
        return aRepository.save(a);
    }

    public Iterable<Answer> saveAllAnswers(List<Answer> as){
        return aRepository.saveAll(as);
    }
}
