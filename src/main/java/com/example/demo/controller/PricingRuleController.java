package com.example.demo.controller;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-rules")
public class PricingRuleController {

    private final PricingRuleService pricingRuleService;

    public PricingRuleController(PricingRuleService pricingRuleService) {
        this.pricingRuleService = pricingRuleService;
    }

    // 1️⃣ POST /api/pricing-rules
    @PostMapping
    public PricingRule createRule(@RequestBody PricingRule rule) {
        return pricingRuleService.createRule(rule);
    }

    // 2️⃣ PUT /api/pricing-rules/{id}
    @PutMapping("/{id}")
    public PricingRule updateRule(
            @PathVariable Long id,
            @RequestBody PricingRule rule
    ) {
        return pricingRuleService.updateRule(id, rule);
    }

    // 3️⃣ GET /api/pricing-rules/active
    @GetMapping("/active")
    public List<PricingRule> getActiveRules() {
        return pricingRuleService.getActiveRules();
    }

    // 4️⃣ GET /api/pricing-rules/{id}
    @GetMapping("/{id}")
    public PricingRule getRuleById(@PathVariable Long id) {
        return pricingRuleService.getRuleById(id);
    }

    // 5️⃣ GET /api/pricing-rules
    @GetMapping
    public List<PricingRule> getAllRules() {
        return pricingRuleService.getAllRules();
    }
}
