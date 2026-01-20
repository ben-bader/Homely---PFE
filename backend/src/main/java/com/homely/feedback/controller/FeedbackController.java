package com.homely.feedback.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.feedback.entity.Feedback;
import com.homely.feedback.service.FeedbackService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.create(feedback);
    }

    @GetMapping("/{id}")
    public Feedback get(@PathVariable UUID id) {
        return feedbackService.get(id);
    }

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAll();
    }

    @GetMapping("/property/{propertyId}")
    public List<Feedback> getByProperty(@PathVariable UUID propertyId) {
        return feedbackService.getByProperty(propertyId);
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> getByUser(@PathVariable UUID userId) {
        return feedbackService.getByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        feedbackService.delete(id);
    }
}