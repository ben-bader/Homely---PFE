package com.homely.boost.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homely.boost.entity.BoostPurchase;
import com.homely.boost.service.BoostService;
import com.homely.common.enums.PurchaseStatus;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/boost")
@RequiredArgsConstructor
public class BoostController {

    private final BoostService boostService;

    @PostMapping
    public BoostPurchase boost(@RequestBody BoostPurchase boost) {
        return boostService.create(boost);
    }
    @GetMapping("/{id}")
    public BoostPurchase getById(@PathVariable UUID id) {
        return boostService.getById(id);
    }
    @GetMapping("/status")
    public List<BoostPurchase> getByStatus(@RequestParam PurchaseStatus status) {
        return boostService.getByStatus(status);
    }

    @GetMapping("/seller")
    public List<BoostPurchase> getBySellerId(@RequestParam UUID sellerId) {
        return boostService.getBySellerId(sellerId);
    }
    @GetMapping("/all")
    public List<BoostPurchase> getAll() {
        return boostService.getAll();
    }
    
    
}
