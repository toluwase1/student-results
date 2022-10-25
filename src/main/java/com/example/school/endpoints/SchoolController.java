package com.example.school.endpoints;


import com.example.school.dto.ResultDto;
import com.example.school.exceptions.UserAlreadyExsist;
import com.example.school.models.Result;
import com.example.school.services.SchoolService;
import com.example.school.services.serviceImpl.SchoolServiceImpl;
import com.example.school.services.serviceImpl.StudentResultServiceImplementation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/school")
@Slf4j
public class SchoolController {
    @Autowired
    private final SchoolServiceImpl schoolService;

    @GetMapping("/createStudents")
    public  ResponseEntity<String> registerStudents() throws UserAlreadyExsist {
        schoolService.registerNewStudents();
        return ResponseEntity.status(HttpStatus.OK).body("Students created successfully");
    }
}
