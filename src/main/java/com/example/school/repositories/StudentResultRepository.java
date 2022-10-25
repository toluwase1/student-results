package com.example.school.repositories;

import com.example.school.models.Result;
import com.example.school.models.School;
import com.example.school.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentResultRepository extends JpaRepository<Result, Long> {
//    Result findResultByIdAndStudentClass(Long id, String studentClass);
//    Result findResultByIdAndTerm(Long id, String term);
//
//    Result findResultByIdAndSubjects(Long id, List<Subject> subjects);
}
//getResultByStudentIdAndSubject(name)
//getResultByStudentIdAndClass
//getResultByStudentIdAndTerm
