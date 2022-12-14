package com.example.school.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String studentName;
    private String studentClass;
    private String term;
    private LocalDateTime date;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Subject> subjects;
    private double resultAverage;
}

//getResultByStudentIdAndSubject(name)
//getResultByStudentIdAndClass
//getResultByStudentIdAndTerm



