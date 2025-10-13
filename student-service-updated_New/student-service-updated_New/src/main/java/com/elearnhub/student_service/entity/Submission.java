package com.elearnhub.student_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotNull(message = "Assignment ID cannot be null")
    @Size(min = 1, max = 50, message = "Assignment ID must be between 1 and 50 characters")
    private String assignmentId;

    @NotNull(message = "Content cannot be null")
    @Size(min = 1, max = 1000, message = "Content must be between 1 and 1000 characters")
    private String content;

    // Default constructor
    public Submission() {
    }

    // Parameterized constructor
    public Submission(Long submissionId, String username, String assignmentId, String content) {
        this.submissionId = submissionId;
        this.username = username;
        this.assignmentId = assignmentId;
        this.content = content;
    }

    // Getter and Setter methods
    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}