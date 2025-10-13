package com.elearnhub.student_service.service;

import com.elearnhub.student_service.entity.Submission;
import com.elearnhub.student_service.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    // Add a new submission
    public Submission addSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    // Get all submissions
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    // Get submission by ID
    public Optional<Submission> getSubmissionById(Long submissionId) {
        return submissionRepository.findById(submissionId);
    }

    // Update submission
    public Submission updateSubmission(Long submissionId, Submission submissionDetails) {
        Optional<Submission> existingSubmission = submissionRepository.findById(submissionId);
        if (existingSubmission.isPresent()) {
            Submission submission = existingSubmission.get();
            submission.setUsername(submissionDetails.getUsername());
            submission.setAssignmentId(submissionDetails.getAssignmentId());
            submission.setContent(submissionDetails.getContent());
            return submissionRepository.save(submission);
        } else {
            throw new RuntimeException("Submission not found with id: " + submissionId);
        }
    }

    // Delete submission
    public void deleteSubmission(Long submissionId) {
        Optional<Submission> submission = submissionRepository.findById(submissionId);
        if (submission.isPresent()) {
            submissionRepository.deleteById(submissionId);
        } else {
            throw new RuntimeException("Submission not found with id: " + submissionId);
        }
    }
}