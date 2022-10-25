package com.example.school.repositories;

import com.example.school.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByStudentId(Long id);

    Subject findByStudentIdAndSubjectTitle(Long studentId, String subjectTitle);
    @Query("select s from Subject s WHERE s.studentId = ?1 AND s.studentClass=?2")
    List<Subject> findByStudentIdAndStudentClass(Long studentId, String studentClass);

    @Query("select s from Subject s WHERE s.studentId = ?1")
    List<Subject> findAllByStudentId(Long id);

}