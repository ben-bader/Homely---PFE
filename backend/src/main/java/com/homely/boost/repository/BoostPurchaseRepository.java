package com.homely.boost.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homely.boost.entity.BoostPurchase;
import com.homely.common.enums.PurchaseStatus;

public interface BoostPurchaseRepository extends JpaRepository<BoostPurchase, UUID> {
    List<BoostPurchase> findBySellerId(UUID sellerId);

    List<BoostPurchase> findByStatus(PurchaseStatus status);

}

