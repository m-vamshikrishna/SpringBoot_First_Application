package com.project.FirstSpringProject.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.FirstSpringProject.ownClass.Vamshi;

@Repository
public interface Javajpa extends JpaRepository<Vamshi,Long>{
    List<Vamshi> findByName(String name);
    // List<Vamshi> findByNameandAge(String name,Integer age);

    @Query(value = "SELECT * FROM vamshi ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Vamshi> getAllQuestionsByTitle(int numQ);
} 





