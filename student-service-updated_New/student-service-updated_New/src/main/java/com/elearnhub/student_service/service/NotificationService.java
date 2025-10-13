package com.elearnhub.student_service.service;

import com.elearnhub.student_service.entity.Notification;
import com.elearnhub.student_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Add a new notification
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get notification by ID
    public Optional<Notification> getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    // Update notification
    public Notification updateNotification(Long notificationId, Notification notificationDetails) {
        Optional<Notification> existingNotification = notificationRepository.findById(notificationId);
        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            notification.setUserId(notificationDetails.getUserId());
            notification.setMessage(notificationDetails.getMessage());
            notification.setCreatedAt(notificationDetails.getCreatedAt());
            return notificationRepository.save(notification);
        } else {
            throw new RuntimeException("Notification not found with id: " + notificationId);
        }
    }

    // Delete notification
    public void deleteNotification(Long notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isPresent()) {
            notificationRepository.deleteById(notificationId);
        } else {
            throw new RuntimeException("Notification not found with id: " + notificationId);
        }
    }
}