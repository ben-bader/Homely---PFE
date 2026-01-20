package com.homely.boost.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.boost.entity.BoostPurchase;
import com.homely.boost.repository.BoostPurchaseRepository;
import com.homely.common.enums.PurchaseStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoostService {

    private final BoostPurchaseRepository boostPurchaseRepository;

    public BoostPurchase create(BoostPurchase boost) {
        return boostPurchaseRepository.save(boost);
    }

    public BoostPurchase getById(UUID id) {
        return boostPurchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boost not found"));
    }

    public List<BoostPurchase> getByStatus(PurchaseStatus status) {
        return boostPurchaseRepository.findByStatus(status);
    }

    public List<BoostPurchase> getBySellerId(UUID sellerId) {
        return boostPurchaseRepository.findBySellerId(sellerId);
    }

    public List<BoostPurchase> getAll() {
        return boostPurchaseRepository.findAll();
    }
}
