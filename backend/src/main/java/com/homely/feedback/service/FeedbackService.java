package com.homely.feedback.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.feedback.entity.Feedback;
import com.homely.feedback.repository.FeedbackRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback get(UUID id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    public List<Feedback> getByProperty(UUID propertyId) {
        return feedbackRepository.findByPropertyId(propertyId);
    }

    public List<Feedback> getByUser(UUID userId) {
        return feedbackRepository.findByUserId(userId);
    }

    public void delete(UUID id) {
        feedbackRepository.deleteById(id);
    }
}