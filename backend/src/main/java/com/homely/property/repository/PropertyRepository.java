package com.homely.property.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homely.common.enums.ListingType;
import com.homely.common.enums.PropertyType;
import com.homely.property.entity.Property;


public interface PropertyRepository extends JpaRepository<Property, UUID> {

    List<Property> findByListingType(ListingType listingType);

    List<Property> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Property> findByAddressContainingIgnoreCase(String city);

    List<Property> findByStatus(String status);
    List<Property> findByPropertyType(PropertyType propertyType);
   @Query("""
    SELECT p FROM Property p
    WHERE (:type IS NULL OR p.listingType = :type)
    AND (:city IS NULL OR LOWER(p.address) LIKE LOWER(CONCAT('%', :city, '%')))
    AND (:minPrice IS NULL OR p.price >= :minPrice)
    AND (:maxPrice IS NULL OR p.price <= :maxPrice)
    """)
    List<Property> search(
        @Param("type") ListingType type,
        @Param("city") String city,
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice
    );

}
