package com.example.school.services;


import com.example.school.dto.StudentDto;
import com.example.school.exceptions.UserAlreadyExsist;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService {
    void registerNewStudents () throws UserAlreadyExsist;
}
