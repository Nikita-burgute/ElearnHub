package com.elearnhub.student_service.controller;

import com.elearnhub.student_service.entity.Notification;
import com.elearnhub.student_service.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Add a new notification
    @PostMapping
    public ResponseEntity<String> createNotification(@Valid @RequestBody Notification notification) {
        notificationService.addNotification(notification);
        return ResponseEntity.ok("Notification created successfully!");
    }

    // Get all notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    // Get notification by ID
    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notificationId) {
        return notificationService.getNotificationById(notificationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update notification
    @PutMapping("/{notificationId}")
    public ResponseEntity<String> updateNotification(@PathVariable Long notificationId, @Valid @RequestBody Notification notificationDetails) {
        notificationService.updateNotification(notificationId, notificationDetails);
        return ResponseEntity.ok("Notification updated successfully!");
    }

    // Delete notification
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok("Notification deleted successfully!");
    }
}