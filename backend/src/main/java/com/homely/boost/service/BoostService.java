package com.homely.boost.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.homely.boost.entity.BoostPurchase;
import com.homely.boost.repository.BoostPurchaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoostService {

    private final BoostPurchaseRepository boostRepository;

    public BoostPurchase create(BoostPurchase boost) {
        return boostRepository.save(boost);
    }
    public BoostPurchase getById(UUID id) {
        return boostRepository.findById(id).orElse(null);
    }
    public BoostPurchase getBySellerId(UUID sellerId) {
        return boostRepository.findById(sellerId).orElse(null);
    }
    public BoostPurchase getBBSStatus(String status) {
        return boostRepository.findById(UUID.fromString(status)).orElse(null);
    }
}
