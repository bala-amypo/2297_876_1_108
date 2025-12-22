package com.example.demo.controller;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pricing-rules")
@Tag(name = "Pricing Rules Management")
public class PricingRuleController {

    private final PricingRuleService ruleService;

    public PricingRuleController(PricingRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public PricingRule createRule(@RequestBody PricingRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public PricingRule updateRule(
            @PathVariable Long id,
            @RequestBody PricingRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<PricingRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/{code}")
    public Optional<PricingRule> getRuleByCode(
            @PathVariable String code) {
        return ruleService.getRuleByCode(code);
    }

    @GetMapping
    public List<PricingRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
