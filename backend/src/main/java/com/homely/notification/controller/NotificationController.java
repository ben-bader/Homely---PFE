package com.homely.notification.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.notification.entity.Notification;
import com.homely.notification.service.NotificationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications(@RequestParam UUID userId) {
        return notificationService.getUnreadNotifications(userId);
    }
    

    @PostMapping
    public Notification notify(@RequestBody Notification n) {
        return notificationService.notify(n);
    }
}
