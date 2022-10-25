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
//    Optional<Subject> findByIdAndName(Long id, String name);

//getResultByStudentIdAndSubject(name)
//getResultByStudentIdAndClass
//getResultByStudentIdAndTerm

/*
List<Product> findAllByNameLikeAndCategoryInAndPriceBetweenAndManufacturingPlace_State(String name,
                                             List<Category> categories,
                                             Double bottom, Double top,
                                             STATE state);
 */

//RETRIEVE RESULTS WITH subjects
// The application should as well allow the school to retrieve all the scores of all subjects of
// any student, for any selected term, displaying the average score as well.