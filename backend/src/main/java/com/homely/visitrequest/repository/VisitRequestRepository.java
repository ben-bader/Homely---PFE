package com.homely.visitrequest.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homely.common.enums.VisitStatus;
import com.homely.visitrequest.entity.VisitRequest;

public interface VisitRequestRepository extends JpaRepository<VisitRequest, UUID> {
    List<VisitRequest> findByPropertyId(UUID propertyId);
    List<VisitRequest> findByUserId(UUID userId);
    List<VisitRequest> findByStatus(VisitStatus status);
}