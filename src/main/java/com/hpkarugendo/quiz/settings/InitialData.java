package com.hpkarugendo.quiz.settings;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hpkarugendo.quiz.models.Answer;
import com.hpkarugendo.quiz.models.Question;
import com.hpkarugendo.quiz.repositories.AnswerRepository;
import com.hpkarugendo.quiz.repositories.QuestionRepository;
import com.hpkarugendo.quiz.services.AnswerService;
import com.hpkarugendo.quiz.services.Databank;
import com.hpkarugendo.quiz.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {
    @Autowired
    private QuestionRepository qRepository;
    @Autowired
    private AnswerRepository aRepository;

    @Override
    public void run(String... args) throws Exception {

        QuestionService qService = new QuestionService(qRepository);
        AnswerService aService = new AnswerService(aRepository);

        try {
            File f = new ClassPathResource("static/files/data.txt").getFile();
            String data = "";
            System.out.println("FILE SIZE IS: " + f.length());
            System.out.println("PREPARING DATA...");
            data = new String(Files.readAllBytes(Paths.get(f.toURI())));
            String[] breakUpQuestions = data.split("[|]");
            Question q0;
            Answer a0, b0, c0, d0;

            for (int n = 0; n < breakUpQuestions.length; n++) {
                if (n % 2 != 0) {
                    String[] eachQuestion = breakUpQuestions[n].split("[:]");
                    String q, a, b, c, d, an;
                    q = eachQuestion[1];
                    a = eachQuestion[2];
                    b = eachQuestion[3];
                    c = eachQuestion[4];
                    d = eachQuestion[5];
                    an = eachQuestion[6];
                    q0 = new Question();
                    q0.setQuestion(q.substring(0, q.length() - 2));
                    a0 = new Answer();
                    a0.setAnswer(a.substring(0, a.length() - 2).toUpperCase());
                    a0.setLabel('A');
                    b0 = new Answer();
                    b0.setAnswer(b.substring(0, b.length() - 2).toUpperCase());
                    b0.setLabel('B');
                    c0 = new Answer();
                    c0.setAnswer(c.substring(0, c.length() - 2).toUpperCase());
                    c0.setLabel('C');
                    d0 = new Answer();
                    d0.setAnswer(d.substring(0, d.length() - 7).toUpperCase());
                    d0.setLabel('D');
                    switch (an) {
                        case "A":
                            a0.setCorrect(true);
                            break;
                        case "B":
                            b0.setCorrect(true);
                            break;
                        case "C":
                            c0.setCorrect(true);
                            break;
                        case "D":
                            d0.setCorrect(true);
                            break;
                    }
                    q0.getAnswers().add(a0);
                    q0.getAnswers().add(b0);
                    q0.getAnswers().add(c0);
                    q0.getAnswers().add(d0);
                    Databank.quizQuestions.add(q0);
                }
            }

            System.out.println("DATA BANK SIZE IS: " + Databank.quizQuestions.size());
            System.out.println("SAVING DATA TO DATABASE...");
            List<Question> toUpdate = new ArrayList<>();
            
            for(Question q: Databank.quizQuestions){
                Question toSave = new Question();
                toSave.setQuestion(q.getQuestion());
                Question saved = qService.saveQuestion(toSave);
                for(Answer a: q.getAnswers()){
                    Answer aToSave = new Answer();
                    aToSave.setAnswer(a.getAnswer());
                    aToSave.setLabel(a.getLabel());
                    aToSave.setCorrect(a.isCorrect());
                    aToSave.setPicked(a.isPicked());
                    aToSave.setQuestion(saved);
                    Answer aSaved = aService.saveAnswer(aToSave);
                    saved.getAnswers().add(aSaved);
                }
                toUpdate.add(saved);
            }
            qService.saveAllQuestions(toUpdate);
            System.out.println("FINISHED SAVING DATA TO DB!");
            System.out.println("FINISHED PREPARING DATA!");
            List<Question> qs = qService.listAllQuestions();
            System.out.println("There are: " + Databank.quizQuestions.size() + " questions available in the Memory List!");
            System.out.println("There are: " + qs.size() + " questions in the database!");
            System.out.println("Sample Questions from List and DB are:::::");
            Databank.quizQuestions.get(new Random().nextInt(355)).printQuestion();
            qs.get(new Random().nextInt(qs.size()));

            
            toUpdate.get(6).printQuestion();

        } catch (Exception e) {
            System.out.println("CAN'T READ FILE!");
        }

    }

}
