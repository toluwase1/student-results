package com.example.school.models;

import com.example.school.enums.TERM;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String subjectTitle;
    private double totalScore;
    private Long studentId;
    private String studentClass;
    @Enumerated(EnumType.STRING)
    private TERM term;

//    @ManyToMany
//    private List<Result> result;

}
