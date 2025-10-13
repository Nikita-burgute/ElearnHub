package com.elearnhub.student_service.controller;

import com.elearnhub.student_service.entity.Submission;
import com.elearnhub.student_service.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    // Add a new submission
    @PostMapping
    public ResponseEntity<String> submitAssignment(@Valid @RequestBody Submission submission) {
        submissionService.addSubmission(submission);
        return ResponseEntity.ok("Submission successful!");
    }

    // Get all submissions
    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        List<Submission> submissions = submissionService.getAllSubmissions();
        return ResponseEntity.ok(submissions);
    }

    // Get submission by ID
    @GetMapping("/{submissionId}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable Long submissionId) {
        return submissionService.getSubmissionById(submissionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update submission
    @PutMapping("/{submissionId}")
    public ResponseEntity<String> updateSubmission(@PathVariable Long submissionId, @Valid @RequestBody Submission submissionDetails) {
        submissionService.updateSubmission(submissionId, submissionDetails);
        return ResponseEntity.ok("Submission updated successfully!");
    }

    // Delete submission
    @DeleteMapping("/{submissionId}")
    public ResponseEntity<String> deleteSubmission(@PathVariable Long submissionId) {
        submissionService.deleteSubmission(submissionId);
        return ResponseEntity.ok("Submission deleted successfully!");
    }
}