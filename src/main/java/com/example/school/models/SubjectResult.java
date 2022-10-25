package com.example.school.models;

import com.example.school.enums.TERM;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    private String subjectName;
    private String studentName;
    @Enumerated(EnumType.STRING)
    private TERM term;
    private String session;
    private LocalDateTime date;
    private double totalScore;
}
