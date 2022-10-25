package com.example.school.services.serviceImpl;

import com.example.school.exceptions.UserAlreadyExsist;
import com.example.school.models.CLASS;
import com.example.school.models.Student;
import com.example.school.repositories.StudentRepository;
import com.example.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void registerNewStudents() throws UserAlreadyExsist {
        createClasses(CLASS.A1);
        createClasses(CLASS.A2);
        createClasses(CLASS.B1);
        createClasses(CLASS.B2);

    }

    private void createClasses(CLASS b2) throws UserAlreadyExsist {
        int i=1;
        Student st = studentRepository.findByStudentName("stud"+b2+i);
        if(st!=null) {
            throw new UserAlreadyExsist("A user with this name already exist");
        }
        while (i<=10) {
            Student s = Student.builder()
                    .studentName("stud"+b2+i)
                    .classIn(b2)
                    .build();
            studentRepository.save(s);
            i++;
        }
    }

}
