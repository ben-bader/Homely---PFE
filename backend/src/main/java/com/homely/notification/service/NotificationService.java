package com.homely.notification.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.notification.entity.Notification;
import com.homely.notification.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification notify(Notification notification) {
        return notificationRepository.save(notification);
    }
    public List<Notification> getUnreadNotifications(UUID userId) {
        return notificationRepository.findByUserIdAndReadFalse(userId);
    }
}
