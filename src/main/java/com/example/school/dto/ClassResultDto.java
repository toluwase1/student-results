package com.example.school.dto;

import com.example.school.enums.TERM;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassResultDto {
    private Long studentId;
    private String studentClass;
    private String session;
}
