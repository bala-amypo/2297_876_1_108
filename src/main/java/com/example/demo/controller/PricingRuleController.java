package com.example.demo.controller;

import com.example.demo.service.PricingRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricing-rules")
public class PricingRuleController {

    private final PricingRuleService pricingRuleService;

    // ✅ CORRECT constructor
    public PricingRuleController(PricingRuleService pricingRuleService) {
        this.pricingRuleService = pricingRuleService;
    }
}

