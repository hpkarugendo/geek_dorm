package com.hpkarugendo.quiz.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Quiz {

    private final String id = UUID.randomUUID().toString();
    private List<QuizQuestion> questions;

    public Quiz(){
        this.questions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }
}
