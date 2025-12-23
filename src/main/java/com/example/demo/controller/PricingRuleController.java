package com.example.demo.controller;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing-rules")
public class PricingRuleController {

    private final PricingRuleService pricingRuleService;

    public PricingRuleController(PricingRuleService pricingRuleService) {
        this.pricingRuleService = pricingRuleService;
    }

    @PostMapping
    public PricingRule addRule(@RequestBody PricingRule rule) {
        return pricingRuleService.addRule(rule);
    }

    @GetMapping
    public List<PricingRule> getAllRules() {
        return pricingRuleService.getAllRules();
    }
}
