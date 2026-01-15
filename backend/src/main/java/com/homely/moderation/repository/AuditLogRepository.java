package com.homely.moderation.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homely.moderation.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {
}