package com.project.FirstSpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.FirstSpringProject.jpa.Javajpa;
import com.project.FirstSpringProject.jpa.Quizjpa;
import com.project.FirstSpringProject.ownClass.Quiz;
import com.project.FirstSpringProject.ownClass.Response;
import com.project.FirstSpringProject.ownClass.Vamshi;
import com.project.FirstSpringProject.ownClass.VamshiWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    Quizjpa quizjpa;
    @Autowired
    Javajpa javajpa;

    public ResponseEntity createQuiz(int numQ, String title) {

        List<Vamshi> quesions = javajpa.getAllQuestionsByTitle(numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setVamshis(quesions);
        quizjpa.save(quiz);
        return new ResponseEntity<>("Saving Successfully",HttpStatus.CREATED);
    }

    public ResponseEntity<List<VamshiWrapper>> getQuiz(int id) {
        Optional<Quiz> quiz = quizjpa.findById(id);
        List<Vamshi> vamshiQuestions = quiz.get().getVamshis();
        List<VamshiWrapper> wrapperQuestions = new ArrayList<>();
        for (Vamshi question : vamshiQuestions) 
        {
            VamshiWrapper wrapperQuestion=new VamshiWrapper();
            wrapperQuestion.setId(question.getId());
            wrapperQuestion.setQuestion(question.getQuestion());
            wrapperQuestion.setOption1(question.getOption1());
            wrapperQuestion.setOption2(question.getOption2());
            wrapperQuestion.setOption3(question.getOption3());
            wrapperQuestion.setOption4(question.getOption4());
            wrapperQuestions.add(wrapperQuestion);
        }
        return new ResponseEntity<>(wrapperQuestions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<Response> response) {
        Optional<Quiz> quiz = quizjpa.findById(id);
        List<Vamshi> vamshis = quiz.get().getVamshis();
        int score = 0 ;
        int counter = 0;
        for(Vamshi vamshi : vamshis)
        {
            if(vamshi.getAnswer().equals(response.get(counter).getResponse()))
            score++;
            counter ++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }

}
