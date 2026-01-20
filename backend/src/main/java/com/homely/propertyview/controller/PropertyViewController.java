package com.homely.propertyview.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.propertyview.entity.PropertyView;
import com.homely.propertyview.service.PropertyViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/property-views")
@RequiredArgsConstructor
public class PropertyViewController {

    private final PropertyViewService propertyViewService;

    @PostMapping
    public PropertyView create(@RequestBody PropertyView propertyView) {
        return propertyViewService.create(propertyView);
    }

    @GetMapping("/{id}")
    public PropertyView get(@PathVariable UUID id) {
        return propertyViewService.get(id);
    }

    @GetMapping
    public List<PropertyView> getAll() {
        return propertyViewService.getAll();
    }

    @GetMapping("/property/{propertyId}")
    public List<PropertyView> getByProperty(@PathVariable UUID propertyId) {
        return propertyViewService.getByProperty(propertyId);
    }

    @GetMapping("/user/{userId}")
    public List<PropertyView> getByUser(@PathVariable UUID userId) {
        return propertyViewService.getByUser(userId);
    }

    @GetMapping("/property/{propertyId}/count")
    public long countByProperty(@PathVariable UUID propertyId) {
        return propertyViewService.countByProperty(propertyId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        propertyViewService.delete(id);
    }
}