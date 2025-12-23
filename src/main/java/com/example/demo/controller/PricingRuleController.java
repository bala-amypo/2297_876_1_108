package com.example.demo.controller;

import com.example.demo.service.DynamicPricingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
public class PricingRuleController {

    private final DynamicPricingService pricingService;

    public PricingController(DynamicPricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("/{eventId}")
    public double getPrice(@PathVariable Long eventId) {
        return pricingService.calculatePrice(eventId);
    }
}
