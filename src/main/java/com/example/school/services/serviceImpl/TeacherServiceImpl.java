package com.example.school.services.serviceImpl;

import com.example.school.dto.ClassResultDto;
import com.example.school.dto.RecordDto;
import com.example.school.dto.ResultBaseOnClassDto;
import com.example.school.dto.SubjectResultDto;
import com.example.school.exceptions.NoRecordFoundException;
import com.example.school.exceptions.RegisteredSubjectsAlreadyException;
import com.example.school.exceptions.SubjectNotFoundException;
import com.example.school.exceptions.UserNotFoundException;
import com.example.school.models.*;
import com.example.school.repositories.StudentRepository;
import com.example.school.repositories.StudentResultRepository;
import com.example.school.repositories.SubjectRepository;
import com.example.school.repositories.SubjectResultRepository;
import com.example.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectResultRepository subjectResultRepository;

    @Autowired
    private StudentResultRepository resultRepository;


    @Override
    public String recordStudentSubjects(Long studentId) {
        Optional<Student> student = Optional.ofNullable(studentRepository.findById(studentId)
                .orElseThrow(() -> new UserNotFoundException("User with id not found")));
            Student stud  = new Student();
        if(student.isPresent()) {
            stud = student.get();
        } else {
            throw new RuntimeException(new UserNotFoundException("An empty user"));
        }


        if(stud.getClassIn().equals(CLASS.A1)){
            String [] a1Subjects = {"Maths","English","Writing","General Science"};
            extractAndRegisterSubjects(stud, a1Subjects);
        } else if(stud.getClassIn()== CLASS.A2){
            String [] a1Subjects = {"Maths","Arts","Economics","English"};
            extractAndRegisterSubjects(stud, a1Subjects);
        }else if(stud.getClassIn().equals(CLASS.B1)){
            String [] a1Subjects = {"Maths","English","Biology","Physics","Chemistry","Geography"};
            extractAndRegisterSubjects(stud, a1Subjects);

        }if(stud.getClassIn().equals(CLASS.B2)){
            String [] a1Subjects = {"Maths","Painting","Drawing","Music","Accounting","English"};
            extractAndRegisterSubjects(stud, a1Subjects);
        }

        return "Registered successfully";
    }

    @Override
    public String recordScoreForEachStudentSubject(RecordDto record) throws SubjectNotFoundException {
        Subject sub = subjectRepository.findByStudentIdAndSubjectTitle(record.getStudentId(), record.getSubjectTitle());
        if(sub!=null) {
            sub.setTotalScore(record.getScore());
            sub.setTerm(record.getTerm());
            subjectRepository.save(sub);
        } else {
            throw new SubjectNotFoundException("The subject or Student you are looking for does not exist");
        }
        return "Recorded successfully";
    }

    @Override
    public Result getStudentResult(Long studentId) {
        Optional<Student> student = Optional.of(studentRepository.findById(studentId).
                orElseThrow(()->new UserNotFoundException("User with credentials not found")));
        List<Subject> subject = (List<Subject>) subjectRepository.findAllByStudentId(student.get().getId());
        if(subject.isEmpty()) {
            throw new NoRecordFoundException("Not record found for student");
        }
        double totalScore = 0.0;
        int n =0;
        for (Subject s:subject) {
            totalScore+=s.getTotalScore();
            n++;
        }
        double averageScore = totalScore/n;

        Result result = Result.builder()
                .subjects(subject)
                .date(LocalDateTime.now())
                .resultAverage(averageScore)
                .studentName(student.get().getStudentName())
                .studentClass(String.valueOf(student.get().getClassIn()))
                .term(String.valueOf(subject.get(1).getTerm()))
                .build();

        return resultRepository.save(result);
    }

    @Override
    public SubjectResult getStudentResultBySubject(SubjectResultDto subjectResultDto) {
        Optional<Student> stud = studentRepository.findById(subjectResultDto.getStudentId());
        Subject subject = subjectRepository.findByStudentIdAndSubjectTitle(subjectResultDto.getStudentId(), subjectResultDto.getSubjectTitle());
        String name = "";
        if(stud.isPresent()) {
             name = stud.get().getStudentName();
        } else {
            throw new NoRecordFoundException("No such record was found");
        }
        if(subject==null) {
            throw new NoRecordFoundException("No such record Found");
        }

        SubjectResult subjectResult = SubjectResult.builder()
                .subjectName(subject.getSubjectTitle())
                .studentName(name)
                .totalScore(subject.getTotalScore())
                .term(subjectResultDto.getTerm())
                .session(subjectResultDto.getSession())
                .date(LocalDateTime.now())
                .build();
        return subjectResultRepository.save(subjectResult);
    }

    @Override
    public ResultBaseOnClassDto getStudentResultByClass(ClassResultDto classResultDto) {
        Optional<Student> stud = studentRepository.findById(classResultDto.getStudentId());
        List<Subject> subject = subjectRepository.findByStudentIdAndStudentClass(classResultDto.getStudentId(), classResultDto.getStudentClass());
        String name = "";
        if(stud.isPresent()) {
            name = stud.get().getStudentName();
        } else {
            throw new NoRecordFoundException("No such record was found");
        }
        if(subject==null) {
            throw new NoRecordFoundException("No such record Found");
        }

        double totalScoreForClass = 0.0;
        for (Subject s: subject) {
            totalScoreForClass+=s.getTotalScore();
        }
        double average = totalScoreForClass/ subject.size();

        return ResultBaseOnClassDto.builder()
                .studentClass(String.valueOf(stud.get().getClassIn()))
                .date(LocalDateTime.now())
                .resultAverage(average)
                .studentName(stud.get().getStudentName())
                .subjects(subject)
                .build();
    }

    private void extractAndRegisterSubjects(Student student, String[] a1Subjects) {
        Subject sub = subjectRepository.findByStudentId(student.getId());
        if(sub!=null)
            throw new RegisteredSubjectsAlreadyException("You have registered subjects already!");

        for (String a1Subject : a1Subjects) {
            Subject subject = Subject.builder()
                    .studentId(student.getId())
                    .subjectTitle(a1Subject)
                    .build();
            subjectRepository.save(subject);
        }
    }
}

