package com.homely.propertyview.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.propertyview.entity.PropertyView;
import com.homely.propertyview.repository.PropertyViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropertyViewService {

    private final PropertyViewRepository propertyViewRepository;

    public PropertyView create(PropertyView propertyView) {
        return propertyViewRepository.save(propertyView);
    }

    public PropertyView get(UUID id) {
        return propertyViewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PropertyView not found"));
    }

    public List<PropertyView> getAll() {
        return propertyViewRepository.findAll();
    }

    public List<PropertyView> getByProperty(UUID propertyId) {
        return propertyViewRepository.findByPropertyId(propertyId);
    }

    public List<PropertyView> getByUser(UUID userId) {
        return propertyViewRepository.findByUserId(userId);
    }

    public long countByProperty(UUID propertyId) {
        return propertyViewRepository.countByPropertyId(propertyId);
    }

    public void delete(UUID id) {
        propertyViewRepository.deleteById(id);
    }
}