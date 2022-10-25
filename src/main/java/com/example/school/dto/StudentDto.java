package com.example.school.dto;

import com.example.school.models.CLASS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String studentName;
    private CLASS classIn;
}
