package com.example.demo.service;

import com.example.demo.model.PricingRule;
import java.util.List;

public interface PricingRuleService {
    PricingRule addRule(PricingRule rule);
    List<PricingRule> getAllRules();
}
