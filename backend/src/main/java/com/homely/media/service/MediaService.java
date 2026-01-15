package com.homely.media.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.media.entity.PropertyMedia;
import com.homely.media.repository.PropertyMediaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final PropertyMediaRepository mediaRepository;

    public PropertyMedia add(PropertyMedia media) {
        return mediaRepository.save(media);
    }

    public void delete(UUID id) {
        mediaRepository.deleteById(id);
    }
}

