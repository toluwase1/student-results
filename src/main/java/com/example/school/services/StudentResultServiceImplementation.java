package com.example.school.services;

import com.example.school.models.Result;
import com.example.school.models.Student;
import com.example.school.models.Subject;
import com.example.school.repositories.StudentResultRepository;
import org.hibernate.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
        if (result.getFirstName().isEmpty()) {
            throw new Exception("you cant submit an empty first name");
        }
        if (result.getLastName().isEmpty()) {
            throw new Exception("you cant submit an empty last name");
        }
        if     (!result.getTerm().equals(FirstTerm) ||
                !result.getTerm().equals(SecondTerm) ||
                !result.getTerm().equals(ThirdTerm)) {
            throw new Exception("Entries available only for First, Second Or Third terms available");
        }
        return studentResultRepository.save(result);
    }

    public Result retrieveResults (Result result) {
        CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
        CriteriaQuery<Result> criteriaQuery = criteriaBuilder.createQuery(Result.class);

        Root<Result> root = criteriaQuery.from(Result.class);
        String firstName = result.getFirstName();
        String lastName = result.getLastName();
        String studentClass = result.getStudentClass();
        String term = result.getTerm();
        String teacher = result.getTeacher();
        List<Subject> subjectList = result.getSubjects();

        List<Predicate> searchCriteria = new ArrayList<Predicate>();
        if (firstName != "" && firstName != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName+"%"));
        }

        if (lastName != "" && lastName != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName+"%"));
        }

        if (studentClass != "" && studentClass != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("studentClass"), "%" + studentClass+"%"));
        }

        if (teacher != "" && teacher != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("teacher"), "%" + teacher+"%"));
        }

        if (term != "" && term != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("term"), "%" + term+"%"));
        }

        if (!subjectList.isEmpty() && subjectList != null) {
            searchCriteria.add(criteriaBuilder.like(root.get("subjectList"), "%" + subjectList+"%"));
        }

        criteriaQuery.select(root).where(criteriaBuilder.and(searchCriteria.toArray(new Predicate[searchCriteria.size()])));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
