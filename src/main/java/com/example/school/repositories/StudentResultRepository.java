package com.example.school.repositories;

import com.example.school.models.Result;
import com.example.school.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultRepository extends JpaRepository<Result, Long> {
    public Result RetrieveStudentResult();
    public Result storeStudentResult();
}
