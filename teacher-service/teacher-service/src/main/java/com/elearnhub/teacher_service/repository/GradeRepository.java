package com.elearnhub.teacher_service.repository;

//package com.elearnhub.teacherservice.repository;

//import com.elearnhub.teacherservice.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elearnhub.teacher_service.entity.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findBySubmissionId(Long submissionId);
}