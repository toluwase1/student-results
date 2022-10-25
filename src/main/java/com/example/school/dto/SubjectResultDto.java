package com.example.school.dto;

import com.example.school.enums.TERM;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResultDto {
    private Long studentId;
    private String subjectTitle;
    private String session;
    private TERM term;
}
