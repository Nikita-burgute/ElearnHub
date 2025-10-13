package com.elearnhub.teacher_service.repository;

//package com.elearnhub.teacher_service.repository;

import com.elearnhub.teacher_service.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);
}