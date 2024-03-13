package com.project.FirstSpringProject.ownClass;


import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Vamshi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vamshi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer age;
    @Column(nullable = false)
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

}
