package com.example.school.dto;

import com.example.school.models.Subject;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ResultBaseOnClassDto {
    private String studentName;
    private String studentClass;
    private LocalDateTime date;
    private List<Subject> subjects;
    private double resultAverage;
}

//getResultByStudentIdAndSubject(name)
//getResultByStudentIdAndClass
//getResultByStudentIdAndTerm



