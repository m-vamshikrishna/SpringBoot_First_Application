package com.project.FirstSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FirstSpringProject.ownClass.Response;
import com.project.FirstSpringProject.ownClass.Vamshi;
import com.project.FirstSpringProject.ownClass.VamshiWrapper;
import com.project.FirstSpringProject.service.JavaService;
import com.project.FirstSpringProject.service.QuizService;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity createQuiz(@RequestParam int numQ, @RequestParam String title)
    {
        // return new ResponseEntity<>("Its working fine",HttpStatus.OK);
        return quizService.createQuiz(numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<VamshiWrapper>> getQuiz(@PathVariable int id)
    {
        System.out.println(id);
        return quizService.getQuiz(id);
    }

    @GetMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response)
    {
        return quizService.submitQuiz(id,response);
    }
    
}
