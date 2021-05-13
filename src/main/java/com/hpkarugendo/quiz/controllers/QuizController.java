package com.hpkarugendo.quiz.controllers;

import java.util.List;
import java.util.Random;

import com.hpkarugendo.quiz.models.Challenge;
import com.hpkarugendo.quiz.models.Challenger;
import com.hpkarugendo.quiz.models.Question;
import com.hpkarugendo.quiz.models.Quiz;
import com.hpkarugendo.quiz.models.QuizQuestion;
import com.hpkarugendo.quiz.repositories.ChallengeRepository;
import com.hpkarugendo.quiz.repositories.ChallengerRepository;
import com.hpkarugendo.quiz.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    @Autowired
    private QuestionRepository qRepository;
    @Autowired
    private ChallengeRepository cRepository;
    @Autowired
    private ChallengerRepository chRepository;

    public QuizController(QuestionRepository questionRepository, ChallengeRepository challengeRepository, ChallengerRepository challengerRepository){
        this.cRepository = challengeRepository;
        this.chRepository = challengerRepository;
        this.qRepository = questionRepository;
    }

    @GetMapping("/new-quiz")
    public String quizGet(Model m){
        List<Question> qs = qRepository.findAll();
        Quiz quiz = new Quiz();
        
        for(int i = 0; i < 5; i++){
            int r = new Random().nextInt(qs.size());
            Question q0 = qs.get(r);
            QuizQuestion quizQuestion = new QuizQuestion(q0);
            quiz.getQuestions().add(quizQuestion);
            qs.remove(q0);
        }

        m.addAttribute("quizObject", quiz);

        return "sample_quiz";
    }
}
