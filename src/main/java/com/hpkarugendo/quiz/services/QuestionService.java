package com.hpkarugendo.quiz.services;

import java.util.List;

import com.hpkarugendo.quiz.models.Question;
import com.hpkarugendo.quiz.repositories.QuestionRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private QuestionRepository qRepository;
    
    public QuestionService(QuestionRepository questionRepository){
        this.qRepository = questionRepository;
    }

    public List<Question> listAllQuestions(){
        return qRepository.findAll();
    }

    public Question saveQuestion(Question q){
        return qRepository.save(q);
    }

    public void saveAllQuestions(List<Question> questions){
        questions.iterator().forEachRemaining(q -> saveQuestion(q));
    }
}
