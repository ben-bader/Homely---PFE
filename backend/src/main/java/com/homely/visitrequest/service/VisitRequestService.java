package com.homely.visitrequest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.common.enums.VisitStatus;
import com.homely.visitrequest.entity.VisitRequest;
import com.homely.visitrequest.repository.VisitRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitRequestService {

    private final VisitRequestRepository visitRequestRepository;

    public VisitRequest create(VisitRequest visitRequest) {
        return visitRequestRepository.save(visitRequest);
    }

    public VisitRequest get(UUID id) {
        return visitRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitRequest not found"));
    }

    public List<VisitRequest> getAll() {
        return visitRequestRepository.findAll();
    }

    public List<VisitRequest> getByProperty(UUID propertyId) {
        return visitRequestRepository.findByPropertyId(propertyId);
    }

    public List<VisitRequest> getByUser(UUID userId) {
        return visitRequestRepository.findByUserId(userId);
    }

    public List<VisitRequest> getByStatus(VisitStatus status) {
        return visitRequestRepository.findByStatus(status);
    }

    public VisitRequest updateStatus(UUID id, VisitStatus status) {
        VisitRequest request = get(id);
        request.setStatus(status);
        return visitRequestRepository.save(request);
    }

    public void delete(UUID id) {
        visitRequestRepository.deleteById(id);
    }
}