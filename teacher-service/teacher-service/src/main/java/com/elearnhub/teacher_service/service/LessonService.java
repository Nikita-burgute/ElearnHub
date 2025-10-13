package com.elearnhub.teacher_service.service;


import com.elearnhub.teacher_service.entity.Lesson;
import com.elearnhub.teacher_service.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson existingLesson = lessonRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setContent(lesson.getContent());
        existingLesson.setFilePath(lesson.getFilePath());
        existingLesson.setCourseId(lesson.getCourseId());
        return lessonRepository.save(existingLesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}