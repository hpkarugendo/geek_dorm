package com.hpkarugendo.quiz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToMany(mappedBy = "questions")
    private List<Challenge> challenges;

    public Question(){
        this.question = "";
        this.answers = new ArrayList<>();
        this.challenges = new ArrayList<>();
    }
    public Question(String q, List<Answer> ans){
        this.question = q;
        this.answers = ans;
        this.challenges = new ArrayList<>();
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
    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public void printQuestion(){
        System.out.println("Question" + " (" + id + "): " + question);
        for(Answer a: answers){
            String an = "";
            if(a.isCorrect()){
                an = "CORRECT";
            } else {
                an = "WRONG";
            }
            System.out.println("Answer " + a.getLabel() + ": " + a.getAnswer() + " (" + an + ")" + " -" + a.getId() + "- ");
        }
    }
}
