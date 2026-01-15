package com.homely.moderation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homely.moderation.entity.Report;
import com.homely.moderation.repository.AuditLogRepository;
import com.homely.moderation.repository.ReportRepository;
import com.homely.user.entity.User;
import com.homely.moderation.entity.AuditLog;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModerationService {

    private final ReportRepository reportRepository;
    private final AuditLogRepository auditLogRepository;

    public Report report(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    public void logAction(String action, User admin) {
        var log = new AuditLog();
        log.setAction(action);
        log.setAdmin(admin);
        auditLogRepository.save(log);
    }
}
