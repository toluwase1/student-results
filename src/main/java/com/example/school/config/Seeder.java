package com.example.school.config;

import com.example.school.exceptions.RegisteredSubjectsAlreadyException;
import com.example.school.exceptions.UserAlreadyExist;
import com.example.school.models.Student;
import com.example.school.services.serviceImpl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private SchoolServiceImpl schoolService;

    @Override
    public void run(String... args) {
        List<Student> subjectList = schoolService.findAllStudents();
        try {
            if (subjectList.size() < 1) {
                schoolService.registerNewStudents();
            }
        } catch (UserAlreadyExist e) {
            throw new RegisteredSubjectsAlreadyException("Students already created!");
        }
    }
}
