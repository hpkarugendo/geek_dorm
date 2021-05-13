package com.hpkarugendo.quiz.models;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Challenge {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    @ElementCollection
    @OrderColumn
    private Question[] questions;
    @ManyToOne
    private Challenger challenger;
    private double score;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Challenge(){
        this.questions = new Question[5];
        this.challenger = new Challenger();
        this.score = 0;
        this.date = new Date();
    }
    public Challenge(Question[] qs, Challenger cha) {
        this.challenger = cha;
        this.questions = qs;
        this.date = new Date();
        this.score = 0;
    }

    public Challenger getChallenger() {
        return challenger;
    }
    public Date getDate() {
        return date;
    }
    public int getId() {
        return id;
    }
    public Question[] getQuestions() {
        return questions;
    }
    public double getScore() {
        double sc = 0;
        for(Question q: Arrays.asList(questions)){
            for(Answer a: q.getAnswers()){
                if(a.isPicked() && a.isCorrect()){
                    sc = sc + 20;
                }
            }
        }
        setScore(sc);
        return score;
    }

    public void setChallenger(Challenger challenger) {
        this.challenger = challenger;
    }
    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public void printChallenge(){
        System.out.println("--- GAME --- ");

        for(Question q: Arrays.asList(questions)){
            System.out.println("Question: " + q.getQuestion());
            for(Answer a: q.getAnswers()){
                if(a.isPicked()){
                    System.out.println("Chosen Answer: " + a.getLabel() + " - " + a.getAnswer());
                }
                if(a.isCorrect()){
                    System.out.println("Correct Answer: " + a.getLabel() + " - " + a.getAnswer());
                }
            }
        }
        System.out.println("------");
    }
    
}
