package com.hpkarugendo.quiz.models;

public class QuizQuestion {
    private Question question;
    private Answer answer;

    public QuizQuestion(){
    }
    public QuizQuestion(Question q){
        this.question = q;
        this.answer = new Answer();
    }
    public QuizQuestion(Question q, Answer a){
        this.question = q;
        this.answer = a;
    }

    public Answer getAnswer() {
        return answer;
    }
    public Question getQuestion() {
        return question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
}
