package com.homely.property.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homely.common.enums.ListingType;
import com.homely.property.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, UUID> {

    List<Property> findByListingType(ListingType listingType);

    List<Property> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Property> findByAddressContainingIgnoreCase(String city);

    List<Property> findByStatus(String status);

    List<Property> findBySellerId(UUID sellerId);

    List<Property> findByListingTypeAndPriceBetween(
            ListingType type,
            BigDecimal min,
            BigDecimal max
    );
}
