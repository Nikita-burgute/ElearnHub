package com.elearnhub.teacher_service.Controller;
//
//import com.elearnhub.teacher_service.dto.CourseDTO;
//import com.elearnhub.teacher_service.entity.Course;
//import com.elearnhub.teacher_service.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/courses")
//public class CourseController {
//
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping
//    @PreAuthorize("hasRole('TEACHER')")
//    public ResponseEntity<List<CourseDTO>> getAllCourses() {
//        List<CourseDTO> courses = courseService.getAllCourses();
//        return ResponseEntity.ok(courses);
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('TEACHER')")
//    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
//        CourseDTO course = courseService.getCourseById(id);
//        if (course != null) {
//            return ResponseEntity.ok(course);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    @PreAuthorize("hasRole('TEACHER')")
//    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course) {
//        Course savedCourse = courseService.createCourse(course);
//        CourseDTO courseDTO = new CourseDTO(
//                savedCourse.getId(),
//                savedCourse.getName(),
//                savedCourse.getDescription(),
//                savedCourse.getTeacherId()
//        );
//        return ResponseEntity.status(HttpStatus.CREATED).body(courseDTO);
//    }
//
//    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('TEACHER')")
//    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody Course course) {
//        try {
//            Course updatedCourse = courseService.updateCourse(id, course);
//            CourseDTO courseDTO = new CourseDTO(
//                    updatedCourse.getId(),
//                    updatedCourse.getName(),
//                    updatedCourse.getDescription(),
//                    updatedCourse.getTeacherId()
//            );
//            return ResponseEntity.ok(courseDTO);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('TEACHER')")
//    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
//        try {
//            courseService.deleteCourse(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}



//package com.elearnhub.teacher_service.controller;

import com.elearnhub.teacher_service.dto.CourseDTO;
import com.elearnhub.teacher_service.entity.Course;
import com.elearnhub.teacher_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        CourseDTO courseDTO = new CourseDTO(
                savedCourse.getId(),
                savedCourse.getName(),
                savedCourse.getDescription(),
                savedCourse.getTeacherId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(courseDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(id, course);
            CourseDTO courseDTO = new CourseDTO(
                    updatedCourse.getId(),
                    updatedCourse.getName(),
                    updatedCourse.getDescription(),
                    updatedCourse.getTeacherId()
            );
            return ResponseEntity.ok(courseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}