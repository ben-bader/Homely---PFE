package com.homely.moderation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.moderation.entity.Report;
import com.homely.moderation.service.ModerationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ModerationService moderationService;

    @GetMapping("/reports")
    public List<Report> reports() {
        return moderationService.getReports();
    }
}
