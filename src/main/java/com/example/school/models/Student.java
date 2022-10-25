package com.example.school.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String studentName;
    @Enumerated(EnumType.STRING)
    private CLASS classIn;
    @OneToMany
    private List<Subject> subjectsOffering;

}
