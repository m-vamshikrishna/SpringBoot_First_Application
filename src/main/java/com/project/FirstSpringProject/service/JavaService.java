package com.project.FirstSpringProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.FirstSpringProject.jpa.Javajpa;
import com.project.FirstSpringProject.ownClass.Vamshi;

@Component
public class JavaService {
    @Autowired
    Javajpa javajpa;
    public List<Vamshi> getAllQuestions()
    {
        List<Vamshi> myList = new ArrayList<>();
        return javajpa.findAll();
    }
    public Optional<Vamshi> getAllQuestionsById(Long id) {
        return javajpa.findById(id);
    }
    public List<Vamshi> getAllQuestionsByName(String name) {
        return javajpa.findByName(name);
    }
    public String addVamshi(Vamshi vamshi) {
        javajpa.save(vamshi);
         return "Success";
    }
    public String deleteVamshi(Long id) {
        javajpa.deleteById(id);
        return "Deleted";
    }
    public String updateVamshi(Vamshi vamshi) {
        javajpa.save(vamshi);
        return "Updated";
    } 
    
}
