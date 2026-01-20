package com.homely.property.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homely.common.enums.ListingType;
import com.homely.common.enums.PropertyType;
import com.homely.property.entity.Property;
import com.homely.property.service.PropertyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    public Property create(@RequestBody Property property) {
  /*       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null || authentication.getName().equals("anonymousUser")) {
            throw new RuntimeException("Authentication required. Please provide a valid JWT token.");
        } */
        return propertyService.create(property);
    }

    
    @GetMapping("/{id}")
    public Property get(@PathVariable UUID id) {
        return propertyService.get(id);
    }

    @GetMapping
    public List<Property> all() {
        return propertyService.getAll();
    }
    @GetMapping("/search")
    public List<Property> search(
            @RequestParam(required = false) ListingType type,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String city
    ) {
        return propertyService.search(type, minPrice, maxPrice, city);
    }

    @GetMapping("/type/{propertyType}")
    public List<Property> findByPropertyType(@PathVariable PropertyType propertyType) {
        return propertyService.findByPropertyType(propertyType);
    }
}
