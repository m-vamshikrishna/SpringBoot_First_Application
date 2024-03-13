package com.project.FirstSpringProject.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.FirstSpringProject.ownClass.Quiz;

@Repository
public interface Quizjpa extends JpaRepository<Quiz,Integer>{


}
  