package com.example.school.dto;

import com.example.school.enums.TERM;
import com.example.school.models.Student;
import lombok.*;

@Getter
@Setter
public class RecordDto {
    private Long studentId;
    private String subjectTitle;
    private  double score;
    private TERM term;
}
