package com.elearnhub.teacher_service.service;


import com.elearnhub.teacher_service.entity.Assignment;
import com.elearnhub.teacher_service.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {
        Assignment existingAssignment = assignmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));
        existingAssignment.setTitle(assignment.getTitle());
        existingAssignment.setDescription(assignment.getDescription());
        existingAssignment.setDueDate(assignment.getDueDate());
        existingAssignment.setMaxGrade(assignment.getMaxGrade());
        existingAssignment.setCourseId(assignment.getCourseId());
        return assignmentRepository.save(existingAssignment);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}