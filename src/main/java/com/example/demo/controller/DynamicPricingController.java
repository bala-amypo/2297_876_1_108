package com.example.demo.controller;

import com.example.demo.service.DynamicPricingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricing")
public class DynamicPricingController {

    private final DynamicPricingService pricingService;

    public DynamicPricingController(DynamicPricingService pricingService) {
        this.pricingService = pricingService;
    }

    @GetMapping("/compute/{eventId}")
    public Double computePrice(@PathVariable Long eventId) {
        return pricingService.computeDynamicPrice(eventId);
    }
}
