package com.elearnhub.teacher_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotNull(message = "Description cannot be null")
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Due date cannot be null")
    private LocalDateTime dueDate;

    @NotNull(message = "Max grade cannot be null")
    private Double maxGrade;

    @NotNull(message = "Course ID cannot be null")
    private Long courseId;
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment(Long id, Long courseId, String title, String description, LocalDateTime dueDate,
			Double maxGrade) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.maxGrade = maxGrade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public Double getMaxGrade() {
		return maxGrade;
	}
	public void setMaxGrade(Double maxGrade) {
		this.maxGrade = maxGrade;
	}
    
    
}