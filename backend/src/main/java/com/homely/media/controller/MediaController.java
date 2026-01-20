package com.homely.media.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.media.entity.PropertyMedia;
import com.homely.media.service.MediaService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping
    public PropertyMedia upload(@RequestBody PropertyMedia media) {
        return mediaService.add(media);
    }
    @PutMapping("/{id}")
    public void putMethodName(@PathVariable UUID property_id) {
        mediaService.delete(property_id);
    }
}
