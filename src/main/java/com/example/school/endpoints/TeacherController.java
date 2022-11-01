package com.example.school.endpoints;

import com.example.school.dto.ClassResultDto;
import com.example.school.dto.RecordDto;
import com.example.school.dto.ResultBaseOnClassDto;
import com.example.school.dto.SubjectResultDto;
import com.example.school.exceptions.SubjectNotFoundException;
import com.example.school.models.Result;
import com.example.school.models.SubjectResult;
import com.example.school.services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/register-student-subject/{studentId}")
    public ResponseEntity<String>registerStudentSubjectsByTeacher(@PathVariable Long studentId) throws SubjectNotFoundException {
        String reg = teacherService.recordStudentSubjects(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(reg);
    }

    @PostMapping("/record-scores-for-student")
    public ResponseEntity<String>recordStudentScore(@RequestBody RecordDto record) throws SubjectNotFoundException {
        String rec = teacherService.recordScoreForEachStudentSubject(record);
        return ResponseEntity.status(HttpStatus.OK).body(rec);
    }

    @PostMapping("/get-student-result/{studentId}")
    public ResponseEntity<Result> getStudentResult(@PathVariable Long studentId) {
        Result result = teacherService.getStudentResult(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/student-subject-result")
    public ResponseEntity<SubjectResult>teacherGetsStudentResultBySubject(@RequestBody SubjectResultDto subjectResultDto) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getStudentResultBySubject(subjectResultDto));
    }

    @PostMapping("/student-result-by-class")
    public ResponseEntity<ResultBaseOnClassDto>teacherGetsStudentResultByClass(@RequestBody ClassResultDto classResultDto) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getStudentResultByClass(classResultDto));
    }
}
