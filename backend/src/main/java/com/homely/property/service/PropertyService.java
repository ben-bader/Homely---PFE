package com.homely.property.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.common.enums.ListingType;
import com.homely.property.entity.Property;
import com.homely.property.repository.PropertyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Property create(Property property) {
        return propertyRepository.save(property);
    }

    public Property get(UUID id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    public List<Property> search(
            ListingType type,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            String city
    ) {

        if (type != null && minPrice != null && maxPrice != null) {
            return propertyRepository
                    .findByListingTypeAndPriceBetween(type, minPrice, maxPrice);
        }

        if (type != null) {
            return propertyRepository.findByListingType(type);
        }

        if (city != null && !city.isBlank()) {
            return propertyRepository.findByAddressContainingIgnoreCase(city);
        }

        return propertyRepository.findAll();
    }

    public void delete(UUID id) {
        propertyRepository.deleteById(id);
    }
}
