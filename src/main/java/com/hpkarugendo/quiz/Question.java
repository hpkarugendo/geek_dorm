package com.hpkarugendo.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
    //@Id
    //@GeneratedValue
    private int id;
    private String question;
    //@OneToMany
    private List<Answer> answers;

    public Question(){
        this.question = "";
        this.answers = new ArrayList<>();
    }
    public Question(String q, List<Answer> ans){
        this.question = q;
        this.answers = ans;
    }

    public int getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void printQuestion(){
        System.out.println("Question: " + question);
        for(Answer a: answers){
            String an = "";
            if(a.isCorrect()){
                an = "CORRECT";
            } else {
                an = "WRONG";
            }
            System.out.println("Answer " + a.getLabel() + ": " + a.getAnswer() + " (" + an + ")");
        }
    }
}
