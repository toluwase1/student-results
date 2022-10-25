package com.example.school.services;


import com.example.school.exceptions.UserAlreadyExist;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService {
    void registerNewStudents () throws UserAlreadyExist;
}
