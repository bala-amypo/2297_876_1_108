package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import org.springframework.stereotype.Service;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    @Override
    public PricingRule addRule(PricingRule rule) {
        // Add logic to save the rule in repository or return saved entity
        return rule;
    }
}
