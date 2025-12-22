package com.example.demo.controller;

import com.example.demo.model.DynamicPriceRecord;
import com.example.demo.service.DynamicPricingEngineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dynamic-pricing")
@Tag(name = "Dynamic Pricing Engine")
public class DynamicPricingController {

    private final DynamicPricingEngineService pricingService;

    public DynamicPricingController(
            DynamicPricingEngineService pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping("/compute/{eventId}")
    public DynamicPriceRecord computePrice(
            @PathVariable Long eventId) {
        return pricingService.computeDynamicPrice(eventId);
    }

    @GetMapping("/latest/{eventId}")
    public Optional<DynamicPriceRecord> latestPrice(
            @PathVariable Long eventId) {
        return pricingService.getLatestPrice(eventId);
    }

    @GetMapping("/history/{eventId}")
    public List<DynamicPriceRecord> priceHistory(
            @PathVariable Long eventId) {
        return pricingService.getPriceHistory(eventId);
    }

    @GetMapping
    public List<DynamicPriceRecord> allPrices() {
        return pricingService.getAllComputedPrices();
    }
}
