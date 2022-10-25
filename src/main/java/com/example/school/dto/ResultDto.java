package com.example.school.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultDto {
    private String firstName;
    private String lastName;
    private String studentClass;
    private String term;
    private String teacher;
    private List<SubjectDto> subjectDtos;

    @Override
    public String toString() {
        return "ResultDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", term='" + term + '\'' +
                ", teacher='" + teacher + '\'' +
                ", subjectDtos=" + subjectDtos +
                '}';
    }
}
