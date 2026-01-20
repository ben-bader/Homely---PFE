package com.homely.user.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.user.entity.Profile;
import com.homely.user.service.ProfileService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }
    
    @GetMapping("/{id}")
    public Profile get(@PathVariable UUID id) {
        return profileService.getById(id);
    }

    @PutMapping("/{id}")
    public Profile update(@PathVariable UUID id, @RequestBody Profile profile) {
        profile.setUserId(id); // Assuming id is userId
        return profileService.update(profile);
    }
}