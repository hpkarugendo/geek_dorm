package com.hpkarugendo.quiz;

public class Answer {
    //@Id
    //@GeneratedValue
    private int id;
    private String answer;
    private boolean isCorrect, isPicked;
    private char label;

    public Answer(){
        this.answer = "";
        this.isCorrect = false;
        this.isPicked = false;
        this.label = ' ';
    }
    public Answer(String a, boolean correct, char l){
        this.answer = a;
        this.isCorrect = correct;
        this.isPicked = false;
        this.label = l;
    }

    public int getId() {
        return id;
    }
    public String getAnswer() {
        return answer;
    }
    public boolean isCorrect() {
        return isCorrect;
    }
    public boolean isPicked() {
        return isPicked;
    }
    public char getLabel() {
        return label;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    public void setLabel(char label) {
        this.label = label;
    }
    public void setPicked(boolean isPicked) {
        this.isPicked = isPicked;
    }

    @Override
    public String toString() {
        String well = "";
        String dis = "";

        if(isCorrect){
            well = "YES";
        } else {
            well = "NO";
        }
        if(isPicked){
            dis = "YES";
        } else {
            dis = "NO";
        }
        return "Answer: " + label + " - " +  answer + "\nCorrect?: " + well + "\nPicked?: " + dis;
    }
}
