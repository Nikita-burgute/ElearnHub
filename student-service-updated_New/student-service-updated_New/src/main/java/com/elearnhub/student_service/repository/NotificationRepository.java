package com.elearnhub.student_service.repository;

import com.elearnhub.student_service.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}