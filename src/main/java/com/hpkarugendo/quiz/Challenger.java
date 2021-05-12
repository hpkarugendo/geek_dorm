package com.hpkarugendo.quiz;

import java.util.ArrayList;
import java.util.List;

public class Challenger {
    //@Id
    //@GeneratedValue
    private int id;
    private String username;
    private String email;
    //@OneToMany
    private List<Challenge> challenges;
    private double totalScore;

    public Challenger(){
        this.username = "";
        this.email = "";
        this.challenges = new ArrayList<>();
        this.totalScore = 0;
    }
    public Challenger(String un, String em){
        this.username = un;
        this.email = em;
        this.challenges = new ArrayList<>();
        this.totalScore = 0;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public List<Challenge> getChallenges() {
        return challenges;
    }
    public double getTotalScore() {
        double score = 0.0;
        for(Challenge ch: challenges){
            score = score + ch.getScore();
        }
        setTotalScore(score);
        return totalScore;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void printChallenger(){
        System.out.println("-- Challenger Info ---");
        System.out.println("Username: " + username + "\nEmail: " + email + "\nChallenges Taken: " + challenges.size() + "\nTotal Score: " + totalScore + "/" + (100*challenges.size()));
    }
    
}
