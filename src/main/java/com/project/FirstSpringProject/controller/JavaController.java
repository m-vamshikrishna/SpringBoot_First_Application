package com.project.FirstSpringProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FirstSpringProject.ownClass.Vamshi;
import com.project.FirstSpringProject.service.JavaService;



@RestController
@RequestMapping("/quesion")
public class JavaController {
    
    
    @Autowired
    JavaService javaService;

    @GetMapping("/allQuestions")
    public List<Vamshi> getAllQuestions()
    {
        return javaService.getAllQuestions();
    } 

    @GetMapping("/id/{id}")
    public Optional<Vamshi> getAllQuestionsById(@PathVariable long id)
    {
        return javaService.getAllQuestionsById(id);
    } 

    @GetMapping("/name/{name}")
    public List<Vamshi> getAllQuestionsByName(@PathVariable String name)
    {
        return javaService.getAllQuestionsByName(name);
    } 

    @PostMapping("add")
    public String addVamshi(@RequestBody Vamshi vamshi)
    {
        return javaService.addVamshi(vamshi);
    }

    @DeleteMapping("delete/{delete}")
    public String deleteVamshi(@PathVariable String delete)
    {
        return javaService.deleteVamshi(Long.parseLong(delete));
    }

    @PatchMapping("update")
    public String updateVamshi(@RequestBody Vamshi vamshi)
    {
        return javaService.updateVamshi(vamshi);
    }
    

    // @GetMapping("/abhishek")
    // public String getAllAbhishek()
    // {
    //     return "Hello Abhishek";
    // } 
}
