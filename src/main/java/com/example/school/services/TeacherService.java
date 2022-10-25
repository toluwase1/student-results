package com.example.school.services;

import com.example.school.dto.*;
import com.example.school.exceptions.SubjectNotFoundException;
import com.example.school.models.Result;
import com.example.school.models.Student;
import com.example.school.models.SubjectResult;

public interface TeacherService {
    String recordStudentScore(RecordDto record);
    String recordStudentSubjects(Long studentId);
    String recordScoreForEachStudentSubject(RecordDto record) throws SubjectNotFoundException;

    Result getStudentResult(Long studentId);

    SubjectResult getStudentResultBySubject(SubjectResultDto subjectResultDto);
    ResultBaseOnClassDto getStudentResultByClass(ClassResultDto classResultDto);
}
