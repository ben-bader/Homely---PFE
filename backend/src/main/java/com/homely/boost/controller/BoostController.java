package com.homely.boost.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homely.boost.entity.BoostPurchase;
import com.homely.boost.service.BoostService;

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
}
