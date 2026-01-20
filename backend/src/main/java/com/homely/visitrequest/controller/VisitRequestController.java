package com.homely.visitrequest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homely.common.enums.VisitStatus;
import com.homely.visitrequest.entity.VisitRequest;
import com.homely.visitrequest.service.VisitRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/visit-requests")
@RequiredArgsConstructor
public class VisitRequestController {

    private final VisitRequestService visitRequestService;

    @PostMapping
    public VisitRequest create(@RequestBody VisitRequest visitRequest) {
        return visitRequestService.create(visitRequest);
    }

    @GetMapping("/{id}")
    public VisitRequest get(@PathVariable UUID id) {
        return visitRequestService.get(id);
    }

    @GetMapping
    public List<VisitRequest> getAll() {
        return visitRequestService.getAll();
    }

    @GetMapping("/property/{propertyId}")
    public List<VisitRequest> getByProperty(@PathVariable UUID propertyId) {
        return visitRequestService.getByProperty(propertyId);
    }

    @GetMapping("/user/{userId}")
    public List<VisitRequest> getByUser(@PathVariable UUID userId) {
        return visitRequestService.getByUser(userId);
    }

    @GetMapping("/status")
    public List<VisitRequest> getByStatus(@RequestParam VisitStatus status) {
        return visitRequestService.getByStatus(status);
    }

    @PutMapping("/{id}/status")
    public VisitRequest updateStatus(@PathVariable UUID id, @RequestParam VisitStatus status) {
        return visitRequestService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        visitRequestService.delete(id);
    }
}