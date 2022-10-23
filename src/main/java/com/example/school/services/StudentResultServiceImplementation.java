package com.example.school.services;

import com.example.school.models.Result;
import com.example.school.repositories.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;

public class StudentResultServiceImplementation implements StudentResultService{
    static String FirstTerm = "FIRST";
    static String SecondTerm = "SECOND";
    static String ThirdTerm = "THIRD";
    private EntityManager entityManager;
    @Autowired
    private StudentResultRepository studentResultRepository;


    public Result createStudentResult(@RequestBody Result result) throws Exception {
        if (result.getSubjects().size() < 1) {
            throw new Exception("you cant submit an empty subject");
        }
        if (result.getStudentName().isEmpty()) {
            throw new Exception("you cant submit an empty name");
        }
        if     (!result.getTerm().equals(FirstTerm) ||
                !result.getTerm().equals(SecondTerm) ||
                !result.getTerm().equals(ThirdTerm)) {
            throw new Exception("Only First, Second Or Third terms available");
        }
        return studentResultRepository.save(result);
    }

    public Result retrieveResults () {

    }
}