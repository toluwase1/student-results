package com.example.school.services.serviceImpl;

import com.example.school.exceptions.UserAlreadyExist;
import com.example.school.models.CLASS;
import com.example.school.models.Student;
import com.example.school.models.Subject;
import com.example.school.repositories.StudentRepository;
import com.example.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void registerNewStudents() throws UserAlreadyExist {
        createClasses(CLASS.A1);
        createClasses(CLASS.A2);
        createClasses(CLASS.B1);
        createClasses(CLASS.B2);

    }

    //Creating students in the 4 classes A1,A2,B1,B2 respectively with unique Id and Names
    private void createClasses(CLASS studentClass) throws UserAlreadyExist {
        int i=1;
        Student st = studentRepository.findByStudentName("stud"+studentClass+i);
        if(st!=null) {
            throw new UserAlreadyExist("A user with this name already exist");
        }
        while (i<=10) {
            Student s = Student.builder()
                    .studentName("stud"+studentClass+i)
                    .classIn(studentClass)
                    .build();
            studentRepository.save(s);
            i++;
        }
    }

    public List<Student> findAllStudents() {
        return  studentRepository.findAll();
    }

}
