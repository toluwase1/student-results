package com.example.school.services.serviceImpl;

import com.example.school.dto.ResultDto;
import com.example.school.models.Result;
import com.example.school.repositories.StudentResultRepository;
import com.example.school.services.StudentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
@Service
public class StudentResultServiceImplementation implements StudentResultService {
    static String FirstTerm = "FIRST";
    static String SecondTerm = "SECOND";
    static String ThirdTerm = "THIRD";
    private EntityManager entityManager;
    @Autowired
    private StudentResultRepository studentResultRepository;


    @Transactional
    public Result createStudentResult(ResultDto resultDto) throws Exception {
//        if (resultDto.getSubjectDtos().size() < 1) {
//            throw new Exception("you cant submit an empty subject");
//        }
//        if (resultDto.getFirstName().isEmpty()) {
//            throw new Exception("you cant submit an empty first name");
//        }
//        if (resultDto.getLastName().isEmpty()) {
//            throw new Exception("you cant submit an empty last name");
//        }
//        if     (!result.getTerm().equals(FirstTerm) ||
//                !result.getTerm().equals(SecondTerm) ||
//                !result.getTerm().equals(ThirdTerm)) {
//            throw new Exception("Entries available only for First, Second Or Third terms available");
//        }
//        Result result = new Result();
//        result.setFirstName(resultDto.getFirstName());
//        result.setLastName(resultDto.getLastName());
//        result.setStudentClass(resultDto.getStudentClass());
//        result.setTerm(resultDto.getTerm());
//        result.setTeacher(resultDto.getTeacher());
//        List<Subject> subjectList = new ArrayList<>();
//        resultDto.getSubjectDtos().forEach(
//                subjectDto -> {
//                    Subject subject = new Subject();
//                    subject.setName(subjectDto.getName());
//                    subject.setScore(subjectDto.getScore());
//                    studentResultRepository.getById(result.getId());
//                    subject.setResultId(result.getId());
//                    subjectList.add(subject);
//                }
//        );

//        result.setSubjects(subjectList);
//        return studentResultRepository.save(result);
//    }

//    public Result retrieveResultsByTeacher(Result result) {
//        CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
//        CriteriaQuery<Result> criteriaQuery = criteriaBuilder.createQuery(Result.class);
//
//        Root<Result> root = criteriaQuery.from(Result.class);
//        String firstName = result.getFirstName();
//        String lastName = result.getLastName();
//        String studentClass = result.getStudentClass();
//        String term = result.getTerm();
//        String teacher = result.getTeacher();
//        List<Subject> subjectList = result.getSubjects();
//
//        List<Predicate> searchCriteria = new ArrayList<Predicate>();
//        if (firstName != "" && firstName != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName+"%"));
//        }
//
//        if (lastName != "" && lastName != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName+"%"));
//        }
//
//        if (studentClass != "" && studentClass != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("studentClass"), "%" + studentClass+"%"));
//        }
//
//        if (teacher != "" && teacher != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("teacher"), "%" + teacher+"%"));
//        }
//
//        if (term != "" && term != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("term"), "%" + term+"%"));
//        }
//
//        if (!subjectList.isEmpty() && subjectList != null) {
//            searchCriteria.add(criteriaBuilder.like(root.get("subjectList"), "%" + subjectList+"%"));
//        }
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(searchCriteria.toArray(new Predicate[searchCriteria.size()])));
//        return entityManager.createQuery(criteriaQuery).getSingleResult();
//    }

//    public Result findResultByIdAndStudentClass(Long id, String studentClass) {
//        return studentResultRepository.findResultByIdAndStudentClass(id, studentClass);
//    }
//}
//    }
    return null;
    }
}